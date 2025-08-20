package com.bsit.codegeneration.record;

public record FgConfigSchema(Long ID, String configCode, String name, String parentCode, String fieldData, String formData, String authFormData, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String categoryCode, String typeCode) {

    public static class Builder {

        private Long ID;

        private String configCode;

        private String name;

        private String parentCode;

        private String fieldData;

        private String formData;

        private String authFormData;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String categoryCode;

        private String typeCode;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder configCode(String configCode) {
            this.configCode = configCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder parentCode(String parentCode) {
            this.parentCode = parentCode;
            return this;
        }

        public Builder fieldData(String fieldData) {
            this.fieldData = fieldData;
            return this;
        }

        public Builder formData(String formData) {
            this.formData = formData;
            return this;
        }

        public Builder authFormData(String authFormData) {
            this.authFormData = authFormData;
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

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public FgConfigSchema build() {
            return new FgConfigSchema(ID, configCode, name, parentCode, fieldData, formData, authFormData, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, categoryCode, typeCode);
        }
    }
}
