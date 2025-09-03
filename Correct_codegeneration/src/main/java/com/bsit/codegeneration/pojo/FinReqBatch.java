package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinReqBatch {

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

    private String partyType;

    private String customerCrn;

    private String programLayout;

    private String layoutName;

    private java.time.LocalDateTime batchValueDate;

    private Integer loanRefID;

    private java.time.LocalDateTime loanDueDate;

    private java.math.BigDecimal requestAmount;

    private String ccy;

    private String returnText;

    private java.math.BigDecimal batchAmount;

    private String limitNodeReference;

    private java.math.BigDecimal snapshotLimit;

    private String taskReason;

    private String productType;

    private java.math.BigDecimal financeAmount;

    private java.math.BigDecimal financingAmount;

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

    private java.math.BigDecimal totalCount;

    private String entityTypeCode;

    private String entitySubTypeCode;

    private Integer versionID;

    private Integer isMasterVersion;

    private Integer layoutID;

    private String customerRole;

    private String cpCode;

    private String batchAction;

    private Integer uploadRefID;

    private String ownerParty;

    private String applicantName;

    private String fileName;

    private String financeParty;

    private String cpName;

    private String anchorName;

    public FinReqBatch() {
    }

    public FinReqBatch(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String partyType, String customerCrn, String programLayout, String layoutName, java.time.LocalDateTime batchValueDate, Integer loanRefID, java.time.LocalDateTime loanDueDate, java.math.BigDecimal requestAmount, String ccy, String returnText, java.math.BigDecimal batchAmount, String limitNodeReference, java.math.BigDecimal snapshotLimit, String taskReason, String productType, java.math.BigDecimal financeAmount, java.math.BigDecimal financingAmount, Long tenorInDays, Long intPeriodInDays, Long contractPeriod, String tnxDisplayRemarks, String tnxDisplayStatus, java.time.LocalDateTime maturityDate, String limitNodeReference2, String batchDisplayStatus, String batchDisplayRemarks, String requestInitiationType, String loanRequestType, String layoutUuid, String batchStatus, String productStatus, java.math.BigDecimal totalCount, String entityTypeCode, String entitySubTypeCode, Integer versionID, Integer isMasterVersion, Integer layoutID, String customerRole, String cpCode, String batchAction, Integer uploadRefID, String ownerParty, String applicantName, String fileName, String financeParty, String cpName, String anchorName) {
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
        this.partyType = partyType;
        this.customerCrn = customerCrn;
        this.programLayout = programLayout;
        this.layoutName = layoutName;
        this.batchValueDate = batchValueDate;
        this.loanRefID = loanRefID;
        this.loanDueDate = loanDueDate;
        this.requestAmount = requestAmount;
        this.ccy = ccy;
        this.returnText = returnText;
        this.batchAmount = batchAmount;
        this.limitNodeReference = limitNodeReference;
        this.snapshotLimit = snapshotLimit;
        this.taskReason = taskReason;
        this.productType = productType;
        this.financeAmount = financeAmount;
        this.financingAmount = financingAmount;
        this.tenorInDays = tenorInDays;
        this.intPeriodInDays = intPeriodInDays;
        this.contractPeriod = contractPeriod;
        this.tnxDisplayRemarks = tnxDisplayRemarks;
        this.tnxDisplayStatus = tnxDisplayStatus;
        this.maturityDate = maturityDate;
        this.limitNodeReference2 = limitNodeReference2;
        this.batchDisplayStatus = batchDisplayStatus;
        this.batchDisplayRemarks = batchDisplayRemarks;
        this.requestInitiationType = requestInitiationType;
        this.loanRequestType = loanRequestType;
        this.layoutUuid = layoutUuid;
        this.batchStatus = batchStatus;
        this.productStatus = productStatus;
        this.totalCount = totalCount;
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.layoutID = layoutID;
        this.customerRole = customerRole;
        this.cpCode = cpCode;
        this.batchAction = batchAction;
        this.uploadRefID = uploadRefID;
        this.ownerParty = ownerParty;
        this.applicantName = applicantName;
        this.fileName = fileName;
        this.financeParty = financeParty;
        this.cpName = cpName;
        this.anchorName = anchorName;
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

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getCustomerCrn() {
        return customerCrn;
    }

    public void setCustomerCrn(String customerCrn) {
        this.customerCrn = customerCrn;
    }

    public String getProgramLayout() {
        return programLayout;
    }

    public void setProgramLayout(String programLayout) {
        this.programLayout = programLayout;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public java.time.LocalDateTime getBatchValueDate() {
        return batchValueDate;
    }

    public void setBatchValueDate(java.time.LocalDateTime batchValueDate) {
        this.batchValueDate = batchValueDate;
    }

    public Integer getLoanRefID() {
        return loanRefID;
    }

    public void setLoanRefID(Integer loanRefID) {
        this.loanRefID = loanRefID;
    }

    public java.time.LocalDateTime getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(java.time.LocalDateTime loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    public java.math.BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(java.math.BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getReturnText() {
        return returnText;
    }

    public void setReturnText(String returnText) {
        this.returnText = returnText;
    }

    public java.math.BigDecimal getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(java.math.BigDecimal batchAmount) {
        this.batchAmount = batchAmount;
    }

    public String getLimitNodeReference() {
        return limitNodeReference;
    }

    public void setLimitNodeReference(String limitNodeReference) {
        this.limitNodeReference = limitNodeReference;
    }

    public java.math.BigDecimal getSnapshotLimit() {
        return snapshotLimit;
    }

    public void setSnapshotLimit(java.math.BigDecimal snapshotLimit) {
        this.snapshotLimit = snapshotLimit;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public java.math.BigDecimal getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(java.math.BigDecimal financeAmount) {
        this.financeAmount = financeAmount;
    }

    public java.math.BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(java.math.BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
    }

    public Long getTenorInDays() {
        return tenorInDays;
    }

    public void setTenorInDays(Long tenorInDays) {
        this.tenorInDays = tenorInDays;
    }

    public Long getIntPeriodInDays() {
        return intPeriodInDays;
    }

    public void setIntPeriodInDays(Long intPeriodInDays) {
        this.intPeriodInDays = intPeriodInDays;
    }

    public Long getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Long contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getTnxDisplayRemarks() {
        return tnxDisplayRemarks;
    }

    public void setTnxDisplayRemarks(String tnxDisplayRemarks) {
        this.tnxDisplayRemarks = tnxDisplayRemarks;
    }

    public String getTnxDisplayStatus() {
        return tnxDisplayStatus;
    }

    public void setTnxDisplayStatus(String tnxDisplayStatus) {
        this.tnxDisplayStatus = tnxDisplayStatus;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getLimitNodeReference2() {
        return limitNodeReference2;
    }

    public void setLimitNodeReference2(String limitNodeReference2) {
        this.limitNodeReference2 = limitNodeReference2;
    }

    public String getBatchDisplayStatus() {
        return batchDisplayStatus;
    }

    public void setBatchDisplayStatus(String batchDisplayStatus) {
        this.batchDisplayStatus = batchDisplayStatus;
    }

    public String getBatchDisplayRemarks() {
        return batchDisplayRemarks;
    }

    public void setBatchDisplayRemarks(String batchDisplayRemarks) {
        this.batchDisplayRemarks = batchDisplayRemarks;
    }

    public String getRequestInitiationType() {
        return requestInitiationType;
    }

    public void setRequestInitiationType(String requestInitiationType) {
        this.requestInitiationType = requestInitiationType;
    }

    public String getLoanRequestType() {
        return loanRequestType;
    }

    public void setLoanRequestType(String loanRequestType) {
        this.loanRequestType = loanRequestType;
    }

    public String getLayoutUuid() {
        return layoutUuid;
    }

    public void setLayoutUuid(String layoutUuid) {
        this.layoutUuid = layoutUuid;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public java.math.BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(java.math.BigDecimal totalCount) {
        this.totalCount = totalCount;
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

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(Integer layoutID) {
        this.layoutID = layoutID;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getBatchAction() {
        return batchAction;
    }

    public void setBatchAction(String batchAction) {
        this.batchAction = batchAction;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getOwnerParty() {
        return ownerParty;
    }

    public void setOwnerParty(String ownerParty) {
        this.ownerParty = ownerParty;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFinanceParty() {
        return financeParty;
    }

    public void setFinanceParty(String financeParty) {
        this.financeParty = financeParty;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public static class Builder {

        private FinReqBatch instance = new FinReqBatch();

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

        public Builder partyType(String partyType) {
            instance.setPartyType(partyType);
            return this;
        }

        public Builder customerCrn(String customerCrn) {
            instance.setCustomerCrn(customerCrn);
            return this;
        }

        public Builder programLayout(String programLayout) {
            instance.setProgramLayout(programLayout);
            return this;
        }

        public Builder layoutName(String layoutName) {
            instance.setLayoutName(layoutName);
            return this;
        }

        public Builder batchValueDate(java.time.LocalDateTime batchValueDate) {
            instance.setBatchValueDate(batchValueDate);
            return this;
        }

        public Builder loanRefID(Integer loanRefID) {
            instance.setLoanRefID(loanRefID);
            return this;
        }

        public Builder loanDueDate(java.time.LocalDateTime loanDueDate) {
            instance.setLoanDueDate(loanDueDate);
            return this;
        }

        public Builder requestAmount(java.math.BigDecimal requestAmount) {
            instance.setRequestAmount(requestAmount);
            return this;
        }

        public Builder ccy(String ccy) {
            instance.setCcy(ccy);
            return this;
        }

        public Builder returnText(String returnText) {
            instance.setReturnText(returnText);
            return this;
        }

        public Builder batchAmount(java.math.BigDecimal batchAmount) {
            instance.setBatchAmount(batchAmount);
            return this;
        }

        public Builder limitNodeReference(String limitNodeReference) {
            instance.setLimitNodeReference(limitNodeReference);
            return this;
        }

        public Builder snapshotLimit(java.math.BigDecimal snapshotLimit) {
            instance.setSnapshotLimit(snapshotLimit);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public Builder financeAmount(java.math.BigDecimal financeAmount) {
            instance.setFinanceAmount(financeAmount);
            return this;
        }

        public Builder financingAmount(java.math.BigDecimal financingAmount) {
            instance.setFinancingAmount(financingAmount);
            return this;
        }

        public Builder tenorInDays(Long tenorInDays) {
            instance.setTenorInDays(tenorInDays);
            return this;
        }

        public Builder intPeriodInDays(Long intPeriodInDays) {
            instance.setIntPeriodInDays(intPeriodInDays);
            return this;
        }

        public Builder contractPeriod(Long contractPeriod) {
            instance.setContractPeriod(contractPeriod);
            return this;
        }

        public Builder tnxDisplayRemarks(String tnxDisplayRemarks) {
            instance.setTnxDisplayRemarks(tnxDisplayRemarks);
            return this;
        }

        public Builder tnxDisplayStatus(String tnxDisplayStatus) {
            instance.setTnxDisplayStatus(tnxDisplayStatus);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder limitNodeReference2(String limitNodeReference2) {
            instance.setLimitNodeReference2(limitNodeReference2);
            return this;
        }

        public Builder batchDisplayStatus(String batchDisplayStatus) {
            instance.setBatchDisplayStatus(batchDisplayStatus);
            return this;
        }

        public Builder batchDisplayRemarks(String batchDisplayRemarks) {
            instance.setBatchDisplayRemarks(batchDisplayRemarks);
            return this;
        }

        public Builder requestInitiationType(String requestInitiationType) {
            instance.setRequestInitiationType(requestInitiationType);
            return this;
        }

        public Builder loanRequestType(String loanRequestType) {
            instance.setLoanRequestType(loanRequestType);
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            instance.setLayoutUuid(layoutUuid);
            return this;
        }

        public Builder batchStatus(String batchStatus) {
            instance.setBatchStatus(batchStatus);
            return this;
        }

        public Builder productStatus(String productStatus) {
            instance.setProductStatus(productStatus);
            return this;
        }

        public Builder totalCount(java.math.BigDecimal totalCount) {
            instance.setTotalCount(totalCount);
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

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder layoutID(Integer layoutID) {
            instance.setLayoutID(layoutID);
            return this;
        }

        public Builder customerRole(String customerRole) {
            instance.setCustomerRole(customerRole);
            return this;
        }

        public Builder cpCode(String cpCode) {
            instance.setCpCode(cpCode);
            return this;
        }

        public Builder batchAction(String batchAction) {
            instance.setBatchAction(batchAction);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder ownerParty(String ownerParty) {
            instance.setOwnerParty(ownerParty);
            return this;
        }

        public Builder applicantName(String applicantName) {
            instance.setApplicantName(applicantName);
            return this;
        }

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder financeParty(String financeParty) {
            instance.setFinanceParty(financeParty);
            return this;
        }

        public Builder cpName(String cpName) {
            instance.setCpName(cpName);
            return this;
        }

        public Builder anchorName(String anchorName) {
            instance.setAnchorName(anchorName);
            return this;
        }

        public FinReqBatch build() {
            return instance;
        }
    }
}
