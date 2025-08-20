package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.InventoryDTO;
import com.bsit.codegeneration.dto.FilmDTO;
import com.bsit.codegeneration.dto.StoreDTO;
import com.bsit.codegeneration.dto.RentalDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryDTOTest {

    private static final FilmDTO film = new FilmDTO();

    private static final StoreDTO store = new StoreDTO();

    private static final RentalDTO inventory = new RentalDTO();

    private static final Integer inventoryid = 40;

    private static final Integer filmid = 50;

    private static final Integer storeid = 60;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 7, 7, 10, 30, 0);

    private static final List<RentalDTO> rentallist = new ArrayList<>(Arrays.asList(new RentalDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        InventoryDTO dto = new InventoryDTO();
        assertNotNull(dto);
        assertNull(dto.getFilm());
        assertNull(dto.getStore());
        assertNull(dto.getInventory());
        assertNull(dto.getInventoryID());
        assertNull(dto.getFilmID());
        assertNull(dto.getStoreID());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getRentalList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        InventoryDTO dto = new InventoryDTO();
        dto.setFilm(film);
        assertEquals(film, dto.getFilm());
        dto.setStore(store);
        assertEquals(store, dto.getStore());
        dto.setInventory(inventory);
        assertEquals(inventory, dto.getInventory());
        dto.setInventoryID(inventoryid);
        assertEquals(inventoryid, dto.getInventoryID());
        dto.setFilmID(filmid);
        assertEquals(filmid, dto.getFilmID());
        dto.setStoreID(storeid);
        assertEquals(storeid, dto.getStoreID());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setRentalList(rentallist);
        assertEquals(rentallist, dto.getRentalList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        InventoryDTO dto = new InventoryDTO(film, store, inventory, inventoryid, filmid, storeid, lastupdate);
        assertNotNull(dto);
        assertEquals(film, dto.getFilm());
        assertEquals(store, dto.getStore());
        assertEquals(inventory, dto.getInventory());
        assertEquals(inventoryid, dto.getInventoryID());
        assertEquals(filmid, dto.getFilmID());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getRentalList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        InventoryDTO dto = new InventoryDTO.Builder().film(film).store(store).inventory(inventory).inventoryID(inventoryid).filmID(filmid).storeID(storeid).lastUpdate(lastupdate).rentalList(rentallist).build();
        assertNotNull(dto);
        assertEquals(film, dto.getFilm());
        assertEquals(store, dto.getStore());
        assertEquals(inventory, dto.getInventory());
        assertEquals(inventoryid, dto.getInventoryID());
        assertEquals(filmid, dto.getFilmID());
        assertEquals(storeid, dto.getStoreID());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(rentallist, dto.getRentalList());
    }

    @Test()
    @DisplayName("Should set and get film relationship correctly")
    public void testFilmRelationship() {
        InventoryDTO dto = new InventoryDTO();
        FilmDTO relatedDto = film;
        dto.setFilm(relatedDto);
        assertSame(relatedDto, dto.getFilm());
    }

    @Test()
    @DisplayName("Should set and get store relationship correctly")
    public void testStoreRelationship() {
        InventoryDTO dto = new InventoryDTO();
        StoreDTO relatedDto = store;
        dto.setStore(relatedDto);
        assertSame(relatedDto, dto.getStore());
    }

    @Test()
    @DisplayName("Should manage rentalList relationship correctly")
    public void testRentalListRelationship() {
        InventoryDTO dto = new InventoryDTO();
        List<RentalDTO> relatedList = rentallist;
        dto.setRentalList(relatedList);
        assertNotNull(dto.getRentalList());
        assertEquals(relatedList, dto.getRentalList());
    }
}
