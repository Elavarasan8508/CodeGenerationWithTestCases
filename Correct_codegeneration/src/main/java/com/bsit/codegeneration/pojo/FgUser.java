package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgUser {

    private Integer ID;

    private String userPassword;

    private String userSecret;

    private String userTypeCode;

    private Integer partyID;

    private Integer partyVersionID;

    private Integer isUsing2fa;

    private java.math.BigDecimal firstTimeLogin;

    private java.math.BigDecimal loginAttempts;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private Integer userID;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private Integer isAuthoriseOwnTnx;

    private String lastLoginTime;

    private String currentLoginTime;

    private String lastLogoutTime;

    private Integer currSessionID;

    private Integer lastSessionID;

    private FgParty party;

    private FgParty partyVersion;

    private FgUserRole user;

    private List<FgUserRole> fgUserRoleList;

    public FgUser() {
    }

    public FgUser(Integer ID, String userPassword, String userSecret, String userTypeCode, Integer partyID, Integer partyVersionID, Integer isUsing2fa, java.math.BigDecimal firstTimeLogin, java.math.BigDecimal loginAttempts, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, Integer userID, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, Integer isAuthoriseOwnTnx, String lastLoginTime, String currentLoginTime, String lastLogoutTime, Integer currSessionID, Integer lastSessionID, FgParty party, FgParty partyVersion, FgUserRole user) {
        this.ID = ID;
        this.userPassword = userPassword;
        this.userSecret = userSecret;
        this.userTypeCode = userTypeCode;
        this.partyID = partyID;
        this.partyVersionID = partyVersionID;
        this.isUsing2fa = isUsing2fa;
        this.firstTimeLogin = firstTimeLogin;
        this.loginAttempts = loginAttempts;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.userID = userID;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.isAuthoriseOwnTnx = isAuthoriseOwnTnx;
        this.lastLoginTime = lastLoginTime;
        this.currentLoginTime = currentLoginTime;
        this.lastLogoutTime = lastLogoutTime;
        this.currSessionID = currSessionID;
        this.lastSessionID = lastSessionID;
        this.party = party;
        this.partyVersion = partyVersion;
        this.user = user;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public Integer getPartyID() {
        return partyID;
    }

    public void setPartyID(Integer partyID) {
        this.partyID = partyID;
    }

    public Integer getPartyVersionID() {
        return partyVersionID;
    }

    public void setPartyVersionID(Integer partyVersionID) {
        this.partyVersionID = partyVersionID;
    }

    public Integer getIsUsing2fa() {
        return isUsing2fa;
    }

    public void setIsUsing2fa(Integer isUsing2fa) {
        this.isUsing2fa = isUsing2fa;
    }

    public java.math.BigDecimal getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(java.math.BigDecimal firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public java.math.BigDecimal getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(java.math.BigDecimal loginAttempts) {
        this.loginAttempts = loginAttempts;
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

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public Integer getIsAuthoriseOwnTnx() {
        return isAuthoriseOwnTnx;
    }

    public void setIsAuthoriseOwnTnx(Integer isAuthoriseOwnTnx) {
        this.isAuthoriseOwnTnx = isAuthoriseOwnTnx;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCurrentLoginTime() {
        return currentLoginTime;
    }

    public void setCurrentLoginTime(String currentLoginTime) {
        this.currentLoginTime = currentLoginTime;
    }

    public String getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(String lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public Integer getCurrSessionID() {
        return currSessionID;
    }

    public void setCurrSessionID(Integer currSessionID) {
        this.currSessionID = currSessionID;
    }

    public Integer getLastSessionID() {
        return lastSessionID;
    }

    public void setLastSessionID(Integer lastSessionID) {
        this.lastSessionID = lastSessionID;
    }

    public FgParty getParty() {
        return party;
    }

    public void setParty(FgParty party) {
        this.party = party;
    }

    public FgParty getPartyVersion() {
        return partyVersion;
    }

    public void setPartyVersion(FgParty partyVersion) {
        this.partyVersion = partyVersion;
    }

    public FgUserRole getUser() {
        return user;
    }

    public void setUser(FgUserRole user) {
        this.user = user;
    }

    public List<FgUserRole> getFgUserRoleList() {
        return fgUserRoleList;
    }

    public void setFgUserRoleList(List<FgUserRole> fgUserRoleList) {
        this.fgUserRoleList = fgUserRoleList;
    }

    public static class Builder {

        private FgUser instance = new FgUser();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder userPassword(String userPassword) {
            instance.setUserPassword(userPassword);
            return this;
        }

        public Builder userSecret(String userSecret) {
            instance.setUserSecret(userSecret);
            return this;
        }

        public Builder userTypeCode(String userTypeCode) {
            instance.setUserTypeCode(userTypeCode);
            return this;
        }

        public Builder partyID(Integer partyID) {
            instance.setPartyID(partyID);
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            instance.setPartyVersionID(partyVersionID);
            return this;
        }

        public Builder isUsing2fa(Integer isUsing2fa) {
            instance.setIsUsing2fa(isUsing2fa);
            return this;
        }

        public Builder firstTimeLogin(java.math.BigDecimal firstTimeLogin) {
            instance.setFirstTimeLogin(firstTimeLogin);
            return this;
        }

        public Builder loginAttempts(java.math.BigDecimal loginAttempts) {
            instance.setLoginAttempts(loginAttempts);
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

        public Builder userID(Integer userID) {
            instance.setUserID(userID);
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

        public Builder isAuthoriseOwnTnx(Integer isAuthoriseOwnTnx) {
            instance.setIsAuthoriseOwnTnx(isAuthoriseOwnTnx);
            return this;
        }

        public Builder lastLoginTime(String lastLoginTime) {
            instance.setLastLoginTime(lastLoginTime);
            return this;
        }

        public Builder currentLoginTime(String currentLoginTime) {
            instance.setCurrentLoginTime(currentLoginTime);
            return this;
        }

        public Builder lastLogoutTime(String lastLogoutTime) {
            instance.setLastLogoutTime(lastLogoutTime);
            return this;
        }

        public Builder currSessionID(Integer currSessionID) {
            instance.setCurrSessionID(currSessionID);
            return this;
        }

        public Builder lastSessionID(Integer lastSessionID) {
            instance.setLastSessionID(lastSessionID);
            return this;
        }

        public Builder party(FgParty party) {
            instance.setParty(party);
            return this;
        }

        public Builder partyVersion(FgParty partyVersion) {
            instance.setPartyVersion(partyVersion);
            return this;
        }

        public Builder user(FgUserRole user) {
            instance.setUser(user);
            return this;
        }

        public Builder fgUserRoleList(List<FgUserRole> fgUserRoleList) {
            instance.setFgUserRoleList(fgUserRoleList);
            return this;
        }

        public FgUser build() {
            return instance;
        }
    }
}
