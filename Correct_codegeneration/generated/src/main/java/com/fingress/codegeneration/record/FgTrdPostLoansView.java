package com.bsit.codegeneration.record;

public record FgTrdPostLoansView(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String postLoanRefID, String txnRefID, String loanRefID, String curCode, Long principalOutstanding, Long dspAmt, Long equDspAmt, String collectShort, String accNo, String applicantParty) {

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

        private String postLoanRefID;

        private String txnRefID;

        private String loanRefID;

        private String curCode;

        private Long principalOutstanding;

        private Long dspAmt;

        private Long equDspAmt;

        private String collectShort;

        private String accNo;

        private String applicantParty;

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

        public Builder postLoanRefID(String postLoanRefID) {
            this.postLoanRefID = postLoanRefID;
            return this;
        }

        public Builder txnRefID(String txnRefID) {
            this.txnRefID = txnRefID;
            return this;
        }

        public Builder loanRefID(String loanRefID) {
            this.loanRefID = loanRefID;
            return this;
        }

        public Builder curCode(String curCode) {
            this.curCode = curCode;
            return this;
        }

        public Builder principalOutstanding(Long principalOutstanding) {
            this.principalOutstanding = principalOutstanding;
            return this;
        }

        public Builder dspAmt(Long dspAmt) {
            this.dspAmt = dspAmt;
            return this;
        }

        public Builder equDspAmt(Long equDspAmt) {
            this.equDspAmt = equDspAmt;
            return this;
        }

        public Builder collectShort(String collectShort) {
            this.collectShort = collectShort;
            return this;
        }

        public Builder accNo(String accNo) {
            this.accNo = accNo;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public FgTrdPostLoansView build() {
            return new FgTrdPostLoansView(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, postLoanRefID, txnRefID, loanRefID, curCode, principalOutstanding, dspAmt, equDspAmt, collectShort, accNo, applicantParty);
        }
    }
}
