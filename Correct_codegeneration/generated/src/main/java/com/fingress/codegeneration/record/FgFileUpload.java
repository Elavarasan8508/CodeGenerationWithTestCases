package com.bsit.codegeneration.record;

public record FgFileUpload(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String fgClientCode, String fgFiller1, String fgFiller2, String fgFiller3, String fgFileNameHdr, Long layoutTemplateID, String dmsEventID, String totalCount, String successCount, String errorCount, Long totalAmount, Long totalSuccessAmount, Long totalFailedAmount, String financeTypeCode, String financeDisplayStatus, String programName, String programCode, String partyRoleCode, String entityTypeCode, String entitySubTypeCode, String fileStatus, String taskReasonCode, String taskReasonText, Long warningCount, String layoutName, Long layoutTemplateVersionID, String authLevelCode, String applicantRefID, String issuingPartyCode, String processID, String uploadRefID, Long isMasterVersion, String taskReason, String displayStatus, String fgSourceCode, String ftTotalNoOfInstructions, String fileName, String fgBatchRefNumber, String fgProductCode, String categorySubType, Long fgInstructionsCount, Long fgTotalAmount, Long fgTotalInstruments, Long ftTotalInstruments, Long ftTotalAmount, java.time.LocalDateTime fgBatchDate, java.time.LocalDateTime fgPaymentDate, String uuid, String entity, String issuersRef, String equCcy, Long equAmount, Long blanketAmount, Long terms, String authEquCcy, Long authEquAmount, Long authBlanketAmount, String displayEquCcy, Long displayEquAmount, Long displayBlanketAmount, Long authFxBaseRate, Long displayFxBaseRate, String applicantPartyCode, Long optDeclare, String fileSource, String streetName, String townName, String countrySubDiv, String bankAbbvName) {

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

        private String fgClientCode;

        private String fgFiller1;

        private String fgFiller2;

        private String fgFiller3;

        private String fgFileNameHdr;

        private Long layoutTemplateID;

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

        private String layoutName;

        private Long layoutTemplateVersionID;

        private String authLevelCode;

        private String applicantRefID;

        private String issuingPartyCode;

        private String processID;

        private String uploadRefID;

        private Long isMasterVersion;

        private String taskReason;

        private String displayStatus;

        private String fgSourceCode;

        private String ftTotalNoOfInstructions;

        private String fileName;

        private String fgBatchRefNumber;

        private String fgProductCode;

        private String categorySubType;

        private Long fgInstructionsCount;

        private Long fgTotalAmount;

        private Long fgTotalInstruments;

        private Long ftTotalInstruments;

        private Long ftTotalAmount;

        private java.time.LocalDateTime fgBatchDate;

        private java.time.LocalDateTime fgPaymentDate;

        private String uuid;

        private String entity;

        private String issuersRef;

        private String equCcy;

        private Long equAmount;

        private Long blanketAmount;

        private Long terms;

        private String authEquCcy;

        private Long authEquAmount;

        private Long authBlanketAmount;

        private String displayEquCcy;

        private Long displayEquAmount;

        private Long displayBlanketAmount;

        private Long authFxBaseRate;

        private Long displayFxBaseRate;

        private String applicantPartyCode;

        private Long optDeclare;

        private String fileSource;

        private String streetName;

        private String townName;

        private String countrySubDiv;

        private String bankAbbvName;

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

        public Builder fgClientCode(String fgClientCode) {
            this.fgClientCode = fgClientCode;
            return this;
        }

        public Builder fgFiller1(String fgFiller1) {
            this.fgFiller1 = fgFiller1;
            return this;
        }

        public Builder fgFiller2(String fgFiller2) {
            this.fgFiller2 = fgFiller2;
            return this;
        }

        public Builder fgFiller3(String fgFiller3) {
            this.fgFiller3 = fgFiller3;
            return this;
        }

        public Builder fgFileNameHdr(String fgFileNameHdr) {
            this.fgFileNameHdr = fgFileNameHdr;
            return this;
        }

