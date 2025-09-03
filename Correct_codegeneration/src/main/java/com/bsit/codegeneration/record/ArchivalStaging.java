package com.bsit.codegeneration.record;

import java.util.List;

public record ArchivalStaging(Integer archiveRowid, String tableName, String purgeStatus) {

    public static class Builder {

        private Integer archiveRowid;

        private String tableName;

        private String purgeStatus;

        public Builder archiveRowid(Integer archiveRowid) {
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
