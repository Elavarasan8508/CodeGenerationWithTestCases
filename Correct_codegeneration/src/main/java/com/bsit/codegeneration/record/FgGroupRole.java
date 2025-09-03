package com.bsit.codegeneration.record;

import java.util.List;

public record FgGroupRole(Integer ID, Integer groupID, Integer groupVersionID, Integer roleID, Integer roleVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgGroup fgGroup, FgRole fgRole) {

    public static class Builder {

        private Integer ID;

        private Integer groupID;

        private Integer groupVersionID;

        private Integer roleID;

        private Integer roleVersionID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgGroup fgGroup;

        private FgRole fgRole;

        public Builder ID(Integer ID) {
            this.ID = ID;
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

        public Builder roleID(Integer roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder roleVersionID(Integer roleVersionID) {
            this.roleVersionID = roleVersionID;
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

        public Builder fgGroup(FgGroup fgGroup) {
            this.fgGroup = fgGroup;
            return this;
        }

        public Builder fgRole(FgRole fgRole) {
            this.fgRole = fgRole;
            return this;
        }

        public FgGroupRole build() {
            return new FgGroupRole(ID, groupID, groupVersionID, roleID, roleVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgGroup, fgRole);
        }
    }
}
