package com.bsit.codegeneration.record;

public record FgPartyRole(Long ID, Long partyID, Long partyVersionID, Long roleID, Long roleVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Long ID;

        private Long partyID;

        private Long partyVersionID;

        private Long roleID;

        private Long roleVersionID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyID(Long partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder roleID(Long roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder roleVersionID(Long roleVersionID) {
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

        public FgPartyRole build() {
            return new FgPartyRole(ID, partyID, partyVersionID, roleID, roleVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedBy, lastAuthorisedOn);
        }
    }
}
