package com.bsit.codegeneration.record;

public record FgRuleAls(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, Long versionID, Long isMasterVersion, String customerCrn, String accountNumber, String productCode, String logicOfSettlement, Long maxSettlementPercentage, Long maxSettlementAmount, String repaymentAction, String status, String debitLock, String processID, String slotReference, String customerName, String monthendSlot, String virtualAccountNumber, String accountType, String counterpartyCrn) {

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

        private Long versionID;

        private Long isMasterVersion;

        private String customerCrn;

        private String accountNumber;

        private String productCode;

        private String logicOfSettlement;

        private Long maxSettlementPercentage;

        private Long maxSettlementAmount;

        private String repaymentAction;

        private String status;

        private String debitLock;

        private String processID;

        private String slotReference;

        private String customerName;

        private String monthendSlot;

        private String virtualAccountNumber;

        private String accountType;

        private String counterpartyCrn;

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

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder logicOfSettlement(String logicOfSettlement) {
            this.logicOfSettlement = logicOfSettlement;
            return this;
        }

        public Builder maxSettlementPercentage(Long maxSettlementPercentage) {
            this.maxSettlementPercentage = maxSettlementPercentage;
            return this;
        }

        public Builder maxSettlementAmount(Long maxSettlementAmount) {
            this.maxSettlementAmount = maxSettlementAmount;
            return this;
        }

        public Builder repaymentAction(String repaymentAction) {
            this.repaymentAction = repaymentAction;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder debitLock(String debitLock) {
            this.debitLock = debitLock;
            return this;
        }

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder slotReference(String slotReference) {
            this.slotReference = slotReference;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder monthendSlot(String monthendSlot) {
            this.monthendSlot = monthendSlot;
            return this;
        }

        public Builder virtualAccountNumber(String virtualAccountNumber) {
            this.virtualAccountNumber = virtualAccountNumber;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder counterpartyCrn(String counterpartyCrn) {
            this.counterpartyCrn = counterpartyCrn;
            return this;
        }

        public FgRuleAls build() {
            return new FgRuleAls(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, versionID, isMasterVersion, customerCrn, accountNumber, productCode, logicOfSettlement, maxSettlementPercentage, maxSettlementAmount, repaymentAction, status, debitLock, processID, slotReference, customerName, monthendSlot, virtualAccountNumber, accountType, counterpartyCrn);
        }
    }
}
