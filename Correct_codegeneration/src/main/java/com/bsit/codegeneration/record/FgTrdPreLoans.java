package com.bsit.codegeneration.record;

import java.util.List;

public record FgTrdPreLoans(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Integer preLoanRefID, Integer loanRefID, String curCode, Long principalOutstanding, String inLoanCur, Long dspAmt, Long equDspAmt, Integer parentRefID, Integer parentVersionID, Integer irReferenceID, java.time.LocalDateTime disbDate, String applicantParty, Integer billRefID) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

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

        private Integer preLoanRefID;

        private Integer loanRefID;

        private String curCode;

        private Long principalOutstanding;

        private String inLoanCur;

        private Long dspAmt;

        private Long equDspAmt;

        private Integer parentRefID;

        private Integer parentVersionID;

        private Integer irReferenceID;

        private java.time.LocalDateTime disbDate;

        private String applicantParty;

        private Integer billRefID;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
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

        public Builder preLoanRefID(Integer preLoanRefID) {
            this.preLoanRefID = preLoanRefID;
            return this;
        }

        public Builder loanRefID(Integer loanRefID) {
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

        public Builder inLoanCur(String inLoanCur) {
            this.inLoanCur = inLoanCur;
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

        public Builder parentRefID(Integer parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder irReferenceID(Integer irReferenceID) {
            this.irReferenceID = irReferenceID;
            return this;
        }

        public Builder disbDate(java.time.LocalDateTime disbDate) {
            this.disbDate = disbDate;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder billRefID(Integer billRefID) {
            this.billRefID = billRefID;
            return this;
        }

        public FgTrdPreLoans build() {
            return new FgTrdPreLoans(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, preLoanRefID, loanRefID, curCode, principalOutstanding, inLoanCur, dspAmt, equDspAmt, parentRefID, parentVersionID, irReferenceID, disbDate, applicantParty, billRefID);
        }
    }
}
