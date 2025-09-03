package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgEdpmsFircReq {

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

    private String irmNumber;

    private java.time.LocalDateTime remittanceDate;

    private String irmCcy;

    private java.math.BigDecimal irmAmt;

    private java.math.BigDecimal irmUtilAmt;

    private java.math.BigDecimal irmOsAmt;

    private String ieCode;

    private String adCode;

    private String remitterName;

    private String remitterCountry;

    private String remitBankCountry;

    private Integer parentRefID;

    private Integer parentVersionID;

    private java.math.BigDecimal fircAmt;

    private String fircNumber;

    private String finalErrorDesc;

    private String finalStatus;

    public FgEdpmsFircReq() {
    }

    public FgEdpmsFircReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String irmNumber, java.time.LocalDateTime remittanceDate, String irmCcy, java.math.BigDecimal irmAmt, java.math.BigDecimal irmUtilAmt, java.math.BigDecimal irmOsAmt, String ieCode, String adCode, String remitterName, String remitterCountry, String remitBankCountry, Integer parentRefID, Integer parentVersionID, java.math.BigDecimal fircAmt, String fircNumber, String finalErrorDesc, String finalStatus) {
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
        this.irmNumber = irmNumber;
        this.remittanceDate = remittanceDate;
        this.irmCcy = irmCcy;
        this.irmAmt = irmAmt;
        this.irmUtilAmt = irmUtilAmt;
        this.irmOsAmt = irmOsAmt;
        this.ieCode = ieCode;
        this.adCode = adCode;
        this.remitterName = remitterName;
        this.remitterCountry = remitterCountry;
        this.remitBankCountry = remitBankCountry;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.fircAmt = fircAmt;
        this.fircNumber = fircNumber;
        this.finalErrorDesc = finalErrorDesc;
        this.finalStatus = finalStatus;
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

    public String getIrmNumber() {
        return irmNumber;
    }

    public void setIrmNumber(String irmNumber) {
        this.irmNumber = irmNumber;
    }

    public java.time.LocalDateTime getRemittanceDate() {
        return remittanceDate;
    }

    public void setRemittanceDate(java.time.LocalDateTime remittanceDate) {
        this.remittanceDate = remittanceDate;
    }

    public String getIrmCcy() {
        return irmCcy;
    }

    public void setIrmCcy(String irmCcy) {
        this.irmCcy = irmCcy;
    }

    public java.math.BigDecimal getIrmAmt() {
        return irmAmt;
    }

    public void setIrmAmt(java.math.BigDecimal irmAmt) {
        this.irmAmt = irmAmt;
    }

    public java.math.BigDecimal getIrmUtilAmt() {
        return irmUtilAmt;
    }

    public void setIrmUtilAmt(java.math.BigDecimal irmUtilAmt) {
        this.irmUtilAmt = irmUtilAmt;
    }

    public java.math.BigDecimal getIrmOsAmt() {
        return irmOsAmt;
    }

    public void setIrmOsAmt(java.math.BigDecimal irmOsAmt) {
        this.irmOsAmt = irmOsAmt;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
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

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public java.math.BigDecimal getFircAmt() {
        return fircAmt;
    }

    public void setFircAmt(java.math.BigDecimal fircAmt) {
        this.fircAmt = fircAmt;
    }

    public String getFircNumber() {
        return fircNumber;
    }

    public void setFircNumber(String fircNumber) {
        this.fircNumber = fircNumber;
    }

    public String getFinalErrorDesc() {
        return finalErrorDesc;
    }

    public void setFinalErrorDesc(String finalErrorDesc) {
        this.finalErrorDesc = finalErrorDesc;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public static class Builder {

        private FgEdpmsFircReq instance = new FgEdpmsFircReq();

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

        public Builder irmNumber(String irmNumber) {
            instance.setIrmNumber(irmNumber);
            return this;
        }

        public Builder remittanceDate(java.time.LocalDateTime remittanceDate) {
            instance.setRemittanceDate(remittanceDate);
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            instance.setIrmCcy(irmCcy);
            return this;
        }

        public Builder irmAmt(java.math.BigDecimal irmAmt) {
            instance.setIrmAmt(irmAmt);
            return this;
        }

        public Builder irmUtilAmt(java.math.BigDecimal irmUtilAmt) {
            instance.setIrmUtilAmt(irmUtilAmt);
            return this;
        }

        public Builder irmOsAmt(java.math.BigDecimal irmOsAmt) {
            instance.setIrmOsAmt(irmOsAmt);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
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

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder fircAmt(java.math.BigDecimal fircAmt) {
            instance.setFircAmt(fircAmt);
            return this;
        }

        public Builder fircNumber(String fircNumber) {
            instance.setFircNumber(fircNumber);
            return this;
        }

        public Builder finalErrorDesc(String finalErrorDesc) {
            instance.setFinalErrorDesc(finalErrorDesc);
            return this;
        }

        public Builder finalStatus(String finalStatus) {
            instance.setFinalStatus(finalStatus);
            return this;
        }

        public FgEdpmsFircReq build() {
            return instance;
        }
    }
}
