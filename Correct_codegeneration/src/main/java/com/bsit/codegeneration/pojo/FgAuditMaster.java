package com.bsit.codegeneration.pojo;

import java.util.List;

public class FgAuditMaster {

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

    private Integer sessionID;

    private String sessionAddress;

    private Integer entityRefID;

    private String relOrgCode;

    private String relOrgSubTypeCode;

    private String relOrgTypeCode;

    private String relOrgParentCode;

    private String tokenValue;

    private String endsOn;

    private List<FgAuditItem> fgAuditItemList;

    public FgAuditMaster() {
    }

    public FgAuditMaster(String uuid, String partyCode, String userCode, String categoryCode, String typeCode, String source, String endpointCode, String entityCode, String eventCode, String serverityCode, String statusCode, String occuredOn, Integer sessionID, String sessionAddress, Integer entityRefID, String relOrgCode, String relOrgSubTypeCode, String relOrgTypeCode, String relOrgParentCode, String tokenValue, String endsOn) {
        this.uuid = uuid;
        this.partyCode = partyCode;
        this.userCode = userCode;
        this.categoryCode = categoryCode;
        this.typeCode = typeCode;
        this.source = source;
        this.endpointCode = endpointCode;
        this.entityCode = entityCode;
        this.eventCode = eventCode;
        this.serverityCode = serverityCode;
        this.statusCode = statusCode;
        this.occuredOn = occuredOn;
        this.sessionID = sessionID;
        this.sessionAddress = sessionAddress;
        this.entityRefID = entityRefID;
        this.relOrgCode = relOrgCode;
        this.relOrgSubTypeCode = relOrgSubTypeCode;
        this.relOrgTypeCode = relOrgTypeCode;
        this.relOrgParentCode = relOrgParentCode;
        this.tokenValue = tokenValue;
        this.endsOn = endsOn;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEndpointCode() {
        return endpointCode;
    }

    public void setEndpointCode(String endpointCode) {
        this.endpointCode = endpointCode;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getServerityCode() {
        return serverityCode;
    }

    public void setServerityCode(String serverityCode) {
        this.serverityCode = serverityCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOccuredOn() {
        return occuredOn;
    }

    public void setOccuredOn(String occuredOn) {
        this.occuredOn = occuredOn;
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionAddress() {
        return sessionAddress;
    }

    public void setSessionAddress(String sessionAddress) {
        this.sessionAddress = sessionAddress;
    }

    public Integer getEntityRefID() {
        return entityRefID;
    }

    public void setEntityRefID(Integer entityRefID) {
        this.entityRefID = entityRefID;
    }

    public String getRelOrgCode() {
        return relOrgCode;
    }

    public void setRelOrgCode(String relOrgCode) {
        this.relOrgCode = relOrgCode;
    }

    public String getRelOrgSubTypeCode() {
        return relOrgSubTypeCode;
    }

    public void setRelOrgSubTypeCode(String relOrgSubTypeCode) {
        this.relOrgSubTypeCode = relOrgSubTypeCode;
    }

    public String getRelOrgTypeCode() {
        return relOrgTypeCode;
    }

    public void setRelOrgTypeCode(String relOrgTypeCode) {
        this.relOrgTypeCode = relOrgTypeCode;
    }

    public String getRelOrgParentCode() {
        return relOrgParentCode;
    }

    public void setRelOrgParentCode(String relOrgParentCode) {
        this.relOrgParentCode = relOrgParentCode;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(String endsOn) {
        this.endsOn = endsOn;
    }

    public List<FgAuditItem> getFgAuditItemList() {
        return fgAuditItemList;
    }

    public void setFgAuditItemList(List<FgAuditItem> fgAuditItemList) {
        this.fgAuditItemList = fgAuditItemList;
    }

    public static class Builder {

        private FgAuditMaster instance = new FgAuditMaster();

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder partyCode(String partyCode) {
            instance.setPartyCode(partyCode);
            return this;
        }

        public Builder userCode(String userCode) {
            instance.setUserCode(userCode);
            return this;
        }

        public Builder categoryCode(String categoryCode) {
            instance.setCategoryCode(categoryCode);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder source(String source) {
            instance.setSource(source);
            return this;
        }

        public Builder endpointCode(String endpointCode) {
            instance.setEndpointCode(endpointCode);
            return this;
        }

        public Builder entityCode(String entityCode) {
            instance.setEntityCode(entityCode);
            return this;
        }

        public Builder eventCode(String eventCode) {
            instance.setEventCode(eventCode);
            return this;
        }

        public Builder serverityCode(String serverityCode) {
            instance.setServerityCode(serverityCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder occuredOn(String occuredOn) {
            instance.setOccuredOn(occuredOn);
            return this;
        }

        public Builder sessionID(Integer sessionID) {
            instance.setSessionID(sessionID);
            return this;
        }

        public Builder sessionAddress(String sessionAddress) {
            instance.setSessionAddress(sessionAddress);
            return this;
        }

        public Builder entityRefID(Integer entityRefID) {
            instance.setEntityRefID(entityRefID);
            return this;
        }

        public Builder relOrgCode(String relOrgCode) {
            instance.setRelOrgCode(relOrgCode);
            return this;
        }

        public Builder relOrgSubTypeCode(String relOrgSubTypeCode) {
            instance.setRelOrgSubTypeCode(relOrgSubTypeCode);
            return this;
        }

        public Builder relOrgTypeCode(String relOrgTypeCode) {
            instance.setRelOrgTypeCode(relOrgTypeCode);
            return this;
        }

        public Builder relOrgParentCode(String relOrgParentCode) {
            instance.setRelOrgParentCode(relOrgParentCode);
            return this;
        }

        public Builder tokenValue(String tokenValue) {
            instance.setTokenValue(tokenValue);
            return this;
        }

        public Builder endsOn(String endsOn) {
            instance.setEndsOn(endsOn);
            return this;
        }

        public Builder fgAuditItemList(List<FgAuditItem> fgAuditItemList) {
            instance.setFgAuditItemList(fgAuditItemList);
            return this;
        }

        public FgAuditMaster build() {
            return instance;
        }
    }
}
