package com.assignment.customer.service;

import com.assignment.customer.model.bean.request.CustomerRequestBean;

public interface CustomerService {
    boolean saveCustomer(CustomerRequestBean customerRequestBean);
}
