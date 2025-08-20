package com.bsit.codegeneration.record;

public record FgDmsEvent(Long ID, String actionCode, String entityReferenceID, Long entityVersionID, Long partyID, Long partyVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String entityTypeCode, String entitySubTypeCode) {

    public static class Builder {

        private Long ID;

        private String actionCode;

        private String entityReferenceID;

        private Long entityVersionID;

        private Long partyID;

        private Long partyVersionID;

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

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder actionCode(String actionCode) {
            this.actionCode = actionCode;
            return this;
        }

        public Builder entityReferenceID(String entityReferenceID) {
            this.entityReferenceID = entityReferenceID;
            return this;
        }

        public Builder entityVersionID(Long entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public Builder partyID(Long partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
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
