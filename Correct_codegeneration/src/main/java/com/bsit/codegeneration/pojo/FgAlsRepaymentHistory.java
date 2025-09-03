package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgAlsRepaymentHistory {

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

    private String customerCrn;

    private String settlementAmt;

    private String accountNo;

    private Long weight;

    private String status;

    private java.time.LocalDateTime maturityDate;

    private java.time.LocalDateTime disbDate;

    private String overdueYN;

    private String masterRef;

    private String logicOfSettlement;

    private java.math.BigDecimal availableBalance;

    private java.math.BigDecimal totalBalance;

    private java.math.BigDecimal totalRepaymentAmount;

    private java.math.BigDecimal principleRepaymentAmount;

    private java.math.BigDecimal interestRepaymentAmount;

    private java.math.BigDecimal accountBalance;

    private String customerName;

    public FgAlsRepaymentHistory() {
    }

    public FgAlsRepaymentHistory(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String customerCrn, String settlementAmt, String accountNo, Long weight, String status, java.time.LocalDateTime maturityDate, java.time.LocalDateTime disbDate, String overdueYN, String masterRef, String logicOfSettlement, java.math.BigDecimal availableBalance, java.math.BigDecimal totalBalance, java.math.BigDecimal totalRepaymentAmount, java.math.BigDecimal principleRepaymentAmount, java.math.BigDecimal interestRepaymentAmount, java.math.BigDecimal accountBalance, String customerName) {
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
        this.customerCrn = customerCrn;
        this.settlementAmt = settlementAmt;
        this.accountNo = accountNo;
        this.weight = weight;
        this.status = status;
        this.maturityDate = maturityDate;
        this.disbDate = disbDate;
        this.overdueYN = overdueYN;
        this.masterRef = masterRef;
        this.logicOfSettlement = logicOfSettlement;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
        this.totalRepaymentAmount = totalRepaymentAmount;
        this.principleRepaymentAmount = principleRepaymentAmount;
        this.interestRepaymentAmount = interestRepaymentAmount;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
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

    public String getCustomerCrn() {
        return customerCrn;
    }

    public void setCustomerCrn(String customerCrn) {
        this.customerCrn = customerCrn;
    }

    public String getSettlementAmt() {
        return settlementAmt;
    }

    public void setSettlementAmt(String settlementAmt) {
        this.settlementAmt = settlementAmt;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.time.LocalDateTime getDisbDate() {
        return disbDate;
    }

    public void setDisbDate(java.time.LocalDateTime disbDate) {
        this.disbDate = disbDate;
    }

    public String getOverdueYN() {
        return overdueYN;
    }

    public void setOverdueYN(String overdueYN) {
        this.overdueYN = overdueYN;
    }

    public String getMasterRef() {
        return masterRef;
    }

    public void setMasterRef(String masterRef) {
        this.masterRef = masterRef;
    }

    public String getLogicOfSettlement() {
        return logicOfSettlement;
    }

    public void setLogicOfSettlement(String logicOfSettlement) {
        this.logicOfSettlement = logicOfSettlement;
    }

    public java.math.BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(java.math.BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public java.math.BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(java.math.BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public java.math.BigDecimal getTotalRepaymentAmount() {
        return totalRepaymentAmount;
    }

    public void setTotalRepaymentAmount(java.math.BigDecimal totalRepaymentAmount) {
        this.totalRepaymentAmount = totalRepaymentAmount;
    }

    public java.math.BigDecimal getPrincipleRepaymentAmount() {
        return principleRepaymentAmount;
    }

    public void setPrincipleRepaymentAmount(java.math.BigDecimal principleRepaymentAmount) {
        this.principleRepaymentAmount = principleRepaymentAmount;
    }

    public java.math.BigDecimal getInterestRepaymentAmount() {
        return interestRepaymentAmount;
    }

    public void setInterestRepaymentAmount(java.math.BigDecimal interestRepaymentAmount) {
        this.interestRepaymentAmount = interestRepaymentAmount;
    }

    public java.math.BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(java.math.BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public static class Builder {

        private FgAlsRepaymentHistory instance = new FgAlsRepaymentHistory();

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

        public Builder customerCrn(String customerCrn) {
            instance.setCustomerCrn(customerCrn);
            return this;
        }

        public Builder settlementAmt(String settlementAmt) {
            instance.setSettlementAmt(settlementAmt);
            return this;
        }

        public Builder accountNo(String accountNo) {
            instance.setAccountNo(accountNo);
            return this;
        }

        public Builder weight(Long weight) {
            instance.setWeight(weight);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder disbDate(java.time.LocalDateTime disbDate) {
            instance.setDisbDate(disbDate);
            return this;
        }

        public Builder overdueYN(String overdueYN) {
            instance.setOverdueYN(overdueYN);
            return this;
        }

        public Builder masterRef(String masterRef) {
            instance.setMasterRef(masterRef);
            return this;
        }

        public Builder logicOfSettlement(String logicOfSettlement) {
            instance.setLogicOfSettlement(logicOfSettlement);
            return this;
        }

        public Builder availableBalance(java.math.BigDecimal availableBalance) {
            instance.setAvailableBalance(availableBalance);
            return this;
        }

        public Builder totalBalance(java.math.BigDecimal totalBalance) {
            instance.setTotalBalance(totalBalance);
            return this;
        }

        public Builder totalRepaymentAmount(java.math.BigDecimal totalRepaymentAmount) {
            instance.setTotalRepaymentAmount(totalRepaymentAmount);
            return this;
        }

        public Builder principleRepaymentAmount(java.math.BigDecimal principleRepaymentAmount) {
            instance.setPrincipleRepaymentAmount(principleRepaymentAmount);
            return this;
        }

        public Builder interestRepaymentAmount(java.math.BigDecimal interestRepaymentAmount) {
            instance.setInterestRepaymentAmount(interestRepaymentAmount);
            return this;
        }

        public Builder accountBalance(java.math.BigDecimal accountBalance) {
            instance.setAccountBalance(accountBalance);
            return this;
        }

        public Builder customerName(String customerName) {
            instance.setCustomerName(customerName);
            return this;
        }

        public FgAlsRepaymentHistory build() {
            return instance;
        }
    }
}
