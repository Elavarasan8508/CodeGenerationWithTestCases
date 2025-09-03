package com.bsit.codegeneration.record;

import java.util.List;

public record FgAuditItem(Integer uuid, Integer auditMasterID, String outputContext, String errorContext, FgAuditMaster fgAuditMaster) {

    public static class Builder {

        private Integer uuid;

        private Integer auditMasterID;

        private String outputContext;

        private String errorContext;

        private FgAuditMaster fgAuditMaster;

        public Builder uuid(Integer uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder auditMasterID(Integer auditMasterID) {
            this.auditMasterID = auditMasterID;
            return this;
        }

        public Builder outputContext(String outputContext) {
            this.outputContext = outputContext;
            return this;
        }

        public Builder errorContext(String errorContext) {
            this.errorContext = errorContext;
            return this;
        }

        public Builder fgAuditMaster(FgAuditMaster fgAuditMaster) {
            this.fgAuditMaster = fgAuditMaster;
            return this;
        }

        public FgAuditItem build() {
            return new FgAuditItem(uuid, auditMasterID, outputContext, errorContext, fgAuditMaster);
        }
    }
}
