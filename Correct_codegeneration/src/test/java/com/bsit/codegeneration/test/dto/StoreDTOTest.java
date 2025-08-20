package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.StoreDTO;
import com.bsit.codegeneration.dto.AddressDTO;
import com.bsit.codegeneration.dto.StaffDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.CustomerDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.dto.InventoryDTO;

public class StoreDTOTest {

    private static final AddressDTO address = new AddressDTO();

    private static final StaffDTO managerstaff = new StaffDTO();

    private static final Integer storeid = 30;

    private static final Integer managerstaffid = 40;

    private static final Integer addressid = 50;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 6, 6, 10, 30, 0);

    private static final List<CustomerDTO> customerlist = new ArrayList<>(Arrays.asList(new CustomerDTO()));

    private static final List<InventoryDTO> inventorylist = new ArrayList<>(Arrays.asList(new InventoryDTO()));

    private static final List<StaffDTO> stafflist = new ArrayList<>(Arrays.asList(new StaffDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        StoreDTO dto = new StoreDTO();
        assertNotNull(dto);
        assertNull(dto.getAddress());
        assertNull(dto.getManagerStaff());
        assertNull(dto.getStoreID());
        assertNull(dto.getManagerStaffID());
        assertNull(dto.getAddressID());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getCustomerList());
        assertNull(dto.getInventoryList());
        assertNull(dto.getStaffList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        StoreDTO dto = new StoreDTO();
        dto.setAddress(address);
        assertEquals(address, dto.getAddress());
        dto.setManagerStaff(managerstaff);
        assertEquals(managerstaff, dto.getManagerStaff());
        dto.setStoreID(storeid);
        assertEquals(storeid, dto.getStoreID());
        dto.setManagerStaffID(managerstaffid);
        assertEquals(managerstaffid, dto.getManagerStaffID());
        dto.setAddressID(addressid);
        assertEquals(addressid, dto.getAddressID());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setCustomerList(customerlist);
        assertEquals(customerlist, dto.getCustomerList());
        dto.setInventoryList(inventorylist);
        assertEquals(inventorylist, dto.getInventoryList());
        dto.setStaffList(stafflist);
        assertEquals(stafflist, dto.getStaffList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        StoreDTO dto = new StoreDTO(address, managerstaff, storeid, managerstaffid, addressid, lastupdate);
        assertNotNull(dto);
        assertEquals(address, dto.getAddress());
        assertEquals(managerstaff, dto.getManagerStaff());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(managerstaffid, dto.getManagerStaffID());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getCustomerList());
        assertNull(dto.getInventoryList());
        assertNull(dto.getStaffList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        StoreDTO dto = new StoreDTO.Builder().address(address).managerStaff(managerstaff).storeID(storeid).managerStaffID(managerstaffid).addressID(addressid).lastUpdate(lastupdate).customerList(customerlist).inventoryList(inventorylist).staffList(stafflist).build();
        assertNotNull(dto);
        assertEquals(address, dto.getAddress());
        assertEquals(managerstaff, dto.getManagerStaff());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(managerstaffid, dto.getManagerStaffID());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(customerlist, dto.getCustomerList());
        assertEquals(inventorylist, dto.getInventoryList());
        assertEquals(stafflist, dto.getStaffList());
    }

    @Test()
    @DisplayName("Should set and get address relationship correctly")
    public void testAddressRelationship() {
        StoreDTO dto = new StoreDTO();
        AddressDTO relatedDto = address;
        dto.setAddress(relatedDto);
        assertSame(relatedDto, dto.getAddress());
    }

    @Test()
    @DisplayName("Should set and get managerStaff relationship correctly")
    public void testManagerStaffRelationship() {
        StoreDTO dto = new StoreDTO();
        StaffDTO relatedDto = managerstaff;
        dto.setManagerStaff(relatedDto);
        assertSame(relatedDto, dto.getManagerStaff());
    }

    @Test()
    @DisplayName("Should manage customerList relationship correctly")
    public void testCustomerListRelationship() {
        StoreDTO dto = new StoreDTO();
        List<CustomerDTO> relatedList = customerlist;
        dto.setCustomerList(relatedList);
        assertNotNull(dto.getCustomerList());
        assertEquals(relatedList, dto.getCustomerList());
    }

    @Test()
    @DisplayName("Should manage inventoryList relationship correctly")
    public void testInventoryListRelationship() {
        StoreDTO dto = new StoreDTO();
        List<InventoryDTO> relatedList = inventorylist;
        dto.setInventoryList(relatedList);
        assertNotNull(dto.getInventoryList());
        assertEquals(relatedList, dto.getInventoryList());
    }

    @Test()
    @DisplayName("Should manage staffList relationship correctly")
    public void testStaffListRelationship() {
        StoreDTO dto = new StoreDTO();
        List<StaffDTO> relatedList = stafflist;
        dto.setStaffList(relatedList);
        assertNotNull(dto.getStaffList());
        assertEquals(relatedList, dto.getStaffList());
    }
}
