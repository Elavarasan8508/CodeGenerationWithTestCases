package com.bsit.codegeneration.pojo;

public class FgTempDataHolder {

    private Integer referenceID;

    private String tableName;

    public FgTempDataHolder() {
    }

    public FgTempDataHolder(Integer referenceID, String tableName) {
        this.referenceID = referenceID;
        this.tableName = tableName;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public static class Builder {

        private FgTempDataHolder instance = new FgTempDataHolder();

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder tableName(String tableName) {
            instance.setTableName(tableName);
            return this;
        }

        public FgTempDataHolder build() {
            return instance;
        }
    }
}
