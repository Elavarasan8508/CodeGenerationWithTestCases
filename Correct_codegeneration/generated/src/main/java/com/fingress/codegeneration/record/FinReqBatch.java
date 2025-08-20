package com.bsit.codegeneration.record;

public record FinReqBatch(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String partyType, String customerCrn, String programLayout, String layoutName, java.time.LocalDateTime batchValueDate, String loanRefID, java.time.LocalDateTime loanDueDate, Long requestAmount, String ccy, String returnText, Long batchAmount, String limitNodeReference, Long snapshotLimit, String taskReason, String productType, Long financeAmount, Long financingAmount, Long tenorInDays, Long intPeriodInDays, Long contractPeriod, String tnxDisplayRemarks, String tnxDisplayStatus, java.time.LocalDateTime maturityDate, String limitNodeReference2, String batchDisplayStatus, String batchDisplayRemarks, String requestInitiationType, String loanRequestType, String layoutUuid, String batchStatus, String productStatus, Long totalCount, String entityTypeCode, String entitySubTypeCode, Long versionID, Long isMasterVersion, String layoutID, String customerRole, String cpCode, String batchAction, String uploadRefID, String ownerParty, String applicantName, String fileName, String financeParty, String cpName) {

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

        private String partyType;

        private String customerCrn;

        private String programLayout;

        private String layoutName;

        private java.time.LocalDateTime batchValueDate;

        private String loanRefID;

        private java.time.LocalDateTime loanDueDate;

        private Long requestAmount;

        private String ccy;

        private String returnText;

        private Long batchAmount;

        private String limitNodeReference;

        private Long snapshotLimit;

        private String taskReason;

        private String productType;

        private Long financeAmount;

        private Long financingAmount;

        private Long tenorInDays;

        private Long intPeriodInDays;

        private Long contractPeriod;

        private String tnxDisplayRemarks;

        private String tnxDisplayStatus;

        private java.time.LocalDateTime maturityDate;

        private String limitNodeReference2;

        private String batchDisplayStatus;

        private String batchDisplayRemarks;

        private String requestInitiationType;

        private String loanRequestType;

        private String layoutUuid;

        private String batchStatus;

        private String productStatus;

        private Long totalCount;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private Long versionID;

        private Long isMasterVersion;

        private String layoutID;

        private String customerRole;

        private String cpCode;

        private String batchAction;

        private String uploadRefID;

        private String ownerParty;

        private String applicantName;

        private String fileName;

        private String financeParty;

        private String cpName;

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

        public Builder partyType(String partyType) {
            this.partyType = partyType;
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            this.customerCrn = customerCrn;
            return this;
        }

        public Builder programLayout(String programLayout) {
            this.programLayout = programLayout;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder batchValueDate(java.time.LocalDateTime batchValueDate) {
            this.batchValueDate = batchValueDate;
            return this;
        }

        public Builder loanRefID(String loanRefID) {
            this.loanRefID = loanRefID;
            return this;
        }

        public Builder loanDueDate(java.time.LocalDateTime loanDueDate) {
            this.loanDueDate = loanDueDate;
            return this;
        }

        public Builder requestAmount(Long requestAmount) {
            this.requestAmount = requestAmount;
            return this;
        }

        public Builder ccy(String ccy) {
            this.ccy = ccy;
            return this;
        }

        public Builder returnText(String returnText) {
            this.returnText = returnText;
            return this;
        }

        public Builder batchAmount(Long batchAmount) {
            this.batchAmount = batchAmount;
            return this;
        }

        public Builder limitNodeReference(String limitNodeReference) {
            this.limitNodeReference = limitNodeReference;
            return this;
        }

        public Builder snapshotLimit(Long snapshotLimit) {
            this.snapshotLimit = snapshotLimit;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder financeAmount(Long financeAmount) {
            this.financeAmount = financeAmount;
            return this;
        }

        public Builder financingAmount(Long financingAmount) {
            this.financingAmount = financingAmount;
            return this;
        }

        public Builder tenorInDays(Long tenorInDays) {
            this.tenorInDays = tenorInDays;
            return this;
        }

        public Builder intPeriodInDays(Long intPeriodInDays) {
            this.intPeriodInDays = intPeriodInDays;
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            this.contractPeriod = contractPeriod;
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            this.tnxDisplayRemarks = tnxDisplayRemarks;
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            this.tnxDisplayStatus = tnxDisplayStatus;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder limitNodeReference2(String limitNodeReference2) {
            this.limitNodeReference2 = limitNodeReference2;
            return this;
        }

        public Builder batchDisplayStatus(String batchDisplayStatus) {
            this.batchDisplayStatus = batchDisplayStatus;
            return this;
        }

        public Builder batchDisplayRemarks(String batchDisplayRemarks) {
            this.batchDisplayRemarks = batchDisplayRemarks;
            return this;
        }

        public Builder requestInitiationType(String requestInitiationType) {
            this.requestInitiationType = requestInitiationType;
            return this;
        }

        public Builder loanRequestType(String loanRequestType) {
            this.loanRequestType = loanRequestType;
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            this.layoutUuid = layoutUuid;
            return this;
        }

        public Builder batchStatus(String batchStatus) {
            this.batchStatus = batchStatus;
            return this;
        }

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder totalCount(Long totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
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

        public Builder layoutID(String layoutID) {
            this.layoutID = layoutID;
            return this;
        }

        public Builder customerRole(String customerRole) {
            this.customerRole = customerRole;
            return this;
        }

        public Builder cpCode(String cpCode) {
            this.cpCode = cpCode;
            return this;
        }

        public Builder batchAction(String batchAction) {
            this.batchAction = batchAction;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder ownerParty(String ownerParty) {
            this.ownerParty = ownerParty;
            return this;
        }

        public Builder applicantName(String applicantName) {
            this.applicantName = applicantName;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder financeParty(String financeParty) {
            this.financeParty = financeParty;
            return this;
        }

        public Builder cpName(String cpName) {
            this.cpName = cpName;
            return this;
        }

        public FinReqBatch build() {
            return new FinReqBatch(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, partyType, customerCrn, programLayout, layoutName, batchValueDate, loanRefID, loanDueDate, requestAmount, ccy, returnText, batchAmount, limitNodeReference, snapshotLimit, taskReason, productType, financeAmount, financingAmount, tenorInDays, intPeriodInDays, contractPeriod, tnxDisplayRemarks, tnxDisplayStatus, maturityDate, limitNodeReference2, batchDisplayStatus, batchDisplayRemarks, requestInitiationType, loanRequestType, layoutUuid, batchStatus, productStatus, totalCount, entityTypeCode, entitySubTypeCode, versionID, isMasterVersion, layoutID, customerRole, cpCode, batchAction, uploadRefID, ownerParty, applicantName, fileName, financeParty, cpName);
        }
    }
}
