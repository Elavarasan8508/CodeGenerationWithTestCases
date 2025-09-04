package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Inventory;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Film;
import com.bsit.codegeneration.pojo.Store;
import com.bsit.codegeneration.pojo.Rental;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryTest {

    private static final Integer inventoryid = 10;

    private static final Integer filmid = 20;

    private static final Integer storeid = 30;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final Film film = new Film();

    private static final Store store = new Store();

    private static final Rental inventory = new Rental();

    private static final List<Rental> rentallist = new ArrayList<>(Arrays.asList(new Rental()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Inventory obj = new Inventory();
        assertNotNull(obj);
        assertNull(obj.getInventoryID());
        assertNull(obj.getFilmID());
        assertNull(obj.getStoreID());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getFilm());
        assertNull(obj.getStore());
        assertNull(obj.getInventory());
        assertNull(obj.getRentalList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Inventory obj = new Inventory();
        obj.setInventoryID(inventoryid);
        assertEquals(inventoryid, obj.getInventoryID());
        obj.setFilmID(filmid);
        assertEquals(filmid, obj.getFilmID());
        obj.setStoreID(storeid);
        assertEquals(storeid, obj.getStoreID());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setFilm(film);
        assertEquals(film, obj.getFilm());
        obj.setStore(store);
        assertEquals(store, obj.getStore());
        obj.setInventory(inventory);
        assertEquals(inventory, obj.getInventory());
        obj.setRentalList(rentallist);
        assertEquals(rentallist, obj.getRentalList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Inventory obj = new Inventory(inventoryid, filmid, storeid, lastupdate, film, store, inventory);
        assertNotNull(obj);
        assertEquals(inventoryid, obj.getInventoryID());
        assertEquals(filmid, obj.getFilmID());
        assertEquals(storeid, obj.getStoreID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(film, obj.getFilm());
        assertEquals(store, obj.getStore());
        assertEquals(inventory, obj.getInventory());
        assertNull(obj.getRentalList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Inventory obj = new Inventory.Builder().inventoryID(inventoryid).filmID(filmid).storeID(storeid).lastUpdate(lastupdate).film(film).store(store).inventory(inventory).rentalList(rentallist).build();
        assertNotNull(obj);
        assertEquals(inventoryid, obj.getInventoryID());
        assertEquals(filmid, obj.getFilmID());
        assertEquals(storeid, obj.getStoreID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(film, obj.getFilm());
        assertEquals(store, obj.getStore());
        assertEquals(inventory, obj.getInventory());
        assertEquals(rentallist, obj.getRentalList());
    }

    @Test()
    @DisplayName("Should set and get film relationship correctly")
    public void testFilmRelationship() {
        Inventory obj = new Inventory();
        Film relatedObj = film;
        obj.setFilm(relatedObj);
        assertSame(relatedObj, obj.getFilm());
    }

    @Test()
    @DisplayName("Should set and get store relationship correctly")
    public void testStoreRelationship() {
        Inventory obj = new Inventory();
        Store relatedObj = store;
        obj.setStore(relatedObj);
        assertSame(relatedObj, obj.getStore());
    }

    @Test()
    @DisplayName("Should manage rentalList relationship correctly")
    public void testRentalListRelationship() {
        Inventory obj = new Inventory();
        List<Rental> relatedList = rentallist;
        obj.setRentalList(relatedList);
        assertNotNull(obj.getRentalList());
        assertEquals(relatedList, obj.getRentalList());
    }
}
