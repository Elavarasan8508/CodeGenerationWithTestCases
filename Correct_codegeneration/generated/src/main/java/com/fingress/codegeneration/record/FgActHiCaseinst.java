package com.bsit.codegeneration.record;

public record FgActHiCaseinst(String ID_, String caseInstID_, String businessKey_, String caseDefID_, String createTime_, String closeTime_, Long duration_, Long state_, String createUserID_, String superCaseInstanceID_, String superProcessInstanceID_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private String caseInstID_;

        private String businessKey_;

        private String caseDefID_;

        private String createTime_;

        private String closeTime_;

        private Long duration_;

        private Long state_;

        private String createUserID_;

        private String superCaseInstanceID_;

        private String superProcessInstanceID_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder businessKey_(String businessKey_) {
            this.businessKey_ = businessKey_;
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            this.caseDefID_ = caseDefID_;
            return this;
        }

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
            return this;
        }

        public Builder closeTime_(String closeTime_) {
            this.closeTime_ = closeTime_;
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

        public Builder createUserID_(String createUserID_) {
            this.createUserID_ = createUserID_;
            return this;
        }

        public Builder superCaseInstanceID_(String superCaseInstanceID_) {
            this.superCaseInstanceID_ = superCaseInstanceID_;
            return this;
        }

        public Builder superProcessInstanceID_(String superProcessInstanceID_) {
            this.superProcessInstanceID_ = superProcessInstanceID_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActHiCaseinst build() {
            return new FgActHiCaseinst(ID_, caseInstID_, businessKey_, caseDefID_, createTime_, closeTime_, duration_, state_, createUserID_, superCaseInstanceID_, superProcessInstanceID_, tenantID_);
        }
    }
}
