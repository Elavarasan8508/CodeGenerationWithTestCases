package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddressTest {

    private static final Integer addressid = 10;

    private static final String address = "TestValue2";

    private static final String address2 = "TestValue3";

    private static final String district = "TestValue4";

    private static final Integer cityid = 50;

    private static final String postalcode = "TestValue6";

    private static final String phone = "TestValue7";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 8, 8, 10, 30, 0);

    private static final City city = null;

    private static final List<Customer> customers = new ArrayList<>();

    private static final List<Staff> staffs = new ArrayList<>();

    private static final List<Store> stores = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Address record = new Address(addressid, address, address2, district, cityid, postalcode, phone, lastupdate, city, customers, staffs, stores);
        assertNotNull(record);
        assertEquals(addressid, record.addressID());
        assertEquals(address, record.address());
        assertEquals(address2, record.address2());
        assertEquals(district, record.district());
        assertEquals(cityid, record.cityID());
        assertEquals(postalcode, record.postalCode());
        assertEquals(phone, record.phone());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(city, record.city());
        assertEquals(customers, record.customers());
        assertEquals(staffs, record.staffs());
        assertEquals(stores, record.stores());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Address record = new Address.Builder().addressID(addressid).address(address).address2(address2).district(district).cityID(cityid).postalCode(postalcode).phone(phone).lastUpdate(lastupdate).city(city).customers(customers).staffs(staffs).stores(stores).build();
        assertNotNull(record);
        assertEquals(addressid, record.addressID());
        assertEquals(address, record.address());
        assertEquals(address2, record.address2());
        assertEquals(district, record.district());
        assertEquals(cityid, record.cityID());
        assertEquals(postalcode, record.postalCode());
        assertEquals(phone, record.phone());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(city, record.city());
        assertEquals(customers, record.customers());
        assertEquals(staffs, record.staffs());
        assertEquals(stores, record.stores());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Address record1 = new Address(addressid, address, address2, district, cityid, postalcode, phone, lastupdate, city, customers, staffs, stores);
        Address record2 = new Address(addressid, address, address2, district, cityid, postalcode, phone, lastupdate, city, customers, staffs, stores);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Address record = new Address(addressid, address, address2, district, cityid, postalcode, phone, lastupdate, city, customers, staffs, stores);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Address"));
    }
}
