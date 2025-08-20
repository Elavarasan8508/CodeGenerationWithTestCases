package com.bsit.codegeneration.record;

public record FgNavigation(Long ID, String appliedDate, String typeCode, String subTypeCode, String navigationContent, Long createdBy, String createdOn, Long lastAuthorisedBy, String lastAuthorisedOn, Long lastUpdatedBy, String lastUpdatedOn) {

    public static class Builder {

        private Long ID;

        private String appliedDate;

        private String typeCode;

        private String subTypeCode;

        private String navigationContent;

        private Long createdBy;

        private String createdOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder appliedDate(String appliedDate) {
            this.appliedDate = appliedDate;
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

        public Builder navigationContent(String navigationContent) {
            this.navigationContent = navigationContent;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public FgNavigation build() {
            return new FgNavigation(ID, appliedDate, typeCode, subTypeCode, navigationContent, createdBy, createdOn, lastAuthorisedBy, lastAuthorisedOn, lastUpdatedBy, lastUpdatedOn);
        }
    }
}
