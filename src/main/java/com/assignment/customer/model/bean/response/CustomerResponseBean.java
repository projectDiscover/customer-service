package com.assignment.customer.model.bean.response;

import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Value
public class CustomerResponseBean {
    String operationStatus;
    String operationMessage;
    List<ErrorResponseBean> errors;
}
