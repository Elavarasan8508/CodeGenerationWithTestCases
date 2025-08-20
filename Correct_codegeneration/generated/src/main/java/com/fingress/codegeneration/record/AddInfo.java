package com.bsit.codegeneration.record;

public record AddInfo(Long ID, String address, Long employeeID) {

    public static class Builder {

        private Long ID;

        private String address;

        private Long employeeID;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder employeeID(Long employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public AddInfo build() {
            return new AddInfo(ID, address, employeeID);
        }
    }
}
