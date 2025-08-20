package com.bsit.codegeneration.record;

public record FgTrdExpRegRq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String portCode, String expType, String sbNo, java.time.LocalDateTime sbDate, String formNo, String ieCode, String reqType, String irmNo, String irmAd, Long irmAmt, Long osAmtIrm, String irmCcy, String applicantParty, String issuingParty, String productStatus, String processID, String dmsEventID, String expAgency, String debitAccNum) {

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

        private String portCode;

        private String expType;

        private String sbNo;

        private java.time.LocalDateTime sbDate;

        private String formNo;

        private String ieCode;

        private String reqType;

        private String irmNo;

        private String irmAd;

        private Long irmAmt;

        private Long osAmtIrm;

        private String irmCcy;

        private String applicantParty;

        private String issuingParty;

        private String productStatus;

        private String processID;

        private String dmsEventID;

        private String expAgency;

        private String debitAccNum;

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

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder expType(String expType) {
            this.expType = expType;
            return this;
        }

        public Builder sbNo(String sbNo) {
            this.sbNo = sbNo;
            return this;
        }

        public Builder sbDate(java.time.LocalDateTime sbDate) {
            this.sbDate = sbDate;
            return this;
        }

        public Builder formNo(String formNo) {
            this.formNo = formNo;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder reqType(String reqType) {
            this.reqType = reqType;
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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder issuingParty(String issuingParty) {
            this.issuingParty = issuingParty;
            return this;
        }

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder expAgency(String expAgency) {
            this.expAgency = expAgency;
            return this;
        }

        public Builder debitAccNum(String debitAccNum) {
            this.debitAccNum = debitAccNum;
            return this;
        }

        public FgTrdExpRegRq build() {
            return new FgTrdExpRegRq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, portCode, expType, sbNo, sbDate, formNo, ieCode, reqType, irmNo, irmAd, irmAmt, osAmtIrm, irmCcy, applicantParty, issuingParty, productStatus, processID, dmsEventID, expAgency, debitAccNum);
        }
    }
}
