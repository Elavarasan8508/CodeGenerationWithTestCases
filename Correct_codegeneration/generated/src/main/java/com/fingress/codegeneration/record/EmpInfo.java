package com.bsit.codegeneration.record;

public record EmpInfo(Long ID, String name) {

    public static class Builder {

        private Long ID;

        private String name;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmpInfo build() {
            return new EmpInfo(ID, name);
        }
    }
}
