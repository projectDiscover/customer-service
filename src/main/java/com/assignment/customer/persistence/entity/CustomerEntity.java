package com.assignment.customer.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity(name = "Customer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Middle_Name", nullable = true)
    private String middleName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    // Since this field may contains composite value, it is more efficient to store this data in DB in a JSONB datatype
    // column. Strong it as String for simplicity, but need to parse it everytime for processing which has performance cost.
    //@JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

}
