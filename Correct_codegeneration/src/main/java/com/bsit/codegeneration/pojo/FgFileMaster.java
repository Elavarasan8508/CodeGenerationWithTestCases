package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgFileMaster {

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

    private String fileName;

    private String fileAttachRefNo;

    private String fileStatus;

    private String remarks;

    private Long lineCount;

    private Long txnCount;

    private Long txnValSuccessCnt;

    private Long txnListingCnt;

    private Long txnListingAckCnt;

    private Long finpayReqCnt;

    private Long integritySuccessCnt;

    private String stagestatus;

    private Long finpayRespCnt;

    private String anchorName;

    private String displayFileName;

    private String hashKey;

    private String purposeCode;

    private String displayStatus;

    private Integer layoutTemplateID;

    private String layoutName;

    private Integer layoutTemplateVersionID;

    private Integer uploadRefID;

    public FgFileMaster() {
    }

    public FgFileMaster(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String anchorCrn, String fileName, String fileAttachRefNo, String fileStatus, String remarks, Long lineCount, Long txnCount, Long txnValSuccessCnt, Long txnListingCnt, Long txnListingAckCnt, Long finpayReqCnt, Long integritySuccessCnt, String stagestatus, Long finpayRespCnt, String anchorName, String displayFileName, String hashKey, String purposeCode, String displayStatus, Integer layoutTemplateID, String layoutName, Integer layoutTemplateVersionID, Integer uploadRefID) {
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
        this.fileName = fileName;
        this.fileAttachRefNo = fileAttachRefNo;
        this.fileStatus = fileStatus;
        this.remarks = remarks;
        this.lineCount = lineCount;
        this.txnCount = txnCount;
        this.txnValSuccessCnt = txnValSuccessCnt;
        this.txnListingCnt = txnListingCnt;
        this.txnListingAckCnt = txnListingAckCnt;
        this.finpayReqCnt = finpayReqCnt;
        this.integritySuccessCnt = integritySuccessCnt;
        this.stagestatus = stagestatus;
        this.finpayRespCnt = finpayRespCnt;
        this.anchorName = anchorName;
        this.displayFileName = displayFileName;
        this.hashKey = hashKey;
        this.purposeCode = purposeCode;
        this.displayStatus = displayStatus;
        this.layoutTemplateID = layoutTemplateID;
        this.layoutName = layoutName;
        this.layoutTemplateVersionID = layoutTemplateVersionID;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileAttachRefNo() {
        return fileAttachRefNo;
    }

    public void setFileAttachRefNo(String fileAttachRefNo) {
        this.fileAttachRefNo = fileAttachRefNo;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getLineCount() {
        return lineCount;
    }

    public void setLineCount(Long lineCount) {
        this.lineCount = lineCount;
    }

    public Long getTxnCount() {
        return txnCount;
    }

    public void setTxnCount(Long txnCount) {
        this.txnCount = txnCount;
    }

    public Long getTxnValSuccessCnt() {
        return txnValSuccessCnt;
    }

    public void setTxnValSuccessCnt(Long txnValSuccessCnt) {
        this.txnValSuccessCnt = txnValSuccessCnt;
    }

    public Long getTxnListingCnt() {
        return txnListingCnt;
    }

    public void setTxnListingCnt(Long txnListingCnt) {
        this.txnListingCnt = txnListingCnt;
    }

    public Long getTxnListingAckCnt() {
        return txnListingAckCnt;
    }

    public void setTxnListingAckCnt(Long txnListingAckCnt) {
        this.txnListingAckCnt = txnListingAckCnt;
    }

    public Long getFinpayReqCnt() {
        return finpayReqCnt;
    }

    public void setFinpayReqCnt(Long finpayReqCnt) {
        this.finpayReqCnt = finpayReqCnt;
    }

    public Long getIntegritySuccessCnt() {
        return integritySuccessCnt;
    }

    public void setIntegritySuccessCnt(Long integritySuccessCnt) {
        this.integritySuccessCnt = integritySuccessCnt;
    }

    public String getStagestatus() {
        return stagestatus;
    }

    public void setStagestatus(String stagestatus) {
        this.stagestatus = stagestatus;
    }

    public Long getFinpayRespCnt() {
        return finpayRespCnt;
    }

    public void setFinpayRespCnt(Long finpayRespCnt) {
        this.finpayRespCnt = finpayRespCnt;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public String getDisplayFileName() {
        return displayFileName;
    }

    public void setDisplayFileName(String displayFileName) {
        this.displayFileName = displayFileName;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public Integer getLayoutTemplateID() {
        return layoutTemplateID;
    }

    public void setLayoutTemplateID(Integer layoutTemplateID) {
        this.layoutTemplateID = layoutTemplateID;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public Integer getLayoutTemplateVersionID() {
        return layoutTemplateVersionID;
    }

    public void setLayoutTemplateVersionID(Integer layoutTemplateVersionID) {
        this.layoutTemplateVersionID = layoutTemplateVersionID;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public static class Builder {

        private FgFileMaster instance = new FgFileMaster();

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

        public Builder fileName(String fileName) {
            instance.setFileName(fileName);
            return this;
        }

        public Builder fileAttachRefNo(String fileAttachRefNo) {
            instance.setFileAttachRefNo(fileAttachRefNo);
            return this;
        }

        public Builder fileStatus(String fileStatus) {
            instance.setFileStatus(fileStatus);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder lineCount(Long lineCount) {
            instance.setLineCount(lineCount);
            return this;
        }

        public Builder txnCount(Long txnCount) {
            instance.setTxnCount(txnCount);
            return this;
        }

        public Builder txnValSuccessCnt(Long txnValSuccessCnt) {
            instance.setTxnValSuccessCnt(txnValSuccessCnt);
            return this;
        }

        public Builder txnListingCnt(Long txnListingCnt) {
            instance.setTxnListingCnt(txnListingCnt);
            return this;
        }

        public Builder txnListingAckCnt(Long txnListingAckCnt) {
            instance.setTxnListingAckCnt(txnListingAckCnt);
            return this;
        }

        public Builder finpayReqCnt(Long finpayReqCnt) {
            instance.setFinpayReqCnt(finpayReqCnt);
            return this;
        }

        public Builder integritySuccessCnt(Long integritySuccessCnt) {
            instance.setIntegritySuccessCnt(integritySuccessCnt);
            return this;
        }

        public Builder stagestatus(String stagestatus) {
            instance.setStagestatus(stagestatus);
            return this;
        }

        public Builder finpayRespCnt(Long finpayRespCnt) {
            instance.setFinpayRespCnt(finpayRespCnt);
            return this;
        }

        public Builder anchorName(String anchorName) {
            instance.setAnchorName(anchorName);
            return this;
        }

        public Builder displayFileName(String displayFileName) {
            instance.setDisplayFileName(displayFileName);
            return this;
        }

        public Builder hashKey(String hashKey) {
            instance.setHashKey(hashKey);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            instance.setDisplayStatus(displayStatus);
            return this;
        }

        public Builder layoutTemplateID(Integer layoutTemplateID) {
            instance.setLayoutTemplateID(layoutTemplateID);
            return this;
        }

        public Builder layoutName(String layoutName) {
            instance.setLayoutName(layoutName);
            return this;
        }

        public Builder layoutTemplateVersionID(Integer layoutTemplateVersionID) {
            instance.setLayoutTemplateVersionID(layoutTemplateVersionID);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public FgFileMaster build() {
            return instance;
        }
    }
}
