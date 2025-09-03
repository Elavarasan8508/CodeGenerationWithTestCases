package com.bsit.codegeneration.record;

import java.util.List;

public record FgVault(Integer ID, Integer entityRefID, String entitySubTypeCode, String vaultType, String vaultData, String activeCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Integer entityID, Integer entityVersionID) {

    public static class Builder {

        private Integer ID;

        private Integer entityRefID;

        private String entitySubTypeCode;

        private String vaultType;

        private String vaultData;

        private String activeCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Integer entityID;

        private Integer entityVersionID;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            this.entitySubTypeCode = entitySubTypeCode;
            return this;
        }

        public Builder vaultType(String vaultType) {
            this.vaultType = vaultType;
            return this;
        }

        public Builder vaultData(String vaultData) {
            this.vaultData = vaultData;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
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

        public Builder entityID(Integer entityID) {
            this.entityID = entityID;
            return this;
        }

        public Builder entityVersionID(Integer entityVersionID) {
            this.entityVersionID = entityVersionID;
            return this;
        }

        public FgVault build() {
            return new FgVault(ID, entityRefID, entitySubTypeCode, vaultType, vaultData, activeCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, entityID, entityVersionID);
        }
    }
}
