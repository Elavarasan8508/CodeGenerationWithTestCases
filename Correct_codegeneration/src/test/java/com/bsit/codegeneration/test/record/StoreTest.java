package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    private static final Integer storeid = 10;

    private static final Integer managerstaffid = 20;

    private static final Integer addressid = 30;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final Address address = null;

    private static final Staff staff = null;

    private static final List<Customer> customers = new ArrayList<>();

    private static final List<Inventory> inventorys = new ArrayList<>();
    

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Store record = new Store(storeid, managerstaffid, addressid, lastupdate, address, staff, customers, inventorys);
        assertNotNull(record);
        assertEquals(storeid, record.storeID());
        assertEquals(managerstaffid, record.managerStaffID());
        assertEquals(addressid, record.addressID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(address, record.address());
        assertEquals(staff, record.staff());
        assertEquals(customers, record.customers());
        assertEquals(inventorys, record.inventorys());

    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Store record = new Store.Builder().storeID(storeid).managerStaffID(managerstaffid).addressID(addressid).lastUpdate(lastupdate).address(address).staff(staff).customers(customers).inventorys(inventorys).build();
        assertNotNull(record);
        assertEquals(storeid, record.storeID());
        assertEquals(managerstaffid, record.managerStaffID());
        assertEquals(addressid, record.addressID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(address, record.address());
        assertEquals(staff, record.staff());
        assertEquals(customers, record.customers());
        assertEquals(inventorys, record.inventorys());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Store record1 = new Store(storeid, managerstaffid, addressid, lastupdate, address, staff, customers, inventorys);
        Store record2 = new Store(storeid, managerstaffid, addressid, lastupdate, address, staff, customers, inventorys);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Store record = new Store(storeid, managerstaffid, addressid, lastupdate, address, staff, customers, inventorys);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Store"));
    }
}
