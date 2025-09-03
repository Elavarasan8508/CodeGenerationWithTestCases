package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTrdPreLoans {

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

    private Integer preLoanRefID;

    private Integer loanRefID;

    private String curCode;

    private java.math.BigDecimal principalOutstanding;

    private String inLoanCur;

    private java.math.BigDecimal dspAmt;

    private java.math.BigDecimal equDspAmt;

    private Integer parentRefID;

    private Integer parentVersionID;

    private Integer irReferenceID;

    private java.time.LocalDateTime disbDate;

    private String applicantParty;

    private Integer billRefID;

    public FgTrdPreLoans() {
    }

    public FgTrdPreLoans(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, Integer preLoanRefID, Integer loanRefID, String curCode, java.math.BigDecimal principalOutstanding, String inLoanCur, java.math.BigDecimal dspAmt, java.math.BigDecimal equDspAmt, Integer parentRefID, Integer parentVersionID, Integer irReferenceID, java.time.LocalDateTime disbDate, String applicantParty, Integer billRefID) {
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
        this.preLoanRefID = preLoanRefID;
        this.loanRefID = loanRefID;
        this.curCode = curCode;
        this.principalOutstanding = principalOutstanding;
        this.inLoanCur = inLoanCur;
        this.dspAmt = dspAmt;
        this.equDspAmt = equDspAmt;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.irReferenceID = irReferenceID;
        this.disbDate = disbDate;
        this.applicantParty = applicantParty;
        this.billRefID = billRefID;
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

    public Integer getPreLoanRefID() {
        return preLoanRefID;
    }

    public void setPreLoanRefID(Integer preLoanRefID) {
        this.preLoanRefID = preLoanRefID;
    }

    public Integer getLoanRefID() {
        return loanRefID;
    }

    public void setLoanRefID(Integer loanRefID) {
        this.loanRefID = loanRefID;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public java.math.BigDecimal getPrincipalOutstanding() {
        return principalOutstanding;
    }

    public void setPrincipalOutstanding(java.math.BigDecimal principalOutstanding) {
        this.principalOutstanding = principalOutstanding;
    }

    public String getInLoanCur() {
        return inLoanCur;
    }

    public void setInLoanCur(String inLoanCur) {
        this.inLoanCur = inLoanCur;
    }

    public java.math.BigDecimal getDspAmt() {
        return dspAmt;
    }

    public void setDspAmt(java.math.BigDecimal dspAmt) {
        this.dspAmt = dspAmt;
    }

    public java.math.BigDecimal getEquDspAmt() {
        return equDspAmt;
    }

    public void setEquDspAmt(java.math.BigDecimal equDspAmt) {
        this.equDspAmt = equDspAmt;
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

    public Integer getIrReferenceID() {
        return irReferenceID;
    }

    public void setIrReferenceID(Integer irReferenceID) {
        this.irReferenceID = irReferenceID;
    }

    public java.time.LocalDateTime getDisbDate() {
        return disbDate;
    }

    public void setDisbDate(java.time.LocalDateTime disbDate) {
        this.disbDate = disbDate;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public Integer getBillRefID() {
        return billRefID;
    }

    public void setBillRefID(Integer billRefID) {
        this.billRefID = billRefID;
    }

    public static class Builder {

        private FgTrdPreLoans instance = new FgTrdPreLoans();

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

        public Builder preLoanRefID(Integer preLoanRefID) {
            instance.setPreLoanRefID(preLoanRefID);
            return this;
        }

        public Builder loanRefID(Integer loanRefID) {
            instance.setLoanRefID(loanRefID);
            return this;
        }

        public Builder curCode(String curCode) {
            instance.setCurCode(curCode);
            return this;
        }

        public Builder principalOutstanding(java.math.BigDecimal principalOutstanding) {
            instance.setPrincipalOutstanding(principalOutstanding);
            return this;
        }

        public Builder inLoanCur(String inLoanCur) {
            instance.setInLoanCur(inLoanCur);
            return this;
        }

        public Builder dspAmt(java.math.BigDecimal dspAmt) {
            instance.setDspAmt(dspAmt);
            return this;
        }

        public Builder equDspAmt(java.math.BigDecimal equDspAmt) {
            instance.setEquDspAmt(equDspAmt);
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

        public Builder irReferenceID(Integer irReferenceID) {
            instance.setIrReferenceID(irReferenceID);
            return this;
        }

        public Builder disbDate(java.time.LocalDateTime disbDate) {
            instance.setDisbDate(disbDate);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder billRefID(Integer billRefID) {
            instance.setBillRefID(billRefID);
            return this;
        }

        public FgTrdPreLoans build() {
            return instance;
        }
    }
}
