package com.acme.invoice.repository;

import com.acme.invoice.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author John Spangenberg
 */
@Component("jdbcTemplateCustomerRepository")
public class JdbcTemplateCustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    private static final String QUERY = "select c.customer_id, a.address_id, i.invoice_id,i.invoice_type, i.invoice_date, i.payment_due_date, i.invoice_number, i.start_date, i.end_date, i.amount, i.vat_amount from customer c inner join address a on c.customer_id = a.cust_id inner join invoice i on i.addr_id = a.address_id where c.customer_id = ? and a.address_id = ? and MONTH(i.start_date) = ?";

    public List<InvoiceDTO> findInvoiceByCustomerAndAddress(Long customerId, Long addressId, Integer month) {
        List<InvoiceDTO> results = jdbcTemplate.query(
                QUERY, new Object[]{customerId, addressId, month},
                new RowMapper<InvoiceDTO>() {
                    @Override
                    public InvoiceDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        InvoiceDTO invoiceDTO = new InvoiceDTO();
                        invoiceDTO.setCustomerId(rs.getLong("customer_id"));
                        invoiceDTO.setAddressId(rs.getLong("address_id"));
                        invoiceDTO.setInvoiceId(rs.getLong("invoice_id"));
                        invoiceDTO.setInvoiceType(rs.getString("invoice_type"));
                        invoiceDTO.setInvoiceDate(rs.getDate("invoice_date"));
                        invoiceDTO.setPaymentDueDate(rs.getDate("payment_due_date"));
                        invoiceDTO.setInvoiceNumber(rs.getLong("invoice_number"));
                        invoiceDTO.setStartDate(rs.getDate("start_date"));
                        invoiceDTO.setEndDate(rs.getDate("end_date"));
                        invoiceDTO.setAmount(rs.getDouble("amount"));
                        invoiceDTO.setVatAmount(rs.getDouble("vat_amount"));
                        return invoiceDTO;
                    }
                });

        return results;

    }
}
