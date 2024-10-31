package com.assignment.customer.service;

import com.assignment.customer.model.bean.request.CustomerCreationRequestBean;
import com.assignment.customer.model.bean.request.CustomerUpdateRequestBean;
import com.assignment.customer.model.bean.response.CustomerDataBean;

public interface CustomerService {
    boolean saveCustomer(CustomerCreationRequestBean customerCreationRequestBean);

    boolean updateCustomer(CustomerUpdateRequestBean customerCreationRequestBean);

    boolean deleteCustomer(long customerId);

    CustomerDataBean getCustomerRecord(long customerId);

}
