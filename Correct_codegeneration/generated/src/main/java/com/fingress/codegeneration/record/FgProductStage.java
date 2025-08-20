package com.bsit.codegeneration.record;

public record FgProductStage(String entityTypeCode, String entitySubTypeCode, String stageCode, String perfPtySubtypCode, String perfPtyTypCode, String perfPtyRoleCode, Long stp, Long stageOrderIdx, Long autoSubmit, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String entityRefID, String authStatusCode, String tnxStatusCode, String authorization, Long entityVersionID, Long autoAuthorise, String perfPtyFieldCode, String uploadRefID, String ID) {

    public static class Builder {

        private String entityTypeCode;

        private String entitySubTypeCode;

        private String stageCode;

        private String perfPtySubtypCode;

        private String perfPtyTypCode;

        private String perfPtyRoleCode;

        private Long stp;

        private Long stageOrderIdx;

        private Long autoSubmit;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String entityRefID;

        private String authStatusCode;

        private String tnxStatusCode;

        private String authorization;

        private Long entityVersionID;

        private Long autoAuthorise;

        private String perfPtyFieldCode;

        private String uploadRefID;

        private String ID;

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
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

        public Builder autoSubmit(Long autoSubmit) {
            this.autoSubmit = autoSubmit;
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

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder authStatusCode(String authStatusCode) {
            this.authStatusCode = authStatusCode;
            return this;
        }

        public Builder tnxStatusCode(String tnxStatusCode) {
            this.tnxStatusCode = tnxStatusCode;
            return this;
        }

        public Builder authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }

        public Builder entityVersionID(Long entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public Builder autoAuthorise(Long autoAuthorise) {
            this.autoAuthorise = autoAuthorise;
            return this;
        }

        public Builder perfPtyFieldCode(String perfPtyFieldCode) {
            this.perfPtyFieldCode = perfPtyFieldCode;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public FgProductStage build() {
            return new FgProductStage(entityTypeCode, entitySubTypeCode, stageCode, perfPtySubtypCode, perfPtyTypCode, perfPtyRoleCode, stp, stageOrderIdx, autoSubmit, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, entityRefID, authStatusCode, tnxStatusCode, authorization, entityVersionID, autoAuthorise, perfPtyFieldCode, uploadRefID, ID);
        }
    }
}
