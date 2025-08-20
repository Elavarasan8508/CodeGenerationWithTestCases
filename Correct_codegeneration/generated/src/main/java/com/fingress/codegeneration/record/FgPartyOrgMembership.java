package com.bsit.codegeneration.record;

public record FgPartyOrgMembership(Long ID, Long partyID, Long partyVersionID, String partySubTypeCode, String partyCode, String memberCatCode, String memberTypeCode, String memberSubTypeCode, Long partyUserID, Long partyUserVersionID, String userLoginID, String name, Long age, String address, String qualification, String designationCode, String titleCode, String netWorth, String relationshipCode, String shareHoldingCode, String sharePercentage, String comments, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String userSubTypeCode, String emailID, String phoneNo) {

    public static class Builder {

        private Long ID;

        private Long partyID;

        private Long partyVersionID;

        private String partySubTypeCode;

        private String partyCode;

        private String memberCatCode;

        private String memberTypeCode;

        private String memberSubTypeCode;

        private Long partyUserID;

        private Long partyUserVersionID;

        private String userLoginID;

        private String name;

        private Long age;

        private String address;

        private String qualification;

        private String designationCode;

        private String titleCode;

        private String netWorth;

        private String relationshipCode;

        private String shareHoldingCode;

        private String sharePercentage;

        private String comments;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String userSubTypeCode;

        private String emailID;

        private String phoneNo;

        public Builder ID(Long ID) {
            this.ID = ID;
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

        public Builder partySubTypeCode(String partySubTypeCode) {
            this.partySubTypeCode = partySubTypeCode;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder memberCatCode(String memberCatCode) {
            this.memberCatCode = memberCatCode;
            return this;
        }

        public Builder memberTypeCode(String memberTypeCode) {
            this.memberTypeCode = memberTypeCode;
            return this;
        }

        public Builder memberSubTypeCode(String memberSubTypeCode) {
            this.memberSubTypeCode = memberSubTypeCode;
            return this;
        }

        public Builder partyUserID(Long partyUserID) {
            this.partyUserID = partyUserID;
            return this;
        }

        public Builder partyUserVersionID(Long partyUserVersionID) {
            this.partyUserVersionID = partyUserVersionID;
            return this;
        }

        public Builder userLoginID(String userLoginID) {
            this.userLoginID = userLoginID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Long age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder qualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Builder designationCode(String designationCode) {
            this.designationCode = designationCode;
            return this;
        }

        public Builder titleCode(String titleCode) {
            this.titleCode = titleCode;
            return this;
        }

        public Builder netWorth(String netWorth) {
            this.netWorth = netWorth;
            return this;
        }

        public Builder relationshipCode(String relationshipCode) {
            this.relationshipCode = relationshipCode;
            return this;
        }

        public Builder shareHoldingCode(String shareHoldingCode) {
            this.shareHoldingCode = shareHoldingCode;
            return this;
        }

        public Builder sharePercentage(String sharePercentage) {
            this.sharePercentage = sharePercentage;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
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

        public Builder userSubTypeCode(String userSubTypeCode) {
            this.userSubTypeCode = userSubTypeCode;
            return this;
        }

        public Builder emailID(String emailID) {
            this.emailID = emailID;
            return this;
        }

        public Builder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public FgPartyOrgMembership build() {
            return new FgPartyOrgMembership(ID, partyID, partyVersionID, partySubTypeCode, partyCode, memberCatCode, memberTypeCode, memberSubTypeCode, partyUserID, partyUserVersionID, userLoginID, name, age, address, qualification, designationCode, titleCode, netWorth, relationshipCode, shareHoldingCode, sharePercentage, comments, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, userSubTypeCode, emailID, phoneNo);
        }
    }
}
