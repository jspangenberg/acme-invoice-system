package com.acme.invoice.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author John Spangenberg
 */
@Entity
public class Invoice {

    @Id
    @Column(name = "INVOICE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String invoiceType;

    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    @Temporal(TemporalType.DATE)
    private Date paymentDueDate;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private double amount;

    private double vatAmount;

    private Long invoiceNumber;



    /**
     * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is
     * designated as protected.
     */
    protected Invoice() {
    }

    public Invoice(String type, Date invoiceDate, Date paymentDueDate, Date startDate, Date endDate, double amount, double vatAmount, Long invoiceNumber) {
        this.invoiceType = type;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.paymentDueDate = paymentDueDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.vatAmount = vatAmount;
    }

    public long getId() {
        return id;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getAmount() {
        return amount;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }


}