package com.bsit.codegeneration.record;

public record FgActHiVarinst(String ID_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String actInstID_, String caseDefKey_, String caseDefID_, String caseInstID_, String caseExecutionID_, String taskID_, String name_, String varType_, Long rev_, String bytearrayID_, Long double_, Long long_, String text_, String text2_, String tenantID_, String state_, String createTime_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String procDefKey_;

        private String procDefID_;

        private String procInstID_;

        private String executionID_;

        private String actInstID_;

        private String caseDefKey_;

        private String caseDefID_;

        private String caseInstID_;

        private String caseExecutionID_;

        private String taskID_;

        private String name_;

        private String varType_;

        private Long rev_;

        private String bytearrayID_;

        private Long double_;

        private Long long_;

        private String text_;

        private String text2_;

        private String tenantID_;

        private String state_;

        private String createTime_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            this.procDefKey_ = procDefKey_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            this.actInstID_ = actInstID_;
            return this;
        }

        public Builder caseDefKey_(String caseDefKey_) {
            this.caseDefKey_ = caseDefKey_;
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

        public Builder caseExecutionID_(String caseExecutionID_) {
            this.caseExecutionID_ = caseExecutionID_;
            return this;
        }

        public Builder taskID_(String taskID_) {
            this.taskID_ = taskID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder varType_(String varType_) {
            this.varType_ = varType_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder bytearrayID_(String bytearrayID_) {
            this.bytearrayID_ = bytearrayID_;
            return this;
        }

        public Builder double_(Long double_) {
            this.double_ = double_;
            return this;
        }

        public Builder long_(Long long_) {
            this.long_ = long_;
            return this;
        }

        public Builder text_(String text_) {
            this.text_ = text_;
            return this;
        }

        public Builder text2_(String text2_) {
            this.text2_ = text2_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder state_(String state_) {
            this.state_ = state_;
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

        public FgActHiVarinst build() {
            return new FgActHiVarinst(ID_, procDefKey_, procDefID_, procInstID_, executionID_, actInstID_, caseDefKey_, caseDefID_, caseInstID_, caseExecutionID_, taskID_, name_, varType_, rev_, bytearrayID_, double_, long_, text_, text2_, tenantID_, state_, createTime_, rootProcInstID_, removalTime_);
        }
    }
}
