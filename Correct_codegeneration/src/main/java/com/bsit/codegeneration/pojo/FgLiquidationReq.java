package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgLiquidationReq {

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

    private String tdAccount;

    private String accountName;

    private java.math.BigDecimal principalAmount;

    private java.math.BigDecimal liqInterestRate;

    private java.math.BigDecimal currentBalance;

    private String startDate;

    private String liqMaturityDate;

    private java.math.BigDecimal maturityAmount;

    private String interestAccount;

    private String principalAccount;

    private String liquidType;

    private java.math.BigDecimal liqWithdrawnAmount;

    private String remarks;

    private Integer terms;

    private java.math.BigDecimal availableBalance;

    private String liqDebitAccNo;

    private String liqDepositAccNo;

    private java.math.BigDecimal liqDepositAmount;

    private Integer lienMarked;

    private String nameOfAcc;

    private java.math.BigDecimal lienAmount;

    private String transferTo;

    private String taskReason;

    private String schemeCode;

    private String userType;

    private java.math.BigDecimal maxBookingLimit;

    private Long otpCount;

    private Long otpResent;

    private String otpSentTime;

    private String otpLockedTime;

    private String otpUnlockTime;

    private Long otpFailedCount;

    private java.math.BigDecimal utilizedBookingLimit;

    private java.math.BigDecimal availableBookingLimit;

    private java.math.BigDecimal pendingUtilisedLimit;

    private String productStatus;

    private String finacleStatus;

    private String finacleErrorCode;

    private String finacleErrorDesc;

    private java.math.BigDecimal liqWithdrawalInterest;

    private String origin;

    public FgLiquidationReq() {
    }

    public FgLiquidationReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String tdAccount, String accountName, java.math.BigDecimal principalAmount, java.math.BigDecimal liqInterestRate, java.math.BigDecimal currentBalance, String startDate, String liqMaturityDate, java.math.BigDecimal maturityAmount, String interestAccount, String principalAccount, String liquidType, java.math.BigDecimal liqWithdrawnAmount, String remarks, Integer terms, java.math.BigDecimal availableBalance, String liqDebitAccNo, String liqDepositAccNo, java.math.BigDecimal liqDepositAmount, Integer lienMarked, String nameOfAcc, java.math.BigDecimal lienAmount, String transferTo, String taskReason, String schemeCode, String userType, java.math.BigDecimal maxBookingLimit, Long otpCount, Long otpResent, String otpSentTime, String otpLockedTime, String otpUnlockTime, Long otpFailedCount, java.math.BigDecimal utilizedBookingLimit, java.math.BigDecimal availableBookingLimit, java.math.BigDecimal pendingUtilisedLimit, String productStatus, String finacleStatus, String finacleErrorCode, String finacleErrorDesc, java.math.BigDecimal liqWithdrawalInterest, String origin) {
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
        this.tdAccount = tdAccount;
        this.accountName = accountName;
        this.principalAmount = principalAmount;
        this.liqInterestRate = liqInterestRate;
        this.currentBalance = currentBalance;
        this.startDate = startDate;
        this.liqMaturityDate = liqMaturityDate;
        this.maturityAmount = maturityAmount;
        this.interestAccount = interestAccount;
        this.principalAccount = principalAccount;
        this.liquidType = liquidType;
        this.liqWithdrawnAmount = liqWithdrawnAmount;
        this.remarks = remarks;
        this.terms = terms;
        this.availableBalance = availableBalance;
        this.liqDebitAccNo = liqDebitAccNo;
        this.liqDepositAccNo = liqDepositAccNo;
        this.liqDepositAmount = liqDepositAmount;
        this.lienMarked = lienMarked;
        this.nameOfAcc = nameOfAcc;
        this.lienAmount = lienAmount;
        this.transferTo = transferTo;
        this.taskReason = taskReason;
        this.schemeCode = schemeCode;
        this.userType = userType;
        this.maxBookingLimit = maxBookingLimit;
        this.otpCount = otpCount;
        this.otpResent = otpResent;
        this.otpSentTime = otpSentTime;
        this.otpLockedTime = otpLockedTime;
        this.otpUnlockTime = otpUnlockTime;
        this.otpFailedCount = otpFailedCount;
        this.utilizedBookingLimit = utilizedBookingLimit;
        this.availableBookingLimit = availableBookingLimit;
        this.pendingUtilisedLimit = pendingUtilisedLimit;
        this.productStatus = productStatus;
        this.finacleStatus = finacleStatus;
        this.finacleErrorCode = finacleErrorCode;
        this.finacleErrorDesc = finacleErrorDesc;
        this.liqWithdrawalInterest = liqWithdrawalInterest;
        this.origin = origin;
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

    public String getTdAccount() {
        return tdAccount;
    }

    public void setTdAccount(String tdAccount) {
        this.tdAccount = tdAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public java.math.BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(java.math.BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public java.math.BigDecimal getLiqInterestRate() {
        return liqInterestRate;
    }

    public void setLiqInterestRate(java.math.BigDecimal liqInterestRate) {
        this.liqInterestRate = liqInterestRate;
    }

    public java.math.BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(java.math.BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLiqMaturityDate() {
        return liqMaturityDate;
    }

    public void setLiqMaturityDate(String liqMaturityDate) {
        this.liqMaturityDate = liqMaturityDate;
    }

    public java.math.BigDecimal getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(java.math.BigDecimal maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public String getInterestAccount() {
        return interestAccount;
    }

    public void setInterestAccount(String interestAccount) {
        this.interestAccount = interestAccount;
    }

    public String getPrincipalAccount() {
        return principalAccount;
    }

    public void setPrincipalAccount(String principalAccount) {
        this.principalAccount = principalAccount;
    }

    public String getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public java.math.BigDecimal getLiqWithdrawnAmount() {
        return liqWithdrawnAmount;
    }

    public void setLiqWithdrawnAmount(java.math.BigDecimal liqWithdrawnAmount) {
        this.liqWithdrawnAmount = liqWithdrawnAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public java.math.BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(java.math.BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getLiqDebitAccNo() {
        return liqDebitAccNo;
    }

    public void setLiqDebitAccNo(String liqDebitAccNo) {
        this.liqDebitAccNo = liqDebitAccNo;
    }

    public String getLiqDepositAccNo() {
        return liqDepositAccNo;
    }

    public void setLiqDepositAccNo(String liqDepositAccNo) {
        this.liqDepositAccNo = liqDepositAccNo;
    }

    public java.math.BigDecimal getLiqDepositAmount() {
        return liqDepositAmount;
    }

    public void setLiqDepositAmount(java.math.BigDecimal liqDepositAmount) {
        this.liqDepositAmount = liqDepositAmount;
    }

    public Integer getLienMarked() {
        return lienMarked;
    }

    public void setLienMarked(Integer lienMarked) {
        this.lienMarked = lienMarked;
    }

    public String getNameOfAcc() {
        return nameOfAcc;
    }

    public void setNameOfAcc(String nameOfAcc) {
        this.nameOfAcc = nameOfAcc;
    }

    public java.math.BigDecimal getLienAmount() {
        return lienAmount;
    }

    public void setLienAmount(java.math.BigDecimal lienAmount) {
        this.lienAmount = lienAmount;
    }

    public String getTransferTo() {
        return transferTo;
    }

    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public java.math.BigDecimal getMaxBookingLimit() {
        return maxBookingLimit;
    }

    public void setMaxBookingLimit(java.math.BigDecimal maxBookingLimit) {
        this.maxBookingLimit = maxBookingLimit;
    }

    public Long getOtpCount() {
        return otpCount;
    }

    public void setOtpCount(Long otpCount) {
        this.otpCount = otpCount;
    }

    public Long getOtpResent() {
        return otpResent;
    }

    public void setOtpResent(Long otpResent) {
        this.otpResent = otpResent;
    }

    public String getOtpSentTime() {
        return otpSentTime;
    }

    public void setOtpSentTime(String otpSentTime) {
        this.otpSentTime = otpSentTime;
    }

    public String getOtpLockedTime() {
        return otpLockedTime;
    }

    public void setOtpLockedTime(String otpLockedTime) {
        this.otpLockedTime = otpLockedTime;
    }

    public String getOtpUnlockTime() {
        return otpUnlockTime;
    }

    public void setOtpUnlockTime(String otpUnlockTime) {
        this.otpUnlockTime = otpUnlockTime;
    }

    public Long getOtpFailedCount() {
        return otpFailedCount;
    }

    public void setOtpFailedCount(Long otpFailedCount) {
        this.otpFailedCount = otpFailedCount;
    }

    public java.math.BigDecimal getUtilizedBookingLimit() {
        return utilizedBookingLimit;
    }

    public void setUtilizedBookingLimit(java.math.BigDecimal utilizedBookingLimit) {
        this.utilizedBookingLimit = utilizedBookingLimit;
    }

    public java.math.BigDecimal getAvailableBookingLimit() {
        return availableBookingLimit;
    }

    public void setAvailableBookingLimit(java.math.BigDecimal availableBookingLimit) {
        this.availableBookingLimit = availableBookingLimit;
    }

    public java.math.BigDecimal getPendingUtilisedLimit() {
        return pendingUtilisedLimit;
    }

    public void setPendingUtilisedLimit(java.math.BigDecimal pendingUtilisedLimit) {
        this.pendingUtilisedLimit = pendingUtilisedLimit;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getFinacleStatus() {
        return finacleStatus;
    }

    public void setFinacleStatus(String finacleStatus) {
        this.finacleStatus = finacleStatus;
    }

    public String getFinacleErrorCode() {
        return finacleErrorCode;
    }

    public void setFinacleErrorCode(String finacleErrorCode) {
        this.finacleErrorCode = finacleErrorCode;
    }

    public String getFinacleErrorDesc() {
        return finacleErrorDesc;
    }

    public void setFinacleErrorDesc(String finacleErrorDesc) {
        this.finacleErrorDesc = finacleErrorDesc;
    }

    public java.math.BigDecimal getLiqWithdrawalInterest() {
        return liqWithdrawalInterest;
    }

    public void setLiqWithdrawalInterest(java.math.BigDecimal liqWithdrawalInterest) {
        this.liqWithdrawalInterest = liqWithdrawalInterest;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public static class Builder {

        private FgLiquidationReq instance = new FgLiquidationReq();

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

        public Builder tdAccount(String tdAccount) {
            instance.setTdAccount(tdAccount);
            return this;
        }

        public Builder accountName(String accountName) {
            instance.setAccountName(accountName);
            return this;
        }

        public Builder principalAmount(java.math.BigDecimal principalAmount) {
            instance.setPrincipalAmount(principalAmount);
            return this;
        }

        public Builder liqInterestRate(java.math.BigDecimal liqInterestRate) {
            instance.setLiqInterestRate(liqInterestRate);
            return this;
        }

        public Builder currentBalance(java.math.BigDecimal currentBalance) {
            instance.setCurrentBalance(currentBalance);
            return this;
        }

        public Builder startDate(String startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public Builder liqMaturityDate(String liqMaturityDate) {
            instance.setLiqMaturityDate(liqMaturityDate);
            return this;
        }

        public Builder maturityAmount(java.math.BigDecimal maturityAmount) {
            instance.setMaturityAmount(maturityAmount);
            return this;
        }

        public Builder interestAccount(String interestAccount) {
            instance.setInterestAccount(interestAccount);
            return this;
        }

        public Builder principalAccount(String principalAccount) {
            instance.setPrincipalAccount(principalAccount);
            return this;
        }

        public Builder liquidType(String liquidType) {
            instance.setLiquidType(liquidType);
            return this;
        }

        public Builder liqWithdrawnAmount(java.math.BigDecimal liqWithdrawnAmount) {
            instance.setLiqWithdrawnAmount(liqWithdrawnAmount);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder terms(Integer terms) {
            instance.setTerms(terms);
            return this;
        }

        public Builder availableBalance(java.math.BigDecimal availableBalance) {
            instance.setAvailableBalance(availableBalance);
            return this;
        }

        public Builder liqDebitAccNo(String liqDebitAccNo) {
            instance.setLiqDebitAccNo(liqDebitAccNo);
            return this;
        }

        public Builder liqDepositAccNo(String liqDepositAccNo) {
            instance.setLiqDepositAccNo(liqDepositAccNo);
            return this;
        }

        public Builder liqDepositAmount(java.math.BigDecimal liqDepositAmount) {
            instance.setLiqDepositAmount(liqDepositAmount);
            return this;
        }

        public Builder lienMarked(Integer lienMarked) {
            instance.setLienMarked(lienMarked);
            return this;
        }

        public Builder nameOfAcc(String nameOfAcc) {
            instance.setNameOfAcc(nameOfAcc);
            return this;
        }

        public Builder lienAmount(java.math.BigDecimal lienAmount) {
            instance.setLienAmount(lienAmount);
            return this;
        }

        public Builder transferTo(String transferTo) {
            instance.setTransferTo(transferTo);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            instance.setSchemeCode(schemeCode);
            return this;
        }

        public Builder userType(String userType) {
            instance.setUserType(userType);
            return this;
        }

        public Builder maxBookingLimit(java.math.BigDecimal maxBookingLimit) {
            instance.setMaxBookingLimit(maxBookingLimit);
            return this;
        }

        public Builder otpCount(Long otpCount) {
            instance.setOtpCount(otpCount);
            return this;
        }

        public Builder otpResent(Long otpResent) {
            instance.setOtpResent(otpResent);
            return this;
        }

        public Builder otpSentTime(String otpSentTime) {
            instance.setOtpSentTime(otpSentTime);
            return this;
        }

        public Builder otpLockedTime(String otpLockedTime) {
            instance.setOtpLockedTime(otpLockedTime);
            return this;
        }

        public Builder otpUnlockTime(String otpUnlockTime) {
            instance.setOtpUnlockTime(otpUnlockTime);
            return this;
        }

        public Builder otpFailedCount(Long otpFailedCount) {
            instance.setOtpFailedCount(otpFailedCount);
            return this;
        }

        public Builder utilizedBookingLimit(java.math.BigDecimal utilizedBookingLimit) {
            instance.setUtilizedBookingLimit(utilizedBookingLimit);
            return this;
        }

        public Builder availableBookingLimit(java.math.BigDecimal availableBookingLimit) {
            instance.setAvailableBookingLimit(availableBookingLimit);
            return this;
        }

        public Builder pendingUtilisedLimit(java.math.BigDecimal pendingUtilisedLimit) {
            instance.setPendingUtilisedLimit(pendingUtilisedLimit);
            return this;
        }

        public Builder productStatus(String productStatus) {
            instance.setProductStatus(productStatus);
            return this;
        }

        public Builder finacleStatus(String finacleStatus) {
            instance.setFinacleStatus(finacleStatus);
            return this;
        }

        public Builder finacleErrorCode(String finacleErrorCode) {
            instance.setFinacleErrorCode(finacleErrorCode);
            return this;
        }

        public Builder finacleErrorDesc(String finacleErrorDesc) {
            instance.setFinacleErrorDesc(finacleErrorDesc);
            return this;
        }

        public Builder liqWithdrawalInterest(java.math.BigDecimal liqWithdrawalInterest) {
            instance.setLiqWithdrawalInterest(liqWithdrawalInterest);
            return this;
        }

        public Builder origin(String origin) {
            instance.setOrigin(origin);
            return this;
        }

        public FgLiquidationReq build() {
            return instance;
        }
    }
}
