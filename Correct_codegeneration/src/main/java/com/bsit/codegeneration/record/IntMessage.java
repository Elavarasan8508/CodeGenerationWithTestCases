package com.bsit.codegeneration.record;

import java.util.List;

public record IntMessage(Integer messageID, String region, String createdDate, String messageBytes) {

    public static class Builder {

        private Integer messageID;

        private String region;

        private String createdDate;

        private String messageBytes;

        public Builder messageID(Integer messageID) {
            this.messageID = messageID;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder createdDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder messageBytes(String messageBytes) {
            this.messageBytes = messageBytes;
            return this;
        }

        public IntMessage build() {
            return new IntMessage(messageID, region, createdDate, messageBytes);
        }
    }
}
