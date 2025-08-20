package com.bsit.codegeneration.record;

public record FgActHiOpLog(String ID_, String deploymentID_, String procDefID_, String procDefKey_, String procInstID_, String executionID_, String caseDefID_, String caseInstID_, String caseExecutionID_, String taskID_, String jobID_, String jobDefID_, String batchID_, String userID_, String timestamp_, String operationType_, String operationID_, String entityType_, String property_, String orgValue_, String newValue_, String tenantID_, String rootProcInstID_, String removalTime_, String category_, String externalTaskID_, String annotation_) {

    public static class Builder {

        private String ID_;

        private String deploymentID_;

        private String procDefID_;

        private String procDefKey_;

        private String procInstID_;

        private String executionID_;

        private String caseDefID_;

        private String caseInstID_;

        private String caseExecutionID_;

        private String taskID_;

        private String jobID_;

        private String jobDefID_;

        private String batchID_;

        private String userID_;

        private String timestamp_;

        private String operationType_;

        private String operationID_;

        private String entityType_;

        private String property_;

        private String orgValue_;

        private String newValue_;

        private String tenantID_;

        private String rootProcInstID_;

        private String removalTime_;

        private String category_;

        private String externalTaskID_;

        private String annotation_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            this.deploymentID_ = deploymentID_;
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

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
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

        public Builder jobID_(String jobID_) {
            this.jobID_ = jobID_;
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            this.jobDefID_ = jobDefID_;
            return this;
        }

        public Builder batchID_(String batchID_) {
            this.batchID_ = batchID_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            this.timestamp_ = timestamp_;
            return this;
        }

        public Builder operationType_(String operationType_) {
            this.operationType_ = operationType_;
            return this;
        }

        public Builder operationID_(String operationID_) {
            this.operationID_ = operationID_;
            return this;
        }

        public Builder entityType_(String entityType_) {
            this.entityType_ = entityType_;
            return this;
        }

        public Builder property_(String property_) {
            this.property_ = property_;
            return this;
        }

        public Builder orgValue_(String orgValue_) {
            this.orgValue_ = orgValue_;
            return this;
        }

        public Builder newValue_(String newValue_) {
            this.newValue_ = newValue_;
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

        public Builder category_(String category_) {
            this.category_ = category_;
            return this;
        }

        public Builder externalTaskID_(String externalTaskID_) {
            this.externalTaskID_ = externalTaskID_;
            return this;
        }

        public Builder annotation_(String annotation_) {
            this.annotation_ = annotation_;
            return this;
        }

        public FgActHiOpLog build() {
            return new FgActHiOpLog(ID_, deploymentID_, procDefID_, procDefKey_, procInstID_, executionID_, caseDefID_, caseInstID_, caseExecutionID_, taskID_, jobID_, jobDefID_, batchID_, userID_, timestamp_, operationType_, operationID_, entityType_, property_, orgValue_, newValue_, tenantID_, rootProcInstID_, removalTime_, category_, externalTaskID_, annotation_);
        }
    }
}
