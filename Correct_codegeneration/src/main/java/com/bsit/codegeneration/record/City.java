package com.bsit.codegeneration.record;

import java.util.List;

public record City(Integer cityID, String city, Integer countryID, java.time.LocalDateTime lastUpdate, Country country, List<Address> addresss) {

    public static class Builder {

        private Integer cityID;

        private String city;

        private Integer countryID;

        private java.time.LocalDateTime lastUpdate;

        private Country country;

        private List<Address> addresss;

        public Builder cityID(Integer cityID) {
            this.cityID = cityID;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder countryID(Integer countryID) {
            this.countryID = countryID;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder country(Country country) {
            this.country = country;
            return this;
        }

        public Builder addresss(List<Address> addresss) {
            this.addresss = addresss;
            return this;
        }

        public City build() {
            return new City(cityID, city, countryID, lastUpdate, country, addresss);
        }
    }
}
