package com.bsit.codegeneration.record;

import java.util.List;

public record FgUserGroup(Integer ID, String partyCode, Integer userID, Integer groupID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgGroup fgGroup) {

    public static class Builder {

        private Integer ID;

        private String partyCode;

        private Integer userID;

        private Integer groupID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgGroup fgGroup;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder userID(Integer userID) {
            this.userID = userID;
            return this;
        }

        public Builder groupID(Integer groupID) {
            this.groupID = groupID;
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

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder fgGroup(FgGroup fgGroup) {
            this.fgGroup = fgGroup;
            return this;
        }

        public FgUserGroup build() {
            return new FgUserGroup(ID, partyCode, userID, groupID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgGroup);
        }
    }
}
