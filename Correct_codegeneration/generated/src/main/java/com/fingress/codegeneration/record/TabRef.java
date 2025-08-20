package com.bsit.codegeneration.record;

public record TabRef(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String tdCode1, java.time.LocalDateTime tdCode2, String tdCode3, String tdCode4, String tdCode5, String tdCode6, String tdCode7, String tdCode8, String tdCode9, String tdCode10) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private String applicantParty;

        private String fulfillmentParty;

        private Long isTemplate;

        private String tdCode1;

        private java.time.LocalDateTime tdCode2;

        private String tdCode3;

        private String tdCode4;

        private String tdCode5;

        private String tdCode6;

        private String tdCode7;

        private String tdCode8;

        private String tdCode9;

        private String tdCode10;

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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder tdCode1(String tdCode1) {
            this.tdCode1 = tdCode1;
            return this;
        }

        public Builder tdCode2(java.time.LocalDateTime tdCode2) {
            this.tdCode2 = tdCode2;
            return this;
        }

        public Builder tdCode3(String tdCode3) {
            this.tdCode3 = tdCode3;
            return this;
        }

        public Builder tdCode4(String tdCode4) {
            this.tdCode4 = tdCode4;
            return this;
        }

        public Builder tdCode5(String tdCode5) {
            this.tdCode5 = tdCode5;
            return this;
        }

        public Builder tdCode6(String tdCode6) {
            this.tdCode6 = tdCode6;
            return this;
        }

        public Builder tdCode7(String tdCode7) {
            this.tdCode7 = tdCode7;
            return this;
        }

        public Builder tdCode8(String tdCode8) {
            this.tdCode8 = tdCode8;
            return this;
        }

        public Builder tdCode9(String tdCode9) {
            this.tdCode9 = tdCode9;
            return this;
        }

        public Builder tdCode10(String tdCode10) {
            this.tdCode10 = tdCode10;
            return this;
        }

        public TabRef build() {
            return new TabRef(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, tdCode1, tdCode2, tdCode3, tdCode4, tdCode5, tdCode6, tdCode7, tdCode8, tdCode9, tdCode10);
        }
    }
}
