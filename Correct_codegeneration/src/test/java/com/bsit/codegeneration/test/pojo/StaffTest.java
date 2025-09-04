package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Staff;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.Store;
import com.bsit.codegeneration.pojo.Payment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.pojo.Rental;

public class StaffTest {

    private static final Integer staffid = 10;

    private static final String firstname = "Test Name 2";

    private static final String lastname = "Test Name 3";

    private static final Integer addressid = 40;

    private static final String email = "test5@example.com";

    private static final Integer storeid = 60;

    private static final Boolean active = false;

    private static final String username = "Test Name 8";

    private static final String password = "TestValue9";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 10, 10, 10, 30, 0);

    private static final String picture = "TestValue11";

    private static final Address address = new Address();

    private static final Store store = new Store();

    private static final Store managerstaff = new Store();

    private static final List<Payment> paymentlist = new ArrayList<>(Arrays.asList(new Payment()));

    private static final List<Rental> rentallist = new ArrayList<>(Arrays.asList(new Rental()));

    private static final List<Store> storelist = new ArrayList<>(Arrays.asList(new Store()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Staff obj = new Staff();
        assertNotNull(obj);
        assertNull(obj.getStaffID());
        assertNull(obj.getFirstName());
        assertNull(obj.getLastName());
        assertNull(obj.getAddressID());
        assertNull(obj.getEmail());
        assertNull(obj.getStoreID());
        assertNull(obj.getActive());
        assertNull(obj.getUsername());
        assertNull(obj.getPassword());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getPicture());
        assertNull(obj.getAddress());
        assertNull(obj.getStore());
        assertNull(obj.getManagerStaff());
        assertNull(obj.getPaymentList());
        assertNull(obj.getRentalList());
        assertNull(obj.getStoreList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Staff obj = new Staff();
        obj.setStaffID(staffid);
        assertEquals(staffid, obj.getStaffID());
        obj.setFirstName(firstname);
        assertEquals(firstname, obj.getFirstName());
        obj.setLastName(lastname);
        assertEquals(lastname, obj.getLastName());
        obj.setAddressID(addressid);
        assertEquals(addressid, obj.getAddressID());
        obj.setEmail(email);
        assertEquals(email, obj.getEmail());
        obj.setStoreID(storeid);
        assertEquals(storeid, obj.getStoreID());
        obj.setActive(active);
        assertEquals(active, obj.getActive());
        obj.setUsername(username);
        assertEquals(username, obj.getUsername());
        obj.setPassword(password);
        assertEquals(password, obj.getPassword());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setPicture(picture);
        assertEquals(picture, obj.getPicture());
        obj.setAddress(address);
        assertEquals(address, obj.getAddress());
        obj.setStore(store);
        assertEquals(store, obj.getStore());
        obj.setManagerStaff(managerstaff);
        assertEquals(managerstaff, obj.getManagerStaff());
        obj.setPaymentList(paymentlist);
        assertEquals(paymentlist, obj.getPaymentList());
        obj.setRentalList(rentallist);
        assertEquals(rentallist, obj.getRentalList());
        obj.setStoreList(storelist);
        assertEquals(storelist, obj.getStoreList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Staff obj = new Staff(staffid, firstname, lastname, addressid, email, storeid, active, username, password, lastupdate, picture, address, store, managerstaff);
        assertNotNull(obj);
        assertEquals(staffid, obj.getStaffID());
        assertEquals(firstname, obj.getFirstName());
        assertEquals(lastname, obj.getLastName());
        assertEquals(addressid, obj.getAddressID());
        assertEquals(email, obj.getEmail());
        assertEquals(storeid, obj.getStoreID());
        assertEquals(active, obj.getActive());
        assertEquals(username, obj.getUsername());
        assertEquals(password, obj.getPassword());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(picture, obj.getPicture());
        assertEquals(address, obj.getAddress());
        assertEquals(store, obj.getStore());
        assertEquals(managerstaff, obj.getManagerStaff());
        assertNull(obj.getPaymentList());
        assertNull(obj.getRentalList());
        assertNull(obj.getStoreList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Staff obj = new Staff.Builder().staffID(staffid).firstName(firstname).lastName(lastname).addressID(addressid).email(email).storeID(storeid).active(active).username(username).password(password).lastUpdate(lastupdate).picture(picture).address(address).store(store).managerStaff(managerstaff).paymentList(paymentlist).rentalList(rentallist).storeList(storelist).build();
        assertNotNull(obj);
        assertEquals(staffid, obj.getStaffID());
        assertEquals(firstname, obj.getFirstName());
        assertEquals(lastname, obj.getLastName());
        assertEquals(addressid, obj.getAddressID());
        assertEquals(email, obj.getEmail());
        assertEquals(storeid, obj.getStoreID());
        assertEquals(active, obj.getActive());
        assertEquals(username, obj.getUsername());
        assertEquals(password, obj.getPassword());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(picture, obj.getPicture());
        assertEquals(address, obj.getAddress());
        assertEquals(store, obj.getStore());
        assertEquals(managerstaff, obj.getManagerStaff());
        assertEquals(paymentlist, obj.getPaymentList());
        assertEquals(rentallist, obj.getRentalList());
        assertEquals(storelist, obj.getStoreList());
    }

    @Test()
    @DisplayName("Should set and get address relationship correctly")
    public void testAddressRelationship() {
        Staff obj = new Staff();
        Address relatedObj = address;
        obj.setAddress(relatedObj);
        assertSame(relatedObj, obj.getAddress());
    }

    @Test()
    @DisplayName("Should set and get store relationship correctly")
    public void testStoreRelationship() {
        Staff obj = new Staff();
        Store relatedObj = store;
        obj.setStore(relatedObj);
        assertSame(relatedObj, obj.getStore());
    }

    @Test()
    @DisplayName("Should manage paymentList relationship correctly")
    public void testPaymentListRelationship() {
        Staff obj = new Staff();
        List<Payment> relatedList = paymentlist;
        obj.setPaymentList(relatedList);
        assertNotNull(obj.getPaymentList());
        assertEquals(relatedList, obj.getPaymentList());
    }

    @Test()
    @DisplayName("Should manage rentalList relationship correctly")
    public void testRentalListRelationship() {
        Staff obj = new Staff();
        List<Rental> relatedList = rentallist;
        obj.setRentalList(relatedList);
        assertNotNull(obj.getRentalList());
        assertEquals(relatedList, obj.getRentalList());
    }

    @Test()
    @DisplayName("Should manage storeList relationship correctly")
    public void testStoreListRelationship() {
        Staff obj = new Staff();
        List<Store> relatedList = storelist;
        obj.setStoreList(relatedList);
        assertNotNull(obj.getStoreList());
        assertEquals(relatedList, obj.getStoreList());
    }
}
