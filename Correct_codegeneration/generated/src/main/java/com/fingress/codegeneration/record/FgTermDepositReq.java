package com.bsit.codegeneration.record;

public record FgTermDepositReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String userCrn, String userName, String userEmail, String userMobile, Long depositAmount, String ccy, String accountName, String accountType, String tenureDays, String customTenure, String interestRate, java.time.LocalDateTime maturityDate, String productStatus, String taskReason, String debitAccNum, String interestAccount, String principalAccount, Long lienAmount, Long lienMarked, Long accBalance, Long principalAmount, Long maturityAmount, Long interestAmount, String interestPayPlan, String interestDescription, String maturityInstruction, String schemeCode, String userType, Long terms, String itType, Long otpCount, Long otpResent, String otpSentTime, String otpLockedTime, String otpUnlockTime, Long otpFailedCount, Long tdMinAmount, Long tdMaxAmount, Long maxBookingLimit, Long utilisedBookingLimit, Long availableBookingLimit, Long pendingUtilisedLimit, Long year, Long month, Long days, String tdAccountNumber, String finacleStatus, String optionalRange, String origin, String tdType) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String processID;

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

        private String userCrn;

        private String userName;

        private String userEmail;

        private String userMobile;

        private Long depositAmount;

        private String ccy;

        private String accountName;

        private String accountType;

        private String tenureDays;

        private String customTenure;

        private String interestRate;

        private java.time.LocalDateTime maturityDate;

        private String productStatus;

        private String taskReason;

        private String debitAccNum;

        private String interestAccount;

        private String principalAccount;

        private Long lienAmount;

        private Long lienMarked;

        private Long accBalance;

        private Long principalAmount;

        private Long maturityAmount;

        private Long interestAmount;

        private String interestPayPlan;

        private String interestDescription;

        private String maturityInstruction;

        private String schemeCode;

        private String userType;

        private Long terms;

        private String itType;

        private Long otpCount;

        private Long otpResent;

        private String otpSentTime;

        private String otpLockedTime;

        private String otpUnlockTime;

        private Long otpFailedCount;

        private Long tdMinAmount;

        private Long tdMaxAmount;

        private Long maxBookingLimit;

        private Long utilisedBookingLimit;

        private Long availableBookingLimit;

        private Long pendingUtilisedLimit;

        private Long year;

        private Long month;

        private Long days;

        private String tdAccountNumber;

        private String finacleStatus;

        private String optionalRange;

        private String origin;

        private String tdType;

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

        public Builder processID(String processID) {
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

        public Builder userCrn(String userCrn) {
            this.userCrn = userCrn;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder userMobile(String userMobile) {
            this.userMobile = userMobile;
            return this;
        }

        public Builder depositAmount(Long depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        public Builder ccy(String ccy) {
            this.ccy = ccy;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder tenureDays(String tenureDays) {
            this.tenureDays = tenureDays;
            return this;
        }

        public Builder customTenure(String customTenure) {
            this.customTenure = customTenure;
            return this;
        }

        public Builder interestRate(String interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder maturityDate(java.time.LocalDateTime maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder debitAccNum(String debitAccNum) {
            this.debitAccNum = debitAccNum;
            return this;
        }

        public Builder interestAccount(String interestAccount) {
            this.interestAccount = interestAccount;
            return this;
        }

        public Builder principalAccount(String principalAccount) {
            this.principalAccount = principalAccount;
            return this;
        }

        public Builder lienAmount(Long lienAmount) {
            this.lienAmount = lienAmount;
            return this;
        }

        public Builder lienMarked(Long lienMarked) {
            this.lienMarked = lienMarked;
            return this;
        }

        public Builder accBalance(Long accBalance) {
            this.accBalance = accBalance;
            return this;
        }

        public Builder principalAmount(Long principalAmount) {
            this.principalAmount = principalAmount;
            return this;
        }

        public Builder maturityAmount(Long maturityAmount) {
            this.maturityAmount = maturityAmount;
            return this;
        }

        public Builder interestAmount(Long interestAmount) {
            this.interestAmount = interestAmount;
            return this;
        }

        public Builder interestPayPlan(String interestPayPlan) {
            this.interestPayPlan = interestPayPlan;
            return this;
        }

        public Builder interestDescription(String interestDescription) {
            this.interestDescription = interestDescription;
            return this;
        }

        public Builder maturityInstruction(String maturityInstruction) {
            this.maturityInstruction = maturityInstruction;
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            this.schemeCode = schemeCode;
            return this;
        }

        public Builder userType(String userType) {
            this.userType = userType;
            return this;
        }

        public Builder terms(Long terms) {
            this.terms = terms;
            return this;
        }

        public Builder itType(String itType) {
            this.itType = itType;
            return this;
        }

        public Builder otpCount(Long otpCount) {
            this.otpCount = otpCount;
            return this;
        }

        public Builder otpResent(Long otpResent) {
            this.otpResent = otpResent;
            return this;
        }

        public Builder otpSentTime(String otpSentTime) {
            this.otpSentTime = otpSentTime;
            return this;
        }

        public Builder otpLockedTime(String otpLockedTime) {
            this.otpLockedTime = otpLockedTime;
            return this;
        }

        public Builder otpUnlockTime(String otpUnlockTime) {
            this.otpUnlockTime = otpUnlockTime;
            return this;
        }

        public Builder otpFailedCount(Long otpFailedCount) {
            this.otpFailedCount = otpFailedCount;
            return this;
        }

        public Builder tdMinAmount(Long tdMinAmount) {
            this.tdMinAmount = tdMinAmount;
            return this;
        }

        public Builder tdMaxAmount(Long tdMaxAmount) {
            this.tdMaxAmount = tdMaxAmount;
            return this;
        }

        public Builder maxBookingLimit(Long maxBookingLimit) {
            this.maxBookingLimit = maxBookingLimit;
            return this;
        }

        public Builder utilisedBookingLimit(Long utilisedBookingLimit) {
            this.utilisedBookingLimit = utilisedBookingLimit;
            return this;
        }

        public Builder availableBookingLimit(Long availableBookingLimit) {
            this.availableBookingLimit = availableBookingLimit;
            return this;
        }

        public Builder pendingUtilisedLimit(Long pendingUtilisedLimit) {
            this.pendingUtilisedLimit = pendingUtilisedLimit;
            return this;
        }

        public Builder year(Long year) {
            this.year = year;
            return this;
        }

        public Builder month(Long month) {
            this.month = month;
            return this;
        }

        public Builder days(Long days) {
            this.days = days;
            return this;
        }

        public Builder tdAccountNumber(String tdAccountNumber) {
            this.tdAccountNumber = tdAccountNumber;
            return this;
        }

        public Builder finacleStatus(String finacleStatus) {
            this.finacleStatus = finacleStatus;
            return this;
        }

        public Builder optionalRange(String optionalRange) {
            this.optionalRange = optionalRange;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder tdType(String tdType) {
            this.tdType = tdType;
            return this;
        }

        public FgTermDepositReq build() {
            return new FgTermDepositReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, userCrn, userName, userEmail, userMobile, depositAmount, ccy, accountName, accountType, tenureDays, customTenure, interestRate, maturityDate, productStatus, taskReason, debitAccNum, interestAccount, principalAccount, lienAmount, lienMarked, accBalance, principalAmount, maturityAmount, interestAmount, interestPayPlan, interestDescription, maturityInstruction, schemeCode, userType, terms, itType, otpCount, otpResent, otpSentTime, otpLockedTime, otpUnlockTime, otpFailedCount, tdMinAmount, tdMaxAmount, maxBookingLimit, utilisedBookingLimit, availableBookingLimit, pendingUtilisedLimit, year, month, days, tdAccountNumber, finacleStatus, optionalRange, origin, tdType);
        }
    }
}
