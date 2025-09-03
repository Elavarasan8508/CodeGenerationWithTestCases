package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyRelation(Integer ID, String partyFromRoleCode, String partyToRoleCode, Integer fromPartyID, Integer fromPartyVersionID, Integer toPartyID, Integer toPartyVersionID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String fromPartyUserCode, Integer fromPartyUserID, Integer fromPartyUserVersionID, FgParty fgParty) {

    public static class Builder {

        private Integer ID;

        private String partyFromRoleCode;

        private String partyToRoleCode;

        private Integer fromPartyID;

        private Integer fromPartyVersionID;

        private Integer toPartyID;

        private Integer toPartyVersionID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String fromPartyUserCode;

        private Integer fromPartyUserID;

        private Integer fromPartyUserVersionID;

        private FgParty fgParty;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyFromRoleCode(String partyFromRoleCode) {
            this.partyFromRoleCode = partyFromRoleCode;
            return this;
        }

        public Builder partyToRoleCode(String partyToRoleCode) {
            this.partyToRoleCode = partyToRoleCode;
            return this;
        }

        public Builder fromPartyID(Integer fromPartyID) {
            this.fromPartyID = fromPartyID;
            return this;
        }

        public Builder fromPartyVersionID(Integer fromPartyVersionID) {
            this.fromPartyVersionID = fromPartyVersionID;
            return this;
        }

        public Builder toPartyID(Integer toPartyID) {
            this.toPartyID = toPartyID;
            return this;
        }

        public Builder toPartyVersionID(Integer toPartyVersionID) {
            this.toPartyVersionID = toPartyVersionID;
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

        public Builder fromPartyUserCode(String fromPartyUserCode) {
            this.fromPartyUserCode = fromPartyUserCode;
            return this;
        }

        public Builder fromPartyUserID(Integer fromPartyUserID) {
            this.fromPartyUserID = fromPartyUserID;
            return this;
        }

        public Builder fromPartyUserVersionID(Integer fromPartyUserVersionID) {
            this.fromPartyUserVersionID = fromPartyUserVersionID;
            return this;
        }

        public Builder fgParty(FgParty fgParty) {
            this.fgParty = fgParty;
            return this;
        }

        public FgPartyRelation build() {
            return new FgPartyRelation(ID, partyFromRoleCode, partyToRoleCode, fromPartyID, fromPartyVersionID, toPartyID, toPartyVersionID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fromPartyUserCode, fromPartyUserID, fromPartyUserVersionID, fgParty);
        }
    }
}
