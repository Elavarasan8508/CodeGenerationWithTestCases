package com.bsit.codegeneration.record;

public record FgTdLiqView(String referenceID, String productStatus, String statusCode, String stageCode, String subTypeCode, String typeCode, String createdOn, String lastUpdatedOn, String processID) {

    public static class Builder {

        private String referenceID;

        private String productStatus;

        private String statusCode;

        private String stageCode;

        private String subTypeCode;

        private String typeCode;

        private String createdOn;

        private String lastUpdatedOn;

        private String processID;

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public FgTdLiqView build() {
            return new FgTdLiqView(referenceID, productStatus, statusCode, stageCode, subTypeCode, typeCode, createdOn, lastUpdatedOn, processID);
        }
    }
}
