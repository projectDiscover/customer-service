package com.assignment.customer.controller;

import com.assignment.customer.annotation.swagger.CreateCustomerApiSwaggerDoc;
import com.assignment.customer.model.bean.request.CustomerCreationRequestBean;
import com.assignment.customer.model.bean.request.CustomerUpdateRequestBean;
import com.assignment.customer.model.bean.response.CustomerDataBean;
import com.assignment.customer.model.bean.response.CustomerDataResponseBean;
import com.assignment.customer.model.bean.response.CustomerResponseBean;
import com.assignment.customer.service.CustomerService;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.assignment.customer.constants.CustomerServiceConstants.*;

@RestController
@RequestMapping(value = "/customer-service/v1/")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(value = "/create-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CreateCustomerApiSwaggerDoc
    public ResponseEntity<CustomerResponseBean> createUserRecord(@RequestBody @Validated @NonNull final CustomerCreationRequestBean customerCreationRequestBean) {
        boolean isPersistenceSuccess = customerService.saveCustomer(customerCreationRequestBean);
        log.atInfo().log("Customer Creation Status: {}", isPersistenceSuccess);
        return ResponseEntity.ok().body(CustomerResponseBean.builder().operationStatus(SUCCESS)
                .operationMessage(CUSTOMER_PERSISTENCE_SUCCESSFUL).build());
    }

    /**
     * Perform JSON Schema validation as pre-requisite, to make sure there is always customerId present in the
     * request data object along with other data fields. Then update the DB.
     *
     * @param customerCreationRequestBean  Customer data bean.
     * @return Bean containing operation status and message.
     */
    @PutMapping(value = "/update-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponseBean> updateUserRecord(@RequestBody @Validated @NonNull final CustomerUpdateRequestBean customerCreationRequestBean) {
        boolean isPersistenceSuccess = customerService.updateCustomer(customerCreationRequestBean);
        log.atInfo().log("Customer record update Status: {}", isPersistenceSuccess);
        return ResponseEntity.ok().body(CustomerResponseBean.builder().operationStatus(SUCCESS)
                .operationMessage(CUSTOMER_PERSISTENCE_SUCCESSFUL).build());
    }


    @DeleteMapping(value = "/delete-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponseBean> deleteCustomerRecord(@PathVariable(value = "customerId") @NotBlank String customerId) {
        boolean isDeleted = customerService.deleteCustomer(Integer.parseInt(customerId));
        log.atInfo().log("Customer record deletion Status: {}", isDeleted);
        return ResponseEntity.ok().body(CustomerResponseBean.builder().operationStatus(SUCCESS)
                .operationMessage(CUSTOMER_DELETION_SUCCESSFUL).build());
    }

    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<CustomerDataResponseBean> fetchCustomerRecord(@PathVariable(value = "customerId") @NotBlank String customerId) {
        CustomerDataBean customerDataBean = customerService.getCustomerRecord(Integer.parseInt(customerId));
        log.atInfo().log("Customer record selection Status: {}", ObjectUtils.isEmpty(customerDataBean));
        return ResponseEntity.ok().body(CustomerDataResponseBean.builder().customerDataBean(customerDataBean).build());
    }

}
