package com.bsit.codegeneration.record;

public record FgPartyEntityType(Long ID, Long isEnabled, String partyReferenceID, String entityCategoryCode, String entityTypeCode, String userObjectType, String userObjectReferenceID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String entityTypeName, Long partyID, Long partyVersionID, Long userObjectID, Long userObjectVersionID, String template, String entityAction) {

    public static class Builder {

        private Long ID;

        private Long isEnabled;

        private String partyReferenceID;

        private String entityCategoryCode;

        private String entityTypeCode;

        private String userObjectType;

        private String userObjectReferenceID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String entityTypeName;

        private Long partyID;

        private Long partyVersionID;

        private Long userObjectID;

        private Long userObjectVersionID;

        private String template;

        private String entityAction;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder isEnabled(Long isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public Builder partyReferenceID(String partyReferenceID) {
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

        public Builder userObjectReferenceID(String userObjectReferenceID) {
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

        public Builder partyID(Long partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder userObjectID(Long userObjectID) {
            this.userObjectID = userObjectID;
            return this;
        }

        public Builder userObjectVersionID(Long userObjectVersionID) {
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
