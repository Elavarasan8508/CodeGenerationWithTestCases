package com.bsit.codegeneration.pojo;

import java.time.LocalDateTime;

public class FgPartyError {

    private Integer ignore;

    private String category;

    private String severity;

    private String typeCode;

    private String subTypeCode;

    private Integer partyReferenceID;

    private String partyCode;

    private String message;

    private String details;

    private java.time.LocalDateTime createdOn;

    private java.time.LocalDateTime lastUpdatedOn;

    private String parentPartyCode;

    public FgPartyError() {
    }

    public FgPartyError(Integer ignore, String category, String severity, String typeCode, String subTypeCode, Integer partyReferenceID, String partyCode, String message, String details, java.time.LocalDateTime createdOn, java.time.LocalDateTime lastUpdatedOn, String parentPartyCode) {
        this.ignore = ignore;
        this.category = category;
        this.severity = severity;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.partyReferenceID = partyReferenceID;
        this.partyCode = partyCode;
        this.message = message;
        this.details = details;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
        this.parentPartyCode = parentPartyCode;
    }

    public Integer getIgnore() {
        return ignore;
    }

    public void setIgnore(Integer ignore) {
        this.ignore = ignore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
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

    public Integer getPartyReferenceID() {
        return partyReferenceID;
    }

    public void setPartyReferenceID(Integer partyReferenceID) {
        this.partyReferenceID = partyReferenceID;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public java.time.LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(java.time.LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public java.time.LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(java.time.LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getParentPartyCode() {
        return parentPartyCode;
    }

    public void setParentPartyCode(String parentPartyCode) {
        this.parentPartyCode = parentPartyCode;
    }

    public static class Builder {

        private FgPartyError instance = new FgPartyError();

        public Builder ignore(Integer ignore) {
            instance.setIgnore(ignore);
            return this;
        }

        public Builder category(String category) {
            instance.setCategory(category);
            return this;
        }

        public Builder severity(String severity) {
            instance.setSeverity(severity);
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

        public Builder partyReferenceID(Integer partyReferenceID) {
            instance.setPartyReferenceID(partyReferenceID);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder message(String message) {
            instance.setMessage(message);
            return this;
        }

        public Builder details(String details) {
            instance.setDetails(details);
            return this;
        }

        public Builder createdOn(java.time.LocalDateTime createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastUpdatedOn(java.time.LocalDateTime lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder parentPartyCode(String parentPartyCode) {
            instance.setParentPartyCode(parentPartyCode);
            return this;
        }

        public FgPartyError build() {
            return instance;
        }
    }
}
