package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyGroup(Integer ID, String partySubTypeCode, String partyCode, Integer groupID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String parentPartyCode, Integer referenceID, String subTypeCode, String typeCode, FgGroup fgGroup) {

    public static class Builder {

        private Integer ID;

        private String partySubTypeCode;

        private String partyCode;

        private Integer groupID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String parentPartyCode;

        private Integer referenceID;

        private String subTypeCode;

        private String typeCode;

        private FgGroup fgGroup;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
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

        public Builder parentPartyCode(String parentPartyCode) {
            this.parentPartyCode = parentPartyCode;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder fgGroup(FgGroup fgGroup) {
            this.fgGroup = fgGroup;
            return this;
        }

        public FgPartyGroup build() {
            return new FgPartyGroup(ID, partySubTypeCode, partyCode, groupID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, parentPartyCode, referenceID, subTypeCode, typeCode, fgGroup);
        }
    }
}
