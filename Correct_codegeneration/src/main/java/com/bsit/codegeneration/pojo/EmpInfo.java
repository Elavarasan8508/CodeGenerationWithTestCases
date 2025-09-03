package com.bsit.codegeneration.pojo;

import java.util.List;

public class EmpInfo {

    private Integer ID;

    private String name;

    private List<AddInfo> addInfoList;

    public EmpInfo() {
    }

    public EmpInfo(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddInfo> getAddInfoList() {
        return addInfoList;
    }

    public void setAddInfoList(List<AddInfo> addInfoList) {
        this.addInfoList = addInfoList;
    }

    public static class Builder {

        private EmpInfo instance = new EmpInfo();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder addInfoList(List<AddInfo> addInfoList) {
            instance.setAddInfoList(addInfoList);
            return this;
        }

        public EmpInfo build() {
            return instance;
        }
    }
}
