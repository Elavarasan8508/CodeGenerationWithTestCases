package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InventoryTest {

    private static final Integer inventoryid = 10;

    private static final Integer filmid = 20;

    private static final Integer storeid = 30;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final Film film = null;

    private static final Store store = null;

    private static final List<Rental> rentals = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Inventory record = new Inventory(inventoryid, filmid, storeid, lastupdate, film, store, rentals);
        assertNotNull(record);
        assertEquals(inventoryid, record.inventoryID());
        assertEquals(filmid, record.filmID());
        assertEquals(storeid, record.storeID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(film, record.film());
        assertEquals(store, record.store());
        assertEquals(rentals, record.rentals());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Inventory record = new Inventory.Builder().inventoryID(inventoryid).filmID(filmid).storeID(storeid).lastUpdate(lastupdate).film(film).store(store).rentals(rentals).build();
        assertNotNull(record);
        assertEquals(inventoryid, record.inventoryID());
        assertEquals(filmid, record.filmID());
        assertEquals(storeid, record.storeID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(film, record.film());
        assertEquals(store, record.store());
        assertEquals(rentals, record.rentals());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Inventory record1 = new Inventory(inventoryid, filmid, storeid, lastupdate, film, store, rentals);
        Inventory record2 = new Inventory(inventoryid, filmid, storeid, lastupdate, film, store, rentals);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Inventory record = new Inventory(inventoryid, filmid, storeid, lastupdate, film, store, rentals);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Inventory"));
    }
}
