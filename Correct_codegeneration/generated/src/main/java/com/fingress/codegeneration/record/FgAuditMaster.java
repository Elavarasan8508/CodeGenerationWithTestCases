package com.bsit.codegeneration.record;

public record FgAuditMaster(String uuid, String partyCode, String userCode, String categoryCode, String typeCode, String source, String endpointCode, String entityCode, String eventCode, String serverityCode, String statusCode, String occuredOn, String sessionID, String sessionAddress, String entityRefID, String relOrgCode, String relOrgSubTypeCode, String relOrgTypeCode, String relOrgParentCode, String tokenValue, String endsOn) {

    public static class Builder {

        private String uuid;

        private String partyCode;

        private String userCode;

        private String categoryCode;

        private String typeCode;

        private String source;

        private String endpointCode;

        private String entityCode;

        private String eventCode;

        private String serverityCode;

        private String statusCode;

        private String occuredOn;

        private String sessionID;

        private String sessionAddress;

        private String entityRefID;

        private String relOrgCode;

        private String relOrgSubTypeCode;

        private String relOrgTypeCode;

        private String relOrgParentCode;

        private String tokenValue;

        private String endsOn;

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder partyCode(String partyCode) {
            this.partyCode = partyCode;
            return this;
        }

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public Builder endpointCode(String endpointCode) {
            this.endpointCode = endpointCode;
            return this;
        }

        public Builder entityCode(String entityCode) {
            this.entityCode = entityCode;
            return this;
        }

        public Builder eventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        public Builder serverityCode(String serverityCode) {
            this.serverityCode = serverityCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder occuredOn(String occuredOn) {
            this.occuredOn = occuredOn;
            return this;
        }

        public Builder sessionID(String sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public Builder sessionAddress(String sessionAddress) {
            this.sessionAddress = sessionAddress;
            return this;
        }

        public Builder entityRefID(String entityRefID) {
            this.entityRefID = entityRefID;
            return this;
        }

        public Builder relOrgCode(String relOrgCode) {
            this.relOrgCode = relOrgCode;
            return this;
        }

        public Builder relOrgSubTypeCode(String relOrgSubTypeCode) {
            this.relOrgSubTypeCode = relOrgSubTypeCode;
            return this;
        }

        public Builder relOrgTypeCode(String relOrgTypeCode) {
            this.relOrgTypeCode = relOrgTypeCode;
            return this;
        }

        public Builder relOrgParentCode(String relOrgParentCode) {
            this.relOrgParentCode = relOrgParentCode;
            return this;
        }

        public Builder tokenValue(String tokenValue) {
            this.tokenValue = tokenValue;
            return this;
        }

        public Builder endsOn(String endsOn) {
            this.endsOn = endsOn;
            return this;
        }

        public FgAuditMaster build() {
            return new FgAuditMaster(uuid, partyCode, userCode, categoryCode, typeCode, source, endpointCode, entityCode, eventCode, serverityCode, statusCode, occuredOn, sessionID, sessionAddress, entityRefID, relOrgCode, relOrgSubTypeCode, relOrgTypeCode, relOrgParentCode, tokenValue, endsOn);
        }
    }
}
