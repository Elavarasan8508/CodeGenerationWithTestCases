package com.bsit.codegeneration.record;

public record TestTable(Long ID, String longData) {

    public static class Builder {

        private Long ID;

        private String longData;

        public Builder ID(Long ID) {
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
