package com.bsit.codegeneration.record;

public record FgExpMbiXar(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String irmNo, String adCode, Long irmAmt, Long irmUtilAmt, Long irmOsAmt, String irmCcy, java.time.LocalDateTime irmDate, String ieCode, String remitterName, String remitterCountry, String remitBankCountry, String remitBankName, String xarBankRef, String purposeOfRemittance, String billNo, String parentRefID, Long parentVersionID, Long settledAmt) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String irmNo;

        private String adCode;

        private Long irmAmt;

        private Long irmUtilAmt;

        private Long irmOsAmt;

        private String irmCcy;

        private java.time.LocalDateTime irmDate;

        private String ieCode;

        private String remitterName;

        private String remitterCountry;

        private String remitBankCountry;

        private String remitBankName;

        private String xarBankRef;

        private String purposeOfRemittance;

        private String billNo;

        private String parentRefID;

        private Long parentVersionID;

        private Long settledAmt;

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

        public Builder processID(String processID) {
            this.processID = processID;
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

        public Builder irmNo(String irmNo) {
            this.irmNo = irmNo;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
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

        public Builder irmCcy(String irmCcy) {
            this.irmCcy = irmCcy;
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            this.irmDate = irmDate;
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

        public Builder remitBankName(String remitBankName) {
            this.remitBankName = remitBankName;
            return this;
        }

        public Builder xarBankRef(String xarBankRef) {
            this.xarBankRef = xarBankRef;
            return this;
        }

        public Builder purposeOfRemittance(String purposeOfRemittance) {
            this.purposeOfRemittance = purposeOfRemittance;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
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

        public Builder settledAmt(Long settledAmt) {
            this.settledAmt = settledAmt;
            return this;
        }

        public FgExpMbiXar build() {
            return new FgExpMbiXar(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, irmNo, adCode, irmAmt, irmUtilAmt, irmOsAmt, irmCcy, irmDate, ieCode, remitterName, remitterCountry, remitBankCountry, remitBankName, xarBankRef, purposeOfRemittance, billNo, parentRefID, parentVersionID, settledAmt);
        }
    }
}
