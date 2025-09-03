package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgIdpmsBoeReq {

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

    private String boeNumber;

    private java.time.LocalDateTime boeDate;

    private String portOfDis;

    private String importAgency;

    private String ieCode;

    private java.time.LocalDateTime overduePeriod;

    private String invoiceSlNo;

    private String invNum;

    private String termsOfInv;

    private String invCcy;

    private java.math.BigDecimal invAmt;

    private String supplierName;

    private String supplierAddr;

    private String supplierCountry;

    private String sellerName;

    private String sellerAddr;

    private String sellerCountry;

    private java.math.BigDecimal utilizedInvAmt;

    private java.math.BigDecimal osInvAmt;

    private java.math.BigDecimal endorsedAmt;

    private String closureIndicator;

    private java.math.BigDecimal adjAmt;

    private String adjReason;

    private java.time.LocalDateTime extendedDate;

    private String extendedBy;

    private String remarks;

    private Integer parentRefID;

    private Integer parentVersionID;

    private String trracsStatus;

    private String trracsErrorCode;

    private String trracsErrorDesc;

    private String reqType;

    private String finalErrorDesc;

    private String finalErrorCode;

    private String finalStatus;

    private String adCode;

    private String docNo;

    private java.time.LocalDateTime docDate;

    private java.time.LocalDateTime letterDate;

    private String letterNo;

    private String approvedBy;

    private Integer checkbox;

    private String rbiStatus;

    private String rbiErrorDesc;

    private String rbiErrorCode;

    public FgIdpmsBoeReq() {
    }

    public FgIdpmsBoeReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String boeNumber, java.time.LocalDateTime boeDate, String portOfDis, String importAgency, String ieCode, java.time.LocalDateTime overduePeriod, String invoiceSlNo, String invNum, String termsOfInv, String invCcy, java.math.BigDecimal invAmt, String supplierName, String supplierAddr, String supplierCountry, String sellerName, String sellerAddr, String sellerCountry, java.math.BigDecimal utilizedInvAmt, java.math.BigDecimal osInvAmt, java.math.BigDecimal endorsedAmt, String closureIndicator, java.math.BigDecimal adjAmt, String adjReason, java.time.LocalDateTime extendedDate, String extendedBy, String remarks, Integer parentRefID, Integer parentVersionID, String trracsStatus, String trracsErrorCode, String trracsErrorDesc, String reqType, String finalErrorDesc, String finalErrorCode, String finalStatus, String adCode, String docNo, java.time.LocalDateTime docDate, java.time.LocalDateTime letterDate, String letterNo, String approvedBy, Integer checkbox, String rbiStatus, String rbiErrorDesc, String rbiErrorCode) {
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
        this.portOfDis = portOfDis;
        this.importAgency = importAgency;
        this.ieCode = ieCode;
        this.overduePeriod = overduePeriod;
        this.invoiceSlNo = invoiceSlNo;
        this.invNum = invNum;
        this.termsOfInv = termsOfInv;
        this.invCcy = invCcy;
        this.invAmt = invAmt;
        this.supplierName = supplierName;
        this.supplierAddr = supplierAddr;
        this.supplierCountry = supplierCountry;
        this.sellerName = sellerName;
        this.sellerAddr = sellerAddr;
        this.sellerCountry = sellerCountry;
        this.utilizedInvAmt = utilizedInvAmt;
        this.osInvAmt = osInvAmt;
        this.endorsedAmt = endorsedAmt;
        this.closureIndicator = closureIndicator;
        this.adjAmt = adjAmt;
        this.adjReason = adjReason;
        this.extendedDate = extendedDate;
        this.extendedBy = extendedBy;
        this.remarks = remarks;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.trracsStatus = trracsStatus;
        this.trracsErrorCode = trracsErrorCode;
        this.trracsErrorDesc = trracsErrorDesc;
        this.reqType = reqType;
        this.finalErrorDesc = finalErrorDesc;
        this.finalErrorCode = finalErrorCode;
        this.finalStatus = finalStatus;
        this.adCode = adCode;
        this.docNo = docNo;
        this.docDate = docDate;
        this.letterDate = letterDate;
        this.letterNo = letterNo;
        this.approvedBy = approvedBy;
        this.checkbox = checkbox;
        this.rbiStatus = rbiStatus;
        this.rbiErrorDesc = rbiErrorDesc;
        this.rbiErrorCode = rbiErrorCode;
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

    public String getBoeNumber() {
        return boeNumber;
    }

    public void setBoeNumber(String boeNumber) {
        this.boeNumber = boeNumber;
    }

    public java.time.LocalDateTime getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(java.time.LocalDateTime boeDate) {
        this.boeDate = boeDate;
    }

    public String getPortOfDis() {
        return portOfDis;
    }

    public void setPortOfDis(String portOfDis) {
        this.portOfDis = portOfDis;
    }

    public String getImportAgency() {
        return importAgency;
    }

    public void setImportAgency(String importAgency) {
        this.importAgency = importAgency;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public java.time.LocalDateTime getOverduePeriod() {
        return overduePeriod;
    }

    public void setOverduePeriod(java.time.LocalDateTime overduePeriod) {
        this.overduePeriod = overduePeriod;
    }

    public String getInvoiceSlNo() {
        return invoiceSlNo;
    }

    public void setInvoiceSlNo(String invoiceSlNo) {
        this.invoiceSlNo = invoiceSlNo;
    }

    public String getInvNum() {
        return invNum;
    }

    public void setInvNum(String invNum) {
        this.invNum = invNum;
    }

    public String getTermsOfInv() {
        return termsOfInv;
    }

    public void setTermsOfInv(String termsOfInv) {
        this.termsOfInv = termsOfInv;
    }

    public String getInvCcy() {
        return invCcy;
    }

    public void setInvCcy(String invCcy) {
        this.invCcy = invCcy;
    }

    public java.math.BigDecimal getInvAmt() {
        return invAmt;
    }

    public void setInvAmt(java.math.BigDecimal invAmt) {
        this.invAmt = invAmt;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddr() {
        return supplierAddr;
    }

    public void setSupplierAddr(String supplierAddr) {
        this.supplierAddr = supplierAddr;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddr() {
        return sellerAddr;
    }

    public void setSellerAddr(String sellerAddr) {
        this.sellerAddr = sellerAddr;
    }

    public String getSellerCountry() {
        return sellerCountry;
    }

    public void setSellerCountry(String sellerCountry) {
        this.sellerCountry = sellerCountry;
    }

    public java.math.BigDecimal getUtilizedInvAmt() {
        return utilizedInvAmt;
    }

    public void setUtilizedInvAmt(java.math.BigDecimal utilizedInvAmt) {
        this.utilizedInvAmt = utilizedInvAmt;
    }

    public java.math.BigDecimal getOsInvAmt() {
        return osInvAmt;
    }

    public void setOsInvAmt(java.math.BigDecimal osInvAmt) {
        this.osInvAmt = osInvAmt;
    }

    public java.math.BigDecimal getEndorsedAmt() {
        return endorsedAmt;
    }

    public void setEndorsedAmt(java.math.BigDecimal endorsedAmt) {
        this.endorsedAmt = endorsedAmt;
    }

    public String getClosureIndicator() {
        return closureIndicator;
    }

    public void setClosureIndicator(String closureIndicator) {
        this.closureIndicator = closureIndicator;
    }

    public java.math.BigDecimal getAdjAmt() {
        return adjAmt;
    }

    public void setAdjAmt(java.math.BigDecimal adjAmt) {
        this.adjAmt = adjAmt;
    }

    public String getAdjReason() {
        return adjReason;
    }

    public void setAdjReason(String adjReason) {
        this.adjReason = adjReason;
    }

    public java.time.LocalDateTime getExtendedDate() {
        return extendedDate;
    }

    public void setExtendedDate(java.time.LocalDateTime extendedDate) {
        this.extendedDate = extendedDate;
    }

    public String getExtendedBy() {
        return extendedBy;
    }

    public void setExtendedBy(String extendedBy) {
        this.extendedBy = extendedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getTrracsStatus() {
        return trracsStatus;
    }

    public void setTrracsStatus(String trracsStatus) {
        this.trracsStatus = trracsStatus;
    }

    public String getTrracsErrorCode() {
        return trracsErrorCode;
    }

    public void setTrracsErrorCode(String trracsErrorCode) {
        this.trracsErrorCode = trracsErrorCode;
    }

    public String getTrracsErrorDesc() {
        return trracsErrorDesc;
    }

    public void setTrracsErrorDesc(String trracsErrorDesc) {
        this.trracsErrorDesc = trracsErrorDesc;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getFinalErrorDesc() {
        return finalErrorDesc;
    }

    public void setFinalErrorDesc(String finalErrorDesc) {
        this.finalErrorDesc = finalErrorDesc;
    }

    public String getFinalErrorCode() {
        return finalErrorCode;
    }

    public void setFinalErrorCode(String finalErrorCode) {
        this.finalErrorCode = finalErrorCode;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public java.time.LocalDateTime getDocDate() {
        return docDate;
    }

    public void setDocDate(java.time.LocalDateTime docDate) {
        this.docDate = docDate;
    }

    public java.time.LocalDateTime getLetterDate() {
        return letterDate;
    }

    public void setLetterDate(java.time.LocalDateTime letterDate) {
        this.letterDate = letterDate;
    }

    public String getLetterNo() {
        return letterNo;
    }

    public void setLetterNo(String letterNo) {
        this.letterNo = letterNo;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Integer getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Integer checkbox) {
        this.checkbox = checkbox;
    }

    public String getRbiStatus() {
        return rbiStatus;
    }

    public void setRbiStatus(String rbiStatus) {
        this.rbiStatus = rbiStatus;
    }

    public String getRbiErrorDesc() {
        return rbiErrorDesc;
    }

    public void setRbiErrorDesc(String rbiErrorDesc) {
        this.rbiErrorDesc = rbiErrorDesc;
    }

    public String getRbiErrorCode() {
        return rbiErrorCode;
    }

    public void setRbiErrorCode(String rbiErrorCode) {
        this.rbiErrorCode = rbiErrorCode;
    }

    public static class Builder {

        private FgIdpmsBoeReq instance = new FgIdpmsBoeReq();

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

        public Builder boeNumber(String boeNumber) {
            instance.setBoeNumber(boeNumber);
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder portOfDis(String portOfDis) {
            instance.setPortOfDis(portOfDis);
            return this;
        }

        public Builder importAgency(String importAgency) {
            instance.setImportAgency(importAgency);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder overduePeriod(java.time.LocalDateTime overduePeriod) {
            instance.setOverduePeriod(overduePeriod);
            return this;
        }

        public Builder invoiceSlNo(String invoiceSlNo) {
            instance.setInvoiceSlNo(invoiceSlNo);
            return this;
        }

        public Builder invNum(String invNum) {
            instance.setInvNum(invNum);
            return this;
        }

        public Builder termsOfInv(String termsOfInv) {
            instance.setTermsOfInv(termsOfInv);
            return this;
        }

        public Builder invCcy(String invCcy) {
            instance.setInvCcy(invCcy);
            return this;
        }

        public Builder invAmt(java.math.BigDecimal invAmt) {
            instance.setInvAmt(invAmt);
            return this;
        }

        public Builder supplierName(String supplierName) {
            instance.setSupplierName(supplierName);
            return this;
        }

        public Builder supplierAddr(String supplierAddr) {
            instance.setSupplierAddr(supplierAddr);
            return this;
        }

        public Builder supplierCountry(String supplierCountry) {
            instance.setSupplierCountry(supplierCountry);
            return this;
        }

        public Builder sellerName(String sellerName) {
            instance.setSellerName(sellerName);
            return this;
        }

        public Builder sellerAddr(String sellerAddr) {
            instance.setSellerAddr(sellerAddr);
            return this;
        }

        public Builder sellerCountry(String sellerCountry) {
            instance.setSellerCountry(sellerCountry);
            return this;
        }

        public Builder utilizedInvAmt(java.math.BigDecimal utilizedInvAmt) {
            instance.setUtilizedInvAmt(utilizedInvAmt);
            return this;
        }

        public Builder osInvAmt(java.math.BigDecimal osInvAmt) {
            instance.setOsInvAmt(osInvAmt);
            return this;
        }

        public Builder endorsedAmt(java.math.BigDecimal endorsedAmt) {
            instance.setEndorsedAmt(endorsedAmt);
            return this;
        }

        public Builder closureIndicator(String closureIndicator) {
            instance.setClosureIndicator(closureIndicator);
            return this;
        }

        public Builder adjAmt(java.math.BigDecimal adjAmt) {
            instance.setAdjAmt(adjAmt);
            return this;
        }

        public Builder adjReason(String adjReason) {
            instance.setAdjReason(adjReason);
            return this;
        }

        public Builder extendedDate(java.time.LocalDateTime extendedDate) {
            instance.setExtendedDate(extendedDate);
            return this;
        }

        public Builder extendedBy(String extendedBy) {
            instance.setExtendedBy(extendedBy);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
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

        public Builder trracsStatus(String trracsStatus) {
            instance.setTrracsStatus(trracsStatus);
            return this;
        }

        public Builder trracsErrorCode(String trracsErrorCode) {
            instance.setTrracsErrorCode(trracsErrorCode);
            return this;
        }

        public Builder trracsErrorDesc(String trracsErrorDesc) {
            instance.setTrracsErrorDesc(trracsErrorDesc);
            return this;
        }

        public Builder reqType(String reqType) {
            instance.setReqType(reqType);
            return this;
        }

        public Builder finalErrorDesc(String finalErrorDesc) {
            instance.setFinalErrorDesc(finalErrorDesc);
            return this;
        }

        public Builder finalErrorCode(String finalErrorCode) {
            instance.setFinalErrorCode(finalErrorCode);
            return this;
        }

        public Builder finalStatus(String finalStatus) {
            instance.setFinalStatus(finalStatus);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder docNo(String docNo) {
            instance.setDocNo(docNo);
            return this;
        }

        public Builder docDate(java.time.LocalDateTime docDate) {
            instance.setDocDate(docDate);
            return this;
        }

        public Builder letterDate(java.time.LocalDateTime letterDate) {
            instance.setLetterDate(letterDate);
            return this;
        }

        public Builder letterNo(String letterNo) {
            instance.setLetterNo(letterNo);
            return this;
        }

        public Builder approvedBy(String approvedBy) {
            instance.setApprovedBy(approvedBy);
            return this;
        }

        public Builder checkbox(Integer checkbox) {
            instance.setCheckbox(checkbox);
            return this;
        }

        public Builder rbiStatus(String rbiStatus) {
            instance.setRbiStatus(rbiStatus);
            return this;
        }

        public Builder rbiErrorDesc(String rbiErrorDesc) {
            instance.setRbiErrorDesc(rbiErrorDesc);
            return this;
        }

        public Builder rbiErrorCode(String rbiErrorCode) {
            instance.setRbiErrorCode(rbiErrorCode);
            return this;
        }

        public FgIdpmsBoeReq build() {
            return instance;
        }
    }
}
