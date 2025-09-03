package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgModCaseEntity {

    private Integer ID;

    private Integer versionID;

    private Integer referenceID;

    private String applicantPartyCode;

    private Integer applicantRefID;

    private String issuingPartyCode;

    private String typeCode;

    private String subTypeCode;

    private Integer processID;

    private String templateJson;

    private String activeCode;

    private String statusCode;

    private String stageCode;

    private Integer isMasterVersion;

    private java.math.BigDecimal createdBy;

    private String createdOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private Integer attachmentID;

    public FgModCaseEntity() {
    }

    public FgModCaseEntity(Integer ID, Integer versionID, Integer referenceID, String applicantPartyCode, Integer applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, Integer processID, String templateJson, String activeCode, String statusCode, String stageCode, Integer isMasterVersion, java.math.BigDecimal createdBy, String createdOn, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, Integer attachmentID) {
        this.ID = ID;
        this.versionID = versionID;
        this.referenceID = referenceID;
        this.applicantPartyCode = applicantPartyCode;
        this.applicantRefID = applicantRefID;
        this.issuingPartyCode = issuingPartyCode;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.processID = processID;
        this.templateJson = templateJson;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.stageCode = stageCode;
        this.isMasterVersion = isMasterVersion;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.attachmentID = attachmentID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public Integer getApplicantRefID() {
        return applicantRefID;
    }

    public void setApplicantRefID(Integer applicantRefID) {
        this.applicantRefID = applicantRefID;
    }

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public String getTemplateJson() {
        return templateJson;
    }

    public void setTemplateJson(String templateJson) {
        this.templateJson = templateJson;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public Integer getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(Integer attachmentID) {
        this.attachmentID = attachmentID;
    }

    public static class Builder {

        private FgModCaseEntity instance = new FgModCaseEntity();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder applicantRefID(Integer applicantRefID) {
            instance.setApplicantRefID(applicantRefID);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
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

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder templateJson(String templateJson) {
            instance.setTemplateJson(templateJson);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder attachmentID(Integer attachmentID) {
            instance.setAttachmentID(attachmentID);
            return this;
        }

        public FgModCaseEntity build() {
            return instance;
        }
    }
}
