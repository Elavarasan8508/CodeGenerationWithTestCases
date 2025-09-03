package com.bsit.codegeneration.pojo;

public class FgLocalization {

    private String locType;

    private String locKey;

    private String locale;

    private String locValue;

    private Integer ID;

    public FgLocalization() {
    }

    public FgLocalization(String locType, String locKey, String locale, String locValue, Integer ID) {
        this.locType = locType;
        this.locKey = locKey;
        this.locale = locale;
        this.locValue = locValue;
        this.ID = ID;
    }

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public String getLocKey() {
        return locKey;
    }

    public void setLocKey(String locKey) {
        this.locKey = locKey;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocValue() {
        return locValue;
    }

    public void setLocValue(String locValue) {
        this.locValue = locValue;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public static class Builder {

        private FgLocalization instance = new FgLocalization();

        public Builder locType(String locType) {
            instance.setLocType(locType);
            return this;
        }

        public Builder locKey(String locKey) {
            instance.setLocKey(locKey);
            return this;
        }

        public Builder locale(String locale) {
            instance.setLocale(locale);
            return this;
        }

        public Builder locValue(String locValue) {
            instance.setLocValue(locValue);
            return this;
        }

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public FgLocalization build() {
            return instance;
        }
    }
}
