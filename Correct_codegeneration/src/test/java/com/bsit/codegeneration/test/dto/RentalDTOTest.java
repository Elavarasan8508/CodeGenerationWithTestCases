package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.RentalDTO;
import com.bsit.codegeneration.dto.CustomerDTO;
import com.bsit.codegeneration.dto.InventoryDTO;
import com.bsit.codegeneration.dto.StaffDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.PaymentDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentalDTOTest {

    private static final CustomerDTO customer = new CustomerDTO();

    private static final InventoryDTO inventory = new InventoryDTO();

    private static final StaffDTO staff = new StaffDTO();

    private static final Integer rentalid = 40;

    private static final java.time.LocalDateTime rentaldate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    private static final Integer inventoryid = 60;

    private static final Integer customerid = 70;

    private static final java.time.LocalDateTime returndate = LocalDateTime.of(2023, 8, 8, 10, 30, 0);

    private static final Integer staffid = 90;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 10, 10, 10, 30, 0);

    private static final List<PaymentDTO> paymentlist = new ArrayList<>(Arrays.asList(new PaymentDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        RentalDTO dto = new RentalDTO();
        assertNotNull(dto);
        assertNull(dto.getCustomer());
        assertNull(dto.getInventory());
        assertNull(dto.getStaff());
        assertNull(dto.getRentalID());
        assertNull(dto.getRentalDate());
        assertNull(dto.getInventoryID());
        assertNull(dto.getCustomerID());
        assertNull(dto.getReturnDate());
        assertNull(dto.getStaffID());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getPaymentList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        RentalDTO dto = new RentalDTO();
        dto.setCustomer(customer);
        assertEquals(customer, dto.getCustomer());
        dto.setInventory(inventory);
        assertEquals(inventory, dto.getInventory());
        dto.setStaff(staff);
        assertEquals(staff, dto.getStaff());
        dto.setRentalID(rentalid);
        assertEquals(rentalid, dto.getRentalID());
        dto.setRentalDate(rentaldate);
        assertEquals(rentaldate, dto.getRentalDate());
        dto.setInventoryID(inventoryid);
        assertEquals(inventoryid, dto.getInventoryID());
        dto.setCustomerID(customerid);
        assertEquals(customerid, dto.getCustomerID());
        dto.setReturnDate(returndate);
        assertEquals(returndate, dto.getReturnDate());
        dto.setStaffID(staffid);
        assertEquals(staffid, dto.getStaffID());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setPaymentList(paymentlist);
        assertEquals(paymentlist, dto.getPaymentList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        RentalDTO dto = new RentalDTO(customer, inventory, staff, rentalid, rentaldate, inventoryid, customerid, returndate, staffid, lastupdate);
        assertNotNull(dto);
        assertEquals(customer, dto.getCustomer());
        assertEquals(inventory, dto.getInventory());
        assertEquals(staff, dto.getStaff());
        assertEquals(rentalid, dto.getRentalID());
        assertEquals(rentaldate, dto.getRentalDate());
        assertEquals(inventoryid, dto.getInventoryID());
        assertEquals(customerid, dto.getCustomerID());
        assertEquals(returndate, dto.getReturnDate());
        assertEquals(staffid, dto.getStaffID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getPaymentList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        RentalDTO dto = new RentalDTO.Builder().customer(customer).inventory(inventory).staff(staff).rentalID(rentalid).rentalDate(rentaldate).inventoryID(inventoryid).customerID(customerid).returnDate(returndate).staffID(staffid).lastUpdate(lastupdate).paymentList(paymentlist).build();
        assertNotNull(dto);
        assertEquals(customer, dto.getCustomer());
        assertEquals(inventory, dto.getInventory());
        assertEquals(staff, dto.getStaff());
        assertEquals(rentalid, dto.getRentalID());
        assertEquals(rentaldate, dto.getRentalDate());
        assertEquals(inventoryid, dto.getInventoryID());
        assertEquals(customerid, dto.getCustomerID());
        assertEquals(returndate, dto.getReturnDate());
        assertEquals(staffid, dto.getStaffID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(paymentlist, dto.getPaymentList());
    }

    @Test()
    @DisplayName("Should set and get customer relationship correctly")
    public void testCustomerRelationship() {
        RentalDTO dto = new RentalDTO();
        CustomerDTO relatedDto = customer;
        dto.setCustomer(relatedDto);
        assertSame(relatedDto, dto.getCustomer());
    }

    @Test()
    @DisplayName("Should set and get inventory relationship correctly")
    public void testInventoryRelationship() {
        RentalDTO dto = new RentalDTO();
        InventoryDTO relatedDto = inventory;
        dto.setInventory(relatedDto);
        assertSame(relatedDto, dto.getInventory());
    }

    @Test()
    @DisplayName("Should set and get staff relationship correctly")
    public void testStaffRelationship() {
        RentalDTO dto = new RentalDTO();
        StaffDTO relatedDto = staff;
        dto.setStaff(relatedDto);
        assertSame(relatedDto, dto.getStaff());
    }

    @Test()
    @DisplayName("Should manage paymentList relationship correctly")
    public void testPaymentListRelationship() {
        RentalDTO dto = new RentalDTO();
        List<PaymentDTO> relatedList = paymentlist;
        dto.setPaymentList(relatedList);
        assertNotNull(dto.getPaymentList());
        assertEquals(relatedList, dto.getPaymentList());
    }
}
