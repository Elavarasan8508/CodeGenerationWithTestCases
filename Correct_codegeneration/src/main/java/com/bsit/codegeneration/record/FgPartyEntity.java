package com.bsit.codegeneration.record;

import java.util.List;

public record FgPartyEntity(Integer ID, String parentPartyCode, String partyCode, String partyTypeCode, String partySubTypeCode, String entityRefCode, String entityTypeCode, String entitySubTypeCode, Long mask, Long granting, Long isMaster, Long versionNo, String initiateBy, Long isTransaction, Long isView, String activeCode, String statusCode, String authStatusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Integer parentPartyID, Integer parentPartyVersionID, Integer partyID, Integer partyVersionID, Integer entityID, Integer entityVersionID) {

    public static class Builder {

        private Integer ID;

        private String parentPartyCode;

        private String partyCode;

        private String partyTypeCode;

        private String partySubTypeCode;

        private String entityRefCode;

        private String entityTypeCode;

        private String entitySubTypeCode;

        private Long mask;

        private Long granting;

        private Long isMaster;

        private Long versionNo;

        private String initiateBy;

        private Long isTransaction;

        private Long isView;

        private String activeCode;

        private String statusCode;

        private String authStatusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Integer parentPartyID;

        private Integer parentPartyVersionID;

        private Integer partyID;

        private Integer partyVersionID;

        private Integer entityID;

        private Integer entityVersionID;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder parentPartyCode(String parentPartyCode) {
            this.parentPartyCode = parentPartyCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder entityRefCode(String entityRefCode) {
            this.entityRefCode = entityRefCode;
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            this.entityTypeCode = entityTypeCode;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder mask(Long mask) {
            this.mask = mask;
            return this;
        }

        public Builder granting(Long granting) {
            this.granting = granting;
            return this;
        }

        public Builder isMaster(Long isMaster) {
            this.isMaster = isMaster;
            return this;
        }

        public Builder versionNo(Long versionNo) {
            this.versionNo = versionNo;
            return this;
        }

        public Builder initiateBy(String initiateBy) {
            this.initiateBy = initiateBy;
            return this;
        }

        public Builder isTransaction(Long isTransaction) {
            this.isTransaction = isTransaction;
            return this;
        }

        public Builder isView(Long isView) {
            this.isView = isView;
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

        public Builder authStatusCode(String authStatusCode) {
            this.authStatusCode = authStatusCode;
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

        public Builder parentPartyID(Integer parentPartyID) {
            this.parentPartyID = parentPartyID;
            return this;
        }

        public Builder parentPartyVersionID(Integer parentPartyVersionID) {
            this.parentPartyVersionID = parentPartyVersionID;
            return this;
        }

        public Builder partyID(Integer partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder entityID(Integer entityID) {
            this.entityID = entityID;
            return this;
        }

        public Builder entityVersionID(Integer entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public FgPartyEntity build() {
            return new FgPartyEntity(ID, parentPartyCode, partyCode, partyTypeCode, partySubTypeCode, entityRefCode, entityTypeCode, entitySubTypeCode, mask, granting, isMaster, versionNo, initiateBy, isTransaction, isView, activeCode, statusCode, authStatusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, parentPartyID, parentPartyVersionID, partyID, partyVersionID, entityID, entityVersionID);
        }
    }
}
