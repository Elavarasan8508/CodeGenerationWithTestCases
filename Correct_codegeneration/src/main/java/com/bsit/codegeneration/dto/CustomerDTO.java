package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class CustomerDTO {

    private AddressDTO address;

    private StoreDTO store;

    private CustomerDTO customer;

    private Integer customerID;

    private Integer storeID;

    private String firstName;

    private String lastName;

    private String email;

    private Integer addressID;

    private String active;

    private java.time.LocalDateTime createDate;

    private java.time.LocalDateTime lastUpdate;

    private List<PaymentDTO> paymentList;

    private List<RentalDTO> rentalList;

    public CustomerDTO() {
    }

    public CustomerDTO(AddressDTO address, StoreDTO store, CustomerDTO customer, Integer customerID, Integer storeID, String firstName, String lastName, String email, Integer addressID, String active, java.time.LocalDateTime createDate, java.time.LocalDateTime lastUpdate) {
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public java.time.LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.time.LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<PaymentDTO> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<PaymentDTO> paymentList) {
        this.paymentList = paymentList;
    }

    public List<RentalDTO> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<RentalDTO> rentalList) {
        this.rentalList = rentalList;
    }

    public static class Builder {

        private CustomerDTO instance = new CustomerDTO();

        public Builder address(AddressDTO address) {
            instance.setAddress(address);
            return this;
        }

        public Builder store(StoreDTO store) {
            instance.setStore(store);
            return this;
        }

        public Builder customer(CustomerDTO customer) {
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

        public Builder active(String active) {
            instance.setActive(active);
            return this;
        }

        public Builder createDate(java.time.LocalDateTime createDate) {
            instance.setCreateDate(createDate);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder paymentList(List<PaymentDTO> paymentList) {
            instance.setPaymentList(paymentList);
            return this;
        }

        public Builder rentalList(List<RentalDTO> rentalList) {
            instance.setRentalList(rentalList);
            return this;
        }

        public CustomerDTO build() {
            return instance;
        }
    }
}
