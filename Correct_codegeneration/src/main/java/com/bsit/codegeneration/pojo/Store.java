package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Store {

    private Address address;

    private Staff managerStaff;

    private Integer storeID;

    private Integer managerStaffID;

    private Integer addressID;

    private java.time.LocalDateTime lastUpdate;

    private List<Customer> customerList;

    private List<Inventory> inventoryList;

    private List<Staff> staffList;

    public Store() {
    }

    public Store(Address address, Staff managerStaff, Integer storeID, Integer managerStaffID, Integer addressID, java.time.LocalDateTime lastUpdate) {
        this.address = address;
        this.managerStaff = managerStaff;
        this.storeID = storeID;
        this.managerStaffID = managerStaffID;
        this.addressID = addressID;
        this.lastUpdate = lastUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Integer getStoreID() {
        return storeID;
    }

    public void setStoreID(Integer storeID) {
        this.storeID = storeID;
    }

    public Integer getManagerStaffID() {
        return managerStaffID;
    }

    public void setManagerStaffID(Integer managerStaffID) {
        this.managerStaffID = managerStaffID;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public static class Builder {

        private Store instance = new Store();

        public Builder address(Address address) {
            instance.setAddress(address);
            return this;
        }

        public Builder managerStaff(Staff managerStaff) {
            instance.setManagerStaff(managerStaff);
            return this;
        }

        public Builder storeID(Integer storeID) {
            instance.setStoreID(storeID);
            return this;
        }

        public Builder managerStaffID(Integer managerStaffID) {
            instance.setManagerStaffID(managerStaffID);
            return this;
        }

        public Builder addressID(Integer addressID) {
            instance.setAddressID(addressID);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder customerList(List<Customer> customerList) {
            instance.setCustomerList(customerList);
            return this;
        }

        public Builder inventoryList(List<Inventory> inventoryList) {
            instance.setInventoryList(inventoryList);
            return this;
        }

        public Builder staffList(List<Staff> staffList) {
            instance.setStaffList(staffList);
            return this;
        }

        public Store build() {
            return instance;
        }
    }
}
