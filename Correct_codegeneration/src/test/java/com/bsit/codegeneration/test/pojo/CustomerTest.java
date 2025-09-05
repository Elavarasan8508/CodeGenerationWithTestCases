package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Customer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.Store;
import com.bsit.codegeneration.pojo.Payment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.pojo.Rental;

public class CustomerTest {

    private static final Integer customerid = 10;

    private static final Integer storeid = 20;

    private static final String firstname = "Test Name 3";

    private static final String lastname = "Test Name 4";

    private static final String email = "test5@example.com";

    private static final Integer addressid = 60;

    private static final Boolean active = false;

    private static final java.time.LocalDate createdate = LocalDate.of(2023, 8, 8);

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 9, 9, 10, 30, 0);

    private static final Address address = new Address();

    private static final Store store = new Store();

    private static final Payment customer = new Payment();

    private static final List<Payment> paymentlist = new ArrayList<>(Arrays.asList(new Payment()));

    private static final List<Rental> rentallist = new ArrayList<>(Arrays.asList(new Rental()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Customer obj = new Customer();
        assertNotNull(obj);
        assertNull(obj.getCustomerID());
        assertNull(obj.getStoreID());
        assertNull(obj.getFirstName());
        assertNull(obj.getLastName());
        assertNull(obj.getEmail());
        assertNull(obj.getAddressID());
        assertNull(obj.getActive());
        assertNull(obj.getCreateDate());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getAddress());
        assertNull(obj.getStore());
        assertNull(obj.getCustomer());
        assertNull(obj.getPaymentList());
        assertNull(obj.getRentalList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Customer obj = new Customer();
        obj.setCustomerID(customerid);
        assertEquals(customerid, obj.getCustomerID());
        obj.setStoreID(storeid);
        assertEquals(storeid, obj.getStoreID());
        obj.setFirstName(firstname);
        assertEquals(firstname, obj.getFirstName());
        obj.setLastName(lastname);
        assertEquals(lastname, obj.getLastName());
        obj.setEmail(email);
        assertEquals(email, obj.getEmail());
        obj.setAddressID(addressid);
        assertEquals(addressid, obj.getAddressID());
        obj.setActive(active);
        assertEquals(active, obj.getActive());
        obj.setCreateDate(createdate);
        assertEquals(createdate, obj.getCreateDate());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setAddress(address);
        assertEquals(address, obj.getAddress());
        obj.setStore(store);
        assertEquals(store, obj.getStore());
        obj.setCustomer(customer);
        assertEquals(customer, obj.getCustomer());
        obj.setPaymentList(paymentlist);
        assertEquals(paymentlist, obj.getPaymentList());
        obj.setRentalList(rentallist);
        assertEquals(rentallist, obj.getRentalList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Customer obj = new Customer(customerid, storeid, firstname, lastname, email, addressid, active, createdate, lastupdate, address, store, customer);
        assertNotNull(obj);
        assertEquals(customerid, obj.getCustomerID());
        assertEquals(storeid, obj.getStoreID());
        assertEquals(firstname, obj.getFirstName());
        assertEquals(lastname, obj.getLastName());
        assertEquals(email, obj.getEmail());
        assertEquals(addressid, obj.getAddressID());
        assertEquals(active, obj.getActive());
        assertEquals(createdate, obj.getCreateDate());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(address, obj.getAddress());
        assertEquals(store, obj.getStore());
        assertEquals(customer, obj.getCustomer());
        assertNull(obj.getPaymentList());
        assertNull(obj.getRentalList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Customer obj = new Customer.Builder().customerID(customerid).storeID(storeid).firstName(firstname).lastName(lastname).email(email).addressID(addressid).active(active).createDate(createdate).lastUpdate(lastupdate).address(address).store(store).customer(customer).paymentList(paymentlist).rentalList(rentallist).build();
        assertNotNull(obj);
        assertEquals(customerid, obj.getCustomerID());
        assertEquals(storeid, obj.getStoreID());
        assertEquals(firstname, obj.getFirstName());
        assertEquals(lastname, obj.getLastName());
        assertEquals(email, obj.getEmail());
        assertEquals(addressid, obj.getAddressID());
        assertEquals(active, obj.getActive());
        assertEquals(createdate, obj.getCreateDate());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(address, obj.getAddress());
        assertEquals(store, obj.getStore());
        assertEquals(customer, obj.getCustomer());
        assertEquals(paymentlist, obj.getPaymentList());
        assertEquals(rentallist, obj.getRentalList());
    }

    @Test()
    @DisplayName("Should set and get address relationship correctly")
    public void testAddressRelationship() {
        Customer obj = new Customer();
        Address relatedObj = address;
        obj.setAddress(relatedObj);
        assertSame(relatedObj, obj.getAddress());
    }

    @Test()
    @DisplayName("Should set and get store relationship correctly")
    public void testStoreRelationship() {
        Customer obj = new Customer();
        Store relatedObj = store;
        obj.setStore(relatedObj);
        assertSame(relatedObj, obj.getStore());
    }

    @Test()
    @DisplayName("Should manage paymentList relationship correctly")
    public void testPaymentListRelationship() {
        Customer obj = new Customer();
        List<Payment> relatedList = paymentlist;
        obj.setPaymentList(relatedList);
        assertNotNull(obj.getPaymentList());
        assertEquals(relatedList, obj.getPaymentList());
    }

    @Test()
    @DisplayName("Should manage rentalList relationship correctly")
    public void testRentalListRelationship() {
        Customer obj = new Customer();
        List<Rental> relatedList = rentallist;
        obj.setRentalList(relatedList);
        assertNotNull(obj.getRentalList());
        assertEquals(relatedList, obj.getRentalList());
    }
}
