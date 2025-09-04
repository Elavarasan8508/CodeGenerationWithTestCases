package com.bsit.codegeneration.record;

import java.util.List;

public record Rental(Integer rentalID, java.time.LocalDateTime rentalDate, Integer inventoryID, Integer customerID, java.time.LocalDateTime returnDate, Integer staffID, java.time.LocalDateTime lastUpdate, Customer customer, Inventory inventory, Staff staff, List<Payment> payments) {

    public static class Builder {

        private Integer rentalID;

        private java.time.LocalDateTime rentalDate;

        private Integer inventoryID;

        private Integer customerID;

        private java.time.LocalDateTime returnDate;

        private Integer staffID;

        private java.time.LocalDateTime lastUpdate;

        private Customer customer;

        private Inventory inventory;

        private Staff staff;

        private List<Payment> payments;

        public Builder rentalID(Integer rentalID) {
            this.rentalID = rentalID;
            return this;
        }

        public Builder rentalDate(java.time.LocalDateTime rentalDate) {
            this.rentalDate = rentalDate;
            return this;
        }

        public Builder inventoryID(Integer inventoryID) {
            this.inventoryID = inventoryID;
            return this;
        }

        public Builder customerID(Integer customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder returnDate(java.time.LocalDateTime returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder staffID(Integer staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder inventory(Inventory inventory) {
            this.inventory = inventory;
            return this;
        }

        public Builder staff(Staff staff) {
            this.staff = staff;
            return this;
        }

        public Builder payments(List<Payment> payments) {
            this.payments = payments;
            return this;
        }

        public Rental build() {
            return new Rental(rentalID, rentalDate, inventoryID, customerID, returnDate, staffID, lastUpdate, customer, inventory, staff, payments);
        }
    }
}
