package com.acme.invoice.repository;

import static org.junit.Assert.assertEquals;

import com.acme.invoice.AbstractIntegrationTest;
import com.acme.invoice.entity.Address;
import com.acme.invoice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author John Spangenberg
 */
public class CustomerRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;

    @org.junit.Test
    public void findCustomerById() {
        Customer customer = customerRepository.findOne(1L);
        assertEquals(1,customer.getId());
    }

    @org.junit.Test
    public void findAddressesByCustomerId() {
        Customer customer = customerRepository.findOne(1L);
        List<Address> addresses = customer.getAddresses();
        assertEquals(1, addresses.size());
    }

    @org.junit.Test
    public void findInvoicesByCustomerId() {
        Customer customer1 = customerRepository.findOne(1L);
        List<Address> addresses1 = customer1.getAddresses();
        assertEquals(1, addresses1.size());
        assertEquals(2, addresses1.get(0).getInvoices().size());
        assertEquals(1, addresses1.get(0).getInvoices().get(0).getId());
        assertEquals(2, addresses1.get(0).getInvoices().get(1).getId());

        Customer customer2 = customerRepository.findOne(2L);
        List<Address> addresses2 = customer2.getAddresses();
        assertEquals(1, addresses2.size());
        assertEquals(2, addresses2.get(0).getInvoices().size());
        assertEquals(3, addresses2.get(0).getInvoices().get(0).getId());
        assertEquals(4, addresses2.get(0).getInvoices().get(1).getId());


    }

}
