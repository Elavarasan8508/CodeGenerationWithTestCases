package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class AddressDTO {

    private CityDTO city;

    private StaffDTO managerStaff;

    private Integer addressID;

    private String address;

    private String address2;

    private String district;

    private Integer cityID;

    private String postalCode;

    private String phone;

    private java.time.LocalDateTime lastUpdate;

    private List<CustomerDTO> customerList;

    private List<StaffDTO> staffList;

    private List<StoreDTO> storeList;

    public AddressDTO() {
    }

    public AddressDTO(CityDTO city, String address, StaffDTO managerStaff, Integer addressID, String address2, String district, Integer cityID, String postalCode, String phone, java.time.LocalDateTime lastUpdate) {
        this.city = city;
        this.address = address;
        this.managerStaff = managerStaff;
        this.addressID = addressID;
        this.address2 = address2;
        this.district = district;
        this.cityID = cityID;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StaffDTO getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(StaffDTO managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<CustomerDTO> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerDTO> customerList) {
        this.customerList = customerList;
    }

    public List<StaffDTO> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<StaffDTO> staffList) {
        this.staffList = staffList;
    }

    public List<StoreDTO> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<StoreDTO> storeList) {
        this.storeList = storeList;
    }

    public static class Builder {

        private AddressDTO instance = new AddressDTO();

        public Builder city(CityDTO city) {
            instance.setCity(city);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder managerStaff(StaffDTO managerStaff) {
            instance.setManagerStaff(managerStaff);
            return this;
        }

        public Builder addressID(Integer addressID) {
            instance.setAddressID(addressID);
            return this;
        }

        public Builder address2(String address2) {
            instance.setAddress2(address2);
            return this;
        }

        public Builder district(String district) {
            instance.setDistrict(district);
            return this;
        }

        public Builder cityID(Integer cityID) {
            instance.setCityID(cityID);
            return this;
        }

        public Builder postalCode(String postalCode) {
            instance.setPostalCode(postalCode);
            return this;
        }

        public Builder phone(String phone) {
            instance.setPhone(phone);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder customerList(List<CustomerDTO> customerList) {
            instance.setCustomerList(customerList);
            return this;
        }

        public Builder staffList(List<StaffDTO> staffList) {
            instance.setStaffList(staffList);
            return this;
        }

        public Builder storeList(List<StoreDTO> storeList) {
            instance.setStoreList(storeList);
            return this;
        }

        public AddressDTO build() {
            return instance;
        }
    }
}
