package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.City;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Country;
import com.bsit.codegeneration.pojo.Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityTest {

    private static final Integer cityid = 10;

    private static final String city = "TestValue2";

    private static final Integer countryid = 30;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final Country country = new Country();

    private static final List<Address> addresslist = new ArrayList<>(Arrays.asList(new Address()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        City obj = new City();
        assertNotNull(obj);
        assertNull(obj.getCityID());
        assertNull(obj.getCity());
        assertNull(obj.getCountryID());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCountry());
        assertNull(obj.getAddressList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        City obj = new City();
        obj.setCityID(cityid);
        assertEquals(cityid, obj.getCityID());
        obj.setCity(city);
        assertEquals(city, obj.getCity());
        obj.setCountryID(countryid);
        assertEquals(countryid, obj.getCountryID());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCountry(country);
        assertEquals(country, obj.getCountry());
        obj.setAddressList(addresslist);
        assertEquals(addresslist, obj.getAddressList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        City obj = new City(cityid, city, countryid, lastupdate, country);
        assertNotNull(obj);
        assertEquals(cityid, obj.getCityID());
        assertEquals(city, obj.getCity());
        assertEquals(countryid, obj.getCountryID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(country, obj.getCountry());
        assertNull(obj.getAddressList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        City obj = new City.Builder().cityID(cityid).city(city).countryID(countryid).lastUpdate(lastupdate).country(country).addressList(addresslist).build();
        assertNotNull(obj);
        assertEquals(cityid, obj.getCityID());
        assertEquals(city, obj.getCity());
        assertEquals(countryid, obj.getCountryID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(country, obj.getCountry());
        assertEquals(addresslist, obj.getAddressList());
    }

    @Test()
    @DisplayName("Should set and get country relationship correctly")
    public void testCountryRelationship() {
        City obj = new City();
        Country relatedObj = country;
        obj.setCountry(relatedObj);
        assertSame(relatedObj, obj.getCountry());
    }

    @Test()
    @DisplayName("Should manage addressList relationship correctly")
    public void testAddressListRelationship() {
        City obj = new City();
        List<Address> relatedList = addresslist;
        obj.setAddressList(relatedList);
        assertNotNull(obj.getAddressList());
        assertEquals(relatedList, obj.getAddressList());
    }
}
