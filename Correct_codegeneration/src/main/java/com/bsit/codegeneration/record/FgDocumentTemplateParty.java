package com.bsit.codegeneration.record;

import java.util.List;

public record FgDocumentTemplateParty(Integer ID, Integer partyID, Integer partyVersionID, Integer documentID, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, FgDocumentTemplate fgDocumentTemplate) {

    public static class Builder {

        private Integer ID;

        private Integer partyID;

        private Integer partyVersionID;

        private Integer documentID;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private FgDocumentTemplate fgDocumentTemplate;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyID(Integer partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Integer partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder documentID(Integer documentID) {
            this.documentID = documentID;
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

        public Builder fgDocumentTemplate(FgDocumentTemplate fgDocumentTemplate) {
            this.fgDocumentTemplate = fgDocumentTemplate;
            return this;
        }

        public FgDocumentTemplateParty build() {
            return new FgDocumentTemplateParty(ID, partyID, partyVersionID, documentID, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, fgDocumentTemplate);
        }
    }
}
