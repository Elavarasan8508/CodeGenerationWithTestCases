package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgAddress {

    private Integer ID;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String countryCode;

    private String stateCode;

    private String cityCode;

    private String landMark;

    private String postCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String latitude;

    private String longitude;

    private Integer sysDefined;

    private String systemSourceCode;

    private FgPartyAddress address;

    private List<FgPartyAddress> fgPartyAddressList;

    public FgAddress() {
    }

    public FgAddress(Integer ID, String addressLine1, String addressLine2, String addressLine3, String countryCode, String stateCode, String cityCode, String landMark, String postCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String latitude, String longitude, Integer sysDefined, String systemSourceCode, FgPartyAddress address) {
        this.ID = ID;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.cityCode = cityCode;
        this.landMark = landMark;
        this.postCode = postCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sysDefined = sysDefined;
        this.systemSourceCode = systemSourceCode;
        this.address = address;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getSysDefined() {
        return sysDefined;
    }

    public void setSysDefined(Integer sysDefined) {
        this.sysDefined = sysDefined;
    }

    public String getSystemSourceCode() {
        return systemSourceCode;
    }

    public void setSystemSourceCode(String systemSourceCode) {
        this.systemSourceCode = systemSourceCode;
    }

    public FgPartyAddress getAddress() {
        return address;
    }

    public void setAddress(FgPartyAddress address) {
        this.address = address;
    }

    public List<FgPartyAddress> getFgPartyAddressList() {
        return fgPartyAddressList;
    }

    public void setFgPartyAddressList(List<FgPartyAddress> fgPartyAddressList) {
        this.fgPartyAddressList = fgPartyAddressList;
    }

    public static class Builder {

        private FgAddress instance = new FgAddress();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder addressLine1(String addressLine1) {
            instance.setAddressLine1(addressLine1);
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            instance.setAddressLine2(addressLine2);
            return this;
        }

        public Builder addressLine3(String addressLine3) {
            instance.setAddressLine3(addressLine3);
            return this;
        }

        public Builder countryCode(String countryCode) {
            instance.setCountryCode(countryCode);
            return this;
        }

        public Builder stateCode(String stateCode) {
            instance.setStateCode(stateCode);
            return this;
        }

        public Builder cityCode(String cityCode) {
            instance.setCityCode(cityCode);
            return this;
        }

        public Builder landMark(String landMark) {
            instance.setLandMark(landMark);
            return this;
        }

        public Builder postCode(String postCode) {
            instance.setPostCode(postCode);
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

        public Builder latitude(String latitude) {
            instance.setLatitude(latitude);
            return this;
        }

        public Builder longitude(String longitude) {
            instance.setLongitude(longitude);
            return this;
        }

        public Builder sysDefined(Integer sysDefined) {
            instance.setSysDefined(sysDefined);
            return this;
        }

        public Builder systemSourceCode(String systemSourceCode) {
            instance.setSystemSourceCode(systemSourceCode);
            return this;
        }

        public Builder address(FgPartyAddress address) {
            instance.setAddress(address);
            return this;
        }

        public Builder fgPartyAddressList(List<FgPartyAddress> fgPartyAddressList) {
            instance.setFgPartyAddressList(fgPartyAddressList);
            return this;
        }

        public FgAddress build() {
            return instance;
        }
    }
}
