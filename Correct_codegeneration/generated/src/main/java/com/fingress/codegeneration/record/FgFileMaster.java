package com.bsit.codegeneration.record;

public record FgFileMaster(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String anchorCrn, String fileName, String fileAttachRefNo, String fileStatus, String remarks, Long lineCount, Long txnCount, Long txnValSuccessCnt, Long txnListingCnt, Long txnListingAckCnt, Long finpayReqCnt, Long integritySuccessCnt, String stagestatus, Long finpayRespCnt, String anchorName, String displayFileName, String hashKey, String purposeCode, String displayStatus, Long layoutTemplateID, String layoutName, Long layoutTemplateVersionID, String uploadRefID) {

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

        private Long layoutTemplateID;

        private String layoutName;

        private Long layoutTemplateVersionID;

        private String uploadRefID;

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

        public Builder anchorCrn(String anchorCrn) {
            this.anchorCrn = anchorCrn;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder fileAttachRefNo(String fileAttachRefNo) {
            this.fileAttachRefNo = fileAttachRefNo;
            return this;
        }

        public Builder fileStatus(String fileStatus) {
            this.fileStatus = fileStatus;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder lineCount(Long lineCount) {
            this.lineCount = lineCount;
            return this;
        }

        public Builder txnCount(Long txnCount) {
            this.txnCount = txnCount;
            return this;
        }

        public Builder txnValSuccessCnt(Long txnValSuccessCnt) {
            this.txnValSuccessCnt = txnValSuccessCnt;
            return this;
        }

        public Builder txnListingCnt(Long txnListingCnt) {
            this.txnListingCnt = txnListingCnt;
            return this;
        }

        public Builder txnListingAckCnt(Long txnListingAckCnt) {
            this.txnListingAckCnt = txnListingAckCnt;
            return this;
        }

        public Builder finpayReqCnt(Long finpayReqCnt) {
            this.finpayReqCnt = finpayReqCnt;
            return this;
        }

        public Builder integritySuccessCnt(Long integritySuccessCnt) {
            this.integritySuccessCnt = integritySuccessCnt;
            return this;
        }

        public Builder stagestatus(String stagestatus) {
            this.stagestatus = stagestatus;
            return this;
        }

        public Builder finpayRespCnt(Long finpayRespCnt) {
            this.finpayRespCnt = finpayRespCnt;
            return this;
        }

        public Builder anchorName(String anchorName) {
            this.anchorName = anchorName;
            return this;
        }

        public Builder displayFileName(String displayFileName) {
            this.displayFileName = displayFileName;
            return this;
        }

        public Builder hashKey(String hashKey) {
            this.hashKey = hashKey;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder displayStatus(String displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }

        public Builder layoutTemplateID(Long layoutTemplateID) {
            this.layoutTemplateID = layoutTemplateID;
            return this;
        }

        public Builder layoutName(String layoutName) {
            this.layoutName = layoutName;
            return this;
        }

        public Builder layoutTemplateVersionID(Long layoutTemplateVersionID) {
            this.layoutTemplateVersionID = layoutTemplateVersionID;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public FgFileMaster build() {
            return new FgFileMaster(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, anchorCrn, fileName, fileAttachRefNo, fileStatus, remarks, lineCount, txnCount, txnValSuccessCnt, txnListingCnt, txnListingAckCnt, finpayReqCnt, integritySuccessCnt, stagestatus, finpayRespCnt, anchorName, displayFileName, hashKey, purposeCode, displayStatus, layoutTemplateID, layoutName, layoutTemplateVersionID, uploadRefID);
        }
    }
}
