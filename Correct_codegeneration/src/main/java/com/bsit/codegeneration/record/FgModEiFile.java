package com.bsit.codegeneration.record;

import java.util.List;

public record FgModEiFile(Integer ID, Integer referenceID, Integer partyRefID, Integer partyVersionID, Integer entityRefID, Integer entityVersionID, String eventCode, String eventDirectionCode, String endpointCode, String endpointPath, String endpointDirectory, String fileName, Long totalCount, Long successCount, Long errorCount, String categoryCode, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private Integer partyRefID;

        private Integer partyVersionID;

        private Integer entityRefID;

        private Integer entityVersionID;

        private String eventCode;

        private String eventDirectionCode;

        private String endpointCode;

        private String endpointPath;

        private String endpointDirectory;

        private String fileName;

        private Long totalCount;

        private Long successCount;

        private Long errorCount;

        private String categoryCode;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder partyRefID(Integer partyRefID) {
            this.partyRefID = partyRefID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionID(Integer entityVersionID) {
            this.entityVersionID = entityVersionID;
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

        public Builder endpointCode(String endpointCode) {
            this.endpointCode = endpointCode;
            return this;
        }

        public Builder endpointPath(String endpointPath) {
            this.endpointPath = endpointPath;
            return this;
        }

        public Builder endpointDirectory(String endpointDirectory) {
            this.endpointDirectory = endpointDirectory;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder successCount(Long successCount) {
            this.successCount = successCount;
            return this;
        }

        public Builder errorCount(Long errorCount) {
            this.errorCount = errorCount;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
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

        public FgModEiFile build() {
            return new FgModEiFile(ID, referenceID, partyRefID, partyVersionID, entityRefID, entityVersionID, eventCode, eventDirectionCode, endpointCode, endpointPath, endpointDirectory, fileName, totalCount, successCount, errorCount, categoryCode, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
