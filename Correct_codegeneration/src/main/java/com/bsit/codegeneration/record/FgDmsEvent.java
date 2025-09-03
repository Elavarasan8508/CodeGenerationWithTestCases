package com.bsit.codegeneration.record;

import java.util.List;

public record FgDmsEvent(Integer ID, String actionCode, Integer entityReferenceID, Integer entityVersionID, Integer partyID, Integer partyVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String entityTypeCode, String entitySubTypeCode) {

    public static class Builder {

        private Integer ID;

        private String actionCode;

        private Integer entityReferenceID;

        private Integer entityVersionID;

        private Integer partyID;

        private Integer partyVersionID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String entityTypeCode;

        private String entitySubTypeCode;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder actionCode(String actionCode) {
            this.actionCode = actionCode;
            return this;
        }

        public Builder entityReferenceID(Integer entityReferenceID) {
            this.entityReferenceID = entityReferenceID;
            return this;
        }

        public Builder entityVersionID(Integer entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public Builder partyID(Integer partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
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

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public FgDmsEvent build() {
            return new FgDmsEvent(ID, actionCode, entityReferenceID, entityVersionID, partyID, partyVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, entityTypeCode, entitySubTypeCode);
        }
    }
}
