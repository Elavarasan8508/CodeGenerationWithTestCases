package com.bsit.codegeneration.record;

public record FgPreferencesRelation(Long ID, String prefCategoryCode, String prefTypeCode, String prefCode, String scopeCode, String scopeValue, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Long ID;

        private String prefCategoryCode;

        private String prefTypeCode;

        private String prefCode;

        private String scopeCode;

        private String scopeValue;

        private String description;

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

        public Builder scopeCode(String scopeCode) {
            this.scopeCode = scopeCode;
            return this;
        }

        public Builder scopeValue(String scopeValue) {
            this.scopeValue = scopeValue;
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

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public FgPreferencesRelation build() {
            return new FgPreferencesRelation(ID, prefCategoryCode, prefTypeCode, prefCode, scopeCode, scopeValue, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedBy, lastAuthorisedOn);
        }
    }
}
