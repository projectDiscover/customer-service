package com.assignment.customer.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Entity(name = "Customer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Middle_Name", nullable = true)
    private String middleName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Column(name = "Email_Address", nullable = false, unique = true)
    private String email;

    // Since this field may contains composite value, it is more efficient to store this data in DB in a JSONB datatype
    // column. Strong it as String for simplicity, but need to parse it everytime for processing which has performance cost.
    @Column(name = "Phone_Number", nullable = false)
    private String phoneNumber;

}
