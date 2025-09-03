package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdFtView {

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

    private String curCode;

    private java.time.LocalDateTime lodgeDate;

    private String drawee;

    private java.math.BigDecimal outstandingAmt;

    private java.math.BigDecimal outstandingAmtSettled;

    private java.math.BigDecimal dspAmt;

    private java.math.BigDecimal deduction;

    private String reason;

    private Integer ocfRefID;

    private String applicantParty;

    public FgTrdFtView() {
    }

    public FgTrdFtView(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String curCode, java.time.LocalDateTime lodgeDate, String drawee, java.math.BigDecimal outstandingAmt, java.math.BigDecimal outstandingAmtSettled, java.math.BigDecimal dspAmt, java.math.BigDecimal deduction, String reason, Integer ocfRefID, String applicantParty) {
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
        this.curCode = curCode;
        this.lodgeDate = lodgeDate;
        this.drawee = drawee;
        this.outstandingAmt = outstandingAmt;
        this.outstandingAmtSettled = outstandingAmtSettled;
        this.dspAmt = dspAmt;
        this.deduction = deduction;
        this.reason = reason;
        this.ocfRefID = ocfRefID;
        this.applicantParty = applicantParty;
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

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public java.time.LocalDateTime getLodgeDate() {
        return lodgeDate;
    }

    public void setLodgeDate(java.time.LocalDateTime lodgeDate) {
        this.lodgeDate = lodgeDate;
    }

    public String getDrawee() {
        return drawee;
    }

    public void setDrawee(String drawee) {
        this.drawee = drawee;
    }

    public java.math.BigDecimal getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(java.math.BigDecimal outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public java.math.BigDecimal getOutstandingAmtSettled() {
        return outstandingAmtSettled;
    }

    public void setOutstandingAmtSettled(java.math.BigDecimal outstandingAmtSettled) {
        this.outstandingAmtSettled = outstandingAmtSettled;
    }

    public java.math.BigDecimal getDspAmt() {
        return dspAmt;
    }

    public void setDspAmt(java.math.BigDecimal dspAmt) {
        this.dspAmt = dspAmt;
    }

    public java.math.BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(java.math.BigDecimal deduction) {
        this.deduction = deduction;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getOcfRefID() {
        return ocfRefID;
    }

    public void setOcfRefID(Integer ocfRefID) {
        this.ocfRefID = ocfRefID;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public static class Builder {

        private FgTrdFtView instance = new FgTrdFtView();

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

        public Builder curCode(String curCode) {
            instance.setCurCode(curCode);
            return this;
        }

        public Builder lodgeDate(java.time.LocalDateTime lodgeDate) {
            instance.setLodgeDate(lodgeDate);
            return this;
        }

        public Builder drawee(String drawee) {
            instance.setDrawee(drawee);
            return this;
        }

        public Builder outstandingAmt(java.math.BigDecimal outstandingAmt) {
            instance.setOutstandingAmt(outstandingAmt);
            return this;
        }

        public Builder outstandingAmtSettled(java.math.BigDecimal outstandingAmtSettled) {
            instance.setOutstandingAmtSettled(outstandingAmtSettled);
            return this;
        }

        public Builder dspAmt(java.math.BigDecimal dspAmt) {
            instance.setDspAmt(dspAmt);
            return this;
        }

        public Builder deduction(java.math.BigDecimal deduction) {
            instance.setDeduction(deduction);
            return this;
        }

        public Builder reason(String reason) {
            instance.setReason(reason);
            return this;
        }

        public Builder ocfRefID(Integer ocfRefID) {
            instance.setOcfRefID(ocfRefID);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public FgTrdFtView build() {
            return instance;
        }
    }
}
