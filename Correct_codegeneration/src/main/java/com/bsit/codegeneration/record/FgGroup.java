package com.bsit.codegeneration.record;

import java.util.List;

public record FgGroup(Integer ID, String name, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String code, String typeCode, String subTypeCode, String partyTypeCode, Integer referenceID, String configStatusCode, String orgTypeCode, String orgCode, List<FgGroupPermission> fgGroupPermissions, List<FgGroupRole> fgGroupRoles, List<FgPartyGroup> fgPartyGroups, List<FgUserGroup> fgUserGroups, List<FgPermission> fgPermissions) {

    public static class Builder {

        private Integer ID;

        private String name;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String code;

        private String typeCode;

        private String subTypeCode;

        private String partyTypeCode;

        private Integer referenceID;

        private String configStatusCode;

        private String orgTypeCode;

        private String orgCode;

        private List<FgGroupPermission> fgGroupPermissions;

        private List<FgGroupRole> fgGroupRoles;

        private List<FgPartyGroup> fgPartyGroups;

        private List<FgUserGroup> fgUserGroups;

        private List<FgPermission> fgPermissions;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
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

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder partyTypeCode(String partyTypeCode) {
            this.partyTypeCode = partyTypeCode;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public Builder configStatusCode(String configStatusCode) {
            this.configStatusCode = configStatusCode;
            return this;
        }

        public Builder orgTypeCode(String orgTypeCode) {
            this.orgTypeCode = orgTypeCode;
            return this;
        }

        public Builder orgCode(String orgCode) {
            this.orgCode = orgCode;
            return this;
        }

        public Builder fgGroupPermissions(List<FgGroupPermission> fgGroupPermissions) {
            this.fgGroupPermissions = fgGroupPermissions;
            return this;
        }

        public Builder fgGroupRoles(List<FgGroupRole> fgGroupRoles) {
            this.fgGroupRoles = fgGroupRoles;
            return this;
        }

        public Builder fgPartyGroups(List<FgPartyGroup> fgPartyGroups) {
            this.fgPartyGroups = fgPartyGroups;
            return this;
        }

        public Builder fgUserGroups(List<FgUserGroup> fgUserGroups) {
            this.fgUserGroups = fgUserGroups;
            return this;
        }

        public Builder fgPermissions(List<FgPermission> fgPermissions) {
            this.fgPermissions = fgPermissions;
            return this;
        }

        public FgGroup build() {
            return new FgGroup(ID, name, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, code, typeCode, subTypeCode, partyTypeCode, referenceID, configStatusCode, orgTypeCode, orgCode, fgGroupPermissions, fgGroupRoles, fgPartyGroups, fgUserGroups, fgPermissions);
        }
    }
}
