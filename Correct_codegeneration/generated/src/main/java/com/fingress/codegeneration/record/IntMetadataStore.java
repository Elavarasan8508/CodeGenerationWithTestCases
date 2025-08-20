package com.bsit.codegeneration.record;

public record IntMetadataStore(String metadataKey, String metadataValue, String region) {

    public static class Builder {

        private String metadataKey;

        private String metadataValue;

        private String region;

        public Builder metadataKey(String metadataKey) {
            this.metadataKey = metadataKey;
            return this;
        }

        public Builder metadataValue(String metadataValue) {
            this.metadataValue = metadataValue;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public IntMetadataStore build() {
            return new IntMetadataStore(metadataKey, metadataValue, region);
        }
    }
}
