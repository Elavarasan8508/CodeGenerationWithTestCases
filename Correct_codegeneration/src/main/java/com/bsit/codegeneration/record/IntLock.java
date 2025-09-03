package com.bsit.codegeneration.record;

import java.util.List;

public record IntLock(String lockKey, String region, Integer clientID, String createdDate) {

    public static class Builder {

        private String lockKey;

        private String region;

        private Integer clientID;

        private String createdDate;

        public Builder lockKey(String lockKey) {
            this.lockKey = lockKey;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder clientID(Integer clientID) {
            this.clientID = clientID;
            return this;
        }

        public Builder createdDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public IntLock build() {
            return new IntLock(lockKey, region, clientID, createdDate);
        }
    }
}
