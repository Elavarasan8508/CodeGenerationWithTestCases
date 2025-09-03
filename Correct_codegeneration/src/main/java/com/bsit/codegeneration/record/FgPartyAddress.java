package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyAddress(Integer ID, String purposeCode, Integer addressID, Integer partyID, Integer partyVersionID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgAddress fgAddress, FgParty fgParty) {

    public static class Builder {

        private Integer ID;

        private String purposeCode;

        private Integer addressID;

        private Integer partyID;

        private Integer partyVersionID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgAddress fgAddress;

        private FgParty fgParty;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder addressID(Integer addressID) {
            this.addressID = addressID;
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

        public Builder fgAddress(FgAddress fgAddress) {
            this.fgAddress = fgAddress;
            return this;
        }

        public Builder fgParty(FgParty fgParty) {
            this.fgParty = fgParty;
            return this;
        }

        public FgPartyAddress build() {
            return new FgPartyAddress(ID, purposeCode, addressID, partyID, partyVersionID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgAddress, fgParty);
        }
    }
}
