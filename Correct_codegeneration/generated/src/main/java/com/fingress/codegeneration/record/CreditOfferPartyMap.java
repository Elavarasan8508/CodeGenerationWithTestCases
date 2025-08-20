package com.bsit.codegeneration.record;

public record CreditOfferPartyMap(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String processID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, String attachmentID, String parentID, String parentRefID, Long parentVersionID, Long isTemplate, String offerID, String mappingStatus, Long versionID, Long isMasterVersion, String uploadRefID, Long usageLimit, String customerID, String crnBor, String accNo, String roi, Long procFee, Long overallLimit, String portfolio, String productCode, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, String declarationType, String branchAddress, String branchLocation, String solid, String financialYear, String gstinNum, String typOfProcFee, Long minLoanAmt, Long maxLoanAmt, Long minTenureDays, Long maxTenureDays, String adhocType, Long existingFac, Long availableLoanLimit, Long sancLoanLimit, Long utlLoanDem, Long gst, Long spreadOfRoi, Long roiNextYr, String sancLtrRefno, Long roiBenchmark, String benchmark, Long adminChrgs, Long technicalFees, String remarks, Long gstNextYr, Long procFeesNextYr, String roiType, String msmeStatus, String pslStatus, String natureOfBusiness, String schemeCode, String limitID, String subsectorCode, String branchCode, String operationType, String userID, java.time.LocalDateTime uploadedDate, String subProductCode, String segmentCode, String segmentTeams, Long lineNo) {

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

        private String offerID;

        private String mappingStatus;

        private Long versionID;

        private Long isMasterVersion;

        private String uploadRefID;

        private Long usageLimit;

        private String customerID;

        private String crnBor;

        private String accNo;

        private String roi;

        private Long procFee;

        private Long overallLimit;

        private String portfolio;

        private String productCode;

        private java.time.LocalDateTime validFrom;

        private java.time.LocalDateTime validTo;

        private String declarationType;

        private String branchAddress;

        private String branchLocation;

        private String solid;

        private String financialYear;

        private String gstinNum;

        private String typOfProcFee;

        private Long minLoanAmt;

        private Long maxLoanAmt;

        private Long minTenureDays;

        private Long maxTenureDays;

        private String adhocType;

        private Long existingFac;

        private Long availableLoanLimit;

        private Long sancLoanLimit;

        private Long utlLoanDem;

        private Long gst;

        private Long spreadOfRoi;

        private Long roiNextYr;

        private String sancLtrRefno;

        private Long roiBenchmark;

        private String benchmark;

        private Long adminChrgs;

        private Long technicalFees;

        private String remarks;

        private Long gstNextYr;

        private Long procFeesNextYr;

        private String roiType;

        private String msmeStatus;

        private String pslStatus;

        private String natureOfBusiness;

        private String schemeCode;

        private String limitID;

        private String subsectorCode;

        private String branchCode;

        private String operationType;

        private String userID;

        private java.time.LocalDateTime uploadedDate;

        private String subProductCode;

        private String segmentCode;

        private String segmentTeams;

        private Long lineNo;

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

        public Builder offerID(String offerID) {
            this.offerID = offerID;
            return this;
        }

