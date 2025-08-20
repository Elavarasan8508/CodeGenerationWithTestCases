package com.bsit.codegeneration.record;

public record SpringSessionAttributes(String sessionPrimaryID, String attributeName, String attributeBytes) {

    public static class Builder {

        private String sessionPrimaryID;

        private String attributeName;

        private String attributeBytes;

        public Builder sessionPrimaryID(String sessionPrimaryID) {
            this.sessionPrimaryID = sessionPrimaryID;
            return this;
        }

        public Builder attributeName(String attributeName) {
            this.attributeName = attributeName;
            return this;
        }

        public Builder attributeBytes(String attributeBytes) {
            this.attributeBytes = attributeBytes;
            return this;
        }

        public SpringSessionAttributes build() {
            return new SpringSessionAttributes(sessionPrimaryID, attributeName, attributeBytes);
        }
    }
}
