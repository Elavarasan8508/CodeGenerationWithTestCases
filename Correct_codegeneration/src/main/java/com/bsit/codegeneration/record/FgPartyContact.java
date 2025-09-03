package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyContact(Integer ID, Integer partyID, String purposeCode, String reference, String typeCode, Integer partyVersionID, String description, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String systemSourceCode, Long sysDefined, FgParty fgParty) {

    public static class Builder {

        private Integer ID;

        private Integer partyID;

        private String purposeCode;

        private String reference;

        private String typeCode;

        private Integer partyVersionID;

        private String description;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String systemSourceCode;

        private Long sysDefined;

        private FgParty fgParty;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyID(Integer partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
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

        public Builder systemSourceCode(String systemSourceCode) {
            this.systemSourceCode = systemSourceCode;
            return this;
        }

        public Builder sysDefined(Long sysDefined) {
            this.sysDefined = sysDefined;
            return this;
        }

        public Builder fgParty(FgParty fgParty) {
            this.fgParty = fgParty;
            return this;
        }

        public FgPartyContact build() {
            return new FgPartyContact(ID, partyID, purposeCode, reference, typeCode, partyVersionID, description, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, systemSourceCode, sysDefined, fgParty);
        }
    }
}
