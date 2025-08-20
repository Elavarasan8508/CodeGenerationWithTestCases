package com.bsit.codegeneration.record;

public record FgActGeBytearray(String ID_, Long rev_, String name_, String deploymentID_, String bytes_, Long generated_, String tenantID_, Long type_, String createTime_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String name_;

        private String deploymentID_;

        private String bytes_;

        private Long generated_;

        private String tenantID_;

        private Long type_;

        private String createTime_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            this.deploymentID_ = deploymentID_;
            return this;
        }

        public Builder bytes_(String bytes_) {
            this.bytes_ = bytes_;
            return this;
        }

        public Builder generated_(Long generated_) {
            this.generated_ = generated_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder type_(Long type_) {
            this.type_ = type_;
            return this;
        }

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            this.rootProcInstID_ = rootProcInstID_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public FgActGeBytearray build() {
            return new FgActGeBytearray(ID_, rev_, name_, deploymentID_, bytes_, generated_, tenantID_, type_, createTime_, rootProcInstID_, removalTime_);
        }
    }
}
