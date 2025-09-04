package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StaffTest {

    private static final Integer staffid = 10;

    private static final String firstname = "Test Name 2";

    private static final String lastname = "Test Name 3";

    private static final Integer addressid = 40;

    private static final String email = "test5@example.com";

    private static final Integer storeid = 60;

    private static final String active = "TestValue7";

    private static final String username = "Test Name 8";

    private static final String password = "TestValue9";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 10, 10, 10, 30, 0);

    private static final String picture = "TestValue11";

    private static final Address address = null;

    private static final Store store = null;

    private static final List<Payment> payments = new ArrayList<>();

    private static final List<Rental> rentals = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Staff record = new Staff(staffid, firstname, lastname, addressid, email, storeid, active, username, password, lastupdate, picture, address, store, payments, rentals);
        assertNotNull(record);
        assertEquals(staffid, record.staffID());
        assertEquals(firstname, record.firstName());
        assertEquals(lastname, record.lastName());
        assertEquals(addressid, record.addressID());
        assertEquals(email, record.email());
        assertEquals(storeid, record.storeID());
        assertEquals(active, record.active());
        assertEquals(username, record.username());
        assertEquals(password, record.password());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(picture, record.picture());
        assertEquals(address, record.address());
        assertEquals(store, record.store());
        assertEquals(payments, record.payments());
        assertEquals(rentals, record.rentals());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Staff record = new Staff.Builder().staffID(staffid).firstName(firstname).lastName(lastname).addressID(addressid).email(email).storeID(storeid).active(active).username(username).password(password).lastUpdate(lastupdate).picture(picture).address(address).store(store).payments(payments).rentals(rentals).build();
        assertNotNull(record);
        assertEquals(staffid, record.staffID());
        assertEquals(firstname, record.firstName());
        assertEquals(lastname, record.lastName());
        assertEquals(addressid, record.addressID());
        assertEquals(email, record.email());
        assertEquals(storeid, record.storeID());
        assertEquals(active, record.active());
        assertEquals(username, record.username());
        assertEquals(password, record.password());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(picture, record.picture());
        assertEquals(address, record.address());
        assertEquals(store, record.store());
        assertEquals(payments, record.payments());
        assertEquals(rentals, record.rentals());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Staff record1 = new Staff(staffid, firstname, lastname, addressid, email, storeid, active, username, password, lastupdate, picture, address, store, payments, rentals);
        Staff record2 = new Staff(staffid, firstname, lastname, addressid, email, storeid, active, username, password, lastupdate, picture, address, store, payments, rentals);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Staff record = new Staff(staffid, firstname, lastname, addressid, email, storeid, active, username, password, lastupdate, picture, address, store, payments, rentals);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Staff"));
    }
}
