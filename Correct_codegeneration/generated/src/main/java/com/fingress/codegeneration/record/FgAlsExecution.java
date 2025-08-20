package com.bsit.codegeneration.record;

public record FgAlsExecution(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String customerCrn, String accountNo, String lastExecution, String status, Long totalLoans, Long processedLoans, String errorDesc, Long accountBalance, Long totalBalance, String reason, String executionStartTime, String executionEndTime, String finacleStatus, String accountStatus, String debitLock, String customerName) {

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

        private String accountNo;

        private String lastExecution;

        private String status;

        private Long totalLoans;

        private Long processedLoans;

        private String errorDesc;

        private Long accountBalance;

        private Long totalBalance;

        private String reason;

        private String executionStartTime;

        private String executionEndTime;

        private String finacleStatus;

        private String accountStatus;

        private String debitLock;

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

        public Builder accountNo(String accountNo) {
            this.accountNo = accountNo;
            return this;
        }

        public Builder lastExecution(String lastExecution) {
            this.lastExecution = lastExecution;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder totalLoans(Long totalLoans) {
            this.totalLoans = totalLoans;
            return this;
        }

        public Builder processedLoans(Long processedLoans) {
            this.processedLoans = processedLoans;
            return this;
        }

        public Builder errorDesc(String errorDesc) {
            this.errorDesc = errorDesc;
            return this;
        }

        public Builder accountBalance(Long accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public Builder totalBalance(Long totalBalance) {
            this.totalBalance = totalBalance;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder executionStartTime(String executionStartTime) {
            this.executionStartTime = executionStartTime;
            return this;
        }

        public Builder executionEndTime(String executionEndTime) {
            this.executionEndTime = executionEndTime;
            return this;
        }

        public Builder finacleStatus(String finacleStatus) {
            this.finacleStatus = finacleStatus;
            return this;
        }

        public Builder accountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
            return this;
        }

        public Builder debitLock(String debitLock) {
            this.debitLock = debitLock;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public FgAlsExecution build() {
            return new FgAlsExecution(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, customerCrn, accountNo, lastExecution, status, totalLoans, processedLoans, errorDesc, accountBalance, totalBalance, reason, executionStartTime, executionEndTime, finacleStatus, accountStatus, debitLock, customerName);
        }
    }
}
