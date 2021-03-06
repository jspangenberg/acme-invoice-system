package com.acme.invoice.controller;

import com.acme.invoice.dto.InvoiceDTO;
import com.acme.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John Spangenberg
 */
@RestController
public class InvoiceController {

    @Autowired
    com.acme.invoice.service.InvoiceService invoiceService;

    /**
     *
     * @param customerId
     * @param addressId
     * @param month
     * @param filter
     * @return
     */
    @RequestMapping(value="sysapi/v1/invoices", method=RequestMethod.GET)
    public List<InvoiceDTO> invoices(@RequestParam(value="customerId", required=false) Long customerId,
                                     @RequestParam(value="addressId", required=false) Long addressId,
                                     @RequestParam(value="month", required=false) Integer month,
                                     @RequestParam(value="filter", required=false) String filter) {

        List<InvoiceDTO> invoiceDTOs = new ArrayList<InvoiceDTO>();


        if (allInvoicesOrByCustomerId(addressId, month, filter)) {
            if (customerId != null && customerId > 0) {
                invoiceDTOs = invoiceService.getInvoices(customerId);
            } else {
                invoiceDTOs = invoiceService.getInvoices();
            }
        } else {
            if (filter == null || filter.equalsIgnoreCase("shop")) {
                invoiceDTOs = invoiceService.getInvoices(customerId, addressId, month);
            }
        }
        return invoiceDTOs;
    }

    /**
     *
     * @param invoice
     * @return
     */
    @RequestMapping(value="sysapi/v1/invoice", method=RequestMethod.POST)
    public List<InvoiceDTO> create(@RequestBody InvoiceDTO invoice) {
        return invoiceService.create(invoice);
    }

    private boolean allInvoicesOrByCustomerId(Long addressId, Integer month, String filter) {
        return addressId == null && month == null && filter == null;
    }


}
