package com.bsit.codegeneration.record;

public record KmblScfCounterparty(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantPartyCode, String fulfillmentParty, Long isTemplate, String abbvName, String name, String customerRole, String inputBranch, String behalfOfBranch, String accountNumber, String ifscCode, String bankName, String limitNode1, String paymentType, String intBearingParty, String debitParty, String intType, String baseCode, String penelSpread, String cpAbbvName, String cpName, String cpCode, String cpRole, String productType, Long gracePeriod, String limitNode2, Long marginRate, Long spreadRate, String uploadRefID, Long interestRate, String rateType, String debitPartyCrn, String creditPartyCrn, String creditPartyName, String sellerIDCrn, String cpStatus, String displayStatus, String lineNo, String ancAccountNumber, String ancIfscCode, String ancBankName, String ancPaymentType, String ancIntType, String ancPenalSpread, String ancBaseCode, Long ancSpreadRate, Long versionID, Long isMasterVersion, String buyerIDCrn, String layoutName, String taskReason, Long baseRate, String migrationStatus, String migrationDate, String dmsEventID, String ancBeneLei, String activePeriodUom, Long activePeriod, String actvDateField, String loanRepaymentDate, String loanTenor, String loanTenorUom, String programLayoutName, String layoutID, String layoutUuid, String actvDateDisplay, Long loanTenorDays) {

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

        private String applicantPartyCode;

        private String fulfillmentParty;

        private Long isTemplate;

        private String abbvName;

        private String name;

        private String customerRole;

        private String inputBranch;

        private String behalfOfBranch;

        private String accountNumber;

        private String ifscCode;

        private String bankName;

        private String limitNode1;

        private String paymentType;

        private String intBearingParty;

        private String debitParty;

        private String intType;

        private String baseCode;

        private String penelSpread;

        private String cpAbbvName;

        private String cpName;

        private String cpCode;

        private String cpRole;

        private String productType;

        private Long gracePeriod;

        private String limitNode2;

        private Long marginRate;

        private Long spreadRate;

        private String uploadRefID;

        private Long interestRate;

        private String rateType;

        private String debitPartyCrn;

        private String creditPartyCrn;

        private String creditPartyName;

        private String sellerIDCrn;

        private String cpStatus;

        private String displayStatus;

        private String lineNo;

        private String ancAccountNumber;

        private String ancIfscCode;

        private String ancBankName;

        private String ancPaymentType;

        private String ancIntType;

        private String ancPenalSpread;

        private String ancBaseCode;

        private Long ancSpreadRate;

        private Long versionID;

        private Long isMasterVersion;

        private String buyerIDCrn;

        private String layoutName;

        private String taskReason;

        private Long baseRate;

        private String migrationStatus;

        private String migrationDate;

        private String dmsEventID;

        private String ancBeneLei;

        private String activePeriodUom;

        private Long activePeriod;

        private String actvDateField;

        private String loanRepaymentDate;

        private String loanTenor;

        private String loanTenorUom;

        private String programLayoutName;

        private String layoutID;

        private String layoutUuid;

        private String actvDateDisplay;

        private Long loanTenorDays;

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

