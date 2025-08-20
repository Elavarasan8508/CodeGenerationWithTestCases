package com.bsit.codegeneration.record;

public record FgGroupPermission(Long ID, Long permissionID, Long groupID, Long groupVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, Long lastUpdatedBy, String lastUpdatedOn, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Long ID;

        private Long permissionID;

        private Long groupID;

        private Long groupVersionID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder permissionID(Long permissionID) {
            this.permissionID = permissionID;
            return this;
        }

        public Builder groupID(Long groupID) {
            this.groupID = groupID;
            return this;
        }

        public Builder groupVersionID(Long groupVersionID) {
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

        public FgGroupPermission build() {
            return new FgGroupPermission(ID, permissionID, groupID, groupVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedBy, lastUpdatedOn, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