        public Builder layoutTemplateID(Long layoutTemplateID) {
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

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder layoutTemplateVersionID(Long layoutTemplateVersionID) {
            this.layoutTemplateVersionID = layoutTemplateVersionID;
            return this;
        }

        public Builder authLevelCode(String authLevelCode) {
            this.authLevelCode = authLevelCode;
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

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder fgSourceCode(String fgSourceCode) {
            this.fgSourceCode = fgSourceCode;
            return this;
        }

        public Builder ftTotalNoOfInstructions(String ftTotalNoOfInstructions) {
            this.ftTotalNoOfInstructions = ftTotalNoOfInstructions;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fgBatchRefNumber(String fgBatchRefNumber) {
            this.fgBatchRefNumber = fgBatchRefNumber;
            return this;
        }

        public Builder fgProductCode(String fgProductCode) {
            this.fgProductCode = fgProductCode;
            return this;
        }

        public Builder categorySubType(String categorySubType) {
            this.categorySubType = categorySubType;
            return this;
        }

        public Builder fgInstructionsCount(Long fgInstructionsCount) {
            this.fgInstructionsCount = fgInstructionsCount;
            return this;
        }

        public Builder fgTotalAmount(Long fgTotalAmount) {
            this.fgTotalAmount = fgTotalAmount;
            return this;
        }

        public Builder fgTotalInstruments(Long fgTotalInstruments) {
            this.fgTotalInstruments = fgTotalInstruments;
            return this;
        }

        public Builder ftTotalInstruments(Long ftTotalInstruments) {
            this.ftTotalInstruments = ftTotalInstruments;
            return this;
        }

        public Builder ftTotalAmount(Long ftTotalAmount) {
            this.ftTotalAmount = ftTotalAmount;
            return this;
        }

        public Builder fgBatchDate(java.time.LocalDateTime fgBatchDate) {
            this.fgBatchDate = fgBatchDate;
            return this;
        }

        public Builder fgPaymentDate(java.time.LocalDateTime fgPaymentDate) {
            this.fgPaymentDate = fgPaymentDate;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder entity(String entity) {
            this.entity = entity;
            return this;
        }

        public Builder issuersRef(String issuersRef) {
            this.issuersRef = issuersRef;
            return this;
        }

        public Builder equCcy(String equCcy) {
            this.equCcy = equCcy;
            return this;
        }

        public Builder equAmount(Long equAmount) {
            this.equAmount = equAmount;
            return this;
        }

        public Builder blanketAmount(Long blanketAmount) {
            this.blanketAmount = blanketAmount;
            return this;
        }

        public Builder terms(Long terms) {
            this.terms = terms;
            return this;
        }

        public Builder authEquCcy(String authEquCcy) {
            this.authEquCcy = authEquCcy;
            return this;
        }

        public Builder authEquAmount(Long authEquAmount) {
            this.authEquAmount = authEquAmount;
            return this;
        }

        public Builder authBlanketAmount(Long authBlanketAmount) {
            this.authBlanketAmount = authBlanketAmount;
            return this;
        }

        public Builder displayEquCcy(String displayEquCcy) {
            this.displayEquCcy = displayEquCcy;
            return this;
        }

        public Builder displayEquAmount(Long displayEquAmount) {
            this.displayEquAmount = displayEquAmount;
            return this;
        }

        public Builder displayBlanketAmount(Long displayBlanketAmount) {
            this.displayBlanketAmount = displayBlanketAmount;
            return this;
        }

        public Builder authFxBaseRate(Long authFxBaseRate) {
            this.authFxBaseRate = authFxBaseRate;
            return this;
        }

        public Builder displayFxBaseRate(Long displayFxBaseRate) {
            this.displayFxBaseRate = displayFxBaseRate;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder optDeclare(Long optDeclare) {
            this.optDeclare = optDeclare;
            return this;
        }

        public Builder fileSource(String fileSource) {
            this.fileSource = fileSource;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder townName(String townName) {
            this.townName = townName;
            return this;
        }

        public Builder countrySubDiv(String countrySubDiv) {
            this.countrySubDiv = countrySubDiv;
            return this;
        }

        public Builder bankAbbvName(String bankAbbvName) {
            this.bankAbbvName = bankAbbvName;
            return this;
        }

        public FgFileUpload build() {
            return new FgFileUpload(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, fgClientCode, fgFiller1, fgFiller2, fgFiller3, fgFileNameHdr, layoutTemplateID, dmsEventID, totalCount, successCount, errorCount, totalAmount, totalSuccessAmount, totalFailedAmount, financeTypeCode, financeDisplayStatus, programName, programCode, partyRoleCode, entityTypeCode, entitySubTypeCode, fileStatus, taskReasonCode, taskReasonText, warningCount, layoutName, layoutTemplateVersionID, authLevelCode, applicantRefID, issuingPartyCode, processID, uploadRefID, isMasterVersion, taskReason, displayStatus, fgSourceCode, ftTotalNoOfInstructions, fileName, fgBatchRefNumber, fgProductCode, categorySubType, fgInstructionsCount, fgTotalAmount, fgTotalInstruments, ftTotalInstruments, ftTotalAmount, fgBatchDate, fgPaymentDate, uuid, entity, issuersRef, equCcy, equAmount, blanketAmount, terms, authEquCcy, authEquAmount, authBlanketAmount, displayEquCcy, displayEquAmount, displayBlanketAmount, authFxBaseRate, displayFxBaseRate, applicantPartyCode, optDeclare, fileSource, streetName, townName, countrySubDiv, bankAbbvName);
        }
    }
}
