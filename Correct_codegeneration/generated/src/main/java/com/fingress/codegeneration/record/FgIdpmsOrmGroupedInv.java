package com.bsit.codegeneration.record;

public record FgIdpmsOrmGroupedInv(String invNum, Long utilAmt, Long endorsedAmt, String parentRefID, Long parentVersionID, Long isTemplate, String template, String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, java.time.LocalDateTime createdOn, java.time.LocalDateTime lastUpdatedOn, java.time.LocalDateTime lastAuthorisedOn, String createdBy, String lastUpdatedBy, String lastAuthorisedBy) {

    public static class Builder {

        private String invNum;

        private Long utilAmt;

        private Long endorsedAmt;

        private String parentRefID;

        private Long parentVersionID;

        private Long isTemplate;

        private String template;

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

        private java.time.LocalDateTime createdOn;

        private java.time.LocalDateTime lastUpdatedOn;

        private java.time.LocalDateTime lastAuthorisedOn;

        private String createdBy;

        private String lastUpdatedBy;

        private String lastAuthorisedBy;

        public Builder invNum(String invNum) {
            this.invNum = invNum;
            return this;
        }

        public Builder utilAmt(Long utilAmt) {
            this.utilAmt = utilAmt;
            return this;
        }

        public Builder endorsedAmt(Long endorsedAmt) {
            this.endorsedAmt = endorsedAmt;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder ID(String ID) {
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

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder createdOn(java.time.LocalDateTime createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastUpdatedOn(java.time.LocalDateTime lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastAuthorisedOn(java.time.LocalDateTime lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastUpdatedBy(String lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastAuthorisedBy(String lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public FgIdpmsOrmGroupedInv build() {
            return new FgIdpmsOrmGroupedInv(invNum, utilAmt, endorsedAmt, parentRefID, parentVersionID, isTemplate, template, ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, lastUpdatedOn, lastAuthorisedOn, createdBy, lastUpdatedBy, lastAuthorisedBy);
        }
    }
}
