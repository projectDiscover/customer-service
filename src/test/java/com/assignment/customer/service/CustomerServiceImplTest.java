package com.assignment.customer.service;

import com.assignment.customer.persistence.entity.CustomerEntity;
import com.assignment.customer.persistence.repository.CustomerRepository;
import com.assignment.customer.util.TestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Service layer test class. Only one sample test case is written. There will be many test cases for happy path and failure path.
 */
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerService =new CustomerServiceImpl(customerRepository);
    }

    @Test
    void saveCustomer_happy_path() {
        CustomerEntity customerEntity = TestBuilder.getCustomerEntity(TestBuilder.buildCustomerRequestBeanMandatoryFields());
        when(customerRepository.saveAndFlush(any(CustomerEntity.class))).thenReturn(customerEntity);
        boolean isSuccess = customerService.saveCustomer(TestBuilder.buildCustomerRequestBeanMandatoryFields());
        assertTrue(isSuccess);
        verify(customerRepository, times(1)).saveAndFlush(any(CustomerEntity.class));
    }

   /* @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void getCustomerRecord() {
    }*/
}