package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Rental;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Customer;
import com.bsit.codegeneration.pojo.Inventory;
import com.bsit.codegeneration.pojo.Staff;
import com.bsit.codegeneration.pojo.Payment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentalTest {

    private static final Integer rentalid = 10;

    private static final java.time.LocalDateTime rentaldate = LocalDateTime.of(2023, 2, 2, 10, 30, 0);

    private static final Integer inventoryid = 30;

    private static final Integer customerid = 40;

    private static final java.time.LocalDateTime returndate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    private static final Integer staffid = 60;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 7, 7, 10, 30, 0);

    private static final Customer customer = new Customer();

    private static final Inventory inventory = new Inventory();

    private static final Staff staff = new Staff();

    private static final List<Payment> paymentlist = new ArrayList<>(Arrays.asList(new Payment()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Rental obj = new Rental();
        assertNotNull(obj);
        assertNull(obj.getRentalID());
        assertNull(obj.getRentalDate());
        assertNull(obj.getInventoryID());
        assertNull(obj.getCustomerID());
        assertNull(obj.getReturnDate());
        assertNull(obj.getStaffID());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCustomer());
        assertNull(obj.getInventory());
        assertNull(obj.getStaff());
        assertNull(obj.getPaymentList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Rental obj = new Rental();
        obj.setRentalID(rentalid);
        assertEquals(rentalid, obj.getRentalID());
        obj.setRentalDate(rentaldate);
        assertEquals(rentaldate, obj.getRentalDate());
        obj.setInventoryID(inventoryid);
        assertEquals(inventoryid, obj.getInventoryID());
        obj.setCustomerID(customerid);
        assertEquals(customerid, obj.getCustomerID());
        obj.setReturnDate(returndate);
        assertEquals(returndate, obj.getReturnDate());
        obj.setStaffID(staffid);
        assertEquals(staffid, obj.getStaffID());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCustomer(customer);
        assertEquals(customer, obj.getCustomer());
        obj.setInventory(inventory);
        assertEquals(inventory, obj.getInventory());
        obj.setStaff(staff);
        assertEquals(staff, obj.getStaff());
        obj.setPaymentList(paymentlist);
        assertEquals(paymentlist, obj.getPaymentList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Rental obj = new Rental(rentalid, rentaldate, inventoryid, customerid, returndate, staffid, lastupdate, customer, inventory, staff);
        assertNotNull(obj);
        assertEquals(rentalid, obj.getRentalID());
        assertEquals(rentaldate, obj.getRentalDate());
        assertEquals(inventoryid, obj.getInventoryID());
        assertEquals(customerid, obj.getCustomerID());
        assertEquals(returndate, obj.getReturnDate());
        assertEquals(staffid, obj.getStaffID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(customer, obj.getCustomer());
        assertEquals(inventory, obj.getInventory());
        assertEquals(staff, obj.getStaff());
        assertNull(obj.getPaymentList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Rental obj = new Rental.Builder().rentalID(rentalid).rentalDate(rentaldate).inventoryID(inventoryid).customerID(customerid).returnDate(returndate).staffID(staffid).lastUpdate(lastupdate).customer(customer).inventory(inventory).staff(staff).paymentList(paymentlist).build();
        assertNotNull(obj);
        assertEquals(rentalid, obj.getRentalID());
        assertEquals(rentaldate, obj.getRentalDate());
        assertEquals(inventoryid, obj.getInventoryID());
        assertEquals(customerid, obj.getCustomerID());
        assertEquals(returndate, obj.getReturnDate());
        assertEquals(staffid, obj.getStaffID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(customer, obj.getCustomer());
        assertEquals(inventory, obj.getInventory());
        assertEquals(staff, obj.getStaff());
        assertEquals(paymentlist, obj.getPaymentList());
    }

    @Test()
    @DisplayName("Should set and get customer relationship correctly")
    public void testCustomerRelationship() {
        Rental obj = new Rental();
        Customer relatedObj = customer;
        obj.setCustomer(relatedObj);
        assertSame(relatedObj, obj.getCustomer());
    }

    @Test()
    @DisplayName("Should set and get inventory relationship correctly")
    public void testInventoryRelationship() {
        Rental obj = new Rental();
        Inventory relatedObj = inventory;
        obj.setInventory(relatedObj);
        assertSame(relatedObj, obj.getInventory());
    }

    @Test()
    @DisplayName("Should set and get staff relationship correctly")
    public void testStaffRelationship() {
        Rental obj = new Rental();
        Staff relatedObj = staff;
        obj.setStaff(relatedObj);
        assertSame(relatedObj, obj.getStaff());
    }

    @Test()
    @DisplayName("Should manage paymentList relationship correctly")
    public void testPaymentListRelationship() {
        Rental obj = new Rental();
        List<Payment> relatedList = paymentlist;
        obj.setPaymentList(relatedList);
        assertNotNull(obj.getPaymentList());
        assertEquals(relatedList, obj.getPaymentList());
    }
}
