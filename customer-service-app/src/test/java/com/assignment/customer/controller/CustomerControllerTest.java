package com.assignment.customer.controller;

import com.assignment.customer.model.bean.request.CustomerCreationRequestBean;
import com.assignment.customer.model.bean.response.CustomerResponseBean;
import com.assignment.customer.service.CustomerService;
import com.assignment.customer.util.TestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static com.assignment.customer.constants.CustomerServiceConstants.SUCCESS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        customerController = new CustomerController(customerService);
    }

    @Test
    void given_createUserRecord_is_invoked_with_null_rec_then_throw_bad_request_error() {
        assertThrows(NullPointerException.class, () -> customerController.createUserRecord(null));
    }

    @Test
    void given_createUserRecord_is_invoked_with_full_payload_then_return_success_response() {
        when(customerService.saveCustomer(any(CustomerCreationRequestBean.class))).thenReturn(true);
        ResponseEntity<CustomerResponseBean> responseEntity = customerController.createUserRecord(TestBuilder.buildCustomerRequestBeanMandatoryFields());
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertEquals(SUCCESS, responseEntity.getBody().getOperationStatus());
    }

}