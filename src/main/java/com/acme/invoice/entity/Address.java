package com.acme.invoice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John Spangenberg
 */
@Entity
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String streetName;
    private int streetNr;
    private String streetExtension;
    private String zipCode;
    private String city;
    private String country;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="ADDR_ID")
    private List<Invoice> invoices;

    /**
     * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is
     * designated as protected.
     */
    protected Address() {}

    public Address(String streetName, int streetNr, String streetExtension, String zipCode, String city, String country) {
        this.streetName = streetName;
        this.streetNr = streetNr;
        this.streetExtension = streetExtension;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNr() {
        return streetNr;
    }

    public String getStreetExtension() {
        return streetExtension;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}