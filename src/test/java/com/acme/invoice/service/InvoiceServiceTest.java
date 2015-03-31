package com.acme.invoice.service;

import com.acme.invoice.TestConfig;
import com.acme.invoice.AbstractIntegrationTest;
import com.acme.invoice.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author John Spangenberg
 */
@ContextConfiguration(classes = TestConfig.class)
public class InvoiceServiceTest extends AbstractIntegrationTest {

    @Autowired
    InvoiceService invoiceService;


    @org.junit.Test
    public void findInvoicesForCustomer() {
        List<InvoiceDTO> invoices = invoiceService.getInvoices(1L);
        assertEquals(2, invoices.size());
    }

    @org.junit.Test
    public void findAllInvoices() {
        List<InvoiceDTO> invoices = invoiceService.getInvoices();
        assertEquals(4, invoices.size());
    }

    @org.junit.Test
    public void findInvoicesByCustomerAddressAndMonth() {
        List<InvoiceDTO> invoices = invoiceService.getInvoices(1L, 1L,5);
        assertEquals(2, invoices.size());
    }
}
