package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdImpRegRq {

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

    private Long boeNumber;

    private java.time.LocalDateTime boeDate;

    private String ieCode;

    private Long invoiceNumber;

    private String portCode;

    private String productStatus;

    private String bankCode;

    private String bankName;

    private String tranReq;

    private String reqType;

    private Integer processID;

    private String applicantParty;

    private String issuingParty;

    private Integer dmsEventID;

    private String taskReason;

    private java.math.BigDecimal nameMatch;

    private Integer checkbox;

    private Integer bankUserID;

    public FgTrdImpRegRq() {
    }

    public FgTrdImpRegRq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, Long boeNumber, java.time.LocalDateTime boeDate, String ieCode, Long invoiceNumber, String portCode, String productStatus, String bankCode, String bankName, String tranReq, String reqType, Integer processID, String applicantParty, String issuingParty, Integer dmsEventID, String taskReason, java.math.BigDecimal nameMatch, Integer checkbox, Integer bankUserID) {
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
        this.boeNumber = boeNumber;
        this.boeDate = boeDate;
        this.ieCode = ieCode;
        this.invoiceNumber = invoiceNumber;
        this.portCode = portCode;
        this.productStatus = productStatus;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.tranReq = tranReq;
        this.reqType = reqType;
        this.processID = processID;
        this.applicantParty = applicantParty;
        this.issuingParty = issuingParty;
        this.dmsEventID = dmsEventID;
        this.taskReason = taskReason;
        this.nameMatch = nameMatch;
        this.checkbox = checkbox;
        this.bankUserID = bankUserID;
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

    public Long getBoeNumber() {
        return boeNumber;
    }

    public void setBoeNumber(Long boeNumber) {
        this.boeNumber = boeNumber;
    }

    public java.time.LocalDateTime getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(java.time.LocalDateTime boeDate) {
        this.boeDate = boeDate;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTranReq() {
        return tranReq;
    }

    public void setTranReq(String tranReq) {
        this.tranReq = tranReq;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
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

    public Integer getDmsEventID() {
        return dmsEventID;
    }

    public void setDmsEventID(Integer dmsEventID) {
        this.dmsEventID = dmsEventID;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public java.math.BigDecimal getNameMatch() {
        return nameMatch;
    }

    public void setNameMatch(java.math.BigDecimal nameMatch) {
        this.nameMatch = nameMatch;
    }

    public Integer getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Integer checkbox) {
        this.checkbox = checkbox;
    }

    public Integer getBankUserID() {
        return bankUserID;
    }

    public void setBankUserID(Integer bankUserID) {
        this.bankUserID = bankUserID;
    }

    public static class Builder {

        private FgTrdImpRegRq instance = new FgTrdImpRegRq();

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

        public Builder boeNumber(Long boeNumber) {
            instance.setBoeNumber(boeNumber);
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder invoiceNumber(Long invoiceNumber) {
            instance.setInvoiceNumber(invoiceNumber);
            return this;
        }

        public Builder portCode(String portCode) {
            instance.setPortCode(portCode);
            return this;
        }

        public Builder productStatus(String productStatus) {
            instance.setProductStatus(productStatus);
            return this;
        }

        public Builder bankCode(String bankCode) {
            instance.setBankCode(bankCode);
            return this;
        }

        public Builder bankName(String bankName) {
            instance.setBankName(bankName);
            return this;
        }

        public Builder tranReq(String tranReq) {
            instance.setTranReq(tranReq);
            return this;
        }

        public Builder reqType(String reqType) {
            instance.setReqType(reqType);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
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

        public Builder dmsEventID(Integer dmsEventID) {
            instance.setDmsEventID(dmsEventID);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder nameMatch(java.math.BigDecimal nameMatch) {
            instance.setNameMatch(nameMatch);
            return this;
        }

        public Builder checkbox(Integer checkbox) {
            instance.setCheckbox(checkbox);
            return this;
        }

        public Builder bankUserID(Integer bankUserID) {
            instance.setBankUserID(bankUserID);
            return this;
        }

        public FgTrdImpRegRq build() {
            return instance;
        }
    }
}
