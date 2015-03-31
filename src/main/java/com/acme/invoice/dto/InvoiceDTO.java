package com.acme.invoice.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author John Spangenberg
 */
public class InvoiceDTO implements Serializable {

    public Long customerId;
    public Long addressId;
    public Long invoiceId;
    public String invoiceType;
    public Date invoiceDate;
    public Date paymentDueDate;
    public Long invoiceNumber;
    public Date startDate;
    public Date endDate;
    public double amount;
    public double vatAmount;
    public double totalAmount;


    public InvoiceDTO() {}


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getTotalAmount() {
        return vatAmount + amount;
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "customerId=" + customerId +
                ", addressId=" + addressId +
                ", invoiceId=" + invoiceId +
                ", invoiceType='" + invoiceType + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", paymentDueDate=" + paymentDueDate +
                ", invoiceNumber=" + invoiceNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", vatAmount=" + vatAmount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

