package com.assignment.customer.advice;

import com.assignment.customer.constants.CustomerServiceConstants;
import com.assignment.customer.constants.ErrorMessageConstants;
import com.assignment.customer.exceptions.CustomerValidationException;
import com.assignment.customer.model.bean.response.CustomerResponseBean;
import com.assignment.customer.model.bean.response.ErrorResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class CustomerControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomerResponseBean handleValidationExceptions(MethodArgumentNotValidException argumentNotValidException) {
        log.error("MethodArgumentNotValidException: {}", argumentNotValidException);
        List<ErrorResponseBean> fieldErrors = argumentNotValidException.getFieldErrors().stream()
                .map(objectError -> ErrorResponseBean.builder()
                        .errorMessage(objectError.getDefaultMessage())
                        .fieldName(objectError.getField())
                        .build())
                .collect(Collectors.toUnmodifiableList());
        return CustomerResponseBean.builder()
                .operationStatus(CustomerServiceConstants.FAILED)
                .operationMessage(ErrorMessageConstants.VALIDATION_FAILED)
                .errors(fieldErrors)
                .build();
    }

    /**
     * Template method for handling JSON schema validation errors.
     * @param customerValidationException JSON schema validation errors.
     * @return error response bean.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerValidationException.class)
    public CustomerResponseBean handleValidationExceptions(CustomerValidationException customerValidationException) {
        log.error("CustomerValidationException: {}", customerValidationException);
        return CustomerResponseBean.builder()
                .operationStatus(CustomerServiceConstants.FAILED)
                .operationMessage(ErrorMessageConstants.VALIDATION_FAILED)
                //.errors(fieldErrors)
                .build();
    }


    /**
     * Template method for handling DataAccessException.
     * @param dataAccessException Spring DB operation exception
     * @return error response bean.
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataAccessException.class)
    public CustomerResponseBean handleVDataAccessException(DataAccessException dataAccessException) {
        log.error("DataAccessException: {}", dataAccessException);
        return CustomerResponseBean.builder()
                .operationStatus(CustomerServiceConstants.FAILED)
                .operationMessage(ErrorMessageConstants.DB_ACCESS_ERROR)
                //.errors(fieldErrors)
                .build();
    }

}
