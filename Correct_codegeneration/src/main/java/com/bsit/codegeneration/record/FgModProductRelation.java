package com.bsit.codegeneration.record;

import java.util.List;

public record FgModProductRelation(Integer ID, Integer referenceID, String typeCode, String subTypeCode, Integer srcRefID, String srcTypeCode, String srcSubTypeCode, String srcRelationCode, String srcApplicantPartyRole, String srcApplicantPartyCode, String srcIssuingPartyRole, String srcIssuingPartyCode, Integer trgRefID, String trgTypeCode, String trgSubTypeCode, String trgRelationCode, String trgApplicantPartyRole, String trgApplicantPartyCode, String trgIssuingPartyRole, String trgIssuingPartyCode, Integer trgFormID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Integer srcVersionID, Integer trgVersionID) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private Integer srcRefID;

        private String srcTypeCode;

        private String srcSubTypeCode;

        private String srcRelationCode;

        private String srcApplicantPartyRole;

        private String srcApplicantPartyCode;

        private String srcIssuingPartyRole;

        private String srcIssuingPartyCode;

        private Integer trgRefID;

        private String trgTypeCode;

        private String trgSubTypeCode;

        private String trgRelationCode;

        private String trgApplicantPartyRole;

        private String trgApplicantPartyCode;

        private String trgIssuingPartyRole;

        private String trgIssuingPartyCode;

        private Integer trgFormID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Integer srcVersionID;

        private Integer trgVersionID;

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

        public Builder srcRefID(Integer srcRefID) {
            this.srcRefID = srcRefID;
            return this;
        }

        public Builder srcTypeCode(String srcTypeCode) {
            this.srcTypeCode = srcTypeCode;
            return this;
        }

        public Builder srcSubTypeCode(String srcSubTypeCode) {
            this.srcSubTypeCode = srcSubTypeCode;
            return this;
        }

        public Builder srcRelationCode(String srcRelationCode) {
            this.srcRelationCode = srcRelationCode;
            return this;
        }

        public Builder srcApplicantPartyRole(String srcApplicantPartyRole) {
            this.srcApplicantPartyRole = srcApplicantPartyRole;
            return this;
        }

        public Builder srcApplicantPartyCode(String srcApplicantPartyCode) {
            this.srcApplicantPartyCode = srcApplicantPartyCode;
            return this;
        }

        public Builder srcIssuingPartyRole(String srcIssuingPartyRole) {
            this.srcIssuingPartyRole = srcIssuingPartyRole;
            return this;
        }

        public Builder srcIssuingPartyCode(String srcIssuingPartyCode) {
            this.srcIssuingPartyCode = srcIssuingPartyCode;
            return this;
        }

        public Builder trgRefID(Integer trgRefID) {
            this.trgRefID = trgRefID;
            return this;
        }

        public Builder trgTypeCode(String trgTypeCode) {
            this.trgTypeCode = trgTypeCode;
            return this;
        }

        public Builder trgSubTypeCode(String trgSubTypeCode) {
            this.trgSubTypeCode = trgSubTypeCode;
            return this;
        }

        public Builder trgRelationCode(String trgRelationCode) {
            this.trgRelationCode = trgRelationCode;
            return this;
        }

        public Builder trgApplicantPartyRole(String trgApplicantPartyRole) {
            this.trgApplicantPartyRole = trgApplicantPartyRole;
            return this;
        }

        public Builder trgApplicantPartyCode(String trgApplicantPartyCode) {
            this.trgApplicantPartyCode = trgApplicantPartyCode;
            return this;
        }

        public Builder trgIssuingPartyRole(String trgIssuingPartyRole) {
            this.trgIssuingPartyRole = trgIssuingPartyRole;
            return this;
        }

        public Builder trgIssuingPartyCode(String trgIssuingPartyCode) {
            this.trgIssuingPartyCode = trgIssuingPartyCode;
            return this;
        }

        public Builder trgFormID(Integer trgFormID) {
            this.trgFormID = trgFormID;
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

        public Builder srcVersionID(Integer srcVersionID) {
            this.srcVersionID = srcVersionID;
            return this;
        }

        public Builder trgVersionID(Integer trgVersionID) {
            this.trgVersionID = trgVersionID;
            return this;
        }

        public FgModProductRelation build() {
            return new FgModProductRelation(ID, referenceID, typeCode, subTypeCode, srcRefID, srcTypeCode, srcSubTypeCode, srcRelationCode, srcApplicantPartyRole, srcApplicantPartyCode, srcIssuingPartyRole, srcIssuingPartyCode, trgRefID, trgTypeCode, trgSubTypeCode, trgRelationCode, trgApplicantPartyRole, trgApplicantPartyCode, trgIssuingPartyRole, trgIssuingPartyCode, trgFormID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, srcVersionID, trgVersionID);
        }
    }
}
