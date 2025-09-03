package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTiLoans {

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

    private String custMnm;

    private java.time.LocalDateTime disbDate;

    private java.math.BigDecimal interestRepaymentAmount;

    private String masterRef;

    private java.time.LocalDateTime maturityDate;

    private String overdueYN;

    private String status;

    private Integer versionID;

    private Integer isMasterVersion;

    private java.math.BigDecimal totalRepaymentAmount;

    private java.math.BigDecimal principleRepaymentAmount;

    public FgTiLoans() {
    }

    public FgTiLoans(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String custMnm, java.time.LocalDateTime disbDate, java.math.BigDecimal interestRepaymentAmount, String masterRef, java.time.LocalDateTime maturityDate, String overdueYN, String status, Integer versionID, Integer isMasterVersion, java.math.BigDecimal totalRepaymentAmount, java.math.BigDecimal principleRepaymentAmount) {
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
        this.custMnm = custMnm;
        this.disbDate = disbDate;
        this.interestRepaymentAmount = interestRepaymentAmount;
        this.masterRef = masterRef;
        this.maturityDate = maturityDate;
        this.overdueYN = overdueYN;
        this.status = status;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.totalRepaymentAmount = totalRepaymentAmount;
        this.principleRepaymentAmount = principleRepaymentAmount;
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

    public String getCustMnm() {
        return custMnm;
    }

    public void setCustMnm(String custMnm) {
        this.custMnm = custMnm;
    }

    public java.time.LocalDateTime getDisbDate() {
        return disbDate;
    }

    public void setDisbDate(java.time.LocalDateTime disbDate) {
        this.disbDate = disbDate;
    }

    public java.math.BigDecimal getInterestRepaymentAmount() {
        return interestRepaymentAmount;
    }

    public void setInterestRepaymentAmount(java.math.BigDecimal interestRepaymentAmount) {
        this.interestRepaymentAmount = interestRepaymentAmount;
    }

    public String getMasterRef() {
        return masterRef;
    }

    public void setMasterRef(String masterRef) {
        this.masterRef = masterRef;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getOverdueYN() {
        return overdueYN;
    }

    public void setOverdueYN(String overdueYN) {
        this.overdueYN = overdueYN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public java.math.BigDecimal getTotalRepaymentAmount() {
        return totalRepaymentAmount;
    }

    public void setTotalRepaymentAmount(java.math.BigDecimal totalRepaymentAmount) {
        this.totalRepaymentAmount = totalRepaymentAmount;
    }

    public java.math.BigDecimal getPrincipleRepaymentAmount() {
        return principleRepaymentAmount;
    }

    public void setPrincipleRepaymentAmount(java.math.BigDecimal principleRepaymentAmount) {
        this.principleRepaymentAmount = principleRepaymentAmount;
    }

    public static class Builder {

        private FgTiLoans instance = new FgTiLoans();

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

        public Builder custMnm(String custMnm) {
            instance.setCustMnm(custMnm);
            return this;
        }

        public Builder disbDate(java.time.LocalDateTime disbDate) {
            instance.setDisbDate(disbDate);
            return this;
        }

        public Builder interestRepaymentAmount(java.math.BigDecimal interestRepaymentAmount) {
            instance.setInterestRepaymentAmount(interestRepaymentAmount);
            return this;
        }

        public Builder masterRef(String masterRef) {
            instance.setMasterRef(masterRef);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder overdueYN(String overdueYN) {
            instance.setOverdueYN(overdueYN);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder totalRepaymentAmount(java.math.BigDecimal totalRepaymentAmount) {
            instance.setTotalRepaymentAmount(totalRepaymentAmount);
            return this;
        }

        public Builder principleRepaymentAmount(java.math.BigDecimal principleRepaymentAmount) {
            instance.setPrincipleRepaymentAmount(principleRepaymentAmount);
            return this;
        }

        public FgTiLoans build() {
            return instance;
        }
    }
}
