package com.bsit.codegeneration.record;

public record FgActRuCaseExecution(String ID_, Long rev_, String caseInstID_, String superCaseExec_, String superExec_, String businessKey_, String parentID_, String caseDefID_, String actID_, Long prevState_, Long currentState_, Long required_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String caseInstID_;

        private String superCaseExec_;

        private String superExec_;

        private String businessKey_;

        private String parentID_;

        private String caseDefID_;

        private String actID_;

        private Long prevState_;

        private Long currentState_;

        private Long required_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder superCaseExec_(String superCaseExec_) {
            this.superCaseExec_ = superCaseExec_;
            return this;
        }

        public Builder superExec_(String superExec_) {
            this.superExec_ = superExec_;
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

        public Builder caseDefID_(String caseDefID_) {
            this.caseDefID_ = caseDefID_;
            return this;
        }

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder prevState_(Long prevState_) {
            this.prevState_ = prevState_;
            return this;
        }

        public Builder currentState_(Long currentState_) {
            this.currentState_ = currentState_;
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

        public FgActRuCaseExecution build() {
            return new FgActRuCaseExecution(ID_, rev_, caseInstID_, superCaseExec_, superExec_, businessKey_, parentID_, caseDefID_, actID_, prevState_, currentState_, required_, tenantID_);
        }
    }
}
