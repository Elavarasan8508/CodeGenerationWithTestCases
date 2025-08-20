package com.bsit.codegeneration.record;

import java.util.List;

public record Country(Integer countryID, String country, java.time.LocalDateTime lastUpdate, List<City> citys) {

    public static class Builder {

        private Integer countryID;

        private String country;

        private java.time.LocalDateTime lastUpdate;

        private List<City> citys;

        public Builder countryID(Integer countryID) {
            this.countryID = countryID;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder citys(List<City> citys) {
            this.citys = citys;
            return this;
        }

        public Country build() {
            return new Country(countryID, country, lastUpdate, citys);
        }
    }
}
