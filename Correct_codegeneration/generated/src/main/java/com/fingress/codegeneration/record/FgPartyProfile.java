package com.bsit.codegeneration.record;

public record FgPartyProfile(Long ID, Long orgID, Long orgVersionID, String orgCode, String profileTypeCode, String profileText, String template, String userID, Long userVersionID, String statusCode, String authStatusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Long ID;

        private Long orgID;

        private Long orgVersionID;

        private String orgCode;

        private String profileTypeCode;

        private String profileText;

        private String template;

        private String userID;

        private Long userVersionID;

        private String statusCode;

        private String authStatusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder orgID(Long orgID) {
            this.orgID = orgID;
            return this;
        }

        public Builder orgVersionID(Long orgVersionID) {
            this.orgVersionID = orgVersionID;
            return this;
        }

        public Builder orgCode(String orgCode) {
            this.orgCode = orgCode;
            return this;
        }

        public Builder profileTypeCode(String profileTypeCode) {
            this.profileTypeCode = profileTypeCode;
            return this;
        }

        public Builder profileText(String profileText) {
            this.profileText = profileText;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder userID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder userVersionID(Long userVersionID) {
            this.userVersionID = userVersionID;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder authStatusCode(String authStatusCode) {
            this.authStatusCode = authStatusCode;
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

        public FgPartyProfile build() {
            return new FgPartyProfile(ID, orgID, orgVersionID, orgCode, profileTypeCode, profileText, template, userID, userVersionID, statusCode, authStatusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
