package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgIdpmsOrmGroupedInv {

    private String invNum;

    private java.math.BigDecimal utilAmt;

    private java.math.BigDecimal endorsedAmt;

    private Integer parentRefID;

    private Integer parentVersionID;

    private Integer isTemplate;

    private String template;

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private java.time.LocalDateTime createdOn;

    private java.time.LocalDateTime lastUpdatedOn;

    private java.time.LocalDateTime lastAuthorisedOn;

    private String createdBy;

    private String lastUpdatedBy;

    private String lastAuthorisedBy;

    public FgIdpmsOrmGroupedInv() {
    }

    public FgIdpmsOrmGroupedInv(String invNum, java.math.BigDecimal utilAmt, java.math.BigDecimal endorsedAmt, Integer parentRefID, Integer parentVersionID, Integer isTemplate, String template, Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, java.time.LocalDateTime createdOn, java.time.LocalDateTime lastUpdatedOn, java.time.LocalDateTime lastAuthorisedOn, String createdBy, String lastUpdatedBy, String lastAuthorisedBy) {
        this.invNum = invNum;
        this.utilAmt = utilAmt;
        this.endorsedAmt = endorsedAmt;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
        this.isTemplate = isTemplate;
        this.template = template;
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getInvNum() {
        return invNum;
    }

    public void setInvNum(String invNum) {
        this.invNum = invNum;
    }

    public java.math.BigDecimal getUtilAmt() {
        return utilAmt;
    }

    public void setUtilAmt(java.math.BigDecimal utilAmt) {
        this.utilAmt = utilAmt;
    }

    public java.math.BigDecimal getEndorsedAmt() {
        return endorsedAmt;
    }

    public void setEndorsedAmt(java.math.BigDecimal endorsedAmt) {
        this.endorsedAmt = endorsedAmt;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public java.time.LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(java.time.LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public java.time.LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(java.time.LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.time.LocalDateTime getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(java.time.LocalDateTime lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(String lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public static class Builder {

        private FgIdpmsOrmGroupedInv instance = new FgIdpmsOrmGroupedInv();

        public Builder invNum(String invNum) {
            instance.setInvNum(invNum);
            return this;
        }

        public Builder utilAmt(java.math.BigDecimal utilAmt) {
            instance.setUtilAmt(utilAmt);
            return this;
        }

        public Builder endorsedAmt(java.math.BigDecimal endorsedAmt) {
            instance.setEndorsedAmt(endorsedAmt);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder createdOn(java.time.LocalDateTime createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder lastUpdatedOn(java.time.LocalDateTime lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastAuthorisedOn(java.time.LocalDateTime lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder createdBy(String createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedBy(String lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedBy(String lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public FgIdpmsOrmGroupedInv build() {
            return instance;
        }
    }
}
