package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class SpringSession {

    private Integer primaryID;

    private Integer sessionID;

    private java.math.BigDecimal creationTime;

    private java.math.BigDecimal lastAccessTime;

    private Long maxInactiveInterval;

    private java.math.BigDecimal expiryTime;

    private String principalName;

    private SpringSessionAttributes sessionPrimary;

    private List<SpringSessionAttributes> springSessionAttributesList;

    public SpringSession() {
    }

    public SpringSession(Integer primaryID, Integer sessionID, java.math.BigDecimal creationTime, java.math.BigDecimal lastAccessTime, Long maxInactiveInterval, java.math.BigDecimal expiryTime, String principalName, SpringSessionAttributes sessionPrimary) {
        this.primaryID = primaryID;
        this.sessionID = sessionID;
        this.creationTime = creationTime;
        this.lastAccessTime = lastAccessTime;
        this.maxInactiveInterval = maxInactiveInterval;
        this.expiryTime = expiryTime;
        this.principalName = principalName;
        this.sessionPrimary = sessionPrimary;
    }

    public Integer getPrimaryID() {
        return primaryID;
    }

    public void setPrimaryID(Integer primaryID) {
        this.primaryID = primaryID;
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public java.math.BigDecimal getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(java.math.BigDecimal creationTime) {
        this.creationTime = creationTime;
    }

    public java.math.BigDecimal getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(java.math.BigDecimal lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(Long maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    public java.math.BigDecimal getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(java.math.BigDecimal expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public SpringSessionAttributes getSessionPrimary() {
        return sessionPrimary;
    }

    public void setSessionPrimary(SpringSessionAttributes sessionPrimary) {
        this.sessionPrimary = sessionPrimary;
    }

    public List<SpringSessionAttributes> getSpringSessionAttributesList() {
        return springSessionAttributesList;
    }

    public void setSpringSessionAttributesList(List<SpringSessionAttributes> springSessionAttributesList) {
        this.springSessionAttributesList = springSessionAttributesList;
    }

    public static class Builder {

        private SpringSession instance = new SpringSession();

        public Builder primaryID(Integer primaryID) {
            instance.setPrimaryID(primaryID);
            return this;
        }

        public Builder sessionID(Integer sessionID) {
            instance.setSessionID(sessionID);
            return this;
        }

        public Builder creationTime(java.math.BigDecimal creationTime) {
            instance.setCreationTime(creationTime);
            return this;
        }

        public Builder lastAccessTime(java.math.BigDecimal lastAccessTime) {
            instance.setLastAccessTime(lastAccessTime);
            return this;
        }

        public Builder maxInactiveInterval(Long maxInactiveInterval) {
            instance.setMaxInactiveInterval(maxInactiveInterval);
            return this;
        }

        public Builder expiryTime(java.math.BigDecimal expiryTime) {
            instance.setExpiryTime(expiryTime);
            return this;
        }

        public Builder principalName(String principalName) {
            instance.setPrincipalName(principalName);
            return this;
        }

        public Builder sessionPrimary(SpringSessionAttributes sessionPrimary) {
            instance.setSessionPrimary(sessionPrimary);
            return this;
        }

        public Builder springSessionAttributesList(List<SpringSessionAttributes> springSessionAttributesList) {
            instance.setSpringSessionAttributesList(springSessionAttributesList);
            return this;
        }

        public SpringSession build() {
            return instance;
        }
    }
}
