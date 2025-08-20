package com.bsit.codegeneration.record;

public record FgOrganizationParty(Long ID, String versionID, Long isMasterVersion, String isoCode, String languageCode, String name, String timeZoneCode, String typeCode, String subTypeCode, String referenceID, String abbvName, String currencyCode, String description, String configStatusCode, String ownerPartyCode, String addlCode01, String addlCode02, String addlCode03, String addlCode04, String addlCode05, String addlCode06, String addlCode07, String addlCode08, String addlCode09, String addlCode10, String addlCode11, String addlCode12, String addlCode13, String addlCode14, String addlCode15, String addlCode16, String addlCode17, String addlCode18, String addlCode19, String addlCode20, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String processID, String branchName, String branchCode, Long attachmentID, String partySubTypeCode, String democracyTypeCode, String democracySubTypeCode, String constitutionTypeCode, String parentPartyCode, String systemSourceCode, String empCode, String taskReasonCode, String taskReasonText, String masterTemplate, String transactionType, String regStatus, String migrationStatusCode, String migrationSysCode, String migrationSysRefCode, String migrationDatetime, String stageCode, String boStatusCode, String boStatusReference, String boStatusReasson, String boStatusMessage, String portalEnablementStatusCode, String uuid, String uploadRefID, String organizationType, String partyLinkType, String parentLinkType, String mobileNumber, String emailID, String firstName, String lastName, String applicantParty, String gender, String customerID, String dob, String currentAddress, String licenseNo, String panNo, String address1, String address2, String cityCode, String country, String pinCode, String identifierSubTypeCode, String identityNo, String issuerCode, String issuerName, String roleCode, String productID, String template, String isTemplate, String orgTypeCode, String orgSubTypeCode, String userActionCode, String activeCode) {

    public static class Builder {

        private Long ID;

        private String versionID;

        private Long isMasterVersion;

        private String isoCode;

        private String languageCode;

        private String name;

        private String timeZoneCode;

        private String typeCode;

        private String subTypeCode;

        private String referenceID;

        private String abbvName;

        private String currencyCode;

        private String description;

        private String configStatusCode;

        private String ownerPartyCode;

        private String addlCode01;

        private String addlCode02;

        private String addlCode03;

        private String addlCode04;

        private String addlCode05;

        private String addlCode06;

        private String addlCode07;

        private String addlCode08;

        private String addlCode09;

        private String addlCode10;

        private String addlCode11;

        private String addlCode12;

        private String addlCode13;

        private String addlCode14;

        private String addlCode15;

        private String addlCode16;

        private String addlCode17;

        private String addlCode18;

        private String addlCode19;

        private String addlCode20;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String processID;

        private String branchName;

        private String branchCode;

        private Long attachmentID;

        private String partySubTypeCode;

        private String democracyTypeCode;

        private String democracySubTypeCode;

        private String constitutionTypeCode;

        private String parentPartyCode;

        private String systemSourceCode;

        private String empCode;

        private String taskReasonCode;

        private String taskReasonText;

        private String masterTemplate;

        private String transactionType;

        private String regStatus;

        private String migrationStatusCode;

        private String migrationSysCode;

        private String migrationSysRefCode;

        private String migrationDatetime;

        private String stageCode;

        private String boStatusCode;

        private String boStatusReference;

        private String boStatusReasson;

        private String boStatusMessage;

        private String portalEnablementStatusCode;

        private String uuid;

        private String uploadRefID;

        private String organizationType;

        private String partyLinkType;

        private String parentLinkType;

        private String mobileNumber;

        private String emailID;

        private String firstName;

        private String lastName;

        private String applicantParty;

        private String gender;

        private String customerID;

        private String dob;

        private String currentAddress;

        private String licenseNo;

        private String panNo;

        private String address1;

        private String address2;

        private String cityCode;

        private String country;

        private String pinCode;

        private String identifierSubTypeCode;

        private String identityNo;

        private String issuerCode;

        private String issuerName;

        private String roleCode;

        private String productID;

        private String template;

        private String isTemplate;

        private String orgTypeCode;

        private String orgSubTypeCode;

        private String userActionCode;

