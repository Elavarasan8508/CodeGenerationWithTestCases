package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgEdpmsIrmReq {

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

    private String irmNo;

    private String irmAd;

    private java.math.BigDecimal irmAmt;

    private java.math.BigDecimal osAmtIrm;

    private String irmCcy;

    private String ieCodeIrm;

    private java.time.LocalDateTime irmDate;

    private java.math.BigDecimal irmUtilAmt;

    private String remitName;

    private String remitCountry;

    private String remitBankName;

    private String remitBankCountry;

    private String swiftOtherBankRef;

    private String purOfRemit;

    private java.math.BigDecimal amtUtil;

    private java.time.LocalDateTime extDateIrm;

    private String remarksIrme;

    private String irmAdjNo;

    private String bankRefNo;

    private java.math.BigDecimal adjAmtIrm;

    private String remarksIrma;

    private Integer parentRefID;

    private Integer parentVersionID;

    private String trracsErrorCode;

    private String trracsErrorDecs;

    private String trracsStatus;

    public FgEdpmsIrmReq() {
    }

    public FgEdpmsIrmReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String irmNo, String irmAd, java.math.BigDecimal irmAmt, java.math.BigDecimal osAmtIrm, String irmCcy, String ieCodeIrm, java.time.LocalDateTime irmDate, java.math.BigDecimal irmUtilAmt, String remitName, String remitCountry, String remitBankName, String remitBankCountry, String swiftOtherBankRef, String purOfRemit, java.math.BigDecimal amtUtil, java.time.LocalDateTime extDateIrm, String remarksIrme, String irmAdjNo, String bankRefNo, java.math.BigDecimal adjAmtIrm, String remarksIrma, Integer parentRefID, Integer parentVersionID, String trracsErrorCode, String trracsErrorDecs, String trracsStatus) {
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
        this.irmNo = irmNo;
        this.irmAd = irmAd;
        this.irmAmt = irmAmt;
        this.osAmtIrm = osAmtIrm;
        this.irmCcy = irmCcy;
        this.ieCodeIrm = ieCodeIrm;
        this.irmDate = irmDate;
        this.irmUtilAmt = irmUtilAmt;
        this.remitName = remitName;
        this.remitCountry = remitCountry;
        this.remitBankName = remitBankName;
        this.remitBankCountry = remitBankCountry;
        this.swiftOtherBankRef = swiftOtherBankRef;
        this.purOfRemit = purOfRemit;
        this.amtUtil = amtUtil;
        this.extDateIrm = extDateIrm;
        this.remarksIrme = remarksIrme;
        this.irmAdjNo = irmAdjNo;
        this.bankRefNo = bankRefNo;
        this.adjAmtIrm = adjAmtIrm;
        this.remarksIrma = remarksIrma;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.trracsErrorCode = trracsErrorCode;
        this.trracsErrorDecs = trracsErrorDecs;
        this.trracsStatus = trracsStatus;
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

    public String getIeCodeIrm() {
        return ieCodeIrm;
    }

    public void setIeCodeIrm(String ieCodeIrm) {
        this.ieCodeIrm = ieCodeIrm;
    }

    public java.time.LocalDateTime getIrmDate() {
        return irmDate;
    }

    public void setIrmDate(java.time.LocalDateTime irmDate) {
        this.irmDate = irmDate;
    }

    public java.math.BigDecimal getIrmUtilAmt() {
        return irmUtilAmt;
    }

    public void setIrmUtilAmt(java.math.BigDecimal irmUtilAmt) {
        this.irmUtilAmt = irmUtilAmt;
    }

    public String getRemitName() {
        return remitName;
    }

    public void setRemitName(String remitName) {
        this.remitName = remitName;
    }

    public String getRemitCountry() {
        return remitCountry;
    }

    public void setRemitCountry(String remitCountry) {
        this.remitCountry = remitCountry;
    }

    public String getRemitBankName() {
        return remitBankName;
    }

    public void setRemitBankName(String remitBankName) {
        this.remitBankName = remitBankName;
    }

    public String getRemitBankCountry() {
        return remitBankCountry;
    }

    public void setRemitBankCountry(String remitBankCountry) {
        this.remitBankCountry = remitBankCountry;
    }

    public String getSwiftOtherBankRef() {
        return swiftOtherBankRef;
    }

    public void setSwiftOtherBankRef(String swiftOtherBankRef) {
        this.swiftOtherBankRef = swiftOtherBankRef;
    }

    public String getPurOfRemit() {
        return purOfRemit;
    }

    public void setPurOfRemit(String purOfRemit) {
        this.purOfRemit = purOfRemit;
    }

    public java.math.BigDecimal getAmtUtil() {
        return amtUtil;
    }

    public void setAmtUtil(java.math.BigDecimal amtUtil) {
        this.amtUtil = amtUtil;
    }

    public java.time.LocalDateTime getExtDateIrm() {
        return extDateIrm;
    }

    public void setExtDateIrm(java.time.LocalDateTime extDateIrm) {
        this.extDateIrm = extDateIrm;
    }

    public String getRemarksIrme() {
        return remarksIrme;
    }

    public void setRemarksIrme(String remarksIrme) {
        this.remarksIrme = remarksIrme;
    }

    public String getIrmAdjNo() {
        return irmAdjNo;
    }

    public void setIrmAdjNo(String irmAdjNo) {
        this.irmAdjNo = irmAdjNo;
    }

    public String getBankRefNo() {
        return bankRefNo;
    }

    public void setBankRefNo(String bankRefNo) {
        this.bankRefNo = bankRefNo;
    }

    public java.math.BigDecimal getAdjAmtIrm() {
        return adjAmtIrm;
    }

    public void setAdjAmtIrm(java.math.BigDecimal adjAmtIrm) {
        this.adjAmtIrm = adjAmtIrm;
    }

    public String getRemarksIrma() {
        return remarksIrma;
    }

    public void setRemarksIrma(String remarksIrma) {
        this.remarksIrma = remarksIrma;
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

    public String getTrracsStatus() {
        return trracsStatus;
    }

    public void setTrracsStatus(String trracsStatus) {
        this.trracsStatus = trracsStatus;
    }

    public static class Builder {

        private FgEdpmsIrmReq instance = new FgEdpmsIrmReq();

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

        public Builder ieCodeIrm(String ieCodeIrm) {
            instance.setIeCodeIrm(ieCodeIrm);
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            instance.setIrmDate(irmDate);
            return this;
        }

        public Builder irmUtilAmt(java.math.BigDecimal irmUtilAmt) {
            instance.setIrmUtilAmt(irmUtilAmt);
            return this;
        }

        public Builder remitName(String remitName) {
            instance.setRemitName(remitName);
            return this;
        }

        public Builder remitCountry(String remitCountry) {
            instance.setRemitCountry(remitCountry);
            return this;
        }

        public Builder remitBankName(String remitBankName) {
            instance.setRemitBankName(remitBankName);
            return this;
        }

        public Builder remitBankCountry(String remitBankCountry) {
            instance.setRemitBankCountry(remitBankCountry);
            return this;
        }

        public Builder swiftOtherBankRef(String swiftOtherBankRef) {
            instance.setSwiftOtherBankRef(swiftOtherBankRef);
            return this;
        }

        public Builder purOfRemit(String purOfRemit) {
            instance.setPurOfRemit(purOfRemit);
            return this;
        }

        public Builder amtUtil(java.math.BigDecimal amtUtil) {
            instance.setAmtUtil(amtUtil);
            return this;
        }

        public Builder extDateIrm(java.time.LocalDateTime extDateIrm) {
            instance.setExtDateIrm(extDateIrm);
            return this;
        }

        public Builder remarksIrme(String remarksIrme) {
            instance.setRemarksIrme(remarksIrme);
            return this;
        }

        public Builder irmAdjNo(String irmAdjNo) {
            instance.setIrmAdjNo(irmAdjNo);
            return this;
        }

        public Builder bankRefNo(String bankRefNo) {
            instance.setBankRefNo(bankRefNo);
            return this;
        }

        public Builder adjAmtIrm(java.math.BigDecimal adjAmtIrm) {
            instance.setAdjAmtIrm(adjAmtIrm);
            return this;
        }

        public Builder remarksIrma(String remarksIrma) {
            instance.setRemarksIrma(remarksIrma);
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

        public Builder trracsErrorCode(String trracsErrorCode) {
            instance.setTrracsErrorCode(trracsErrorCode);
            return this;
        }

        public Builder trracsErrorDecs(String trracsErrorDecs) {
            instance.setTrracsErrorDecs(trracsErrorDecs);
            return this;
        }

        public Builder trracsStatus(String trracsStatus) {
            instance.setTrracsStatus(trracsStatus);
            return this;
        }

        public FgEdpmsIrmReq build() {
            return instance;
        }
    }
}
