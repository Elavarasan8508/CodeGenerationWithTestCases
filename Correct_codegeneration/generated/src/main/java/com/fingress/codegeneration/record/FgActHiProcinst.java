package com.bsit.codegeneration.record;

public record FgActHiProcinst(String ID_, String procInstID_, String businessKey_, String procDefKey_, String procDefID_, String startTime_, String endTime_, Long duration_, String startUserID_, String startActID_, String endActID_, String superProcessInstanceID_, String superCaseInstanceID_, String caseInstID_, String deleteReason_, String tenantID_, String state_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String procInstID_;

        private String businessKey_;

        private String procDefKey_;

        private String procDefID_;

        private String startTime_;

        private String endTime_;

        private Long duration_;

        private String startUserID_;

        private String startActID_;

        private String endActID_;

        private String superProcessInstanceID_;

        private String superCaseInstanceID_;

        private String caseInstID_;

        private String deleteReason_;

        private String tenantID_;

        private String state_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder businessKey_(String businessKey_) {
            this.businessKey_ = businessKey_;
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

        public Builder startUserID_(String startUserID_) {
            this.startUserID_ = startUserID_;
            return this;
        }

        public Builder startActID_(String startActID_) {
            this.startActID_ = startActID_;
            return this;
        }

        public Builder endActID_(String endActID_) {
            this.endActID_ = endActID_;
            return this;
        }

        public Builder superProcessInstanceID_(String superProcessInstanceID_) {
            this.superProcessInstanceID_ = superProcessInstanceID_;
            return this;
        }

        public Builder superCaseInstanceID_(String superCaseInstanceID_) {
            this.superCaseInstanceID_ = superCaseInstanceID_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder deleteReason_(String deleteReason_) {
            this.deleteReason_ = deleteReason_;
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

        public Builder rootProcInstID_(String rootProcInstID_) {
            this.rootProcInstID_ = rootProcInstID_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public FgActHiProcinst build() {
            return new FgActHiProcinst(ID_, procInstID_, businessKey_, procDefKey_, procDefID_, startTime_, endTime_, duration_, startUserID_, startActID_, endActID_, superProcessInstanceID_, superCaseInstanceID_, caseInstID_, deleteReason_, tenantID_, state_, rootProcInstID_, removalTime_);
        }
    }
}
