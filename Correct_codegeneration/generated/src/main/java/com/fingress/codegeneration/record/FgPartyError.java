package com.bsit.codegeneration.record;

public record FgPartyError(Long ignore, String category, String severity, String typeCode, String subTypeCode, String partyReferenceID, String partyCode, String message, String details, java.time.LocalDateTime createdOn, java.time.LocalDateTime lastUpdatedOn, String parentPartyCode) {

    public static class Builder {

        private Long ignore;

        private String category;

        private String severity;

        private String typeCode;

        private String subTypeCode;

        private String partyReferenceID;

        private String partyCode;

        private String message;

        private String details;

        private java.time.LocalDateTime createdOn;

        private java.time.LocalDateTime lastUpdatedOn;

        private String parentPartyCode;

        public Builder ignore(Long ignore) {
            this.ignore = ignore;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder severity(String severity) {
            this.severity = severity;
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

        public Builder partyReferenceID(String partyReferenceID) {
            this.partyReferenceID = partyReferenceID;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
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

        public Builder parentPartyCode(String parentPartyCode) {
            this.parentPartyCode = parentPartyCode;
            return this;
        }

        public FgPartyError build() {
            return new FgPartyError(ignore, category, severity, typeCode, subTypeCode, partyReferenceID, partyCode, message, details, createdOn, lastUpdatedOn, parentPartyCode);
        }
    }
}
