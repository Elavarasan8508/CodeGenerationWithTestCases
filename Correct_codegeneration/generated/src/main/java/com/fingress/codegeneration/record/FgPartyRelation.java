package com.bsit.codegeneration.record;

public record FgPartyRelation(Long ID, String partyFromRoleCode, String partyToRoleCode, Long fromPartyID, Long fromPartyVersionID, Long toPartyID, Long toPartyVersionID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String fromPartyUserCode, Long fromPartyUserID, Long fromPartyUserVersionID) {

    public static class Builder {

        private Long ID;

        private String partyFromRoleCode;

        private String partyToRoleCode;

        private Long fromPartyID;

        private Long fromPartyVersionID;

        private Long toPartyID;

        private Long toPartyVersionID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String fromPartyUserCode;

        private Long fromPartyUserID;

        private Long fromPartyUserVersionID;

        public Builder ID(Long ID) {
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

        public Builder fromPartyID(Long fromPartyID) {
            this.fromPartyID = fromPartyID;
            return this;
        }

        public Builder fromPartyVersionID(Long fromPartyVersionID) {
            this.fromPartyVersionID = fromPartyVersionID;
            return this;
        }

        public Builder toPartyID(Long toPartyID) {
            this.toPartyID = toPartyID;
            return this;
        }

        public Builder toPartyVersionID(Long toPartyVersionID) {
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

        public Builder fromPartyUserID(Long fromPartyUserID) {
            this.fromPartyUserID = fromPartyUserID;
            return this;
        }

        public Builder fromPartyUserVersionID(Long fromPartyUserVersionID) {
            this.fromPartyUserVersionID = fromPartyUserVersionID;
            return this;
        }

        public FgPartyRelation build() {
            return new FgPartyRelation(ID, partyFromRoleCode, partyToRoleCode, fromPartyID, fromPartyVersionID, toPartyID, toPartyVersionID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fromPartyUserCode, fromPartyUserID, fromPartyUserVersionID);
        }
    }
}
