package com.bsit.codegeneration.record;

public record FgTrdFxRate(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String dealReference, String buyingCur, Long buyingAmt, String sellingCur, Long sellingAmt, Long fxRate, String parentRefID, Long parentVersionID, Long fxAmt, String irReferenceID, String dealType) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String dealReference;

        private String buyingCur;

        private Long buyingAmt;

        private String sellingCur;

        private Long sellingAmt;

        private Long fxRate;

        private String parentRefID;

        private Long parentVersionID;

        private Long fxAmt;

        private String irReferenceID;

        private String dealType;

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

        public Builder dealReference(String dealReference) {
            this.dealReference = dealReference;
            return this;
        }

        public Builder buyingCur(String buyingCur) {
            this.buyingCur = buyingCur;
            return this;
        }

        public Builder buyingAmt(Long buyingAmt) {
            this.buyingAmt = buyingAmt;
            return this;
        }

        public Builder sellingCur(String sellingCur) {
            this.sellingCur = sellingCur;
            return this;
        }

        public Builder sellingAmt(Long sellingAmt) {
            this.sellingAmt = sellingAmt;
            return this;
        }

        public Builder fxRate(Long fxRate) {
            this.fxRate = fxRate;
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

        public Builder fxAmt(Long fxAmt) {
            this.fxAmt = fxAmt;
            return this;
        }

        public Builder irReferenceID(String irReferenceID) {
            this.irReferenceID = irReferenceID;
            return this;
        }

        public Builder dealType(String dealType) {
            this.dealType = dealType;
            return this;
        }

        public FgTrdFxRate build() {
            return new FgTrdFxRate(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, dealReference, buyingCur, buyingAmt, sellingCur, sellingAmt, fxRate, parentRefID, parentVersionID, fxAmt, irReferenceID, dealType);
        }
    }
}
