package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgModProductLink {

    private Integer ID;

    private Integer refID;

    private String typeCode;

    private String subTypeCode;

    private Integer childRefID;

    private String childTypeCode;

    private String childSubTypeCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private java.math.BigDecimal amount;

    private Double faceValue;

    private String discountPercentage;

    private String requestPercentage;

    private java.math.BigDecimal requestedAmount;

    private String programCode;

    private String offerCode;

    public FgModProductLink() {
    }

    public FgModProductLink(Integer ID, Integer refID, String typeCode, String subTypeCode, Integer childRefID, String childTypeCode, String childSubTypeCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, java.math.BigDecimal amount, Double faceValue, String discountPercentage, String requestPercentage, java.math.BigDecimal requestedAmount, String programCode, String offerCode) {
        this.ID = ID;
        this.refID = refID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.childRefID = childRefID;
        this.childTypeCode = childTypeCode;
        this.childSubTypeCode = childSubTypeCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.amount = amount;
        this.faceValue = faceValue;
        this.discountPercentage = discountPercentage;
        this.requestPercentage = requestPercentage;
        this.requestedAmount = requestedAmount;
        this.programCode = programCode;
        this.offerCode = offerCode;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getRefID() {
        return refID;
    }

    public void setRefID(Integer refID) {
        this.refID = refID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public Integer getChildRefID() {
        return childRefID;
    }

    public void setChildRefID(Integer childRefID) {
        this.childRefID = childRefID;
    }

    public String getChildTypeCode() {
        return childTypeCode;
    }

    public void setChildTypeCode(String childTypeCode) {
        this.childTypeCode = childTypeCode;
    }

    public String getChildSubTypeCode() {
        return childSubTypeCode;
    }

    public void setChildSubTypeCode(String childSubTypeCode) {
        this.childSubTypeCode = childSubTypeCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public Double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Double faceValue) {
        this.faceValue = faceValue;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getRequestPercentage() {
        return requestPercentage;
    }

    public void setRequestPercentage(String requestPercentage) {
        this.requestPercentage = requestPercentage;
    }

    public java.math.BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(java.math.BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public static class Builder {

        private FgModProductLink instance = new FgModProductLink();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder refID(Integer refID) {
            instance.setRefID(refID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder childRefID(Integer childRefID) {
            instance.setChildRefID(childRefID);
            return this;
        }

        public Builder childTypeCode(String childTypeCode) {
            instance.setChildTypeCode(childTypeCode);
            return this;
        }

        public Builder childSubTypeCode(String childSubTypeCode) {
            instance.setChildSubTypeCode(childSubTypeCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder amount(java.math.BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder faceValue(Double faceValue) {
            instance.setFaceValue(faceValue);
            return this;
        }

        public Builder discountPercentage(String discountPercentage) {
            instance.setDiscountPercentage(discountPercentage);
            return this;
        }

        public Builder requestPercentage(String requestPercentage) {
            instance.setRequestPercentage(requestPercentage);
            return this;
        }

        public Builder requestedAmount(java.math.BigDecimal requestedAmount) {
            instance.setRequestedAmount(requestedAmount);
            return this;
        }

        public Builder programCode(String programCode) {
            instance.setProgramCode(programCode);
            return this;
        }

        public Builder offerCode(String offerCode) {
            instance.setOfferCode(offerCode);
            return this;
        }

        public FgModProductLink build() {
            return instance;
        }
    }
}
