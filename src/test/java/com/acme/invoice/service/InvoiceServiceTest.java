package com.acme.invoice.service;

import com.acme.invoice.TestConfig;
import com.acme.invoice.AbstractIntegrationTest;
import com.acme.invoice.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
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

    @org.junit.Test
    public void createInvoice() {
        InvoiceDTO invoiceDTO = new InvoiceDTO();


        invoiceDTO.setCustomerId(1L);
        invoiceDTO.setAddressId(1L);
        invoiceDTO.setInvoiceDate(new Date());
        invoiceDTO.setInvoiceType("Test");
        invoiceDTO.setPaymentDueDate(new Date());
        invoiceDTO.setInvoiceNumber(213312L);
        invoiceDTO.setStartDate(new Date());
        invoiceDTO.setEndDate(new Date());
        invoiceDTO.setAmount(120.00);
        invoiceDTO.setVatAmount(12.00);



        invoiceService.create(invoiceDTO);

        List<InvoiceDTO> invoices = invoiceService.getInvoices(1L);
        assertEquals(3, invoices.size());
    }
}
