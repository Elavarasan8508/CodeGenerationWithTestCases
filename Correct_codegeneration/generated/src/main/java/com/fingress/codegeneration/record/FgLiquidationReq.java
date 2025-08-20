package com.bsit.codegeneration.record;

public record FgLiquidationReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String tdAccount, String accountName, Long principalAmount, String liqInterestRate, Long currentBalance, String startDate, String liqMaturityDate, Long maturityAmount, String interestAccount, String principalAccount, String liquidType, Long liqWithdrawnAmount, String remarks, Long terms, Long availableBalance, String liqDebitAccNo, String liqDepositAccNo, Long liqDepositAmount, Long lienMarked, String nameOfAcc, Long lienAmount, String transferTo, String taskReason, String schemeCode, String userType, Long maxBookingLimit, Long otpCount, Long otpResent, String otpSentTime, String otpLockedTime, String otpUnlockTime, Long otpFailedCount, Long utilizedBookingLimit, Long availableBookingLimit, Long pendingUtilisedLimit, String productStatus, String finacleStatus, String finacleErrorCode, String finacleErrorDesc, Long liqWithdrawalInterest, String origin) {

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

        private String tdAccount;

        private String accountName;

        private Long principalAmount;

        private String liqInterestRate;

        private Long currentBalance;

        private String startDate;

        private String liqMaturityDate;

        private Long maturityAmount;

        private String interestAccount;

        private String principalAccount;

        private String liquidType;

        private Long liqWithdrawnAmount;

        private String remarks;

        private Long terms;

        private Long availableBalance;

        private String liqDebitAccNo;

        private String liqDepositAccNo;

        private Long liqDepositAmount;

        private Long lienMarked;

        private String nameOfAcc;

        private Long lienAmount;

        private String transferTo;

        private String taskReason;

        private String schemeCode;

        private String userType;

        private Long maxBookingLimit;

        private Long otpCount;

        private Long otpResent;

        private String otpSentTime;

        private String otpLockedTime;

        private String otpUnlockTime;

        private Long otpFailedCount;

        private Long utilizedBookingLimit;

        private Long availableBookingLimit;

        private Long pendingUtilisedLimit;

        private String productStatus;

        private String finacleStatus;

        private String finacleErrorCode;

        private String finacleErrorDesc;

        private Long liqWithdrawalInterest;

        private String origin;

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

        public Builder tdAccount(String tdAccount) {
            this.tdAccount = tdAccount;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder principalAmount(Long principalAmount) {
            this.principalAmount = principalAmount;
            return this;
        }

        public Builder liqInterestRate(String liqInterestRate) {
            this.liqInterestRate = liqInterestRate;
            return this;
        }

        public Builder currentBalance(Long currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder liqMaturityDate(String liqMaturityDate) {
            this.liqMaturityDate = liqMaturityDate;
            return this;
        }

        public Builder maturityAmount(Long maturityAmount) {
            this.maturityAmount = maturityAmount;
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

        public Builder liquidType(String liquidType) {
            this.liquidType = liquidType;
            return this;
        }

        public Builder liqWithdrawnAmount(Long liqWithdrawnAmount) {
            this.liqWithdrawnAmount = liqWithdrawnAmount;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder terms(Long terms) {
            this.terms = terms;
            return this;
        }

        public Builder availableBalance(Long availableBalance) {
            this.availableBalance = availableBalance;
            return this;
        }

        public Builder liqDebitAccNo(String liqDebitAccNo) {
            this.liqDebitAccNo = liqDebitAccNo;
            return this;
        }

        public Builder liqDepositAccNo(String liqDepositAccNo) {
            this.liqDepositAccNo = liqDepositAccNo;
            return this;
        }

        public Builder liqDepositAmount(Long liqDepositAmount) {
            this.liqDepositAmount = liqDepositAmount;
            return this;
        }

        public Builder lienMarked(Long lienMarked) {
            this.lienMarked = lienMarked;
            return this;
        }

        public Builder nameOfAcc(String nameOfAcc) {
            this.nameOfAcc = nameOfAcc;
            return this;
        }

        public Builder lienAmount(Long lienAmount) {
            this.lienAmount = lienAmount;
            return this;
        }

        public Builder transferTo(String transferTo) {
            this.transferTo = transferTo;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
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

        public Builder maxBookingLimit(Long maxBookingLimit) {
            this.maxBookingLimit = maxBookingLimit;
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

        public Builder utilizedBookingLimit(Long utilizedBookingLimit) {
            this.utilizedBookingLimit = utilizedBookingLimit;
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

        public Builder productStatus(String productStatus) {
            this.productStatus = productStatus;
            return this;
        }

        public Builder finacleStatus(String finacleStatus) {
            this.finacleStatus = finacleStatus;
            return this;
        }

        public Builder finacleErrorCode(String finacleErrorCode) {
            this.finacleErrorCode = finacleErrorCode;
            return this;
        }

        public Builder finacleErrorDesc(String finacleErrorDesc) {
            this.finacleErrorDesc = finacleErrorDesc;
            return this;
        }

        public Builder liqWithdrawalInterest(Long liqWithdrawalInterest) {
            this.liqWithdrawalInterest = liqWithdrawalInterest;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public FgLiquidationReq build() {
            return new FgLiquidationReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, tdAccount, accountName, principalAmount, liqInterestRate, currentBalance, startDate, liqMaturityDate, maturityAmount, interestAccount, principalAccount, liquidType, liqWithdrawnAmount, remarks, terms, availableBalance, liqDebitAccNo, liqDepositAccNo, liqDepositAmount, lienMarked, nameOfAcc, lienAmount, transferTo, taskReason, schemeCode, userType, maxBookingLimit, otpCount, otpResent, otpSentTime, otpLockedTime, otpUnlockTime, otpFailedCount, utilizedBookingLimit, availableBookingLimit, pendingUtilisedLimit, productStatus, finacleStatus, finacleErrorCode, finacleErrorDesc, liqWithdrawalInterest, origin);
        }
    }
}
