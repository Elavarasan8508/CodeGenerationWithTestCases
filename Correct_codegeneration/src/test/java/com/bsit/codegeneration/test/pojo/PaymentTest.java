package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Payment;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Customer;
import com.bsit.codegeneration.pojo.Rental;
import com.bsit.codegeneration.pojo.Staff;

public class PaymentTest {

    private static final Integer paymentid = 10;

    private static final Integer customerid = 20;

    private static final Integer staffid = 30;

    private static final Integer rentalid = 40;

    private static final java.math.BigDecimal amount = new BigDecimal("54.95");

    private static final java.time.LocalDateTime paymentdate = LocalDateTime.of(2023, 6, 6, 10, 30, 0);

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 7, 7, 10, 30, 0);

    private static final Customer customer = new Customer();

    private static final Rental rental = new Rental();

    private static final Staff staff = new Staff();

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Payment obj = new Payment();
        assertNotNull(obj);
        assertNull(obj.getPaymentID());
        assertNull(obj.getCustomerID());
        assertNull(obj.getStaffID());
        assertNull(obj.getRentalID());
        assertNull(obj.getAmount());
        assertNull(obj.getPaymentDate());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCustomer());
        assertNull(obj.getRental());
        assertNull(obj.getStaff());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Payment obj = new Payment();
        obj.setPaymentID(paymentid);
        assertEquals(paymentid, obj.getPaymentID());
        obj.setCustomerID(customerid);
        assertEquals(customerid, obj.getCustomerID());
        obj.setStaffID(staffid);
        assertEquals(staffid, obj.getStaffID());
        obj.setRentalID(rentalid);
        assertEquals(rentalid, obj.getRentalID());
        obj.setAmount(amount);
        assertEquals(amount, obj.getAmount());
        obj.setPaymentDate(paymentdate);
        assertEquals(paymentdate, obj.getPaymentDate());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCustomer(customer);
        assertEquals(customer, obj.getCustomer());
        obj.setRental(rental);
        assertEquals(rental, obj.getRental());
        obj.setStaff(staff);
        assertEquals(staff, obj.getStaff());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Payment obj = new Payment(paymentid, customerid, staffid, rentalid, amount, paymentdate, lastupdate, customer, rental, staff);
        assertNotNull(obj);
        assertEquals(paymentid, obj.getPaymentID());
        assertEquals(customerid, obj.getCustomerID());
        assertEquals(staffid, obj.getStaffID());
        assertEquals(rentalid, obj.getRentalID());
        assertEquals(amount, obj.getAmount());
        assertEquals(paymentdate, obj.getPaymentDate());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(customer, obj.getCustomer());
        assertEquals(rental, obj.getRental());
        assertEquals(staff, obj.getStaff());
    }

    @Test()
    @DisplayName("Should set and get customer relationship correctly")
    public void testCustomerRelationship() {
        Payment obj = new Payment();
        Customer relatedObj = customer;
        obj.setCustomer(relatedObj);
        assertSame(relatedObj, obj.getCustomer());
    }

    @Test()
    @DisplayName("Should set and get rental relationship correctly")
    public void testRentalRelationship() {
        Payment obj = new Payment();
        Rental relatedObj = rental;
        obj.setRental(relatedObj);
        assertSame(relatedObj, obj.getRental());
    }

    @Test()
    @DisplayName("Should set and get staff relationship correctly")
    public void testStaffRelationship() {
        Payment obj = new Payment();
        Staff relatedObj = staff;
        obj.setStaff(relatedObj);
        assertSame(relatedObj, obj.getStaff());
    }
}
