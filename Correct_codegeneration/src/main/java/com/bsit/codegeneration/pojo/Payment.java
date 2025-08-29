package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Customer customer;

    private Rental rental;

    private Staff staff;

    private Integer paymentID;

    private Integer customerID;

    private Integer staffID;

    private Integer rentalID;

    private java.math.BigDecimal amount;

    private java.time.LocalDateTime paymentDate;

    private java.time.LocalDateTime lastUpdate;

    public Payment() {
    }

    public Payment(Customer customer, Rental rental, Staff staff, Integer paymentID, Integer customerID, Integer staffID, Integer rentalID, java.math.BigDecimal amount, java.time.LocalDateTime paymentDate, java.time.LocalDateTime lastUpdate) {
        this.customer = customer;
        this.rental = rental;
        this.staff = staff;
        this.paymentID = paymentID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.rentalID = rentalID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public Integer getRentalID() {
        return rentalID;
    }

    public void setRentalID(Integer rentalID) {
        this.rentalID = rentalID;
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public java.time.LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(java.time.LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public static class Builder {

        private Payment instance = new Payment();

        public Builder customer(Customer customer) {
            instance.setCustomer(customer);
            return this;
        }

        public Builder rental(Rental rental) {
            instance.setRental(rental);
            return this;
        }

        public Builder staff(Staff staff) {
            instance.setStaff(staff);
            return this;
        }

        public Builder paymentID(Integer paymentID) {
            instance.setPaymentID(paymentID);
            return this;
        }

        public Builder customerID(Integer customerID) {
            instance.setCustomerID(customerID);
            return this;
        }

        public Builder staffID(Integer staffID) {
            instance.setStaffID(staffID);
            return this;
        }

        public Builder rentalID(Integer rentalID) {
            instance.setRentalID(rentalID);
            return this;
        }

        public Builder amount(java.math.BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder paymentDate(java.time.LocalDateTime paymentDate) {
            instance.setPaymentDate(paymentDate);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Payment build() {
            return instance;
        }
    }
}
