ACME Invoice System
===================
The ACME Invoice System provides a REST API for retrieval of customer invoices.
Invoice data is persisted in a relational database system and mapped to Entity classes
using JPA. Via Service and Repository classes (and interfaces), a REST controller
has access to invoice data.
The application uses Spring Boot, which makes it easy to create stand-alone,
production-grade Spring based Applications that you can "just run".

The physical relational data model consistens of three tables. CUSTOMER has a ONE-TO-MANY
relation with ADDRESS. ADDRESS has a ONE-TO-MANY relation with invoice:

    CUSTOMER --< ADDRESS --< INVOICE

The db script can be found in:

    acme-invoice-system/src/main/resources/db/migration/V1__init.sql

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
Examples:

Getting all invoices

    GET: http://localhost:8080/sysapi/v1/invoices

Getting all invoices for a customer:

    GET: http://localhost:8080/sysapi/v1/invoices?customerId=1

Getting all invoices for a customer for a certain address and for a particular month
(May in this example):

    GET: http://localhost:8080/sysapi/v1/invoices?customerId=1&addressId=1&month=5
    GET: http://localhost:8080/sysapi/v1/invoices?customerId=1&addressId=1&month=5&filter=shop

Creating a new invoice (not tested yet)

    POST: http://localhost:8080/sysapi/v1/invoices/create


TO-DOs (enhancements for upcoming releases)
===========================================

    - Add Integration tests for REST controller
    - Input validation
    - Improved exception handling and logging
    - Business rules?

