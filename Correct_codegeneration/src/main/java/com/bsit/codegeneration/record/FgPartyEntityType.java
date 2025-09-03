package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyEntityType(Integer ID, Long isEnabled, Integer partyReferenceID, String entityCategoryCode, String entityTypeCode, String userObjectType, Integer userObjectReferenceID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String entityTypeName, Integer partyID, Integer partyVersionID, Integer userObjectID, Integer userObjectVersionID, String template, String entityAction) {

    public static class Builder {

        private Integer ID;

        private Long isEnabled;

        private Integer partyReferenceID;

        private String entityCategoryCode;

        private String entityTypeCode;

        private String userObjectType;

        private Integer userObjectReferenceID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String entityTypeName;

        private Integer partyID;

        private Integer partyVersionID;

        private Integer userObjectID;

        private Integer userObjectVersionID;

        private String template;

        private String entityAction;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder isEnabled(Long isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder partyReferenceID(Integer partyReferenceID) {
            this.partyReferenceID = partyReferenceID;
            return this;
        }

        public Builder entityCategoryCode(String entityCategoryCode) {
            this.entityCategoryCode = entityCategoryCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder userObjectType(String userObjectType) {
            this.userObjectType = userObjectType;
            return this;
        }

        public Builder userObjectReferenceID(Integer userObjectReferenceID) {
            this.userObjectReferenceID = userObjectReferenceID;
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

        public Builder entityTypeName(String entityTypeName) {
            this.entityTypeName = entityTypeName;
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

        public Builder userObjectID(Integer userObjectID) {
            this.userObjectID = userObjectID;
            return this;
        }

        public Builder userObjectVersionID(Integer userObjectVersionID) {
            this.userObjectVersionID = userObjectVersionID;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder entityAction(String entityAction) {
            this.entityAction = entityAction;
            return this;
        }

        public FgPartyEntityType build() {
            return new FgPartyEntityType(ID, isEnabled, partyReferenceID, entityCategoryCode, entityTypeCode, userObjectType, userObjectReferenceID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, entityTypeName, partyID, partyVersionID, userObjectID, userObjectVersionID, template, entityAction);
        }
    }
}
