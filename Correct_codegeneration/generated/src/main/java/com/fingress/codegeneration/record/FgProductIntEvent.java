package com.bsit.codegeneration.record;

public record FgProductIntEvent(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String sourceSystem, String sourceProduct, String sourceEvent, String targetSystem, String targetProduct, String targetEvent, String entityRefID, String entityVersionID, String entityTypeCode, String test, String test1, String test2, String entitySubTypeCode, String boRefNo, String boStatus, String boComments, String translatorCode, String stagingType, String intStatusCode, String stagingStatusCode, String stagingRequest, String stagingResponse, String eventType, String eventStatus, String serverDetails) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

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

        private Long isTemplate;

        private String sourceSystem;

        private String sourceProduct;

        private String sourceEvent;

        private String targetSystem;

        private String targetProduct;

        private String targetEvent;

        private String entityRefID;

        private String entityVersionID;

        private String entityTypeCode;

        private String test;

        private String test1;

        private String test2;

        private String entitySubTypeCode;

        private String boRefNo;

        private String boStatus;

        private String boComments;

        private String translatorCode;

        private String stagingType;

        private String intStatusCode;

        private String stagingStatusCode;

        private String stagingRequest;

        private String stagingResponse;

        private String eventType;

        private String eventStatus;

        private String serverDetails;

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

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder sourceSystem(String sourceSystem) {
            this.sourceSystem = sourceSystem;
            return this;
        }

        public Builder sourceProduct(String sourceProduct) {
            this.sourceProduct = sourceProduct;
            return this;
        }

        public Builder sourceEvent(String sourceEvent) {
            this.sourceEvent = sourceEvent;
            return this;
        }

        public Builder targetSystem(String targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        public Builder targetProduct(String targetProduct) {
            this.targetProduct = targetProduct;
            return this;
        }

        public Builder targetEvent(String targetEvent) {
            this.targetEvent = targetEvent;
            return this;
        }

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionID(String entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder test(String test) {
            this.test = test;
            return this;
        }

        public Builder test1(String test1) {
            this.test1 = test1;
            return this;
        }

        public Builder test2(String test2) {
            this.test2 = test2;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder boRefNo(String boRefNo) {
            this.boRefNo = boRefNo;
            return this;
        }

        public Builder boStatus(String boStatus) {
            this.boStatus = boStatus;
            return this;
        }

        public Builder boComments(String boComments) {
            this.boComments = boComments;
            return this;
        }

        public Builder translatorCode(String translatorCode) {
            this.translatorCode = translatorCode;
            return this;
        }

        public Builder stagingType(String stagingType) {
            this.stagingType = stagingType;
            return this;
        }

        public Builder intStatusCode(String intStatusCode) {
            this.intStatusCode = intStatusCode;
            return this;
        }

        public Builder stagingStatusCode(String stagingStatusCode) {
            this.stagingStatusCode = stagingStatusCode;
            return this;
        }

        public Builder stagingRequest(String stagingRequest) {
            this.stagingRequest = stagingRequest;
            return this;
        }

        public Builder stagingResponse(String stagingResponse) {
            this.stagingResponse = stagingResponse;
            return this;
        }

        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder eventStatus(String eventStatus) {
            this.eventStatus = eventStatus;
            return this;
        }

        public Builder serverDetails(String serverDetails) {
            this.serverDetails = serverDetails;
            return this;
        }

        public FgProductIntEvent build() {
            return new FgProductIntEvent(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, sourceSystem, sourceProduct, sourceEvent, targetSystem, targetProduct, targetEvent, entityRefID, entityVersionID, entityTypeCode, test, test1, test2, entitySubTypeCode, boRefNo, boStatus, boComments, translatorCode, stagingType, intStatusCode, stagingStatusCode, stagingRequest, stagingResponse, eventType, eventStatus, serverDetails);
        }
    }
}
