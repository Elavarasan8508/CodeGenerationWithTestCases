package com.bsit.codegeneration.record;

public record FgActRuTask(String ID_, Long rev_, String executionID_, String procInstID_, String procDefID_, String caseExecutionID_, String caseInstID_, String caseDefID_, String name_, String parentTaskID_, String description_, String taskDefKey_, String owner_, String assignee_, String delegation_, Long priority_, String createTime_, String dueDate_, String followUpDate_, Long suspensionState_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String executionID_;

        private String procInstID_;

        private String procDefID_;

        private String caseExecutionID_;

        private String caseInstID_;

        private String caseDefID_;

        private String name_;

        private String parentTaskID_;

        private String description_;

        private String taskDefKey_;

        private String owner_;

        private String assignee_;

        private String delegation_;

        private Long priority_;

        private String createTime_;

        private String dueDate_;

        private String followUpDate_;

        private Long suspensionState_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder caseExecutionID_(String caseExecutionID_) {
            this.caseExecutionID_ = caseExecutionID_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            this.caseDefID_ = caseDefID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder parentTaskID_(String parentTaskID_) {
            this.parentTaskID_ = parentTaskID_;
            return this;
        }

        public Builder description_(String description_) {
            this.description_ = description_;
            return this;
        }

        public Builder taskDefKey_(String taskDefKey_) {
            this.taskDefKey_ = taskDefKey_;
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

        public Builder delegation_(String delegation_) {
            this.delegation_ = delegation_;
            return this;
        }

        public Builder priority_(Long priority_) {
            this.priority_ = priority_;
            return this;
        }

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
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

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActRuTask build() {
            return new FgActRuTask(ID_, rev_, executionID_, procInstID_, procDefID_, caseExecutionID_, caseInstID_, caseDefID_, name_, parentTaskID_, description_, taskDefKey_, owner_, assignee_, delegation_, priority_, createTime_, dueDate_, followUpDate_, suspensionState_, tenantID_);
        }
    }
}
