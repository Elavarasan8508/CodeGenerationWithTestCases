package com.bsit.codegeneration.record;

import java.util.List;

public record AddInfo(Integer ID, String address, Integer employeeID, EmpInfo empInfo) {

    public static class Builder {

        private Integer ID;

        private String address;

        private Integer employeeID;

        private EmpInfo empInfo;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder employeeID(Integer employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder empInfo(EmpInfo empInfo) {
            this.empInfo = empInfo;
            return this;
        }

        public AddInfo build() {
            return new AddInfo(ID, address, employeeID, empInfo);
        }
    }
}
