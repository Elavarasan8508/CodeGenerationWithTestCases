package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdRemittance {

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

    private Integer custRefID;

    private Long tnxType;

    private Long prodStatCode;

    private Long tnxStatCode;

    private String productCode;

    private java.time.LocalDateTime applDate;

    private Long irTypeCode;

    private java.time.LocalDateTime tnxValueDate;

    private String irCurCode;

    private java.math.BigDecimal irAmt;

    private String tnxCurCode;

    private java.math.BigDecimal tnxAmt;

    private String actNo;

    private String beneficiaryName;

    private String beneficiaryAddressLine1;

    private String beneficiaryAddressLine2;

    private String beneficiaryReference;

    private String remitterName;

    private String remitterAddressLine1;

    private String remitterAddressLine2;

    private String nostroNumber;

    private String subProductCode;

    private java.time.LocalDateTime irValueDate;

    private String swiftMsgType;

    private String irOrdrInstitution;

    private String irRemInfo;

    private String irDtlChrgs;

    private Integer processID;

    private String applicantParty;

    private Integer boRefID;

    public FgTrdRemittance() {
    }

    public FgTrdRemittance(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, Integer custRefID, Long tnxType, Long prodStatCode, Long tnxStatCode, String productCode, java.time.LocalDateTime applDate, Long irTypeCode, java.time.LocalDateTime tnxValueDate, String irCurCode, java.math.BigDecimal irAmt, String tnxCurCode, java.math.BigDecimal tnxAmt, String actNo, String beneficiaryName, String beneficiaryAddressLine1, String beneficiaryAddressLine2, String beneficiaryReference, String remitterName, String remitterAddressLine1, String remitterAddressLine2, String nostroNumber, String subProductCode, java.time.LocalDateTime irValueDate, String swiftMsgType, String irOrdrInstitution, String irRemInfo, String irDtlChrgs, Integer processID, String applicantParty, Integer boRefID) {
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
        this.custRefID = custRefID;
        this.tnxType = tnxType;
        this.prodStatCode = prodStatCode;
        this.tnxStatCode = tnxStatCode;
        this.productCode = productCode;
        this.applDate = applDate;
        this.irTypeCode = irTypeCode;
        this.tnxValueDate = tnxValueDate;
        this.irCurCode = irCurCode;
        this.irAmt = irAmt;
        this.tnxCurCode = tnxCurCode;
        this.tnxAmt = tnxAmt;
        this.actNo = actNo;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryAddressLine1 = beneficiaryAddressLine1;
        this.beneficiaryAddressLine2 = beneficiaryAddressLine2;
        this.beneficiaryReference = beneficiaryReference;
        this.remitterName = remitterName;
        this.remitterAddressLine1 = remitterAddressLine1;
        this.remitterAddressLine2 = remitterAddressLine2;
        this.nostroNumber = nostroNumber;
        this.subProductCode = subProductCode;
        this.irValueDate = irValueDate;
        this.swiftMsgType = swiftMsgType;
        this.irOrdrInstitution = irOrdrInstitution;
        this.irRemInfo = irRemInfo;
        this.irDtlChrgs = irDtlChrgs;
        this.processID = processID;
        this.applicantParty = applicantParty;
        this.boRefID = boRefID;
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

    public Integer getCustRefID() {
        return custRefID;
    }

    public void setCustRefID(Integer custRefID) {
        this.custRefID = custRefID;
    }

    public Long getTnxType() {
        return tnxType;
    }

    public void setTnxType(Long tnxType) {
        this.tnxType = tnxType;
    }

    public Long getProdStatCode() {
        return prodStatCode;
    }

    public void setProdStatCode(Long prodStatCode) {
        this.prodStatCode = prodStatCode;
    }

    public Long getTnxStatCode() {
        return tnxStatCode;
    }

    public void setTnxStatCode(Long tnxStatCode) {
        this.tnxStatCode = tnxStatCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public java.time.LocalDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(java.time.LocalDateTime applDate) {
        this.applDate = applDate;
    }

    public Long getIrTypeCode() {
        return irTypeCode;
    }

    public void setIrTypeCode(Long irTypeCode) {
        this.irTypeCode = irTypeCode;
    }

    public java.time.LocalDateTime getTnxValueDate() {
        return tnxValueDate;
    }

    public void setTnxValueDate(java.time.LocalDateTime tnxValueDate) {
        this.tnxValueDate = tnxValueDate;
    }

    public String getIrCurCode() {
        return irCurCode;
    }

    public void setIrCurCode(String irCurCode) {
        this.irCurCode = irCurCode;
    }

    public java.math.BigDecimal getIrAmt() {
        return irAmt;
    }

    public void setIrAmt(java.math.BigDecimal irAmt) {
        this.irAmt = irAmt;
    }

    public String getTnxCurCode() {
        return tnxCurCode;
    }

    public void setTnxCurCode(String tnxCurCode) {
        this.tnxCurCode = tnxCurCode;
    }

    public java.math.BigDecimal getTnxAmt() {
        return tnxAmt;
    }

    public void setTnxAmt(java.math.BigDecimal tnxAmt) {
        this.tnxAmt = tnxAmt;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryAddressLine1() {
        return beneficiaryAddressLine1;
    }

    public void setBeneficiaryAddressLine1(String beneficiaryAddressLine1) {
        this.beneficiaryAddressLine1 = beneficiaryAddressLine1;
    }

    public String getBeneficiaryAddressLine2() {
        return beneficiaryAddressLine2;
    }

    public void setBeneficiaryAddressLine2(String beneficiaryAddressLine2) {
        this.beneficiaryAddressLine2 = beneficiaryAddressLine2;
    }

    public String getBeneficiaryReference() {
        return beneficiaryReference;
    }

    public void setBeneficiaryReference(String beneficiaryReference) {
        this.beneficiaryReference = beneficiaryReference;
    }

    public String getRemitterName() {
        return remitterName;
    }

    public void setRemitterName(String remitterName) {
        this.remitterName = remitterName;
    }

    public String getRemitterAddressLine1() {
        return remitterAddressLine1;
    }

    public void setRemitterAddressLine1(String remitterAddressLine1) {
        this.remitterAddressLine1 = remitterAddressLine1;
    }

    public String getRemitterAddressLine2() {
        return remitterAddressLine2;
    }

    public void setRemitterAddressLine2(String remitterAddressLine2) {
        this.remitterAddressLine2 = remitterAddressLine2;
    }

    public String getNostroNumber() {
        return nostroNumber;
    }

    public void setNostroNumber(String nostroNumber) {
        this.nostroNumber = nostroNumber;
    }

    public String getSubProductCode() {
        return subProductCode;
    }

    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    public java.time.LocalDateTime getIrValueDate() {
        return irValueDate;
    }

    public void setIrValueDate(java.time.LocalDateTime irValueDate) {
        this.irValueDate = irValueDate;
    }

    public String getSwiftMsgType() {
        return swiftMsgType;
    }

    public void setSwiftMsgType(String swiftMsgType) {
        this.swiftMsgType = swiftMsgType;
    }

    public String getIrOrdrInstitution() {
        return irOrdrInstitution;
    }

    public void setIrOrdrInstitution(String irOrdrInstitution) {
        this.irOrdrInstitution = irOrdrInstitution;
    }

    public String getIrRemInfo() {
        return irRemInfo;
    }

    public void setIrRemInfo(String irRemInfo) {
        this.irRemInfo = irRemInfo;
    }

    public String getIrDtlChrgs() {
        return irDtlChrgs;
    }

    public void setIrDtlChrgs(String irDtlChrgs) {
        this.irDtlChrgs = irDtlChrgs;
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

    public Integer getBoRefID() {
        return boRefID;
    }

    public void setBoRefID(Integer boRefID) {
        this.boRefID = boRefID;
    }

    public static class Builder {

        private FgTrdRemittance instance = new FgTrdRemittance();

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

        public Builder custRefID(Integer custRefID) {
            instance.setCustRefID(custRefID);
            return this;
        }

        public Builder tnxType(Long tnxType) {
            instance.setTnxType(tnxType);
            return this;
        }

        public Builder prodStatCode(Long prodStatCode) {
            instance.setProdStatCode(prodStatCode);
            return this;
        }

        public Builder tnxStatCode(Long tnxStatCode) {
            instance.setTnxStatCode(tnxStatCode);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder applDate(java.time.LocalDateTime applDate) {
            instance.setApplDate(applDate);
            return this;
        }

        public Builder irTypeCode(Long irTypeCode) {
            instance.setIrTypeCode(irTypeCode);
            return this;
        }

        public Builder tnxValueDate(java.time.LocalDateTime tnxValueDate) {
            instance.setTnxValueDate(tnxValueDate);
            return this;
        }

        public Builder irCurCode(String irCurCode) {
            instance.setIrCurCode(irCurCode);
            return this;
        }

        public Builder irAmt(java.math.BigDecimal irAmt) {
            instance.setIrAmt(irAmt);
            return this;
        }

        public Builder tnxCurCode(String tnxCurCode) {
            instance.setTnxCurCode(tnxCurCode);
            return this;
        }

        public Builder tnxAmt(java.math.BigDecimal tnxAmt) {
            instance.setTnxAmt(tnxAmt);
            return this;
        }

        public Builder actNo(String actNo) {
            instance.setActNo(actNo);
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            instance.setBeneficiaryName(beneficiaryName);
            return this;
        }

        public Builder beneficiaryAddressLine1(String beneficiaryAddressLine1) {
            instance.setBeneficiaryAddressLine1(beneficiaryAddressLine1);
            return this;
        }

        public Builder beneficiaryAddressLine2(String beneficiaryAddressLine2) {
            instance.setBeneficiaryAddressLine2(beneficiaryAddressLine2);
            return this;
        }

        public Builder beneficiaryReference(String beneficiaryReference) {
            instance.setBeneficiaryReference(beneficiaryReference);
            return this;
        }

        public Builder remitterName(String remitterName) {
            instance.setRemitterName(remitterName);
            return this;
        }

        public Builder remitterAddressLine1(String remitterAddressLine1) {
            instance.setRemitterAddressLine1(remitterAddressLine1);
            return this;
        }

        public Builder remitterAddressLine2(String remitterAddressLine2) {
            instance.setRemitterAddressLine2(remitterAddressLine2);
            return this;
        }

        public Builder nostroNumber(String nostroNumber) {
            instance.setNostroNumber(nostroNumber);
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            instance.setSubProductCode(subProductCode);
            return this;
        }

        public Builder irValueDate(java.time.LocalDateTime irValueDate) {
            instance.setIrValueDate(irValueDate);
            return this;
        }

        public Builder swiftMsgType(String swiftMsgType) {
            instance.setSwiftMsgType(swiftMsgType);
            return this;
        }

        public Builder irOrdrInstitution(String irOrdrInstitution) {
            instance.setIrOrdrInstitution(irOrdrInstitution);
            return this;
        }

        public Builder irRemInfo(String irRemInfo) {
            instance.setIrRemInfo(irRemInfo);
            return this;
        }

        public Builder irDtlChrgs(String irDtlChrgs) {
            instance.setIrDtlChrgs(irDtlChrgs);
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

        public Builder boRefID(Integer boRefID) {
            instance.setBoRefID(boRefID);
            return this;
        }

        public FgTrdRemittance build() {
            return instance;
        }
    }
}
