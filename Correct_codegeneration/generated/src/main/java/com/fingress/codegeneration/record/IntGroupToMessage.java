package com.bsit.codegeneration.record;

public record IntGroupToMessage(String groupKey, String messageID, String region) {

    public static class Builder {

        private String groupKey;

        private String messageID;

        private String region;

        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        public Builder messageID(String messageID) {
            this.messageID = messageID;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public IntGroupToMessage build() {
            return new IntGroupToMessage(groupKey, messageID, region);
        }
    }
}
