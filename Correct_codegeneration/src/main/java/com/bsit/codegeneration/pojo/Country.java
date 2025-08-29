package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Country {

    private Integer countryID;

    private String country;

    private java.time.LocalDateTime lastUpdate;

    private List<City> cityList;

    public Country() {
    }

    public Country(Integer countryID, String country, java.time.LocalDateTime lastUpdate) {
        this.countryID = countryID;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public static class Builder {

        private Country instance = new Country();

        public Builder countryID(Integer countryID) {
            instance.setCountryID(countryID);
            return this;
        }

        public Builder country(String country) {
            instance.setCountry(country);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder cityList(List<City> cityList) {
            instance.setCityList(cityList);
            return this;
        }

        public Country build() {
            return instance;
        }
    }
}
