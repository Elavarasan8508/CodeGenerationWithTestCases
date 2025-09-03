package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class ScfTxnBatch {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

    private String anchorCrn;

    private String fileMasterRefNo;

    private String scfReqRefNo;

    private Long txnBatchCount;

    private String productType;

    private String utrRefNo;

    private String financeRefNo;

    private String status;

    private String remarks;

    private String eventsPayResRefNo;

    private String cmsRefNo;

    private String purposeCode;

    private java.math.BigDecimal totalCount;

    private java.math.BigDecimal totalAmount;

    public ScfTxnBatch() {
    }

    public ScfTxnBatch(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String anchorCrn, String fileMasterRefNo, String scfReqRefNo, Long txnBatchCount, String productType, String utrRefNo, String financeRefNo, String status, String remarks, String eventsPayResRefNo, String cmsRefNo, String purposeCode, java.math.BigDecimal totalCount, java.math.BigDecimal totalAmount) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.anchorCrn = anchorCrn;
        this.fileMasterRefNo = fileMasterRefNo;
        this.scfReqRefNo = scfReqRefNo;
        this.txnBatchCount = txnBatchCount;
        this.productType = productType;
        this.utrRefNo = utrRefNo;
        this.financeRefNo = financeRefNo;
        this.status = status;
        this.remarks = remarks;
        this.eventsPayResRefNo = eventsPayResRefNo;
        this.cmsRefNo = cmsRefNo;
        this.purposeCode = purposeCode;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
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

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getAnchorCrn() {
        return anchorCrn;
    }

    public void setAnchorCrn(String anchorCrn) {
        this.anchorCrn = anchorCrn;
    }

    public String getFileMasterRefNo() {
        return fileMasterRefNo;
    }

    public void setFileMasterRefNo(String fileMasterRefNo) {
        this.fileMasterRefNo = fileMasterRefNo;
    }

    public String getScfReqRefNo() {
        return scfReqRefNo;
    }

    public void setScfReqRefNo(String scfReqRefNo) {
        this.scfReqRefNo = scfReqRefNo;
    }

    public Long getTxnBatchCount() {
        return txnBatchCount;
    }

    public void setTxnBatchCount(Long txnBatchCount) {
        this.txnBatchCount = txnBatchCount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getUtrRefNo() {
        return utrRefNo;
    }

    public void setUtrRefNo(String utrRefNo) {
        this.utrRefNo = utrRefNo;
    }

    public String getFinanceRefNo() {
        return financeRefNo;
    }

    public void setFinanceRefNo(String financeRefNo) {
        this.financeRefNo = financeRefNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEventsPayResRefNo() {
        return eventsPayResRefNo;
    }

    public void setEventsPayResRefNo(String eventsPayResRefNo) {
        this.eventsPayResRefNo = eventsPayResRefNo;
    }

    public String getCmsRefNo() {
        return cmsRefNo;
    }

    public void setCmsRefNo(String cmsRefNo) {
        this.cmsRefNo = cmsRefNo;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public java.math.BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(java.math.BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public java.math.BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static class Builder {

        private ScfTxnBatch instance = new ScfTxnBatch();

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

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder anchorCrn(String anchorCrn) {
            instance.setAnchorCrn(anchorCrn);
            return this;
        }

        public Builder fileMasterRefNo(String fileMasterRefNo) {
            instance.setFileMasterRefNo(fileMasterRefNo);
            return this;
        }

        public Builder scfReqRefNo(String scfReqRefNo) {
            instance.setScfReqRefNo(scfReqRefNo);
            return this;
        }

        public Builder txnBatchCount(Long txnBatchCount) {
            instance.setTxnBatchCount(txnBatchCount);
            return this;
        }

        public Builder productType(String productType) {
            instance.setProductType(productType);
            return this;
        }

        public Builder utrRefNo(String utrRefNo) {
            instance.setUtrRefNo(utrRefNo);
            return this;
        }

        public Builder financeRefNo(String financeRefNo) {
            instance.setFinanceRefNo(financeRefNo);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder eventsPayResRefNo(String eventsPayResRefNo) {
            instance.setEventsPayResRefNo(eventsPayResRefNo);
            return this;
        }

        public Builder cmsRefNo(String cmsRefNo) {
            instance.setCmsRefNo(cmsRefNo);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder totalCount(java.math.BigDecimal totalCount) {
            instance.setTotalCount(totalCount);
            return this;
        }

        public Builder totalAmount(java.math.BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public ScfTxnBatch build() {
            return instance;
        }
    }
}
