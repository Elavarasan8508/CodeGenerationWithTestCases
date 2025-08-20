package com.bsit.codegeneration.record;

public record FgActHiDecinst(String ID_, String decDefID_, String decDefKey_, String decDefName_, String procDefKey_, String procDefID_, String procInstID_, String caseDefKey_, String caseDefID_, String caseInstID_, String actInstID_, String actID_, String evalTime_, Long collectValue_, String userID_, String rootDecInstID_, String decReqID_, String decReqKey_, String tenantID_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String decDefID_;

        private String decDefKey_;

        private String decDefName_;

        private String procDefKey_;

        private String procDefID_;

        private String procInstID_;

        private String caseDefKey_;

        private String caseDefID_;

        private String caseInstID_;

        private String actInstID_;

        private String actID_;

        private String evalTime_;

        private Long collectValue_;

        private String userID_;

        private String rootDecInstID_;

        private String decReqID_;

        private String decReqKey_;

        private String tenantID_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder decDefID_(String decDefID_) {
            this.decDefID_ = decDefID_;
            return this;
        }

        public Builder decDefKey_(String decDefKey_) {
            this.decDefKey_ = decDefKey_;
            return this;
        }

        public Builder decDefName_(String decDefName_) {
            this.decDefName_ = decDefName_;
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

        public Builder actInstID_(String actInstID_) {
            this.actInstID_ = actInstID_;
            return this;
        }

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder evalTime_(String evalTime_) {
            this.evalTime_ = evalTime_;
            return this;
        }

        public Builder collectValue_(Long collectValue_) {
            this.collectValue_ = collectValue_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder rootDecInstID_(String rootDecInstID_) {
            this.rootDecInstID_ = rootDecInstID_;
            return this;
        }

        public Builder decReqID_(String decReqID_) {
            this.decReqID_ = decReqID_;
            return this;
        }

        public Builder decReqKey_(String decReqKey_) {
            this.decReqKey_ = decReqKey_;
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

        public FgActHiDecinst build() {
            return new FgActHiDecinst(ID_, decDefID_, decDefKey_, decDefName_, procDefKey_, procDefID_, procInstID_, caseDefKey_, caseDefID_, caseInstID_, actInstID_, actID_, evalTime_, collectValue_, userID_, rootDecInstID_, decReqID_, decReqKey_, tenantID_, rootProcInstID_, removalTime_);
        }
    }
}
