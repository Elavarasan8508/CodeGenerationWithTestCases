package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Store;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.Staff;
import com.bsit.codegeneration.pojo.Customer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.pojo.Inventory;

public class StoreTest {

    private static final Integer storeid = 10;

    private static final Integer managerstaffid = 20;

    private static final Integer addressid = 30;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final Address address = new Address();

    private static final Staff managerstaff = new Staff();

    private static final List<Customer> customerlist = new ArrayList<>(Arrays.asList(new Customer()));

    private static final List<Inventory> inventorylist = new ArrayList<>(Arrays.asList(new Inventory()));

    private static final List<Staff> stafflist = new ArrayList<>(Arrays.asList(new Staff()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Store obj = new Store();
        assertNotNull(obj);
        assertNull(obj.getStoreID());
        assertNull(obj.getManagerStaffID());
        assertNull(obj.getAddressID());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getAddress());
        assertNull(obj.getManagerStaff());
        assertNull(obj.getCustomerList());
        assertNull(obj.getInventoryList());
        assertNull(obj.getStaffList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Store obj = new Store();
        obj.setStoreID(storeid);
        assertEquals(storeid, obj.getStoreID());
        obj.setManagerStaffID(managerstaffid);
        assertEquals(managerstaffid, obj.getManagerStaffID());
        obj.setAddressID(addressid);
        assertEquals(addressid, obj.getAddressID());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setAddress(address);
        assertEquals(address, obj.getAddress());
        obj.setManagerStaff(managerstaff);
        assertEquals(managerstaff, obj.getManagerStaff());
        obj.setCustomerList(customerlist);
        assertEquals(customerlist, obj.getCustomerList());
        obj.setInventoryList(inventorylist);
        assertEquals(inventorylist, obj.getInventoryList());
        obj.setStaffList(stafflist);
        assertEquals(stafflist, obj.getStaffList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Store obj = new Store(storeid, managerstaffid, addressid, lastupdate, address, managerstaff);
        assertNotNull(obj);
        assertEquals(storeid, obj.getStoreID());
        assertEquals(managerstaffid, obj.getManagerStaffID());
        assertEquals(addressid, obj.getAddressID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(address, obj.getAddress());
        assertEquals(managerstaff, obj.getManagerStaff());
        assertNull(obj.getCustomerList());
        assertNull(obj.getInventoryList());
        assertNull(obj.getStaffList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Store obj = new Store.Builder().storeID(storeid).managerStaffID(managerstaffid).addressID(addressid).lastUpdate(lastupdate).address(address).managerStaff(managerstaff).customerList(customerlist).inventoryList(inventorylist).staffList(stafflist).build();
        assertNotNull(obj);
        assertEquals(storeid, obj.getStoreID());
        assertEquals(managerstaffid, obj.getManagerStaffID());
        assertEquals(addressid, obj.getAddressID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(address, obj.getAddress());
        assertEquals(managerstaff, obj.getManagerStaff());
        assertEquals(customerlist, obj.getCustomerList());
        assertEquals(inventorylist, obj.getInventoryList());
        assertEquals(stafflist, obj.getStaffList());
    }

    @Test()
    @DisplayName("Should set and get address relationship correctly")
    public void testAddressRelationship() {
        Store obj = new Store();
        Address relatedObj = address;
        obj.setAddress(relatedObj);
        assertSame(relatedObj, obj.getAddress());
    }

    @Test()
    @DisplayName("Should set and get managerStaff relationship correctly")
    public void testManagerStaffRelationship() {
        Store obj = new Store();
        Staff relatedObj = managerstaff;
        obj.setManagerStaff(relatedObj);
        assertSame(relatedObj, obj.getManagerStaff());
    }

    @Test()
    @DisplayName("Should manage customerList relationship correctly")
    public void testCustomerListRelationship() {
        Store obj = new Store();
        List<Customer> relatedList = customerlist;
        obj.setCustomerList(relatedList);
        assertNotNull(obj.getCustomerList());
        assertEquals(relatedList, obj.getCustomerList());
    }

    @Test()
    @DisplayName("Should manage inventoryList relationship correctly")
    public void testInventoryListRelationship() {
        Store obj = new Store();
        List<Inventory> relatedList = inventorylist;
        obj.setInventoryList(relatedList);
        assertNotNull(obj.getInventoryList());
        assertEquals(relatedList, obj.getInventoryList());
    }

    @Test()
    @DisplayName("Should manage staffList relationship correctly")
    public void testStaffListRelationship() {
        Store obj = new Store();
        List<Staff> relatedList = stafflist;
        obj.setStaffList(relatedList);
        assertNotNull(obj.getStaffList());
        assertEquals(relatedList, obj.getStaffList());
    }
}
