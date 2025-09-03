package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgOrmFuInv {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private String applicantParty;

    private String fulfillmentParty;

    private Integer isTemplate;

    private String invNo;

    private String hsCode;

    private String portOfLoading;

    private String vesselName;

    private Integer parentRefID;

    private Integer parentVersionID;

    private java.time.LocalDateTime invDate;

    private java.math.BigDecimal invAmount;

    private String invCcy;

    private String boeNum;

    private java.time.LocalDateTime boeDate;

    private String transportDocNum;

    private String portOfDischarge;

    private String goodsDes;

    private String boeAdCode;

    private String countryOrigGood;

    private String boeNumber;

    private Integer lineNo;

    private String migrationBoeSuplCountry;

    private String sellerName;

    private String supplierAddr;

    private String supplierCountry;

    private String supplierName;

    private java.math.BigDecimal osInvAmt;

    private java.math.BigDecimal invAmt;

    public FgOrmFuInv() {
    }

    public FgOrmFuInv(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String invNo, String hsCode, String portOfLoading, String vesselName, Integer parentRefID, Integer parentVersionID, java.time.LocalDateTime invDate, java.math.BigDecimal invAmount, String invCcy, String boeNum, java.time.LocalDateTime boeDate, String transportDocNum, String portOfDischarge, String goodsDes, String boeAdCode, String countryOrigGood, String boeNumber, Integer lineNo, String migrationBoeSuplCountry, String sellerName, String supplierAddr, String supplierCountry, String supplierName, java.math.BigDecimal osInvAmt, java.math.BigDecimal invAmt) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
        this.isTemplate = isTemplate;
        this.invNo = invNo;
        this.hsCode = hsCode;
        this.portOfLoading = portOfLoading;
        this.vesselName = vesselName;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.invDate = invDate;
        this.invAmount = invAmount;
        this.invCcy = invCcy;
        this.boeNum = boeNum;
        this.boeDate = boeDate;
        this.transportDocNum = transportDocNum;
        this.portOfDischarge = portOfDischarge;
        this.goodsDes = goodsDes;
        this.boeAdCode = boeAdCode;
        this.countryOrigGood = countryOrigGood;
        this.boeNumber = boeNumber;
        this.lineNo = lineNo;
        this.migrationBoeSuplCountry = migrationBoeSuplCountry;
        this.sellerName = sellerName;
        this.supplierAddr = supplierAddr;
        this.supplierCountry = supplierCountry;
        this.supplierName = supplierName;
        this.osInvAmt = osInvAmt;
        this.invAmt = invAmt;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
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

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getPortOfLoading() {
        return portOfLoading;
    }

    public void setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
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

    public java.time.LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(java.time.LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public java.math.BigDecimal getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(java.math.BigDecimal invAmount) {
        this.invAmount = invAmount;
    }

    public String getInvCcy() {
        return invCcy;
    }

    public void setInvCcy(String invCcy) {
        this.invCcy = invCcy;
    }

    public String getBoeNum() {
        return boeNum;
    }

    public void setBoeNum(String boeNum) {
        this.boeNum = boeNum;
    }

    public java.time.LocalDateTime getBoeDate() {
        return boeDate;
    }

    public void setBoeDate(java.time.LocalDateTime boeDate) {
        this.boeDate = boeDate;
    }

    public String getTransportDocNum() {
        return transportDocNum;
    }

    public void setTransportDocNum(String transportDocNum) {
        this.transportDocNum = transportDocNum;
    }

    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

    public String getBoeAdCode() {
        return boeAdCode;
    }

    public void setBoeAdCode(String boeAdCode) {
        this.boeAdCode = boeAdCode;
    }

    public String getCountryOrigGood() {
        return countryOrigGood;
    }

    public void setCountryOrigGood(String countryOrigGood) {
        this.countryOrigGood = countryOrigGood;
    }

    public String getBoeNumber() {
        return boeNumber;
    }

    public void setBoeNumber(String boeNumber) {
        this.boeNumber = boeNumber;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public String getMigrationBoeSuplCountry() {
        return migrationBoeSuplCountry;
    }

    public void setMigrationBoeSuplCountry(String migrationBoeSuplCountry) {
        this.migrationBoeSuplCountry = migrationBoeSuplCountry;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public java.math.BigDecimal getOsInvAmt() {
        return osInvAmt;
    }

    public void setOsInvAmt(java.math.BigDecimal osInvAmt) {
        this.osInvAmt = osInvAmt;
    }

    public java.math.BigDecimal getInvAmt() {
        return invAmt;
    }

    public void setInvAmt(java.math.BigDecimal invAmt) {
        this.invAmt = invAmt;
    }

    public static class Builder {

        private FgOrmFuInv instance = new FgOrmFuInv();

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

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
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

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder hsCode(String hsCode) {
            instance.setHsCode(hsCode);
            return this;
        }

        public Builder portOfLoading(String portOfLoading) {
            instance.setPortOfLoading(portOfLoading);
            return this;
        }

        public Builder vesselName(String vesselName) {
            instance.setVesselName(vesselName);
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

        public Builder invDate(java.time.LocalDateTime invDate) {
            instance.setInvDate(invDate);
            return this;
        }

        public Builder invAmount(java.math.BigDecimal invAmount) {
            instance.setInvAmount(invAmount);
            return this;
        }

        public Builder invCcy(String invCcy) {
            instance.setInvCcy(invCcy);
            return this;
        }

        public Builder boeNum(String boeNum) {
            instance.setBoeNum(boeNum);
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            instance.setBoeDate(boeDate);
            return this;
        }

        public Builder transportDocNum(String transportDocNum) {
            instance.setTransportDocNum(transportDocNum);
            return this;
        }

        public Builder portOfDischarge(String portOfDischarge) {
            instance.setPortOfDischarge(portOfDischarge);
            return this;
        }

        public Builder goodsDes(String goodsDes) {
            instance.setGoodsDes(goodsDes);
            return this;
        }

        public Builder boeAdCode(String boeAdCode) {
            instance.setBoeAdCode(boeAdCode);
            return this;
        }

        public Builder countryOrigGood(String countryOrigGood) {
            instance.setCountryOrigGood(countryOrigGood);
            return this;
        }

        public Builder boeNumber(String boeNumber) {
            instance.setBoeNumber(boeNumber);
            return this;
        }

        public Builder lineNo(Integer lineNo) {
            instance.setLineNo(lineNo);
            return this;
        }

        public Builder migrationBoeSuplCountry(String migrationBoeSuplCountry) {
            instance.setMigrationBoeSuplCountry(migrationBoeSuplCountry);
            return this;
        }

        public Builder sellerName(String sellerName) {
            instance.setSellerName(sellerName);
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

        public Builder supplierName(String supplierName) {
            instance.setSupplierName(supplierName);
            return this;
        }

        public Builder osInvAmt(java.math.BigDecimal osInvAmt) {
            instance.setOsInvAmt(osInvAmt);
            return this;
        }

        public Builder invAmt(java.math.BigDecimal invAmt) {
            instance.setInvAmt(invAmt);
            return this;
        }

        public FgOrmFuInv build() {
            return instance;
        }
    }
}
