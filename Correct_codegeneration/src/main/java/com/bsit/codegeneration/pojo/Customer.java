package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {

    private Address address;

    private Store store;

    private Payment customer;

    private Integer customerID;

    private Integer storeID;

    private String firstName;

    private String lastName;

    private String email;

    private Integer addressID;

    private Boolean active;

    private java.time.LocalDate createDate;

    private java.time.LocalDateTime lastUpdate;

    private List<Payment> paymentList;

    private List<Rental> rentalList;

    public Customer() {
    }

    public Customer(Address address, Store store, Payment customer, Integer customerID, Integer storeID, String firstName, String lastName, String email, Integer addressID, Boolean active, java.time.LocalDate createDate, java.time.LocalDateTime lastUpdate) {
        this.address = address;
        this.store = store;
        this.customer = customer;
        this.customerID = customerID;
        this.storeID = storeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressID = addressID;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
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

    public Payment getCustomer() {
        return customer;
    }

    public void setCustomer(Payment customer) {
        this.customer = customer;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public java.time.LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.time.LocalDate createDate) {
        this.createDate = createDate;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
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

    public static class Builder {

        private Customer instance = new Customer();

        public Builder address(Address address) {
            instance.setAddress(address);
            return this;
        }

        public Builder store(Store store) {
            instance.setStore(store);
            return this;
        }

        public Builder customer(Payment customer) {
            instance.setCustomer(customer);
            return this;
        }

        public Builder customerID(Integer customerID) {
            instance.setCustomerID(customerID);
            return this;
        }

        public Builder storeID(Integer storeID) {
            instance.setStoreID(storeID);
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

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder addressID(Integer addressID) {
            instance.setAddressID(addressID);
            return this;
        }

        public Builder active(Boolean active) {
            instance.setActive(active);
            return this;
        }

        public Builder createDate(java.time.LocalDate createDate) {
            instance.setCreateDate(createDate);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
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

        public Customer build() {
            return instance;
        }
    }
}
