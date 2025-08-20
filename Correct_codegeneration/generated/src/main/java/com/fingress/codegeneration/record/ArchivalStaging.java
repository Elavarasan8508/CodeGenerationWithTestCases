package com.bsit.codegeneration.record;

public record ArchivalStaging(String archiveRowid, String tableName, String purgeStatus) {

    public static class Builder {

        private String archiveRowid;

        private String tableName;

        private String purgeStatus;

        public Builder archiveRowid(String archiveRowid) {
            this.archiveRowid = archiveRowid;
            return this;
        }

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public Builder purgeStatus(String purgeStatus) {
            this.purgeStatus = purgeStatus;
            return this;
        }

        public ArchivalStaging build() {
            return new ArchivalStaging(archiveRowid, tableName, purgeStatus);
        }
    }
}
