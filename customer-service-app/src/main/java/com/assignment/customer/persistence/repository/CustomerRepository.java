package com.assignment.customer.persistence.repository;

import com.assignment.customer.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
