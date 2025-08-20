package com.bsit.codegeneration.record;

public record IntLock(String lockKey, String region, String clientID, String createdDate) {

    public static class Builder {

        private String lockKey;

        private String region;

        private String clientID;

        private String createdDate;

        public Builder lockKey(String lockKey) {
            this.lockKey = lockKey;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder clientID(String clientID) {
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
