package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class CityDTO {

    private CountryDTO country;

    private Integer cityID;

    private String city;

    private Integer countryID;

    private java.time.LocalDateTime lastUpdate;

    private List<AddressDTO> addressList;

    public CityDTO() {
    }

    public CityDTO(CountryDTO country, Integer cityID, String city, Integer countryID, java.time.LocalDateTime lastUpdate) {
        this.country = country;
        this.cityID = cityID;
        this.city = city;
        this.countryID = countryID;
        this.lastUpdate = lastUpdate;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
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

    public List<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDTO> addressList) {
        this.addressList = addressList;
    }

    public static class Builder {

        private CityDTO instance = new CityDTO();

        public Builder country(CountryDTO country) {
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

        public Builder addressList(List<AddressDTO> addressList) {
            instance.setAddressList(addressList);
            return this;
        }

        public CityDTO build() {
            return instance;
        }
    }
}
