package com.bsit.codegeneration.record;

public record FgModEiEvent(Long ID, String fileRefID, String eventCode, String eventDirectionCode, String eventStatusCode, String sourceEndpointCode, String targetEndpointCode, String eventReqFileName, String eventRequestDate, String eventRequest, String eventResFileName, String eventResponseDate, String eventResponse, String eventErrorFileName, String eventErrorDate, String eventError, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Long modEiFileID) {

    public static class Builder {

        private Long ID;

        private String fileRefID;

        private String eventCode;

        private String eventDirectionCode;

        private String eventStatusCode;

        private String sourceEndpointCode;

        private String targetEndpointCode;

        private String eventReqFileName;

        private String eventRequestDate;

        private String eventRequest;

        private String eventResFileName;

        private String eventResponseDate;

        private String eventResponse;

        private String eventErrorFileName;

        private String eventErrorDate;

        private String eventError;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Long modEiFileID;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder fileRefID(String fileRefID) {
            this.fileRefID = fileRefID;
            return this;
        }

        public Builder eventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        public Builder eventDirectionCode(String eventDirectionCode) {
            this.eventDirectionCode = eventDirectionCode;
            return this;
        }

        public Builder eventStatusCode(String eventStatusCode) {
            this.eventStatusCode = eventStatusCode;
            return this;
        }

        public Builder sourceEndpointCode(String sourceEndpointCode) {
            this.sourceEndpointCode = sourceEndpointCode;
            return this;
        }

        public Builder targetEndpointCode(String targetEndpointCode) {
            this.targetEndpointCode = targetEndpointCode;
            return this;
        }

        public Builder eventReqFileName(String eventReqFileName) {
            this.eventReqFileName = eventReqFileName;
            return this;
        }

        public Builder eventRequestDate(String eventRequestDate) {
            this.eventRequestDate = eventRequestDate;
            return this;
        }

        public Builder eventRequest(String eventRequest) {
            this.eventRequest = eventRequest;
            return this;
        }

        public Builder eventResFileName(String eventResFileName) {
            this.eventResFileName = eventResFileName;
            return this;
        }

        public Builder eventResponseDate(String eventResponseDate) {
            this.eventResponseDate = eventResponseDate;
            return this;
        }

        public Builder eventResponse(String eventResponse) {
            this.eventResponse = eventResponse;
            return this;
        }

        public Builder eventErrorFileName(String eventErrorFileName) {
            this.eventErrorFileName = eventErrorFileName;
            return this;
        }

        public Builder eventErrorDate(String eventErrorDate) {
            this.eventErrorDate = eventErrorDate;
            return this;
        }

        public Builder eventError(String eventError) {
            this.eventError = eventError;
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

        public Builder modEiFileID(Long modEiFileID) {
            this.modEiFileID = modEiFileID;
            return this;
        }

        public FgModEiEvent build() {
            return new FgModEiEvent(ID, fileRefID, eventCode, eventDirectionCode, eventStatusCode, sourceEndpointCode, targetEndpointCode, eventReqFileName, eventRequestDate, eventRequest, eventResFileName, eventResponseDate, eventResponse, eventErrorFileName, eventErrorDate, eventError, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, modEiFileID);
        }
    }
}
