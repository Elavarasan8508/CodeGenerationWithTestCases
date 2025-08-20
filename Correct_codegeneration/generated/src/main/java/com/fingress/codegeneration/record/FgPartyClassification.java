package com.bsit.codegeneration.record;

public record FgPartyClassification(Long ID, Long partyID, Long partyVersionID, String partySubTypeCode, String partyCode, String classTypeCode, String classSubTypeCode, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, String comments, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String demographicTypeCode, String demographicSubTypeCode, Long sysDefined, String systemSourceCode) {

    public static class Builder {

        private Long ID;

        private Long partyID;

        private Long partyVersionID;

        private String partySubTypeCode;

        private String partyCode;

        private String classTypeCode;

        private String classSubTypeCode;

        private java.time.LocalDateTime validFrom;

        private java.time.LocalDateTime validTo;

        private String comments;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String demographicTypeCode;

        private String demographicSubTypeCode;

        private Long sysDefined;

        private String systemSourceCode;

        public Builder ID(Long ID) {
            this.ID = ID;
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

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder classTypeCode(String classTypeCode) {
            this.classTypeCode = classTypeCode;
            return this;
        }

        public Builder classSubTypeCode(String classSubTypeCode) {
            this.classSubTypeCode = classSubTypeCode;
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

        public Builder comments(String comments) {
            this.comments = comments;
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

        public Builder demographicTypeCode(String demographicTypeCode) {
            this.demographicTypeCode = demographicTypeCode;
            return this;
        }

        public Builder demographicSubTypeCode(String demographicSubTypeCode) {
            this.demographicSubTypeCode = demographicSubTypeCode;
            return this;
        }

        public Builder sysDefined(Long sysDefined) {
            this.sysDefined = sysDefined;
            return this;
        }

        public Builder systemSourceCode(String systemSourceCode) {
            this.systemSourceCode = systemSourceCode;
            return this;
        }

        public FgPartyClassification build() {
            return new FgPartyClassification(ID, partyID, partyVersionID, partySubTypeCode, partyCode, classTypeCode, classSubTypeCode, validFrom, validTo, comments, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, demographicTypeCode, demographicSubTypeCode, sysDefined, systemSourceCode);
        }
    }
}
