package com.assignment.customer.service;

import com.assignment.customer.model.bean.request.CustomerRequestBean;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public boolean saveCustomer(CustomerRequestBean customerRequestBean) {
        return true;
    }
}
