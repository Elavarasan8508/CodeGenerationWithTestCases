package com.bsit.codegeneration.record;

import java.util.List;

public record FgModCmsPtyRole(Integer ID, String partyTypeCode, String partySubTypeCode, String partyRefNo, Integer partyVersionID, String partyRole, String spaceRefNo, Integer spaceVersionID, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Integer ID;

        private String partyTypeCode;

        private String partySubTypeCode;

        private String partyRefNo;

        private Integer partyVersionID;

        private String partyRole;

        private String spaceRefNo;

        private Integer spaceVersionID;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        public Builder ID(Integer ID) {
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

        public Builder partyVersionID(Integer partyVersionID) {
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

        public Builder spaceVersionID(Integer spaceVersionID) {
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
