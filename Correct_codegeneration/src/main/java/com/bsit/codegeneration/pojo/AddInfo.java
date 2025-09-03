package com.bsit.codegeneration.pojo;

public class AddInfo {

    private Integer ID;

    private String address;

    private Integer employeeID;

    private EmpInfo employee;

    public AddInfo() {
    }

    public AddInfo(Integer ID, String address, Integer employeeID, EmpInfo employee) {
        this.ID = ID;
        this.address = address;
        this.employeeID = employeeID;
        this.employee = employee;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public EmpInfo getEmployee() {
        return employee;
    }

    public void setEmployee(EmpInfo employee) {
        this.employee = employee;
    }

    public static class Builder {

        private AddInfo instance = new AddInfo();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder employeeID(Integer employeeID) {
            instance.setEmployeeID(employeeID);
            return this;
        }

        public Builder employee(EmpInfo employee) {
            instance.setEmployee(employee);
            return this;
        }

        public AddInfo build() {
            return instance;
        }
    }
}
