package com.bsit.codegeneration.record;

public record FgTrdRemittance(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String custRefID, Long tnxType, Long prodStatCode, Long tnxStatCode, String productCode, java.time.LocalDateTime applDate, Long irTypeCode, java.time.LocalDateTime tnxValueDate, String irCurCode, Long irAmt, String tnxCurCode, Long tnxAmt, String actNo, String beneficiaryName, String beneficiaryAddressLine1, String beneficiaryAddressLine2, String beneficiaryReference, String remitterName, String remitterAddressLine1, String remitterAddressLine2, String nostroNumber, String subProductCode, java.time.LocalDateTime irValueDate, String swiftMsgType, String irOrdrInstitution, String irRemInfo, String irDtlChrgs, String processID, String applicantParty, String boRefID) {

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

        private String custRefID;

        private Long tnxType;

        private Long prodStatCode;

        private Long tnxStatCode;

        private String productCode;

        private java.time.LocalDateTime applDate;

        private Long irTypeCode;

        private java.time.LocalDateTime tnxValueDate;

        private String irCurCode;

        private Long irAmt;

        private String tnxCurCode;

        private Long tnxAmt;

        private String actNo;

        private String beneficiaryName;

        private String beneficiaryAddressLine1;

        private String beneficiaryAddressLine2;

        private String beneficiaryReference;

        private String remitterName;

        private String remitterAddressLine1;

        private String remitterAddressLine2;

        private String nostroNumber;

        private String subProductCode;

        private java.time.LocalDateTime irValueDate;

        private String swiftMsgType;

        private String irOrdrInstitution;

        private String irRemInfo;

        private String irDtlChrgs;

        private String processID;

        private String applicantParty;

        private String boRefID;

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

        public Builder custRefID(String custRefID) {
            this.custRefID = custRefID;
            return this;
        }

        public Builder tnxType(Long tnxType) {
            this.tnxType = tnxType;
            return this;
        }

        public Builder prodStatCode(Long prodStatCode) {
            this.prodStatCode = prodStatCode;
            return this;
        }

        public Builder tnxStatCode(Long tnxStatCode) {
            this.tnxStatCode = tnxStatCode;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder applDate(java.time.LocalDateTime applDate) {
            this.applDate = applDate;
            return this;
        }

        public Builder irTypeCode(Long irTypeCode) {
            this.irTypeCode = irTypeCode;
            return this;
        }

        public Builder tnxValueDate(java.time.LocalDateTime tnxValueDate) {
            this.tnxValueDate = tnxValueDate;
            return this;
        }

        public Builder irCurCode(String irCurCode) {
            this.irCurCode = irCurCode;
            return this;
        }

        public Builder irAmt(Long irAmt) {
            this.irAmt = irAmt;
            return this;
        }

        public Builder tnxCurCode(String tnxCurCode) {
            this.tnxCurCode = tnxCurCode;
            return this;
        }

        public Builder tnxAmt(Long tnxAmt) {
            this.tnxAmt = tnxAmt;
            return this;
        }

        public Builder actNo(String actNo) {
            this.actNo = actNo;
            return this;
        }

        public Builder beneficiaryName(String beneficiaryName) {
            this.beneficiaryName = beneficiaryName;
            return this;
        }

        public Builder beneficiaryAddressLine1(String beneficiaryAddressLine1) {
            this.beneficiaryAddressLine1 = beneficiaryAddressLine1;
            return this;
        }

        public Builder beneficiaryAddressLine2(String beneficiaryAddressLine2) {
            this.beneficiaryAddressLine2 = beneficiaryAddressLine2;
            return this;
        }

        public Builder beneficiaryReference(String beneficiaryReference) {
            this.beneficiaryReference = beneficiaryReference;
            return this;
        }

        public Builder remitterName(String remitterName) {
            this.remitterName = remitterName;
            return this;
        }

        public Builder remitterAddressLine1(String remitterAddressLine1) {
            this.remitterAddressLine1 = remitterAddressLine1;
            return this;
        }

        public Builder remitterAddressLine2(String remitterAddressLine2) {
            this.remitterAddressLine2 = remitterAddressLine2;
            return this;
        }

        public Builder nostroNumber(String nostroNumber) {
            this.nostroNumber = nostroNumber;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder irValueDate(java.time.LocalDateTime irValueDate) {
            this.irValueDate = irValueDate;
            return this;
        }

        public Builder swiftMsgType(String swiftMsgType) {
            this.swiftMsgType = swiftMsgType;
            return this;
        }

        public Builder irOrdrInstitution(String irOrdrInstitution) {
            this.irOrdrInstitution = irOrdrInstitution;
            return this;
        }

        public Builder irRemInfo(String irRemInfo) {
            this.irRemInfo = irRemInfo;
            return this;
        }

        public Builder irDtlChrgs(String irDtlChrgs) {
            this.irDtlChrgs = irDtlChrgs;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder boRefID(String boRefID) {
            this.boRefID = boRefID;
            return this;
        }

        public FgTrdRemittance build() {
            return new FgTrdRemittance(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, custRefID, tnxType, prodStatCode, tnxStatCode, productCode, applDate, irTypeCode, tnxValueDate, irCurCode, irAmt, tnxCurCode, tnxAmt, actNo, beneficiaryName, beneficiaryAddressLine1, beneficiaryAddressLine2, beneficiaryReference, remitterName, remitterAddressLine1, remitterAddressLine2, nostroNumber, subProductCode, irValueDate, swiftMsgType, irOrdrInstitution, irRemInfo, irDtlChrgs, processID, applicantParty, boRefID);
        }
    }
}
