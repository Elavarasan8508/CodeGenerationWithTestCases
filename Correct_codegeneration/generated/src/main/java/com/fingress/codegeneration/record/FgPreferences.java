package com.bsit.codegeneration.record;

public record FgPreferences(Long ID, Long versionID, String typeCode, String subTypeCode, String prefCategoryCode, String prefTypeCode, String prefCode, String orgPartyCode, String orgPartySubTypeCode, String userPartyCode, String userPartySubTypeCode, String name, String description, String template, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Long ID;

        private Long versionID;

        private String typeCode;

        private String subTypeCode;

        private String prefCategoryCode;

        private String prefTypeCode;

        private String prefCode;

        private String orgPartyCode;

        private String orgPartySubTypeCode;

        private String userPartyCode;

        private String userPartySubTypeCode;

        private String name;

        private String description;

        private String template;

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

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder prefCategoryCode(String prefCategoryCode) {
            this.prefCategoryCode = prefCategoryCode;
            return this;
        }

        public Builder prefTypeCode(String prefTypeCode) {
            this.prefTypeCode = prefTypeCode;
            return this;
        }

        public Builder prefCode(String prefCode) {
            this.prefCode = prefCode;
            return this;
        }

        public Builder orgPartyCode(String orgPartyCode) {
            this.orgPartyCode = orgPartyCode;
            return this;
        }

        public Builder orgPartySubTypeCode(String orgPartySubTypeCode) {
            this.orgPartySubTypeCode = orgPartySubTypeCode;
            return this;
        }

        public Builder userPartyCode(String userPartyCode) {
            this.userPartyCode = userPartyCode;
            return this;
        }

        public Builder userPartySubTypeCode(String userPartySubTypeCode) {
            this.userPartySubTypeCode = userPartySubTypeCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
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

        public FgPreferences build() {
            return new FgPreferences(ID, versionID, typeCode, subTypeCode, prefCategoryCode, prefTypeCode, prefCode, orgPartyCode, orgPartySubTypeCode, userPartyCode, userPartySubTypeCode, name, description, template, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedBy, lastAuthorisedOn);
        }
    }
}
