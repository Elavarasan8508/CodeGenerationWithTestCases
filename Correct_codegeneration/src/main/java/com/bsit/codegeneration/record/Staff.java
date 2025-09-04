package com.bsit.codegeneration.record;

import java.util.List;

public record Staff(Integer staffID, String firstName, String lastName, Integer addressID, String email, Integer storeID, String active, String username, String password, java.time.LocalDateTime lastUpdate, String picture, Address address, Store store, List<Payment> payments, List<Rental> rentals) {

    public static class Builder {

        private Integer staffID;

        private String firstName;

        private String lastName;

        private Integer addressID;

        private String email;

        private Integer storeID;

        private String active;

        private String username;

        private String password;

        private java.time.LocalDateTime lastUpdate;

        private String picture;

        private Address address;

        private Store store;

        private List<Payment> payments;

        private List<Rental> rentals;

        public Builder staffID(Integer staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder addressID(Integer addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder storeID(Integer storeID) {
            this.storeID = storeID;
            return this;
        }

        public Builder active(String active) {
            this.active = active;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder picture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder store(Store store) {
            this.store = store;
            return this;
        }

        public Builder payments(List<Payment> payments) {
            this.payments = payments;
            return this;
        }

        public Builder rentals(List<Rental> rentals) {
            this.rentals = rentals;
            return this;
        }

        public Staff build() {
            return new Staff(staffID, firstName, lastName, addressID, email, storeID, active, username, password, lastUpdate, picture, address, store, payments, rentals);
        }
    }
}
