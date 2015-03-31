package com.acme.invoice.repository;

import com.acme.invoice.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author John Spangenberg
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

