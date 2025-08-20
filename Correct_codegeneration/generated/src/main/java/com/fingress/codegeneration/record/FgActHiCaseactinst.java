package com.bsit.codegeneration.record;

public record FgActHiCaseactinst(String ID_, String parentActInstID_, String caseDefID_, String caseInstID_, String caseActID_, String taskID_, String callProcInstID_, String callCaseInstID_, String caseActName_, String caseActType_, String createTime_, String endTime_, Long duration_, Long state_, Long required_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private String parentActInstID_;

        private String caseDefID_;

        private String caseInstID_;

        private String caseActID_;

        private String taskID_;

        private String callProcInstID_;

        private String callCaseInstID_;

        private String caseActName_;

        private String caseActType_;

        private String createTime_;

        private String endTime_;

        private Long duration_;

        private Long state_;

        private Long required_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder parentActInstID_(String parentActInstID_) {
            this.parentActInstID_ = parentActInstID_;
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            this.caseDefID_ = caseDefID_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder caseActID_(String caseActID_) {
            this.caseActID_ = caseActID_;
            return this;
        }

        public Builder taskID_(String taskID_) {
            this.taskID_ = taskID_;
            return this;
        }

        public Builder callProcInstID_(String callProcInstID_) {
            this.callProcInstID_ = callProcInstID_;
            return this;
        }

        public Builder callCaseInstID_(String callCaseInstID_) {
            this.callCaseInstID_ = callCaseInstID_;
            return this;
        }

        public Builder caseActName_(String caseActName_) {
            this.caseActName_ = caseActName_;
            return this;
        }

        public Builder caseActType_(String caseActType_) {
            this.caseActType_ = caseActType_;
            return this;
        }

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
            return this;
        }

        public Builder endTime_(String endTime_) {
            this.endTime_ = endTime_;
            return this;
        }

        public Builder duration_(Long duration_) {
            this.duration_ = duration_;
            return this;
        }

        public Builder state_(Long state_) {
            this.state_ = state_;
            return this;
        }

        public Builder required_(Long required_) {
            this.required_ = required_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActHiCaseactinst build() {
            return new FgActHiCaseactinst(ID_, parentActInstID_, caseDefID_, caseInstID_, caseActID_, taskID_, callProcInstID_, callCaseInstID_, caseActName_, caseActType_, createTime_, endTime_, duration_, state_, required_, tenantID_);
        }
    }
}
