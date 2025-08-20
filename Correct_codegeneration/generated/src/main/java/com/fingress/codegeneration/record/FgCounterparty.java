package com.bsit.codegeneration.record;

public record FgCounterparty(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantPartyCode, String fulfillmentParty, Long isTemplate, String abbvName, String name, String customerRole, String inputBranch, String behalfOfBranch, String accountNumber, String ifscCode, String bankName, String limitNode1, String paymentType, String intBearingParty, String debitParty, String intType, String baseCode, String penelSpread, String cpAbbvName, String cpName, String cpCode, String cpRole, String productType, Long gracePeriod, String limitNode2, Long marginRate, Long spreadRate, String uploadRefID, Long interestRate, String rateType, String debitPartyCrn, String creditPartyCrn, String creditPartyName, String buyerID, String sellerID, String cpStatus) {

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

        private String buyerID;

        private String sellerID;

        private String cpStatus;

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

        public Builder buyerID(String buyerID) {
            this.buyerID = buyerID;
            return this;
        }

        public Builder sellerID(String sellerID) {
            this.sellerID = sellerID;
            return this;
        }

        public Builder cpStatus(String cpStatus) {
            this.cpStatus = cpStatus;
            return this;
        }

        public FgCounterparty build() {
            return new FgCounterparty(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantPartyCode, fulfillmentParty, isTemplate, abbvName, name, customerRole, inputBranch, behalfOfBranch, accountNumber, ifscCode, bankName, limitNode1, paymentType, intBearingParty, debitParty, intType, baseCode, penelSpread, cpAbbvName, cpName, cpCode, cpRole, productType, gracePeriod, limitNode2, marginRate, spreadRate, uploadRefID, interestRate, rateType, debitPartyCrn, creditPartyCrn, creditPartyName, buyerID, sellerID, cpStatus);
        }
    }
}
