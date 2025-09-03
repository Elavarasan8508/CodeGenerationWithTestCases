package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyProfile(Integer ID, Integer orgID, Integer orgVersionID, String orgCode, String profileTypeCode, String profileText, String template, Integer userID, Integer userVersionID, String statusCode, String authStatusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgParty fgParty) {

    public static class Builder {

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

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgParty fgParty;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder orgID(Integer orgID) {
            this.orgID = orgID;
            return this;
        }

        public Builder orgVersionID(Integer orgVersionID) {
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

        public Builder userID(Integer userID) {
            this.userID = userID;
            return this;
        }

        public Builder userVersionID(Integer userVersionID) {
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

        public Builder fgParty(FgParty fgParty) {
            this.fgParty = fgParty;
            return this;
        }

        public FgPartyProfile build() {
            return new FgPartyProfile(ID, orgID, orgVersionID, orgCode, profileTypeCode, profileText, template, userID, userVersionID, statusCode, authStatusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgParty);
        }
    }
}
