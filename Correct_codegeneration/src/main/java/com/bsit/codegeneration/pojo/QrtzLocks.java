package com.bsit.codegeneration.pojo;

public class QrtzLocks {

    private String schedName;

    private String lockName;

    public QrtzLocks() {
    }

    public QrtzLocks(String schedName, String lockName) {
        this.schedName = schedName;
        this.lockName = lockName;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public static class Builder {

        private QrtzLocks instance = new QrtzLocks();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder lockName(String lockName) {
            instance.setLockName(lockName);
            return this;
        }

        public QrtzLocks build() {
            return instance;
        }
    }
}
