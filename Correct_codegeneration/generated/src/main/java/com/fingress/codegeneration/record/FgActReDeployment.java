package com.bsit.codegeneration.record;

public record FgActReDeployment(String ID_, String name_, String deployTime_, String source_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private String name_;

        private String deployTime_;

        private String source_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder deployTime_(String deployTime_) {
            this.deployTime_ = deployTime_;
            return this;
        }

        public Builder source_(String source_) {
            this.source_ = source_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActReDeployment build() {
            return new FgActReDeployment(ID_, name_, deployTime_, source_, tenantID_);
        }
    }
}
