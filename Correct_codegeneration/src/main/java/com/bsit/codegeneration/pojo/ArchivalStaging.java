package com.bsit.codegeneration.pojo;

public class ArchivalStaging {

    private String archiveRowid;

    private String tableName;

    private String purgeStatus;

    public ArchivalStaging() {
    }

    public ArchivalStaging(String archiveRowid, String tableName, String purgeStatus) {
        this.archiveRowid = archiveRowid;
        this.tableName = tableName;
        this.purgeStatus = purgeStatus;
    }

    public String getArchiveRowid() {
        return archiveRowid;
    }

    public void setArchiveRowid(String archiveRowid) {
        this.archiveRowid = archiveRowid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPurgeStatus() {
        return purgeStatus;
    }

    public void setPurgeStatus(String purgeStatus) {
        this.purgeStatus = purgeStatus;
    }

    public static class Builder {

        private ArchivalStaging instance = new ArchivalStaging();

        public Builder archiveRowid(String archiveRowid) {
            instance.setArchiveRowid(archiveRowid);
            return this;
        }

        public Builder tableName(String tableName) {
            instance.setTableName(tableName);
            return this;
        }

        public Builder purgeStatus(String purgeStatus) {
            instance.setPurgeStatus(purgeStatus);
            return this;
        }

        public ArchivalStaging build() {
            return instance;
        }
    }
}
