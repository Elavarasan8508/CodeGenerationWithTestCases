package com.bsit.codegeneration.record;

public record FgModBatchTnx(Long ID, String referenceID, String typeCode, String subTypeCode, String parentRefID, String parentRefVersionID, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long parentVersionID, Long isTemplate, String entityRefID, String entitySubTypeCode, String entityTypeCode, Long entityVersionID) {

    public static class Builder {

        private Long ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String parentRefID;

        private String parentRefVersionID;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long parentVersionID;

        private Long isTemplate;

        private String entityRefID;

        private String entitySubTypeCode;

        private String entityTypeCode;

        private Long entityVersionID;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
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

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentRefVersionID(String parentRefVersionID) {
            this.parentRefVersionID = parentRefVersionID;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
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

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entityVersionID(Long entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public FgModBatchTnx build() {
            return new FgModBatchTnx(ID, referenceID, typeCode, subTypeCode, parentRefID, parentRefVersionID, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, parentVersionID, isTemplate, entityRefID, entitySubTypeCode, entityTypeCode, entityVersionID);
        }
    }
}
