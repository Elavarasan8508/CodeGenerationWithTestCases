package com.bsit.codegeneration.record;

import java.util.List;

public record FgProductStageHistory(String entityTypeCode, String entitySubTypeCode, Integer wfProcessID, Integer wfDefinitionID, Integer entityRefID, Long entityVersionNo, String stageCode, String perfPtySubtypCode, String perfPtyTypCode, String partyCode, String perfPtyRoleCode, Long stp, Long stageOrderIdx, String stageStartTime, String stageEndTime, String wfProcessStatusCode, String activeCode, String statusCode, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn, String perfPtyFieldCode, Integer uploadRefID, Integer ID) {

    public static class Builder {

        private String entityTypeCode;

        private String entitySubTypeCode;

        private Integer wfProcessID;

        private Integer wfDefinitionID;

        private Integer entityRefID;

        private Long entityVersionNo;

        private String stageCode;

        private String perfPtySubtypCode;

        private String perfPtyTypCode;

        private String partyCode;

        private String perfPtyRoleCode;

        private Long stp;

        private Long stageOrderIdx;

        private String stageStartTime;

        private String stageEndTime;

        private String wfProcessStatusCode;

        private String activeCode;

        private String statusCode;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private String perfPtyFieldCode;

        private Integer uploadRefID;

        private Integer ID;

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder wfProcessID(Integer wfProcessID) {
            this.wfProcessID = wfProcessID;
            return this;
        }

        public Builder wfDefinitionID(Integer wfDefinitionID) {
            this.wfDefinitionID = wfDefinitionID;
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entityVersionNo(Long entityVersionNo) {
            this.entityVersionNo = entityVersionNo;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
            return this;
        }

        public Builder perfPtySubtypCode(String perfPtySubtypCode) {
            this.perfPtySubtypCode = perfPtySubtypCode;
            return this;
        }

        public Builder perfPtyTypCode(String perfPtyTypCode) {
            this.perfPtyTypCode = perfPtyTypCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder perfPtyRoleCode(String perfPtyRoleCode) {
            this.perfPtyRoleCode = perfPtyRoleCode;
            return this;
        }

        public Builder stp(Long stp) {
            this.stp = stp;
            return this;
        }

        public Builder stageOrderIdx(Long stageOrderIdx) {
            this.stageOrderIdx = stageOrderIdx;
            return this;
        }

        public Builder stageStartTime(String stageStartTime) {
            this.stageStartTime = stageStartTime;
            return this;
        }

        public Builder stageEndTime(String stageEndTime) {
            this.stageEndTime = stageEndTime;
            return this;
        }

        public Builder wfProcessStatusCode(String wfProcessStatusCode) {
            this.wfProcessStatusCode = wfProcessStatusCode;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder perfPtyFieldCode(String perfPtyFieldCode) {
            this.perfPtyFieldCode = perfPtyFieldCode;
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public FgProductStageHistory build() {
            return new FgProductStageHistory(entityTypeCode, entitySubTypeCode, wfProcessID, wfDefinitionID, entityRefID, entityVersionNo, stageCode, perfPtySubtypCode, perfPtyTypCode, partyCode, perfPtyRoleCode, stp, stageOrderIdx, stageStartTime, stageEndTime, wfProcessStatusCode, activeCode, statusCode, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn, lastAuthorisedBy, lastAuthorisedOn, perfPtyFieldCode, uploadRefID, ID);
        }
    }
}
