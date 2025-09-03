package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgScheduleCode {

    private Integer ID;

    private java.time.LocalDateTime endDate;

    private String name;

    private String processingType;

    private java.time.LocalDateTime startDate;

    private String template;

    private String typeCode;

    private Integer partyID;

    private Integer partyVersionID;

    private String description;

    private String applicantPartyCode;

    private Integer configRefID;

    private String categoryCode;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String subTypeCode;

    private String entityTypeCode;

    private String entitySubTypeCode;

    private Integer processID;

    private Integer referenceID;

    private Integer versionID;

    private Integer isMasterVersion;

    private String stageCode;

    private FgParty party;

    private FgParty partyVersion;

    public FgScheduleCode() {
    }

    public FgScheduleCode(Integer ID, java.time.LocalDateTime endDate, String name, String processingType, java.time.LocalDateTime startDate, String template, String typeCode, Integer partyID, Integer partyVersionID, String description, String applicantPartyCode, Integer configRefID, String categoryCode, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String subTypeCode, String entityTypeCode, String entitySubTypeCode, Integer processID, Integer referenceID, Integer versionID, Integer isMasterVersion, String stageCode, FgParty party, FgParty partyVersion) {
        this.ID = ID;
        this.endDate = endDate;
        this.name = name;
        this.processingType = processingType;
        this.startDate = startDate;
        this.template = template;
        this.typeCode = typeCode;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.description = description;
        this.applicantPartyCode = applicantPartyCode;
        this.configRefID = configRefID;
        this.categoryCode = categoryCode;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.subTypeCode = subTypeCode;
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.processID = processID;
        this.referenceID = referenceID;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.stageCode = stageCode;
        this.party = party;
        this.partyVersion = partyVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public java.time.LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(java.time.LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessingType() {
        return processingType;
    }

    public void setProcessingType(String processingType) {
        this.processingType = processingType;
    }

    public java.time.LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(java.time.LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getPartyID() {
        return partyID;
    }

    public void setPartyID(Integer partyID) {
        this.partyID = partyID;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public Integer getConfigRefID() {
        return configRefID;
    }

    public void setConfigRefID(Integer configRefID) {
        this.configRefID = configRefID;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
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

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public FgParty getParty() {
        return party;
    }

    public void setParty(FgParty party) {
        this.party = party;
    }

    public FgParty getPartyVersion() {
        return partyVersion;
    }

    public void setPartyVersion(FgParty partyVersion) {
        this.partyVersion = partyVersion;
    }

    public static class Builder {

        private FgScheduleCode instance = new FgScheduleCode();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder processingType(String processingType) {
            instance.setProcessingType(processingType);
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder partyID(Integer partyID) {
            instance.setPartyID(partyID);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder configRefID(Integer configRefID) {
            instance.setConfigRefID(configRefID);
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            instance.setCategoryCode(categoryCode);
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

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
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

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder party(FgParty party) {
            instance.setParty(party);
            return this;
        }

        public Builder partyVersion(FgParty partyVersion) {
            instance.setPartyVersion(partyVersion);
            return this;
        }

        public FgScheduleCode build() {
            return instance;
        }
    }
}
