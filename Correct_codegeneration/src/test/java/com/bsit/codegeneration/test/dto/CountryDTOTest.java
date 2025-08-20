package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.CountryDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.CityDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryDTOTest {

    private static final Integer countryid = 10;

    private static final String country = "TestValue2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<CityDTO> citylist = new ArrayList<>(Arrays.asList(new CityDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        CountryDTO dto = new CountryDTO();
        assertNotNull(dto);
        assertNull(dto.getCountryID());
        assertNull(dto.getCountry());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getCityList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        CountryDTO dto = new CountryDTO();
        dto.setCountryID(countryid);
        assertEquals(countryid, dto.getCountryID());
        dto.setCountry(country);
        assertEquals(country, dto.getCountry());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setCityList(citylist);
        assertEquals(citylist, dto.getCityList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        CountryDTO dto = new CountryDTO(countryid, country, lastupdate);
        assertNotNull(dto);
        assertEquals(countryid, dto.getCountryID());
        assertEquals(country, dto.getCountry());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getCityList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        CountryDTO dto = new CountryDTO.Builder().countryID(countryid).country(country).lastUpdate(lastupdate).cityList(citylist).build();
        assertNotNull(dto);
        assertEquals(countryid, dto.getCountryID());
        assertEquals(country, dto.getCountry());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(citylist, dto.getCityList());
    }

    @Test()
    @DisplayName("Should manage cityList relationship correctly")
    public void testCityListRelationship() {
        CountryDTO dto = new CountryDTO();
        List<CityDTO> relatedList = citylist;
        dto.setCityList(relatedList);
        assertNotNull(dto.getCityList());
        assertEquals(relatedList, dto.getCityList());
    }
}
