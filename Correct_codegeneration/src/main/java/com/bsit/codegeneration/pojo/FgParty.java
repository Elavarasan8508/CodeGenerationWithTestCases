package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgParty {

    private Integer ID;

    private Integer versionID;

    private Integer isMasterVersion;

    private String isoCode;

    private String languageCode;

    private String name;

    private String timeZoneCode;

    private String typeCode;

    private String subTypeCode;

    private Integer referenceID;

    private String abbvName;

    private String currencyCode;

    private String description;

    private String configStatusCode;

    private String ownerPartyCode;

    private String addlCode01;

    private String addlCode02;

    private String addlCode03;

    private String addlCode04;

    private String addlCode05;

    private String addlCode06;

    private String addlCode07;

    private String addlCode08;

    private String addlCode09;

    private String addlCode10;

    private String addlCode11;

    private String addlCode12;

    private String addlCode13;

    private String addlCode14;

    private String addlCode15;

    private String addlCode16;

    private String addlCode17;

    private String addlCode18;

    private String addlCode19;

    private String addlCode20;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private Integer processID;

    private Integer uploadRefID;

    private String branchName;

    private String branchCode;

    private Integer attachmentID;

    private String partySubTypeCode;

    private String democracyTypeCode;

    private String democracySubTypeCode;

    private String constitutionTypeCode;

    private String parentPartyCode;

    private String systemSourceCode;

    private String empCode;

    private String taskReasonCode;

    private String taskReasonText;

    private String masterTemplate;

    private String transactionType;

    private String regStatus;

    private String migrationStatusCode;

    private String migrationSysCode;

    private String migrationSysRefCode;

    private String migrationDatetime;

    private String stageCode;

    private String boStatusCode;

    private String boStatusReference;

    private String boStatusReasson;

    private String boStatusMessage;

    private String portalEnablementStatusCode;

    private String channel;

    private String channelType;

    private String template;

    private FgPartyAddress party;

    private FgPartyAddress partyVersion;

    private FgPartyProfile org;

    private FgPartyProfile orgVersion;

    private FgPartyRelation fromParty;

    private FgPartyRelation toParty;

    private FgPartyRelation fromPartyVersion;

    private FgPartyRelation toPartyVersion;

    private List<FgBusinessCode> fgBusinessCodeList;

    private List<FgPartyAddress> fgPartyAddressList;

    private List<FgPartyContact> fgPartyContactList;

    private List<FgPartyProfile> fgPartyProfileList;

    private List<FgPartyRelation> fgPartyRelationList;

    private List<FgPartyRole> fgPartyRoleList;

    private List<FgScheduleCode> fgScheduleCodeList;

    private List<FgUser> fgUserList;

    public FgParty() {
    }

    public FgParty(Integer ID, Integer versionID, Integer isMasterVersion, String isoCode, String languageCode, String name, String timeZoneCode, String typeCode, String subTypeCode, Integer referenceID, String abbvName, String currencyCode, String description, String configStatusCode, String ownerPartyCode, String addlCode01, String addlCode02, String addlCode03, String addlCode04, String addlCode05, String addlCode06, String addlCode07, String addlCode08, String addlCode09, String addlCode10, String addlCode11, String addlCode12, String addlCode13, String addlCode14, String addlCode15, String addlCode16, String addlCode17, String addlCode18, String addlCode19, String addlCode20, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, Integer processID, Integer uploadRefID, String branchName, String branchCode, Integer attachmentID, String partySubTypeCode, String democracyTypeCode, String democracySubTypeCode, String constitutionTypeCode, String parentPartyCode, String systemSourceCode, String empCode, String taskReasonCode, String taskReasonText, String masterTemplate, String transactionType, String regStatus, String migrationStatusCode, String migrationSysCode, String migrationSysRefCode, String migrationDatetime, String stageCode, String boStatusCode, String boStatusReference, String boStatusReasson, String boStatusMessage, String portalEnablementStatusCode, String channel, String channelType, String template, FgPartyAddress party, FgPartyAddress partyVersion, FgPartyProfile org, FgPartyProfile orgVersion, FgPartyRelation fromParty, FgPartyRelation toParty, FgPartyRelation fromPartyVersion, FgPartyRelation toPartyVersion) {
        this.ID = ID;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.isoCode = isoCode;
        this.languageCode = languageCode;
        this.name = name;
        this.timeZoneCode = timeZoneCode;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.referenceID = referenceID;
        this.abbvName = abbvName;
        this.currencyCode = currencyCode;
        this.description = description;
        this.configStatusCode = configStatusCode;
        this.ownerPartyCode = ownerPartyCode;
        this.addlCode01 = addlCode01;
        this.addlCode02 = addlCode02;
        this.addlCode03 = addlCode03;
        this.addlCode04 = addlCode04;
        this.addlCode05 = addlCode05;
        this.addlCode06 = addlCode06;
        this.addlCode07 = addlCode07;
        this.addlCode08 = addlCode08;
        this.addlCode09 = addlCode09;
        this.addlCode10 = addlCode10;
        this.addlCode11 = addlCode11;
        this.addlCode12 = addlCode12;
        this.addlCode13 = addlCode13;
        this.addlCode14 = addlCode14;
        this.addlCode15 = addlCode15;
        this.addlCode16 = addlCode16;
        this.addlCode17 = addlCode17;
        this.addlCode18 = addlCode18;
        this.addlCode19 = addlCode19;
        this.addlCode20 = addlCode20;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.processID = processID;
        this.uploadRefID = uploadRefID;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.attachmentID = attachmentID;
        this.partySubTypeCode = partySubTypeCode;
        this.democracyTypeCode = democracyTypeCode;
        this.democracySubTypeCode = democracySubTypeCode;
        this.constitutionTypeCode = constitutionTypeCode;
        this.parentPartyCode = parentPartyCode;
        this.systemSourceCode = systemSourceCode;
        this.empCode = empCode;
        this.taskReasonCode = taskReasonCode;
        this.taskReasonText = taskReasonText;
        this.masterTemplate = masterTemplate;
        this.transactionType = transactionType;
        this.regStatus = regStatus;
        this.migrationStatusCode = migrationStatusCode;
        this.migrationSysCode = migrationSysCode;
        this.migrationSysRefCode = migrationSysRefCode;
        this.migrationDatetime = migrationDatetime;
        this.stageCode = stageCode;
        this.boStatusCode = boStatusCode;
        this.boStatusReference = boStatusReference;
        this.boStatusReasson = boStatusReasson;
        this.boStatusMessage = boStatusMessage;
        this.portalEnablementStatusCode = portalEnablementStatusCode;
        this.channel = channel;
        this.channelType = channelType;
        this.template = template;
        this.party = party;
        this.partyVersion = partyVersion;
        this.org = org;
        this.orgVersion = orgVersion;
        this.fromParty = fromParty;
        this.toParty = toParty;
        this.fromPartyVersion = fromPartyVersion;
        this.toPartyVersion = toPartyVersion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeZoneCode() {
        return timeZoneCode;
    }

    public void setTimeZoneCode(String timeZoneCode) {
        this.timeZoneCode = timeZoneCode;
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

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getAbbvName() {
        return abbvName;
    }

    public void setAbbvName(String abbvName) {
        this.abbvName = abbvName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConfigStatusCode() {
        return configStatusCode;
    }

    public void setConfigStatusCode(String configStatusCode) {
        this.configStatusCode = configStatusCode;
    }

    public String getOwnerPartyCode() {
        return ownerPartyCode;
    }

    public void setOwnerPartyCode(String ownerPartyCode) {
        this.ownerPartyCode = ownerPartyCode;
    }

    public String getAddlCode01() {
        return addlCode01;
    }

    public void setAddlCode01(String addlCode01) {
        this.addlCode01 = addlCode01;
    }

    public String getAddlCode02() {
        return addlCode02;
    }

    public void setAddlCode02(String addlCode02) {
        this.addlCode02 = addlCode02;
    }

    public String getAddlCode03() {
        return addlCode03;
    }

    public void setAddlCode03(String addlCode03) {
        this.addlCode03 = addlCode03;
    }

    public String getAddlCode04() {
        return addlCode04;
    }

    public void setAddlCode04(String addlCode04) {
        this.addlCode04 = addlCode04;
    }

    public String getAddlCode05() {
        return addlCode05;
    }

    public void setAddlCode05(String addlCode05) {
        this.addlCode05 = addlCode05;
    }

    public String getAddlCode06() {
        return addlCode06;
    }

    public void setAddlCode06(String addlCode06) {
        this.addlCode06 = addlCode06;
    }

    public String getAddlCode07() {
        return addlCode07;
    }

    public void setAddlCode07(String addlCode07) {
        this.addlCode07 = addlCode07;
    }

    public String getAddlCode08() {
        return addlCode08;
    }

    public void setAddlCode08(String addlCode08) {
        this.addlCode08 = addlCode08;
    }

    public String getAddlCode09() {
        return addlCode09;
    }

    public void setAddlCode09(String addlCode09) {
        this.addlCode09 = addlCode09;
    }

    public String getAddlCode10() {
        return addlCode10;
    }

    public void setAddlCode10(String addlCode10) {
        this.addlCode10 = addlCode10;
    }

    public String getAddlCode11() {
        return addlCode11;
    }

    public void setAddlCode11(String addlCode11) {
        this.addlCode11 = addlCode11;
    }

    public String getAddlCode12() {
        return addlCode12;
    }

    public void setAddlCode12(String addlCode12) {
        this.addlCode12 = addlCode12;
    }

    public String getAddlCode13() {
        return addlCode13;
    }

    public void setAddlCode13(String addlCode13) {
        this.addlCode13 = addlCode13;
    }

    public String getAddlCode14() {
        return addlCode14;
    }

    public void setAddlCode14(String addlCode14) {
        this.addlCode14 = addlCode14;
    }

    public String getAddlCode15() {
        return addlCode15;
    }

    public void setAddlCode15(String addlCode15) {
        this.addlCode15 = addlCode15;
    }

    public String getAddlCode16() {
        return addlCode16;
    }

    public void setAddlCode16(String addlCode16) {
        this.addlCode16 = addlCode16;
    }

    public String getAddlCode17() {
        return addlCode17;
    }

    public void setAddlCode17(String addlCode17) {
        this.addlCode17 = addlCode17;
    }

    public String getAddlCode18() {
        return addlCode18;
    }

    public void setAddlCode18(String addlCode18) {
        this.addlCode18 = addlCode18;
    }

    public String getAddlCode19() {
        return addlCode19;
    }

    public void setAddlCode19(String addlCode19) {
        this.addlCode19 = addlCode19;
    }

    public String getAddlCode20() {
        return addlCode20;
    }

    public void setAddlCode20(String addlCode20) {
        this.addlCode20 = addlCode20;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(Integer attachmentID) {
        this.attachmentID = attachmentID;
    }

    public String getPartySubTypeCode() {
        return partySubTypeCode;
    }

    public void setPartySubTypeCode(String partySubTypeCode) {
        this.partySubTypeCode = partySubTypeCode;
    }

    public String getDemocracyTypeCode() {
        return democracyTypeCode;
    }

    public void setDemocracyTypeCode(String democracyTypeCode) {
        this.democracyTypeCode = democracyTypeCode;
    }

    public String getDemocracySubTypeCode() {
        return democracySubTypeCode;
    }

    public void setDemocracySubTypeCode(String democracySubTypeCode) {
        this.democracySubTypeCode = democracySubTypeCode;
    }

    public String getConstitutionTypeCode() {
        return constitutionTypeCode;
    }

    public void setConstitutionTypeCode(String constitutionTypeCode) {
        this.constitutionTypeCode = constitutionTypeCode;
    }

    public String getParentPartyCode() {
        return parentPartyCode;
    }

    public void setParentPartyCode(String parentPartyCode) {
        this.parentPartyCode = parentPartyCode;
    }

    public String getSystemSourceCode() {
        return systemSourceCode;
    }

    public void setSystemSourceCode(String systemSourceCode) {
        this.systemSourceCode = systemSourceCode;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getTaskReasonCode() {
        return taskReasonCode;
    }

    public void setTaskReasonCode(String taskReasonCode) {
        this.taskReasonCode = taskReasonCode;
    }

    public String getTaskReasonText() {
        return taskReasonText;
    }

    public void setTaskReasonText(String taskReasonText) {
        this.taskReasonText = taskReasonText;
    }

    public String getMasterTemplate() {
        return masterTemplate;
    }

    public void setMasterTemplate(String masterTemplate) {
        this.masterTemplate = masterTemplate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }

    public String getMigrationStatusCode() {
        return migrationStatusCode;
    }

    public void setMigrationStatusCode(String migrationStatusCode) {
        this.migrationStatusCode = migrationStatusCode;
    }

    public String getMigrationSysCode() {
        return migrationSysCode;
    }

    public void setMigrationSysCode(String migrationSysCode) {
        this.migrationSysCode = migrationSysCode;
    }

    public String getMigrationSysRefCode() {
        return migrationSysRefCode;
    }

    public void setMigrationSysRefCode(String migrationSysRefCode) {
        this.migrationSysRefCode = migrationSysRefCode;
    }

    public String getMigrationDatetime() {
        return migrationDatetime;
    }

    public void setMigrationDatetime(String migrationDatetime) {
        this.migrationDatetime = migrationDatetime;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getBoStatusCode() {
        return boStatusCode;
    }

    public void setBoStatusCode(String boStatusCode) {
        this.boStatusCode = boStatusCode;
    }

    public String getBoStatusReference() {
        return boStatusReference;
    }

    public void setBoStatusReference(String boStatusReference) {
        this.boStatusReference = boStatusReference;
    }

    public String getBoStatusReasson() {
        return boStatusReasson;
    }

    public void setBoStatusReasson(String boStatusReasson) {
        this.boStatusReasson = boStatusReasson;
    }

    public String getBoStatusMessage() {
        return boStatusMessage;
    }

    public void setBoStatusMessage(String boStatusMessage) {
        this.boStatusMessage = boStatusMessage;
    }

    public String getPortalEnablementStatusCode() {
        return portalEnablementStatusCode;
    }

    public void setPortalEnablementStatusCode(String portalEnablementStatusCode) {
        this.portalEnablementStatusCode = portalEnablementStatusCode;
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

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public FgPartyAddress getParty() {
        return party;
    }

    public void setParty(FgPartyAddress party) {
        this.party = party;
    }

    public FgPartyAddress getPartyVersion() {
        return partyVersion;
    }

    public void setPartyVersion(FgPartyAddress partyVersion) {
        this.partyVersion = partyVersion;
    }

    public FgPartyProfile getOrg() {
        return org;
    }

    public void setOrg(FgPartyProfile org) {
        this.org = org;
    }

    public FgPartyProfile getOrgVersion() {
        return orgVersion;
    }

    public void setOrgVersion(FgPartyProfile orgVersion) {
        this.orgVersion = orgVersion;
    }

    public FgPartyRelation getFromParty() {
        return fromParty;
    }

    public void setFromParty(FgPartyRelation fromParty) {
        this.fromParty = fromParty;
    }

    public FgPartyRelation getToParty() {
        return toParty;
    }

    public void setToParty(FgPartyRelation toParty) {
        this.toParty = toParty;
    }

    public FgPartyRelation getFromPartyVersion() {
        return fromPartyVersion;
    }

    public void setFromPartyVersion(FgPartyRelation fromPartyVersion) {
        this.fromPartyVersion = fromPartyVersion;
    }

    public FgPartyRelation getToPartyVersion() {
        return toPartyVersion;
    }

    public void setToPartyVersion(FgPartyRelation toPartyVersion) {
        this.toPartyVersion = toPartyVersion;
    }

    public List<FgBusinessCode> getFgBusinessCodeList() {
        return fgBusinessCodeList;
    }

    public void setFgBusinessCodeList(List<FgBusinessCode> fgBusinessCodeList) {
        this.fgBusinessCodeList = fgBusinessCodeList;
    }

    public List<FgPartyAddress> getFgPartyAddressList() {
        return fgPartyAddressList;
    }

    public void setFgPartyAddressList(List<FgPartyAddress> fgPartyAddressList) {
        this.fgPartyAddressList = fgPartyAddressList;
    }

    public List<FgPartyContact> getFgPartyContactList() {
        return fgPartyContactList;
    }

    public void setFgPartyContactList(List<FgPartyContact> fgPartyContactList) {
        this.fgPartyContactList = fgPartyContactList;
    }

    public List<FgPartyProfile> getFgPartyProfileList() {
        return fgPartyProfileList;
    }

    public void setFgPartyProfileList(List<FgPartyProfile> fgPartyProfileList) {
        this.fgPartyProfileList = fgPartyProfileList;
    }

    public List<FgPartyRelation> getFgPartyRelationList() {
        return fgPartyRelationList;
    }

    public void setFgPartyRelationList(List<FgPartyRelation> fgPartyRelationList) {
        this.fgPartyRelationList = fgPartyRelationList;
    }

    public List<FgPartyRole> getFgPartyRoleList() {
        return fgPartyRoleList;
    }

    public void setFgPartyRoleList(List<FgPartyRole> fgPartyRoleList) {
        this.fgPartyRoleList = fgPartyRoleList;
    }

    public List<FgScheduleCode> getFgScheduleCodeList() {
        return fgScheduleCodeList;
    }

    public void setFgScheduleCodeList(List<FgScheduleCode> fgScheduleCodeList) {
        this.fgScheduleCodeList = fgScheduleCodeList;
    }

    public List<FgUser> getFgUserList() {
        return fgUserList;
    }

    public void setFgUserList(List<FgUser> fgUserList) {
        this.fgUserList = fgUserList;
    }

    public static class Builder {

        private FgParty instance = new FgParty();

        public Builder ID(Integer ID) {
            instance.setID(ID);
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

        public Builder isoCode(String isoCode) {
            instance.setIsoCode(isoCode);
            return this;
        }

        public Builder languageCode(String languageCode) {
            instance.setLanguageCode(languageCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder timeZoneCode(String timeZoneCode) {
            instance.setTimeZoneCode(timeZoneCode);
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

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder abbvName(String abbvName) {
            instance.setAbbvName(abbvName);
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            instance.setCurrencyCode(currencyCode);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder configStatusCode(String configStatusCode) {
            instance.setConfigStatusCode(configStatusCode);
            return this;
        }

        public Builder ownerPartyCode(String ownerPartyCode) {
            instance.setOwnerPartyCode(ownerPartyCode);
            return this;
        }

        public Builder addlCode01(String addlCode01) {
            instance.setAddlCode01(addlCode01);
            return this;
        }

        public Builder addlCode02(String addlCode02) {
            instance.setAddlCode02(addlCode02);
            return this;
        }

        public Builder addlCode03(String addlCode03) {
            instance.setAddlCode03(addlCode03);
            return this;
        }

        public Builder addlCode04(String addlCode04) {
            instance.setAddlCode04(addlCode04);
            return this;
        }

        public Builder addlCode05(String addlCode05) {
            instance.setAddlCode05(addlCode05);
            return this;
        }

        public Builder addlCode06(String addlCode06) {
            instance.setAddlCode06(addlCode06);
            return this;
        }

        public Builder addlCode07(String addlCode07) {
            instance.setAddlCode07(addlCode07);
            return this;
        }

        public Builder addlCode08(String addlCode08) {
            instance.setAddlCode08(addlCode08);
            return this;
        }

        public Builder addlCode09(String addlCode09) {
            instance.setAddlCode09(addlCode09);
            return this;
        }

        public Builder addlCode10(String addlCode10) {
            instance.setAddlCode10(addlCode10);
            return this;
        }

        public Builder addlCode11(String addlCode11) {
            instance.setAddlCode11(addlCode11);
            return this;
        }

        public Builder addlCode12(String addlCode12) {
            instance.setAddlCode12(addlCode12);
            return this;
        }

        public Builder addlCode13(String addlCode13) {
            instance.setAddlCode13(addlCode13);
            return this;
        }

        public Builder addlCode14(String addlCode14) {
            instance.setAddlCode14(addlCode14);
            return this;
        }

        public Builder addlCode15(String addlCode15) {
            instance.setAddlCode15(addlCode15);
            return this;
        }

        public Builder addlCode16(String addlCode16) {
            instance.setAddlCode16(addlCode16);
            return this;
        }

        public Builder addlCode17(String addlCode17) {
            instance.setAddlCode17(addlCode17);
            return this;
        }

        public Builder addlCode18(String addlCode18) {
            instance.setAddlCode18(addlCode18);
            return this;
        }

        public Builder addlCode19(String addlCode19) {
            instance.setAddlCode19(addlCode19);
            return this;
        }

        public Builder addlCode20(String addlCode20) {
            instance.setAddlCode20(addlCode20);
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

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder branchName(String branchName) {
            instance.setBranchName(branchName);
            return this;
        }

        public Builder branchCode(String branchCode) {
            instance.setBranchCode(branchCode);
            return this;
        }

        public Builder attachmentID(Integer attachmentID) {
            instance.setAttachmentID(attachmentID);
            return this;
        }

        public Builder partySubTypeCode(String partySubTypeCode) {
            instance.setPartySubTypeCode(partySubTypeCode);
            return this;
        }

        public Builder democracyTypeCode(String democracyTypeCode) {
            instance.setDemocracyTypeCode(democracyTypeCode);
            return this;
        }

        public Builder democracySubTypeCode(String democracySubTypeCode) {
            instance.setDemocracySubTypeCode(democracySubTypeCode);
            return this;
        }

        public Builder constitutionTypeCode(String constitutionTypeCode) {
            instance.setConstitutionTypeCode(constitutionTypeCode);
            return this;
        }

        public Builder parentPartyCode(String parentPartyCode) {
            instance.setParentPartyCode(parentPartyCode);
            return this;
        }

        public Builder systemSourceCode(String systemSourceCode) {
            instance.setSystemSourceCode(systemSourceCode);
            return this;
        }

        public Builder empCode(String empCode) {
            instance.setEmpCode(empCode);
            return this;
        }

        public Builder taskReasonCode(String taskReasonCode) {
            instance.setTaskReasonCode(taskReasonCode);
            return this;
        }

        public Builder taskReasonText(String taskReasonText) {
            instance.setTaskReasonText(taskReasonText);
            return this;
        }

        public Builder masterTemplate(String masterTemplate) {
            instance.setMasterTemplate(masterTemplate);
            return this;
        }

        public Builder transactionType(String transactionType) {
            instance.setTransactionType(transactionType);
            return this;
        }

        public Builder regStatus(String regStatus) {
            instance.setRegStatus(regStatus);
            return this;
        }

        public Builder migrationStatusCode(String migrationStatusCode) {
            instance.setMigrationStatusCode(migrationStatusCode);
            return this;
        }

        public Builder migrationSysCode(String migrationSysCode) {
            instance.setMigrationSysCode(migrationSysCode);
            return this;
        }

        public Builder migrationSysRefCode(String migrationSysRefCode) {
            instance.setMigrationSysRefCode(migrationSysRefCode);
            return this;
        }

        public Builder migrationDatetime(String migrationDatetime) {
            instance.setMigrationDatetime(migrationDatetime);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder boStatusCode(String boStatusCode) {
            instance.setBoStatusCode(boStatusCode);
            return this;
        }

        public Builder boStatusReference(String boStatusReference) {
            instance.setBoStatusReference(boStatusReference);
            return this;
        }

        public Builder boStatusReasson(String boStatusReasson) {
            instance.setBoStatusReasson(boStatusReasson);
            return this;
        }

        public Builder boStatusMessage(String boStatusMessage) {
            instance.setBoStatusMessage(boStatusMessage);
            return this;
        }

        public Builder portalEnablementStatusCode(String portalEnablementStatusCode) {
            instance.setPortalEnablementStatusCode(portalEnablementStatusCode);
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

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder party(FgPartyAddress party) {
            instance.setParty(party);
            return this;
        }

        public Builder partyVersion(FgPartyAddress partyVersion) {
            instance.setPartyVersion(partyVersion);
            return this;
        }

        public Builder org(FgPartyProfile org) {
            instance.setOrg(org);
            return this;
        }

        public Builder orgVersion(FgPartyProfile orgVersion) {
            instance.setOrgVersion(orgVersion);
            return this;
        }

        public Builder fromParty(FgPartyRelation fromParty) {
            instance.setFromParty(fromParty);
            return this;
        }

        public Builder toParty(FgPartyRelation toParty) {
            instance.setToParty(toParty);
            return this;
        }

        public Builder fromPartyVersion(FgPartyRelation fromPartyVersion) {
            instance.setFromPartyVersion(fromPartyVersion);
            return this;
        }

        public Builder toPartyVersion(FgPartyRelation toPartyVersion) {
            instance.setToPartyVersion(toPartyVersion);
            return this;
        }

        public Builder fgBusinessCodeList(List<FgBusinessCode> fgBusinessCodeList) {
            instance.setFgBusinessCodeList(fgBusinessCodeList);
            return this;
        }

        public Builder fgPartyAddressList(List<FgPartyAddress> fgPartyAddressList) {
            instance.setFgPartyAddressList(fgPartyAddressList);
            return this;
        }

        public Builder fgPartyContactList(List<FgPartyContact> fgPartyContactList) {
            instance.setFgPartyContactList(fgPartyContactList);
            return this;
        }

        public Builder fgPartyProfileList(List<FgPartyProfile> fgPartyProfileList) {
            instance.setFgPartyProfileList(fgPartyProfileList);
            return this;
        }

        public Builder fgPartyRelationList(List<FgPartyRelation> fgPartyRelationList) {
            instance.setFgPartyRelationList(fgPartyRelationList);
            return this;
        }

        public Builder fgPartyRoleList(List<FgPartyRole> fgPartyRoleList) {
            instance.setFgPartyRoleList(fgPartyRoleList);
            return this;
        }

        public Builder fgScheduleCodeList(List<FgScheduleCode> fgScheduleCodeList) {
            instance.setFgScheduleCodeList(fgScheduleCodeList);
            return this;
        }

        public Builder fgUserList(List<FgUser> fgUserList) {
            instance.setFgUserList(fgUserList);
            return this;
        }

        public FgParty build() {
            return instance;
        }
    }
}
