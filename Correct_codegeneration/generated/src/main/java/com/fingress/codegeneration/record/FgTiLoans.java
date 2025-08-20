package com.bsit.codegeneration.record;

public record FgTiLoans(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String custMnm, java.time.LocalDateTime disbDate, Long interestRepaymentAmount, String masterRef, java.time.LocalDateTime maturityDate, String overdueYN, String status, Long versionID, Long isMasterVersion, Long totalRepaymentAmount, Long principleRepaymentAmount) {

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

        private String custMnm;

        private java.time.LocalDateTime disbDate;

        private Long interestRepaymentAmount;

        private String masterRef;

        private java.time.LocalDateTime maturityDate;

        private String overdueYN;

        private String status;

        private Long versionID;

        private Long isMasterVersion;

        private Long totalRepaymentAmount;

        private Long principleRepaymentAmount;

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

        public Builder custMnm(String custMnm) {
            this.custMnm = custMnm;
            return this;
        }

        public Builder disbDate(java.time.LocalDateTime disbDate) {
            this.disbDate = disbDate;
            return this;
        }

        public Builder interestRepaymentAmount(Long interestRepaymentAmount) {
            this.interestRepaymentAmount = interestRepaymentAmount;
            return this;
        }

        public Builder masterRef(String masterRef) {
            this.masterRef = masterRef;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder overdueYN(String overdueYN) {
            this.overdueYN = overdueYN;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder totalRepaymentAmount(Long totalRepaymentAmount) {
            this.totalRepaymentAmount = totalRepaymentAmount;
            return this;
        }

        public Builder principleRepaymentAmount(Long principleRepaymentAmount) {
            this.principleRepaymentAmount = principleRepaymentAmount;
            return this;
        }

        public FgTiLoans build() {
            return new FgTiLoans(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, custMnm, disbDate, interestRepaymentAmount, masterRef, maturityDate, overdueYN, status, versionID, isMasterVersion, totalRepaymentAmount, principleRepaymentAmount);
        }
    }
}
