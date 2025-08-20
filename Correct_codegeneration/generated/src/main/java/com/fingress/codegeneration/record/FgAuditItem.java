package com.bsit.codegeneration.record;

public record FgAuditItem(String uuid, String auditMasterID, String outputContext, String errorContext) {

    public static class Builder {

        private String uuid;

        private String auditMasterID;

        private String outputContext;

        private String errorContext;

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder auditMasterID(String auditMasterID) {
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

        public FgAuditItem build() {
            return new FgAuditItem(uuid, auditMasterID, outputContext, errorContext);
        }
    }
}
