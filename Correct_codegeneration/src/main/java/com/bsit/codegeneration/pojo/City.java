package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class City {

    private Country country;

    private Integer cityID;

    private String city;

    private Integer countryID;

    private java.time.LocalDateTime lastUpdate;

    private List<Address> addressList;

    public City() {
    }

    public City(Country country, Integer cityID, String city, Integer countryID, java.time.LocalDateTime lastUpdate) {
        this.country = country;
        this.cityID = cityID;
        this.city = city;
        this.countryID = countryID;
        this.lastUpdate = lastUpdate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public static class Builder {

        private City instance = new City();

        public Builder country(Country country) {
            instance.setCountry(country);
            return this;
        }

        public Builder cityID(Integer cityID) {
            instance.setCityID(cityID);
            return this;
        }

        public Builder city(String city) {
            instance.setCity(city);
            return this;
        }

        public Builder countryID(Integer countryID) {
            instance.setCountryID(countryID);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder addressList(List<Address> addressList) {
            instance.setAddressList(addressList);
            return this;
        }

        public City build() {
            return instance;
        }
    }
}
