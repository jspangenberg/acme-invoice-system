package com.acme.invoice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John Spangenberg
 */
@Entity
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="CUST_ID")
    private List<Address> addresses;

    /**
     * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is
     * designated as protected.
     */
    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}