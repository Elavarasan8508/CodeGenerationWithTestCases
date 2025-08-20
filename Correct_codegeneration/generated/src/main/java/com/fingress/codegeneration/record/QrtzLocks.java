package com.bsit.codegeneration.record;

public record QrtzLocks(String schedName, String lockName) {

    public static class Builder {

        private String schedName;

        private String lockName;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder lockName(String lockName) {
            this.lockName = lockName;
            return this;
        }

        public QrtzLocks build() {
            return new QrtzLocks(schedName, lockName);
        }
    }
}
