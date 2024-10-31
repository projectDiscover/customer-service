package com.assignment.customer.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessageConstants {
    public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String CUSTOMER_ALREADY_EXISTS = "Customer already exists";
    public static final String CUSTOMER_ALREADY_DELETED = "Customer already deleted";
    public static final String CUSTOMER_ALREADY_UPDATED = "Customer already updated";
    public static final String CUSTOMER_ID_REQUIRED = "Id is required.";
    public static final String FIRST_NAME_REQUIRED = "First Name is required.";
    public static final String LAST_NAME_REQUIRED = "Last Name is required.";
    public static final String EMAIL_REQUIRED = "Email is required.";
    public static final String PHONE_NUMBER_REQUIRED = "Phone Number is required.";
    public static final String  VALIDATION_FAILED = "Validation Failed";
    public static final String  DB_ACCESS_ERROR = "DB Access Error";

}
