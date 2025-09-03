package com.bsit.codegeneration.pojo;

public class FgTdLiqView {

    private Integer referenceID;

    private String productStatus;

    private String statusCode;

    private String stageCode;

    private String subTypeCode;

    private String typeCode;

    private String createdOn;

    private String lastUpdatedOn;

    private Integer processID;

    public FgTdLiqView() {
    }

    public FgTdLiqView(Integer referenceID, String productStatus, String statusCode, String stageCode, String subTypeCode, String typeCode, String createdOn, String lastUpdatedOn, Integer processID) {
        this.referenceID = referenceID;
        this.productStatus = productStatus;
        this.statusCode = statusCode;
        this.stageCode = stageCode;
        this.subTypeCode = subTypeCode;
        this.typeCode = typeCode;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
        this.processID = processID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public static class Builder {

        private FgTdLiqView instance = new FgTdLiqView();

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder productStatus(String productStatus) {
            instance.setProductStatus(productStatus);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public FgTdLiqView build() {
            return instance;
        }
    }
}
