package com.bsit.codegeneration.record;

import java.util.List;

public record EmpInfo(Integer ID, String name, List<AddInfo> addInfos) {

    public static class Builder {

        private Integer ID;

        private String name;

        private List<AddInfo> addInfos;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder addInfos(List<AddInfo> addInfos) {
            this.addInfos = addInfos;
            return this;
        }

        public EmpInfo build() {
            return new EmpInfo(ID, name, addInfos);
        }
    }
}
