package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgTdOtpReq {

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

    private Long otpCount;

    private Long otpResent;

    private Long otpFailedCount;

    private String otpSentTime;

    private String otpLockedTime;

    private String otpUnlockTime;

    private String userCrn;

    private String entityTypeCode;

    private String mobileMasked;

    private String emailMasked;

    public FgTdOtpReq() {
    }

    public FgTdOtpReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, Long otpCount, Long otpResent, Long otpFailedCount, String otpSentTime, String otpLockedTime, String otpUnlockTime, String userCrn, String entityTypeCode, String mobileMasked, String emailMasked) {
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
        this.otpCount = otpCount;
        this.otpResent = otpResent;
        this.otpFailedCount = otpFailedCount;
        this.otpSentTime = otpSentTime;
        this.otpLockedTime = otpLockedTime;
        this.otpUnlockTime = otpUnlockTime;
        this.userCrn = userCrn;
        this.entityTypeCode = entityTypeCode;
        this.mobileMasked = mobileMasked;
        this.emailMasked = emailMasked;
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

    public Long getOtpCount() {
        return otpCount;
    }

    public void setOtpCount(Long otpCount) {
        this.otpCount = otpCount;
    }

    public Long getOtpResent() {
        return otpResent;
    }

    public void setOtpResent(Long otpResent) {
        this.otpResent = otpResent;
    }

    public Long getOtpFailedCount() {
        return otpFailedCount;
    }

    public void setOtpFailedCount(Long otpFailedCount) {
        this.otpFailedCount = otpFailedCount;
    }

    public String getOtpSentTime() {
        return otpSentTime;
    }

    public void setOtpSentTime(String otpSentTime) {
        this.otpSentTime = otpSentTime;
    }

    public String getOtpLockedTime() {
        return otpLockedTime;
    }

    public void setOtpLockedTime(String otpLockedTime) {
        this.otpLockedTime = otpLockedTime;
    }

    public String getOtpUnlockTime() {
        return otpUnlockTime;
    }

    public void setOtpUnlockTime(String otpUnlockTime) {
        this.otpUnlockTime = otpUnlockTime;
    }

    public String getUserCrn() {
        return userCrn;
    }

    public void setUserCrn(String userCrn) {
        this.userCrn = userCrn;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getMobileMasked() {
        return mobileMasked;
    }

    public void setMobileMasked(String mobileMasked) {
        this.mobileMasked = mobileMasked;
    }

    public String getEmailMasked() {
        return emailMasked;
    }

    public void setEmailMasked(String emailMasked) {
        this.emailMasked = emailMasked;
    }

    public static class Builder {

        private FgTdOtpReq instance = new FgTdOtpReq();

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

        public Builder otpCount(Long otpCount) {
            instance.setOtpCount(otpCount);
            return this;
        }

        public Builder otpResent(Long otpResent) {
            instance.setOtpResent(otpResent);
            return this;
        }

        public Builder otpFailedCount(Long otpFailedCount) {
            instance.setOtpFailedCount(otpFailedCount);
            return this;
        }

        public Builder otpSentTime(String otpSentTime) {
            instance.setOtpSentTime(otpSentTime);
            return this;
        }

        public Builder otpLockedTime(String otpLockedTime) {
            instance.setOtpLockedTime(otpLockedTime);
            return this;
        }

        public Builder otpUnlockTime(String otpUnlockTime) {
            instance.setOtpUnlockTime(otpUnlockTime);
            return this;
        }

        public Builder userCrn(String userCrn) {
            instance.setUserCrn(userCrn);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder mobileMasked(String mobileMasked) {
            instance.setMobileMasked(mobileMasked);
            return this;
        }

        public Builder emailMasked(String emailMasked) {
            instance.setEmailMasked(emailMasked);
            return this;
        }

        public FgTdOtpReq build() {
            return instance;
        }
    }
}
