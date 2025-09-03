package com.bsit.codegeneration.pojo;

public class TestTable {

    private Integer ID;

    private String longData;

    public TestTable() {
    }

    public TestTable(Integer ID, String longData) {
        this.ID = ID;
        this.longData = longData;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLongData() {
        return longData;
    }

    public void setLongData(String longData) {
        this.longData = longData;
    }

    public static class Builder {

        private TestTable instance = new TestTable();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder longData(String longData) {
            instance.setLongData(longData);
            return this;
        }

        public TestTable build() {
            return instance;
        }
    }
}
