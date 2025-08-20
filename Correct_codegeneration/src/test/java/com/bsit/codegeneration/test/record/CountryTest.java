package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CountryTest {

    private static final Integer countryid = 10;

    private static final String country = "TestValue2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<City> citys = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Country record = new Country(countryid, country, lastupdate, citys);
        assertNotNull(record);
        assertEquals(countryid, record.countryID());
        assertEquals(country, record.country());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(citys, record.citys());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Country record = new Country.Builder().countryID(countryid).country(country).lastUpdate(lastupdate).citys(citys).build();
        assertNotNull(record);
        assertEquals(countryid, record.countryID());
        assertEquals(country, record.country());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(citys, record.citys());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Country record1 = new Country(countryid, country, lastupdate, citys);
        Country record2 = new Country(countryid, country, lastupdate, citys);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Country record = new Country(countryid, country, lastupdate, citys);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Country"));
    }
}