        public Builder mappingStatus(String mappingStatus) {
            this.mappingStatus = mappingStatus;
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

        public Builder usageLimit(Long usageLimit) {
            this.usageLimit = usageLimit;
            return this;
        }

        public Builder customerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder crnBor(String crnBor) {
            this.crnBor = crnBor;
            return this;
        }

        public Builder accNo(String accNo) {
            this.accNo = accNo;
            return this;
        }

        public Builder roi(String roi) {
            this.roi = roi;
            return this;
        }

        public Builder procFee(Long procFee) {
            this.procFee = procFee;
            return this;
        }

        public Builder overallLimit(Long overallLimit) {
            this.overallLimit = overallLimit;
            return this;
        }

        public Builder portfolio(String portfolio) {
            this.portfolio = portfolio;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder validFrom(java.time.LocalDateTime validFrom) {
            this.validFrom = validFrom;
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            this.validTo = validTo;
            return this;
        }

        public Builder declarationType(String declarationType) {
            this.declarationType = declarationType;
            return this;
        }

        public Builder branchAddress(String branchAddress) {
            this.branchAddress = branchAddress;
            return this;
        }

        public Builder branchLocation(String branchLocation) {
            this.branchLocation = branchLocation;
            return this;
        }

        public Builder solid(String solid) {
            this.solid = solid;
            return this;
        }

        public Builder financialYear(String financialYear) {
            this.financialYear = financialYear;
            return this;
        }

        public Builder gstinNum(String gstinNum) {
            this.gstinNum = gstinNum;
            return this;
        }

        public Builder typOfProcFee(String typOfProcFee) {
            this.typOfProcFee = typOfProcFee;
            return this;
        }

        public Builder minLoanAmt(Long minLoanAmt) {
            this.minLoanAmt = minLoanAmt;
            return this;
        }

        public Builder maxLoanAmt(Long maxLoanAmt) {
            this.maxLoanAmt = maxLoanAmt;
            return this;
        }

        public Builder minTenureDays(Long minTenureDays) {
            this.minTenureDays = minTenureDays;
            return this;
        }

        public Builder maxTenureDays(Long maxTenureDays) {
            this.maxTenureDays = maxTenureDays;
            return this;
        }

        public Builder adhocType(String adhocType) {
            this.adhocType = adhocType;
            return this;
        }

        public Builder existingFac(Long existingFac) {
            this.existingFac = existingFac;
            return this;
        }

        public Builder availableLoanLimit(Long availableLoanLimit) {
            this.availableLoanLimit = availableLoanLimit;
            return this;
        }

        public Builder sancLoanLimit(Long sancLoanLimit) {
            this.sancLoanLimit = sancLoanLimit;
            return this;
        }

        public Builder utlLoanDem(Long utlLoanDem) {
            this.utlLoanDem = utlLoanDem;
            return this;
        }

        public Builder gst(Long gst) {
            this.gst = gst;
            return this;
        }

        public Builder spreadOfRoi(Long spreadOfRoi) {
            this.spreadOfRoi = spreadOfRoi;
            return this;
        }

        public Builder roiNextYr(Long roiNextYr) {
            this.roiNextYr = roiNextYr;
            return this;
        }

        public Builder sancLtrRefno(String sancLtrRefno) {
            this.sancLtrRefno = sancLtrRefno;
            return this;
        }

        public Builder roiBenchmark(Long roiBenchmark) {
            this.roiBenchmark = roiBenchmark;
            return this;
        }

        public Builder benchmark(String benchmark) {
            this.benchmark = benchmark;
            return this;
        }

        public Builder adminChrgs(Long adminChrgs) {
            this.adminChrgs = adminChrgs;
            return this;
        }

        public Builder technicalFees(Long technicalFees) {
            this.technicalFees = technicalFees;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder gstNextYr(Long gstNextYr) {
            this.gstNextYr = gstNextYr;
            return this;
        }

        public Builder procFeesNextYr(Long procFeesNextYr) {
            this.procFeesNextYr = procFeesNextYr;
            return this;
        }

        public Builder roiType(String roiType) {
            this.roiType = roiType;
            return this;
        }

        public Builder msmeStatus(String msmeStatus) {
            this.msmeStatus = msmeStatus;
            return this;
        }

        public Builder pslStatus(String pslStatus) {
            this.pslStatus = pslStatus;
            return this;
        }

        public Builder natureOfBusiness(String natureOfBusiness) {
            this.natureOfBusiness = natureOfBusiness;
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            this.schemeCode = schemeCode;
            return this;
        }

        public Builder limitID(String limitID) {
            this.limitID = limitID;
            return this;
        }

        public Builder subsectorCode(String subsectorCode) {
            this.subsectorCode = subsectorCode;
            return this;
        }

        public Builder branchCode(String branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        public Builder operationType(String operationType) {
            this.operationType = operationType;
            return this;
        }

        public Builder userID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder uploadedDate(java.time.LocalDateTime uploadedDate) {
            this.uploadedDate = uploadedDate;
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            this.subProductCode = subProductCode;
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            this.segmentCode = segmentCode;
            return this;
        }

        public Builder segmentTeams(String segmentTeams) {
            this.segmentTeams = segmentTeams;
            return this;
        }

        public Builder lineNo(Long lineNo) {
            this.lineNo = lineNo;
            return this;
        }

        public CreditOfferPartyMap build() {
            return new CreditOfferPartyMap(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, processID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, applicantParty, fulfillmentParty, attachmentID, parentID, parentRefID, parentVersionID, isTemplate, offerID, mappingStatus, versionID, isMasterVersion, uploadRefID, usageLimit, customerID, crnBor, accNo, roi, procFee, overallLimit, portfolio, productCode, validFrom, validTo, declarationType, branchAddress, branchLocation, solid, financialYear, gstinNum, typOfProcFee, minLoanAmt, maxLoanAmt, minTenureDays, maxTenureDays, adhocType, existingFac, availableLoanLimit, sancLoanLimit, utlLoanDem, gst, spreadOfRoi, roiNextYr, sancLtrRefno, roiBenchmark, benchmark, adminChrgs, technicalFees, remarks, gstNextYr, procFeesNextYr, roiType, msmeStatus, pslStatus, natureOfBusiness, schemeCode, limitID, subsectorCode, branchCode, operationType, userID, uploadedDate, subProductCode, segmentCode, segmentTeams, lineNo);
        }
    }
}
