package com.bsit.codegeneration.record;

import java.util.List;

public record FgProjects(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String projectName, java.time.LocalDateTime startDate, java.time.LocalDateTime endDate, String projectTitle, String description, String subProject, String category, Integer processID, Integer versionID, Long isMasterVersion, String attributeGuarantee) {

    public static class Builder {

        private Integer ID;

        private Integer referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String projectName;

        private java.time.LocalDateTime startDate;

        private java.time.LocalDateTime endDate;

        private String projectTitle;

        private String description;

        private String subProject;

        private String category;

        private Integer processID;

        private Integer versionID;

        private Long isMasterVersion;

        private String attributeGuarantee;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            this.referenceID = referenceID;
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

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder startDate(java.time.LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(java.time.LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder projectTitle(String projectTitle) {
            this.projectTitle = projectTitle;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder subProject(String subProject) {
            this.subProject = subProject;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder processID(Integer processID) {
            this.processID = processID;
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

        public Builder attributeGuarantee(String attributeGuarantee) {
            this.attributeGuarantee = attributeGuarantee;
            return this;
        }

        public FgProjects build() {
            return new FgProjects(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, projectName, startDate, endDate, projectTitle, description, subProject, category, processID, versionID, isMasterVersion, attributeGuarantee);
        }
    }
}
