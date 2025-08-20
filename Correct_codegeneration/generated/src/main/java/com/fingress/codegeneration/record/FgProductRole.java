package com.bsit.codegeneration.record;

public record FgProductRole(String entityTypeCode, String entitySubTypeCode, String partyTypeCode, String partySubTypeCode, String partyRoleCode, String entityRefID, Long entityVersionNo, String partyCode, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String uploadRefID, String ID) {

    public static class Builder {

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String partyTypeCode;

        private String partySubTypeCode;

        private String partyRoleCode;

        private String entityRefID;

        private Long entityVersionNo;

        private String partyCode;

        private java.time.LocalDateTime validFrom;

        private java.time.LocalDateTime validTo;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String uploadRefID;

        private String ID;

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder partyRoleCode(String partyRoleCode) {
            this.partyRoleCode = partyRoleCode;
            return this;
        }

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionNo(Long entityVersionNo) {
            this.entityVersionNo = entityVersionNo;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder validFrom(java.time.LocalDateTime validFrom) {
            this.validFrom = validFrom;
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            this.validTo = validTo;
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

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public FgProductRole build() {
            return new FgProductRole(entityTypeCode, entitySubTypeCode, partyTypeCode, partySubTypeCode, partyRoleCode, entityRefID, entityVersionNo, partyCode, validFrom, validTo, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, uploadRefID, ID);
        }
    }
}
