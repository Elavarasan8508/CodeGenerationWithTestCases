package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyRole(Integer ID, Integer partyID, Integer partyVersionID, Integer roleID, Integer roleVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, Long lastAuthorisedBy, String lastAuthorisedOn, FgParty fgParty, FgRole fgRole) {

    public static class Builder {

        private Integer ID;

        private Integer partyID;

        private Integer partyVersionID;

        private Integer roleID;

        private Integer roleVersionID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private FgParty fgParty;

        private FgRole fgRole;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyID(Integer partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder roleID(Integer roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder roleVersionID(Integer roleVersionID) {
            this.roleVersionID = roleVersionID;
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

        public Builder fgParty(FgParty fgParty) {
            this.fgParty = fgParty;
            return this;
        }

        public Builder fgRole(FgRole fgRole) {
            this.fgRole = fgRole;
            return this;
        }

        public FgPartyRole build() {
            return new FgPartyRole(ID, partyID, partyVersionID, roleID, roleVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedBy, lastAuthorisedOn, fgParty, fgRole);
        }
    }
}
