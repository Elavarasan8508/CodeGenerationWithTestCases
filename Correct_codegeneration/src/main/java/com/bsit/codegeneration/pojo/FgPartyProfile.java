package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgPartyProfile {

    private Integer ID;

    private Integer orgID;

    private Integer orgVersionID;

    private String orgCode;

    private String profileTypeCode;

    private String profileText;

    private String template;

    private Integer userID;

    private Integer userVersionID;

    private String statusCode;

    private String authStatusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgParty org;

    private FgParty orgVersion;

    public FgPartyProfile() {
    }

    public FgPartyProfile(Integer ID, Integer orgID, Integer orgVersionID, String orgCode, String profileTypeCode, String profileText, String template, Integer userID, Integer userVersionID, String statusCode, String authStatusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgParty org, FgParty orgVersion) {
        this.ID = ID;
        this.orgID = orgID;
        this.orgVersionID = orgVersionID;
        this.orgCode = orgCode;
        this.profileTypeCode = profileTypeCode;
        this.profileText = profileText;
        this.template = template;
        this.userID = userID;
        this.userVersionID = userVersionID;
        this.statusCode = statusCode;
        this.authStatusCode = authStatusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.org = org;
        this.orgVersion = orgVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getOrgID() {
        return orgID;
    }

    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }

    public Integer getOrgVersionID() {
        return orgVersionID;
    }

    public void setOrgVersionID(Integer orgVersionID) {
        this.orgVersionID = orgVersionID;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getProfileTypeCode() {
        return profileTypeCode;
    }

    public void setProfileTypeCode(String profileTypeCode) {
        this.profileTypeCode = profileTypeCode;
    }

    public String getProfileText() {
        return profileText;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserVersionID() {
        return userVersionID;
    }

    public void setUserVersionID(Integer userVersionID) {
        this.userVersionID = userVersionID;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getAuthStatusCode() {
        return authStatusCode;
    }

    public void setAuthStatusCode(String authStatusCode) {
        this.authStatusCode = authStatusCode;
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

    public FgParty getOrg() {
        return org;
    }

    public void setOrg(FgParty org) {
        this.org = org;
    }

    public FgParty getOrgVersion() {
        return orgVersion;
    }

    public void setOrgVersion(FgParty orgVersion) {
        this.orgVersion = orgVersion;
    }

    public static class Builder {

        private FgPartyProfile instance = new FgPartyProfile();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder orgID(Integer orgID) {
            instance.setOrgID(orgID);
            return this;
        }

        public Builder orgVersionID(Integer orgVersionID) {
            instance.setOrgVersionID(orgVersionID);
            return this;
        }

        public Builder orgCode(String orgCode) {
            instance.setOrgCode(orgCode);
            return this;
        }

        public Builder profileTypeCode(String profileTypeCode) {
            instance.setProfileTypeCode(profileTypeCode);
            return this;
        }

        public Builder profileText(String profileText) {
            instance.setProfileText(profileText);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder userID(Integer userID) {
            instance.setUserID(userID);
            return this;
        }

        public Builder userVersionID(Integer userVersionID) {
            instance.setUserVersionID(userVersionID);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder authStatusCode(String authStatusCode) {
            instance.setAuthStatusCode(authStatusCode);
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

        public Builder org(FgParty org) {
            instance.setOrg(org);
            return this;
        }

        public Builder orgVersion(FgParty orgVersion) {
            instance.setOrgVersion(orgVersion);
            return this;
        }

        public FgPartyProfile build() {
            return instance;
        }
    }
}
