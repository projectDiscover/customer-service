package com.assignment.customer.service;

import com.assignment.customer.model.bean.request.CustomerCreationRequestBean;
import com.assignment.customer.model.bean.request.CustomerUpdateRequestBean;
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
    public boolean saveCustomer(CustomerCreationRequestBean customerCreationRequestBean) {
        CustomerEntity customerEntity = customerRepository.saveAndFlush(getCustomerEntity(customerCreationRequestBean));
        log.info("Customer saved successfully: {}", customerEntity);
        return ObjectUtils.isNotEmpty(customerEntity);
    }

    /**
     * JSON Schema validation will ensure that request data is fully populated. Then update.
     *
     * @param customerUpdateRequestBean customerEntity = teRequestBean Customer Data
     * @return Update status.
     */
    @Override
    public boolean updateCustomer(CustomerUpdateRequestBean customerUpdateRequestBean) {
        Optional<CustomerEntity> customerEntityOp = customerRepository.findById(Long.parseLong(customerUpdateRequestBean.getCustomerId()));
        if(customerEntityOp.isPresent()){
            CustomerEntity customerEntity = customerRepository.saveAndFlush(getCustomerUpdEntity(customerUpdateRequestBean));
            log.info("Customer Data updated successfully: {}", customerEntity);
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
     * @param customerCreationRequestBean Customer Data
     * @return Customer Entity
     */
    private CustomerEntity getCustomerEntity(CustomerCreationRequestBean customerCreationRequestBean) {
        return CustomerEntity.builder()
                .firstName(customerCreationRequestBean.getFirstName())
                .middleName(customerCreationRequestBean.getMiddleName())
                .lastName(customerCreationRequestBean.getLastName())
                .email(customerCreationRequestBean.getEmail())
                .phoneNumber(customerCreationRequestBean.getPhoneNumber())
                .build();
    }

    /**
     * This method is performing Bean conversion. It is a perfect use case of MapStruct library
     * @param customerUpdateRequestBean Customer Data
     * @return Customer Entity
     */
    private CustomerEntity getCustomerUpdEntity(CustomerUpdateRequestBean customerUpdateRequestBean) {
        return CustomerEntity.builder()
                .firstName(customerUpdateRequestBean.getFirstName())
                .middleName(customerUpdateRequestBean.getMiddleName())
                .lastName(customerUpdateRequestBean.getLastName())
                .email(customerUpdateRequestBean.getEmail())
                .phoneNumber(customerUpdateRequestBean.getPhoneNumber())
                .build();
    }
}
