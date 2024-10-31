package com.assignment.customer.annotation.swagger;

import com.assignment.customer.model.bean.request.CustomerCreationRequestBean;
import com.assignment.customer.model.bean.response.CustomerResponseBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Operation(method = "POST", summary = "This method creates a new customer, if it is a new customer. It sends a " +
        "duplicate error code for existing customer.")
@RequestBody(required = true, content = {@Content(
        schema = @Schema(implementation = CustomerCreationRequestBean.class),
        mediaType = MediaType.APPLICATION_JSON_VALUE,
        examples = @ExampleObject(
                name = "Create/Update Customer record.",
                description = "Create/Modify Customer Data.",
                value = """
                        {
                            "firstName":"firstName",
                            "middleName":"",
                            "lastName":"lastName",
                            "email":"email@gmail.com",
                            "phoneNumber":"5b0a20207b0a202020202274797065223a20224d6f62696c65222c0a202020202270686f6e654e756d626572223a20223836302d3030302d30303030222c0a2020202022657874656e73696f6e223a2022220a20207d0a5d"
                        }
                        """
            )
        )
    }
)
@ApiResponses(value = {
        @ApiResponse(
                description = "OK",
                responseCode = "200",
                headers = {
                        @Header(name = "responseId",
                                description = "Unique response identifier, which is the value of requestId",
                                required = true,
                                example = "5555-abcf-67ad"
                        )
                        //Custom security headers and any other headers
                },
                content = {
                        @Content(
                                mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = CustomerResponseBean.class),
                                examples = {@ExampleObject(
                                        name = "Customer creation successful",
                                        value = """
                                                {
                                                    "operationStatus":"SUCCESS",
                                                    "operationMessage":"Successfully persisted customer",
                                                    "errors": []
                                                }
                                                """
                                )}
                        )
                }
        ),
        @ApiResponse(
                description = "User error",
                responseCode = "4xx",
                headers = {
                        @Header(name = "responseId",
                                description = "Unique response identifier, which is the value of requestId",
                                required = true,
                                example = "5555-abcf-67ad"
                        )
                        //Custom security headers and any other headers
                },
                content = {
                        @Content(
                                mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = CustomerResponseBean.class),
                                examples = {@ExampleObject(
                                        name = "User Error",
                                        value = """
                                                {
                                                    "operationStatus":"FAILED",
                                                    "operationMessage":"Validation Failed",
                                                    "errors": [
                                                        {
                                                            "fieldName":"First Name",
                                                            "errorMessage":"First Name is required."
                                                        }
                                                    ]
                                                }
                                                """
                                )}
                        )
                }
        ),
        @ApiResponse(
                description = "System error",
                responseCode = "5xx",
                headers = {
                        @Header(name = "responseId",
                                description = "Unique response identifier, which is the value of requestId",
                                required = true,
                                example = "5555-abcf-67ad"
                        )
                        //Custom security headers and any other headers
                },
                content = {
                        @Content(
                                mediaType = MediaType.APPLICATION_JSON_VALUE,
                                schema = @Schema(implementation = CustomerResponseBean.class),
                                examples = {@ExampleObject(
                                        name = "Internal Server Error",
                                        value = """
                                                  {
                                                    "operationStatus":"FAILED",
                                                    "operationMessage":"DB Access Error",
                                                    "errors": []
                                                  }
                                                """
                                )}
                        )
                }
        )
})
public @interface CreateCustomerApiSwaggerDoc {
}
