package com.bsit.codegeneration.record;

public record FgActRuExecution(String ID_, Long rev_, String procInstID_, String businessKey_, String parentID_, String procDefID_, String superExec_, String superCaseExec_, String caseInstID_, String actID_, String actInstID_, Long isActive_, Long isConcurrent_, Long isScope_, Long isEventScope_, Long suspensionState_, Long cachedEntState_, Long sequenceCounter_, String tenantID_, String rootProcInstID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String procInstID_;

        private String businessKey_;

        private String parentID_;

        private String procDefID_;

        private String superExec_;

        private String superCaseExec_;

        private String caseInstID_;

        private String actID_;

        private String actInstID_;

        private Long isActive_;

        private Long isConcurrent_;

        private Long isScope_;

        private Long isEventScope_;

        private Long suspensionState_;

        private Long cachedEntState_;

        private Long sequenceCounter_;

        private String tenantID_;

        private String rootProcInstID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
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

        public Builder parentID_(String parentID_) {
            this.parentID_ = parentID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder superExec_(String superExec_) {
            this.superExec_ = superExec_;
            return this;
        }

        public Builder superCaseExec_(String superCaseExec_) {
            this.superCaseExec_ = superCaseExec_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            this.actInstID_ = actInstID_;
            return this;
        }

        public Builder isActive_(Long isActive_) {
            this.isActive_ = isActive_;
            return this;
        }

        public Builder isConcurrent_(Long isConcurrent_) {
            this.isConcurrent_ = isConcurrent_;
            return this;
        }

        public Builder isScope_(Long isScope_) {
            this.isScope_ = isScope_;
            return this;
        }

        public Builder isEventScope_(Long isEventScope_) {
            this.isEventScope_ = isEventScope_;
            return this;
        }

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder cachedEntState_(Long cachedEntState_) {
            this.cachedEntState_ = cachedEntState_;
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

        public FgActRuExecution build() {
            return new FgActRuExecution(ID_, rev_, procInstID_, businessKey_, parentID_, procDefID_, superExec_, superCaseExec_, caseInstID_, actID_, actInstID_, isActive_, isConcurrent_, isScope_, isEventScope_, suspensionState_, cachedEntState_, sequenceCounter_, tenantID_, rootProcInstID_);
        }
    }
}
