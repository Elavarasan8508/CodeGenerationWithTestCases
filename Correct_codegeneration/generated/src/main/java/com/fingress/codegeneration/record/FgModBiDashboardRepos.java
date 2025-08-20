package com.bsit.codegeneration.record;

public record FgModBiDashboardRepos(Long ID, String referenceID, String typeCode, String subTypeCode, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, Long lastAuthorisedBy, String lastAuthorisedOn, Long versionID, Long boardID, String boardName, String categoryName, String partyType, String partyCode, String partyUserType, String partyUserCode, Long isMasterVersion, String layoutJson, Long companyID, Long userID, Long isDefault) {

    public static class Builder {

        private Long ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private Long versionID;

        private Long boardID;

        private String boardName;

        private String categoryName;

        private String partyType;

        private String partyCode;

        private String partyUserType;

        private String partyUserCode;

        private Long isMasterVersion;

        private String layoutJson;

        private Long companyID;

        private Long userID;

        private Long isDefault;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
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

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder boardID(Long boardID) {
            this.boardID = boardID;
            return this;
        }

        public Builder boardName(String boardName) {
            this.boardName = boardName;
            return this;
        }

        public Builder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder partyType(String partyType) {
            this.partyType = partyType;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder partyUserType(String partyUserType) {
            this.partyUserType = partyUserType;
            return this;
        }

        public Builder partyUserCode(String partyUserCode) {
            this.partyUserCode = partyUserCode;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder layoutJson(String layoutJson) {
            this.layoutJson = layoutJson;
            return this;
        }

        public Builder companyID(Long companyID) {
            this.companyID = companyID;
            return this;
        }

        public Builder userID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder isDefault(Long isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public FgModBiDashboardRepos build() {
            return new FgModBiDashboardRepos(ID, referenceID, typeCode, subTypeCode, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedBy, lastAuthorisedOn, versionID, boardID, boardName, categoryName, partyType, partyCode, partyUserType, partyUserCode, isMasterVersion, layoutJson, companyID, userID, isDefault);
        }
    }
}
