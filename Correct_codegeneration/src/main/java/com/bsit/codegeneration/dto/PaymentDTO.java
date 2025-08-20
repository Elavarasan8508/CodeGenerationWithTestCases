package com.bsit.codegeneration.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private CustomerDTO customer;

    private RentalDTO rental;

    private StaffDTO staff;

    private Integer paymentID;

    private Integer customerID;

    private Integer staffID;

    private Integer rentalID;

    private Float amount;

    private java.time.LocalDateTime paymentDate;

    private java.time.LocalDateTime lastUpdate;

    public PaymentDTO() {
    }

    public PaymentDTO(CustomerDTO customer, RentalDTO rental, StaffDTO staff, Integer paymentID, Integer customerID, Integer staffID, Integer rentalID, Float amount, java.time.LocalDateTime paymentDate, java.time.LocalDateTime lastUpdate) {
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public RentalDTO getRental() {
        return rental;
    }

    public void setRental(RentalDTO rental) {
        this.rental = rental;
    }

    public StaffDTO getStaff() {
        return staff;
    }

    public void setStaff(StaffDTO staff) {
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
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

        private PaymentDTO instance = new PaymentDTO();

        public Builder customer(CustomerDTO customer) {
            instance.setCustomer(customer);
            return this;
        }

        public Builder rental(RentalDTO rental) {
            instance.setRental(rental);
            return this;
        }

        public Builder staff(StaffDTO staff) {
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

        public Builder amount(Float amount) {
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

        public PaymentDTO build() {
            return instance;
        }
    }
}
