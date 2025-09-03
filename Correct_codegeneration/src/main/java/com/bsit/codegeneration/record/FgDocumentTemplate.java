package com.bsit.codegeneration.record;

import java.util.List;

public record FgDocumentTemplate(Integer ID, Integer referenceID, String name, String typeCode, String subTypeCode, Long isDefault, String purposeCode, String renderTypeCode, String description, String template, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, List<FgDocumentTemplateParty> fgDocumentTemplatePartys) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String name;

        private String typeCode;

        private String subTypeCode;

        private Long isDefault;

        private String purposeCode;

        private String renderTypeCode;

        private String description;

        private String template;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private List<FgDocumentTemplateParty> fgDocumentTemplatePartys;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
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

        public Builder isDefault(Long isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder renderTypeCode(String renderTypeCode) {
            this.renderTypeCode = renderTypeCode;
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

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder fgDocumentTemplatePartys(List<FgDocumentTemplateParty> fgDocumentTemplatePartys) {
            this.fgDocumentTemplatePartys = fgDocumentTemplatePartys;
            return this;
        }

        public FgDocumentTemplate build() {
            return new FgDocumentTemplate(ID, referenceID, name, typeCode, subTypeCode, isDefault, purposeCode, renderTypeCode, description, template, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgDocumentTemplatePartys);
        }
    }
}
