package com.bsit.codegeneration.record;

import java.util.List;

public record FgTempDataHolder(Integer referenceID, String tableName) {

    public static class Builder {

        private Integer referenceID;

        private String tableName;

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public FgTempDataHolder build() {
            return new FgTempDataHolder(referenceID, tableName);
        }
    }
}
