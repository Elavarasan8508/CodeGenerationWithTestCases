package com.bsit.codegeneration.record;

public record SpringSession(String primaryID, String sessionID, Long creationTime, Long lastAccessTime, Long maxInactiveInterval, Long expiryTime, String principalName) {

    public static class Builder {

        private String primaryID;

        private String sessionID;

        private Long creationTime;

        private Long lastAccessTime;

        private Long maxInactiveInterval;

        private Long expiryTime;

        private String principalName;

        public Builder primaryID(String primaryID) {
            this.primaryID = primaryID;
            return this;
        }

        public Builder sessionID(String sessionID) {
            this.sessionID = sessionID;
            return this;
        }

        public Builder creationTime(Long creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Builder lastAccessTime(Long lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
            return this;
        }

        public Builder maxInactiveInterval(Long maxInactiveInterval) {
            this.maxInactiveInterval = maxInactiveInterval;
            return this;
        }

        public Builder expiryTime(Long expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }

        public Builder principalName(String principalName) {
            this.principalName = principalName;
            return this;
        }

        public SpringSession build() {
            return new SpringSession(primaryID, sessionID, creationTime, lastAccessTime, maxInactiveInterval, expiryTime, principalName);
        }
    }
}
