package com.bsit.codegeneration.record;

public record FgBankGuarantee(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String bankGuaranteeNumber, String issuingBankName, String issuingBankIfscOrBic, String issuingBankAddress, String applicantCode, String applicantName, String applicantAddress, String applicantPan, String applicantGstin, String applicantAadhaar, java.time.LocalDateTime dateOfIssuance, java.time.LocalDateTime effectiveDate, Long faceValue, java.time.LocalDateTime expiryDate, java.time.LocalDateTime claimExpiryDate, String ifin760coverReference, String uploadRefID, String dmsEventID) {

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

        private String bankGuaranteeNumber;

        private String issuingBankName;

        private String issuingBankIfscOrBic;

        private String issuingBankAddress;

        private String applicantCode;

        private String applicantName;

        private String applicantAddress;

        private String applicantPan;

        private String applicantGstin;

        private String applicantAadhaar;

        private java.time.LocalDateTime dateOfIssuance;

        private java.time.LocalDateTime effectiveDate;

        private Long faceValue;

        private java.time.LocalDateTime expiryDate;

        private java.time.LocalDateTime claimExpiryDate;

        private String ifin760coverReference;

        private String uploadRefID;

        private String dmsEventID;

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

        public Builder bankGuaranteeNumber(String bankGuaranteeNumber) {
            this.bankGuaranteeNumber = bankGuaranteeNumber;
            return this;
        }

        public Builder issuingBankName(String issuingBankName) {
            this.issuingBankName = issuingBankName;
            return this;
        }

        public Builder issuingBankIfscOrBic(String issuingBankIfscOrBic) {
            this.issuingBankIfscOrBic = issuingBankIfscOrBic;
            return this;
        }

        public Builder issuingBankAddress(String issuingBankAddress) {
            this.issuingBankAddress = issuingBankAddress;
            return this;
        }

        public Builder applicantCode(String applicantCode) {
            this.applicantCode = applicantCode;
            return this;
        }

        public Builder applicantName(String applicantName) {
            this.applicantName = applicantName;
            return this;
        }

        public Builder applicantAddress(String applicantAddress) {
            this.applicantAddress = applicantAddress;
            return this;
        }

        public Builder applicantPan(String applicantPan) {
            this.applicantPan = applicantPan;
            return this;
        }

        public Builder applicantGstin(String applicantGstin) {
            this.applicantGstin = applicantGstin;
            return this;
        }

        public Builder applicantAadhaar(String applicantAadhaar) {
            this.applicantAadhaar = applicantAadhaar;
            return this;
        }

        public Builder dateOfIssuance(java.time.LocalDateTime dateOfIssuance) {
            this.dateOfIssuance = dateOfIssuance;
            return this;
        }

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder faceValue(Long faceValue) {
            this.faceValue = faceValue;
            return this;
        }

        public Builder expiryDate(java.time.LocalDateTime expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder claimExpiryDate(java.time.LocalDateTime claimExpiryDate) {
            this.claimExpiryDate = claimExpiryDate;
            return this;
        }

        public Builder ifin760coverReference(String ifin760coverReference) {
            this.ifin760coverReference = ifin760coverReference;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public FgBankGuarantee build() {
            return new FgBankGuarantee(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, bankGuaranteeNumber, issuingBankName, issuingBankIfscOrBic, issuingBankAddress, applicantCode, applicantName, applicantAddress, applicantPan, applicantGstin, applicantAadhaar, dateOfIssuance, effectiveDate, faceValue, expiryDate, claimExpiryDate, ifin760coverReference, uploadRefID, dmsEventID);
        }
    }
}
