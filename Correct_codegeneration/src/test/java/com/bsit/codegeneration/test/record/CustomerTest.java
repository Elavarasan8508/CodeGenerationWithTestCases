package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private static final Integer customerid = 10;

    private static final Integer storeid = 20;

    private static final String firstname = "Test Name 3";

    private static final String lastname = "Test Name 4";

    private static final String email = "test5@example.com";

    private static final Integer addressid = 60;

    private static final String active = "TestValue7";

    private static final java.time.LocalDateTime createdate = LocalDateTime.of(2023, 8, 8, 10, 30, 0);

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 9, 9, 10, 30, 0);

    private static final Address address = null;

    private static final Store store = null;

    private static final List<Payment> payments = new ArrayList<>();

    private static final List<Rental> rentals = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Customer record = new Customer(customerid, storeid, firstname, lastname, email, addressid, active, createdate, lastupdate, address, store, payments, rentals);
        assertNotNull(record);
        assertEquals(customerid, record.customerID());
        assertEquals(storeid, record.storeID());
        assertEquals(firstname, record.firstName());
        assertEquals(lastname, record.lastName());
        assertEquals(email, record.email());
        assertEquals(addressid, record.addressID());
        assertEquals(active, record.active());
        assertEquals(createdate, record.createDate());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(address, record.address());
        assertEquals(store, record.store());
        assertEquals(payments, record.payments());
        assertEquals(rentals, record.rentals());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Customer record = new Customer.Builder().customerID(customerid).storeID(storeid).firstName(firstname).lastName(lastname).email(email).addressID(addressid).active(active).createDate(createdate).lastUpdate(lastupdate).address(address).store(store).payments(payments).rentals(rentals).build();
        assertNotNull(record);
        assertEquals(customerid, record.customerID());
        assertEquals(storeid, record.storeID());
        assertEquals(firstname, record.firstName());
        assertEquals(lastname, record.lastName());
        assertEquals(email, record.email());
        assertEquals(addressid, record.addressID());
        assertEquals(active, record.active());
        assertEquals(createdate, record.createDate());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(address, record.address());
        assertEquals(store, record.store());
        assertEquals(payments, record.payments());
        assertEquals(rentals, record.rentals());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Customer record1 = new Customer(customerid, storeid, firstname, lastname, email, addressid, active, createdate, lastupdate, address, store, payments, rentals);
        Customer record2 = new Customer(customerid, storeid, firstname, lastname, email, addressid, active, createdate, lastupdate, address, store, payments, rentals);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Customer record = new Customer(customerid, storeid, firstname, lastname, email, addressid, active, createdate, lastupdate, address, store, payments, rentals);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Customer"));
    }
}
