package com.bsit.codegeneration.pojo;

public class FgAuditItem {

    private String uuid;

    private Integer auditMasterID;

    private String outputContext;

    private String errorContext;

    private FgAuditMaster auditMaster;

    public FgAuditItem() {
    }

    public FgAuditItem(String uuid, Integer auditMasterID, String outputContext, String errorContext, FgAuditMaster auditMaster) {
        this.uuid = uuid;
        this.auditMasterID = auditMasterID;
        this.outputContext = outputContext;
        this.errorContext = errorContext;
        this.auditMaster = auditMaster;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getAuditMasterID() {
        return auditMasterID;
    }

    public void setAuditMasterID(Integer auditMasterID) {
        this.auditMasterID = auditMasterID;
    }

    public String getOutputContext() {
        return outputContext;
    }

    public void setOutputContext(String outputContext) {
        this.outputContext = outputContext;
    }

    public String getErrorContext() {
        return errorContext;
    }

    public void setErrorContext(String errorContext) {
        this.errorContext = errorContext;
    }

    public FgAuditMaster getAuditMaster() {
        return auditMaster;
    }

    public void setAuditMaster(FgAuditMaster auditMaster) {
        this.auditMaster = auditMaster;
    }

    public static class Builder {

        private FgAuditItem instance = new FgAuditItem();

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder auditMasterID(Integer auditMasterID) {
            instance.setAuditMasterID(auditMasterID);
            return this;
        }

        public Builder outputContext(String outputContext) {
            instance.setOutputContext(outputContext);
            return this;
        }

        public Builder errorContext(String errorContext) {
            instance.setErrorContext(errorContext);
            return this;
        }

        public Builder auditMaster(FgAuditMaster auditMaster) {
            instance.setAuditMaster(auditMaster);
            return this;
        }

        public FgAuditItem build() {
            return instance;
        }
    }
}
