package com.bsit.codegeneration.record;

public record FgActRuJobdef(String ID_, Long rev_, String procDefID_, String procDefKey_, String actID_, String jobType_, String jobConfiguration_, Long suspensionState_, Long jobPriority_, String tenantID_, String deploymentID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String procDefID_;

        private String procDefKey_;

        private String actID_;

        private String jobType_;

        private String jobConfiguration_;

        private Long suspensionState_;

        private Long jobPriority_;

        private String tenantID_;

        private String deploymentID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            this.procDefKey_ = procDefKey_;
            return this;
        }

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder jobType_(String jobType_) {
            this.jobType_ = jobType_;
            return this;
        }

        public Builder jobConfiguration_(String jobConfiguration_) {
            this.jobConfiguration_ = jobConfiguration_;
            return this;
        }

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder jobPriority_(Long jobPriority_) {
            this.jobPriority_ = jobPriority_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            this.deploymentID_ = deploymentID_;
            return this;
        }

        public FgActRuJobdef build() {
            return new FgActRuJobdef(ID_, rev_, procDefID_, procDefKey_, actID_, jobType_, jobConfiguration_, suspensionState_, jobPriority_, tenantID_, deploymentID_);
        }
    }
}
