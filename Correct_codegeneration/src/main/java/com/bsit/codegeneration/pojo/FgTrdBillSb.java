package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdBillSb {

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

    private String shippingbillNo;

    private java.time.LocalDateTime sbDate;

    private String formNo;

    private String portCode;

    private java.math.BigDecimal fobAmt;

    private String fobCcy;

    private String ieCode;

    private java.math.BigDecimal utilFobAmt;

    private java.math.BigDecimal invSlNo;

    private String invNo;

    private String expAgency;

    private String adCode;

    private java.time.LocalDateTime leoDate;

    private Long osPeriod;

    private String adBillNo;

    private String sbStatus;

    private String expType;

    private java.time.LocalDateTime invDate;

    private String invStatus;

    private java.math.BigDecimal freightAmt;

    private String freightCcy;

    private java.math.BigDecimal utilFreightAmt;

    private java.math.BigDecimal insAmt;

    private String insCcy;

    private java.math.BigDecimal utilInsAmt;

    public FgTrdBillSb() {
    }

    public FgTrdBillSb(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String shippingbillNo, java.time.LocalDateTime sbDate, String formNo, String portCode, java.math.BigDecimal fobAmt, String fobCcy, String ieCode, java.math.BigDecimal utilFobAmt, java.math.BigDecimal invSlNo, String invNo, String expAgency, String adCode, java.time.LocalDateTime leoDate, Long osPeriod, String adBillNo, String sbStatus, String expType, java.time.LocalDateTime invDate, String invStatus, java.math.BigDecimal freightAmt, String freightCcy, java.math.BigDecimal utilFreightAmt, java.math.BigDecimal insAmt, String insCcy, java.math.BigDecimal utilInsAmt) {
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
        this.shippingbillNo = shippingbillNo;
        this.sbDate = sbDate;
        this.formNo = formNo;
        this.portCode = portCode;
        this.fobAmt = fobAmt;
        this.fobCcy = fobCcy;
        this.ieCode = ieCode;
        this.utilFobAmt = utilFobAmt;
        this.invSlNo = invSlNo;
        this.invNo = invNo;
        this.expAgency = expAgency;
        this.adCode = adCode;
        this.leoDate = leoDate;
        this.osPeriod = osPeriod;
        this.adBillNo = adBillNo;
        this.sbStatus = sbStatus;
        this.expType = expType;
        this.invDate = invDate;
        this.invStatus = invStatus;
        this.freightAmt = freightAmt;
        this.freightCcy = freightCcy;
        this.utilFreightAmt = utilFreightAmt;
        this.insAmt = insAmt;
        this.insCcy = insCcy;
        this.utilInsAmt = utilInsAmt;
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

    public String getShippingbillNo() {
        return shippingbillNo;
    }

    public void setShippingbillNo(String shippingbillNo) {
        this.shippingbillNo = shippingbillNo;
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

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public java.math.BigDecimal getFobAmt() {
        return fobAmt;
    }

    public void setFobAmt(java.math.BigDecimal fobAmt) {
        this.fobAmt = fobAmt;
    }

    public String getFobCcy() {
        return fobCcy;
    }

    public void setFobCcy(String fobCcy) {
        this.fobCcy = fobCcy;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public java.math.BigDecimal getUtilFobAmt() {
        return utilFobAmt;
    }

    public void setUtilFobAmt(java.math.BigDecimal utilFobAmt) {
        this.utilFobAmt = utilFobAmt;
    }

    public java.math.BigDecimal getInvSlNo() {
        return invSlNo;
    }

    public void setInvSlNo(java.math.BigDecimal invSlNo) {
        this.invSlNo = invSlNo;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getExpAgency() {
        return expAgency;
    }

    public void setExpAgency(String expAgency) {
        this.expAgency = expAgency;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public java.time.LocalDateTime getLeoDate() {
        return leoDate;
    }

    public void setLeoDate(java.time.LocalDateTime leoDate) {
        this.leoDate = leoDate;
    }

    public Long getOsPeriod() {
        return osPeriod;
    }

    public void setOsPeriod(Long osPeriod) {
        this.osPeriod = osPeriod;
    }

    public String getAdBillNo() {
        return adBillNo;
    }

    public void setAdBillNo(String adBillNo) {
        this.adBillNo = adBillNo;
    }

    public String getSbStatus() {
        return sbStatus;
    }

    public void setSbStatus(String sbStatus) {
        this.sbStatus = sbStatus;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public java.time.LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(java.time.LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public String getInvStatus() {
        return invStatus;
    }

    public void setInvStatus(String invStatus) {
        this.invStatus = invStatus;
    }

    public java.math.BigDecimal getFreightAmt() {
        return freightAmt;
    }

    public void setFreightAmt(java.math.BigDecimal freightAmt) {
        this.freightAmt = freightAmt;
    }

    public String getFreightCcy() {
        return freightCcy;
    }

    public void setFreightCcy(String freightCcy) {
        this.freightCcy = freightCcy;
    }

    public java.math.BigDecimal getUtilFreightAmt() {
        return utilFreightAmt;
    }

    public void setUtilFreightAmt(java.math.BigDecimal utilFreightAmt) {
        this.utilFreightAmt = utilFreightAmt;
    }

    public java.math.BigDecimal getInsAmt() {
        return insAmt;
    }

    public void setInsAmt(java.math.BigDecimal insAmt) {
        this.insAmt = insAmt;
    }

    public String getInsCcy() {
        return insCcy;
    }

    public void setInsCcy(String insCcy) {
        this.insCcy = insCcy;
    }

    public java.math.BigDecimal getUtilInsAmt() {
        return utilInsAmt;
    }

    public void setUtilInsAmt(java.math.BigDecimal utilInsAmt) {
        this.utilInsAmt = utilInsAmt;
    }

    public static class Builder {

        private FgTrdBillSb instance = new FgTrdBillSb();

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

        public Builder shippingbillNo(String shippingbillNo) {
            instance.setShippingbillNo(shippingbillNo);
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

        public Builder portCode(String portCode) {
            instance.setPortCode(portCode);
            return this;
        }

        public Builder fobAmt(java.math.BigDecimal fobAmt) {
            instance.setFobAmt(fobAmt);
            return this;
        }

        public Builder fobCcy(String fobCcy) {
            instance.setFobCcy(fobCcy);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder utilFobAmt(java.math.BigDecimal utilFobAmt) {
            instance.setUtilFobAmt(utilFobAmt);
            return this;
        }

        public Builder invSlNo(java.math.BigDecimal invSlNo) {
            instance.setInvSlNo(invSlNo);
            return this;
        }

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder expAgency(String expAgency) {
            instance.setExpAgency(expAgency);
            return this;
        }

        public Builder adCode(String adCode) {
            instance.setAdCode(adCode);
            return this;
        }

        public Builder leoDate(java.time.LocalDateTime leoDate) {
            instance.setLeoDate(leoDate);
            return this;
        }

        public Builder osPeriod(Long osPeriod) {
            instance.setOsPeriod(osPeriod);
            return this;
        }

        public Builder adBillNo(String adBillNo) {
            instance.setAdBillNo(adBillNo);
            return this;
        }

        public Builder sbStatus(String sbStatus) {
            instance.setSbStatus(sbStatus);
            return this;
        }

        public Builder expType(String expType) {
            instance.setExpType(expType);
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            instance.setInvDate(invDate);
            return this;
        }

        public Builder invStatus(String invStatus) {
            instance.setInvStatus(invStatus);
            return this;
        }

        public Builder freightAmt(java.math.BigDecimal freightAmt) {
            instance.setFreightAmt(freightAmt);
            return this;
        }

        public Builder freightCcy(String freightCcy) {
            instance.setFreightCcy(freightCcy);
            return this;
        }

        public Builder utilFreightAmt(java.math.BigDecimal utilFreightAmt) {
            instance.setUtilFreightAmt(utilFreightAmt);
            return this;
        }

        public Builder insAmt(java.math.BigDecimal insAmt) {
            instance.setInsAmt(insAmt);
            return this;
        }

        public Builder insCcy(String insCcy) {
            instance.setInsCcy(insCcy);
            return this;
        }

        public Builder utilInsAmt(java.math.BigDecimal utilInsAmt) {
            instance.setUtilInsAmt(utilInsAmt);
            return this;
        }

        public FgTrdBillSb build() {
            return instance;
        }
    }
}
