package com.bsit.codegeneration.record;

import java.util.List;

public record IntGroupToMessage(String groupKey, Integer messageID, String region) {

    public static class Builder {

        private String groupKey;

        private Integer messageID;

        private String region;

        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        public Builder messageID(Integer messageID) {
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
