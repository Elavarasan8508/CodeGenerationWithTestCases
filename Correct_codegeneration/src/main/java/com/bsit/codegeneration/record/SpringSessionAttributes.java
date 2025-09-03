package com.bsit.codegeneration.record;

import java.util.List;

public record SpringSessionAttributes(Integer sessionPrimaryID, String attributeName, String attributeBytes, SpringSession springSession) {

    public static class Builder {

        private Integer sessionPrimaryID;

        private String attributeName;

        private String attributeBytes;

        private SpringSession springSession;

        public Builder sessionPrimaryID(Integer sessionPrimaryID) {
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

        public Builder springSession(SpringSession springSession) {
            this.springSession = springSession;
            return this;
        }

        public SpringSessionAttributes build() {
            return new SpringSessionAttributes(sessionPrimaryID, attributeName, attributeBytes, springSession);
        }
    }
}
