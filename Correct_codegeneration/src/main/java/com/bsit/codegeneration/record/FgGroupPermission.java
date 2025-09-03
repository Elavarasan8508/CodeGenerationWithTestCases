package com.bsit.codegeneration.record;

import java.util.List;

public record FgGroupPermission(Integer ID, Integer permissionID, Integer groupID, Integer groupVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, Long lastUpdatedBy, String lastUpdatedOn, String lastAuthorisedOn, Long lastAuthorisedBy, FgGroup fgGroup, FgPermission fgPermission) {

    public static class Builder {

        private Integer ID;

        private Integer permissionID;

        private Integer groupID;

        private Integer groupVersionID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgGroup fgGroup;

        private FgPermission fgPermission;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder permissionID(Integer permissionID) {
            this.permissionID = permissionID;
            return this;
        }

        public Builder groupID(Integer groupID) {
            this.groupID = groupID;
            return this;
        }

        public Builder groupVersionID(Integer groupVersionID) {
            this.groupVersionID = groupVersionID;
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

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
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

        public Builder fgGroup(FgGroup fgGroup) {
            this.fgGroup = fgGroup;
            return this;
        }

        public Builder fgPermission(FgPermission fgPermission) {
            this.fgPermission = fgPermission;
            return this;
        }

        public FgGroupPermission build() {
            return new FgGroupPermission(ID, permissionID, groupID, groupVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedBy, lastUpdatedOn, lastAuthorisedOn, lastAuthorisedBy, fgGroup, fgPermission);
        }
    }
}
