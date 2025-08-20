package com.bsit.codegeneration.record;

public record FgEdpmsIrmReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String irmNo, String irmAd, Long irmAmt, Long osAmtIrm, String irmCcy, String ieCodeIrm, java.time.LocalDateTime irmDate, Long irmUtilAmt, String remitName, String remitCountry, String remitBankName, String remitBankCountry, String swiftOtherBankRef, String purOfRemit, Long amtUtil, java.time.LocalDateTime extDateIrm, String remarksIrme, String irmAdjNo, String bankRefNo, Long adjAmtIrm, String remarksIrma, String parentRefID, Long parentVersionID, String trracsErrorCode, String trracsErrorDecs, String trracsStatus) {

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

        private String irmNo;

        private String irmAd;

        private Long irmAmt;

        private Long osAmtIrm;

        private String irmCcy;

        private String ieCodeIrm;

        private java.time.LocalDateTime irmDate;

        private Long irmUtilAmt;

        private String remitName;

        private String remitCountry;

        private String remitBankName;

        private String remitBankCountry;

        private String swiftOtherBankRef;

        private String purOfRemit;

        private Long amtUtil;

        private java.time.LocalDateTime extDateIrm;

        private String remarksIrme;

        private String irmAdjNo;

        private String bankRefNo;

        private Long adjAmtIrm;

        private String remarksIrma;

        private String parentRefID;

        private Long parentVersionID;

        private String trracsErrorCode;

        private String trracsErrorDecs;

        private String trracsStatus;

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

        public Builder irmNo(String irmNo) {
            this.irmNo = irmNo;
            return this;
        }

        public Builder irmAd(String irmAd) {
            this.irmAd = irmAd;
            return this;
        }

        public Builder irmAmt(Long irmAmt) {
            this.irmAmt = irmAmt;
            return this;
        }

        public Builder osAmtIrm(Long osAmtIrm) {
            this.osAmtIrm = osAmtIrm;
            return this;
        }

        public Builder irmCcy(String irmCcy) {
            this.irmCcy = irmCcy;
            return this;
        }

        public Builder ieCodeIrm(String ieCodeIrm) {
            this.ieCodeIrm = ieCodeIrm;
            return this;
        }

        public Builder irmDate(java.time.LocalDateTime irmDate) {
            this.irmDate = irmDate;
            return this;
        }

        public Builder irmUtilAmt(Long irmUtilAmt) {
            this.irmUtilAmt = irmUtilAmt;
            return this;
        }

        public Builder remitName(String remitName) {
            this.remitName = remitName;
            return this;
        }

        public Builder remitCountry(String remitCountry) {
            this.remitCountry = remitCountry;
            return this;
        }

        public Builder remitBankName(String remitBankName) {
            this.remitBankName = remitBankName;
            return this;
        }

        public Builder remitBankCountry(String remitBankCountry) {
            this.remitBankCountry = remitBankCountry;
            return this;
        }

        public Builder swiftOtherBankRef(String swiftOtherBankRef) {
            this.swiftOtherBankRef = swiftOtherBankRef;
            return this;
        }

        public Builder purOfRemit(String purOfRemit) {
            this.purOfRemit = purOfRemit;
            return this;
        }

        public Builder amtUtil(Long amtUtil) {
            this.amtUtil = amtUtil;
            return this;
        }

        public Builder extDateIrm(java.time.LocalDateTime extDateIrm) {
            this.extDateIrm = extDateIrm;
            return this;
        }

        public Builder remarksIrme(String remarksIrme) {
            this.remarksIrme = remarksIrme;
            return this;
        }

        public Builder irmAdjNo(String irmAdjNo) {
            this.irmAdjNo = irmAdjNo;
            return this;
        }

        public Builder bankRefNo(String bankRefNo) {
            this.bankRefNo = bankRefNo;
            return this;
        }

        public Builder adjAmtIrm(Long adjAmtIrm) {
            this.adjAmtIrm = adjAmtIrm;
            return this;
        }

        public Builder remarksIrma(String remarksIrma) {
            this.remarksIrma = remarksIrma;
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

        public Builder trracsErrorCode(String trracsErrorCode) {
            this.trracsErrorCode = trracsErrorCode;
            return this;
        }

        public Builder trracsErrorDecs(String trracsErrorDecs) {
            this.trracsErrorDecs = trracsErrorDecs;
            return this;
        }

        public Builder trracsStatus(String trracsStatus) {
            this.trracsStatus = trracsStatus;
            return this;
        }

        public FgEdpmsIrmReq build() {
            return new FgEdpmsIrmReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, irmNo, irmAd, irmAmt, osAmtIrm, irmCcy, ieCodeIrm, irmDate, irmUtilAmt, remitName, remitCountry, remitBankName, remitBankCountry, swiftOtherBankRef, purOfRemit, amtUtil, extDateIrm, remarksIrme, irmAdjNo, bankRefNo, adjAmtIrm, remarksIrma, parentRefID, parentVersionID, trracsErrorCode, trracsErrorDecs, trracsStatus);
        }
    }
}
