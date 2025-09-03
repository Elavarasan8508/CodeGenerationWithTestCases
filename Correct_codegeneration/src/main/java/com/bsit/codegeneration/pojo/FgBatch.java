package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgBatch {

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

    private String recordIdentifier;

    private Long totInstruments;

    private java.math.BigDecimal totalAmount;

    private String batchRefNo;

    private java.time.LocalDateTime batchDate;

    private String productCode;

    private Integer uploadRefID;

    private String pmntHdrIdentifier;

    private java.time.LocalDateTime pmntDateForFile;

    private Long countOfInstruction;

    public FgBatch() {
    }

    public FgBatch(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String recordIdentifier, Long totInstruments, java.math.BigDecimal totalAmount, String batchRefNo, java.time.LocalDateTime batchDate, String productCode, Integer uploadRefID, String pmntHdrIdentifier, java.time.LocalDateTime pmntDateForFile, Long countOfInstruction) {
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
        this.recordIdentifier = recordIdentifier;
        this.totInstruments = totInstruments;
        this.totalAmount = totalAmount;
        this.batchRefNo = batchRefNo;
        this.batchDate = batchDate;
        this.productCode = productCode;
        this.uploadRefID = uploadRefID;
        this.pmntHdrIdentifier = pmntHdrIdentifier;
        this.pmntDateForFile = pmntDateForFile;
        this.countOfInstruction = countOfInstruction;
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

    public String getRecordIdentifier() {
        return recordIdentifier;
    }

    public void setRecordIdentifier(String recordIdentifier) {
        this.recordIdentifier = recordIdentifier;
    }

    public Long getTotInstruments() {
        return totInstruments;
    }

    public void setTotInstruments(Long totInstruments) {
        this.totInstruments = totInstruments;
    }

    public java.math.BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBatchRefNo() {
        return batchRefNo;
    }

    public void setBatchRefNo(String batchRefNo) {
        this.batchRefNo = batchRefNo;
    }

    public java.time.LocalDateTime getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(java.time.LocalDateTime batchDate) {
        this.batchDate = batchDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getPmntHdrIdentifier() {
        return pmntHdrIdentifier;
    }

    public void setPmntHdrIdentifier(String pmntHdrIdentifier) {
        this.pmntHdrIdentifier = pmntHdrIdentifier;
    }

    public java.time.LocalDateTime getPmntDateForFile() {
        return pmntDateForFile;
    }

    public void setPmntDateForFile(java.time.LocalDateTime pmntDateForFile) {
        this.pmntDateForFile = pmntDateForFile;
    }

    public Long getCountOfInstruction() {
        return countOfInstruction;
    }

    public void setCountOfInstruction(Long countOfInstruction) {
        this.countOfInstruction = countOfInstruction;
    }

    public static class Builder {

        private FgBatch instance = new FgBatch();

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

        public Builder recordIdentifier(String recordIdentifier) {
            instance.setRecordIdentifier(recordIdentifier);
            return this;
        }

        public Builder totInstruments(Long totInstruments) {
            instance.setTotInstruments(totInstruments);
            return this;
        }

        public Builder totalAmount(java.math.BigDecimal totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder batchRefNo(String batchRefNo) {
            instance.setBatchRefNo(batchRefNo);
            return this;
        }

        public Builder batchDate(java.time.LocalDateTime batchDate) {
            instance.setBatchDate(batchDate);
            return this;
        }

        public Builder productCode(String productCode) {
            instance.setProductCode(productCode);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder pmntHdrIdentifier(String pmntHdrIdentifier) {
            instance.setPmntHdrIdentifier(pmntHdrIdentifier);
            return this;
        }

        public Builder pmntDateForFile(java.time.LocalDateTime pmntDateForFile) {
            instance.setPmntDateForFile(pmntDateForFile);
            return this;
        }

        public Builder countOfInstruction(Long countOfInstruction) {
            instance.setCountOfInstruction(countOfInstruction);
            return this;
        }

        public FgBatch build() {
            return instance;
        }
    }
}
