package com.bsit.codegeneration.record;

public record FgSecurityCredential(Long ID, String purposeCode, String partyCode, String partySubTypeCode, String userCode, String userSubTypeCode, String credentialTypeCode, String credentialValue, String expiresOn, String mobileNo, String imeiNo, String device, String deviceID, String deviceBrand, String deviceMfct, String deviceModel, String deviceProduct, String userName, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String credentialKey) {

    public static class Builder {

        private Long ID;

        private String purposeCode;

        private String partyCode;

        private String partySubTypeCode;

        private String userCode;

        private String userSubTypeCode;

        private String credentialTypeCode;

        private String credentialValue;

        private String expiresOn;

        private String mobileNo;

        private String imeiNo;

        private String device;

        private String deviceID;

        private String deviceBrand;

        private String deviceMfct;

        private String deviceModel;

        private String deviceProduct;

        private String userName;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String credentialKey;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            this.purposeCode = purposeCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder userSubTypeCode(String userSubTypeCode) {
            this.userSubTypeCode = userSubTypeCode;
            return this;
        }

        public Builder credentialTypeCode(String credentialTypeCode) {
            this.credentialTypeCode = credentialTypeCode;
            return this;
        }

        public Builder credentialValue(String credentialValue) {
            this.credentialValue = credentialValue;
            return this;
        }

        public Builder expiresOn(String expiresOn) {
            this.expiresOn = expiresOn;
            return this;
        }

        public Builder mobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Builder imeiNo(String imeiNo) {
            this.imeiNo = imeiNo;
            return this;
        }

        public Builder device(String device) {
            this.device = device;
            return this;
        }

        public Builder deviceID(String deviceID) {
            this.deviceID = deviceID;
            return this;
        }

        public Builder deviceBrand(String deviceBrand) {
            this.deviceBrand = deviceBrand;
            return this;
        }

        public Builder deviceMfct(String deviceMfct) {
            this.deviceMfct = deviceMfct;
            return this;
        }

        public Builder deviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
            return this;
        }

        public Builder deviceProduct(String deviceProduct) {
            this.deviceProduct = deviceProduct;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
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

        public Builder credentialKey(String credentialKey) {
            this.credentialKey = credentialKey;
            return this;
        }

        public FgSecurityCredential build() {
            return new FgSecurityCredential(ID, purposeCode, partyCode, partySubTypeCode, userCode, userSubTypeCode, credentialTypeCode, credentialValue, expiresOn, mobileNo, imeiNo, device, deviceID, deviceBrand, deviceMfct, deviceModel, deviceProduct, userName, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, credentialKey);
        }
    }
}
