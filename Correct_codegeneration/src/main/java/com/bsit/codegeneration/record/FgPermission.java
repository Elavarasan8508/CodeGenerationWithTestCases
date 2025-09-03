package com.bsit.codegeneration.record;

import java.util.List;

public record FgPermission(Integer ID, String classCode, String fieldCode, String typeCode, String categoryCode, String subTypeCode, String operationCode, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, List<FgRolePermission> fgRolePermissions, List<FgGroup> fgGroups, List<FgGroupPermission> fgGroupPermissions) {

    public static class Builder {

        private Integer ID;

        private String classCode;

        private String fieldCode;

        private String typeCode;

        private String categoryCode;

        private String subTypeCode;

        private String operationCode;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private List<FgRolePermission> fgRolePermissions;

        private List<FgGroup> fgGroups;

        private List<FgGroupPermission> fgGroupPermissions;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder classCode(String classCode) {
            this.classCode = classCode;
            return this;
        }

        public Builder fieldCode(String fieldCode) {
            this.fieldCode = fieldCode;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder operationCode(String operationCode) {
            this.operationCode = operationCode;
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

        public Builder fgRolePermissions(List<FgRolePermission> fgRolePermissions) {
            this.fgRolePermissions = fgRolePermissions;
            return this;
        }

        public Builder fgGroups(List<FgGroup> fgGroups) {
            this.fgGroups = fgGroups;
            return this;
        }

        public Builder fgGroupPermissions(List<FgGroupPermission> fgGroupPermissions) {
            this.fgGroupPermissions = fgGroupPermissions;
            return this;
        }

        public FgPermission build() {
            return new FgPermission(ID, classCode, fieldCode, typeCode, categoryCode, subTypeCode, operationCode, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgRolePermissions, fgGroups, fgGroupPermissions);
        }
    }
}
