package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgEdpmsSbReq {

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

    private String existAd;

    private String newAd;

    private String adjRefNo;

    private Long invSlNo;

    private String invNo;

    private String adjInd;

    private java.math.BigDecimal adjAmt;

    private String billClInd;

    private String extRefNo;

    private String extBy;

    private java.time.LocalDateTime extDateSb;

    private String remarksSb;

    private String bankRefNo;

    private java.math.BigDecimal amtUtil;

    private String portcode;

    private String expType;

    private String shipbillno;

    private java.time.LocalDateTime shipbilldate;

    private String formno;

    private String adCode;

    private String ieCode;

    private String expAgency;

    private java.time.LocalDateTime leoDate;

    private Long osPeriod;

    private String adBillNo;

    private String status;

    private java.time.LocalDateTime invDate;

    private String invStatus;

    private java.math.BigDecimal fobAmt;

    private String fobCcy;

    private java.math.BigDecimal utilFobAmt;

    private java.math.BigDecimal freightAmt;

    private String freightCcy;

    private java.math.BigDecimal utilFreightAmt;

    private java.math.BigDecimal insAmt;

    private String insCcy;

    private java.math.BigDecimal utilInsAmt;

    private Integer masterID;

    private Integer detailID;

    private Integer parentRefID;

    private Integer parentVersionID;

    private String trracsStatus;

    private String trracsErrorCode;

    private String trracsErrorDecs;

    private String counterParty;

    private String writeOffBy;

    private String writeOffReason;

    private java.math.BigDecimal sbAmount;

    private String sbCcy;

    private java.math.BigDecimal sbUtilAmt;

    private java.math.BigDecimal sbOsAmt;

    private String billrefno;

    private String billNo;

    private String reqType;

    private String remarks;

    private String finalErrorDesc;

    private String finalStatus;

    public FgEdpmsSbReq() {
    }

    public FgEdpmsSbReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String existAd, String newAd, String adjRefNo, Long invSlNo, String invNo, String adjInd, java.math.BigDecimal adjAmt, String billClInd, String extRefNo, String extBy, java.time.LocalDateTime extDateSb, String remarksSb, String bankRefNo, java.math.BigDecimal amtUtil, String portcode, String expType, String shipbillno, java.time.LocalDateTime shipbilldate, String formno, String adCode, String ieCode, String expAgency, java.time.LocalDateTime leoDate, Long osPeriod, String adBillNo, String status, java.time.LocalDateTime invDate, String invStatus, java.math.BigDecimal fobAmt, String fobCcy, java.math.BigDecimal utilFobAmt, java.math.BigDecimal freightAmt, String freightCcy, java.math.BigDecimal utilFreightAmt, java.math.BigDecimal insAmt, String insCcy, java.math.BigDecimal utilInsAmt, Integer masterID, Integer detailID, Integer parentRefID, Integer parentVersionID, String trracsStatus, String trracsErrorCode, String trracsErrorDecs, String counterParty, String writeOffBy, String writeOffReason, java.math.BigDecimal sbAmount, String sbCcy, java.math.BigDecimal sbUtilAmt, java.math.BigDecimal sbOsAmt, String billrefno, String billNo, String reqType, String remarks, String finalErrorDesc, String finalStatus) {
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
        this.existAd = existAd;
        this.newAd = newAd;
        this.adjRefNo = adjRefNo;
        this.invSlNo = invSlNo;
        this.invNo = invNo;
        this.adjInd = adjInd;
        this.adjAmt = adjAmt;
        this.billClInd = billClInd;
        this.extRefNo = extRefNo;
        this.extBy = extBy;
        this.extDateSb = extDateSb;
        this.remarksSb = remarksSb;
        this.bankRefNo = bankRefNo;
        this.amtUtil = amtUtil;
        this.portcode = portcode;
        this.expType = expType;
        this.shipbillno = shipbillno;
        this.shipbilldate = shipbilldate;
        this.formno = formno;
        this.adCode = adCode;
        this.ieCode = ieCode;
        this.expAgency = expAgency;
        this.leoDate = leoDate;
        this.osPeriod = osPeriod;
        this.adBillNo = adBillNo;
        this.status = status;
        this.invDate = invDate;
        this.invStatus = invStatus;
        this.fobAmt = fobAmt;
        this.fobCcy = fobCcy;
        this.utilFobAmt = utilFobAmt;
        this.freightAmt = freightAmt;
        this.freightCcy = freightCcy;
        this.utilFreightAmt = utilFreightAmt;
        this.insAmt = insAmt;
        this.insCcy = insCcy;
        this.utilInsAmt = utilInsAmt;
        this.masterID = masterID;
        this.detailID = detailID;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.trracsStatus = trracsStatus;
        this.trracsErrorCode = trracsErrorCode;
        this.trracsErrorDecs = trracsErrorDecs;
        this.counterParty = counterParty;
        this.writeOffBy = writeOffBy;
        this.writeOffReason = writeOffReason;
        this.sbAmount = sbAmount;
        this.sbCcy = sbCcy;
        this.sbUtilAmt = sbUtilAmt;
        this.sbOsAmt = sbOsAmt;
        this.billrefno = billrefno;
        this.billNo = billNo;
        this.reqType = reqType;
        this.remarks = remarks;
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

    public String getExistAd() {
        return existAd;
    }

    public void setExistAd(String existAd) {
        this.existAd = existAd;
    }

    public String getNewAd() {
        return newAd;
    }

    public void setNewAd(String newAd) {
        this.newAd = newAd;
    }

    public String getAdjRefNo() {
        return adjRefNo;
    }

    public void setAdjRefNo(String adjRefNo) {
        this.adjRefNo = adjRefNo;
    }

    public Long getInvSlNo() {
        return invSlNo;
    }

    public void setInvSlNo(Long invSlNo) {
        this.invSlNo = invSlNo;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getAdjInd() {
        return adjInd;
    }

    public void setAdjInd(String adjInd) {
        this.adjInd = adjInd;
    }

    public java.math.BigDecimal getAdjAmt() {
        return adjAmt;
    }

    public void setAdjAmt(java.math.BigDecimal adjAmt) {
        this.adjAmt = adjAmt;
    }

    public String getBillClInd() {
        return billClInd;
    }

    public void setBillClInd(String billClInd) {
        this.billClInd = billClInd;
    }

    public String getExtRefNo() {
        return extRefNo;
    }

    public void setExtRefNo(String extRefNo) {
        this.extRefNo = extRefNo;
    }

    public String getExtBy() {
        return extBy;
    }

    public void setExtBy(String extBy) {
        this.extBy = extBy;
    }

    public java.time.LocalDateTime getExtDateSb() {
        return extDateSb;
    }

    public void setExtDateSb(java.time.LocalDateTime extDateSb) {
        this.extDateSb = extDateSb;
    }

    public String getRemarksSb() {
        return remarksSb;
    }

    public void setRemarksSb(String remarksSb) {
        this.remarksSb = remarksSb;
    }

    public String getBankRefNo() {
        return bankRefNo;
    }

    public void setBankRefNo(String bankRefNo) {
        this.bankRefNo = bankRefNo;
    }

    public java.math.BigDecimal getAmtUtil() {
        return amtUtil;
    }

    public void setAmtUtil(java.math.BigDecimal amtUtil) {
        this.amtUtil = amtUtil;
    }

    public String getPortcode() {
        return portcode;
    }

    public void setPortcode(String portcode) {
        this.portcode = portcode;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getShipbillno() {
        return shipbillno;
    }

    public void setShipbillno(String shipbillno) {
        this.shipbillno = shipbillno;
    }

    public java.time.LocalDateTime getShipbilldate() {
        return shipbilldate;
    }

    public void setShipbilldate(java.time.LocalDateTime shipbilldate) {
        this.shipbilldate = shipbilldate;
    }

    public String getFormno() {
        return formno;
    }

    public void setFormno(String formno) {
        this.formno = formno;
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

    public String getExpAgency() {
        return expAgency;
    }

    public void setExpAgency(String expAgency) {
        this.expAgency = expAgency;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public java.math.BigDecimal getUtilFobAmt() {
        return utilFobAmt;
    }

    public void setUtilFobAmt(java.math.BigDecimal utilFobAmt) {
        this.utilFobAmt = utilFobAmt;
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

    public Integer getMasterID() {
        return masterID;
    }

    public void setMasterID(Integer masterID) {
        this.masterID = masterID;
    }

    public Integer getDetailID() {
        return detailID;
    }

    public void setDetailID(Integer detailID) {
        this.detailID = detailID;
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

    public String getTrracsErrorDecs() {
        return trracsErrorDecs;
    }

    public void setTrracsErrorDecs(String trracsErrorDecs) {
        this.trracsErrorDecs = trracsErrorDecs;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getWriteOffBy() {
        return writeOffBy;
    }

    public void setWriteOffBy(String writeOffBy) {
        this.writeOffBy = writeOffBy;
    }

    public String getWriteOffReason() {
        return writeOffReason;
    }

    public void setWriteOffReason(String writeOffReason) {
        this.writeOffReason = writeOffReason;
    }

    public java.math.BigDecimal getSbAmount() {
        return sbAmount;
    }

    public void setSbAmount(java.math.BigDecimal sbAmount) {
        this.sbAmount = sbAmount;
    }

    public String getSbCcy() {
        return sbCcy;
    }

    public void setSbCcy(String sbCcy) {
        this.sbCcy = sbCcy;
    }

    public java.math.BigDecimal getSbUtilAmt() {
        return sbUtilAmt;
    }

    public void setSbUtilAmt(java.math.BigDecimal sbUtilAmt) {
        this.sbUtilAmt = sbUtilAmt;
    }

    public java.math.BigDecimal getSbOsAmt() {
        return sbOsAmt;
    }

    public void setSbOsAmt(java.math.BigDecimal sbOsAmt) {
        this.sbOsAmt = sbOsAmt;
    }

    public String getBillrefno() {
        return billrefno;
    }

    public void setBillrefno(String billrefno) {
        this.billrefno = billrefno;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

        private FgEdpmsSbReq instance = new FgEdpmsSbReq();

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

        public Builder existAd(String existAd) {
            instance.setExistAd(existAd);
            return this;
        }

        public Builder newAd(String newAd) {
            instance.setNewAd(newAd);
            return this;
        }

        public Builder adjRefNo(String adjRefNo) {
            instance.setAdjRefNo(adjRefNo);
            return this;
        }

        public Builder invSlNo(Long invSlNo) {
            instance.setInvSlNo(invSlNo);
            return this;
        }

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder adjInd(String adjInd) {
            instance.setAdjInd(adjInd);
            return this;
        }

        public Builder adjAmt(java.math.BigDecimal adjAmt) {
            instance.setAdjAmt(adjAmt);
            return this;
        }

        public Builder billClInd(String billClInd) {
            instance.setBillClInd(billClInd);
            return this;
        }

        public Builder extRefNo(String extRefNo) {
            instance.setExtRefNo(extRefNo);
            return this;
        }

        public Builder extBy(String extBy) {
            instance.setExtBy(extBy);
            return this;
        }

        public Builder extDateSb(java.time.LocalDateTime extDateSb) {
            instance.setExtDateSb(extDateSb);
            return this;
        }

        public Builder remarksSb(String remarksSb) {
            instance.setRemarksSb(remarksSb);
            return this;
        }

        public Builder bankRefNo(String bankRefNo) {
            instance.setBankRefNo(bankRefNo);
            return this;
        }

        public Builder amtUtil(java.math.BigDecimal amtUtil) {
            instance.setAmtUtil(amtUtil);
            return this;
        }

        public Builder portcode(String portcode) {
            instance.setPortcode(portcode);
            return this;
        }

        public Builder expType(String expType) {
            instance.setExpType(expType);
            return this;
        }

        public Builder shipbillno(String shipbillno) {
            instance.setShipbillno(shipbillno);
            return this;
        }

        public Builder shipbilldate(java.time.LocalDateTime shipbilldate) {
            instance.setShipbilldate(shipbilldate);
            return this;
        }

        public Builder formno(String formno) {
            instance.setFormno(formno);
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

        public Builder expAgency(String expAgency) {
            instance.setExpAgency(expAgency);
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

        public Builder status(String status) {
            instance.setStatus(status);
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

        public Builder fobAmt(java.math.BigDecimal fobAmt) {
            instance.setFobAmt(fobAmt);
            return this;
        }

        public Builder fobCcy(String fobCcy) {
            instance.setFobCcy(fobCcy);
            return this;
        }

        public Builder utilFobAmt(java.math.BigDecimal utilFobAmt) {
            instance.setUtilFobAmt(utilFobAmt);
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

        public Builder masterID(Integer masterID) {
            instance.setMasterID(masterID);
            return this;
        }

        public Builder detailID(Integer detailID) {
            instance.setDetailID(detailID);
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

        public Builder trracsErrorDecs(String trracsErrorDecs) {
            instance.setTrracsErrorDecs(trracsErrorDecs);
            return this;
        }

        public Builder counterParty(String counterParty) {
            instance.setCounterParty(counterParty);
            return this;
        }

        public Builder writeOffBy(String writeOffBy) {
            instance.setWriteOffBy(writeOffBy);
            return this;
        }

        public Builder writeOffReason(String writeOffReason) {
            instance.setWriteOffReason(writeOffReason);
            return this;
        }

        public Builder sbAmount(java.math.BigDecimal sbAmount) {
            instance.setSbAmount(sbAmount);
            return this;
        }

        public Builder sbCcy(String sbCcy) {
            instance.setSbCcy(sbCcy);
            return this;
        }

        public Builder sbUtilAmt(java.math.BigDecimal sbUtilAmt) {
            instance.setSbUtilAmt(sbUtilAmt);
            return this;
        }

        public Builder sbOsAmt(java.math.BigDecimal sbOsAmt) {
            instance.setSbOsAmt(sbOsAmt);
            return this;
        }

        public Builder billrefno(String billrefno) {
            instance.setBillrefno(billrefno);
            return this;
        }

        public Builder billNo(String billNo) {
            instance.setBillNo(billNo);
            return this;
        }

        public Builder reqType(String reqType) {
            instance.setReqType(reqType);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
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

        public FgEdpmsSbReq build() {
            return instance;
        }
    }
}
