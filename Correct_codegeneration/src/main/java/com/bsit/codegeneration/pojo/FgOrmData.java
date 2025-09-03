package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgOrmData {

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

    private String ormNumber;

    private String adCode;

    private java.math.BigDecimal ormAmount;

    private java.math.BigDecimal ormUtilizedAmt;

    private java.math.BigDecimal ormOsAmt;

    private String ormCcy;

    private java.time.LocalDateTime ormDate;

    private String ieName;

    private String ieCode;

    private String beneName;

    private String beneCountry;

    private String remitterBankName;

    private String purOfRemit;

    public FgOrmData() {
    }

    public FgOrmData(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String ormNumber, String adCode, java.math.BigDecimal ormAmount, java.math.BigDecimal ormUtilizedAmt, java.math.BigDecimal ormOsAmt, String ormCcy, java.time.LocalDateTime ormDate, String ieName, String ieCode, String beneName, String beneCountry, String remitterBankName, String purOfRemit) {
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
        this.ormNumber = ormNumber;
        this.adCode = adCode;
        this.ormAmount = ormAmount;
        this.ormUtilizedAmt = ormUtilizedAmt;
        this.ormOsAmt = ormOsAmt;
        this.ormCcy = ormCcy;
        this.ormDate = ormDate;
        this.ieName = ieName;
        this.ieCode = ieCode;
        this.beneName = beneName;
        this.beneCountry = beneCountry;
        this.remitterBankName = remitterBankName;
        this.purOfRemit = purOfRemit;
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

    public String getOrmNumber() {
        return ormNumber;
    }

    public void setOrmNumber(String ormNumber) {
        this.ormNumber = ormNumber;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public java.math.BigDecimal getOrmAmount() {
        return ormAmount;
    }

    public void setOrmAmount(java.math.BigDecimal ormAmount) {
        this.ormAmount = ormAmount;
    }

    public java.math.BigDecimal getOrmUtilizedAmt() {
        return ormUtilizedAmt;
    }

    public void setOrmUtilizedAmt(java.math.BigDecimal ormUtilizedAmt) {
        this.ormUtilizedAmt = ormUtilizedAmt;
    }

    public java.math.BigDecimal getOrmOsAmt() {
        return ormOsAmt;
    }

    public void setOrmOsAmt(java.math.BigDecimal ormOsAmt) {
        this.ormOsAmt = ormOsAmt;
    }

    public String getOrmCcy() {
        return ormCcy;
    }

    public void setOrmCcy(String ormCcy) {
        this.ormCcy = ormCcy;
    }

    public java.time.LocalDateTime getOrmDate() {
        return ormDate;
    }

    public void setOrmDate(java.time.LocalDateTime ormDate) {
        this.ormDate = ormDate;
    }

    public String getIeName() {
        return ieName;
    }

    public void setIeName(String ieName) {
        this.ieName = ieName;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getBeneName() {
        return beneName;
    }

    public void setBeneName(String beneName) {
        this.beneName = beneName;
    }

    public String getBeneCountry() {
        return beneCountry;
    }

    public void setBeneCountry(String beneCountry) {
        this.beneCountry = beneCountry;
    }

    public String getRemitterBankName() {
        return remitterBankName;
    }

    public void setRemitterBankName(String remitterBankName) {
        this.remitterBankName = remitterBankName;
    }

    public String getPurOfRemit() {
        return purOfRemit;
    }

    public void setPurOfRemit(String purOfRemit) {
        this.purOfRemit = purOfRemit;
    }

    public static class Builder {

        private FgOrmData instance = new FgOrmData();

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

        public Builder ormNumber(String ormNumber) {
            instance.setOrmNumber(ormNumber);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder ormAmount(java.math.BigDecimal ormAmount) {
            instance.setOrmAmount(ormAmount);
            return this;
        }

        public Builder ormUtilizedAmt(java.math.BigDecimal ormUtilizedAmt) {
            instance.setOrmUtilizedAmt(ormUtilizedAmt);
            return this;
        }

        public Builder ormOsAmt(java.math.BigDecimal ormOsAmt) {
            instance.setOrmOsAmt(ormOsAmt);
            return this;
        }

        public Builder ormCcy(String ormCcy) {
            instance.setOrmCcy(ormCcy);
            return this;
        }

        public Builder ormDate(java.time.LocalDateTime ormDate) {
            instance.setOrmDate(ormDate);
            return this;
        }

        public Builder ieName(String ieName) {
            instance.setIeName(ieName);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder beneName(String beneName) {
            instance.setBeneName(beneName);
            return this;
        }

        public Builder beneCountry(String beneCountry) {
            instance.setBeneCountry(beneCountry);
            return this;
        }

        public Builder remitterBankName(String remitterBankName) {
            instance.setRemitterBankName(remitterBankName);
            return this;
        }

        public Builder purOfRemit(String purOfRemit) {
            instance.setPurOfRemit(purOfRemit);
            return this;
        }

        public FgOrmData build() {
            return instance;
        }
    }
}
