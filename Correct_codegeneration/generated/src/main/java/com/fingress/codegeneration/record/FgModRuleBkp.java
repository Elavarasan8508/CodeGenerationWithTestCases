package com.bsit.codegeneration.record;

public record FgModRuleBkp(Long ID, String partyTypeCode, String partySubTypeCode, String ruleTypeCode, String partyCode, String name, String referenceID, String ruleObject, String description, String activeCode, String statusCode, String deploymentID, java.time.LocalDateTime deploymentTime, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String typeCode, String subTypeCode, String code, String stageCode, String authorisedRule, Long isSync, String syncTargetSubTypeCode, String syncSourceSubTypeCode, String lastSyncedOn, String applicantParty, String ownerPartyCode) {

    public static class Builder {

        private Long ID;

        private String partyTypeCode;

        private String partySubTypeCode;

        private String ruleTypeCode;

        private String partyCode;

        private String name;

        private String referenceID;

        private String ruleObject;

        private String description;

        private String activeCode;

        private String statusCode;

        private String deploymentID;

        private java.time.LocalDateTime deploymentTime;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String typeCode;

        private String subTypeCode;

        private String code;

        private String stageCode;

        private String authorisedRule;

        private Long isSync;

        private String syncTargetSubTypeCode;

        private String syncSourceSubTypeCode;

        private String lastSyncedOn;

        private String applicantParty;

        private String ownerPartyCode;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder ruleTypeCode(String ruleTypeCode) {
            this.ruleTypeCode = ruleTypeCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder ruleObject(String ruleObject) {
            this.ruleObject = ruleObject;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder deploymentID(String deploymentID) {
            this.deploymentID = deploymentID;
            return this;
        }

        public Builder deploymentTime(java.time.LocalDateTime deploymentTime) {
            this.deploymentTime = deploymentTime;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder authorisedRule(String authorisedRule) {
            this.authorisedRule = authorisedRule;
            return this;
        }

        public Builder isSync(Long isSync) {
            this.isSync = isSync;
            return this;
        }

        public Builder syncTargetSubTypeCode(String syncTargetSubTypeCode) {
            this.syncTargetSubTypeCode = syncTargetSubTypeCode;
            return this;
        }

        public Builder syncSourceSubTypeCode(String syncSourceSubTypeCode) {
            this.syncSourceSubTypeCode = syncSourceSubTypeCode;
            return this;
        }

        public Builder lastSyncedOn(String lastSyncedOn) {
            this.lastSyncedOn = lastSyncedOn;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder ownerPartyCode(String ownerPartyCode) {
            this.ownerPartyCode = ownerPartyCode;
            return this;
        }

        public FgModRuleBkp build() {
            return new FgModRuleBkp(ID, partyTypeCode, partySubTypeCode, ruleTypeCode, partyCode, name, referenceID, ruleObject, description, activeCode, statusCode, deploymentID, deploymentTime, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, typeCode, subTypeCode, code, stageCode, authorisedRule, isSync, syncTargetSubTypeCode, syncSourceSubTypeCode, lastSyncedOn, applicantParty, ownerPartyCode);
        }
    }
}
