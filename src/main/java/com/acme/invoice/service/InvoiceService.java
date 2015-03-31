package com.acme.invoice.service;

import com.acme.invoice.dto.InvoiceDTO;
import com.acme.invoice.entity.Address;
import com.acme.invoice.entity.Customer;
import com.acme.invoice.entity.Invoice;
import com.acme.invoice.repository.CustomerRepository;
import com.acme.invoice.repository.JdbcTemplateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author John Spangenberg
 */
@Component("invoiceService")
public class InvoiceService  {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    JdbcTemplateCustomerRepository jdbcTemplateCustomerRepository;

    public List<InvoiceDTO> getInvoices(Long customerId) {
        List<InvoiceDTO> invoiceDTOs = new ArrayList<InvoiceDTO>();
        Customer customer = customerRepository.findOne(customerId);

        convert(invoiceDTOs, customer);
        return invoiceDTOs;
    }

    public List<InvoiceDTO> getInvoices() {
        List<InvoiceDTO> invoiceDTOs = new ArrayList<InvoiceDTO>();

        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer: customers) {
             convert(invoiceDTOs,customer);
        }

        return invoiceDTOs;
    }

    public List<InvoiceDTO> getInvoices(Long customerId, Long addressId, Integer month) {
        return jdbcTemplateCustomerRepository.findInvoiceByCustomerAndAddress(customerId, addressId, month);
    }

    private void convert(List<InvoiceDTO> invoiceDTOs, Customer customer) {
        if (customer != null) {


            List<Address> addresses = customer.getAddresses();

            for (Address address: addresses) {

                for (Invoice invoice: address.getInvoices()) {
                    InvoiceDTO invoiceDTO = new InvoiceDTO();
                    invoiceDTO.setCustomerId(customer.getId());
                    invoiceDTO.setAddressId(address.getId());

                    invoiceDTO.setInvoiceId(invoice.getId());
                    invoiceDTO.setInvoiceType(invoice.getInvoiceType());
                    invoiceDTO.setInvoiceDate(invoice.getInvoiceDate());
                    invoiceDTO.setPaymentDueDate(invoice.getPaymentDueDate());
                    invoiceDTO.setInvoiceNumber(invoice.getInvoiceNumber());
                    invoiceDTO.setStartDate(invoice.getStartDate());
                    invoiceDTO.setEndDate(invoice.getEndDate());
                    invoiceDTO.setAmount(invoice.getAmount());
                    invoiceDTO.setVatAmount(invoice.getVatAmount());
                    invoiceDTOs.add(invoiceDTO);
                }
            }
        }
    }
}