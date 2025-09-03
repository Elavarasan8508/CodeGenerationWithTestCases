package com.bsit.codegeneration.record;

import java.util.List;

public record FgRole(Integer ID, Integer versionID, Long isMasterVersion, String code, String name, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String typeCode, String subTypeCode, String type, List<FgGroupRole> fgGroupRoles, List<FgPartyRole> fgPartyRoles) {

    public static class Builder {

        private Integer ID;

        private Integer versionID;

        private Long isMasterVersion;

        private String code;

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

        private String typeCode;

        private String subTypeCode;

        private String type;

        private List<FgGroupRole> fgGroupRoles;

        private List<FgPartyRole> fgPartyRoles;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder versionID(Integer versionID) {
            this.versionID = versionID;
            return this;
        }

        public Builder isMasterVersion(Long isMasterVersion) {
            this.isMasterVersion = isMasterVersion;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
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

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder fgGroupRoles(List<FgGroupRole> fgGroupRoles) {
            this.fgGroupRoles = fgGroupRoles;
            return this;
        }

        public Builder fgPartyRoles(List<FgPartyRole> fgPartyRoles) {
            this.fgPartyRoles = fgPartyRoles;
            return this;
        }

        public FgRole build() {
            return new FgRole(ID, versionID, isMasterVersion, code, name, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, typeCode, subTypeCode, type, fgGroupRoles, fgPartyRoles);
        }
    }
}
