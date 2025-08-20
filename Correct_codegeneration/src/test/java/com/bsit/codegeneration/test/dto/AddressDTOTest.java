package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.AddressDTO;
import com.bsit.codegeneration.dto.CityDTO;
import com.bsit.codegeneration.dto.StaffDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.CustomerDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.dto.StoreDTO;

public class AddressDTOTest {

    private static final CityDTO city = new CityDTO();

    private static final StaffDTO managerstaff = new StaffDTO();

    private static final Integer addressid = 30;

    private static final String address = "TestValue4";

    private static final String address2 = "TestValue5";

    private static final String district = "TestValue6";

    private static final Integer cityid = 70;

    private static final String postalcode = "TestValue8";

    private static final String phone = "TestValue9";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 10, 10, 10, 30, 0);

    private static final List<CustomerDTO> customerlist = new ArrayList<>(Arrays.asList(new CustomerDTO()));

    private static final List<StaffDTO> stafflist = new ArrayList<>(Arrays.asList(new StaffDTO()));

    private static final List<StoreDTO> storelist = new ArrayList<>(Arrays.asList(new StoreDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        AddressDTO dto = new AddressDTO();
        assertNotNull(dto);
        assertNull(dto.getCity());
        assertNull(dto.getManagerStaff());
        assertNull(dto.getAddressID());
        assertNull(dto.getAddress());
        assertNull(dto.getAddress2());
        assertNull(dto.getDistrict());
        assertNull(dto.getCityID());
        assertNull(dto.getPostalCode());
        assertNull(dto.getPhone());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getCustomerList());
        assertNull(dto.getStaffList());
        assertNull(dto.getStoreList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        AddressDTO dto = new AddressDTO();
        dto.setCity(city);
        assertEquals(city, dto.getCity());
        dto.setManagerStaff(managerstaff);
        assertEquals(managerstaff, dto.getManagerStaff());
        dto.setAddressID(addressid);
        assertEquals(addressid, dto.getAddressID());
        dto.setAddress(address);
        assertEquals(address, dto.getAddress());
        dto.setAddress2(address2);
        assertEquals(address2, dto.getAddress2());
        dto.setDistrict(district);
        assertEquals(district, dto.getDistrict());
        dto.setCityID(cityid);
        assertEquals(cityid, dto.getCityID());
        dto.setPostalCode(postalcode);
        assertEquals(postalcode, dto.getPostalCode());
        dto.setPhone(phone);
        assertEquals(phone, dto.getPhone());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setCustomerList(customerlist);
        assertEquals(customerlist, dto.getCustomerList());
        dto.setStaffList(stafflist);
        assertEquals(stafflist, dto.getStaffList());
        dto.setStoreList(storelist);
        assertEquals(storelist, dto.getStoreList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        AddressDTO dto = new AddressDTO(city, address, managerstaff, addressid, address2, district, cityid, postalcode, phone, lastupdate);
        assertNotNull(dto);
        assertEquals(city, dto.getCity());
        assertEquals(managerstaff, dto.getManagerStaff());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(address, dto.getAddress());
        assertEquals(address2, dto.getAddress2());
        assertEquals(district, dto.getDistrict());
        assertEquals(cityid, dto.getCityID());
        assertEquals(postalcode, dto.getPostalCode());
        assertEquals(phone, dto.getPhone());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getCustomerList());
        assertNull(dto.getStaffList());
        assertNull(dto.getStoreList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        AddressDTO dto = new AddressDTO.Builder().city(city).managerStaff(managerstaff).addressID(addressid).address(address).address2(address2).district(district).cityID(cityid).postalCode(postalcode).phone(phone).lastUpdate(lastupdate).customerList(customerlist).staffList(stafflist).storeList(storelist).build();
        assertNotNull(dto);
        assertEquals(city, dto.getCity());
        assertEquals(managerstaff, dto.getManagerStaff());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(address, dto.getAddress());
        assertEquals(address2, dto.getAddress2());
        assertEquals(district, dto.getDistrict());
        assertEquals(cityid, dto.getCityID());
        assertEquals(postalcode, dto.getPostalCode());
        assertEquals(phone, dto.getPhone());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(customerlist, dto.getCustomerList());
        assertEquals(stafflist, dto.getStaffList());
        assertEquals(storelist, dto.getStoreList());
    }

    @Test()
    @DisplayName("Should set and get city relationship correctly")
    public void testCityRelationship() {
        AddressDTO dto = new AddressDTO();
        CityDTO relatedDto = city;
        dto.setCity(relatedDto);
        assertSame(relatedDto, dto.getCity());
    }

    @Test()
    @DisplayName("Should manage customerList relationship correctly")
    public void testCustomerListRelationship() {
        AddressDTO dto = new AddressDTO();
        List<CustomerDTO> relatedList = customerlist;
        dto.setCustomerList(relatedList);
        assertNotNull(dto.getCustomerList());
        assertEquals(relatedList, dto.getCustomerList());
    }

    @Test()
    @DisplayName("Should manage staffList relationship correctly")
    public void testStaffListRelationship() {
        AddressDTO dto = new AddressDTO();
        List<StaffDTO> relatedList = stafflist;
        dto.setStaffList(relatedList);
        assertNotNull(dto.getStaffList());
        assertEquals(relatedList, dto.getStaffList());
    }

    @Test()
    @DisplayName("Should manage storeList relationship correctly")
    public void testStoreListRelationship() {
        AddressDTO dto = new AddressDTO();
        List<StoreDTO> relatedList = storelist;
        dto.setStoreList(relatedList);
        assertNotNull(dto.getStoreList());
        assertEquals(relatedList, dto.getStoreList());
    }
}
