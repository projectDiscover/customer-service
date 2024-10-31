package com.assignment.customer.persistence.repository;

import com.assignment.customer.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
