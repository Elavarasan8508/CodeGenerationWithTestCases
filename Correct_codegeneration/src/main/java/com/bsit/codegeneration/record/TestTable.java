package com.bsit.codegeneration.record;

import java.util.List;

public record TestTable(Integer ID, String longData) {

    public static class Builder {

        private Integer ID;

        private String longData;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder longData(String longData) {
            this.longData = longData;
            return this;
        }

        public TestTable build() {
            return new TestTable(ID, longData);
        }
    }
}
