package com.bsit.codegeneration.record;

public record FgTrdBillFirc(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String fircNo, java.time.LocalDateTime fircDate, String fircCcy, Long fircAmt, Long fircUtilAmt, Long fircOsAmt, String adCode, String ieCode, String remitterName, String remitterCountry, String remitBankCountry) {

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

        private String fircNo;

        private java.time.LocalDateTime fircDate;

        private String fircCcy;

        private Long fircAmt;

        private Long fircUtilAmt;

        private Long fircOsAmt;

        private String adCode;

        private String ieCode;

        private String remitterName;

        private String remitterCountry;

        private String remitBankCountry;

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

        public Builder fircNo(String fircNo) {
            this.fircNo = fircNo;
            return this;
        }

        public Builder fircDate(java.time.LocalDateTime fircDate) {
            this.fircDate = fircDate;
            return this;
        }

        public Builder fircCcy(String fircCcy) {
            this.fircCcy = fircCcy;
            return this;
        }

        public Builder fircAmt(Long fircAmt) {
            this.fircAmt = fircAmt;
            return this;
        }

        public Builder fircUtilAmt(Long fircUtilAmt) {
            this.fircUtilAmt = fircUtilAmt;
            return this;
        }

        public Builder fircOsAmt(Long fircOsAmt) {
            this.fircOsAmt = fircOsAmt;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder remitterName(String remitterName) {
            this.remitterName = remitterName;
            return this;
        }

        public Builder remitterCountry(String remitterCountry) {
            this.remitterCountry = remitterCountry;
            return this;
        }

        public Builder remitBankCountry(String remitBankCountry) {
            this.remitBankCountry = remitBankCountry;
            return this;
        }

        public FgTrdBillFirc build() {
            return new FgTrdBillFirc(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, fircNo, fircDate, fircCcy, fircAmt, fircUtilAmt, fircOsAmt, adCode, ieCode, remitterName, remitterCountry, remitBankCountry);
        }
    }
}
