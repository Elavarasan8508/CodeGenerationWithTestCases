package com.bsit.codegeneration.record;

public record FgAlsRepaymentHistory(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String customerCrn, String settlementAmt, String accountNo, Long weight, String status, java.time.LocalDateTime maturityDate, java.time.LocalDateTime disbDate, String overdueYN, String masterRef, String logicOfSettlement, Long availableBalance, Long totalBalance, Long totalRepaymentAmount, Long principleRepaymentAmount, Long interestRepaymentAmount, Long accountBalance, String customerName) {

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

        private String customerCrn;

        private String settlementAmt;

        private String accountNo;

        private Long weight;

        private String status;

        private java.time.LocalDateTime maturityDate;

        private java.time.LocalDateTime disbDate;

        private String overdueYN;

        private String masterRef;

        private String logicOfSettlement;

        private Long availableBalance;

        private Long totalBalance;

        private Long totalRepaymentAmount;

        private Long principleRepaymentAmount;

        private Long interestRepaymentAmount;

        private Long accountBalance;

        private String customerName;

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

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder settlementAmt(String settlementAmt) {
            this.settlementAmt = settlementAmt;
            return this;
        }

        public Builder accountNo(String accountNo) {
            this.accountNo = accountNo;
            return this;
        }

        public Builder weight(Long weight) {
            this.weight = weight;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder disbDate(java.time.LocalDateTime disbDate) {
            this.disbDate = disbDate;
            return this;
        }

        public Builder overdueYN(String overdueYN) {
            this.overdueYN = overdueYN;
            return this;
        }

        public Builder masterRef(String masterRef) {
            this.masterRef = masterRef;
            return this;
        }

        public Builder logicOfSettlement(String logicOfSettlement) {
            this.logicOfSettlement = logicOfSettlement;
            return this;
        }

        public Builder availableBalance(Long availableBalance) {
            this.availableBalance = availableBalance;
            return this;
        }

        public Builder totalBalance(Long totalBalance) {
            this.totalBalance = totalBalance;
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

        public Builder interestRepaymentAmount(Long interestRepaymentAmount) {
            this.interestRepaymentAmount = interestRepaymentAmount;
            return this;
        }

        public Builder accountBalance(Long accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public FgAlsRepaymentHistory build() {
            return new FgAlsRepaymentHistory(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, customerCrn, settlementAmt, accountNo, weight, status, maturityDate, disbDate, overdueYN, masterRef, logicOfSettlement, availableBalance, totalBalance, totalRepaymentAmount, principleRepaymentAmount, interestRepaymentAmount, accountBalance, customerName);
        }
    }
}
