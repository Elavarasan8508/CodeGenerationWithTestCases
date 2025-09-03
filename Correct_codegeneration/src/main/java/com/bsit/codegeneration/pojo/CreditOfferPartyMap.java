package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditOfferPartyMap {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private String applicantParty;

    private String fulfillmentParty;

    private Integer attachmentID;

    private Integer parentID;

    private Integer parentRefID;

    private Integer parentVersionID;

    private Integer isTemplate;

    private Integer offerID;

    private String mappingStatus;

    private Integer versionID;

    private Integer isMasterVersion;

    private Integer uploadRefID;

    private Long usageLimit;

    private Integer customerID;

    private String crnBor;

    private String accNo;

    private String roi;

    private java.math.BigDecimal procFee;

    private java.math.BigDecimal overallLimit;

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

    private java.math.BigDecimal typOfProcFee;

    private java.math.BigDecimal minLoanAmt;

    private java.math.BigDecimal maxLoanAmt;

    private Long minTenureDays;

    private Long maxTenureDays;

    private String adhocType;

    private java.math.BigDecimal existingFac;

    private java.math.BigDecimal availableLoanLimit;

    private java.math.BigDecimal sancLoanLimit;

    private java.math.BigDecimal utlLoanDem;

    private java.math.BigDecimal gst;

    private java.math.BigDecimal spreadOfRoi;

    private java.math.BigDecimal roiNextYr;

    private String sancLtrRefno;

    private java.math.BigDecimal roiBenchmark;

    private String benchmark;

    private java.math.BigDecimal adminChrgs;

    private java.math.BigDecimal technicalFees;

    private String remarks;

    private java.math.BigDecimal gstNextYr;

    private java.math.BigDecimal procFeesNextYr;

    private String roiType;

    private String msmeStatus;

    private String pslStatus;

    private String natureOfBusiness;

    private String schemeCode;

    private Integer limitID;

    private String subsectorCode;

    private String branchCode;

    private String operationType;

    private Integer userID;

    private java.time.LocalDateTime uploadedDate;

    private String subProductCode;

    private String segmentCode;

    private String segmentTeams;

    private Long lineNo;

    public CreditOfferPartyMap() {
    }

    public CreditOfferPartyMap(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer attachmentID, Integer parentID, Integer parentRefID, Integer parentVersionID, Integer isTemplate, Integer offerID, String mappingStatus, Integer versionID, Integer isMasterVersion, Integer uploadRefID, Long usageLimit, Integer customerID, String crnBor, String accNo, String roi, java.math.BigDecimal procFee, java.math.BigDecimal overallLimit, String portfolio, String productCode, java.time.LocalDateTime validFrom, java.time.LocalDateTime validTo, String declarationType, String branchAddress, String branchLocation, String solid, String financialYear, String gstinNum, java.math.BigDecimal typOfProcFee, java.math.BigDecimal minLoanAmt, java.math.BigDecimal maxLoanAmt, Long minTenureDays, Long maxTenureDays, String adhocType, java.math.BigDecimal existingFac, java.math.BigDecimal availableLoanLimit, java.math.BigDecimal sancLoanLimit, java.math.BigDecimal utlLoanDem, java.math.BigDecimal gst, java.math.BigDecimal spreadOfRoi, java.math.BigDecimal roiNextYr, String sancLtrRefno, java.math.BigDecimal roiBenchmark, String benchmark, java.math.BigDecimal adminChrgs, java.math.BigDecimal technicalFees, String remarks, java.math.BigDecimal gstNextYr, java.math.BigDecimal procFeesNextYr, String roiType, String msmeStatus, String pslStatus, String natureOfBusiness, String schemeCode, Integer limitID, String subsectorCode, String branchCode, String operationType, Integer userID, java.time.LocalDateTime uploadedDate, String subProductCode, String segmentCode, String segmentTeams, Long lineNo) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
        this.attachmentID = attachmentID;
        this.parentID = parentID;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.isTemplate = isTemplate;
        this.offerID = offerID;
        this.mappingStatus = mappingStatus;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.uploadRefID = uploadRefID;
        this.usageLimit = usageLimit;
        this.customerID = customerID;
        this.crnBor = crnBor;
        this.accNo = accNo;
        this.roi = roi;
        this.procFee = procFee;
        this.overallLimit = overallLimit;
        this.portfolio = portfolio;
        this.productCode = productCode;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.declarationType = declarationType;
        this.branchAddress = branchAddress;
        this.branchLocation = branchLocation;
        this.solid = solid;
        this.financialYear = financialYear;
        this.gstinNum = gstinNum;
        this.typOfProcFee = typOfProcFee;
        this.minLoanAmt = minLoanAmt;
        this.maxLoanAmt = maxLoanAmt;
        this.minTenureDays = minTenureDays;
        this.maxTenureDays = maxTenureDays;
        this.adhocType = adhocType;
        this.existingFac = existingFac;
        this.availableLoanLimit = availableLoanLimit;
        this.sancLoanLimit = sancLoanLimit;
        this.utlLoanDem = utlLoanDem;
        this.gst = gst;
        this.spreadOfRoi = spreadOfRoi;
        this.roiNextYr = roiNextYr;
        this.sancLtrRefno = sancLtrRefno;
        this.roiBenchmark = roiBenchmark;
        this.benchmark = benchmark;
        this.adminChrgs = adminChrgs;
        this.technicalFees = technicalFees;
        this.remarks = remarks;
        this.gstNextYr = gstNextYr;
        this.procFeesNextYr = procFeesNextYr;
        this.roiType = roiType;
        this.msmeStatus = msmeStatus;
        this.pslStatus = pslStatus;
        this.natureOfBusiness = natureOfBusiness;
        this.schemeCode = schemeCode;
        this.limitID = limitID;
        this.subsectorCode = subsectorCode;
        this.branchCode = branchCode;
        this.operationType = operationType;
        this.userID = userID;
        this.uploadedDate = uploadedDate;
        this.subProductCode = subProductCode;
        this.segmentCode = segmentCode;
        this.segmentTeams = segmentTeams;
        this.lineNo = lineNo;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public Integer getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(Integer attachmentID) {
        this.attachmentID = attachmentID;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public Integer getOfferID() {
        return offerID;
    }

    public void setOfferID(Integer offerID) {
        this.offerID = offerID;
    }

    public String getMappingStatus() {
        return mappingStatus;
    }

    public void setMappingStatus(String mappingStatus) {
        this.mappingStatus = mappingStatus;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Long getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(Long usageLimit) {
        this.usageLimit = usageLimit;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCrnBor() {
        return crnBor;
    }

    public void setCrnBor(String crnBor) {
        this.crnBor = crnBor;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getRoi() {
        return roi;
    }

    public void setRoi(String roi) {
        this.roi = roi;
    }

    public java.math.BigDecimal getProcFee() {
        return procFee;
    }

    public void setProcFee(java.math.BigDecimal procFee) {
        this.procFee = procFee;
    }

    public java.math.BigDecimal getOverallLimit() {
        return overallLimit;
    }

    public void setOverallLimit(java.math.BigDecimal overallLimit) {
        this.overallLimit = overallLimit;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public java.time.LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(java.time.LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public java.time.LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(java.time.LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public String getDeclarationType() {
        return declarationType;
    }

    public void setDeclarationType(String declarationType) {
        this.declarationType = declarationType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getSolid() {
        return solid;
    }

    public void setSolid(String solid) {
        this.solid = solid;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public String getGstinNum() {
        return gstinNum;
    }

    public void setGstinNum(String gstinNum) {
        this.gstinNum = gstinNum;
    }

    public java.math.BigDecimal getTypOfProcFee() {
        return typOfProcFee;
    }

    public void setTypOfProcFee(java.math.BigDecimal typOfProcFee) {
        this.typOfProcFee = typOfProcFee;
    }

    public java.math.BigDecimal getMinLoanAmt() {
        return minLoanAmt;
    }

    public void setMinLoanAmt(java.math.BigDecimal minLoanAmt) {
        this.minLoanAmt = minLoanAmt;
    }

    public java.math.BigDecimal getMaxLoanAmt() {
        return maxLoanAmt;
    }

    public void setMaxLoanAmt(java.math.BigDecimal maxLoanAmt) {
        this.maxLoanAmt = maxLoanAmt;
    }

    public Long getMinTenureDays() {
        return minTenureDays;
    }

    public void setMinTenureDays(Long minTenureDays) {
        this.minTenureDays = minTenureDays;
    }

    public Long getMaxTenureDays() {
        return maxTenureDays;
    }

    public void setMaxTenureDays(Long maxTenureDays) {
        this.maxTenureDays = maxTenureDays;
    }

    public String getAdhocType() {
        return adhocType;
    }

    public void setAdhocType(String adhocType) {
        this.adhocType = adhocType;
    }

    public java.math.BigDecimal getExistingFac() {
        return existingFac;
    }

    public void setExistingFac(java.math.BigDecimal existingFac) {
        this.existingFac = existingFac;
    }

    public java.math.BigDecimal getAvailableLoanLimit() {
        return availableLoanLimit;
    }

    public void setAvailableLoanLimit(java.math.BigDecimal availableLoanLimit) {
        this.availableLoanLimit = availableLoanLimit;
    }

    public java.math.BigDecimal getSancLoanLimit() {
        return sancLoanLimit;
    }

    public void setSancLoanLimit(java.math.BigDecimal sancLoanLimit) {
        this.sancLoanLimit = sancLoanLimit;
    }

    public java.math.BigDecimal getUtlLoanDem() {
        return utlLoanDem;
    }

    public void setUtlLoanDem(java.math.BigDecimal utlLoanDem) {
        this.utlLoanDem = utlLoanDem;
    }

    public java.math.BigDecimal getGst() {
        return gst;
    }

    public void setGst(java.math.BigDecimal gst) {
        this.gst = gst;
    }

    public java.math.BigDecimal getSpreadOfRoi() {
        return spreadOfRoi;
    }

    public void setSpreadOfRoi(java.math.BigDecimal spreadOfRoi) {
        this.spreadOfRoi = spreadOfRoi;
    }

    public java.math.BigDecimal getRoiNextYr() {
        return roiNextYr;
    }

    public void setRoiNextYr(java.math.BigDecimal roiNextYr) {
        this.roiNextYr = roiNextYr;
    }

    public String getSancLtrRefno() {
        return sancLtrRefno;
    }

    public void setSancLtrRefno(String sancLtrRefno) {
        this.sancLtrRefno = sancLtrRefno;
    }

    public java.math.BigDecimal getRoiBenchmark() {
        return roiBenchmark;
    }

    public void setRoiBenchmark(java.math.BigDecimal roiBenchmark) {
        this.roiBenchmark = roiBenchmark;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public java.math.BigDecimal getAdminChrgs() {
        return adminChrgs;
    }

    public void setAdminChrgs(java.math.BigDecimal adminChrgs) {
        this.adminChrgs = adminChrgs;
    }

    public java.math.BigDecimal getTechnicalFees() {
        return technicalFees;
    }

    public void setTechnicalFees(java.math.BigDecimal technicalFees) {
        this.technicalFees = technicalFees;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public java.math.BigDecimal getGstNextYr() {
        return gstNextYr;
    }

    public void setGstNextYr(java.math.BigDecimal gstNextYr) {
        this.gstNextYr = gstNextYr;
    }

    public java.math.BigDecimal getProcFeesNextYr() {
        return procFeesNextYr;
    }

    public void setProcFeesNextYr(java.math.BigDecimal procFeesNextYr) {
        this.procFeesNextYr = procFeesNextYr;
    }

    public String getRoiType() {
        return roiType;
    }

    public void setRoiType(String roiType) {
        this.roiType = roiType;
    }

    public String getMsmeStatus() {
        return msmeStatus;
    }

    public void setMsmeStatus(String msmeStatus) {
        this.msmeStatus = msmeStatus;
    }

    public String getPslStatus() {
        return pslStatus;
    }

    public void setPslStatus(String pslStatus) {
        this.pslStatus = pslStatus;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public Integer getLimitID() {
        return limitID;
    }

    public void setLimitID(Integer limitID) {
        this.limitID = limitID;
    }

    public String getSubsectorCode() {
        return subsectorCode;
    }

    public void setSubsectorCode(String subsectorCode) {
        this.subsectorCode = subsectorCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public java.time.LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(java.time.LocalDateTime uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getSubProductCode() {
        return subProductCode;
    }

    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getSegmentTeams() {
        return segmentTeams;
    }

    public void setSegmentTeams(String segmentTeams) {
        this.segmentTeams = segmentTeams;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public static class Builder {

        private CreditOfferPartyMap instance = new CreditOfferPartyMap();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public Builder attachmentID(Integer attachmentID) {
            instance.setAttachmentID(attachmentID);
            return this;
        }

        public Builder parentID(Integer parentID) {
            instance.setParentID(parentID);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder offerID(Integer offerID) {
            instance.setOfferID(offerID);
            return this;
        }

        public Builder mappingStatus(String mappingStatus) {
            instance.setMappingStatus(mappingStatus);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder usageLimit(Long usageLimit) {
            instance.setUsageLimit(usageLimit);
            return this;
        }

        public Builder customerID(Integer customerID) {
            instance.setCustomerID(customerID);
            return this;
        }

        public Builder crnBor(String crnBor) {
            instance.setCrnBor(crnBor);
            return this;
        }

        public Builder accNo(String accNo) {
            instance.setAccNo(accNo);
            return this;
        }

        public Builder roi(String roi) {
            instance.setRoi(roi);
            return this;
        }

        public Builder procFee(java.math.BigDecimal procFee) {
            instance.setProcFee(procFee);
            return this;
        }

        public Builder overallLimit(java.math.BigDecimal overallLimit) {
            instance.setOverallLimit(overallLimit);
            return this;
        }

        public Builder portfolio(String portfolio) {
            instance.setPortfolio(portfolio);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder validFrom(java.time.LocalDateTime validFrom) {
            instance.setValidFrom(validFrom);
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            instance.setValidTo(validTo);
            return this;
        }

        public Builder declarationType(String declarationType) {
            instance.setDeclarationType(declarationType);
            return this;
        }

        public Builder branchAddress(String branchAddress) {
            instance.setBranchAddress(branchAddress);
            return this;
        }

        public Builder branchLocation(String branchLocation) {
            instance.setBranchLocation(branchLocation);
            return this;
        }

        public Builder solid(String solid) {
            instance.setSolid(solid);
            return this;
        }

        public Builder financialYear(String financialYear) {
            instance.setFinancialYear(financialYear);
            return this;
        }

        public Builder gstinNum(String gstinNum) {
            instance.setGstinNum(gstinNum);
            return this;
        }

        public Builder typOfProcFee(java.math.BigDecimal typOfProcFee) {
            instance.setTypOfProcFee(typOfProcFee);
            return this;
        }

        public Builder minLoanAmt(java.math.BigDecimal minLoanAmt) {
            instance.setMinLoanAmt(minLoanAmt);
            return this;
        }

        public Builder maxLoanAmt(java.math.BigDecimal maxLoanAmt) {
            instance.setMaxLoanAmt(maxLoanAmt);
            return this;
        }

        public Builder minTenureDays(Long minTenureDays) {
            instance.setMinTenureDays(minTenureDays);
            return this;
        }

        public Builder maxTenureDays(Long maxTenureDays) {
            instance.setMaxTenureDays(maxTenureDays);
            return this;
        }

        public Builder adhocType(String adhocType) {
            instance.setAdhocType(adhocType);
            return this;
        }

        public Builder existingFac(java.math.BigDecimal existingFac) {
            instance.setExistingFac(existingFac);
            return this;
        }

        public Builder availableLoanLimit(java.math.BigDecimal availableLoanLimit) {
            instance.setAvailableLoanLimit(availableLoanLimit);
            return this;
        }

        public Builder sancLoanLimit(java.math.BigDecimal sancLoanLimit) {
            instance.setSancLoanLimit(sancLoanLimit);
            return this;
        }

        public Builder utlLoanDem(java.math.BigDecimal utlLoanDem) {
            instance.setUtlLoanDem(utlLoanDem);
            return this;
        }

        public Builder gst(java.math.BigDecimal gst) {
            instance.setGst(gst);
            return this;
        }

        public Builder spreadOfRoi(java.math.BigDecimal spreadOfRoi) {
            instance.setSpreadOfRoi(spreadOfRoi);
            return this;
        }

        public Builder roiNextYr(java.math.BigDecimal roiNextYr) {
            instance.setRoiNextYr(roiNextYr);
            return this;
        }

        public Builder sancLtrRefno(String sancLtrRefno) {
            instance.setSancLtrRefno(sancLtrRefno);
            return this;
        }

        public Builder roiBenchmark(java.math.BigDecimal roiBenchmark) {
            instance.setRoiBenchmark(roiBenchmark);
            return this;
        }

        public Builder benchmark(String benchmark) {
            instance.setBenchmark(benchmark);
            return this;
        }

        public Builder adminChrgs(java.math.BigDecimal adminChrgs) {
            instance.setAdminChrgs(adminChrgs);
            return this;
        }

        public Builder technicalFees(java.math.BigDecimal technicalFees) {
            instance.setTechnicalFees(technicalFees);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder gstNextYr(java.math.BigDecimal gstNextYr) {
            instance.setGstNextYr(gstNextYr);
            return this;
        }

        public Builder procFeesNextYr(java.math.BigDecimal procFeesNextYr) {
            instance.setProcFeesNextYr(procFeesNextYr);
            return this;
        }

        public Builder roiType(String roiType) {
            instance.setRoiType(roiType);
            return this;
        }

        public Builder msmeStatus(String msmeStatus) {
            instance.setMsmeStatus(msmeStatus);
            return this;
        }

        public Builder pslStatus(String pslStatus) {
            instance.setPslStatus(pslStatus);
            return this;
        }

        public Builder natureOfBusiness(String natureOfBusiness) {
            instance.setNatureOfBusiness(natureOfBusiness);
            return this;
        }

        public Builder schemeCode(String schemeCode) {
            instance.setSchemeCode(schemeCode);
            return this;
        }

        public Builder limitID(Integer limitID) {
            instance.setLimitID(limitID);
            return this;
        }

        public Builder subsectorCode(String subsectorCode) {
            instance.setSubsectorCode(subsectorCode);
            return this;
        }

        public Builder branchCode(String branchCode) {
            instance.setBranchCode(branchCode);
            return this;
        }

        public Builder operationType(String operationType) {
            instance.setOperationType(operationType);
            return this;
        }

        public Builder userID(Integer userID) {
            instance.setUserID(userID);
            return this;
        }

        public Builder uploadedDate(java.time.LocalDateTime uploadedDate) {
            instance.setUploadedDate(uploadedDate);
            return this;
        }

        public Builder subProductCode(String subProductCode) {
            instance.setSubProductCode(subProductCode);
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            instance.setSegmentCode(segmentCode);
            return this;
        }

        public Builder segmentTeams(String segmentTeams) {
            instance.setSegmentTeams(segmentTeams);
            return this;
        }

        public Builder lineNo(Long lineNo) {
            instance.setLineNo(lineNo);
            return this;
        }

        public CreditOfferPartyMap build() {
            return instance;
        }
    }
}
