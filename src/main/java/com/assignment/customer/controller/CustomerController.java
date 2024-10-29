package com.assignment.customer.controller;

import com.assignment.customer.annotation.swagger.CreateUpdCustomerApiSwaggerDoc;
import com.assignment.customer.model.bean.request.CustomerRequestBean;
import com.assignment.customer.model.bean.response.CustomerResponseBean;
import com.assignment.customer.service.CustomerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.assignment.customer.constants.CustomerServiceConstants.CUSTOMER_PERSISTENCE_SUCCESSFUL;
import static com.assignment.customer.constants.CustomerServiceConstants.SUCCESS;

@RestController
@RequestMapping(value = "/customer-service/v1/")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(value = "/create-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CreateUpdCustomerApiSwaggerDoc
    public ResponseEntity<CustomerResponseBean> createUserRecord(@RequestBody @Validated @NonNull final CustomerRequestBean customerRequestBean) {
        boolean isPersistenceSuccess = customerService.saveCustomer(customerRequestBean);
        log.atInfo().log("Customer Creation Status: {}", isPersistenceSuccess);
        return ResponseEntity.ok().body(CustomerResponseBean.builder().operationStatus(SUCCESS)
                .operationMessage(CUSTOMER_PERSISTENCE_SUCCESSFUL).build());
    }

}
