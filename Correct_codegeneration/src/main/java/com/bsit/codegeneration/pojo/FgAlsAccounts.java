package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgAlsAccounts {

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

    private String accountNumber;

    private String productCode;

    private String logicOfSettlement;

    private Long maxSettlementPercentage;

    private java.math.BigDecimal maxSettlementAmount;

    private String repaymentAction;

    private Integer parentRefID;

    private Integer parentVersionID;

    private Integer processID;

    private Integer isMasterVersion;

    private Integer versionID;

    public FgAlsAccounts() {
    }

    public FgAlsAccounts(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String accountNumber, String productCode, String logicOfSettlement, Long maxSettlementPercentage, java.math.BigDecimal maxSettlementAmount, String repaymentAction, Integer parentRefID, Integer parentVersionID, Integer processID, Integer isMasterVersion, Integer versionID) {
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
        this.accountNumber = accountNumber;
        this.productCode = productCode;
        this.logicOfSettlement = logicOfSettlement;
        this.maxSettlementPercentage = maxSettlementPercentage;
        this.maxSettlementAmount = maxSettlementAmount;
        this.repaymentAction = repaymentAction;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.processID = processID;
        this.isMasterVersion = isMasterVersion;
        this.versionID = versionID;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getLogicOfSettlement() {
        return logicOfSettlement;
    }

    public void setLogicOfSettlement(String logicOfSettlement) {
        this.logicOfSettlement = logicOfSettlement;
    }

    public Long getMaxSettlementPercentage() {
        return maxSettlementPercentage;
    }

    public void setMaxSettlementPercentage(Long maxSettlementPercentage) {
        this.maxSettlementPercentage = maxSettlementPercentage;
    }

    public java.math.BigDecimal getMaxSettlementAmount() {
        return maxSettlementAmount;
    }

    public void setMaxSettlementAmount(java.math.BigDecimal maxSettlementAmount) {
        this.maxSettlementAmount = maxSettlementAmount;
    }

    public String getRepaymentAction() {
        return repaymentAction;
    }

    public void setRepaymentAction(String repaymentAction) {
        this.repaymentAction = repaymentAction;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public static class Builder {

        private FgAlsAccounts instance = new FgAlsAccounts();

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

        public Builder accountNumber(String accountNumber) {
            instance.setAccountNumber(accountNumber);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder logicOfSettlement(String logicOfSettlement) {
            instance.setLogicOfSettlement(logicOfSettlement);
            return this;
        }

        public Builder maxSettlementPercentage(Long maxSettlementPercentage) {
            instance.setMaxSettlementPercentage(maxSettlementPercentage);
            return this;
        }

        public Builder maxSettlementAmount(java.math.BigDecimal maxSettlementAmount) {
            instance.setMaxSettlementAmount(maxSettlementAmount);
            return this;
        }

        public Builder repaymentAction(String repaymentAction) {
            instance.setRepaymentAction(repaymentAction);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public FgAlsAccounts build() {
            return instance;
        }
    }
}
