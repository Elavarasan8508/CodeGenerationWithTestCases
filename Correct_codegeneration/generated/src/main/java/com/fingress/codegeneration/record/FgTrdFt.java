package com.bsit.codegeneration.record;

public record FgTrdFt(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String curCode, java.time.LocalDateTime lodgeDate, String drawee, Long outstandingAmt, Long outstandingAmtSettled, Long dspAmt, Long deduction, String reason, String parentRefID, Long parentVersionID, String irReferenceID, String ocfRefID, String applicantParty, String billRefID) {

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

        private String curCode;

        private java.time.LocalDateTime lodgeDate;

        private String drawee;

        private Long outstandingAmt;

        private Long outstandingAmtSettled;

        private Long dspAmt;

        private Long deduction;

        private String reason;

        private String parentRefID;

        private Long parentVersionID;

        private String irReferenceID;

        private String ocfRefID;

        private String applicantParty;

        private String billRefID;

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

        public Builder curCode(String curCode) {
            this.curCode = curCode;
            return this;
        }

        public Builder lodgeDate(java.time.LocalDateTime lodgeDate) {
            this.lodgeDate = lodgeDate;
            return this;
        }

        public Builder drawee(String drawee) {
            this.drawee = drawee;
            return this;
        }

        public Builder outstandingAmt(Long outstandingAmt) {
            this.outstandingAmt = outstandingAmt;
            return this;
        }

        public Builder outstandingAmtSettled(Long outstandingAmtSettled) {
            this.outstandingAmtSettled = outstandingAmtSettled;
            return this;
        }

        public Builder dspAmt(Long dspAmt) {
            this.dspAmt = dspAmt;
            return this;
        }

        public Builder deduction(Long deduction) {
            this.deduction = deduction;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
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

        public Builder irReferenceID(String irReferenceID) {
            this.irReferenceID = irReferenceID;
            return this;
        }

        public Builder ocfRefID(String ocfRefID) {
            this.ocfRefID = ocfRefID;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder billRefID(String billRefID) {
            this.billRefID = billRefID;
            return this;
        }

        public FgTrdFt build() {
            return new FgTrdFt(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, curCode, lodgeDate, drawee, outstandingAmt, outstandingAmtSettled, dspAmt, deduction, reason, parentRefID, parentVersionID, irReferenceID, ocfRefID, applicantParty, billRefID);
        }
    }
}
