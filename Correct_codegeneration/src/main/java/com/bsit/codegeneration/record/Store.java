package com.bsit.codegeneration.record;

import java.util.List;

public record Store(Integer storeID, Integer managerStaffID, Integer addressID, java.time.LocalDateTime lastUpdate, Address address, Staff staff, List<Customer> customers, List<Inventory> inventorys) {

    public static class Builder {

        private Integer storeID;

        private Integer managerStaffID;

        private Integer addressID;

        private java.time.LocalDateTime lastUpdate;

        private Address address;

        private Staff staff;

        private List<Customer> customers;

        private List<Inventory> inventorys;

        public Builder storeID(Integer storeID) {
            this.storeID = storeID;
            return this;
        }

        public Builder managerStaffID(Integer managerStaffID) {
            this.managerStaffID = managerStaffID;
            return this;
        }

        public Builder addressID(Integer addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder staff(Staff staff) {
            this.staff = staff;
            return this;
        }

        public Builder customers(List<Customer> customers) {
            this.customers = customers;
            return this;
        }

        public Builder inventorys(List<Inventory> inventorys) {
            this.inventorys = inventorys;
            return this;
        }

        public Store build() {
            return new Store(storeID, managerStaffID, addressID, lastUpdate, address, staff, customers, inventorys);
        }
    }
}
