package com.assignment.customer.service;

import com.assignment.customer.model.bean.request.CustomerRequestBean;
import com.assignment.customer.model.bean.response.CustomerDataBean;
import com.assignment.customer.persistence.entity.CustomerEntity;
import com.assignment.customer.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public boolean saveCustomer(CustomerRequestBean customerRequestBean) {
        CustomerEntity customerEntity = customerRepository.saveAndFlush(getCustomerEntity(customerRequestBean));
        log.info("Customer saved successfully");
        return ObjectUtils.isNotEmpty(customerEntity);
    }

    /**
     * JSON Schema validation will ensure that request data is fully populated. Then update.
     *
     * @param customerRequestBean Customer Data
     * @return Update status.
     */
    @Override
    public boolean updateCustomer(CustomerRequestBean customerRequestBean) {
        Optional<CustomerEntity> customerEntityOp = customerRepository.findById(Long.parseLong(customerRequestBean.getCustomerId()));
        if(customerEntityOp.isPresent()){
            customerRepository.saveAndFlush(getCustomerEntity(customerRequestBean));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public CustomerDataBean getCustomerRecord(long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseGet(() -> CustomerEntity.builder().build());
        return  CustomerDataBean.builder()
                .customerId(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .middleName(customerEntity.getMiddleName())
                .lastName(customerEntity.getLastName())
                .email(customerEntity.getEmail())
                .phoneNumber(customerEntity.getPhoneNumber())
                .build();
    }

    /**
     * This method is performing Bean conversion. It is a perfect use case of MapStruct library
     * @param customerRequestBean Customer Data
     * @return Customer Entity
     */
    private CustomerEntity getCustomerEntity(CustomerRequestBean customerRequestBean) {
        return CustomerEntity.builder()
                .firstName(customerRequestBean.getFirstName())
                .middleName(customerRequestBean.getMiddleName())
                .lastName(customerRequestBean.getLastName())
                .email(customerRequestBean.getEmail())
                .phoneNumber(customerRequestBean.getPhoneNumber())
                .build();
    }
}
