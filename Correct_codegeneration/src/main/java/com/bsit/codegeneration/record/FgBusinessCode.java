package com.bsit.codegeneration.record;

import java.util.List;

public record FgBusinessCode(Integer ID, String name, String codeType, String codeValue, String parentCode, Integer partyID, Integer partyVersionID, String parentType, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Integer parentRefID, String tags, FgParty fgParty) {

    public static class Builder {

        private Integer ID;

        private String name;

        private String codeType;

        private String codeValue;

        private String parentCode;

        private Integer partyID;

        private Integer partyVersionID;

        private String parentType;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Integer parentRefID;

        private String tags;

        private FgParty fgParty;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder codeType(String codeType) {
            this.codeType = codeType;
            return this;
        }

        public Builder codeValue(String codeValue) {
            this.codeValue = codeValue;
            return this;
        }

        public Builder parentCode(String parentCode) {
            this.parentCode = parentCode;
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

        public Builder parentType(String parentType) {
            this.parentType = parentType;
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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder fgParty(FgParty fgParty) {
            this.fgParty = fgParty;
            return this;
        }

        public FgBusinessCode build() {
            return new FgBusinessCode(ID, name, codeType, codeValue, parentCode, partyID, partyVersionID, parentType, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, parentRefID, tags, fgParty);
        }
    }
}
