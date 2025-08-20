package com.bsit.codegeneration.record;

public record FgTokenBk(String ID, String domainCode, String userName, String loginID, String tokenName, Long status, String reqSystem, String issuedOn, String accessedOn, Long valDuration, String reqTime, String expiresOn, String createdDate, Long createdBy, Long lastUpdatedBy, Long lastAuthorisedBy, String createdOn, String lastUpdatedOn, String lastAuthorisedOn, String tokenValue, String channel, String channelType) {

    public static class Builder {

        private String ID;

        private String domainCode;

        private String userName;

        private String loginID;

        private String tokenName;

        private Long status;

        private String reqSystem;

        private String issuedOn;

        private String accessedOn;

        private Long valDuration;

        private String reqTime;

        private String expiresOn;

        private String createdDate;

        private Long createdBy;

        private Long lastUpdatedBy;

        private Long lastAuthorisedBy;

        private String createdOn;

        private String lastUpdatedOn;

        private String lastAuthorisedOn;

        private String tokenValue;

        private String channel;

        private String channelType;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder domainCode(String domainCode) {
            this.domainCode = domainCode;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder loginID(String loginID) {
            this.loginID = loginID;
            return this;
        }

        public Builder tokenName(String tokenName) {
            this.tokenName = tokenName;
            return this;
        }

        public Builder status(Long status) {
            this.status = status;
            return this;
        }

        public Builder reqSystem(String reqSystem) {
            this.reqSystem = reqSystem;
            return this;
        }

        public Builder issuedOn(String issuedOn) {
            this.issuedOn = issuedOn;
            return this;
        }

        public Builder accessedOn(String accessedOn) {
            this.accessedOn = accessedOn;
            return this;
        }

        public Builder valDuration(Long valDuration) {
            this.valDuration = valDuration;
            return this;
        }

        public Builder reqTime(String reqTime) {
            this.reqTime = reqTime;
            return this;
        }

        public Builder expiresOn(String expiresOn) {
            this.expiresOn = expiresOn;
            return this;
        }

        public Builder createdDate(String createdDate) {
            this.createdDate = createdDate;
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

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
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

        public Builder tokenValue(String tokenValue) {
            this.tokenValue = tokenValue;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder channelType(String channelType) {
            this.channelType = channelType;
            return this;
        }

        public FgTokenBk build() {
            return new FgTokenBk(ID, domainCode, userName, loginID, tokenName, status, reqSystem, issuedOn, accessedOn, valDuration, reqTime, expiresOn, createdDate, createdBy, lastUpdatedBy, lastAuthorisedBy, createdOn, lastUpdatedOn, lastAuthorisedOn, tokenValue, channel, channelType);
        }
    }
}
