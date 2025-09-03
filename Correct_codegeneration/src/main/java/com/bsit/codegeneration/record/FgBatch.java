package com.bsit.codegeneration.record;

import java.util.List;

public record FgBatch(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String recordIdentifier, Long totInstruments, Long totalAmount, String batchRefNo, java.time.LocalDateTime batchDate, String productCode, Integer uploadRefID, String pmntHdrIdentifier, java.time.LocalDateTime pmntDateForFile, Long countOfInstruction) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

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

        private String recordIdentifier;

        private Long totInstruments;

        private Long totalAmount;

        private String batchRefNo;

        private java.time.LocalDateTime batchDate;

        private String productCode;

        private Integer uploadRefID;

        private String pmntHdrIdentifier;

        private java.time.LocalDateTime pmntDateForFile;

        private Long countOfInstruction;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
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

        public Builder recordIdentifier(String recordIdentifier) {
            this.recordIdentifier = recordIdentifier;
            return this;
        }

        public Builder totInstruments(Long totInstruments) {
            this.totInstruments = totInstruments;
            return this;
        }

        public Builder totalAmount(Long totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder batchRefNo(String batchRefNo) {
            this.batchRefNo = batchRefNo;
            return this;
        }

        public Builder batchDate(java.time.LocalDateTime batchDate) {
            this.batchDate = batchDate;
            return this;
        }

        public Builder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder pmntHdrIdentifier(String pmntHdrIdentifier) {
            this.pmntHdrIdentifier = pmntHdrIdentifier;
            return this;
        }

        public Builder pmntDateForFile(java.time.LocalDateTime pmntDateForFile) {
            this.pmntDateForFile = pmntDateForFile;
            return this;
        }

        public Builder countOfInstruction(Long countOfInstruction) {
            this.countOfInstruction = countOfInstruction;
            return this;
        }

        public FgBatch build() {
            return new FgBatch(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, recordIdentifier, totInstruments, totalAmount, batchRefNo, batchDate, productCode, uploadRefID, pmntHdrIdentifier, pmntDateForFile, countOfInstruction);
        }
    }
}
