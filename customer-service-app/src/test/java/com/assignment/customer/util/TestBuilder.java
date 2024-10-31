package com.assignment.customer.util;


import com.assignment.customer.model.bean.request.CustomerCreationRequestBean;
import com.assignment.customer.persistence.entity.CustomerEntity;

public class TestBuilder {
    private TestBuilder(){
        //Empty constructor
    }

    public static CustomerCreationRequestBean buildCustomerRequestBeanMandatoryFields(){
        CustomerCreationRequestBean customerCreationRequestBean = new CustomerCreationRequestBean();
        customerCreationRequestBean.setFirstName("First Name");
        customerCreationRequestBean.setLastName("Last Name");
        customerCreationRequestBean.setEmail("email@email.com");
        customerCreationRequestBean.setPhoneNumber("1234567890");
        return customerCreationRequestBean;
    }

    public static  CustomerEntity getCustomerEntity(CustomerCreationRequestBean customerCreationRequestBean) {
        return CustomerEntity.builder()
                .firstName(customerCreationRequestBean.getFirstName())
                .middleName(customerCreationRequestBean.getMiddleName())
                .lastName(customerCreationRequestBean.getLastName())
                .email(customerCreationRequestBean.getEmail())
                .phoneNumber(customerCreationRequestBean.getPhoneNumber())
                .build();
    }
}
