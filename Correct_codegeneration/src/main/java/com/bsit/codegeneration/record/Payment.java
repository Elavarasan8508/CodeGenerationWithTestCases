package com.bsit.codegeneration.record;

import java.util.List;

public record Payment(Integer paymentID, Integer customerID, Integer staffID, Integer rentalID, Long amount, java.time.LocalDateTime paymentDate, java.time.LocalDateTime lastUpdate, Customer customer, Rental rental, Staff staff) {

    public static class Builder {

        private Integer paymentID;

        private Integer customerID;

        private Integer staffID;

        private Integer rentalID;

        private Long amount;

        private java.time.LocalDateTime paymentDate;

        private java.time.LocalDateTime lastUpdate;

        private Customer customer;

        private Rental rental;

        private Staff staff;

        public Builder paymentID(Integer paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder customerID(Integer customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder staffID(Integer staffID) {
            this.staffID = staffID;
            return this;
        }

        public Builder rentalID(Integer rentalID) {
            this.rentalID = rentalID;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder paymentDate(java.time.LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
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

        public Builder rental(Rental rental) {
            this.rental = rental;
            return this;
        }

        public Builder staff(Staff staff) {
            this.staff = staff;
            return this;
        }

        public Payment build() {
            return new Payment(paymentID, customerID, staffID, rentalID, amount, paymentDate, lastUpdate, customer, rental, staff);
        }
    }
}
