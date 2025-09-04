package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentalTest {

    private static final Integer rentalid = 10;

    private static final java.time.LocalDateTime rentaldate = LocalDateTime.of(2023, 2, 2, 10, 30, 0);

    private static final Integer inventoryid = 30;

    private static final Integer customerid = 40;

    private static final java.time.LocalDateTime returndate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    private static final Integer staffid = 60;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 7, 7, 10, 30, 0);

    private static final Customer customer = null;

    private static final Inventory inventory = null;

    private static final Staff staff = null;

    private static final List<Payment> payments = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Rental record = new Rental(rentalid, rentaldate, inventoryid, customerid, returndate, staffid, lastupdate, customer, inventory, staff, payments);
        assertNotNull(record);
        assertEquals(rentalid, record.rentalID());
        assertEquals(rentaldate, record.rentalDate());
        assertEquals(inventoryid, record.inventoryID());
        assertEquals(customerid, record.customerID());
        assertEquals(returndate, record.returnDate());
        assertEquals(staffid, record.staffID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(customer, record.customer());
        assertEquals(inventory, record.inventory());
        assertEquals(staff, record.staff());
        assertEquals(payments, record.payments());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Rental record = new Rental.Builder().rentalID(rentalid).rentalDate(rentaldate).inventoryID(inventoryid).customerID(customerid).returnDate(returndate).staffID(staffid).lastUpdate(lastupdate).customer(customer).inventory(inventory).staff(staff).payments(payments).build();
        assertNotNull(record);
        assertEquals(rentalid, record.rentalID());
        assertEquals(rentaldate, record.rentalDate());
        assertEquals(inventoryid, record.inventoryID());
        assertEquals(customerid, record.customerID());
        assertEquals(returndate, record.returnDate());
        assertEquals(staffid, record.staffID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(customer, record.customer());
        assertEquals(inventory, record.inventory());
        assertEquals(staff, record.staff());
        assertEquals(payments, record.payments());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Rental record1 = new Rental(rentalid, rentaldate, inventoryid, customerid, returndate, staffid, lastupdate, customer, inventory, staff, payments);
        Rental record2 = new Rental(rentalid, rentaldate, inventoryid, customerid, returndate, staffid, lastupdate, customer, inventory, staff, payments);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Rental record = new Rental(rentalid, rentaldate, inventoryid, customerid, returndate, staffid, lastupdate, customer, inventory, staff, payments);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Rental"));
    }
}
