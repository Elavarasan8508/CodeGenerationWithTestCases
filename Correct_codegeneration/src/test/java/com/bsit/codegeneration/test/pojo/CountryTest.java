package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Country;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.City;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryTest {

    private static final Integer countryid = 10;

    private static final String country = "TestValue2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<City> citylist = new ArrayList<>(Arrays.asList(new City()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Country obj = new Country();
        assertNotNull(obj);
        assertNull(obj.getCountryID());
        assertNull(obj.getCountry());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCityList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Country obj = new Country();
        obj.setCountryID(countryid);
        assertEquals(countryid, obj.getCountryID());
        obj.setCountry(country);
        assertEquals(country, obj.getCountry());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCityList(citylist);
        assertEquals(citylist, obj.getCityList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Country obj = new Country(countryid, country, lastupdate);
        assertNotNull(obj);
        assertEquals(countryid, obj.getCountryID());
        assertEquals(country, obj.getCountry());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertNull(obj.getCityList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Country obj = new Country.Builder().countryID(countryid).country(country).lastUpdate(lastupdate).cityList(citylist).build();
        assertNotNull(obj);
        assertEquals(countryid, obj.getCountryID());
        assertEquals(country, obj.getCountry());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(citylist, obj.getCityList());
    }

    @Test()
    @DisplayName("Should manage cityList relationship correctly")
    public void testCityListRelationship() {
        Country obj = new Country();
        List<City> relatedList = citylist;
        obj.setCityList(relatedList);
        assertNotNull(obj.getCityList());
        assertEquals(relatedList, obj.getCityList());
    }
}
