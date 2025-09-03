package com.bsit.codegeneration.record;

import java.util.List;

public record FgFinanceMaster(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String fileContent, String retriggerCount, Integer uploadRefID, String financeFileName, String applicantPartyCode, String sendFinanceFile, String isFinanceSent, String fileName, String remarks, String cutoffTime, Integer batchRefID, String batchAction) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private Integer processID;

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

        private String fileContent;

        private String retriggerCount;

        private Integer uploadRefID;

        private String financeFileName;

        private String applicantPartyCode;

        private String sendFinanceFile;

        private String isFinanceSent;

        private String fileName;

        private String remarks;

        private String cutoffTime;

        private Integer batchRefID;

        private String batchAction;

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

        public Builder processID(Integer processID) {
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

        public Builder fileContent(String fileContent) {
            this.fileContent = fileContent;
            return this;
        }

        public Builder retriggerCount(String retriggerCount) {
            this.retriggerCount = retriggerCount;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder financeFileName(String financeFileName) {
            this.financeFileName = financeFileName;
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
            return this;
        }

        public Builder sendFinanceFile(String sendFinanceFile) {
            this.sendFinanceFile = sendFinanceFile;
            return this;
        }

        public Builder isFinanceSent(String isFinanceSent) {
            this.isFinanceSent = isFinanceSent;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder cutoffTime(String cutoffTime) {
            this.cutoffTime = cutoffTime;
            return this;
        }

        public Builder batchRefID(Integer batchRefID) {
            this.batchRefID = batchRefID;
            return this;
        }

        public Builder batchAction(String batchAction) {
            this.batchAction = batchAction;
            return this;
        }

        public FgFinanceMaster build() {
            return new FgFinanceMaster(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, fileContent, retriggerCount, uploadRefID, financeFileName, applicantPartyCode, sendFinanceFile, isFinanceSent, fileName, remarks, cutoffTime, batchRefID, batchAction);
        }
    }
}
