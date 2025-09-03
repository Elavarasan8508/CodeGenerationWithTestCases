package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class CoreMdmProduct {

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

    private Integer isTemplate;

    private String productCode;

    private String productName;

    private String productStatusCode;

    private String productDescription;

    private String borrowerParty;

    private Integer assetLiabilityApplicable;

    private Integer creditLineApplicable;

    private Integer exposureMaintenanceReq;

    private String invoiceRaisedBy;

    private String financeRequestBy;

    private Integer interestCalculation;

    private Integer accrualAmortize;

    private String anchorParty;

    private String financeDebitParty;

    private String financeToParty;

    private String segmentCode;

    private Integer cutoffApplicable;

    private Integer chargesApplicable;

    private Integer holidayApplicable;

    private Integer allowPayment;

    private Integer allowCollection;

    private String baShortName;

    private String productGroupCode;

    private String productSubgroupCode;

    private String classification;

    private Integer versionID;

    private Integer isMasterVersion;

    private Integer uploadRefID;

    public CoreMdmProduct() {
    }

    public CoreMdmProduct(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String productCode, String productName, String productStatusCode, String productDescription, String borrowerParty, Integer assetLiabilityApplicable, Integer creditLineApplicable, Integer exposureMaintenanceReq, String invoiceRaisedBy, String financeRequestBy, Integer interestCalculation, Integer accrualAmortize, String anchorParty, String financeDebitParty, String financeToParty, String segmentCode, Integer cutoffApplicable, Integer chargesApplicable, Integer holidayApplicable, Integer allowPayment, Integer allowCollection, String baShortName, String productGroupCode, String productSubgroupCode, String classification, Integer versionID, Integer isMasterVersion, Integer uploadRefID) {
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
        this.isTemplate = isTemplate;
        this.productCode = productCode;
        this.productName = productName;
        this.productStatusCode = productStatusCode;
        this.productDescription = productDescription;
        this.borrowerParty = borrowerParty;
        this.assetLiabilityApplicable = assetLiabilityApplicable;
        this.creditLineApplicable = creditLineApplicable;
        this.exposureMaintenanceReq = exposureMaintenanceReq;
        this.invoiceRaisedBy = invoiceRaisedBy;
        this.financeRequestBy = financeRequestBy;
        this.interestCalculation = interestCalculation;
        this.accrualAmortize = accrualAmortize;
        this.anchorParty = anchorParty;
        this.financeDebitParty = financeDebitParty;
        this.financeToParty = financeToParty;
        this.segmentCode = segmentCode;
        this.cutoffApplicable = cutoffApplicable;
        this.chargesApplicable = chargesApplicable;
        this.holidayApplicable = holidayApplicable;
        this.allowPayment = allowPayment;
        this.allowCollection = allowCollection;
        this.baShortName = baShortName;
        this.productGroupCode = productGroupCode;
        this.productSubgroupCode = productSubgroupCode;
        this.classification = classification;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.uploadRefID = uploadRefID;
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

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStatusCode() {
        return productStatusCode;
    }

    public void setProductStatusCode(String productStatusCode) {
        this.productStatusCode = productStatusCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getBorrowerParty() {
        return borrowerParty;
    }

    public void setBorrowerParty(String borrowerParty) {
        this.borrowerParty = borrowerParty;
    }

    public Integer getAssetLiabilityApplicable() {
        return assetLiabilityApplicable;
    }

    public void setAssetLiabilityApplicable(Integer assetLiabilityApplicable) {
        this.assetLiabilityApplicable = assetLiabilityApplicable;
    }

    public Integer getCreditLineApplicable() {
        return creditLineApplicable;
    }

    public void setCreditLineApplicable(Integer creditLineApplicable) {
        this.creditLineApplicable = creditLineApplicable;
    }

    public Integer getExposureMaintenanceReq() {
        return exposureMaintenanceReq;
    }

    public void setExposureMaintenanceReq(Integer exposureMaintenanceReq) {
        this.exposureMaintenanceReq = exposureMaintenanceReq;
    }

    public String getInvoiceRaisedBy() {
        return invoiceRaisedBy;
    }

    public void setInvoiceRaisedBy(String invoiceRaisedBy) {
        this.invoiceRaisedBy = invoiceRaisedBy;
    }

    public String getFinanceRequestBy() {
        return financeRequestBy;
    }

    public void setFinanceRequestBy(String financeRequestBy) {
        this.financeRequestBy = financeRequestBy;
    }

    public Integer getInterestCalculation() {
        return interestCalculation;
    }

    public void setInterestCalculation(Integer interestCalculation) {
        this.interestCalculation = interestCalculation;
    }

    public Integer getAccrualAmortize() {
        return accrualAmortize;
    }

    public void setAccrualAmortize(Integer accrualAmortize) {
        this.accrualAmortize = accrualAmortize;
    }

    public String getAnchorParty() {
        return anchorParty;
    }

    public void setAnchorParty(String anchorParty) {
        this.anchorParty = anchorParty;
    }

    public String getFinanceDebitParty() {
        return financeDebitParty;
    }

    public void setFinanceDebitParty(String financeDebitParty) {
        this.financeDebitParty = financeDebitParty;
    }

    public String getFinanceToParty() {
        return financeToParty;
    }

    public void setFinanceToParty(String financeToParty) {
        this.financeToParty = financeToParty;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public Integer getCutoffApplicable() {
        return cutoffApplicable;
    }

    public void setCutoffApplicable(Integer cutoffApplicable) {
        this.cutoffApplicable = cutoffApplicable;
    }

    public Integer getChargesApplicable() {
        return chargesApplicable;
    }

    public void setChargesApplicable(Integer chargesApplicable) {
        this.chargesApplicable = chargesApplicable;
    }

    public Integer getHolidayApplicable() {
        return holidayApplicable;
    }

    public void setHolidayApplicable(Integer holidayApplicable) {
        this.holidayApplicable = holidayApplicable;
    }

    public Integer getAllowPayment() {
        return allowPayment;
    }

    public void setAllowPayment(Integer allowPayment) {
        this.allowPayment = allowPayment;
    }

    public Integer getAllowCollection() {
        return allowCollection;
    }

    public void setAllowCollection(Integer allowCollection) {
        this.allowCollection = allowCollection;
    }

    public String getBaShortName() {
        return baShortName;
    }

    public void setBaShortName(String baShortName) {
        this.baShortName = baShortName;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    public String getProductSubgroupCode() {
        return productSubgroupCode;
    }

    public void setProductSubgroupCode(String productSubgroupCode) {
        this.productSubgroupCode = productSubgroupCode;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public static class Builder {

        private CoreMdmProduct instance = new CoreMdmProduct();

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

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder productName(String productName) {
            instance.setProductName(productName);
            return this;
        }

        public Builder productStatusCode(String productStatusCode) {
            instance.setProductStatusCode(productStatusCode);
            return this;
        }

        public Builder productDescription(String productDescription) {
            instance.setProductDescription(productDescription);
            return this;
        }

        public Builder borrowerParty(String borrowerParty) {
            instance.setBorrowerParty(borrowerParty);
            return this;
        }

        public Builder assetLiabilityApplicable(Integer assetLiabilityApplicable) {
            instance.setAssetLiabilityApplicable(assetLiabilityApplicable);
            return this;
        }

        public Builder creditLineApplicable(Integer creditLineApplicable) {
            instance.setCreditLineApplicable(creditLineApplicable);
            return this;
        }

        public Builder exposureMaintenanceReq(Integer exposureMaintenanceReq) {
            instance.setExposureMaintenanceReq(exposureMaintenanceReq);
            return this;
        }

        public Builder invoiceRaisedBy(String invoiceRaisedBy) {
            instance.setInvoiceRaisedBy(invoiceRaisedBy);
            return this;
        }

        public Builder financeRequestBy(String financeRequestBy) {
            instance.setFinanceRequestBy(financeRequestBy);
            return this;
        }

        public Builder interestCalculation(Integer interestCalculation) {
            instance.setInterestCalculation(interestCalculation);
            return this;
        }

        public Builder accrualAmortize(Integer accrualAmortize) {
            instance.setAccrualAmortize(accrualAmortize);
            return this;
        }

        public Builder anchorParty(String anchorParty) {
            instance.setAnchorParty(anchorParty);
            return this;
        }

        public Builder financeDebitParty(String financeDebitParty) {
            instance.setFinanceDebitParty(financeDebitParty);
            return this;
        }

        public Builder financeToParty(String financeToParty) {
            instance.setFinanceToParty(financeToParty);
            return this;
        }

        public Builder segmentCode(String segmentCode) {
            instance.setSegmentCode(segmentCode);
            return this;
        }

        public Builder cutoffApplicable(Integer cutoffApplicable) {
            instance.setCutoffApplicable(cutoffApplicable);
            return this;
        }

        public Builder chargesApplicable(Integer chargesApplicable) {
            instance.setChargesApplicable(chargesApplicable);
            return this;
        }

        public Builder holidayApplicable(Integer holidayApplicable) {
            instance.setHolidayApplicable(holidayApplicable);
            return this;
        }

        public Builder allowPayment(Integer allowPayment) {
            instance.setAllowPayment(allowPayment);
            return this;
        }

        public Builder allowCollection(Integer allowCollection) {
            instance.setAllowCollection(allowCollection);
            return this;
        }

        public Builder baShortName(String baShortName) {
            instance.setBaShortName(baShortName);
            return this;
        }

        public Builder productGroupCode(String productGroupCode) {
            instance.setProductGroupCode(productGroupCode);
            return this;
        }

        public Builder productSubgroupCode(String productSubgroupCode) {
            instance.setProductSubgroupCode(productSubgroupCode);
            return this;
        }

        public Builder classification(String classification) {
            instance.setClassification(classification);
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

        public CoreMdmProduct build() {
            return instance;
        }
    }
}
