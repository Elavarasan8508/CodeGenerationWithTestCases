package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgFileUpload {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

    private String fgClientCode;

    private String fgFiller1;

    private String fgFiller2;

    private String fgFiller3;

    private String fgFileNameHdr;

    private Integer layoutTemplateID;

    private Integer dmsEventID;

    private java.math.BigDecimal totalCount;

    private String successCount;

    private String errorCount;

    private java.math.BigDecimal totalAmount;

    private java.math.BigDecimal totalSuccessAmount;

    private java.math.BigDecimal totalFailedAmount;

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

    private java.math.BigDecimal warningCount;

    private String layoutName;

    private Integer layoutTemplateVersionID;

    private String authLevelCode;

    private Integer applicantRefID;

    private String issuingPartyCode;

    private Integer processID;

    private Integer uploadRefID;

    private Integer isMasterVersion;

    private String taskReason;

    private String displayStatus;

    private String fgSourceCode;

    private java.math.BigDecimal ftTotalNoOfInstructions;

    private String fileName;

    private String fgBatchRefNumber;

    private String fgProductCode;

    private String categorySubType;

    private java.math.BigDecimal fgInstructionsCount;

    private java.math.BigDecimal fgTotalAmount;

    private java.math.BigDecimal fgTotalInstruments;

    private java.math.BigDecimal ftTotalInstruments;

    private java.math.BigDecimal ftTotalAmount;

    private java.time.LocalDateTime fgBatchDate;

    private java.time.LocalDateTime fgPaymentDate;

    private String uuid;

    private String entity;

    private String issuersRef;

    private String equCcy;

    private java.math.BigDecimal equAmount;

    private java.math.BigDecimal blanketAmount;

    private Integer terms;

    private String authEquCcy;

    private java.math.BigDecimal authEquAmount;

    private java.math.BigDecimal authBlanketAmount;

    private String displayEquCcy;

    private java.math.BigDecimal displayEquAmount;

    private java.math.BigDecimal displayBlanketAmount;

    private java.math.BigDecimal authFxBaseRate;

    private java.math.BigDecimal displayFxBaseRate;

    private String applicantPartyCode;

    private Integer optDeclare;

    private String fileSource;

    private String streetName;

    private String townName;

    private String countrySubDiv;

    private String bankAbbvName;

    private Integer optionalDeclaration;

    public FgFileUpload() {
    }

    public FgFileUpload(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String fgClientCode, String fgFiller1, String fgFiller2, String fgFiller3, String fgFileNameHdr, Integer layoutTemplateID, Integer dmsEventID, java.math.BigDecimal totalCount, String successCount, String errorCount, java.math.BigDecimal totalAmount, java.math.BigDecimal totalSuccessAmount, java.math.BigDecimal totalFailedAmount, String financeTypeCode, String financeDisplayStatus, String programName, String programCode, String partyRoleCode, String entityTypeCode, String entitySubTypeCode, String fileStatus, String taskReasonCode, String taskReasonText, java.math.BigDecimal warningCount, String layoutName, Integer layoutTemplateVersionID, String authLevelCode, Integer applicantRefID, String issuingPartyCode, Integer processID, Integer uploadRefID, Integer isMasterVersion, String taskReason, String displayStatus, String fgSourceCode, java.math.BigDecimal ftTotalNoOfInstructions, String fileName, String fgBatchRefNumber, String fgProductCode, String categorySubType, java.math.BigDecimal fgInstructionsCount, java.math.BigDecimal fgTotalAmount, java.math.BigDecimal fgTotalInstruments, java.math.BigDecimal ftTotalInstruments, java.math.BigDecimal ftTotalAmount, java.time.LocalDateTime fgBatchDate, java.time.LocalDateTime fgPaymentDate, String uuid, String entity, String issuersRef, String equCcy, java.math.BigDecimal equAmount, java.math.BigDecimal blanketAmount, Integer terms, String authEquCcy, java.math.BigDecimal authEquAmount, java.math.BigDecimal authBlanketAmount, String displayEquCcy, java.math.BigDecimal displayEquAmount, java.math.BigDecimal displayBlanketAmount, java.math.BigDecimal authFxBaseRate, java.math.BigDecimal displayFxBaseRate, String applicantPartyCode, Integer optDeclare, String fileSource, String streetName, String townName, String countrySubDiv, String bankAbbvName, Integer optionalDeclaration) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.fgClientCode = fgClientCode;
        this.fgFiller1 = fgFiller1;
        this.fgFiller2 = fgFiller2;
        this.fgFiller3 = fgFiller3;
        this.fgFileNameHdr = fgFileNameHdr;
        this.layoutTemplateID = layoutTemplateID;
        this.dmsEventID = dmsEventID;
        this.totalCount = totalCount;
        this.successCount = successCount;
        this.errorCount = errorCount;
        this.totalAmount = totalAmount;
        this.totalSuccessAmount = totalSuccessAmount;
        this.totalFailedAmount = totalFailedAmount;
        this.financeTypeCode = financeTypeCode;
        this.financeDisplayStatus = financeDisplayStatus;
        this.programName = programName;
        this.programCode = programCode;
        this.partyRoleCode = partyRoleCode;
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.fileStatus = fileStatus;
        this.taskReasonCode = taskReasonCode;
        this.taskReasonText = taskReasonText;
        this.warningCount = warningCount;
        this.layoutName = layoutName;
        this.layoutTemplateVersionID = layoutTemplateVersionID;
        this.authLevelCode = authLevelCode;
        this.applicantRefID = applicantRefID;
        this.issuingPartyCode = issuingPartyCode;
        this.processID = processID;
        this.uploadRefID = uploadRefID;
        this.isMasterVersion = isMasterVersion;
        this.taskReason = taskReason;
        this.displayStatus = displayStatus;
        this.fgSourceCode = fgSourceCode;
        this.ftTotalNoOfInstructions = ftTotalNoOfInstructions;
        this.fileName = fileName;
        this.fgBatchRefNumber = fgBatchRefNumber;
        this.fgProductCode = fgProductCode;
        this.categorySubType = categorySubType;
        this.fgInstructionsCount = fgInstructionsCount;
        this.fgTotalAmount = fgTotalAmount;
        this.fgTotalInstruments = fgTotalInstruments;
        this.ftTotalInstruments = ftTotalInstruments;
        this.ftTotalAmount = ftTotalAmount;
        this.fgBatchDate = fgBatchDate;
        this.fgPaymentDate = fgPaymentDate;
        this.uuid = uuid;
        this.entity = entity;
        this.issuersRef = issuersRef;
        this.equCcy = equCcy;
        this.equAmount = equAmount;
        this.blanketAmount = blanketAmount;
        this.terms = terms;
        this.authEquCcy = authEquCcy;
        this.authEquAmount = authEquAmount;
        this.authBlanketAmount = authBlanketAmount;
        this.displayEquCcy = displayEquCcy;
        this.displayEquAmount = displayEquAmount;
        this.displayBlanketAmount = displayBlanketAmount;
        this.authFxBaseRate = authFxBaseRate;
        this.displayFxBaseRate = displayFxBaseRate;
        this.applicantPartyCode = applicantPartyCode;
        this.optDeclare = optDeclare;
        this.fileSource = fileSource;
        this.streetName = streetName;
        this.townName = townName;
        this.countrySubDiv = countrySubDiv;
        this.bankAbbvName = bankAbbvName;
        this.optionalDeclaration = optionalDeclaration;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getFgClientCode() {
        return fgClientCode;
    }

    public void setFgClientCode(String fgClientCode) {
        this.fgClientCode = fgClientCode;
    }

    public String getFgFiller1() {
        return fgFiller1;
    }

    public void setFgFiller1(String fgFiller1) {
        this.fgFiller1 = fgFiller1;
    }

    public String getFgFiller2() {
        return fgFiller2;
    }

    public void setFgFiller2(String fgFiller2) {
        this.fgFiller2 = fgFiller2;
    }

    public String getFgFiller3() {
        return fgFiller3;
    }

    public void setFgFiller3(String fgFiller3) {
        this.fgFiller3 = fgFiller3;
    }

    public String getFgFileNameHdr() {
        return fgFileNameHdr;
    }

    public void setFgFileNameHdr(String fgFileNameHdr) {
        this.fgFileNameHdr = fgFileNameHdr;
    }

    public Integer getLayoutTemplateID() {
        return layoutTemplateID;
    }

    public void setLayoutTemplateID(Integer layoutTemplateID) {
        this.layoutTemplateID = layoutTemplateID;
    }

    public Integer getDmsEventID() {
        return dmsEventID;
    }

    public void setDmsEventID(Integer dmsEventID) {
        this.dmsEventID = dmsEventID;
    }

    public java.math.BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(java.math.BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public String getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(String successCount) {
        this.successCount = successCount;
    }

    public String getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(String errorCount) {
        this.errorCount = errorCount;
    }

    public java.math.BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public java.math.BigDecimal getTotalSuccessAmount() {
        return totalSuccessAmount;
    }

    public void setTotalSuccessAmount(java.math.BigDecimal totalSuccessAmount) {
        this.totalSuccessAmount = totalSuccessAmount;
    }

    public java.math.BigDecimal getTotalFailedAmount() {
        return totalFailedAmount;
    }

    public void setTotalFailedAmount(java.math.BigDecimal totalFailedAmount) {
        this.totalFailedAmount = totalFailedAmount;
    }

    public String getFinanceTypeCode() {
        return financeTypeCode;
    }

    public void setFinanceTypeCode(String financeTypeCode) {
        this.financeTypeCode = financeTypeCode;
    }

    public String getFinanceDisplayStatus() {
        return financeDisplayStatus;
    }

    public void setFinanceDisplayStatus(String financeDisplayStatus) {
        this.financeDisplayStatus = financeDisplayStatus;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getPartyRoleCode() {
        return partyRoleCode;
    }

    public void setPartyRoleCode(String partyRoleCode) {
        this.partyRoleCode = partyRoleCode;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getTaskReasonCode() {
        return taskReasonCode;
    }

    public void setTaskReasonCode(String taskReasonCode) {
        this.taskReasonCode = taskReasonCode;
    }

    public String getTaskReasonText() {
        return taskReasonText;
    }

    public void setTaskReasonText(String taskReasonText) {
        this.taskReasonText = taskReasonText;
    }

    public java.math.BigDecimal getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(java.math.BigDecimal warningCount) {
        this.warningCount = warningCount;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public Integer getLayoutTemplateVersionID() {
        return layoutTemplateVersionID;
    }

    public void setLayoutTemplateVersionID(Integer layoutTemplateVersionID) {
        this.layoutTemplateVersionID = layoutTemplateVersionID;
    }

    public String getAuthLevelCode() {
        return authLevelCode;
    }

    public void setAuthLevelCode(String authLevelCode) {
        this.authLevelCode = authLevelCode;
    }

    public Integer getApplicantRefID() {
        return applicantRefID;
    }

    public void setApplicantRefID(Integer applicantRefID) {
        this.applicantRefID = applicantRefID;
    }

    public String getIssuingPartyCode() {
        return issuingPartyCode;
    }

    public void setIssuingPartyCode(String issuingPartyCode) {
        this.issuingPartyCode = issuingPartyCode;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getFgSourceCode() {
        return fgSourceCode;
    }

    public void setFgSourceCode(String fgSourceCode) {
        this.fgSourceCode = fgSourceCode;
    }

    public java.math.BigDecimal getFtTotalNoOfInstructions() {
        return ftTotalNoOfInstructions;
    }

    public void setFtTotalNoOfInstructions(java.math.BigDecimal ftTotalNoOfInstructions) {
        this.ftTotalNoOfInstructions = ftTotalNoOfInstructions;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFgBatchRefNumber() {
        return fgBatchRefNumber;
    }

    public void setFgBatchRefNumber(String fgBatchRefNumber) {
        this.fgBatchRefNumber = fgBatchRefNumber;
    }

    public String getFgProductCode() {
        return fgProductCode;
    }

    public void setFgProductCode(String fgProductCode) {
        this.fgProductCode = fgProductCode;
    }

    public String getCategorySubType() {
        return categorySubType;
    }

    public void setCategorySubType(String categorySubType) {
        this.categorySubType = categorySubType;
    }

    public java.math.BigDecimal getFgInstructionsCount() {
        return fgInstructionsCount;
    }

    public void setFgInstructionsCount(java.math.BigDecimal fgInstructionsCount) {
        this.fgInstructionsCount = fgInstructionsCount;
    }

    public java.math.BigDecimal getFgTotalAmount() {
        return fgTotalAmount;
    }

    public void setFgTotalAmount(java.math.BigDecimal fgTotalAmount) {
        this.fgTotalAmount = fgTotalAmount;
    }

    public java.math.BigDecimal getFgTotalInstruments() {
        return fgTotalInstruments;
    }

    public void setFgTotalInstruments(java.math.BigDecimal fgTotalInstruments) {
        this.fgTotalInstruments = fgTotalInstruments;
    }

    public java.math.BigDecimal getFtTotalInstruments() {
        return ftTotalInstruments;
    }

    public void setFtTotalInstruments(java.math.BigDecimal ftTotalInstruments) {
        this.ftTotalInstruments = ftTotalInstruments;
    }

    public java.math.BigDecimal getFtTotalAmount() {
        return ftTotalAmount;
    }

    public void setFtTotalAmount(java.math.BigDecimal ftTotalAmount) {
        this.ftTotalAmount = ftTotalAmount;
    }

    public java.time.LocalDateTime getFgBatchDate() {
        return fgBatchDate;
    }

    public void setFgBatchDate(java.time.LocalDateTime fgBatchDate) {
        this.fgBatchDate = fgBatchDate;
    }

    public java.time.LocalDateTime getFgPaymentDate() {
        return fgPaymentDate;
    }

    public void setFgPaymentDate(java.time.LocalDateTime fgPaymentDate) {
        this.fgPaymentDate = fgPaymentDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getIssuersRef() {
        return issuersRef;
    }

    public void setIssuersRef(String issuersRef) {
        this.issuersRef = issuersRef;
    }

    public String getEquCcy() {
        return equCcy;
    }

    public void setEquCcy(String equCcy) {
        this.equCcy = equCcy;
    }

    public java.math.BigDecimal getEquAmount() {
        return equAmount;
    }

    public void setEquAmount(java.math.BigDecimal equAmount) {
        this.equAmount = equAmount;
    }

    public java.math.BigDecimal getBlanketAmount() {
        return blanketAmount;
    }

    public void setBlanketAmount(java.math.BigDecimal blanketAmount) {
        this.blanketAmount = blanketAmount;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public String getAuthEquCcy() {
        return authEquCcy;
    }

    public void setAuthEquCcy(String authEquCcy) {
        this.authEquCcy = authEquCcy;
    }

    public java.math.BigDecimal getAuthEquAmount() {
        return authEquAmount;
    }

    public void setAuthEquAmount(java.math.BigDecimal authEquAmount) {
        this.authEquAmount = authEquAmount;
    }

    public java.math.BigDecimal getAuthBlanketAmount() {
        return authBlanketAmount;
    }

    public void setAuthBlanketAmount(java.math.BigDecimal authBlanketAmount) {
        this.authBlanketAmount = authBlanketAmount;
    }

    public String getDisplayEquCcy() {
        return displayEquCcy;
    }

    public void setDisplayEquCcy(String displayEquCcy) {
        this.displayEquCcy = displayEquCcy;
    }

    public java.math.BigDecimal getDisplayEquAmount() {
        return displayEquAmount;
    }

    public void setDisplayEquAmount(java.math.BigDecimal displayEquAmount) {
        this.displayEquAmount = displayEquAmount;
    }

    public java.math.BigDecimal getDisplayBlanketAmount() {
        return displayBlanketAmount;
    }

    public void setDisplayBlanketAmount(java.math.BigDecimal displayBlanketAmount) {
        this.displayBlanketAmount = displayBlanketAmount;
    }

    public java.math.BigDecimal getAuthFxBaseRate() {
        return authFxBaseRate;
    }

    public void setAuthFxBaseRate(java.math.BigDecimal authFxBaseRate) {
        this.authFxBaseRate = authFxBaseRate;
    }

    public java.math.BigDecimal getDisplayFxBaseRate() {
        return displayFxBaseRate;
    }

    public void setDisplayFxBaseRate(java.math.BigDecimal displayFxBaseRate) {
        this.displayFxBaseRate = displayFxBaseRate;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public Integer getOptDeclare() {
        return optDeclare;
    }

    public void setOptDeclare(Integer optDeclare) {
        this.optDeclare = optDeclare;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCountrySubDiv() {
        return countrySubDiv;
    }

    public void setCountrySubDiv(String countrySubDiv) {
        this.countrySubDiv = countrySubDiv;
    }

    public String getBankAbbvName() {
        return bankAbbvName;
    }

    public void setBankAbbvName(String bankAbbvName) {
        this.bankAbbvName = bankAbbvName;
    }

    public Integer getOptionalDeclaration() {
        return optionalDeclaration;
    }

    public void setOptionalDeclaration(Integer optionalDeclaration) {
        this.optionalDeclaration = optionalDeclaration;
    }

    public static class Builder {

        private FgFileUpload instance = new FgFileUpload();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder fgClientCode(String fgClientCode) {
            instance.setFgClientCode(fgClientCode);
            return this;
        }

        public Builder fgFiller1(String fgFiller1) {
            instance.setFgFiller1(fgFiller1);
            return this;
        }

        public Builder fgFiller2(String fgFiller2) {
            instance.setFgFiller2(fgFiller2);
            return this;
        }

        public Builder fgFiller3(String fgFiller3) {
            instance.setFgFiller3(fgFiller3);
            return this;
        }

        public Builder fgFileNameHdr(String fgFileNameHdr) {
            instance.setFgFileNameHdr(fgFileNameHdr);
            return this;
        }

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            instance.setLayoutTemplateID(layoutTemplateID);
            return this;
        }

        public Builder dmsEventID(Integer dmsEventID) {
            instance.setDmsEventID(dmsEventID);
            return this;
        }

        public Builder totalCount(java.math.BigDecimal totalCount) {
            instance.setTotalCount(totalCount);
            return this;
        }

        public Builder successCount(String successCount) {
            instance.setSuccessCount(successCount);
            return this;
        }

        public Builder errorCount(String errorCount) {
            instance.setErrorCount(errorCount);
            return this;
        }

        public Builder totalAmount(java.math.BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder totalSuccessAmount(java.math.BigDecimal totalSuccessAmount) {
            instance.setTotalSuccessAmount(totalSuccessAmount);
            return this;
        }

        public Builder totalFailedAmount(java.math.BigDecimal totalFailedAmount) {
            instance.setTotalFailedAmount(totalFailedAmount);
            return this;
        }

        public Builder financeTypeCode(String financeTypeCode) {
            instance.setFinanceTypeCode(financeTypeCode);
            return this;
        }

        public Builder financeDisplayStatus(String financeDisplayStatus) {
            instance.setFinanceDisplayStatus(financeDisplayStatus);
            return this;
        }

        public Builder programName(String programName) {
            instance.setProgramName(programName);
            return this;
        }

        public Builder programCode(String programCode) {
            instance.setProgramCode(programCode);
            return this;
        }

        public Builder partyRoleCode(String partyRoleCode) {
            instance.setPartyRoleCode(partyRoleCode);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder fileStatus(String fileStatus) {
            instance.setFileStatus(fileStatus);
            return this;
        }

        public Builder taskReasonCode(String taskReasonCode) {
            instance.setTaskReasonCode(taskReasonCode);
            return this;
        }

        public Builder taskReasonText(String taskReasonText) {
            instance.setTaskReasonText(taskReasonText);
            return this;
        }

        public Builder warningCount(java.math.BigDecimal warningCount) {
            instance.setWarningCount(warningCount);
            return this;
        }

        public Builder layoutName(String layoutName) {
            instance.setLayoutName(layoutName);
            return this;
        }

        public Builder layoutTemplateVersionID(Integer layoutTemplateVersionID) {
            instance.setLayoutTemplateVersionID(layoutTemplateVersionID);
            return this;
        }

        public Builder authLevelCode(String authLevelCode) {
            instance.setAuthLevelCode(authLevelCode);
            return this;
        }

        public Builder applicantRefID(Integer applicantRefID) {
            instance.setApplicantRefID(applicantRefID);
            return this;
        }

        public Builder issuingPartyCode(String issuingPartyCode) {
            instance.setIssuingPartyCode(issuingPartyCode);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            instance.setDisplayStatus(displayStatus);
            return this;
        }

        public Builder fgSourceCode(String fgSourceCode) {
            instance.setFgSourceCode(fgSourceCode);
            return this;
        }

        public Builder ftTotalNoOfInstructions(java.math.BigDecimal ftTotalNoOfInstructions) {
            instance.setFtTotalNoOfInstructions(ftTotalNoOfInstructions);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder fgBatchRefNumber(String fgBatchRefNumber) {
            instance.setFgBatchRefNumber(fgBatchRefNumber);
            return this;
        }

        public Builder fgProductCode(String fgProductCode) {
            instance.setFgProductCode(fgProductCode);
            return this;
        }

        public Builder categorySubType(String categorySubType) {
            instance.setCategorySubType(categorySubType);
            return this;
        }

        public Builder fgInstructionsCount(java.math.BigDecimal fgInstructionsCount) {
            instance.setFgInstructionsCount(fgInstructionsCount);
            return this;
        }

        public Builder fgTotalAmount(java.math.BigDecimal fgTotalAmount) {
            instance.setFgTotalAmount(fgTotalAmount);
            return this;
        }

        public Builder fgTotalInstruments(java.math.BigDecimal fgTotalInstruments) {
            instance.setFgTotalInstruments(fgTotalInstruments);
            return this;
        }

        public Builder ftTotalInstruments(java.math.BigDecimal ftTotalInstruments) {
            instance.setFtTotalInstruments(ftTotalInstruments);
            return this;
        }

        public Builder ftTotalAmount(java.math.BigDecimal ftTotalAmount) {
            instance.setFtTotalAmount(ftTotalAmount);
            return this;
        }

        public Builder fgBatchDate(java.time.LocalDateTime fgBatchDate) {
            instance.setFgBatchDate(fgBatchDate);
            return this;
        }

        public Builder fgPaymentDate(java.time.LocalDateTime fgPaymentDate) {
            instance.setFgPaymentDate(fgPaymentDate);
            return this;
        }

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder entity(String entity) {
            instance.setEntity(entity);
            return this;
        }

        public Builder issuersRef(String issuersRef) {
            instance.setIssuersRef(issuersRef);
            return this;
        }

        public Builder equCcy(String equCcy) {
            instance.setEquCcy(equCcy);
            return this;
        }

        public Builder equAmount(java.math.BigDecimal equAmount) {
            instance.setEquAmount(equAmount);
            return this;
        }

        public Builder blanketAmount(java.math.BigDecimal blanketAmount) {
            instance.setBlanketAmount(blanketAmount);
            return this;
        }

        public Builder terms(Integer terms) {
            instance.setTerms(terms);
            return this;
        }

        public Builder authEquCcy(String authEquCcy) {
            instance.setAuthEquCcy(authEquCcy);
            return this;
        }

        public Builder authEquAmount(java.math.BigDecimal authEquAmount) {
            instance.setAuthEquAmount(authEquAmount);
            return this;
        }

        public Builder authBlanketAmount(java.math.BigDecimal authBlanketAmount) {
            instance.setAuthBlanketAmount(authBlanketAmount);
            return this;
        }

        public Builder displayEquCcy(String displayEquCcy) {
            instance.setDisplayEquCcy(displayEquCcy);
            return this;
        }

        public Builder displayEquAmount(java.math.BigDecimal displayEquAmount) {
            instance.setDisplayEquAmount(displayEquAmount);
            return this;
        }

        public Builder displayBlanketAmount(java.math.BigDecimal displayBlanketAmount) {
            instance.setDisplayBlanketAmount(displayBlanketAmount);
            return this;
        }

        public Builder authFxBaseRate(java.math.BigDecimal authFxBaseRate) {
            instance.setAuthFxBaseRate(authFxBaseRate);
            return this;
        }

        public Builder displayFxBaseRate(java.math.BigDecimal displayFxBaseRate) {
            instance.setDisplayFxBaseRate(displayFxBaseRate);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder optDeclare(Integer optDeclare) {
            instance.setOptDeclare(optDeclare);
            return this;
        }

        public Builder fileSource(String fileSource) {
            instance.setFileSource(fileSource);
            return this;
        }

        public Builder streetName(String streetName) {
            instance.setStreetName(streetName);
            return this;
        }

        public Builder townName(String townName) {
            instance.setTownName(townName);
            return this;
        }

        public Builder countrySubDiv(String countrySubDiv) {
            instance.setCountrySubDiv(countrySubDiv);
            return this;
        }

        public Builder bankAbbvName(String bankAbbvName) {
            instance.setBankAbbvName(bankAbbvName);
            return this;
        }

        public Builder optionalDeclaration(Integer optionalDeclaration) {
            instance.setOptionalDeclaration(optionalDeclaration);
            return this;
        }

        public FgFileUpload build() {
            return instance;
        }
    }
}
