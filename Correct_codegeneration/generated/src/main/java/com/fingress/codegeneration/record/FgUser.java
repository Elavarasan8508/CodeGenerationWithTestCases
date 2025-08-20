package com.bsit.codegeneration.record;

public record FgUser(Long ID, String userPassword, String userSecret, String userTypeCode, Long partyID, Long partyVersionID, Long isUsing2fa, Long firstTimeLogin, Long loginAttempts, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String userID, String lastAuthorisedOn, Long lastAuthorisedBy, Long isAuthoriseOwnTnx, String lastLoginTime, String currentLoginTime, String lastLogoutTime, String currSessionID, String lastSessionID) {

    public static class Builder {

        private Long ID;

        private String userPassword;

        private String userSecret;

        private String userTypeCode;

        private Long partyID;

        private Long partyVersionID;

        private Long isUsing2fa;

        private Long firstTimeLogin;

        private Long loginAttempts;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String userID;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Long isAuthoriseOwnTnx;

        private String lastLoginTime;

        private String currentLoginTime;

        private String lastLogoutTime;

        private String currSessionID;

        private String lastSessionID;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder userPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public Builder userSecret(String userSecret) {
            this.userSecret = userSecret;
            return this;
        }

        public Builder userTypeCode(String userTypeCode) {
            this.userTypeCode = userTypeCode;
            return this;
        }

        public Builder partyID(Long partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder isUsing2fa(Long isUsing2fa) {
            this.isUsing2fa = isUsing2fa;
            return this;
        }

        public Builder firstTimeLogin(Long firstTimeLogin) {
            this.firstTimeLogin = firstTimeLogin;
            return this;
        }

        public Builder loginAttempts(Long loginAttempts) {
            this.loginAttempts = loginAttempts;
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

        public Builder userID(String userID) {
            this.userID = userID;
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

        public Builder isAuthoriseOwnTnx(Long isAuthoriseOwnTnx) {
            this.isAuthoriseOwnTnx = isAuthoriseOwnTnx;
            return this;
        }

        public Builder lastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
            return this;
        }

        public Builder currentLoginTime(String currentLoginTime) {
            this.currentLoginTime = currentLoginTime;
            return this;
        }

        public Builder lastLogoutTime(String lastLogoutTime) {
            this.lastLogoutTime = lastLogoutTime;
            return this;
        }

        public Builder currSessionID(String currSessionID) {
            this.currSessionID = currSessionID;
            return this;
        }

        public Builder lastSessionID(String lastSessionID) {
            this.lastSessionID = lastSessionID;
            return this;
        }

        public FgUser build() {
            return new FgUser(ID, userPassword, userSecret, userTypeCode, partyID, partyVersionID, isUsing2fa, firstTimeLogin, loginAttempts, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, userID, lastAuthorisedOn, lastAuthorisedBy, isAuthoriseOwnTnx, lastLoginTime, currentLoginTime, lastLogoutTime, currSessionID, lastSessionID);
        }
    }
}
