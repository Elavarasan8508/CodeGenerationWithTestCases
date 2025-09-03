package com.bsit.codegeneration.record;

import java.util.List;

public record LimitRenewalOffer(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, Long lob, Long crnBor, Integer prospectID, java.time.LocalDateTime validTo, Long procFee, Long procFeeGst, Long alreadyCollected, Long alreadyCollectedGst, Long balCollected, Long balCollectedGst, Long adminChrgs, Long adminChrgsGst, Long technicalFees, Long technicalFeesGst, java.time.LocalDateTime nextReviewDate, java.time.LocalDateTime lastReviewDate, String varLimitApplicable, String gmlLimitApplicable, String cgtmse, String remarks, String termLoan, String sidbi, String ccod, String seasonalAdHoc, String crnName, Integer versionID, Long isMasterVersion, Long adminCharges, Long adminChargesGst) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private Integer processID;

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

        private Long lob;

        private Long crnBor;

        private Integer prospectID;

        private java.time.LocalDateTime validTo;

        private Long procFee;

        private Long procFeeGst;

        private Long alreadyCollected;

        private Long alreadyCollectedGst;

        private Long balCollected;

        private Long balCollectedGst;

        private Long adminChrgs;

        private Long adminChrgsGst;

        private Long technicalFees;

        private Long technicalFeesGst;

        private java.time.LocalDateTime nextReviewDate;

        private java.time.LocalDateTime lastReviewDate;

        private String varLimitApplicable;

        private String gmlLimitApplicable;

        private String cgtmse;

        private String remarks;

        private String termLoan;

        private String sidbi;

        private String ccod;

        private String seasonalAdHoc;

        private String crnName;

        private Integer versionID;

        private Long isMasterVersion;

        private Long adminCharges;

        private Long adminChargesGst;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
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

        public Builder processID(Integer processID) {
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

        public Builder lob(Long lob) {
            this.lob = lob;
            return this;
        }

        public Builder crnBor(Long crnBor) {
            this.crnBor = crnBor;
            return this;
        }

        public Builder prospectID(Integer prospectID) {
            this.prospectID = prospectID;
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            this.validTo = validTo;
            return this;
        }

        public Builder procFee(Long procFee) {
            this.procFee = procFee;
            return this;
        }

        public Builder procFeeGst(Long procFeeGst) {
            this.procFeeGst = procFeeGst;
            return this;
        }

        public Builder alreadyCollected(Long alreadyCollected) {
            this.alreadyCollected = alreadyCollected;
            return this;
        }

        public Builder alreadyCollectedGst(Long alreadyCollectedGst) {
            this.alreadyCollectedGst = alreadyCollectedGst;
            return this;
        }

        public Builder balCollected(Long balCollected) {
            this.balCollected = balCollected;
            return this;
        }

        public Builder balCollectedGst(Long balCollectedGst) {
            this.balCollectedGst = balCollectedGst;
            return this;
        }

        public Builder adminChrgs(Long adminChrgs) {
            this.adminChrgs = adminChrgs;
            return this;
        }

        public Builder adminChrgsGst(Long adminChrgsGst) {
            this.adminChrgsGst = adminChrgsGst;
            return this;
        }

        public Builder technicalFees(Long technicalFees) {
            this.technicalFees = technicalFees;
            return this;
        }

        public Builder technicalFeesGst(Long technicalFeesGst) {
            this.technicalFeesGst = technicalFeesGst;
            return this;
        }

        public Builder nextReviewDate(java.time.LocalDateTime nextReviewDate) {
            this.nextReviewDate = nextReviewDate;
            return this;
        }

        public Builder lastReviewDate(java.time.LocalDateTime lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        public Builder varLimitApplicable(String varLimitApplicable) {
            this.varLimitApplicable = varLimitApplicable;
            return this;
        }

        public Builder gmlLimitApplicable(String gmlLimitApplicable) {
            this.gmlLimitApplicable = gmlLimitApplicable;
            return this;
        }

        public Builder cgtmse(String cgtmse) {
            this.cgtmse = cgtmse;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder termLoan(String termLoan) {
            this.termLoan = termLoan;
            return this;
        }

        public Builder sidbi(String sidbi) {
            this.sidbi = sidbi;
            return this;
        }

        public Builder ccod(String ccod) {
            this.ccod = ccod;
            return this;
        }

        public Builder seasonalAdHoc(String seasonalAdHoc) {
            this.seasonalAdHoc = seasonalAdHoc;
            return this;
        }

        public Builder crnName(String crnName) {
            this.crnName = crnName;
            return this;
        }

        public Builder versionID(Integer versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder adminCharges(Long adminCharges) {
            this.adminCharges = adminCharges;
            return this;
        }

        public Builder adminChargesGst(Long adminChargesGst) {
            this.adminChargesGst = adminChargesGst;
            return this;
        }

        public LimitRenewalOffer build() {
            return new LimitRenewalOffer(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, lob, crnBor, prospectID, validTo, procFee, procFeeGst, alreadyCollected, alreadyCollectedGst, balCollected, balCollectedGst, adminChrgs, adminChrgsGst, technicalFees, technicalFeesGst, nextReviewDate, lastReviewDate, varLimitApplicable, gmlLimitApplicable, cgtmse, remarks, termLoan, sidbi, ccod, seasonalAdHoc, crnName, versionID, isMasterVersion, adminCharges, adminChargesGst);
        }
    }
}
