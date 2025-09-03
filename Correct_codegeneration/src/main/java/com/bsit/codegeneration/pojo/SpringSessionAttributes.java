package com.bsit.codegeneration.pojo;

public class SpringSessionAttributes {

    private Integer sessionPrimaryID;

    private String attributeName;

    private byte[] attributeBytes;

    private SpringSession sessionPrimary;

    public SpringSessionAttributes() {
    }

    public SpringSessionAttributes(Integer sessionPrimaryID, String attributeName, byte[] attributeBytes, SpringSession sessionPrimary) {
        this.sessionPrimaryID = sessionPrimaryID;
        this.attributeName = attributeName;
        this.attributeBytes = attributeBytes;
        this.sessionPrimary = sessionPrimary;
    }

    public Integer getSessionPrimaryID() {
        return sessionPrimaryID;
    }

    public void setSessionPrimaryID(Integer sessionPrimaryID) {
        this.sessionPrimaryID = sessionPrimaryID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public byte[] getAttributeBytes() {
        return attributeBytes;
    }

    public void setAttributeBytes(byte[] attributeBytes) {
        this.attributeBytes = attributeBytes;
    }

    public SpringSession getSessionPrimary() {
        return sessionPrimary;
    }

    public void setSessionPrimary(SpringSession sessionPrimary) {
        this.sessionPrimary = sessionPrimary;
    }

    public static class Builder {

        private SpringSessionAttributes instance = new SpringSessionAttributes();

        public Builder sessionPrimaryID(Integer sessionPrimaryID) {
            instance.setSessionPrimaryID(sessionPrimaryID);
            return this;
        }

        public Builder attributeName(String attributeName) {
            instance.setAttributeName(attributeName);
            return this;
        }

        public Builder attributeBytes(byte[] attributeBytes) {
            instance.setAttributeBytes(attributeBytes);
            return this;
        }

        public Builder sessionPrimary(SpringSession sessionPrimary) {
            instance.setSessionPrimary(sessionPrimary);
            return this;
        }

        public SpringSessionAttributes build() {
            return instance;
        }
    }
}
