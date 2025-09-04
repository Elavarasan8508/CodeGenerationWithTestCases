package com.bsit.codegeneration.record;

import java.util.List;

public record Customer(Integer customerID, Integer storeID, String firstName, String lastName, String email, Integer addressID, String active, java.time.LocalDateTime createDate, java.time.LocalDateTime lastUpdate, Address address, Store store, List<Payment> payments, List<Rental> rentals) {

    public static class Builder {

        private Integer customerID;

        private Integer storeID;

        private String firstName;

        private String lastName;

        private String email;

        private Integer addressID;

        private String active;

        private java.time.LocalDateTime createDate;

        private java.time.LocalDateTime lastUpdate;

        private Address address;

        private Store store;

        private List<Payment> payments;

        private List<Rental> rentals;

        public Builder customerID(Integer customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder storeID(Integer storeID) {
            this.storeID = storeID;
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

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder addressID(Integer addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder active(String active) {
            this.active = active;
            return this;
        }

        public Builder createDate(java.time.LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
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

        public Customer build() {
            return new Customer(customerID, storeID, firstName, lastName, email, addressID, active, createDate, lastUpdate, address, store, payments, rentals);
        }
    }
}
