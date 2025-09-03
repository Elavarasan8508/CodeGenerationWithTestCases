package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgIdpmsOrmReq {

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

    private String ieCodeOrm;

    private String beneName;

    private String beneCountry;

    private String remitterBankName;

    private String purOfRemit;

    private java.math.BigDecimal adjAmtOrm;

    private String reasonIndicator;

    private String remarksOrm;

    private String paymentTerms;

    private Integer parentRefID;

    private Integer parentVersionID;

    private String trracsStatus;

    private String trracsErrorCode;

    private String trracsErrorDesc;

    private String reqType;

    private java.math.BigDecimal nameMatch;

    private java.math.BigDecimal utilAmt;

    private String approvedBy;

    private String paymentParty;

    private String portCode;

    private String boeNumber;

    private java.time.LocalDateTime boeDate;

    private String adCodeBoe;

    private String invoiceSlNo;

    private String invNum;

    private String docNo;

    private java.time.LocalDateTime docDate;

    private String closureIndicator;

    private java.math.BigDecimal endorsedAmt;

    private String finalErrorDesc;

    private String finalStatus;

    private String finalErrorCode;

    private String letterNo;

    private String rbiStatus;

    private String rbiErrorDesc;

    private String rbiErrorCode;

    private java.time.LocalDateTime letterDate;

    private String ieCode;

    private String remittanceCurrency;

    public FgIdpmsOrmReq() {
    }

    public FgIdpmsOrmReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String ormNumber, String adCode, java.math.BigDecimal ormAmount, java.math.BigDecimal ormUtilizedAmt, java.math.BigDecimal ormOsAmt, String ormCcy, java.time.LocalDateTime ormDate, String ieName, String ieCodeOrm, String beneName, String beneCountry, String remitterBankName, String purOfRemit, java.math.BigDecimal adjAmtOrm, String reasonIndicator, String remarksOrm, String paymentTerms, Integer parentRefID, Integer parentVersionID, String trracsStatus, String trracsErrorCode, String trracsErrorDesc, String reqType, java.math.BigDecimal nameMatch, java.math.BigDecimal utilAmt, String approvedBy, String paymentParty, String portCode, String boeNumber, java.time.LocalDateTime boeDate, String adCodeBoe, String invoiceSlNo, String invNum, String docNo, java.time.LocalDateTime docDate, String closureIndicator, java.math.BigDecimal endorsedAmt, String finalErrorDesc, String finalStatus, String finalErrorCode, String letterNo, String rbiStatus, String rbiErrorDesc, String rbiErrorCode, java.time.LocalDateTime letterDate, String ieCode, String remittanceCurrency) {
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
        this.ieCodeOrm = ieCodeOrm;
        this.beneName = beneName;
        this.beneCountry = beneCountry;
        this.remitterBankName = remitterBankName;
        this.purOfRemit = purOfRemit;
        this.adjAmtOrm = adjAmtOrm;
        this.reasonIndicator = reasonIndicator;
        this.remarksOrm = remarksOrm;
        this.paymentTerms = paymentTerms;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.trracsStatus = trracsStatus;
        this.trracsErrorCode = trracsErrorCode;
        this.trracsErrorDesc = trracsErrorDesc;
        this.reqType = reqType;
        this.nameMatch = nameMatch;
        this.utilAmt = utilAmt;
        this.approvedBy = approvedBy;
        this.paymentParty = paymentParty;
        this.portCode = portCode;
        this.boeNumber = boeNumber;
        this.boeDate = boeDate;
        this.adCodeBoe = adCodeBoe;
        this.invoiceSlNo = invoiceSlNo;
        this.invNum = invNum;
        this.docNo = docNo;
        this.docDate = docDate;
        this.closureIndicator = closureIndicator;
        this.endorsedAmt = endorsedAmt;
        this.finalErrorDesc = finalErrorDesc;
        this.finalStatus = finalStatus;
        this.finalErrorCode = finalErrorCode;
        this.letterNo = letterNo;
        this.rbiStatus = rbiStatus;
        this.rbiErrorDesc = rbiErrorDesc;
        this.rbiErrorCode = rbiErrorCode;
        this.letterDate = letterDate;
        this.ieCode = ieCode;
        this.remittanceCurrency = remittanceCurrency;
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

    public String getIeCodeOrm() {
        return ieCodeOrm;
    }

    public void setIeCodeOrm(String ieCodeOrm) {
        this.ieCodeOrm = ieCodeOrm;
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

    public java.math.BigDecimal getAdjAmtOrm() {
        return adjAmtOrm;
    }

    public void setAdjAmtOrm(java.math.BigDecimal adjAmtOrm) {
        this.adjAmtOrm = adjAmtOrm;
    }

    public String getReasonIndicator() {
        return reasonIndicator;
    }

    public void setReasonIndicator(String reasonIndicator) {
        this.reasonIndicator = reasonIndicator;
    }

    public String getRemarksOrm() {
        return remarksOrm;
    }

    public void setRemarksOrm(String remarksOrm) {
        this.remarksOrm = remarksOrm;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
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

    public java.math.BigDecimal getNameMatch() {
        return nameMatch;
    }

    public void setNameMatch(java.math.BigDecimal nameMatch) {
        this.nameMatch = nameMatch;
    }

    public java.math.BigDecimal getUtilAmt() {
        return utilAmt;
    }

    public void setUtilAmt(java.math.BigDecimal utilAmt) {
        this.utilAmt = utilAmt;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getPaymentParty() {
        return paymentParty;
    }

    public void setPaymentParty(String paymentParty) {
        this.paymentParty = paymentParty;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
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

    public String getAdCodeBoe() {
        return adCodeBoe;
    }

    public void setAdCodeBoe(String adCodeBoe) {
        this.adCodeBoe = adCodeBoe;
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

    public String getClosureIndicator() {
        return closureIndicator;
    }

    public void setClosureIndicator(String closureIndicator) {
        this.closureIndicator = closureIndicator;
    }

    public java.math.BigDecimal getEndorsedAmt() {
        return endorsedAmt;
    }

    public void setEndorsedAmt(java.math.BigDecimal endorsedAmt) {
        this.endorsedAmt = endorsedAmt;
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

    public String getFinalErrorCode() {
        return finalErrorCode;
    }

    public void setFinalErrorCode(String finalErrorCode) {
        this.finalErrorCode = finalErrorCode;
    }

    public String getLetterNo() {
        return letterNo;
    }

    public void setLetterNo(String letterNo) {
        this.letterNo = letterNo;
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

    public java.time.LocalDateTime getLetterDate() {
        return letterDate;
    }

    public void setLetterDate(java.time.LocalDateTime letterDate) {
        this.letterDate = letterDate;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public String getRemittanceCurrency() {
        return remittanceCurrency;
    }

    public void setRemittanceCurrency(String remittanceCurrency) {
        this.remittanceCurrency = remittanceCurrency;
    }

    public static class Builder {

        private FgIdpmsOrmReq instance = new FgIdpmsOrmReq();

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

        public Builder ieCodeOrm(String ieCodeOrm) {
            instance.setIeCodeOrm(ieCodeOrm);
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

        public Builder adjAmtOrm(java.math.BigDecimal adjAmtOrm) {
            instance.setAdjAmtOrm(adjAmtOrm);
            return this;
        }

        public Builder reasonIndicator(String reasonIndicator) {
            instance.setReasonIndicator(reasonIndicator);
            return this;
        }

        public Builder remarksOrm(String remarksOrm) {
            instance.setRemarksOrm(remarksOrm);
            return this;
        }

        public Builder paymentTerms(String paymentTerms) {
            instance.setPaymentTerms(paymentTerms);
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

        public Builder nameMatch(java.math.BigDecimal nameMatch) {
            instance.setNameMatch(nameMatch);
            return this;
        }

        public Builder utilAmt(java.math.BigDecimal utilAmt) {
            instance.setUtilAmt(utilAmt);
            return this;
        }

        public Builder approvedBy(String approvedBy) {
            instance.setApprovedBy(approvedBy);
            return this;
        }

        public Builder paymentParty(String paymentParty) {
            instance.setPaymentParty(paymentParty);
            return this;
        }

        public Builder portCode(String portCode) {
            instance.setPortCode(portCode);
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

        public Builder adCodeBoe(String adCodeBoe) {
            instance.setAdCodeBoe(adCodeBoe);
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

        public Builder docNo(String docNo) {
            instance.setDocNo(docNo);
            return this;
        }

        public Builder docDate(java.time.LocalDateTime docDate) {
            instance.setDocDate(docDate);
            return this;
        }

        public Builder closureIndicator(String closureIndicator) {
            instance.setClosureIndicator(closureIndicator);
            return this;
        }

        public Builder endorsedAmt(java.math.BigDecimal endorsedAmt) {
            instance.setEndorsedAmt(endorsedAmt);
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

        public Builder finalErrorCode(String finalErrorCode) {
            instance.setFinalErrorCode(finalErrorCode);
            return this;
        }

        public Builder letterNo(String letterNo) {
            instance.setLetterNo(letterNo);
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

        public Builder letterDate(java.time.LocalDateTime letterDate) {
            instance.setLetterDate(letterDate);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder remittanceCurrency(String remittanceCurrency) {
            instance.setRemittanceCurrency(remittanceCurrency);
            return this;
        }

        public FgIdpmsOrmReq build() {
            return instance;
        }
    }
}
