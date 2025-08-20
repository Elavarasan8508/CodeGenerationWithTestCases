package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.CustomerDTO;
import com.bsit.codegeneration.dto.AddressDTO;
import com.bsit.codegeneration.dto.StoreDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.PaymentDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.dto.RentalDTO;

public class CustomerDTOTest {

    private static final AddressDTO address = new AddressDTO();

    private static final StoreDTO store = new StoreDTO();

    private static final CustomerDTO customer = new CustomerDTO();

    private static final Integer customerid = 40;

    private static final Integer storeid = 50;

    private static final String firstname = "Test Name 6";

    private static final String lastname = "Test Name 7";

    private static final String email = "test8@example.com";

    private static final Integer addressid = 90;

    private static final String active = "TestValue10";

    private static final java.time.LocalDateTime createdate = LocalDateTime.of(2023, 11, 11, 10, 30, 0);

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 1, 12, 10, 30, 0);

    private static final List<PaymentDTO> paymentlist = new ArrayList<>(Arrays.asList(new PaymentDTO()));

    private static final List<RentalDTO> rentallist = new ArrayList<>(Arrays.asList(new RentalDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        CustomerDTO dto = new CustomerDTO();
        assertNotNull(dto);
        assertNull(dto.getAddress());
        assertNull(dto.getStore());
        assertNull(dto.getCustomer());
        assertNull(dto.getCustomerID());
        assertNull(dto.getStoreID());
        assertNull(dto.getFirstName());
        assertNull(dto.getLastName());
        assertNull(dto.getEmail());
        assertNull(dto.getAddressID());
        assertNull(dto.getActive());
        assertNull(dto.getCreateDate());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getPaymentList());
        assertNull(dto.getRentalList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        CustomerDTO dto = new CustomerDTO();
        dto.setAddress(address);
        assertEquals(address, dto.getAddress());
        dto.setStore(store);
        assertEquals(store, dto.getStore());
        dto.setCustomer(customer);
        assertEquals(customer, dto.getCustomer());
        dto.setCustomerID(customerid);
        assertEquals(customerid, dto.getCustomerID());
        dto.setStoreID(storeid);
        assertEquals(storeid, dto.getStoreID());
        dto.setFirstName(firstname);
        assertEquals(firstname, dto.getFirstName());
        dto.setLastName(lastname);
        assertEquals(lastname, dto.getLastName());
        dto.setEmail(email);
        assertEquals(email, dto.getEmail());
        dto.setAddressID(addressid);
        assertEquals(addressid, dto.getAddressID());
        dto.setActive(active);
        assertEquals(active, dto.getActive());
        dto.setCreateDate(createdate);
        assertEquals(createdate, dto.getCreateDate());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setPaymentList(paymentlist);
        assertEquals(paymentlist, dto.getPaymentList());
        dto.setRentalList(rentallist);
        assertEquals(rentallist, dto.getRentalList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        CustomerDTO dto = new CustomerDTO(address, store, customer, customerid, storeid, firstname, lastname, email, addressid, active, createdate, lastupdate);
        assertNotNull(dto);
        assertEquals(address, dto.getAddress());
        assertEquals(store, dto.getStore());
        assertEquals(customer, dto.getCustomer());
        assertEquals(customerid, dto.getCustomerID());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(firstname, dto.getFirstName());
        assertEquals(lastname, dto.getLastName());
        assertEquals(email, dto.getEmail());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(active, dto.getActive());
        assertEquals(createdate, dto.getCreateDate());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getPaymentList());
        assertNull(dto.getRentalList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        CustomerDTO dto = new CustomerDTO.Builder().address(address).store(store).customer(customer).customerID(customerid).storeID(storeid).firstName(firstname).lastName(lastname).email(email).addressID(addressid).active(active).createDate(createdate).lastUpdate(lastupdate).paymentList(paymentlist).rentalList(rentallist).build();
        assertNotNull(dto);
        assertEquals(address, dto.getAddress());
        assertEquals(store, dto.getStore());
        assertEquals(customer, dto.getCustomer());
        assertEquals(customerid, dto.getCustomerID());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(firstname, dto.getFirstName());
        assertEquals(lastname, dto.getLastName());
        assertEquals(email, dto.getEmail());
        assertEquals(addressid, dto.getAddressID());
        assertEquals(active, dto.getActive());
        assertEquals(createdate, dto.getCreateDate());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(paymentlist, dto.getPaymentList());
        assertEquals(rentallist, dto.getRentalList());
    }

    @Test()
    @DisplayName("Should set and get address relationship correctly")
    public void testAddressRelationship() {
        CustomerDTO dto = new CustomerDTO();
        AddressDTO relatedDto = address;
        dto.setAddress(relatedDto);
        assertSame(relatedDto, dto.getAddress());
    }

    @Test()
    @DisplayName("Should set and get store relationship correctly")
    public void testStoreRelationship() {
        CustomerDTO dto = new CustomerDTO();
        StoreDTO relatedDto = store;
        dto.setStore(relatedDto);
        assertSame(relatedDto, dto.getStore());
    }

    @Test()
    @DisplayName("Should manage paymentList relationship correctly")
    public void testPaymentListRelationship() {
        CustomerDTO dto = new CustomerDTO();
        List<PaymentDTO> relatedList = paymentlist;
        dto.setPaymentList(relatedList);
        assertNotNull(dto.getPaymentList());
        assertEquals(relatedList, dto.getPaymentList());
    }

    @Test()
    @DisplayName("Should manage rentalList relationship correctly")
    public void testRentalListRelationship() {
        CustomerDTO dto = new CustomerDTO();
        List<RentalDTO> relatedList = rentallist;
        dto.setRentalList(relatedList);
        assertNotNull(dto.getRentalList());
        assertEquals(relatedList, dto.getRentalList());
    }
}
