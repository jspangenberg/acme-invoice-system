ACME Invoice System
===================

Software requirements
=====================

    - Maven 3.x
    - JDK 1.7+

Running the application
=======================
You can run the application using

    mvn spring-boot:run

Or you can build the JAR file with

    mvn clean package

and run the JAR by typing:

    java -jar target/invoice-0.1.0.jar

Using the REST API
==================

Getting all invoices

    GET: http://localhost:8080/sysapi/v1/invoices

Getting all invoices for a customer:

    GET: http://localhost:8080/sysapi/v1/invoices?customerId=1

Getting all invoices for a customer for a certain address and for a particular month
(May in this example):

    GET: http://localhost:8080/sysapi/v1/invoices?customerId=1&addressId=1&month=5

Creating a new invoice (not tested yet)

    POST: http://localhost:8080/sysapi/v1/invoices/create


TO-DOs (enhancements for upcoming releases)
===========================================

    - Add Integration tests for REST controller
    - Input validation
    - Improved exception handling and logging

