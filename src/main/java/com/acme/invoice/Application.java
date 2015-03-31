package com.acme.invoice;

import com.acme.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author John Spangenberg
 */
@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    InvoiceService invoiceService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}