package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgTdLimitConfig {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

    private java.math.BigDecimal liqMaxLimit;

    private java.math.BigDecimal minBookLimit;

    private java.math.BigDecimal maxBookLimit;

    private java.math.BigDecimal dailyBookingLimit;

    private java.math.BigDecimal tenorMaxAmount;

    private Long tenorMinDays;

    private Long tenorMaxDays;

    private String schemeCodes;

    private java.math.BigDecimal aboveAmt;

    private java.math.BigDecimal belowAmt;

    private Long aStartNumber;

    private String aStartType;

    private Long aEndNumber;

    private String aEndType;

    private Long bStartNumber;

    private String bStartType;

    private Long bEndNumber;

    private String bEndType;

    private Integer versionID;

    private Integer isMasterVersion;

    private Integer parentRefID;

    private Integer parentID;

    private Integer parentVersionID;

    private String aboveRange;

    private String belowRange;

    private String taskReason;

    private Long minTenor;

    private Long maxTenor;

    private String minTenorType;

    private String maxTenorType;

    private String origin;

    private String tdType;

    public FgTdLimitConfig() {
    }

    public FgTdLimitConfig(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, java.math.BigDecimal liqMaxLimit, java.math.BigDecimal minBookLimit, java.math.BigDecimal maxBookLimit, java.math.BigDecimal dailyBookingLimit, java.math.BigDecimal tenorMaxAmount, Long tenorMinDays, Long tenorMaxDays, String schemeCodes, java.math.BigDecimal aboveAmt, java.math.BigDecimal belowAmt, Long aStartNumber, String aStartType, Long aEndNumber, String aEndType, Long bStartNumber, String bStartType, Long bEndNumber, String bEndType, Integer versionID, Integer isMasterVersion, Integer parentRefID, Integer parentID, Integer parentVersionID, String aboveRange, String belowRange, String taskReason, Long minTenor, Long maxTenor, String minTenorType, String maxTenorType, String origin, String tdType) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.liqMaxLimit = liqMaxLimit;
        this.minBookLimit = minBookLimit;
        this.maxBookLimit = maxBookLimit;
        this.dailyBookingLimit = dailyBookingLimit;
        this.tenorMaxAmount = tenorMaxAmount;
        this.tenorMinDays = tenorMinDays;
        this.tenorMaxDays = tenorMaxDays;
        this.schemeCodes = schemeCodes;
        this.aboveAmt = aboveAmt;
        this.belowAmt = belowAmt;
        this.aStartNumber = aStartNumber;
        this.aStartType = aStartType;
        this.aEndNumber = aEndNumber;
        this.aEndType = aEndType;
        this.bStartNumber = bStartNumber;
        this.bStartType = bStartType;
        this.bEndNumber = bEndNumber;
        this.bEndType = bEndType;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.parentRefID = parentRefID;
        this.parentID = parentID;
        this.parentVersionID = parentVersionID;
        this.aboveRange = aboveRange;
        this.belowRange = belowRange;
        this.taskReason = taskReason;
        this.minTenor = minTenor;
        this.maxTenor = maxTenor;
        this.minTenorType = minTenorType;
        this.maxTenorType = maxTenorType;
        this.origin = origin;
        this.tdType = tdType;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public java.math.BigDecimal getLiqMaxLimit() {
        return liqMaxLimit;
    }

    public void setLiqMaxLimit(java.math.BigDecimal liqMaxLimit) {
        this.liqMaxLimit = liqMaxLimit;
    }

    public java.math.BigDecimal getMinBookLimit() {
        return minBookLimit;
    }

    public void setMinBookLimit(java.math.BigDecimal minBookLimit) {
        this.minBookLimit = minBookLimit;
    }

    public java.math.BigDecimal getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(java.math.BigDecimal maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public java.math.BigDecimal getDailyBookingLimit() {
        return dailyBookingLimit;
    }

    public void setDailyBookingLimit(java.math.BigDecimal dailyBookingLimit) {
        this.dailyBookingLimit = dailyBookingLimit;
    }

    public java.math.BigDecimal getTenorMaxAmount() {
        return tenorMaxAmount;
    }

    public void setTenorMaxAmount(java.math.BigDecimal tenorMaxAmount) {
        this.tenorMaxAmount = tenorMaxAmount;
    }

    public Long getTenorMinDays() {
        return tenorMinDays;
    }

    public void setTenorMinDays(Long tenorMinDays) {
        this.tenorMinDays = tenorMinDays;
    }

    public Long getTenorMaxDays() {
        return tenorMaxDays;
    }

    public void setTenorMaxDays(Long tenorMaxDays) {
        this.tenorMaxDays = tenorMaxDays;
    }

    public String getSchemeCodes() {
        return schemeCodes;
    }

    public void setSchemeCodes(String schemeCodes) {
        this.schemeCodes = schemeCodes;
    }

    public java.math.BigDecimal getAboveAmt() {
        return aboveAmt;
    }

    public void setAboveAmt(java.math.BigDecimal aboveAmt) {
        this.aboveAmt = aboveAmt;
    }

    public java.math.BigDecimal getBelowAmt() {
        return belowAmt;
    }

    public void setBelowAmt(java.math.BigDecimal belowAmt) {
        this.belowAmt = belowAmt;
    }

    public Long getAStartNumber() {
        return aStartNumber;
    }

    public void setAStartNumber(Long aStartNumber) {
        this.aStartNumber = aStartNumber;
    }

    public String getAStartType() {
        return aStartType;
    }

    public void setAStartType(String aStartType) {
        this.aStartType = aStartType;
    }

    public Long getAEndNumber() {
        return aEndNumber;
    }

    public void setAEndNumber(Long aEndNumber) {
        this.aEndNumber = aEndNumber;
    }

    public String getAEndType() {
        return aEndType;
    }

    public void setAEndType(String aEndType) {
        this.aEndType = aEndType;
    }

    public Long getBStartNumber() {
        return bStartNumber;
    }

    public void setBStartNumber(Long bStartNumber) {
        this.bStartNumber = bStartNumber;
    }

    public String getBStartType() {
        return bStartType;
    }

    public void setBStartType(String bStartType) {
        this.bStartType = bStartType;
    }

    public Long getBEndNumber() {
        return bEndNumber;
    }

    public void setBEndNumber(Long bEndNumber) {
        this.bEndNumber = bEndNumber;
    }

    public String getBEndType() {
        return bEndType;
    }

    public void setBEndType(String bEndType) {
        this.bEndType = bEndType;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public String getAboveRange() {
        return aboveRange;
    }

    public void setAboveRange(String aboveRange) {
        this.aboveRange = aboveRange;
    }

    public String getBelowRange() {
        return belowRange;
    }

    public void setBelowRange(String belowRange) {
        this.belowRange = belowRange;
    }

    public String getTaskReason() {
        return taskReason;
    }

    public void setTaskReason(String taskReason) {
        this.taskReason = taskReason;
    }

    public Long getMinTenor() {
        return minTenor;
    }

    public void setMinTenor(Long minTenor) {
        this.minTenor = minTenor;
    }

    public Long getMaxTenor() {
        return maxTenor;
    }

    public void setMaxTenor(Long maxTenor) {
        this.maxTenor = maxTenor;
    }

    public String getMinTenorType() {
        return minTenorType;
    }

    public void setMinTenorType(String minTenorType) {
        this.minTenorType = minTenorType;
    }

    public String getMaxTenorType() {
        return maxTenorType;
    }

    public void setMaxTenorType(String maxTenorType) {
        this.maxTenorType = maxTenorType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTdType() {
        return tdType;
    }

    public void setTdType(String tdType) {
        this.tdType = tdType;
    }

    public static class Builder {

        private FgTdLimitConfig instance = new FgTdLimitConfig();

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

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder liqMaxLimit(java.math.BigDecimal liqMaxLimit) {
            instance.setLiqMaxLimit(liqMaxLimit);
            return this;
        }

        public Builder minBookLimit(java.math.BigDecimal minBookLimit) {
            instance.setMinBookLimit(minBookLimit);
            return this;
        }

        public Builder maxBookLimit(java.math.BigDecimal maxBookLimit) {
            instance.setMaxBookLimit(maxBookLimit);
            return this;
        }

        public Builder dailyBookingLimit(java.math.BigDecimal dailyBookingLimit) {
            instance.setDailyBookingLimit(dailyBookingLimit);
            return this;
        }

        public Builder tenorMaxAmount(java.math.BigDecimal tenorMaxAmount) {
            instance.setTenorMaxAmount(tenorMaxAmount);
            return this;
        }

        public Builder tenorMinDays(Long tenorMinDays) {
            instance.setTenorMinDays(tenorMinDays);
            return this;
        }

        public Builder tenorMaxDays(Long tenorMaxDays) {
            instance.setTenorMaxDays(tenorMaxDays);
            return this;
        }

        public Builder schemeCodes(String schemeCodes) {
            instance.setSchemeCodes(schemeCodes);
            return this;
        }

        public Builder aboveAmt(java.math.BigDecimal aboveAmt) {
            instance.setAboveAmt(aboveAmt);
            return this;
        }

        public Builder belowAmt(java.math.BigDecimal belowAmt) {
            instance.setBelowAmt(belowAmt);
            return this;
        }

        public Builder aStartNumber(Long aStartNumber) {
            instance.setAStartNumber(aStartNumber);
            return this;
        }

        public Builder aStartType(String aStartType) {
            instance.setAStartType(aStartType);
            return this;
        }

        public Builder aEndNumber(Long aEndNumber) {
            instance.setAEndNumber(aEndNumber);
            return this;
        }

        public Builder aEndType(String aEndType) {
            instance.setAEndType(aEndType);
            return this;
        }

        public Builder bStartNumber(Long bStartNumber) {
            instance.setBStartNumber(bStartNumber);
            return this;
        }

        public Builder bStartType(String bStartType) {
            instance.setBStartType(bStartType);
            return this;
        }

        public Builder bEndNumber(Long bEndNumber) {
            instance.setBEndNumber(bEndNumber);
            return this;
        }

        public Builder bEndType(String bEndType) {
            instance.setBEndType(bEndType);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentID(Integer parentID) {
            instance.setParentID(parentID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public Builder aboveRange(String aboveRange) {
            instance.setAboveRange(aboveRange);
            return this;
        }

        public Builder belowRange(String belowRange) {
            instance.setBelowRange(belowRange);
            return this;
        }

        public Builder taskReason(String taskReason) {
            instance.setTaskReason(taskReason);
            return this;
        }

        public Builder minTenor(Long minTenor) {
            instance.setMinTenor(minTenor);
            return this;
        }

        public Builder maxTenor(Long maxTenor) {
            instance.setMaxTenor(maxTenor);
            return this;
        }

        public Builder minTenorType(String minTenorType) {
            instance.setMinTenorType(minTenorType);
            return this;
        }

        public Builder maxTenorType(String maxTenorType) {
            instance.setMaxTenorType(maxTenorType);
            return this;
        }

        public Builder origin(String origin) {
            instance.setOrigin(origin);
            return this;
        }

        public Builder tdType(String tdType) {
            instance.setTdType(tdType);
            return this;
        }

        public FgTdLimitConfig build() {
            return instance;
        }
    }
}
