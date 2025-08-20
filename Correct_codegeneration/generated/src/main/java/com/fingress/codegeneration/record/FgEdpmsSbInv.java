package com.bsit.codegeneration.record;

public record FgEdpmsSbInv(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String billNo, String shipbillno, String formno, String invSlNo, String invNo, java.time.LocalDateTime invDate, String fobcurrcode, Long fobAmt, String frieghtcurrcode, Long frieghtAmt, String inscurrcode, Long insAmt, String ieCode, String parentRefID, Long parentVersionID) {

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

        private String applicantParty;

        private String fulfillmentParty;

        private Long isTemplate;

        private String billNo;

        private String shipbillno;

        private String formno;

        private String invSlNo;

        private String invNo;

        private java.time.LocalDateTime invDate;

        private String fobcurrcode;

        private Long fobAmt;

        private String frieghtcurrcode;

        private Long frieghtAmt;

        private String inscurrcode;

        private Long insAmt;

        private String ieCode;

        private String parentRefID;

        private Long parentVersionID;

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

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            this.fulfillmentParty = fulfillmentParty;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public Builder shipbillno(String shipbillno) {
            this.shipbillno = shipbillno;
            return this;
        }

        public Builder formno(String formno) {
            this.formno = formno;
            return this;
        }

        public Builder invSlNo(String invSlNo) {
            this.invSlNo = invSlNo;
            return this;
        }

        public Builder invNo(String invNo) {
            this.invNo = invNo;
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            this.invDate = invDate;
            return this;
        }

        public Builder fobcurrcode(String fobcurrcode) {
            this.fobcurrcode = fobcurrcode;
            return this;
        }

        public Builder fobAmt(Long fobAmt) {
            this.fobAmt = fobAmt;
            return this;
        }

        public Builder frieghtcurrcode(String frieghtcurrcode) {
            this.frieghtcurrcode = frieghtcurrcode;
            return this;
        }

        public Builder frieghtAmt(Long frieghtAmt) {
            this.frieghtAmt = frieghtAmt;
            return this;
        }

        public Builder inscurrcode(String inscurrcode) {
            this.inscurrcode = inscurrcode;
            return this;
        }

        public Builder insAmt(Long insAmt) {
            this.insAmt = insAmt;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
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

        public FgEdpmsSbInv build() {
            return new FgEdpmsSbInv(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, billNo, shipbillno, formno, invSlNo, invNo, invDate, fobcurrcode, fobAmt, frieghtcurrcode, frieghtAmt, inscurrcode, insAmt, ieCode, parentRefID, parentVersionID);
        }
    }
}
