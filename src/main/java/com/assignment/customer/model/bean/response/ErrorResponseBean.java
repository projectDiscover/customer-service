package com.assignment.customer.model.bean.response;

import lombok.Value;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Value
public class ErrorResponseBean {
     String errorMessage;
     String fieldName;
}
