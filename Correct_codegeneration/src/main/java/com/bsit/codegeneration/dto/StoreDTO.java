package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class StoreDTO {

    private AddressDTO address;

    private StaffDTO managerStaff;

    private Integer storeID;

    private Integer managerStaffID;

    private Integer addressID;

    private java.time.LocalDateTime lastUpdate;

    private List<CustomerDTO> customerList;

    private List<InventoryDTO> inventoryList;

    private List<StaffDTO> staffList;

    public StoreDTO() {
    }

    public StoreDTO(AddressDTO address, StaffDTO managerStaff, Integer storeID, Integer managerStaffID, Integer addressID, java.time.LocalDateTime lastUpdate) {
        this.address = address;
        this.managerStaff = managerStaff;
        this.storeID = storeID;
        this.managerStaffID = managerStaffID;
        this.addressID = addressID;
        this.lastUpdate = lastUpdate;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public StaffDTO getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(StaffDTO managerStaff) {
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

    public List<CustomerDTO> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerDTO> customerList) {
        this.customerList = customerList;
    }

    public List<InventoryDTO> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<InventoryDTO> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<StaffDTO> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<StaffDTO> staffList) {
        this.staffList = staffList;
    }

    public static class Builder {

        private StoreDTO instance = new StoreDTO();

        public Builder address(AddressDTO address) {
            instance.setAddress(address);
            return this;
        }

        public Builder managerStaff(StaffDTO managerStaff) {
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

        public Builder customerList(List<CustomerDTO> customerList) {
            instance.setCustomerList(customerList);
            return this;
        }

        public Builder inventoryList(List<InventoryDTO> inventoryList) {
            instance.setInventoryList(inventoryList);
            return this;
        }

        public Builder staffList(List<StaffDTO> staffList) {
            instance.setStaffList(staffList);
            return this;
        }

        public StoreDTO build() {
            return instance;
        }
    }
}
