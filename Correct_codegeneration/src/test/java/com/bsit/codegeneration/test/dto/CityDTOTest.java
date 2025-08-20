package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.CityDTO;
import com.bsit.codegeneration.dto.CountryDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.AddressDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityDTOTest {

    private static final CountryDTO country = new CountryDTO();

    private static final Integer cityid = 20;

    private static final String city = "TestValue3";

    private static final Integer countryid = 40;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    private static final List<AddressDTO> addresslist = new ArrayList<>(Arrays.asList(new AddressDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        CityDTO dto = new CityDTO();
        assertNotNull(dto);
        assertNull(dto.getCountry());
        assertNull(dto.getCityID());
        assertNull(dto.getCity());
        assertNull(dto.getCountryID());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getAddressList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        CityDTO dto = new CityDTO();
        dto.setCountry(country);
        assertEquals(country, dto.getCountry());
        dto.setCityID(cityid);
        assertEquals(cityid, dto.getCityID());
        dto.setCity(city);
        assertEquals(city, dto.getCity());
        dto.setCountryID(countryid);
        assertEquals(countryid, dto.getCountryID());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setAddressList(addresslist);
        assertEquals(addresslist, dto.getAddressList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        CityDTO dto = new CityDTO(country, cityid, city, countryid, lastupdate);
        assertNotNull(dto);
        assertEquals(country, dto.getCountry());
        assertEquals(cityid, dto.getCityID());
        assertEquals(city, dto.getCity());
        assertEquals(countryid, dto.getCountryID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getAddressList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        CityDTO dto = new CityDTO.Builder().country(country).cityID(cityid).city(city).countryID(countryid).lastUpdate(lastupdate).addressList(addresslist).build();
        assertNotNull(dto);
        assertEquals(country, dto.getCountry());
        assertEquals(cityid, dto.getCityID());
        assertEquals(city, dto.getCity());
        assertEquals(countryid, dto.getCountryID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(addresslist, dto.getAddressList());
    }

    @Test()
    @DisplayName("Should set and get country relationship correctly")
    public void testCountryRelationship() {
        CityDTO dto = new CityDTO();
        CountryDTO relatedDto = country;
        dto.setCountry(relatedDto);
        assertSame(relatedDto, dto.getCountry());
    }

    @Test()
    @DisplayName("Should manage addressList relationship correctly")
    public void testAddressListRelationship() {
        CityDTO dto = new CityDTO();
        List<AddressDTO> relatedList = addresslist;
        dto.setAddressList(relatedList);
        assertNotNull(dto.getAddressList());
        assertEquals(relatedList, dto.getAddressList());
    }
}
