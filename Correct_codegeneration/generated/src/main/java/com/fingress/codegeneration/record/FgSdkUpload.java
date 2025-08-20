package com.bsit.codegeneration.record;

public record FgSdkUpload(String ID, String referenceID, String applicantPartyCode, String applicantRefID, String issuingPartyCode, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String layoutTemplateID, String dmsEventID, String totalCount, String successCount, String errorCount, Long totalAmount, Long totalSuccessAmount, Long totalFailedAmount, String financeTypeCode, String financeDisplayStatus, String programName, String programCode, String partyRoleCode, String entityTypeCode, String entitySubTypeCode, String fileStatus, String taskReasonCode, String taskReasonText, Long warningCount, String layoutID) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String applicantPartyCode;

        private String applicantRefID;

        private String issuingPartyCode;

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

        private String layoutTemplateID;

        private String dmsEventID;

        private String totalCount;

        private String successCount;

        private String errorCount;

        private Long totalAmount;

        private Long totalSuccessAmount;

        private Long totalFailedAmount;

        private String financeTypeCode;

        private String financeDisplayStatus;

        private String programName;

        private String programCode;

        private String partyRoleCode;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String fileStatus;

        private String taskReasonCode;

        private String taskReasonText;

        private Long warningCount;

        private String layoutID;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder applicantRefID(String applicantRefID) {
            this.applicantRefID = applicantRefID;
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            this.issuingPartyCode = issuingPartyCode;
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

        public Builder layoutTemplateID(String layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder totalCount(String totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Builder successCount(String successCount) {
            this.successCount = successCount;
            return this;
        }

        public Builder errorCount(String errorCount) {
            this.errorCount = errorCount;
            return this;
        }

        public Builder totalAmount(Long totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder totalSuccessAmount(Long totalSuccessAmount) {
            this.totalSuccessAmount = totalSuccessAmount;
            return this;
        }

        public Builder totalFailedAmount(Long totalFailedAmount) {
            this.totalFailedAmount = totalFailedAmount;
            return this;
        }

        public Builder financeTypeCode(String financeTypeCode) {
            this.financeTypeCode = financeTypeCode;
            return this;
        }

        public Builder financeDisplayStatus(String financeDisplayStatus) {
            this.financeDisplayStatus = financeDisplayStatus;
            return this;
        }

        public Builder programName(String programName) {
            this.programName = programName;
            return this;
        }

        public Builder programCode(String programCode) {
            this.programCode = programCode;
            return this;
        }

        public Builder partyRoleCode(String partyRoleCode) {
            this.partyRoleCode = partyRoleCode;
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

        public Builder fileStatus(String fileStatus) {
            this.fileStatus = fileStatus;
            return this;
        }

        public Builder taskReasonCode(String taskReasonCode) {
            this.taskReasonCode = taskReasonCode;
            return this;
        }

        public Builder taskReasonText(String taskReasonText) {
            this.taskReasonText = taskReasonText;
            return this;
        }

        public Builder warningCount(Long warningCount) {
            this.warningCount = warningCount;
            return this;
        }

        public Builder layoutID(String layoutID) {
            this.layoutID = layoutID;
            return this;
        }

        public FgSdkUpload build() {
            return new FgSdkUpload(ID, referenceID, applicantPartyCode, applicantRefID, issuingPartyCode, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, layoutTemplateID, dmsEventID, totalCount, successCount, errorCount, totalAmount, totalSuccessAmount, totalFailedAmount, financeTypeCode, financeDisplayStatus, programName, programCode, partyRoleCode, entityTypeCode, entitySubTypeCode, fileStatus, taskReasonCode, taskReasonText, warningCount, layoutID);
        }
    }
}
