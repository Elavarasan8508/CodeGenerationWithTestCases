package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdBillFirc {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

    private String fircNo;

    private java.time.LocalDateTime fircDate;

    private String fircCcy;

    private java.math.BigDecimal fircAmt;

    private java.math.BigDecimal fircUtilAmt;

    private java.math.BigDecimal fircOsAmt;

    private String adCode;

    private String ieCode;

    private String remitterName;

    private String remitterCountry;

    private String remitBankCountry;

    public FgTrdBillFirc() {
    }

    public FgTrdBillFirc(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String fircNo, java.time.LocalDateTime fircDate, String fircCcy, java.math.BigDecimal fircAmt, java.math.BigDecimal fircUtilAmt, java.math.BigDecimal fircOsAmt, String adCode, String ieCode, String remitterName, String remitterCountry, String remitBankCountry) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.fircNo = fircNo;
        this.fircDate = fircDate;
        this.fircCcy = fircCcy;
        this.fircAmt = fircAmt;
        this.fircUtilAmt = fircUtilAmt;
        this.fircOsAmt = fircOsAmt;
        this.adCode = adCode;
        this.ieCode = ieCode;
        this.remitterName = remitterName;
        this.remitterCountry = remitterCountry;
        this.remitBankCountry = remitBankCountry;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
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

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
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

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getFircNo() {
        return fircNo;
    }

    public void setFircNo(String fircNo) {
        this.fircNo = fircNo;
    }

    public java.time.LocalDateTime getFircDate() {
        return fircDate;
    }

    public void setFircDate(java.time.LocalDateTime fircDate) {
        this.fircDate = fircDate;
    }

    public String getFircCcy() {
        return fircCcy;
    }

    public void setFircCcy(String fircCcy) {
        this.fircCcy = fircCcy;
    }

    public java.math.BigDecimal getFircAmt() {
        return fircAmt;
    }

    public void setFircAmt(java.math.BigDecimal fircAmt) {
        this.fircAmt = fircAmt;
    }

    public java.math.BigDecimal getFircUtilAmt() {
        return fircUtilAmt;
    }

    public void setFircUtilAmt(java.math.BigDecimal fircUtilAmt) {
        this.fircUtilAmt = fircUtilAmt;
    }

    public java.math.BigDecimal getFircOsAmt() {
        return fircOsAmt;
    }

    public void setFircOsAmt(java.math.BigDecimal fircOsAmt) {
        this.fircOsAmt = fircOsAmt;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getRemitterName() {
        return remitterName;
    }

    public void setRemitterName(String remitterName) {
        this.remitterName = remitterName;
    }

    public String getRemitterCountry() {
        return remitterCountry;
    }

    public void setRemitterCountry(String remitterCountry) {
        this.remitterCountry = remitterCountry;
    }

    public String getRemitBankCountry() {
        return remitBankCountry;
    }

    public void setRemitBankCountry(String remitBankCountry) {
        this.remitBankCountry = remitBankCountry;
    }

    public static class Builder {

        private FgTrdBillFirc instance = new FgTrdBillFirc();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
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

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
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

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder fircNo(String fircNo) {
            instance.setFircNo(fircNo);
            return this;
        }

        public Builder fircDate(java.time.LocalDateTime fircDate) {
            instance.setFircDate(fircDate);
            return this;
        }

        public Builder fircCcy(String fircCcy) {
            instance.setFircCcy(fircCcy);
            return this;
        }

        public Builder fircAmt(java.math.BigDecimal fircAmt) {
            instance.setFircAmt(fircAmt);
            return this;
        }

        public Builder fircUtilAmt(java.math.BigDecimal fircUtilAmt) {
            instance.setFircUtilAmt(fircUtilAmt);
            return this;
        }

        public Builder fircOsAmt(java.math.BigDecimal fircOsAmt) {
            instance.setFircOsAmt(fircOsAmt);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder remitterName(String remitterName) {
            instance.setRemitterName(remitterName);
            return this;
        }

        public Builder remitterCountry(String remitterCountry) {
            instance.setRemitterCountry(remitterCountry);
            return this;
        }

        public Builder remitBankCountry(String remitBankCountry) {
            instance.setRemitBankCountry(remitBankCountry);
            return this;
        }

        public FgTrdBillFirc build() {
            return instance;
        }
    }
}
