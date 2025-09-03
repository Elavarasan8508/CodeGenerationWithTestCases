package com.bsit.codegeneration.pojo;

public class FgApplicationPropertiesDemo {

    private String key;

    private String value;

    public FgApplicationPropertiesDemo() {
    }

    public FgApplicationPropertiesDemo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {

        private FgApplicationPropertiesDemo instance = new FgApplicationPropertiesDemo();

        public Builder key(String key) {
            instance.setKey(key);
            return this;
        }

        public Builder value(String value) {
            instance.setValue(value);
            return this;
        }

        public FgApplicationPropertiesDemo build() {
            return instance;
        }
    }
}
