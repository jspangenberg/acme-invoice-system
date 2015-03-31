package com.acme.invoice.repository;

import com.acme.invoice.entity.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * @author John Spangenberg
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
