package com.bsit.codegeneration.record;

public record FgEdpmsFircReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String irmNumber, java.time.LocalDateTime remittanceDate, String irmCcy, Long irmAmt, Long irmUtilAmt, Long irmOsAmt, String ieCode, String adCode, String remitterName, String remitterCountry, String remitBankCountry, String parentRefID, Long parentVersionID, Long fircAmt, String fircNumber, String finalErrorDesc, String finalStatus) {

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

        private String irmNumber;

        private java.time.LocalDateTime remittanceDate;

        private String irmCcy;

        private Long irmAmt;

        private Long irmUtilAmt;

        private Long irmOsAmt;

        private String ieCode;

        private String adCode;

        private String remitterName;

        private String remitterCountry;

        private String remitBankCountry;

        private String parentRefID;

        private Long parentVersionID;

        private Long fircAmt;

        private String fircNumber;

        private String finalErrorDesc;

        private String finalStatus;

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

        public Builder irmNumber(String irmNumber) {
            this.irmNumber = irmNumber;
            return this;
        }

        public Builder remittanceDate(java.time.LocalDateTime remittanceDate) {
            this.remittanceDate = remittanceDate;
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            this.irmCcy = irmCcy;
            return this;
        }

        public Builder irmAmt(Long irmAmt) {
            this.irmAmt = irmAmt;
            return this;
        }

        public Builder irmUtilAmt(Long irmUtilAmt) {
            this.irmUtilAmt = irmUtilAmt;
            return this;
        }

        public Builder irmOsAmt(Long irmOsAmt) {
            this.irmOsAmt = irmOsAmt;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
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

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder fircAmt(Long fircAmt) {
            this.fircAmt = fircAmt;
            return this;
        }

        public Builder fircNumber(String fircNumber) {
            this.fircNumber = fircNumber;
            return this;
        }

        public Builder finalErrorDesc(String finalErrorDesc) {
            this.finalErrorDesc = finalErrorDesc;
            return this;
        }

        public Builder finalStatus(String finalStatus) {
            this.finalStatus = finalStatus;
            return this;
        }

        public FgEdpmsFircReq build() {
            return new FgEdpmsFircReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, irmNumber, remittanceDate, irmCcy, irmAmt, irmUtilAmt, irmOsAmt, ieCode, adCode, remitterName, remitterCountry, remitBankCountry, parentRefID, parentVersionID, fircAmt, fircNumber, finalErrorDesc, finalStatus);
        }
    }
}
