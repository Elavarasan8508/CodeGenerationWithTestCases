package com.bsit.codegeneration.record;

public record FgActHiActinst(String ID_, String parentActInstID_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String actID_, String taskID_, String callProcInstID_, String callCaseInstID_, String actName_, String actType_, String assignee_, String startTime_, String endTime_, Long duration_, Long actInstState_, Long sequenceCounter_, String tenantID_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String parentActInstID_;

        private String procDefKey_;

        private String procDefID_;

        private String procInstID_;

        private String executionID_;

        private String actID_;

        private String taskID_;

        private String callProcInstID_;

        private String callCaseInstID_;

        private String actName_;

        private String actType_;

        private String assignee_;

        private String startTime_;

        private String endTime_;

        private Long duration_;

        private Long actInstState_;

        private Long sequenceCounter_;

        private String tenantID_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder parentActInstID_(String parentActInstID_) {
            this.parentActInstID_ = parentActInstID_;
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

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
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

        public Builder actName_(String actName_) {
            this.actName_ = actName_;
            return this;
        }

        public Builder actType_(String actType_) {
            this.actType_ = actType_;
            return this;
        }

        public Builder assignee_(String assignee_) {
            this.assignee_ = assignee_;
            return this;
        }

        public Builder startTime_(String startTime_) {
            this.startTime_ = startTime_;
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

        public Builder actInstState_(Long actInstState_) {
            this.actInstState_ = actInstState_;
            return this;
        }

        public Builder sequenceCounter_(Long sequenceCounter_) {
            this.sequenceCounter_ = sequenceCounter_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
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

        public FgActHiActinst build() {
            return new FgActHiActinst(ID_, parentActInstID_, procDefKey_, procDefID_, procInstID_, executionID_, actID_, taskID_, callProcInstID_, callCaseInstID_, actName_, actType_, assignee_, startTime_, endTime_, duration_, actInstState_, sequenceCounter_, tenantID_, rootProcInstID_, removalTime_);
        }
    }
}
