package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgModTagRel {

    private Integer ID;

    private String tagReferenceNo;

    private String targetEntityTypeCode;

    private String targetEntitySubTypeCode;

    private String targetEntityRefNo;

    private java.math.BigDecimal targetEntityVersionid;

    private java.math.BigDecimal createdBy;

    private String createdOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    public FgModTagRel() {
    }

    public FgModTagRel(Integer ID, String tagReferenceNo, String targetEntityTypeCode, String targetEntitySubTypeCode, String targetEntityRefNo, java.math.BigDecimal targetEntityVersionid, java.math.BigDecimal createdBy, String createdOn, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn) {
        this.ID = ID;
        this.tagReferenceNo = tagReferenceNo;
        this.targetEntityTypeCode = targetEntityTypeCode;
        this.targetEntitySubTypeCode = targetEntitySubTypeCode;
        this.targetEntityRefNo = targetEntityRefNo;
        this.targetEntityVersionid = targetEntityVersionid;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTagReferenceNo() {
        return tagReferenceNo;
    }

    public void setTagReferenceNo(String tagReferenceNo) {
        this.tagReferenceNo = tagReferenceNo;
    }

    public String getTargetEntityTypeCode() {
        return targetEntityTypeCode;
    }

    public void setTargetEntityTypeCode(String targetEntityTypeCode) {
        this.targetEntityTypeCode = targetEntityTypeCode;
    }

    public String getTargetEntitySubTypeCode() {
        return targetEntitySubTypeCode;
    }

    public void setTargetEntitySubTypeCode(String targetEntitySubTypeCode) {
        this.targetEntitySubTypeCode = targetEntitySubTypeCode;
    }

    public String getTargetEntityRefNo() {
        return targetEntityRefNo;
    }

    public void setTargetEntityRefNo(String targetEntityRefNo) {
        this.targetEntityRefNo = targetEntityRefNo;
    }

    public java.math.BigDecimal getTargetEntityVersionid() {
        return targetEntityVersionid;
    }

    public void setTargetEntityVersionid(java.math.BigDecimal targetEntityVersionid) {
        this.targetEntityVersionid = targetEntityVersionid;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public static class Builder {

        private FgModTagRel instance = new FgModTagRel();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder tagReferenceNo(String tagReferenceNo) {
            instance.setTagReferenceNo(tagReferenceNo);
            return this;
        }

        public Builder targetEntityTypeCode(String targetEntityTypeCode) {
            instance.setTargetEntityTypeCode(targetEntityTypeCode);
            return this;
        }

        public Builder targetEntitySubTypeCode(String targetEntitySubTypeCode) {
            instance.setTargetEntitySubTypeCode(targetEntitySubTypeCode);
            return this;
        }

        public Builder targetEntityRefNo(String targetEntityRefNo) {
            instance.setTargetEntityRefNo(targetEntityRefNo);
            return this;
        }

        public Builder targetEntityVersionid(java.math.BigDecimal targetEntityVersionid) {
            instance.setTargetEntityVersionid(targetEntityVersionid);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public FgModTagRel build() {
            return instance;
        }
    }
}
