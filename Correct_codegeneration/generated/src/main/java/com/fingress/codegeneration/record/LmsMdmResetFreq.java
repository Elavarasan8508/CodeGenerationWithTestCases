package com.bsit.codegeneration.record;

public record LmsMdmResetFreq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, String attachmentID, String parentID, String parentRefID, Long parentVersionID, Long isTemplate, Long tenorStartSlab, Long tenorEndSlab, String minTenorUomCode, String tenorSlabRuleExpression, Long resetValue, String resetPeriodUomCode, String resetDescription, String uploadRefID, String resetStatusCode, String ruleType, String segmentCode, String productCode, String subProductCode, String maxTenorUomCode, String segmentTeams) {

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

        private String attachmentID;

        private String parentID;

        private String parentRefID;

        private Long parentVersionID;

        private Long isTemplate;

        private Long tenorStartSlab;

        private Long tenorEndSlab;

        private String minTenorUomCode;

        private String tenorSlabRuleExpression;

        private Long resetValue;

        private String resetPeriodUomCode;

        private String resetDescription;

        private String uploadRefID;

        private String resetStatusCode;

        private String ruleType;

        private String segmentCode;

        private String productCode;

        private String subProductCode;

        private String maxTenorUomCode;

        private String segmentTeams;

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

        public Builder attachmentID(String attachmentID) {
            this.attachmentID = attachmentID;
            return this;
        }

        public Builder parentID(String parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder tenorStartSlab(Long tenorStartSlab) {
            this.tenorStartSlab = tenorStartSlab;
            return this;
        }

        public Builder tenorEndSlab(Long tenorEndSlab) {
            this.tenorEndSlab = tenorEndSlab;
            return this;
        }

        public Builder minTenorUomCode(String minTenorUomCode) {
            this.minTenorUomCode = minTenorUomCode;
            return this;
        }

        public Builder tenorSlabRuleExpression(String tenorSlabRuleExpression) {
            this.tenorSlabRuleExpression = tenorSlabRuleExpression;
            return this;
        }

        public Builder resetValue(Long resetValue) {
            this.resetValue = resetValue;
            return this;
        }

        public Builder resetPeriodUomCode(String resetPeriodUomCode) {
            this.resetPeriodUomCode = resetPeriodUomCode;
            return this;
        }

        public Builder resetDescription(String resetDescription) {
            this.resetDescription = resetDescription;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder resetStatusCode(String resetStatusCode) {
            this.resetStatusCode = resetStatusCode;
            return this;
        }

        public Builder ruleType(String ruleType) {
            this.ruleType = ruleType;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder maxTenorUomCode(String maxTenorUomCode) {
            this.maxTenorUomCode = maxTenorUomCode;
            return this;
        }

        public Builder segmentTeams(String segmentTeams) {
            this.segmentTeams = segmentTeams;
            return this;
        }

        public LmsMdmResetFreq build() {
            return new LmsMdmResetFreq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, attachmentID, parentID, parentRefID, parentVersionID, isTemplate, tenorStartSlab, tenorEndSlab, minTenorUomCode, tenorSlabRuleExpression, resetValue, resetPeriodUomCode, resetDescription, uploadRefID, resetStatusCode, ruleType, segmentCode, productCode, subProductCode, maxTenorUomCode, segmentTeams);
        }
    }
}
