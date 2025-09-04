package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Address;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.City;
import com.bsit.codegeneration.pojo.Staff;
import com.bsit.codegeneration.pojo.Customer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.pojo.Store;

public class AddressTest {

    private static final Integer addressid = 10;

    private static final String address = "TestValue2";

    private static final String address2 = "TestValue3";

    private static final String district = "TestValue4";

    private static final Integer cityid = 50;

    private static final String postalcode = "TestValue6";

    private static final String phone = "TestValue7";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 8, 8, 10, 30, 0);

    private static final City city = new City();

    private static final Staff managerstaff = new Staff();

    private static final List<Customer> customerlist = new ArrayList<>(Arrays.asList(new Customer()));

    private static final List<Staff> stafflist = new ArrayList<>(Arrays.asList(new Staff()));

    private static final List<Store> storelist = new ArrayList<>(Arrays.asList(new Store()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Address obj = new Address();
        assertNotNull(obj);
        assertNull(obj.getAddressID());
        assertNull(obj.getAddress());
        assertNull(obj.getAddress2());
        assertNull(obj.getDistrict());
        assertNull(obj.getCityID());
        assertNull(obj.getPostalCode());
        assertNull(obj.getPhone());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCity());
        assertNull(obj.getManagerStaff());
        assertNull(obj.getCustomerList());
        assertNull(obj.getStaffList());
        assertNull(obj.getStoreList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Address obj = new Address();
        obj.setAddressID(addressid);
        assertEquals(addressid, obj.getAddressID());
        obj.setAddress(address);
        assertEquals(address, obj.getAddress());
        obj.setAddress2(address2);
        assertEquals(address2, obj.getAddress2());
        obj.setDistrict(district);
        assertEquals(district, obj.getDistrict());
        obj.setCityID(cityid);
        assertEquals(cityid, obj.getCityID());
        obj.setPostalCode(postalcode);
        assertEquals(postalcode, obj.getPostalCode());
        obj.setPhone(phone);
        assertEquals(phone, obj.getPhone());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCity(city);
        assertEquals(city, obj.getCity());
        obj.setManagerStaff(managerstaff);
        assertEquals(managerstaff, obj.getManagerStaff());
        obj.setCustomerList(customerlist);
        assertEquals(customerlist, obj.getCustomerList());
        obj.setStaffList(stafflist);
        assertEquals(stafflist, obj.getStaffList());
        obj.setStoreList(storelist);
        assertEquals(storelist, obj.getStoreList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Address obj = new Address(addressid, address, address2, district, cityid, postalcode, phone, lastupdate, city, managerstaff);
        assertNotNull(obj);
        assertEquals(addressid, obj.getAddressID());
        assertEquals(address, obj.getAddress());
        assertEquals(address2, obj.getAddress2());
        assertEquals(district, obj.getDistrict());
        assertEquals(cityid, obj.getCityID());
        assertEquals(postalcode, obj.getPostalCode());
        assertEquals(phone, obj.getPhone());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(city, obj.getCity());
        assertEquals(managerstaff, obj.getManagerStaff());
        assertNull(obj.getCustomerList());
        assertNull(obj.getStaffList());
        assertNull(obj.getStoreList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Address obj = new Address.Builder().addressID(addressid).address(address).address2(address2).district(district).cityID(cityid).postalCode(postalcode).phone(phone).lastUpdate(lastupdate).city(city).managerStaff(managerstaff).customerList(customerlist).staffList(stafflist).storeList(storelist).build();
        assertNotNull(obj);
        assertEquals(addressid, obj.getAddressID());
        assertEquals(address, obj.getAddress());
        assertEquals(address2, obj.getAddress2());
        assertEquals(district, obj.getDistrict());
        assertEquals(cityid, obj.getCityID());
        assertEquals(postalcode, obj.getPostalCode());
        assertEquals(phone, obj.getPhone());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(city, obj.getCity());
        assertEquals(managerstaff, obj.getManagerStaff());
        assertEquals(customerlist, obj.getCustomerList());
        assertEquals(stafflist, obj.getStaffList());
        assertEquals(storelist, obj.getStoreList());
    }

    @Test()
    @DisplayName("Should set and get city relationship correctly")
    public void testCityRelationship() {
        Address obj = new Address();
        City relatedObj = city;
        obj.setCity(relatedObj);
        assertSame(relatedObj, obj.getCity());
    }

    @Test()
    @DisplayName("Should manage customerList relationship correctly")
    public void testCustomerListRelationship() {
        Address obj = new Address();
        List<Customer> relatedList = customerlist;
        obj.setCustomerList(relatedList);
        assertNotNull(obj.getCustomerList());
        assertEquals(relatedList, obj.getCustomerList());
    }

    @Test()
    @DisplayName("Should manage staffList relationship correctly")
    public void testStaffListRelationship() {
        Address obj = new Address();
        List<Staff> relatedList = stafflist;
        obj.setStaffList(relatedList);
        assertNotNull(obj.getStaffList());
        assertEquals(relatedList, obj.getStaffList());
    }

    @Test()
    @DisplayName("Should manage storeList relationship correctly")
    public void testStoreListRelationship() {
        Address obj = new Address();
        List<Store> relatedList = storelist;
        obj.setStoreList(relatedList);
        assertNotNull(obj.getStoreList());
        assertEquals(relatedList, obj.getStoreList());
    }
}
