package com.bsit.codegeneration.record;

public record FgBusinessCodeTypeBkp(Long ID, Long partyID, Long partyVersionID, String codeType, String name, String description, String activeCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String tags) {

    public static class Builder {

        private Long ID;

        private Long partyID;

        private Long partyVersionID;

        private String codeType;

        private String name;

        private String description;

        private String activeCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String tags;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder partyID(Long partyID) {
            this.partyID = partyID;
            return this;
        }

        public Builder partyVersionID(Long partyVersionID) {
            this.partyVersionID = partyVersionID;
            return this;
        }

        public Builder codeType(String codeType) {
            this.codeType = codeType;
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

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public FgBusinessCodeTypeBkp build() {
            return new FgBusinessCodeTypeBkp(ID, partyID, partyVersionID, codeType, name, description, activeCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, tags);
        }
    }
}
