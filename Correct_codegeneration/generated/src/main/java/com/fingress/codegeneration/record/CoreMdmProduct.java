package com.bsit.codegeneration.record;

public record CoreMdmProduct(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Long isTemplate, String productCode, String productName, String productStatusCode, String productDescription, String borrowerParty, Long assetLiabilityApplicable, Long creditLineApplicable, Long exposureMaintenanceReq, String invoiceRaisedBy, String financeRequestBy, Long interestCalculation, Long accrualAmortize, String anchorParty, String financeDebitParty, String financeToParty, String segmentCode, Long cutoffApplicable, Long chargesApplicable, Long holidayApplicable, Long allowPayment, Long allowCollection, String baShortName, String productGroupCode, String productSubgroupCode, String classification, Long versionID, Long isMasterVersion, String uploadRefID) {

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

        private String productCode;

        private String productName;

        private String productStatusCode;

        private String productDescription;

        private String borrowerParty;

        private Long assetLiabilityApplicable;

        private Long creditLineApplicable;

        private Long exposureMaintenanceReq;

        private String invoiceRaisedBy;

        private String financeRequestBy;

        private Long interestCalculation;

        private Long accrualAmortize;

        private String anchorParty;

        private String financeDebitParty;

        private String financeToParty;

        private String segmentCode;

        private Long cutoffApplicable;

        private Long chargesApplicable;

        private Long holidayApplicable;

        private Long allowPayment;

        private Long allowCollection;

        private String baShortName;

        private String productGroupCode;

        private String productSubgroupCode;

        private String classification;

        private Long versionID;

        private Long isMasterVersion;

        private String uploadRefID;

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

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            this.productStatusCode = productStatusCode;
            return this;
        }

        public Builder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder borrowerParty(String borrowerParty) {
            this.borrowerParty = borrowerParty;
            return this;
        }

        public Builder assetLiabilityApplicable(Long assetLiabilityApplicable) {
            this.assetLiabilityApplicable = assetLiabilityApplicable;
            return this;
        }

        public Builder creditLineApplicable(Long creditLineApplicable) {
            this.creditLineApplicable = creditLineApplicable;
            return this;
        }

        public Builder exposureMaintenanceReq(Long exposureMaintenanceReq) {
            this.exposureMaintenanceReq = exposureMaintenanceReq;
            return this;
        }

        public Builder invoiceRaisedBy(String invoiceRaisedBy) {
            this.invoiceRaisedBy = invoiceRaisedBy;
            return this;
        }

        public Builder financeRequestBy(String financeRequestBy) {
            this.financeRequestBy = financeRequestBy;
            return this;
        }

        public Builder interestCalculation(Long interestCalculation) {
            this.interestCalculation = interestCalculation;
            return this;
        }

        public Builder accrualAmortize(Long accrualAmortize) {
            this.accrualAmortize = accrualAmortize;
            return this;
        }

        public Builder anchorParty(String anchorParty) {
            this.anchorParty = anchorParty;
            return this;
        }

        public Builder financeDebitParty(String financeDebitParty) {
            this.financeDebitParty = financeDebitParty;
            return this;
        }

        public Builder financeToParty(String financeToParty) {
            this.financeToParty = financeToParty;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
            return this;
        }

        public Builder cutoffApplicable(Long cutoffApplicable) {
            this.cutoffApplicable = cutoffApplicable;
            return this;
        }

        public Builder chargesApplicable(Long chargesApplicable) {
            this.chargesApplicable = chargesApplicable;
            return this;
        }

        public Builder holidayApplicable(Long holidayApplicable) {
            this.holidayApplicable = holidayApplicable;
            return this;
        }

        public Builder allowPayment(Long allowPayment) {
            this.allowPayment = allowPayment;
            return this;
        }

        public Builder allowCollection(Long allowCollection) {
            this.allowCollection = allowCollection;
            return this;
        }

        public Builder baShortName(String baShortName) {
            this.baShortName = baShortName;
            return this;
        }

        public Builder productGroupCode(String productGroupCode) {
            this.productGroupCode = productGroupCode;
            return this;
        }

        public Builder productSubgroupCode(String productSubgroupCode) {
            this.productSubgroupCode = productSubgroupCode;
            return this;
        }

        public Builder classification(String classification) {
            this.classification = classification;
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

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public CoreMdmProduct build() {
            return new CoreMdmProduct(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, isTemplate, productCode, productName, productStatusCode, productDescription, borrowerParty, assetLiabilityApplicable, creditLineApplicable, exposureMaintenanceReq, invoiceRaisedBy, financeRequestBy, interestCalculation, accrualAmortize, anchorParty, financeDebitParty, financeToParty, segmentCode, cutoffApplicable, chargesApplicable, holidayApplicable, allowPayment, allowCollection, baShortName, productGroupCode, productSubgroupCode, classification, versionID, isMasterVersion, uploadRefID);
        }
    }
}
