package com.bsit.codegeneration.record;

import java.util.List;

public record Inventory(Integer inventoryID, Integer filmID, Integer storeID, java.time.LocalDateTime lastUpdate, Film film, Store store, List<Rental> rentals) {

    public static class Builder {

        private Integer inventoryID;

        private Integer filmID;

        private Integer storeID;

        private java.time.LocalDateTime lastUpdate;

        private Film film;

        private Store store;

        private List<Rental> rentals;

        public Builder inventoryID(Integer inventoryID) {
            this.inventoryID = inventoryID;
            return this;
        }

        public Builder filmID(Integer filmID) {
            this.filmID = filmID;
            return this;
        }

        public Builder storeID(Integer storeID) {
            this.storeID = storeID;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder film(Film film) {
            this.film = film;
            return this;
        }

        public Builder store(Store store) {
            this.store = store;
            return this;
        }

        public Builder rentals(List<Rental> rentals) {
            this.rentals = rentals;
            return this;
        }

        public Inventory build() {
            return new Inventory(inventoryID, filmID, storeID, lastUpdate, film, store, rentals);
        }
    }
}
