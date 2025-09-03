package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdExpRegRq {

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

    private String portCode;

    private String expType;

    private String sbNo;

    private java.time.LocalDateTime sbDate;

    private String formNo;

    private String ieCode;

    private String reqType;

    private String irmNo;

    private String irmAd;

    private java.math.BigDecimal irmAmt;

    private java.math.BigDecimal osAmtIrm;

    private String irmCcy;

    private String applicantParty;

    private String issuingParty;

    private String productStatus;

    private Integer processID;

    private Integer dmsEventID;

    private String expAgency;

    private String debitAccNum;

    public FgTrdExpRegRq() {
    }

    public FgTrdExpRegRq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String portCode, String expType, String sbNo, java.time.LocalDateTime sbDate, String formNo, String ieCode, String reqType, String irmNo, String irmAd, java.math.BigDecimal irmAmt, java.math.BigDecimal osAmtIrm, String irmCcy, String applicantParty, String issuingParty, String productStatus, Integer processID, Integer dmsEventID, String expAgency, String debitAccNum) {
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
        this.portCode = portCode;
        this.expType = expType;
        this.sbNo = sbNo;
        this.sbDate = sbDate;
        this.formNo = formNo;
        this.ieCode = ieCode;
        this.reqType = reqType;
        this.irmNo = irmNo;
        this.irmAd = irmAd;
        this.irmAmt = irmAmt;
        this.osAmtIrm = osAmtIrm;
        this.irmCcy = irmCcy;
        this.applicantParty = applicantParty;
        this.issuingParty = issuingParty;
        this.productStatus = productStatus;
        this.processID = processID;
        this.dmsEventID = dmsEventID;
        this.expAgency = expAgency;
        this.debitAccNum = debitAccNum;
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

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public java.time.LocalDateTime getSbDate() {
        return sbDate;
    }

    public void setSbDate(java.time.LocalDateTime sbDate) {
        this.sbDate = sbDate;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getIrmNo() {
        return irmNo;
    }

    public void setIrmNo(String irmNo) {
        this.irmNo = irmNo;
    }

    public String getIrmAd() {
        return irmAd;
    }

    public void setIrmAd(String irmAd) {
        this.irmAd = irmAd;
    }

    public java.math.BigDecimal getIrmAmt() {
        return irmAmt;
    }

    public void setIrmAmt(java.math.BigDecimal irmAmt) {
        this.irmAmt = irmAmt;
    }

    public java.math.BigDecimal getOsAmtIrm() {
        return osAmtIrm;
    }

    public void setOsAmtIrm(java.math.BigDecimal osAmtIrm) {
        this.osAmtIrm = osAmtIrm;
    }

    public String getIrmCcy() {
        return irmCcy;
    }

    public void setIrmCcy(String irmCcy) {
        this.irmCcy = irmCcy;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getIssuingParty() {
        return issuingParty;
    }

    public void setIssuingParty(String issuingParty) {
        this.issuingParty = issuingParty;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public Integer getDmsEventID() {
        return dmsEventID;
    }

    public void setDmsEventID(Integer dmsEventID) {
        this.dmsEventID = dmsEventID;
    }

    public String getExpAgency() {
        return expAgency;
    }

    public void setExpAgency(String expAgency) {
        this.expAgency = expAgency;
    }

    public String getDebitAccNum() {
        return debitAccNum;
    }

    public void setDebitAccNum(String debitAccNum) {
        this.debitAccNum = debitAccNum;
    }

    public static class Builder {

        private FgTrdExpRegRq instance = new FgTrdExpRegRq();

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

        public Builder portCode(String portCode) {
            instance.setPortCode(portCode);
            return this;
        }

        public Builder expType(String expType) {
            instance.setExpType(expType);
            return this;
        }

        public Builder sbNo(String sbNo) {
            instance.setSbNo(sbNo);
            return this;
        }

        public Builder sbDate(java.time.LocalDateTime sbDate) {
            instance.setSbDate(sbDate);
            return this;
        }

        public Builder formNo(String formNo) {
            instance.setFormNo(formNo);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder reqType(String reqType) {
            instance.setReqType(reqType);
            return this;
        }

        public Builder irmNo(String irmNo) {
            instance.setIrmNo(irmNo);
            return this;
        }

        public Builder irmAd(String irmAd) {
            instance.setIrmAd(irmAd);
            return this;
        }

        public Builder irmAmt(java.math.BigDecimal irmAmt) {
            instance.setIrmAmt(irmAmt);
            return this;
        }

        public Builder osAmtIrm(java.math.BigDecimal osAmtIrm) {
            instance.setOsAmtIrm(osAmtIrm);
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            instance.setIrmCcy(irmCcy);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder issuingParty(String issuingParty) {
            instance.setIssuingParty(issuingParty);
            return this;
        }

        public Builder productStatus(String productStatus) {
            instance.setProductStatus(productStatus);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder dmsEventID(Integer dmsEventID) {
            instance.setDmsEventID(dmsEventID);
            return this;
        }

        public Builder expAgency(String expAgency) {
            instance.setExpAgency(expAgency);
            return this;
        }

        public Builder debitAccNum(String debitAccNum) {
            instance.setDebitAccNum(debitAccNum);
            return this;
        }

        public FgTrdExpRegRq build() {
            return instance;
        }
    }
}
