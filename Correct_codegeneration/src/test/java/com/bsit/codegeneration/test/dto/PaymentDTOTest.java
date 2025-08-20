package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.PaymentDTO;
import com.bsit.codegeneration.dto.CustomerDTO;
import com.bsit.codegeneration.dto.RentalDTO;
import com.bsit.codegeneration.dto.StaffDTO;
import java.time.LocalDateTime;

public class PaymentDTOTest {

    private static final CustomerDTO customer = new CustomerDTO();

    private static final RentalDTO rental = new RentalDTO();

    private static final StaffDTO staff = new StaffDTO();

    private static final Integer paymentid = 40;

    private static final Integer customerid = 50;

    private static final Integer staffid = 60;

    private static final Integer rentalid = 70;

    private static final Float amount = 12.0f;

    private static final java.time.LocalDateTime paymentdate = LocalDateTime.of(2023, 9, 9, 10, 30, 0);

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 10, 10, 10, 30, 0);

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        PaymentDTO dto = new PaymentDTO();
        assertNotNull(dto);
        assertNull(dto.getCustomer());
        assertNull(dto.getRental());
        assertNull(dto.getStaff());
        assertNull(dto.getPaymentID());
        assertNull(dto.getCustomerID());
        assertNull(dto.getStaffID());
        assertNull(dto.getRentalID());
        assertNull(dto.getAmount());
        assertNull(dto.getPaymentDate());
        assertNull(dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        PaymentDTO dto = new PaymentDTO();
        dto.setCustomer(customer);
        assertEquals(customer, dto.getCustomer());
        dto.setRental(rental);
        assertEquals(rental, dto.getRental());
        dto.setStaff(staff);
        assertEquals(staff, dto.getStaff());
        dto.setPaymentID(paymentid);
        assertEquals(paymentid, dto.getPaymentID());
        dto.setCustomerID(customerid);
        assertEquals(customerid, dto.getCustomerID());
        dto.setStaffID(staffid);
        assertEquals(staffid, dto.getStaffID());
        dto.setRentalID(rentalid);
        assertEquals(rentalid, dto.getRentalID());
        dto.setAmount(amount);
        assertEquals(amount, dto.getAmount());
        dto.setPaymentDate(paymentdate);
        assertEquals(paymentdate, dto.getPaymentDate());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        PaymentDTO dto = new PaymentDTO(customer, rental, staff, paymentid, customerid, staffid, rentalid, amount, paymentdate, lastupdate);
        assertNotNull(dto);
        assertEquals(customer, dto.getCustomer());
        assertEquals(rental, dto.getRental());
        assertEquals(staff, dto.getStaff());
        assertEquals(paymentid, dto.getPaymentID());
        assertEquals(customerid, dto.getCustomerID());
        assertEquals(staffid, dto.getStaffID());
        assertEquals(rentalid, dto.getRentalID());
        assertEquals(amount, dto.getAmount());
        assertEquals(paymentdate, dto.getPaymentDate());
        assertEquals(lastupdate, dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should set and get customer relationship correctly")
    public void testCustomerRelationship() {
        PaymentDTO dto = new PaymentDTO();
        CustomerDTO relatedDto = customer;
        dto.setCustomer(relatedDto);
        assertSame(relatedDto, dto.getCustomer());
    }

    @Test()
    @DisplayName("Should set and get rental relationship correctly")
    public void testRentalRelationship() {
        PaymentDTO dto = new PaymentDTO();
        RentalDTO relatedDto = rental;
        dto.setRental(relatedDto);
        assertSame(relatedDto, dto.getRental());
    }

    @Test()
    @DisplayName("Should set and get staff relationship correctly")
    public void testStaffRelationship() {
        PaymentDTO dto = new PaymentDTO();
        StaffDTO relatedDto = staff;
        dto.setStaff(relatedDto);
        assertSame(relatedDto, dto.getStaff());
    }
}
