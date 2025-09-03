package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrracs {

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

    private String sbNo;

    private java.time.LocalDateTime sbDate;

    private String invoiceCcy;

    private String ieCodeSb;

    private String portCode;

    private String formNo;

    private Long invSlNo;

    private String irmNo;

    private String irmAd;

    private java.math.BigDecimal irmAmt;

    private String irmCcy;

    private java.time.LocalDateTime irmDate;

    private String irmName;

    private String irmCountry;

    private String irmBankCountry;

    private String boeNum;

    private java.time.LocalDateTime boeDate;

    private String portOfDis;

    private String importAgency;

    private String invNum;

    private String termsOfInv;

    private String invoiceSlNo;

    private java.math.BigDecimal invAmt;

    private String ormNumber;

    private String adCode;

    private java.math.BigDecimal ormAmount;

    private java.math.BigDecimal ormUtilizedAmt;

    private String ormCcy;

    private java.time.LocalDateTime ormDate;

    private String ieName;

    private String invNo;

    private String irmBankName;

    private String irmSwiftBankRefNo;

    private java.math.BigDecimal osAmtIrm;

    private String invCcy;

    private java.math.BigDecimal osInvAmt;

    private String beneName;

    private String beneCountry;

    private String remitterBankName;

    private String purOfRemit;

    private java.time.LocalDateTime overduePeriod;

    private String supplierName;

    private String supplierAddr;

    private String supplierCountry;

    private String sellerName;

    private String sellerAddr;

    private String sellerCountry;

    private String ieCode;

    private java.math.BigDecimal utilizedInvAmt;

    private java.math.BigDecimal ormOsAmt;

    private String ieCodeOrm;

    public FgTrracs() {
    }

    public FgTrracs(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String sbNo, java.time.LocalDateTime sbDate, String invoiceCcy, String ieCodeSb, String portCode, String formNo, Long invSlNo, String irmNo, String irmAd, java.math.BigDecimal irmAmt, String irmCcy, java.time.LocalDateTime irmDate, String irmName, String irmCountry, String irmBankCountry, String boeNum, java.time.LocalDateTime boeDate, String portOfDis, String importAgency, String invNum, String termsOfInv, String invoiceSlNo, java.math.BigDecimal invAmt, String ormNumber, String adCode, java.math.BigDecimal ormAmount, java.math.BigDecimal ormUtilizedAmt, String ormCcy, java.time.LocalDateTime ormDate, String ieName, String invNo, String irmBankName, String irmSwiftBankRefNo, java.math.BigDecimal osAmtIrm, String invCcy, java.math.BigDecimal osInvAmt, String beneName, String beneCountry, String remitterBankName, String purOfRemit, java.time.LocalDateTime overduePeriod, String supplierName, String supplierAddr, String supplierCountry, String sellerName, String sellerAddr, String sellerCountry, String ieCode, java.math.BigDecimal utilizedInvAmt, java.math.BigDecimal ormOsAmt, String ieCodeOrm) {
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
        this.sbNo = sbNo;
        this.sbDate = sbDate;
        this.invoiceCcy = invoiceCcy;
        this.ieCodeSb = ieCodeSb;
        this.portCode = portCode;
        this.formNo = formNo;
        this.invSlNo = invSlNo;
        this.irmNo = irmNo;
        this.irmAd = irmAd;
        this.irmAmt = irmAmt;
        this.irmCcy = irmCcy;
        this.irmDate = irmDate;
        this.irmName = irmName;
        this.irmCountry = irmCountry;
        this.irmBankCountry = irmBankCountry;
        this.boeNum = boeNum;
        this.boeDate = boeDate;
        this.portOfDis = portOfDis;
        this.importAgency = importAgency;
        this.invNum = invNum;
        this.termsOfInv = termsOfInv;
        this.invoiceSlNo = invoiceSlNo;
        this.invAmt = invAmt;
        this.ormNumber = ormNumber;
        this.adCode = adCode;
        this.ormAmount = ormAmount;
        this.ormUtilizedAmt = ormUtilizedAmt;
        this.ormCcy = ormCcy;
        this.ormDate = ormDate;
        this.ieName = ieName;
        this.invNo = invNo;
        this.irmBankName = irmBankName;
        this.irmSwiftBankRefNo = irmSwiftBankRefNo;
        this.osAmtIrm = osAmtIrm;
        this.invCcy = invCcy;
        this.osInvAmt = osInvAmt;
        this.beneName = beneName;
        this.beneCountry = beneCountry;
        this.remitterBankName = remitterBankName;
        this.purOfRemit = purOfRemit;
        this.overduePeriod = overduePeriod;
        this.supplierName = supplierName;
        this.supplierAddr = supplierAddr;
        this.supplierCountry = supplierCountry;
        this.sellerName = sellerName;
        this.sellerAddr = sellerAddr;
        this.sellerCountry = sellerCountry;
        this.ieCode = ieCode;
        this.utilizedInvAmt = utilizedInvAmt;
        this.ormOsAmt = ormOsAmt;
        this.ieCodeOrm = ieCodeOrm;
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

    public String getInvoiceCcy() {
        return invoiceCcy;
    }

    public void setInvoiceCcy(String invoiceCcy) {
        this.invoiceCcy = invoiceCcy;
    }

    public String getIeCodeSb() {
        return ieCodeSb;
    }

    public void setIeCodeSb(String ieCodeSb) {
        this.ieCodeSb = ieCodeSb;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public Long getInvSlNo() {
        return invSlNo;
    }

    public void setInvSlNo(Long invSlNo) {
        this.invSlNo = invSlNo;
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

    public String getIrmCcy() {
        return irmCcy;
    }

    public void setIrmCcy(String irmCcy) {
        this.irmCcy = irmCcy;
    }

    public java.time.LocalDateTime getIrmDate() {
        return irmDate;
    }

    public void setIrmDate(java.time.LocalDateTime irmDate) {
        this.irmDate = irmDate;
    }

    public String getIrmName() {
        return irmName;
    }

    public void setIrmName(String irmName) {
        this.irmName = irmName;
    }

    public String getIrmCountry() {
        return irmCountry;
    }

    public void setIrmCountry(String irmCountry) {
        this.irmCountry = irmCountry;
    }

    public String getIrmBankCountry() {
        return irmBankCountry;
    }

    public void setIrmBankCountry(String irmBankCountry) {
        this.irmBankCountry = irmBankCountry;
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

    public String getInvoiceSlNo() {
        return invoiceSlNo;
    }

    public void setInvoiceSlNo(String invoiceSlNo) {
        this.invoiceSlNo = invoiceSlNo;
    }

    public java.math.BigDecimal getInvAmt() {
        return invAmt;
    }

    public void setInvAmt(java.math.BigDecimal invAmt) {
        this.invAmt = invAmt;
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

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getIrmBankName() {
        return irmBankName;
    }

    public void setIrmBankName(String irmBankName) {
        this.irmBankName = irmBankName;
    }

    public String getIrmSwiftBankRefNo() {
        return irmSwiftBankRefNo;
    }

    public void setIrmSwiftBankRefNo(String irmSwiftBankRefNo) {
        this.irmSwiftBankRefNo = irmSwiftBankRefNo;
    }

    public java.math.BigDecimal getOsAmtIrm() {
        return osAmtIrm;
    }

    public void setOsAmtIrm(java.math.BigDecimal osAmtIrm) {
        this.osAmtIrm = osAmtIrm;
    }

    public String getInvCcy() {
        return invCcy;
    }

    public void setInvCcy(String invCcy) {
        this.invCcy = invCcy;
    }

    public java.math.BigDecimal getOsInvAmt() {
        return osInvAmt;
    }

    public void setOsInvAmt(java.math.BigDecimal osInvAmt) {
        this.osInvAmt = osInvAmt;
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

    public java.time.LocalDateTime getOverduePeriod() {
        return overduePeriod;
    }

    public void setOverduePeriod(java.time.LocalDateTime overduePeriod) {
        this.overduePeriod = overduePeriod;
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

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public java.math.BigDecimal getUtilizedInvAmt() {
        return utilizedInvAmt;
    }

    public void setUtilizedInvAmt(java.math.BigDecimal utilizedInvAmt) {
        this.utilizedInvAmt = utilizedInvAmt;
    }

    public java.math.BigDecimal getOrmOsAmt() {
        return ormOsAmt;
    }

    public void setOrmOsAmt(java.math.BigDecimal ormOsAmt) {
        this.ormOsAmt = ormOsAmt;
    }

    public String getIeCodeOrm() {
        return ieCodeOrm;
    }

    public void setIeCodeOrm(String ieCodeOrm) {
        this.ieCodeOrm = ieCodeOrm;
    }

    public static class Builder {

        private FgTrracs instance = new FgTrracs();

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

        public Builder sbNo(String sbNo) {
            instance.setSbNo(sbNo);
            return this;
        }

        public Builder sbDate(java.time.LocalDateTime sbDate) {
            instance.setSbDate(sbDate);
            return this;
        }

        public Builder invoiceCcy(String invoiceCcy) {
            instance.setInvoiceCcy(invoiceCcy);
            return this;
        }

        public Builder ieCodeSb(String ieCodeSb) {
            instance.setIeCodeSb(ieCodeSb);
            return this;
        }

        public Builder portCode(String portCode) {
            instance.setPortCode(portCode);
            return this;
        }

        public Builder formNo(String formNo) {
            instance.setFormNo(formNo);
            return this;
        }

        public Builder invSlNo(Long invSlNo) {
            instance.setInvSlNo(invSlNo);
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

        public Builder irmCcy(String irmCcy) {
            instance.setIrmCcy(irmCcy);
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            instance.setIrmDate(irmDate);
            return this;
        }

        public Builder irmName(String irmName) {
            instance.setIrmName(irmName);
            return this;
        }

        public Builder irmCountry(String irmCountry) {
            instance.setIrmCountry(irmCountry);
            return this;
        }

        public Builder irmBankCountry(String irmBankCountry) {
            instance.setIrmBankCountry(irmBankCountry);
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

        public Builder portOfDis(String portOfDis) {
            instance.setPortOfDis(portOfDis);
            return this;
        }

        public Builder importAgency(String importAgency) {
            instance.setImportAgency(importAgency);
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

        public Builder invoiceSlNo(String invoiceSlNo) {
            instance.setInvoiceSlNo(invoiceSlNo);
            return this;
        }

        public Builder invAmt(java.math.BigDecimal invAmt) {
            instance.setInvAmt(invAmt);
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

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder irmBankName(String irmBankName) {
            instance.setIrmBankName(irmBankName);
            return this;
        }

        public Builder irmSwiftBankRefNo(String irmSwiftBankRefNo) {
            instance.setIrmSwiftBankRefNo(irmSwiftBankRefNo);
            return this;
        }

        public Builder osAmtIrm(java.math.BigDecimal osAmtIrm) {
            instance.setOsAmtIrm(osAmtIrm);
            return this;
        }

        public Builder invCcy(String invCcy) {
            instance.setInvCcy(invCcy);
            return this;
        }

        public Builder osInvAmt(java.math.BigDecimal osInvAmt) {
            instance.setOsInvAmt(osInvAmt);
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

        public Builder overduePeriod(java.time.LocalDateTime overduePeriod) {
            instance.setOverduePeriod(overduePeriod);
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

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder utilizedInvAmt(java.math.BigDecimal utilizedInvAmt) {
            instance.setUtilizedInvAmt(utilizedInvAmt);
            return this;
        }

        public Builder ormOsAmt(java.math.BigDecimal ormOsAmt) {
            instance.setOrmOsAmt(ormOsAmt);
            return this;
        }

        public Builder ieCodeOrm(String ieCodeOrm) {
            instance.setIeCodeOrm(ieCodeOrm);
            return this;
        }

        public FgTrracs build() {
            return instance;
        }
    }
}
