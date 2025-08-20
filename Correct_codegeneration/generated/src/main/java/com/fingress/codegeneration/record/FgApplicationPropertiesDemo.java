package com.bsit.codegeneration.record;

public record FgApplicationPropertiesDemo(String key, String value) {

    public static class Builder {

        private String key;

        private String value;

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public FgApplicationPropertiesDemo build() {
            return new FgApplicationPropertiesDemo(key, value);
        }
    }
}
