package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CityTest {

    private static final Integer cityid = 10;

    private static final String city = "TestValue2";

    private static final Integer countryid = 30;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final Country country = null;

    private static final List<Address> addresss = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        City record = new City(cityid, city, countryid, lastupdate, country, addresss);
        assertNotNull(record);
        assertEquals(cityid, record.cityID());
        assertEquals(city, record.city());
        assertEquals(countryid, record.countryID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(country, record.country());
        assertEquals(addresss, record.addresss());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        City record = new City.Builder().cityID(cityid).city(city).countryID(countryid).lastUpdate(lastupdate).country(country).addresss(addresss).build();
        assertNotNull(record);
        assertEquals(cityid, record.cityID());
        assertEquals(city, record.city());
        assertEquals(countryid, record.countryID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(country, record.country());
        assertEquals(addresss, record.addresss());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        City record1 = new City(cityid, city, countryid, lastupdate, country, addresss);
        City record2 = new City(cityid, city, countryid, lastupdate, country, addresss);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        City record = new City(cityid, city, countryid, lastupdate, country, addresss);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("City"));
    }
}
