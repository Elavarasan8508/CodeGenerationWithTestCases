package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Staff {

    private Address address;

    private Store store;

    private Store managerStaff;

    private Integer staffID;

    private String firstName;

    private String lastName;

    private Integer addressID;

    private String email;

    private Integer storeID;

    private Boolean active;

    private String username;

    private String password;

    private java.time.LocalDateTime lastUpdate;

    private String picture;

    private List<Payment> paymentList;

    private List<Rental> rentalList;

    private List<Store> storeList;

    public Staff() {
    }

    public Staff(Address address, Store store, Store managerStaff, Integer staffID, String firstName, String lastName, Integer addressID, String email, Integer storeID, Boolean active, String username, String password, java.time.LocalDateTime lastUpdate, String picture) {
        this.address = address;
        this.store = store;
        this.managerStaff = managerStaff;
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressID = addressID;
        this.email = email;
        this.storeID = storeID;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.picture = picture;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Store managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public static class Builder {

        private Staff instance = new Staff();

        public Builder address(Address address) {
            instance.setAddress(address);
            return this;
        }

        public Builder store(Store store) {
            instance.setStore(store);
            return this;
        }

        public Builder managerStaff(Store managerStaff) {
            instance.setManagerStaff(managerStaff);
            return this;
        }

        public Builder staffID(Integer staffID) {
            instance.setStaffID(staffID);
            return this;
        }

        public Builder firstName(String firstName) {
            instance.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            instance.setLastName(lastName);
            return this;
        }

        public Builder addressID(Integer addressID) {
            instance.setAddressID(addressID);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder storeID(Integer storeID) {
            instance.setStoreID(storeID);
            return this;
        }

        public Builder active(Boolean active) {
            instance.setActive(active);
            return this;
        }

        public Builder username(String username) {
            instance.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            instance.setPassword(password);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder picture(String picture) {
            instance.setPicture(picture);
            return this;
        }

        public Builder paymentList(List<Payment> paymentList) {
            instance.setPaymentList(paymentList);
            return this;
        }

        public Builder rentalList(List<Rental> rentalList) {
            instance.setRentalList(rentalList);
            return this;
        }

        public Builder storeList(List<Store> storeList) {
            instance.setStoreList(storeList);
            return this;
        }

        public Staff build() {
            return instance;
        }
    }
}
