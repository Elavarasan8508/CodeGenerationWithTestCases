package com.bsit.codegeneration.pojo;

public class IntMetadataStore {

    private String metadataKey;

    private String metadataValue;

    private String region;

    public IntMetadataStore() {
    }

    public IntMetadataStore(String metadataKey, String metadataValue, String region) {
        this.metadataKey = metadataKey;
        this.metadataValue = metadataValue;
        this.region = region;
    }

    public String getMetadataKey() {
        return metadataKey;
    }

    public void setMetadataKey(String metadataKey) {
        this.metadataKey = metadataKey;
    }

    public String getMetadataValue() {
        return metadataValue;
    }

    public void setMetadataValue(String metadataValue) {
        this.metadataValue = metadataValue;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public static class Builder {

        private IntMetadataStore instance = new IntMetadataStore();

        public Builder metadataKey(String metadataKey) {
            instance.setMetadataKey(metadataKey);
            return this;
        }

        public Builder metadataValue(String metadataValue) {
            instance.setMetadataValue(metadataValue);
            return this;
        }

        public Builder region(String region) {
            instance.setRegion(region);
            return this;
        }

        public IntMetadataStore build() {
            return instance;
        }
    }
}
