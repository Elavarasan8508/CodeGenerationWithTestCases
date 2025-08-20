package com.bsit.codegeneration.record;

public record FgOrmData(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String ormNumber, String adCode, Long ormAmount, Long ormUtilizedAmt, Long ormOsAmt, String ormCcy, java.time.LocalDateTime ormDate, String ieName, String ieCode, String beneName, String beneCountry, String remitterBankName, String purOfRemit) {

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

        private String ormNumber;

        private String adCode;

        private Long ormAmount;

        private Long ormUtilizedAmt;

        private Long ormOsAmt;

        private String ormCcy;

        private java.time.LocalDateTime ormDate;

        private String ieName;

        private String ieCode;

        private String beneName;

        private String beneCountry;

        private String remitterBankName;

        private String purOfRemit;

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

        public Builder ormNumber(String ormNumber) {
            this.ormNumber = ormNumber;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder ormAmount(Long ormAmount) {
            this.ormAmount = ormAmount;
            return this;
        }

        public Builder ormUtilizedAmt(Long ormUtilizedAmt) {
            this.ormUtilizedAmt = ormUtilizedAmt;
            return this;
        }

        public Builder ormOsAmt(Long ormOsAmt) {
            this.ormOsAmt = ormOsAmt;
            return this;
        }

        public Builder ormCcy(String ormCcy) {
            this.ormCcy = ormCcy;
            return this;
        }

        public Builder ormDate(java.time.LocalDateTime ormDate) {
            this.ormDate = ormDate;
            return this;
        }

        public Builder ieName(String ieName) {
            this.ieName = ieName;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder beneName(String beneName) {
            this.beneName = beneName;
            return this;
        }

        public Builder beneCountry(String beneCountry) {
            this.beneCountry = beneCountry;
            return this;
        }

        public Builder remitterBankName(String remitterBankName) {
            this.remitterBankName = remitterBankName;
            return this;
        }

        public Builder purOfRemit(String purOfRemit) {
            this.purOfRemit = purOfRemit;
            return this;
        }

        public FgOrmData build() {
            return new FgOrmData(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, ormNumber, adCode, ormAmount, ormUtilizedAmt, ormOsAmt, ormCcy, ormDate, ieName, ieCode, beneName, beneCountry, remitterBankName, purOfRemit);
        }
    }
}
