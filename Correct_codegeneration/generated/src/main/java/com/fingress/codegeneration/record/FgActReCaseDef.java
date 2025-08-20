package com.bsit.codegeneration.record;

public record FgActReCaseDef(String ID_, Long rev_, String category_, String name_, String key_, Long version_, String deploymentID_, String resourceName_, String dgrmResourceName_, String tenantID_, Long historyTtl_) {

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

        private String tenantID_;

        private Long historyTtl_;

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

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder historyTtl_(Long historyTtl_) {
            this.historyTtl_ = historyTtl_;
            return this;
        }

        public FgActReCaseDef build() {
            return new FgActReCaseDef(ID_, rev_, category_, name_, key_, version_, deploymentID_, resourceName_, dgrmResourceName_, tenantID_, historyTtl_);
        }
    }
}
