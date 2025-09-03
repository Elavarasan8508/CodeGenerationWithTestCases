package com.bsit.codegeneration.pojo;

public class IntLock {

    private String lockKey;

    private String region;

    private Integer clientID;

    private String createdDate;

    public IntLock() {
    }

    public IntLock(String lockKey, String region, Integer clientID, String createdDate) {
        this.lockKey = lockKey;
        this.region = region;
        this.clientID = clientID;
        this.createdDate = createdDate;
    }

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public static class Builder {

        private IntLock instance = new IntLock();

        public Builder lockKey(String lockKey) {
            instance.setLockKey(lockKey);
            return this;
        }

        public Builder region(String region) {
            instance.setRegion(region);
            return this;
        }

        public Builder clientID(Integer clientID) {
            instance.setClientID(clientID);
            return this;
        }

        public Builder createdDate(String createdDate) {
            instance.setCreatedDate(createdDate);
            return this;
        }

        public IntLock build() {
            return instance;
        }
    }
}