        public Builder applicantPartyCode(String applicantPartyCode) {
            this.applicantPartyCode = applicantPartyCode;
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

        public Builder abbvName(String abbvName) {
            this.abbvName = abbvName;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder customerRole(String customerRole) {
            this.customerRole = customerRole;
            return this;
        }

        public Builder inputBranch(String inputBranch) {
            this.inputBranch = inputBranch;
            return this;
        }

        public Builder behalfOfBranch(String behalfOfBranch) {
            this.behalfOfBranch = behalfOfBranch;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder ifscCode(String ifscCode) {
            this.ifscCode = ifscCode;
            return this;
        }

        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder limitNode1(String limitNode1) {
            this.limitNode1 = limitNode1;
            return this;
        }

        public Builder paymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder intBearingParty(String intBearingParty) {
            this.intBearingParty = intBearingParty;
            return this;
        }

        public Builder debitParty(String debitParty) {
            this.debitParty = debitParty;
            return this;
        }

        public Builder intType(String intType) {
            this.intType = intType;
            return this;
        }

        public Builder baseCode(String baseCode) {
            this.baseCode = baseCode;
            return this;
        }

        public Builder penelSpread(String penelSpread) {
            this.penelSpread = penelSpread;
            return this;
        }

        public Builder cpAbbvName(String cpAbbvName) {
            this.cpAbbvName = cpAbbvName;
            return this;
        }

        public Builder cpName(String cpName) {
            this.cpName = cpName;
            return this;
        }

        public Builder cpCode(String cpCode) {
            this.cpCode = cpCode;
            return this;
        }

        public Builder cpRole(String cpRole) {
            this.cpRole = cpRole;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder gracePeriod(Long gracePeriod) {
            this.gracePeriod = gracePeriod;
            return this;
        }

        public Builder limitNode2(String limitNode2) {
            this.limitNode2 = limitNode2;
            return this;
        }

        public Builder marginRate(Long marginRate) {
            this.marginRate = marginRate;
            return this;
        }

        public Builder spreadRate(Long spreadRate) {
            this.spreadRate = spreadRate;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder rateType(String rateType) {
            this.rateType = rateType;
            return this;
        }

        public Builder debitPartyCrn(String debitPartyCrn) {
            this.debitPartyCrn = debitPartyCrn;
            return this;
        }

        public Builder creditPartyCrn(String creditPartyCrn) {
            this.creditPartyCrn = creditPartyCrn;
            return this;
        }

        public Builder creditPartyName(String creditPartyName) {
            this.creditPartyName = creditPartyName;
            return this;
        }

        public Builder sellerIDCrn(String sellerIDCrn) {
            this.sellerIDCrn = sellerIDCrn;
            return this;
        }

        public Builder cpStatus(String cpStatus) {
            this.cpStatus = cpStatus;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder lineNo(String lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public Builder ancAccountNumber(String ancAccountNumber) {
            this.ancAccountNumber = ancAccountNumber;
            return this;
        }

        public Builder ancIfscCode(String ancIfscCode) {
            this.ancIfscCode = ancIfscCode;
            return this;
        }

        public Builder ancBankName(String ancBankName) {
            this.ancBankName = ancBankName;
            return this;
        }

        public Builder ancPaymentType(String ancPaymentType) {
            this.ancPaymentType = ancPaymentType;
            return this;
        }

        public Builder ancIntType(String ancIntType) {
            this.ancIntType = ancIntType;
            return this;
        }

        public Builder ancPenalSpread(String ancPenalSpread) {
            this.ancPenalSpread = ancPenalSpread;
            return this;
        }

        public Builder ancBaseCode(String ancBaseCode) {
            this.ancBaseCode = ancBaseCode;
            return this;
        }

        public Builder ancSpreadRate(Long ancSpreadRate) {
            this.ancSpreadRate = ancSpreadRate;
            return this;
        }

        public Builder versionID(Long versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder buyerIDCrn(String buyerIDCrn) {
            this.buyerIDCrn = buyerIDCrn;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder baseRate(Long baseRate) {
            this.baseRate = baseRate;
            return this;
        }

        public Builder migrationStatus(String migrationStatus) {
            this.migrationStatus = migrationStatus;
            return this;
        }

        public Builder migrationDate(String migrationDate) {
            this.migrationDate = migrationDate;
            return this;
        }

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder ancBeneLei(String ancBeneLei) {
            this.ancBeneLei = ancBeneLei;
            return this;
        }

        public Builder activePeriodUom(String activePeriodUom) {
            this.activePeriodUom = activePeriodUom;
            return this;
        }

        public Builder activePeriod(Long activePeriod) {
            this.activePeriod = activePeriod;
            return this;
        }

        public Builder actvDateField(String actvDateField) {
            this.actvDateField = actvDateField;
            return this;
        }

        public Builder loanRepaymentDate(String loanRepaymentDate) {
            this.loanRepaymentDate = loanRepaymentDate;
            return this;
        }

        public Builder loanTenor(String loanTenor) {
            this.loanTenor = loanTenor;
            return this;
        }

        public Builder loanTenorUom(String loanTenorUom) {
            this.loanTenorUom = loanTenorUom;
            return this;
        }

        public Builder programLayoutName(String programLayoutName) {
            this.programLayoutName = programLayoutName;
            return this;
        }

        public Builder layoutID(String layoutID) {
            this.layoutID = layoutID;
            return this;
        }

        public Builder layoutUuid(String layoutUuid) {
            this.layoutUuid = layoutUuid;
            return this;
        }

        public Builder actvDateDisplay(String actvDateDisplay) {
            this.actvDateDisplay = actvDateDisplay;
            return this;
        }

        public Builder loanTenorDays(Long loanTenorDays) {
            this.loanTenorDays = loanTenorDays;
            return this;
        }

        public KmblScfCounterparty build() {
            return new KmblScfCounterparty(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantPartyCode, fulfillmentParty, isTemplate, abbvName, name, customerRole, inputBranch, behalfOfBranch, accountNumber, ifscCode, bankName, limitNode1, paymentType, intBearingParty, debitParty, intType, baseCode, penelSpread, cpAbbvName, cpName, cpCode, cpRole, productType, gracePeriod, limitNode2, marginRate, spreadRate, uploadRefID, interestRate, rateType, debitPartyCrn, creditPartyCrn, creditPartyName, sellerIDCrn, cpStatus, displayStatus, lineNo, ancAccountNumber, ancIfscCode, ancBankName, ancPaymentType, ancIntType, ancPenalSpread, ancBaseCode, ancSpreadRate, versionID, isMasterVersion, buyerIDCrn, layoutName, taskReason, baseRate, migrationStatus, migrationDate, dmsEventID, ancBeneLei, activePeriodUom, activePeriod, actvDateField, loanRepaymentDate, loanTenor, loanTenorUom, programLayoutName, layoutID, layoutUuid, actvDateDisplay, loanTenorDays);
        }
    }
}
