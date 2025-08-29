package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Inventory {

    private Film film;

    private Store store;

    private Rental inventory;

    private Integer inventoryID;

    private Integer filmID;

    private Integer storeID;

    private java.time.LocalDateTime lastUpdate;

    private List<Rental> rentalList;

    public Inventory() {
    }

    public Inventory(Film film, Store store, Rental inventory, Integer inventoryID, Integer filmID, Integer storeID, java.time.LocalDateTime lastUpdate) {
        this.film = film;
        this.store = store;
        this.inventory = inventory;
        this.inventoryID = inventoryID;
        this.filmID = filmID;
        this.storeID = storeID;
        this.lastUpdate = lastUpdate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Rental getInventory() {
        return inventory;
    }

    public void setInventory(Rental inventory) {
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

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public static class Builder {

        private Inventory instance = new Inventory();

        public Builder film(Film film) {
            instance.setFilm(film);
            return this;
        }

        public Builder store(Store store) {
            instance.setStore(store);
            return this;
        }

        public Builder inventory(Rental inventory) {
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

        public Builder rentalList(List<Rental> rentalList) {
            instance.setRentalList(rentalList);
            return this;
        }

        public Inventory build() {
            return instance;
        }
    }
}
