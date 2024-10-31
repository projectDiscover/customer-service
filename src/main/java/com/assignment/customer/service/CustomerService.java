package com.assignment.customer.service;

import com.assignment.customer.model.bean.request.CustomerRequestBean;
import com.assignment.customer.model.bean.response.CustomerDataBean;

public interface CustomerService {
    boolean saveCustomer(CustomerRequestBean customerRequestBean);

    boolean updateCustomer(CustomerRequestBean customerRequestBean);

    boolean deleteCustomer(long customerId);

    CustomerDataBean getCustomerRecord(long customerId);

}
