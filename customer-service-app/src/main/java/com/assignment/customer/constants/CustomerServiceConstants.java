package com.assignment.customer.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerServiceConstants {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String CUSTOMER_PERSISTENCE_SUCCESSFUL = "Successfully persisted customer.";
    public static final String CUSTOMER_DELETION_SUCCESSFUL = "Successfully deleted customer.";

}
