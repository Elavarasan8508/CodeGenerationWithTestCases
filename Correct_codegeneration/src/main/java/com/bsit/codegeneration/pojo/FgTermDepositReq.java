package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgTermDepositReq {

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

    private String userCrn;

    private String userName;

    private String userEmail;

    private String userMobile;

    private java.math.BigDecimal depositAmount;

    private String ccy;

    private String accountName;

    private String accountType;

    private String tenureDays;

    private String customTenure;

    private java.math.BigDecimal interestRate;

    private java.time.LocalDateTime maturityDate;

    private String productStatus;

    private String taskReason;

    private String debitAccNum;

    private String interestAccount;

    private String principalAccount;

    private java.math.BigDecimal lienAmount;

    private Integer lienMarked;

    private java.math.BigDecimal accBalance;

    private java.math.BigDecimal principalAmount;

    private java.math.BigDecimal maturityAmount;

    private java.math.BigDecimal interestAmount;

    private String interestPayPlan;

    private String interestDescription;

    private String maturityInstruction;

    private String schemeCode;

    private String userType;

    private Integer terms;

    private String itType;

    private Long otpCount;

    private Long otpResent;

    private String otpSentTime;

    private String otpLockedTime;

    private String otpUnlockTime;

    private Long otpFailedCount;

    private java.math.BigDecimal tdMinAmount;

    private java.math.BigDecimal tdMaxAmount;

    private java.math.BigDecimal maxBookingLimit;

    private java.math.BigDecimal utilisedBookingLimit;

    private java.math.BigDecimal availableBookingLimit;

    private java.math.BigDecimal pendingUtilisedLimit;

    private Integer year;

    private Long month;

    private Long days;

    private String tdAccountNumber;

    private String finacleStatus;

    private String optionalRange;

    private String origin;

    private String tdType;

    public FgTermDepositReq() {
    }

    public FgTermDepositReq(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String userCrn, String userName, String userEmail, String userMobile, java.math.BigDecimal depositAmount, String ccy, String accountName, String accountType, String tenureDays, String customTenure, java.math.BigDecimal interestRate, java.time.LocalDateTime maturityDate, String productStatus, String taskReason, String debitAccNum, String interestAccount, String principalAccount, java.math.BigDecimal lienAmount, Integer lienMarked, java.math.BigDecimal accBalance, java.math.BigDecimal principalAmount, java.math.BigDecimal maturityAmount, java.math.BigDecimal interestAmount, String interestPayPlan, String interestDescription, String maturityInstruction, String schemeCode, String userType, Integer terms, String itType, Long otpCount, Long otpResent, String otpSentTime, String otpLockedTime, String otpUnlockTime, Long otpFailedCount, java.math.BigDecimal tdMinAmount, java.math.BigDecimal tdMaxAmount, java.math.BigDecimal maxBookingLimit, java.math.BigDecimal utilisedBookingLimit, java.math.BigDecimal availableBookingLimit, java.math.BigDecimal pendingUtilisedLimit, Integer year, Long month, Long days, String tdAccountNumber, String finacleStatus, String optionalRange, String origin, String tdType) {
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
        this.userCrn = userCrn;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.depositAmount = depositAmount;
        this.ccy = ccy;
        this.accountName = accountName;
        this.accountType = accountType;
        this.tenureDays = tenureDays;
        this.customTenure = customTenure;
        this.interestRate = interestRate;
        this.maturityDate = maturityDate;
        this.productStatus = productStatus;
        this.taskReason = taskReason;
        this.debitAccNum = debitAccNum;
        this.interestAccount = interestAccount;
        this.principalAccount = principalAccount;
        this.lienAmount = lienAmount;
        this.lienMarked = lienMarked;
        this.accBalance = accBalance;
        this.principalAmount = principalAmount;
        this.maturityAmount = maturityAmount;
        this.interestAmount = interestAmount;
        this.interestPayPlan = interestPayPlan;
        this.interestDescription = interestDescription;
        this.maturityInstruction = maturityInstruction;
        this.schemeCode = schemeCode;
        this.userType = userType;
        this.terms = terms;
        this.itType = itType;
        this.otpCount = otpCount;
        this.otpResent = otpResent;
        this.otpSentTime = otpSentTime;
        this.otpLockedTime = otpLockedTime;
        this.otpUnlockTime = otpUnlockTime;
        this.otpFailedCount = otpFailedCount;
        this.tdMinAmount = tdMinAmount;
        this.tdMaxAmount = tdMaxAmount;
        this.maxBookingLimit = maxBookingLimit;
        this.utilisedBookingLimit = utilisedBookingLimit;
        this.availableBookingLimit = availableBookingLimit;
        this.pendingUtilisedLimit = pendingUtilisedLimit;
        this.year = year;
        this.month = month;
        this.days = days;
        this.tdAccountNumber = tdAccountNumber;
        this.finacleStatus = finacleStatus;
        this.optionalRange = optionalRange;
        this.origin = origin;
        this.tdType = tdType;
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

    public String getUserCrn() {
        return userCrn;
    }

    public void setUserCrn(String userCrn) {
        this.userCrn = userCrn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public java.math.BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(java.math.BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTenureDays() {
        return tenureDays;
    }

    public void setTenureDays(String tenureDays) {
        this.tenureDays = tenureDays;
    }

    public String getCustomTenure() {
        return customTenure;
    }

    public void setCustomTenure(String customTenure) {
        this.customTenure = customTenure;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public java.time.LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.time.LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public String getDebitAccNum() {
        return debitAccNum;
    }

    public void setDebitAccNum(String debitAccNum) {
        this.debitAccNum = debitAccNum;
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

    public java.math.BigDecimal getLienAmount() {
        return lienAmount;
    }

    public void setLienAmount(java.math.BigDecimal lienAmount) {
        this.lienAmount = lienAmount;
    }

    public Integer getLienMarked() {
        return lienMarked;
    }

    public void setLienMarked(Integer lienMarked) {
        this.lienMarked = lienMarked;
    }

    public java.math.BigDecimal getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(java.math.BigDecimal accBalance) {
        this.accBalance = accBalance;
    }

    public java.math.BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(java.math.BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public java.math.BigDecimal getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(java.math.BigDecimal maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public java.math.BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(java.math.BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public String getInterestPayPlan() {
        return interestPayPlan;
    }

    public void setInterestPayPlan(String interestPayPlan) {
        this.interestPayPlan = interestPayPlan;
    }

    public String getInterestDescription() {
        return interestDescription;
    }

    public void setInterestDescription(String interestDescription) {
        this.interestDescription = interestDescription;
    }

    public String getMaturityInstruction() {
        return maturityInstruction;
    }

    public void setMaturityInstruction(String maturityInstruction) {
        this.maturityInstruction = maturityInstruction;
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

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public String getItType() {
        return itType;
    }

    public void setItType(String itType) {
        this.itType = itType;
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

    public java.math.BigDecimal getTdMinAmount() {
        return tdMinAmount;
    }

    public void setTdMinAmount(java.math.BigDecimal tdMinAmount) {
        this.tdMinAmount = tdMinAmount;
    }

    public java.math.BigDecimal getTdMaxAmount() {
        return tdMaxAmount;
    }

    public void setTdMaxAmount(java.math.BigDecimal tdMaxAmount) {
        this.tdMaxAmount = tdMaxAmount;
    }

    public java.math.BigDecimal getMaxBookingLimit() {
        return maxBookingLimit;
    }

    public void setMaxBookingLimit(java.math.BigDecimal maxBookingLimit) {
        this.maxBookingLimit = maxBookingLimit;
    }

    public java.math.BigDecimal getUtilisedBookingLimit() {
        return utilisedBookingLimit;
    }

    public void setUtilisedBookingLimit(java.math.BigDecimal utilisedBookingLimit) {
        this.utilisedBookingLimit = utilisedBookingLimit;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public String getTdAccountNumber() {
        return tdAccountNumber;
    }

    public void setTdAccountNumber(String tdAccountNumber) {
        this.tdAccountNumber = tdAccountNumber;
    }

    public String getFinacleStatus() {
        return finacleStatus;
    }

    public void setFinacleStatus(String finacleStatus) {
        this.finacleStatus = finacleStatus;
    }

    public String getOptionalRange() {
        return optionalRange;
    }

    public void setOptionalRange(String optionalRange) {
        this.optionalRange = optionalRange;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTdType() {
        return tdType;
    }

    public void setTdType(String tdType) {
        this.tdType = tdType;
    }

    public static class Builder {

        private FgTermDepositReq instance = new FgTermDepositReq();

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

        public Builder userCrn(String userCrn) {
            instance.setUserCrn(userCrn);
            return this;
        }

        public Builder userName(String userName) {
            instance.setUserName(userName);
            return this;
        }

        public Builder userEmail(String userEmail) {
            instance.setUserEmail(userEmail);
            return this;
        }

        public Builder userMobile(String userMobile) {
            instance.setUserMobile(userMobile);
            return this;
        }

        public Builder depositAmount(java.math.BigDecimal depositAmount) {
            instance.setDepositAmount(depositAmount);
            return this;
        }

        public Builder ccy(String ccy) {
            instance.setCcy(ccy);
            return this;
        }

        public Builder accountName(String accountName) {
            instance.setAccountName(accountName);
            return this;
        }

        public Builder accountType(String accountType) {
            instance.setAccountType(accountType);
            return this;
        }

        public Builder tenureDays(String tenureDays) {
            instance.setTenureDays(tenureDays);
            return this;
        }

        public Builder customTenure(String customTenure) {
            instance.setCustomTenure(customTenure);
            return this;
        }

        public Builder interestRate(java.math.BigDecimal interestRate) {
            instance.setInterestRate(interestRate);
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            instance.setMaturityDate(maturityDate);
            return this;
        }

        public Builder productStatus(String productStatus) {
            instance.setProductStatus(productStatus);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder debitAccNum(String debitAccNum) {
            instance.setDebitAccNum(debitAccNum);
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

        public Builder lienAmount(java.math.BigDecimal lienAmount) {
            instance.setLienAmount(lienAmount);
            return this;
        }

        public Builder lienMarked(Integer lienMarked) {
            instance.setLienMarked(lienMarked);
            return this;
        }

        public Builder accBalance(java.math.BigDecimal accBalance) {
            instance.setAccBalance(accBalance);
            return this;
        }

        public Builder principalAmount(java.math.BigDecimal principalAmount) {
            instance.setPrincipalAmount(principalAmount);
            return this;
        }

        public Builder maturityAmount(java.math.BigDecimal maturityAmount) {
            instance.setMaturityAmount(maturityAmount);
            return this;
        }

        public Builder interestAmount(java.math.BigDecimal interestAmount) {
            instance.setInterestAmount(interestAmount);
            return this;
        }

        public Builder interestPayPlan(String interestPayPlan) {
            instance.setInterestPayPlan(interestPayPlan);
            return this;
        }

        public Builder interestDescription(String interestDescription) {
            instance.setInterestDescription(interestDescription);
            return this;
        }

        public Builder maturityInstruction(String maturityInstruction) {
            instance.setMaturityInstruction(maturityInstruction);
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

        public Builder terms(Integer terms) {
            instance.setTerms(terms);
            return this;
        }

        public Builder itType(String itType) {
            instance.setItType(itType);
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

        public Builder tdMinAmount(java.math.BigDecimal tdMinAmount) {
            instance.setTdMinAmount(tdMinAmount);
            return this;
        }

        public Builder tdMaxAmount(java.math.BigDecimal tdMaxAmount) {
            instance.setTdMaxAmount(tdMaxAmount);
            return this;
        }

        public Builder maxBookingLimit(java.math.BigDecimal maxBookingLimit) {
            instance.setMaxBookingLimit(maxBookingLimit);
            return this;
        }

        public Builder utilisedBookingLimit(java.math.BigDecimal utilisedBookingLimit) {
            instance.setUtilisedBookingLimit(utilisedBookingLimit);
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

        public Builder year(Integer year) {
            instance.setYear(year);
            return this;
        }

        public Builder month(Long month) {
            instance.setMonth(month);
            return this;
        }

        public Builder days(Long days) {
            instance.setDays(days);
            return this;
        }

        public Builder tdAccountNumber(String tdAccountNumber) {
            instance.setTdAccountNumber(tdAccountNumber);
            return this;
        }

        public Builder finacleStatus(String finacleStatus) {
            instance.setFinacleStatus(finacleStatus);
            return this;
        }

        public Builder optionalRange(String optionalRange) {
            instance.setOptionalRange(optionalRange);
            return this;
        }

        public Builder origin(String origin) {
            instance.setOrigin(origin);
            return this;
        }

        public Builder tdType(String tdType) {
            instance.setTdType(tdType);
            return this;
        }

        public FgTermDepositReq build() {
            return instance;
        }
    }
}
