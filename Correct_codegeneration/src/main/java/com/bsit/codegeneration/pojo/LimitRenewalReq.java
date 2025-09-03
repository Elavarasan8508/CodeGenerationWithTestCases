package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LimitRenewalReq {

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

    private Long corpCrn;

    private String corpCrnName;

    private Long userCrn;

    private String userCrnName;

    private java.time.LocalDateTime nextReviewDate;

    private java.math.BigDecimal technicalFees;

    private java.math.BigDecimal adminChrgs;

    private java.math.BigDecimal procFee;

    private java.math.BigDecimal totalGst;

    private String remarks;

    private String offerReference;

    private String productStatusCode;

    public LimitRenewalReq() {
    }

    public LimitRenewalReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, Long corpCrn, String corpCrnName, Long userCrn, String userCrnName, java.time.LocalDateTime nextReviewDate, java.math.BigDecimal technicalFees, java.math.BigDecimal adminChrgs, java.math.BigDecimal procFee, java.math.BigDecimal totalGst, String remarks, String offerReference, String productStatusCode) {
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
        this.corpCrn = corpCrn;
        this.corpCrnName = corpCrnName;
        this.userCrn = userCrn;
        this.userCrnName = userCrnName;
        this.nextReviewDate = nextReviewDate;
        this.technicalFees = technicalFees;
        this.adminChrgs = adminChrgs;
        this.procFee = procFee;
        this.totalGst = totalGst;
        this.remarks = remarks;
        this.offerReference = offerReference;
        this.productStatusCode = productStatusCode;
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

    public Long getCorpCrn() {
        return corpCrn;
    }

    public void setCorpCrn(Long corpCrn) {
        this.corpCrn = corpCrn;
    }

    public String getCorpCrnName() {
        return corpCrnName;
    }

    public void setCorpCrnName(String corpCrnName) {
        this.corpCrnName = corpCrnName;
    }

    public Long getUserCrn() {
        return userCrn;
    }

    public void setUserCrn(Long userCrn) {
        this.userCrn = userCrn;
    }

    public String getUserCrnName() {
        return userCrnName;
    }

    public void setUserCrnName(String userCrnName) {
        this.userCrnName = userCrnName;
    }

    public java.time.LocalDateTime getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(java.time.LocalDateTime nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public java.math.BigDecimal getTechnicalFees() {
        return technicalFees;
    }

    public void setTechnicalFees(java.math.BigDecimal technicalFees) {
        this.technicalFees = technicalFees;
    }

    public java.math.BigDecimal getAdminChrgs() {
        return adminChrgs;
    }

    public void setAdminChrgs(java.math.BigDecimal adminChrgs) {
        this.adminChrgs = adminChrgs;
    }

    public java.math.BigDecimal getProcFee() {
        return procFee;
    }

    public void setProcFee(java.math.BigDecimal procFee) {
        this.procFee = procFee;
    }

    public java.math.BigDecimal getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(java.math.BigDecimal totalGst) {
        this.totalGst = totalGst;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOfferReference() {
        return offerReference;
    }

    public void setOfferReference(String offerReference) {
        this.offerReference = offerReference;
    }

    public String getProductStatusCode() {
        return productStatusCode;
    }

    public void setProductStatusCode(String productStatusCode) {
        this.productStatusCode = productStatusCode;
    }

    public static class Builder {

        private LimitRenewalReq instance = new LimitRenewalReq();

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

        public Builder corpCrn(Long corpCrn) {
            instance.setCorpCrn(corpCrn);
            return this;
        }

        public Builder corpCrnName(String corpCrnName) {
            instance.setCorpCrnName(corpCrnName);
            return this;
        }

        public Builder userCrn(Long userCrn) {
            instance.setUserCrn(userCrn);
            return this;
        }

        public Builder userCrnName(String userCrnName) {
            instance.setUserCrnName(userCrnName);
            return this;
        }

        public Builder nextReviewDate(java.time.LocalDateTime nextReviewDate) {
            instance.setNextReviewDate(nextReviewDate);
            return this;
        }

        public Builder technicalFees(java.math.BigDecimal technicalFees) {
            instance.setTechnicalFees(technicalFees);
            return this;
        }

        public Builder adminChrgs(java.math.BigDecimal adminChrgs) {
            instance.setAdminChrgs(adminChrgs);
            return this;
        }

        public Builder procFee(java.math.BigDecimal procFee) {
            instance.setProcFee(procFee);
            return this;
        }

        public Builder totalGst(java.math.BigDecimal totalGst) {
            instance.setTotalGst(totalGst);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder offerReference(String offerReference) {
            instance.setOfferReference(offerReference);
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            instance.setProductStatusCode(productStatusCode);
            return this;
        }

        public LimitRenewalReq build() {
            return instance;
        }
    }
}
