package com.bsit.codegeneration.record;

public record FgActHiTaskinst(String ID_, String taskDefKey_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String caseDefKey_, String caseDefID_, String caseInstID_, String caseExecutionID_, String actInstID_, String parentTaskID_, String name_, String description_, String owner_, String assignee_, String startTime_, String endTime_, Long duration_, String deleteReason_, Long priority_, String dueDate_, String followUpDate_, String tenantID_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String taskDefKey_;

        private String procDefKey_;

        private String procDefID_;

        private String procInstID_;

        private String executionID_;

        private String caseDefKey_;

        private String caseDefID_;

        private String caseInstID_;

        private String caseExecutionID_;

        private String actInstID_;

        private String parentTaskID_;

        private String name_;

        private String description_;

        private String owner_;

        private String assignee_;

        private String startTime_;

        private String endTime_;

        private Long duration_;

        private String deleteReason_;

        private Long priority_;

        private String dueDate_;

        private String followUpDate_;

        private String tenantID_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder taskDefKey_(String taskDefKey_) {
            this.taskDefKey_ = taskDefKey_;
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

        public Builder actInstID_(String actInstID_) {
            this.actInstID_ = actInstID_;
            return this;
        }

        public Builder parentTaskID_(String parentTaskID_) {
            this.parentTaskID_ = parentTaskID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder description_(String description_) {
            this.description_ = description_;
            return this;
        }

        public Builder owner_(String owner_) {
            this.owner_ = owner_;
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

        public Builder deleteReason_(String deleteReason_) {
            this.deleteReason_ = deleteReason_;
            return this;
        }

        public Builder priority_(Long priority_) {
            this.priority_ = priority_;
            return this;
        }

        public Builder dueDate_(String dueDate_) {
            this.dueDate_ = dueDate_;
            return this;
        }

        public Builder followUpDate_(String followUpDate_) {
            this.followUpDate_ = followUpDate_;
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

        public FgActHiTaskinst build() {
            return new FgActHiTaskinst(ID_, taskDefKey_, procDefKey_, procDefID_, procInstID_, executionID_, caseDefKey_, caseDefID_, caseInstID_, caseExecutionID_, actInstID_, parentTaskID_, name_, description_, owner_, assignee_, startTime_, endTime_, duration_, deleteReason_, priority_, dueDate_, followUpDate_, tenantID_, rootProcInstID_, removalTime_);
        }
    }
}
