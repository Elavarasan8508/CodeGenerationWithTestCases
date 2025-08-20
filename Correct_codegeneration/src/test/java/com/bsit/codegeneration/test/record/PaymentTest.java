package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;

public class PaymentTest {

    private static final Integer paymentid = 10;

    private static final Integer customerid = 20;

    private static final Integer staffid = 30;

    private static final Integer rentalid = 40;

    private static final Long amount = 500L;

    private static final java.time.LocalDateTime paymentdate = LocalDateTime.of(2023, 6, 6, 10, 30, 0);

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 7, 7, 10, 30, 0);

    private static final Customer customer = null;

    private static final Rental rental = null;

    private static final Staff staff = null;

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Payment record = new Payment(paymentid, customerid, staffid, rentalid, amount, paymentdate, lastupdate, customer, rental, staff);
        assertNotNull(record);
        assertEquals(paymentid, record.paymentID());
        assertEquals(customerid, record.customerID());
        assertEquals(staffid, record.staffID());
        assertEquals(rentalid, record.rentalID());
        assertEquals(amount, record.amount());
        assertEquals(paymentdate, record.paymentDate());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(customer, record.customer());
        assertEquals(rental, record.rental());
        assertEquals(staff, record.staff());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Payment record = new Payment.Builder().paymentID(paymentid).customerID(customerid).staffID(staffid).rentalID(rentalid).amount(amount).paymentDate(paymentdate).lastUpdate(lastupdate).customer(customer).rental(rental).staff(staff).build();
        assertNotNull(record);
        assertEquals(paymentid, record.paymentID());
        assertEquals(customerid, record.customerID());
        assertEquals(staffid, record.staffID());
        assertEquals(rentalid, record.rentalID());
        assertEquals(amount, record.amount());
        assertEquals(paymentdate, record.paymentDate());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(customer, record.customer());
        assertEquals(rental, record.rental());
        assertEquals(staff, record.staff());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Payment record1 = new Payment(paymentid, customerid, staffid, rentalid, amount, paymentdate, lastupdate, customer, rental, staff);
        Payment record2 = new Payment(paymentid, customerid, staffid, rentalid, amount, paymentdate, lastupdate, customer, rental, staff);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Payment record = new Payment(paymentid, customerid, staffid, rentalid, amount, paymentdate, lastupdate, customer, rental, staff);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Payment"));
    }
}
