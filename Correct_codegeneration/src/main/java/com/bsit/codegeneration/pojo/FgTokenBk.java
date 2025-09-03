package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgTokenBk {

    private Integer ID;

    private String domainCode;

    private String userName;

    private Integer loginID;

    private String tokenName;

    private Integer status;

    private String reqSystem;

    private String issuedOn;

    private String accessedOn;

    private Integer valDuration;

    private String reqTime;

    private String expiresOn;

    private String createdDate;

    private java.math.BigDecimal createdBy;

    private java.math.BigDecimal lastUpdatedBy;

    private java.math.BigDecimal lastAuthorisedBy;

    private String createdOn;

    private String lastUpdatedOn;

    private String lastAuthorisedOn;

    private String tokenValue;

    private String channel;

    private String channelType;

    public FgTokenBk() {
    }

    public FgTokenBk(Integer ID, String domainCode, String userName, Integer loginID, String tokenName, Integer status, String reqSystem, String issuedOn, String accessedOn, Integer valDuration, String reqTime, String expiresOn, String createdDate, java.math.BigDecimal createdBy, java.math.BigDecimal lastUpdatedBy, java.math.BigDecimal lastAuthorisedBy, String createdOn, String lastUpdatedOn, String lastAuthorisedOn, String tokenValue, String channel, String channelType) {
        this.ID = ID;
        this.domainCode = domainCode;
        this.userName = userName;
        this.loginID = loginID;
        this.tokenName = tokenName;
        this.status = status;
        this.reqSystem = reqSystem;
        this.issuedOn = issuedOn;
        this.accessedOn = accessedOn;
        this.valDuration = valDuration;
        this.reqTime = reqTime;
        this.expiresOn = expiresOn;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.tokenValue = tokenValue;
        this.channel = channel;
        this.channelType = channelType;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReqSystem() {
        return reqSystem;
    }

    public void setReqSystem(String reqSystem) {
        this.reqSystem = reqSystem;
    }

    public String getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getAccessedOn() {
        return accessedOn;
    }

    public void setAccessedOn(String accessedOn) {
        this.accessedOn = accessedOn;
    }

    public Integer getValDuration() {
        return valDuration;
    }

    public void setValDuration(Integer valDuration) {
        this.valDuration = valDuration;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public static class Builder {

        private FgTokenBk instance = new FgTokenBk();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder domainCode(String domainCode) {
            instance.setDomainCode(domainCode);
            return this;
        }

        public Builder userName(String userName) {
            instance.setUserName(userName);
            return this;
        }

        public Builder loginID(Integer loginID) {
            instance.setLoginID(loginID);
            return this;
        }

        public Builder tokenName(String tokenName) {
            instance.setTokenName(tokenName);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder reqSystem(String reqSystem) {
            instance.setReqSystem(reqSystem);
            return this;
        }

        public Builder issuedOn(String issuedOn) {
            instance.setIssuedOn(issuedOn);
            return this;
        }

        public Builder accessedOn(String accessedOn) {
            instance.setAccessedOn(accessedOn);
            return this;
        }

        public Builder valDuration(Integer valDuration) {
            instance.setValDuration(valDuration);
            return this;
        }

        public Builder reqTime(String reqTime) {
            instance.setReqTime(reqTime);
            return this;
        }

        public Builder expiresOn(String expiresOn) {
            instance.setExpiresOn(expiresOn);
            return this;
        }

        public Builder createdDate(String createdDate) {
            instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder tokenValue(String tokenValue) {
            instance.setTokenValue(tokenValue);
            return this;
        }

        public Builder channel(String channel) {
            instance.setChannel(channel);
            return this;
        }

        public Builder channelType(String channelType) {
            instance.setChannelType(channelType);
            return this;
        }

        public FgTokenBk build() {
            return instance;
        }
    }
}
