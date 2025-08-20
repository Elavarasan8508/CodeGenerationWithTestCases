package com.bsit.codegeneration.record;

import java.util.List;

public record Address(Integer addressID, String address, String address2, String district, Integer cityID, String postalCode, String phone, java.time.LocalDateTime lastUpdate, City city, List<Customer> customers, List<Staff> staffs, List<Store> stores) {

    public static class Builder {

        private Integer addressID;

        private String address;

        private String address2;

        private String district;

        private Integer cityID;

        private String postalCode;

        private String phone;

        private java.time.LocalDateTime lastUpdate;

        private City city;

        private List<Customer> customers;

        private List<Staff> staffs;

        private List<Store> stores;

        public Builder addressID(Integer addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder cityID(Integer cityID) {
            this.cityID = cityID;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public Builder customers(List<Customer> customers) {
            this.customers = customers;
            return this;
        }

        public Builder staffs(List<Staff> staffs) {
            this.staffs = staffs;
            return this;
        }

        public Builder stores(List<Store> stores) {
            this.stores = stores;
            return this;
        }

        public Address build() {
            return new Address(addressID, address, address2, district, cityID, postalCode, phone, lastUpdate, city, customers, staffs, stores);
        }
    }
}
