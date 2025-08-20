package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class InventoryDTO {

    private FilmDTO film;

    private StoreDTO store;

    private RentalDTO inventory;

    private Integer inventoryID;

    private Integer filmID;

    private Integer storeID;

    private java.time.LocalDateTime lastUpdate;

    private List<RentalDTO> rentalList;

    public InventoryDTO() {
    }

    public InventoryDTO(FilmDTO film, StoreDTO store, RentalDTO inventory, Integer inventoryID, Integer filmID, Integer storeID, java.time.LocalDateTime lastUpdate) {
        this.film = film;
        this.store = store;
        this.inventory = inventory;
        this.inventoryID = inventoryID;
        this.filmID = filmID;
        this.storeID = storeID;
        this.lastUpdate = lastUpdate;
    }

    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
        this.film = film;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public RentalDTO getInventory() {
        return inventory;
    }

    public void setInventory(RentalDTO inventory) {
        this.inventory = inventory;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<RentalDTO> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<RentalDTO> rentalList) {
        this.rentalList = rentalList;
    }

    public static class Builder {

        private InventoryDTO instance = new InventoryDTO();

        public Builder film(FilmDTO film) {
            instance.setFilm(film);
            return this;
        }

        public Builder store(StoreDTO store) {
            instance.setStore(store);
            return this;
        }

        public Builder inventory(RentalDTO inventory) {
            instance.setInventory(inventory);
            return this;
        }

        public Builder inventoryID(Integer inventoryID) {
            instance.setInventoryID(inventoryID);
            return this;
        }

        public Builder filmID(Integer filmID) {
            instance.setFilmID(filmID);
            return this;
        }

        public Builder storeID(Integer storeID) {
            instance.setStoreID(storeID);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder rentalList(List<RentalDTO> rentalList) {
            instance.setRentalList(rentalList);
            return this;
        }

        public InventoryDTO build() {
            return instance;
        }
    }
}
