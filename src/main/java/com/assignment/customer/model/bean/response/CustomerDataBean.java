package com.assignment.customer.model.bean.response;

import lombok.Value;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Value
public class CustomerDataBean {
     long customerId;
     String firstName;
     String middleName;
     String lastName;
     String email;
     String phoneNumber;
}
