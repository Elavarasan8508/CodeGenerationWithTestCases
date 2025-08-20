package com.bsit.codegeneration.record;

public record FgActReProcdef(String ID_, Long rev_, String category_, String name_, String key_, Long version_, String deploymentID_, String resourceName_, String dgrmResourceName_, Long hasStartFormKey_, Long suspensionState_, String tenantID_, String versionTag_, Long historyTtl_, Long startable_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String category_;

        private String name_;

        private String key_;

        private Long version_;

        private String deploymentID_;

        private String resourceName_;

        private String dgrmResourceName_;

        private Long hasStartFormKey_;

        private Long suspensionState_;

        private String tenantID_;

        private String versionTag_;

        private Long historyTtl_;

        private Long startable_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder category_(String category_) {
            this.category_ = category_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder key_(String key_) {
            this.key_ = key_;
            return this;
        }

        public Builder version_(Long version_) {
            this.version_ = version_;
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            this.deploymentID_ = deploymentID_;
            return this;
        }

        public Builder resourceName_(String resourceName_) {
            this.resourceName_ = resourceName_;
            return this;
        }

        public Builder dgrmResourceName_(String dgrmResourceName_) {
            this.dgrmResourceName_ = dgrmResourceName_;
            return this;
        }

        public Builder hasStartFormKey_(Long hasStartFormKey_) {
            this.hasStartFormKey_ = hasStartFormKey_;
            return this;
        }

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder versionTag_(String versionTag_) {
            this.versionTag_ = versionTag_;
            return this;
        }

        public Builder historyTtl_(Long historyTtl_) {
            this.historyTtl_ = historyTtl_;
            return this;
        }

        public Builder startable_(Long startable_) {
            this.startable_ = startable_;
            return this;
        }

        public FgActReProcdef build() {
            return new FgActReProcdef(ID_, rev_, category_, name_, key_, version_, deploymentID_, resourceName_, dgrmResourceName_, hasStartFormKey_, suspensionState_, tenantID_, versionTag_, historyTtl_, startable_);
        }
    }
}
