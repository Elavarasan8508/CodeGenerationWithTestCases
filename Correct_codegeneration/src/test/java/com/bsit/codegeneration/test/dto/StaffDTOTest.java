package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.StaffDTO;
import com.bsit.codegeneration.dto.AddressDTO;
import com.bsit.codegeneration.dto.StoreDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.PaymentDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.dto.RentalDTO;

public class StaffDTOTest {

    private static final AddressDTO address = new AddressDTO();

    private static final StoreDTO store = new StoreDTO();

    private static final StaffDTO managerstaff = new StaffDTO();

    private static final Integer staffid = 40;

    private static final String firstname = "Test Name 5";

    private static final String lastname = "Test Name 6";

    private static final Integer addressid = 70;

    private static final String email = "test8@example.com";

    private static final Integer storeid = 90;

    private static final String active = "TestValue10";

    private static final String username = "Test Name 11";

    private static final String password = "TestValue12";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 1, 13, 10, 30, 0);

    private static final String picture = "TestValue14";

    private static final List<PaymentDTO> paymentlist = new ArrayList<>(Arrays.asList(new PaymentDTO()));

    private static final List<RentalDTO> rentallist = new ArrayList<>(Arrays.asList(new RentalDTO()));

    private static final List<StoreDTO> storelist = new ArrayList<>(Arrays.asList(new StoreDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        StaffDTO dto = new StaffDTO();
        assertNotNull(dto);
        assertNull(dto.getAddress());
        assertNull(dto.getStore());
        assertNull(dto.getManagerStaff());
        assertNull(dto.getStaffID());
        assertNull(dto.getFirstName());
        assertNull(dto.getLastName());
        assertNull(dto.getAddressID());
        assertNull(dto.getEmail());
        assertNull(dto.getStoreID());
        assertNull(dto.getActive());
        assertNull(dto.getUsername());
        assertNull(dto.getPassword());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getPicture());
        assertNull(dto.getPaymentList());
        assertNull(dto.getRentalList());
        assertNull(dto.getStoreList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        StaffDTO dto = new StaffDTO();
        dto.setAddress(address);
        assertEquals(address, dto.getAddress());
        dto.setStore(store);
        assertEquals(store, dto.getStore());
        dto.setManagerStaff(managerstaff);
        assertEquals(managerstaff, dto.getManagerStaff());
        dto.setStaffID(staffid);
        assertEquals(staffid, dto.getStaffID());
        dto.setFirstName(firstname);
        assertEquals(firstname, dto.getFirstName());
        dto.setLastName(lastname);
        assertEquals(lastname, dto.getLastName());
        dto.setAddressID(addressid);
        assertEquals(addressid, dto.getAddressID());
        dto.setEmail(email);
        assertEquals(email, dto.getEmail());
        dto.setStoreID(storeid);
        assertEquals(storeid, dto.getStoreID());
        dto.setActive(active);
        assertEquals(active, dto.getActive());
        dto.setUsername(username);
        assertEquals(username, dto.getUsername());
        dto.setPassword(password);
        assertEquals(password, dto.getPassword());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setPicture(picture);
        assertEquals(picture, dto.getPicture());
        dto.setPaymentList(paymentlist);
        assertEquals(paymentlist, dto.getPaymentList());
        dto.setRentalList(rentallist);
        assertEquals(rentallist, dto.getRentalList());
        dto.setStoreList(storelist);
        assertEquals(storelist, dto.getStoreList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        StaffDTO dto = new StaffDTO(address, store, managerstaff, staffid, firstname, lastname, addressid, email, storeid, active, username, password, lastupdate, picture);
        assertNotNull(dto);
        assertEquals(address, dto.getAddress());
        assertEquals(store, dto.getStore());
        assertEquals(managerstaff, dto.getManagerStaff());
        assertEquals(staffid, dto.getStaffID());
        assertEquals(firstname, dto.getFirstName());
        assertEquals(lastname, dto.getLastName());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(email, dto.getEmail());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(active, dto.getActive());
        assertEquals(username, dto.getUsername());
        assertEquals(password, dto.getPassword());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(picture, dto.getPicture());
        assertNull(dto.getPaymentList());
        assertNull(dto.getRentalList());
        assertNull(dto.getStoreList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        StaffDTO dto = new StaffDTO.Builder().address(address).store(store).managerStaff(managerstaff).staffID(staffid).firstName(firstname).lastName(lastname).addressID(addressid).email(email).storeID(storeid).active(active).username(username).password(password).lastUpdate(lastupdate).picture(picture).paymentList(paymentlist).rentalList(rentallist).storeList(storelist).build();
        assertNotNull(dto);
        assertEquals(address, dto.getAddress());
        assertEquals(store, dto.getStore());
        assertEquals(managerstaff, dto.getManagerStaff());
        assertEquals(staffid, dto.getStaffID());
        assertEquals(firstname, dto.getFirstName());
        assertEquals(lastname, dto.getLastName());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(email, dto.getEmail());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(active, dto.getActive());
        assertEquals(username, dto.getUsername());
        assertEquals(password, dto.getPassword());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(picture, dto.getPicture());
        assertEquals(paymentlist, dto.getPaymentList());
        assertEquals(rentallist, dto.getRentalList());
        assertEquals(storelist, dto.getStoreList());
    }

    @Test()
    @DisplayName("Should set and get address relationship correctly")
    public void testAddressRelationship() {
        StaffDTO dto = new StaffDTO();
        AddressDTO relatedDto = address;
        dto.setAddress(relatedDto);
        assertSame(relatedDto, dto.getAddress());
    }

    @Test()
    @DisplayName("Should set and get store relationship correctly")
    public void testStoreRelationship() {
        StaffDTO dto = new StaffDTO();
        StoreDTO relatedDto = store;
        dto.setStore(relatedDto);
        assertSame(relatedDto, dto.getStore());
    }

    @Test()
    @DisplayName("Should manage paymentList relationship correctly")
    public void testPaymentListRelationship() {
        StaffDTO dto = new StaffDTO();
        List<PaymentDTO> relatedList = paymentlist;
        dto.setPaymentList(relatedList);
        assertNotNull(dto.getPaymentList());
        assertEquals(relatedList, dto.getPaymentList());
    }

    @Test()
    @DisplayName("Should manage rentalList relationship correctly")
    public void testRentalListRelationship() {
        StaffDTO dto = new StaffDTO();
        List<RentalDTO> relatedList = rentallist;
        dto.setRentalList(relatedList);
        assertNotNull(dto.getRentalList());
        assertEquals(relatedList, dto.getRentalList());
    }

    @Test()
    @DisplayName("Should manage storeList relationship correctly")
    public void testStoreListRelationship() {
        StaffDTO dto = new StaffDTO();
        List<StoreDTO> relatedList = storelist;
        dto.setStoreList(relatedList);
        assertNotNull(dto.getStoreList());
        assertEquals(relatedList, dto.getStoreList());
    }
}
