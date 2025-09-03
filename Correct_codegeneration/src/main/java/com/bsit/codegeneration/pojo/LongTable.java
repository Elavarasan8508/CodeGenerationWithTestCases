package com.bsit.codegeneration.pojo;

public class LongTable {

    private Integer ID;

    private String longColumn;

    public LongTable() {
    }

    public LongTable(Integer ID, String longColumn) {
        this.ID = ID;
        this.longColumn = longColumn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLongColumn() {
        return longColumn;
    }

    public void setLongColumn(String longColumn) {
        this.longColumn = longColumn;
    }

    public static class Builder {

        private LongTable instance = new LongTable();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder longColumn(String longColumn) {
            instance.setLongColumn(longColumn);
            return this;
        }

        public LongTable build() {
            return instance;
        }
    }
}
