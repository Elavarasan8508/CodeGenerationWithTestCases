package com.bsit.codegeneration.record;

public record FgPerson(Long ID, String birthCountryCode, String birthName, String cityOfBirth, String domicileCountryCode, String genderCode, String givenName, String languageCode, String middleName, String minorIndicator, String name, String namePrefixCode, String nameSuffix, String nationalityCode, String profession, String provinceOfBirth, String residenceCountryCode, String residentialStatusCode, String taxationCountryCode, Long partyID, Long partyVersionID, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String employeeNo, java.time.LocalDateTime dateOfBirth, java.time.LocalDateTime dateOfJoining, String designation) {

    public static class Builder {

        private Long ID;

        private String birthCountryCode;

        private String birthName;

        private String cityOfBirth;

        private String domicileCountryCode;

        private String genderCode;

        private String givenName;

        private String languageCode;

        private String middleName;

        private String minorIndicator;

        private String name;

        private String namePrefixCode;

        private String nameSuffix;

        private String nationalityCode;

        private String profession;

        private String provinceOfBirth;

        private String residenceCountryCode;

        private String residentialStatusCode;

        private String taxationCountryCode;

        private Long partyID;

        private Long partyVersionID;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String employeeNo;

        private java.time.LocalDateTime dateOfBirth;

        private java.time.LocalDateTime dateOfJoining;

        private String designation;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder birthCountryCode(String birthCountryCode) {
            this.birthCountryCode = birthCountryCode;
            return this;
        }

        public Builder birthName(String birthName) {
            this.birthName = birthName;
            return this;
        }

        public Builder cityOfBirth(String cityOfBirth) {
            this.cityOfBirth = cityOfBirth;
            return this;
        }

        public Builder domicileCountryCode(String domicileCountryCode) {
            this.domicileCountryCode = domicileCountryCode;
            return this;
        }

        public Builder genderCode(String genderCode) {
            this.genderCode = genderCode;
            return this;
        }

        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder minorIndicator(String minorIndicator) {
            this.minorIndicator = minorIndicator;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder namePrefixCode(String namePrefixCode) {
            this.namePrefixCode = namePrefixCode;
            return this;
        }

        public Builder nameSuffix(String nameSuffix) {
            this.nameSuffix = nameSuffix;
            return this;
        }

        public Builder nationalityCode(String nationalityCode) {
            this.nationalityCode = nationalityCode;
            return this;
        }

        public Builder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public Builder provinceOfBirth(String provinceOfBirth) {
            this.provinceOfBirth = provinceOfBirth;
            return this;
        }

        public Builder residenceCountryCode(String residenceCountryCode) {
            this.residenceCountryCode = residenceCountryCode;
            return this;
        }

        public Builder residentialStatusCode(String residentialStatusCode) {
            this.residentialStatusCode = residentialStatusCode;
            return this;
        }

        public Builder taxationCountryCode(String taxationCountryCode) {
            this.taxationCountryCode = taxationCountryCode;
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

        public Builder employeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
            return this;
        }

        public Builder dateOfBirth(java.time.LocalDateTime dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder dateOfJoining(java.time.LocalDateTime dateOfJoining) {
            this.dateOfJoining = dateOfJoining;
            return this;
        }

        public Builder designation(String designation) {
            this.designation = designation;
            return this;
        }

        public FgPerson build() {
            return new FgPerson(ID, birthCountryCode, birthName, cityOfBirth, domicileCountryCode, genderCode, givenName, languageCode, middleName, minorIndicator, name, namePrefixCode, nameSuffix, nationalityCode, profession, provinceOfBirth, residenceCountryCode, residentialStatusCode, taxationCountryCode, partyID, partyVersionID, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, employeeNo, dateOfBirth, dateOfJoining, designation);
        }
    }
}
