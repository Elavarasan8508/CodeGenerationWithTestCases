package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyMemberRole(Integer ID, String partyTypeCode, String partyCode, Integer partyRefID, Integer partyVersionID, String roleCode, java.time.LocalDateTime effectiveFrom, java.time.LocalDateTime effectiveTo, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String systemSourceCode) {

    public static class Builder {

        private Integer ID;

        private String partyTypeCode;

        private String partyCode;

        private Integer partyRefID;

        private Integer partyVersionID;

        private String roleCode;

        private java.time.LocalDateTime effectiveFrom;

        private java.time.LocalDateTime effectiveTo;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String systemSourceCode;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder partyRefID(Integer partyRefID) {
            this.partyRefID = partyRefID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder roleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        public Builder effectiveFrom(java.time.LocalDateTime effectiveFrom) {
            this.effectiveFrom = effectiveFrom;
            return this;
        }

        public Builder effectiveTo(java.time.LocalDateTime effectiveTo) {
            this.effectiveTo = effectiveTo;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
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

        public Builder systemSourceCode(String systemSourceCode) {
            this.systemSourceCode = systemSourceCode;
            return this;
        }

        public FgPartyMemberRole build() {
            return new FgPartyMemberRole(ID, partyTypeCode, partyCode, partyRefID, partyVersionID, roleCode, effectiveFrom, effectiveTo, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, systemSourceCode);
        }
    }
}
