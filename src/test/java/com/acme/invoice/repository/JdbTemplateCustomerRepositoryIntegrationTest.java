package com.acme.invoice.repository;

import com.acme.invoice.AbstractIntegrationTest;
import com.acme.invoice.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author John Spangenberg
 */
public class JdbTemplateCustomerRepositoryIntegrationTest extends AbstractIntegrationTest  {

    @Autowired
    JdbcTemplateCustomerRepository jdbcTemplateCustomerRepository;

    @org.junit.Test
    public void findCustomerById() {
        List<InvoiceDTO> invoices = jdbcTemplateCustomerRepository.findInvoicesByCustomerAndAddress(1L, 1L, 5);
        assertEquals(2,invoices.size());
    }

}