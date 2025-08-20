package com.bsit.codegeneration.record;

public record FgRolePermission(Long ID, Long permissionID, Long roleID, Long roleVersionID, String activeCode, String statusCode, String createdOn, Long createdBy, Long lastUpdatedBy, String lastUpdatedOn, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Long ID;

        private Long permissionID;

        private Long roleID;

        private Long roleVersionID;

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

        public Builder roleID(Long roleID) {
            this.roleID = roleID;
            return this;
        }

        public Builder roleVersionID(Long roleVersionID) {
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

        public FgRolePermission build() {
            return new FgRolePermission(ID, permissionID, roleID, roleVersionID, activeCode, statusCode, createdOn, createdBy, lastUpdatedBy, lastUpdatedOn, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
