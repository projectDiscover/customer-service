package com.assignment.customer.model.bean.request;

import com.assignment.customer.constants.ErrorMessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CustomerRequestBean {
    @Null
    private String customerId;
    @NotBlank(message = ErrorMessageConstants.FIRST_NAME_REQUIRED)
    private String firstName;
    @Null
    private String middleName;
    @NotBlank(message = ErrorMessageConstants.LAST_NAME_REQUIRED)
    private String lastName;
    @NotBlank(message = ErrorMessageConstants.EMAIL_REQUIRED)
    private String email;
    @NotBlank(message = ErrorMessageConstants.PHONE_NUMBER_REQUIRED)
    private String phoneNumber;
}
