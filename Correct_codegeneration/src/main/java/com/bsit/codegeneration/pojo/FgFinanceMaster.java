package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgFinanceMaster {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private String applicantParty;

    private String fulfillmentParty;

    private Integer isTemplate;

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

    public FgFinanceMaster() {
    }

    public FgFinanceMaster(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String fileContent, String retriggerCount, Integer uploadRefID, String financeFileName, String applicantPartyCode, String sendFinanceFile, String isFinanceSent, String fileName, String remarks, String cutoffTime, Integer batchRefID, String batchAction) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
        this.isTemplate = isTemplate;
        this.fileContent = fileContent;
        this.retriggerCount = retriggerCount;
        this.uploadRefID = uploadRefID;
        this.financeFileName = financeFileName;
        this.applicantPartyCode = applicantPartyCode;
        this.sendFinanceFile = sendFinanceFile;
        this.isFinanceSent = isFinanceSent;
        this.fileName = fileName;
        this.remarks = remarks;
        this.cutoffTime = cutoffTime;
        this.batchRefID = batchRefID;
        this.batchAction = batchAction;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
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

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getRetriggerCount() {
        return retriggerCount;
    }

    public void setRetriggerCount(String retriggerCount) {
        this.retriggerCount = retriggerCount;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getFinanceFileName() {
        return financeFileName;
    }

    public void setFinanceFileName(String financeFileName) {
        this.financeFileName = financeFileName;
    }

    public String getApplicantPartyCode() {
        return applicantPartyCode;
    }

    public void setApplicantPartyCode(String applicantPartyCode) {
        this.applicantPartyCode = applicantPartyCode;
    }

    public String getSendFinanceFile() {
        return sendFinanceFile;
    }

    public void setSendFinanceFile(String sendFinanceFile) {
        this.sendFinanceFile = sendFinanceFile;
    }

    public String getIsFinanceSent() {
        return isFinanceSent;
    }

    public void setIsFinanceSent(String isFinanceSent) {
        this.isFinanceSent = isFinanceSent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(String cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public Integer getBatchRefID() {
        return batchRefID;
    }

    public void setBatchRefID(Integer batchRefID) {
        this.batchRefID = batchRefID;
    }

    public String getBatchAction() {
        return batchAction;
    }

    public void setBatchAction(String batchAction) {
        this.batchAction = batchAction;
    }

    public static class Builder {

        private FgFinanceMaster instance = new FgFinanceMaster();

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

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
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

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder fileContent(String fileContent) {
            instance.setFileContent(fileContent);
            return this;
        }

        public Builder retriggerCount(String retriggerCount) {
            instance.setRetriggerCount(retriggerCount);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder financeFileName(String financeFileName) {
            instance.setFinanceFileName(financeFileName);
            return this;
        }

        public Builder applicantPartyCode(String applicantPartyCode) {
            instance.setApplicantPartyCode(applicantPartyCode);
            return this;
        }

        public Builder sendFinanceFile(String sendFinanceFile) {
            instance.setSendFinanceFile(sendFinanceFile);
            return this;
        }

        public Builder isFinanceSent(String isFinanceSent) {
            instance.setIsFinanceSent(isFinanceSent);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder cutoffTime(String cutoffTime) {
            instance.setCutoffTime(cutoffTime);
            return this;
        }

        public Builder batchRefID(Integer batchRefID) {
            instance.setBatchRefID(batchRefID);
            return this;
        }

        public Builder batchAction(String batchAction) {
            instance.setBatchAction(batchAction);
            return this;
        }

        public FgFinanceMaster build() {
            return instance;
        }
    }
}
