package com.bsit.codegeneration.record;

import java.util.List;

public record SpringSession(Integer primaryID, Integer sessionID, Long creationTime, Long lastAccessTime, Long maxInactiveInterval, Long expiryTime, String principalName, List<SpringSessionAttributes> springSessionAttributess) {

    public static class Builder {

        private Integer primaryID;

        private Integer sessionID;

        private Long creationTime;

        private Long lastAccessTime;

        private Long maxInactiveInterval;

        private Long expiryTime;

        private String principalName;

        private List<SpringSessionAttributes> springSessionAttributess;

        public Builder primaryID(Integer primaryID) {
            this.primaryID = primaryID;
            return this;
        }

        public Builder sessionID(Integer sessionID) {
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

        public Builder springSessionAttributess(List<SpringSessionAttributes> springSessionAttributess) {
            this.springSessionAttributess = springSessionAttributess;
            return this;
        }

        public SpringSession build() {
            return new SpringSession(primaryID, sessionID, creationTime, lastAccessTime, maxInactiveInterval, expiryTime, principalName, springSessionAttributess);
        }
    }
}
