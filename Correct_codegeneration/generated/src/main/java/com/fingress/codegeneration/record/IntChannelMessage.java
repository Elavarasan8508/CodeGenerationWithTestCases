package com.bsit.codegeneration.record;

public record IntChannelMessage(String messageID, String groupKey, Long createdDate, Long messagePriority, Long messageSequence, String messageBytes, String region) {

    public static class Builder {

        private String messageID;

        private String groupKey;

        private Long createdDate;

        private Long messagePriority;

        private Long messageSequence;

        private String messageBytes;

        private String region;

        public Builder messageID(String messageID) {
            this.messageID = messageID;
            return this;
        }

        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        public Builder createdDate(Long createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder messagePriority(Long messagePriority) {
            this.messagePriority = messagePriority;
            return this;
        }

        public Builder messageSequence(Long messageSequence) {
            this.messageSequence = messageSequence;
            return this;
        }

        public Builder messageBytes(String messageBytes) {
            this.messageBytes = messageBytes;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public IntChannelMessage build() {
            return new IntChannelMessage(messageID, groupKey, createdDate, messagePriority, messageSequence, messageBytes, region);
        }
    }
}
