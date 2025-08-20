package com.bsit.codegeneration.record;

public record FgModCmsPtyRole(Long ID, String partyTypeCode, String partySubTypeCode, String partyRefNo, Long partyVersionID, String partyRole, String spaceRefNo, Long spaceVersionID, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Long ID;

        private String partyTypeCode;

        private String partySubTypeCode;

        private String partyRefNo;

        private Long partyVersionID;

        private String partyRole;

        private String spaceRefNo;

        private Long spaceVersionID;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder partyRefNo(String partyRefNo) {
            this.partyRefNo = partyRefNo;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder partyRole(String partyRole) {
            this.partyRole = partyRole;
            return this;
        }

        public Builder spaceRefNo(String spaceRefNo) {
            this.spaceRefNo = spaceRefNo;
            return this;
        }

        public Builder spaceVersionID(Long spaceVersionID) {
            this.spaceVersionID = spaceVersionID;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
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

        public FgModCmsPtyRole build() {
            return new FgModCmsPtyRole(ID, partyTypeCode, partySubTypeCode, partyRefNo, partyVersionID, partyRole, spaceRefNo, spaceVersionID, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn, lastAuthorisedBy, lastAuthorisedOn);
        }
    }
}
