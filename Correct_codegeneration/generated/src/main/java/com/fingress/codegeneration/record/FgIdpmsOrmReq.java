package com.bsit.codegeneration.record;

public record FgIdpmsOrmReq(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String ormNumber, String adCode, Long ormAmount, Long ormUtilizedAmt, Long ormOsAmt, String ormCcy, java.time.LocalDateTime ormDate, String ieName, String ieCodeOrm, String beneName, String beneCountry, String remitterBankName, String purOfRemit, Long adjAmtOrm, String reasonIndicator, String remarksOrm, String paymentTerms, String parentRefID, Long parentVersionID, String trracsStatus, String trracsErrorCode, String trracsErrorDesc, String reqType, Long nameMatch, Long utilAmt, String approvedBy, String paymentParty, String portCode, String boeNumber, java.time.LocalDateTime boeDate, String adCodeBoe, String invoiceSlNo, String invNum, String docNo, java.time.LocalDateTime docDate, String closureIndicator, Long endorsedAmt, String finalErrorDesc, String finalStatus, String finalErrorCode, String letterNo, String rbiStatus, String rbiErrorDesc, String rbiErrorCode, java.time.LocalDateTime letterDate, String ieCode, String remittanceCurrency) {

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

        private String ieCodeOrm;

        private String beneName;

        private String beneCountry;

        private String remitterBankName;

        private String purOfRemit;

        private Long adjAmtOrm;

        private String reasonIndicator;

        private String remarksOrm;

        private String paymentTerms;

        private String parentRefID;

        private Long parentVersionID;

        private String trracsStatus;

        private String trracsErrorCode;

        private String trracsErrorDesc;

        private String reqType;

        private Long nameMatch;

        private Long utilAmt;

        private String approvedBy;

        private String paymentParty;

        private String portCode;

        private String boeNumber;

        private java.time.LocalDateTime boeDate;

        private String adCodeBoe;

        private String invoiceSlNo;

        private String invNum;

        private String docNo;

        private java.time.LocalDateTime docDate;

        private String closureIndicator;

        private Long endorsedAmt;

        private String finalErrorDesc;

        private String finalStatus;

        private String finalErrorCode;

        private String letterNo;

        private String rbiStatus;

        private String rbiErrorDesc;

        private String rbiErrorCode;

        private java.time.LocalDateTime letterDate;

        private String ieCode;

        private String remittanceCurrency;

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

        public Builder ieCodeOrm(String ieCodeOrm) {
            this.ieCodeOrm = ieCodeOrm;
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

        public Builder adjAmtOrm(Long adjAmtOrm) {
            this.adjAmtOrm = adjAmtOrm;
            return this;
        }

        public Builder reasonIndicator(String reasonIndicator) {
            this.reasonIndicator = reasonIndicator;
            return this;
        }

        public Builder remarksOrm(String remarksOrm) {
            this.remarksOrm = remarksOrm;
            return this;
        }

        public Builder paymentTerms(String paymentTerms) {
            this.paymentTerms = paymentTerms;
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

        public Builder trracsStatus(String trracsStatus) {
            this.trracsStatus = trracsStatus;
            return this;
        }

        public Builder trracsErrorCode(String trracsErrorCode) {
            this.trracsErrorCode = trracsErrorCode;
            return this;
        }

        public Builder trracsErrorDesc(String trracsErrorDesc) {
            this.trracsErrorDesc = trracsErrorDesc;
            return this;
        }

        public Builder reqType(String reqType) {
            this.reqType = reqType;
            return this;
        }

        public Builder nameMatch(Long nameMatch) {
            this.nameMatch = nameMatch;
            return this;
        }

        public Builder utilAmt(Long utilAmt) {
            this.utilAmt = utilAmt;
            return this;
        }

        public Builder approvedBy(String approvedBy) {
            this.approvedBy = approvedBy;
            return this;
        }

        public Builder paymentParty(String paymentParty) {
            this.paymentParty = paymentParty;
            return this;
        }

        public Builder portCode(String portCode) {
            this.portCode = portCode;
            return this;
        }

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder adCodeBoe(String adCodeBoe) {
            this.adCodeBoe = adCodeBoe;
            return this;
        }

        public Builder invoiceSlNo(String invoiceSlNo) {
            this.invoiceSlNo = invoiceSlNo;
            return this;
        }

        public Builder invNum(String invNum) {
            this.invNum = invNum;
            return this;
        }

        public Builder docNo(String docNo) {
            this.docNo = docNo;
            return this;
        }

        public Builder docDate(java.time.LocalDateTime docDate) {
            this.docDate = docDate;
            return this;
        }

        public Builder closureIndicator(String closureIndicator) {
            this.closureIndicator = closureIndicator;
            return this;
        }

        public Builder endorsedAmt(Long endorsedAmt) {
            this.endorsedAmt = endorsedAmt;
            return this;
        }

        public Builder finalErrorDesc(String finalErrorDesc) {
            this.finalErrorDesc = finalErrorDesc;
            return this;
        }

        public Builder finalStatus(String finalStatus) {
            this.finalStatus = finalStatus;
            return this;
        }

        public Builder finalErrorCode(String finalErrorCode) {
            this.finalErrorCode = finalErrorCode;
            return this;
        }

        public Builder letterNo(String letterNo) {
            this.letterNo = letterNo;
            return this;
        }

        public Builder rbiStatus(String rbiStatus) {
            this.rbiStatus = rbiStatus;
            return this;
        }

        public Builder rbiErrorDesc(String rbiErrorDesc) {
            this.rbiErrorDesc = rbiErrorDesc;
            return this;
        }

        public Builder rbiErrorCode(String rbiErrorCode) {
            this.rbiErrorCode = rbiErrorCode;
            return this;
        }

        public Builder letterDate(java.time.LocalDateTime letterDate) {
            this.letterDate = letterDate;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder remittanceCurrency(String remittanceCurrency) {
            this.remittanceCurrency = remittanceCurrency;
            return this;
        }

        public FgIdpmsOrmReq build() {
            return new FgIdpmsOrmReq(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, ormNumber, adCode, ormAmount, ormUtilizedAmt, ormOsAmt, ormCcy, ormDate, ieName, ieCodeOrm, beneName, beneCountry, remitterBankName, purOfRemit, adjAmtOrm, reasonIndicator, remarksOrm, paymentTerms, parentRefID, parentVersionID, trracsStatus, trracsErrorCode, trracsErrorDesc, reqType, nameMatch, utilAmt, approvedBy, paymentParty, portCode, boeNumber, boeDate, adCodeBoe, invoiceSlNo, invNum, docNo, docDate, closureIndicator, endorsedAmt, finalErrorDesc, finalStatus, finalErrorCode, letterNo, rbiStatus, rbiErrorDesc, rbiErrorCode, letterDate, ieCode, remittanceCurrency);
        }
    }
}