        private String activeCode;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder versionID(String versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder isoCode(String isoCode) {
            this.isoCode = isoCode;
            return this;
        }

        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder timeZoneCode(String timeZoneCode) {
            this.timeZoneCode = timeZoneCode;
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

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder abbvName(String abbvName) {
            this.abbvName = abbvName;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder configStatusCode(String configStatusCode) {
            this.configStatusCode = configStatusCode;
            return this;
        }

        public Builder ownerPartyCode(String ownerPartyCode) {
            this.ownerPartyCode = ownerPartyCode;
            return this;
        }

        public Builder addlCode01(String addlCode01) {
            this.addlCode01 = addlCode01;
            return this;
        }

        public Builder addlCode02(String addlCode02) {
            this.addlCode02 = addlCode02;
            return this;
        }

        public Builder addlCode03(String addlCode03) {
            this.addlCode03 = addlCode03;
            return this;
        }

        public Builder addlCode04(String addlCode04) {
            this.addlCode04 = addlCode04;
            return this;
        }

        public Builder addlCode05(String addlCode05) {
            this.addlCode05 = addlCode05;
            return this;
        }

        public Builder addlCode06(String addlCode06) {
            this.addlCode06 = addlCode06;
            return this;
        }

        public Builder addlCode07(String addlCode07) {
            this.addlCode07 = addlCode07;
            return this;
        }

        public Builder addlCode08(String addlCode08) {
            this.addlCode08 = addlCode08;
            return this;
        }

        public Builder addlCode09(String addlCode09) {
            this.addlCode09 = addlCode09;
            return this;
        }

        public Builder addlCode10(String addlCode10) {
            this.addlCode10 = addlCode10;
            return this;
        }

        public Builder addlCode11(String addlCode11) {
            this.addlCode11 = addlCode11;
            return this;
        }

        public Builder addlCode12(String addlCode12) {
            this.addlCode12 = addlCode12;
            return this;
        }

        public Builder addlCode13(String addlCode13) {
            this.addlCode13 = addlCode13;
            return this;
        }

        public Builder addlCode14(String addlCode14) {
            this.addlCode14 = addlCode14;
            return this;
        }

        public Builder addlCode15(String addlCode15) {
            this.addlCode15 = addlCode15;
            return this;
        }

        public Builder addlCode16(String addlCode16) {
            this.addlCode16 = addlCode16;
            return this;
        }

        public Builder addlCode17(String addlCode17) {
            this.addlCode17 = addlCode17;
            return this;
        }

        public Builder addlCode18(String addlCode18) {
            this.addlCode18 = addlCode18;
            return this;
        }

        public Builder addlCode19(String addlCode19) {
            this.addlCode19 = addlCode19;
            return this;
        }

        public Builder addlCode20(String addlCode20) {
            this.addlCode20 = addlCode20;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
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

        public Builder processID(String processID) {
            this.processID = processID;
            return this;
        }

        public Builder branchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

        public Builder branchCode(String branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        public Builder attachmentID(Long attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder democracyTypeCode(String democracyTypeCode) {
            this.democracyTypeCode = democracyTypeCode;
            return this;
        }

        public Builder democracySubTypeCode(String democracySubTypeCode) {
            this.democracySubTypeCode = democracySubTypeCode;
            return this;
        }

        public Builder constitutionTypeCode(String constitutionTypeCode) {
            this.constitutionTypeCode = constitutionTypeCode;
            return this;
        }

        public Builder parentPartyCode(String parentPartyCode) {
            this.parentPartyCode = parentPartyCode;
            return this;
        }

        public Builder systemSourceCode(String systemSourceCode) {
            this.systemSourceCode = systemSourceCode;
            return this;
        }

        public Builder empCode(String empCode) {
            this.empCode = empCode;
            return this;
        }

        public Builder taskReasonCode(String taskReasonCode) {
            this.taskReasonCode = taskReasonCode;
            return this;
        }

        public Builder taskReasonText(String taskReasonText) {
            this.taskReasonText = taskReasonText;
            return this;
        }

        public Builder masterTemplate(String masterTemplate) {
            this.masterTemplate = masterTemplate;
            return this;
        }

        public Builder transactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder regStatus(String regStatus) {
            this.regStatus = regStatus;
            return this;
        }

        public Builder migrationStatusCode(String migrationStatusCode) {
            this.migrationStatusCode = migrationStatusCode;
            return this;
        }

        public Builder migrationSysCode(String migrationSysCode) {
            this.migrationSysCode = migrationSysCode;
            return this;
        }

        public Builder migrationSysRefCode(String migrationSysRefCode) {
            this.migrationSysRefCode = migrationSysRefCode;
            return this;
        }

        public Builder migrationDatetime(String migrationDatetime) {
            this.migrationDatetime = migrationDatetime;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder boStatusCode(String boStatusCode) {
            this.boStatusCode = boStatusCode;
            return this;
        }

        public Builder boStatusReference(String boStatusReference) {
            this.boStatusReference = boStatusReference;
            return this;
        }

        public Builder boStatusReasson(String boStatusReasson) {
            this.boStatusReasson = boStatusReasson;
            return this;
        }

        public Builder boStatusMessage(String boStatusMessage) {
            this.boStatusMessage = boStatusMessage;
            return this;
        }

        public Builder portalEnablementStatusCode(String portalEnablementStatusCode) {
            this.portalEnablementStatusCode = portalEnablementStatusCode;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder organizationType(String organizationType) {
            this.organizationType = organizationType;
            return this;
        }

        public Builder partyLinkType(String partyLinkType) {
            this.partyLinkType = partyLinkType;
            return this;
        }

        public Builder parentLinkType(String parentLinkType) {
            this.parentLinkType = parentLinkType;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder emailID(String emailID) {
            this.emailID = emailID;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            this.applicantParty = applicantParty;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public Builder currentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
            return this;
        }

        public Builder licenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
            return this;
        }

        public Builder panNo(String panNo) {
            this.panNo = panNo;
            return this;
        }

        public Builder address1(String address1) {
            this.address1 = address1;
            return this;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Builder cityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder pinCode(String pinCode) {
            this.pinCode = pinCode;
            return this;
        }

        public Builder identifierSubTypeCode(String identifierSubTypeCode) {
            this.identifierSubTypeCode = identifierSubTypeCode;
            return this;
        }

        public Builder identityNo(String identityNo) {
            this.identityNo = identityNo;
            return this;
        }

        public Builder issuerCode(String issuerCode) {
            this.issuerCode = issuerCode;
            return this;
        }

        public Builder issuerName(String issuerName) {
            this.issuerName = issuerName;
            return this;
        }

        public Builder roleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        public Builder productID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(String isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder orgTypeCode(String orgTypeCode) {
            this.orgTypeCode = orgTypeCode;
            return this;
        }

        public Builder orgSubTypeCode(String orgSubTypeCode) {
            this.orgSubTypeCode = orgSubTypeCode;
            return this;
        }

        public Builder userActionCode(String userActionCode) {
            this.userActionCode = userActionCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public FgOrganizationParty build() {
            return new FgOrganizationParty(ID, versionID, isMasterVersion, isoCode, languageCode, name, timeZoneCode, typeCode, subTypeCode, referenceID, abbvName, currencyCode, description, configStatusCode, ownerPartyCode, addlCode01, addlCode02, addlCode03, addlCode04, addlCode05, addlCode06, addlCode07, addlCode08, addlCode09, addlCode10, addlCode11, addlCode12, addlCode13, addlCode14, addlCode15, addlCode16, addlCode17, addlCode18, addlCode19, addlCode20, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, processID, branchName, branchCode, attachmentID, partySubTypeCode, democracyTypeCode, democracySubTypeCode, constitutionTypeCode, parentPartyCode, systemSourceCode, empCode, taskReasonCode, taskReasonText, masterTemplate, transactionType, regStatus, migrationStatusCode, migrationSysCode, migrationSysRefCode, migrationDatetime, stageCode, boStatusCode, boStatusReference, boStatusReasson, boStatusMessage, portalEnablementStatusCode, uuid, uploadRefID, organizationType, partyLinkType, parentLinkType, mobileNumber, emailID, firstName, lastName, applicantParty, gender, customerID, dob, currentAddress, licenseNo, panNo, address1, address2, cityCode, country, pinCode, identifierSubTypeCode, identityNo, issuerCode, issuerName, roleCode, productID, template, isTemplate, orgTypeCode, orgSubTypeCode, userActionCode, activeCode);
        }
    }
}
