package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgProductRole {

    private String entityTypeCode;

    private String entitySubTypeCode;

    private String partyTypeCode;

    private String partySubTypeCode;

    private String partyRoleCode;

    private Integer entityRefID;

    private java.math.BigDecimal entityVersionNo;

    private String partyCode;

    private java.time.LocalDateTime validFrom;

    private java.time.LocalDateTime validTo;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private Integer uploadRefID;

    private Integer ID;

    public FgProductRole() {
    }

    public FgProductRole(String entityTypeCode, String entitySubTypeCode, String partyTypeCode, String partySubTypeCode, String partyRoleCode, Integer entityRefID, java.math.BigDecimal entityVersionNo, String partyCode, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, Integer uploadRefID, Integer ID) {
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.partyTypeCode = partyTypeCode;
        this.partySubTypeCode = partySubTypeCode;
        this.partyRoleCode = partyRoleCode;
        this.entityRefID = entityRefID;
        this.entityVersionNo = entityVersionNo;
        this.partyCode = partyCode;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.uploadRefID = uploadRefID;
        this.ID = ID;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getPartySubTypeCode() {
        return partySubTypeCode;
    }

    public void setPartySubTypeCode(String partySubTypeCode) {
        this.partySubTypeCode = partySubTypeCode;
    }

    public String getPartyRoleCode() {
        return partyRoleCode;
    }

    public void setPartyRoleCode(String partyRoleCode) {
        this.partyRoleCode = partyRoleCode;
    }

    public Integer getEntityRefID() {
        return entityRefID;
    }

    public void setEntityRefID(Integer entityRefID) {
        this.entityRefID = entityRefID;
    }

    public java.math.BigDecimal getEntityVersionNo() {
        return entityVersionNo;
    }

    public void setEntityVersionNo(java.math.BigDecimal entityVersionNo) {
        this.entityVersionNo = entityVersionNo;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public java.time.LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(java.time.LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public java.time.LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(java.time.LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public static class Builder {

        private FgProductRole instance = new FgProductRole();

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            instance.setPartyTypeCode(partyTypeCode);
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            instance.setPartySubTypeCode(partySubTypeCode);
            return this;
        }

        public Builder partyRoleCode(String partyRoleCode) {
            instance.setPartyRoleCode(partyRoleCode);
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            instance.setEntityRefID(entityRefID);
            return this;
        }

        public Builder entityVersionNo(java.math.BigDecimal entityVersionNo) {
            instance.setEntityVersionNo(entityVersionNo);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder validFrom(java.time.LocalDateTime validFrom) {
            instance.setValidFrom(validFrom);
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            instance.setValidTo(validTo);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
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

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public FgProductRole build() {
            return instance;
        }
    }
}
