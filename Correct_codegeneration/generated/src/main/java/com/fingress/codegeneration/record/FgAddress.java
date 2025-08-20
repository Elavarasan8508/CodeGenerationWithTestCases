package com.bsit.codegeneration.record;

public record FgAddress(Long ID, String addressLine1, String addressLine2, String addressLine3, String countryCode, String stateCode, String cityCode, String landMark, String postCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String latitude, String longitude, Long sysDefined, String systemSourceCode) {

    public static class Builder {

        private Long ID;

        private String addressLine1;

        private String addressLine2;

        private String addressLine3;

        private String countryCode;

        private String stateCode;

        private String cityCode;

        private String landMark;

        private String postCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String latitude;

        private String longitude;

        private Long sysDefined;

        private String systemSourceCode;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder addressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder stateCode(String stateCode) {
            this.stateCode = stateCode;
            return this;
        }

        public Builder cityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public Builder landMark(String landMark) {
            this.landMark = landMark;
            return this;
        }

        public Builder postCode(String postCode) {
            this.postCode = postCode;
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

        public Builder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder sysDefined(Long sysDefined) {
            this.sysDefined = sysDefined;
            return this;
        }

        public Builder systemSourceCode(String systemSourceCode) {
            this.systemSourceCode = systemSourceCode;
            return this;
        }

        public FgAddress build() {
            return new FgAddress(ID, addressLine1, addressLine2, addressLine3, countryCode, stateCode, cityCode, landMark, postCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, latitude, longitude, sysDefined, systemSourceCode);
        }
    }
}
