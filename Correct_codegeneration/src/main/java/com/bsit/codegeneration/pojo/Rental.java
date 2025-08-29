package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Rental {

    private Customer customer;

    private Inventory inventory;

    private Staff staff;

    private Integer rentalID;

    private java.time.LocalDateTime rentalDate;

    private Integer inventoryID;

    private Integer customerID;

    private java.time.LocalDateTime returnDate;

    private Integer staffID;

    private java.time.LocalDateTime lastUpdate;

    private List<Payment> paymentList;

    public Rental() {
    }

    public Rental(Customer customer, Inventory inventory, Staff staff, Integer rentalID, java.time.LocalDateTime rentalDate, Integer inventoryID, Integer customerID, java.time.LocalDateTime returnDate, Integer staffID, java.time.LocalDateTime lastUpdate) {
        this.customer = customer;
        this.inventory = inventory;
        this.staff = staff;
        this.rentalID = rentalID;
        this.rentalDate = rentalDate;
        this.inventoryID = inventoryID;
        this.customerID = customerID;
        this.returnDate = returnDate;
        this.staffID = staffID;
        this.lastUpdate = lastUpdate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Integer getRentalID() {
        return rentalID;
    }

    public void setRentalID(Integer rentalID) {
        this.rentalID = rentalID;
    }

    public java.time.LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(java.time.LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public java.time.LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.time.LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
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

    public static class Builder {

        private Rental instance = new Rental();

        public Builder customer(Customer customer) {
            instance.setCustomer(customer);
            return this;
        }

        public Builder inventory(Inventory inventory) {
            instance.setInventory(inventory);
            return this;
        }

        public Builder staff(Staff staff) {
            instance.setStaff(staff);
            return this;
        }

        public Builder rentalID(Integer rentalID) {
            instance.setRentalID(rentalID);
            return this;
        }

        public Builder rentalDate(java.time.LocalDateTime rentalDate) {
            instance.setRentalDate(rentalDate);
            return this;
        }

        public Builder inventoryID(Integer inventoryID) {
            instance.setInventoryID(inventoryID);
            return this;
        }

        public Builder customerID(Integer customerID) {
            instance.setCustomerID(customerID);
            return this;
        }

        public Builder returnDate(java.time.LocalDateTime returnDate) {
            instance.setReturnDate(returnDate);
            return this;
        }

        public Builder staffID(Integer staffID) {
            instance.setStaffID(staffID);
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

        public Rental build() {
            return instance;
        }
    }
}
