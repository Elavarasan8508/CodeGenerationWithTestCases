package com.bsit.codegeneration.record;

public record KmblScfCounterpartyRel(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String cpAbbvName, String cpName, String cpCode, String cpRole, String cpRateType, String cpLimitNode2, String cpAccountNumber, String cpIfscCode, String cpBankName, String cpPaymentType, String cpIntType, String cpPenalSpread, String cpBaseCode, Long versionID, Long isMasterVersion, String displayStatus, String intBearingParty, String abbvName, String customerRole, String productType, String layoutName, String portalRefID, String taskReason, Long cpGracePeriod, Long cpSpreadRate, Long cpMarginRate, String uploadRefID, String dmsEventID, String cpBeneLei, String requestInitiationType, String programLayoutName, String layoutID, String layoutUuid) {

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

        private Long isTemplate;

        private String cpAbbvName;

        private String cpName;

        private String cpCode;

        private String cpRole;

        private String cpRateType;

        private String cpLimitNode2;

        private String cpAccountNumber;

        private String cpIfscCode;

        private String cpBankName;

        private String cpPaymentType;

        private String cpIntType;

        private String cpPenalSpread;

        private String cpBaseCode;

        private Long versionID;

        private Long isMasterVersion;

        private String displayStatus;

        private String intBearingParty;

        private String abbvName;

        private String customerRole;

        private String productType;

        private String layoutName;

        private String portalRefID;

        private String taskReason;

        private Long cpGracePeriod;

        private Long cpSpreadRate;

        private Long cpMarginRate;

        private String uploadRefID;

        private String dmsEventID;

        private String cpBeneLei;

        private String requestInitiationType;

        private String programLayoutName;

        private String layoutID;

        private String layoutUuid;

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

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
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

        public Builder cpRateType(String cpRateType) {
            this.cpRateType = cpRateType;
            return this;
        }

        public Builder cpLimitNode2(String cpLimitNode2) {
            this.cpLimitNode2 = cpLimitNode2;
            return this;
        }

        public Builder cpAccountNumber(String cpAccountNumber) {
            this.cpAccountNumber = cpAccountNumber;
            return this;
        }

        public Builder cpIfscCode(String cpIfscCode) {
            this.cpIfscCode = cpIfscCode;
            return this;
        }

        public Builder cpBankName(String cpBankName) {
            this.cpBankName = cpBankName;
            return this;
        }

        public Builder cpPaymentType(String cpPaymentType) {
            this.cpPaymentType = cpPaymentType;
            return this;
        }

        public Builder cpIntType(String cpIntType) {
            this.cpIntType = cpIntType;
            return this;
        }

        public Builder cpPenalSpread(String cpPenalSpread) {
            this.cpPenalSpread = cpPenalSpread;
            return this;
        }

        public Builder cpBaseCode(String cpBaseCode) {
            this.cpBaseCode = cpBaseCode;
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

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder intBearingParty(String intBearingParty) {
            this.intBearingParty = intBearingParty;
            return this;
        }

        public Builder abbvName(String abbvName) {
            this.abbvName = abbvName;
            return this;
        }

        public Builder customerRole(String customerRole) {
            this.customerRole = customerRole;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder portalRefID(String portalRefID) {
            this.portalRefID = portalRefID;
            return this;
        }

        public Builder taskReason(String taskReason) {
            this.taskReason = taskReason;
            return this;
        }

        public Builder cpGracePeriod(Long cpGracePeriod) {
            this.cpGracePeriod = cpGracePeriod;
            return this;
        }

        public Builder cpSpreadRate(Long cpSpreadRate) {
            this.cpSpreadRate = cpSpreadRate;
            return this;
        }

        public Builder cpMarginRate(Long cpMarginRate) {
            this.cpMarginRate = cpMarginRate;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder dmsEventID(String dmsEventID) {
            this.dmsEventID = dmsEventID;
            return this;
        }

        public Builder cpBeneLei(String cpBeneLei) {
            this.cpBeneLei = cpBeneLei;
            return this;
        }

        public Builder requestInitiationType(String requestInitiationType) {
            this.requestInitiationType = requestInitiationType;
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

        public KmblScfCounterpartyRel build() {
            return new KmblScfCounterpartyRel(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, cpAbbvName, cpName, cpCode, cpRole, cpRateType, cpLimitNode2, cpAccountNumber, cpIfscCode, cpBankName, cpPaymentType, cpIntType, cpPenalSpread, cpBaseCode, versionID, isMasterVersion, displayStatus, intBearingParty, abbvName, customerRole, productType, layoutName, portalRefID, taskReason, cpGracePeriod, cpSpreadRate, cpMarginRate, uploadRefID, dmsEventID, cpBeneLei, requestInitiationType, programLayoutName, layoutID, layoutUuid);
        }
    }
}
