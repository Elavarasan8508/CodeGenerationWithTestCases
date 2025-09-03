package com.bsit.codegeneration.record;

import java.util.List;

public record FgUserRole(Integer ID, Integer roleID, Integer roleVersionID, Integer userID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgUser fgUser) {

    public static class Builder {

        private Integer ID;

        private Integer roleID;

        private Integer roleVersionID;

        private Integer userID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgUser fgUser;

        public Builder ID(Integer ID) {
            this.ID = ID;
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

        public Builder userID(Integer userID) {
            this.userID = userID;
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

        public Builder fgUser(FgUser fgUser) {
            this.fgUser = fgUser;
            return this;
        }

        public FgUserRole build() {
            return new FgUserRole(ID, roleID, roleVersionID, userID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgUser);
        }
    }
}
