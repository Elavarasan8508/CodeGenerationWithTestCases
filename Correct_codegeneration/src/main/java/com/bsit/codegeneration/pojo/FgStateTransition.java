package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgStateTransition {

    private Integer ID;

    private String actionCode;

    private String actionName;

    private String startStateCode;

    private String targetStateCode;

    private String activeCode;

    private String statusCode;

    private java.math.BigDecimal createdBy;

    private String createdOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String lastAuthorisedOn;

    public FgStateTransition() {
    }

    public FgStateTransition(Integer ID, String actionCode, String actionName, String startStateCode, String targetStateCode, String activeCode, String statusCode, java.math.BigDecimal createdBy, String createdOn, java.math.BigDecimal lastUpdatedBy, String lastUpdatedOn, java.math.BigDecimal lastAuthorisedBy, String lastAuthorisedOn) {
        this.ID = ID;
        this.actionCode = actionCode;
        this.actionName = actionName;
        this.startStateCode = startStateCode;
        this.targetStateCode = targetStateCode;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getStartStateCode() {
        return startStateCode;
    }

    public void setStartStateCode(String startStateCode) {
        this.startStateCode = startStateCode;
    }

    public String getTargetStateCode() {
        return targetStateCode;
    }

    public void setTargetStateCode(String targetStateCode) {
        this.targetStateCode = targetStateCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public static class Builder {

        private FgStateTransition instance = new FgStateTransition();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder actionCode(String actionCode) {
            instance.setActionCode(actionCode);
            return this;
        }

        public Builder actionName(String actionName) {
            instance.setActionName(actionName);
            return this;
        }

        public Builder startStateCode(String startStateCode) {
            instance.setStartStateCode(startStateCode);
            return this;
        }

        public Builder targetStateCode(String targetStateCode) {
            instance.setTargetStateCode(targetStateCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public FgStateTransition build() {
            return instance;
        }
    }
}
