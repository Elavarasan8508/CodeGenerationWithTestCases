package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgPartyClassification {

    private Integer ID;

    private Integer partyID;

    private Integer partyVersionID;

    private String partySubTypeCode;

    private String partyCode;

    private String classTypeCode;

    private String classSubTypeCode;

    private java.time.LocalDateTime validFrom;

    private java.time.LocalDateTime validTo;

    private String comments;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String demographicTypeCode;

    private String demographicSubTypeCode;

    private Integer sysDefined;

    private String systemSourceCode;

    public FgPartyClassification() {
    }

    public FgPartyClassification(Integer ID, Integer partyID, Integer partyVersionID, String partySubTypeCode, String partyCode, String classTypeCode, String classSubTypeCode, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, String comments, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String demographicTypeCode, String demographicSubTypeCode, Integer sysDefined, String systemSourceCode) {
        this.ID = ID;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.partySubTypeCode = partySubTypeCode;
        this.partyCode = partyCode;
        this.classTypeCode = classTypeCode;
        this.classSubTypeCode = classSubTypeCode;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.comments = comments;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.demographicTypeCode = demographicTypeCode;
        this.demographicSubTypeCode = demographicSubTypeCode;
        this.sysDefined = sysDefined;
        this.systemSourceCode = systemSourceCode;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPartyID() {
        return partyID;
    }

    public void setPartyID(Integer partyID) {
        this.partyID = partyID;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public String getPartySubTypeCode() {
        return partySubTypeCode;
    }

    public void setPartySubTypeCode(String partySubTypeCode) {
        this.partySubTypeCode = partySubTypeCode;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getClassTypeCode() {
        return classTypeCode;
    }

    public void setClassTypeCode(String classTypeCode) {
        this.classTypeCode = classTypeCode;
    }

    public String getClassSubTypeCode() {
        return classSubTypeCode;
    }

    public void setClassSubTypeCode(String classSubTypeCode) {
        this.classSubTypeCode = classSubTypeCode;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getDemographicTypeCode() {
        return demographicTypeCode;
    }

    public void setDemographicTypeCode(String demographicTypeCode) {
        this.demographicTypeCode = demographicTypeCode;
    }

    public String getDemographicSubTypeCode() {
        return demographicSubTypeCode;
    }

    public void setDemographicSubTypeCode(String demographicSubTypeCode) {
        this.demographicSubTypeCode = demographicSubTypeCode;
    }

    public Integer getSysDefined() {
        return sysDefined;
    }

    public void setSysDefined(Integer sysDefined) {
        this.sysDefined = sysDefined;
    }

    public String getSystemSourceCode() {
        return systemSourceCode;
    }

    public void setSystemSourceCode(String systemSourceCode) {
        this.systemSourceCode = systemSourceCode;
    }

    public static class Builder {

        private FgPartyClassification instance = new FgPartyClassification();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder partyID(Integer partyID) {
            instance.setPartyID(partyID);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            instance.setPartySubTypeCode(partySubTypeCode);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder classTypeCode(String classTypeCode) {
            instance.setClassTypeCode(classTypeCode);
            return this;
        }

        public Builder classSubTypeCode(String classSubTypeCode) {
            instance.setClassSubTypeCode(classSubTypeCode);
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

        public Builder comments(String comments) {
            instance.setComments(comments);
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

        public Builder demographicTypeCode(String demographicTypeCode) {
            instance.setDemographicTypeCode(demographicTypeCode);
            return this;
        }

        public Builder demographicSubTypeCode(String demographicSubTypeCode) {
            instance.setDemographicSubTypeCode(demographicSubTypeCode);
            return this;
        }

        public Builder sysDefined(Integer sysDefined) {
            instance.setSysDefined(sysDefined);
            return this;
        }

        public Builder systemSourceCode(String systemSourceCode) {
            instance.setSystemSourceCode(systemSourceCode);
            return this;
        }

        public FgPartyClassification build() {
            return instance;
        }
    }
}
