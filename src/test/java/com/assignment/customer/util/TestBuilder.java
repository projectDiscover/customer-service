package com.assignment.customer.util;


import com.assignment.customer.model.bean.request.CustomerRequestBean;
import com.assignment.customer.persistence.entity.CustomerEntity;

public class TestBuilder {
    private TestBuilder(){
        //Empty constructor
    }

    public static CustomerRequestBean buildCustomerRequestBeanMandatoryFields(){
        CustomerRequestBean customerRequestBean = new CustomerRequestBean();
        customerRequestBean.setFirstName("First Name");
        customerRequestBean.setLastName("Last Name");
        customerRequestBean.setEmail("email@email.com");
        customerRequestBean.setPhoneNumber("1234567890");
        return customerRequestBean;
    }

    public static  CustomerEntity getCustomerEntity(CustomerRequestBean customerRequestBean) {
        return CustomerEntity.builder()
                .firstName(customerRequestBean.getFirstName())
                .middleName(customerRequestBean.getMiddleName())
                .lastName(customerRequestBean.getLastName())
                .email(customerRequestBean.getEmail())
                .phoneNumber(customerRequestBean.getPhoneNumber())
                .build();
    }
}
