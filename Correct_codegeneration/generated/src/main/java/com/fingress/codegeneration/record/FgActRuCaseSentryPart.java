package com.bsit.codegeneration.record;

public record FgActRuCaseSentryPart(String ID_, Long rev_, String caseInstID_, String caseExecID_, String sentryID_, String type_, String sourceCaseExecID_, String standardEvent_, String source_, String variableEvent_, String variableName_, Long satisfied_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String caseInstID_;

        private String caseExecID_;

        private String sentryID_;

        private String type_;

        private String sourceCaseExecID_;

        private String standardEvent_;

        private String source_;

        private String variableEvent_;

        private String variableName_;

        private Long satisfied_;

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

        public Builder caseExecID_(String caseExecID_) {
            this.caseExecID_ = caseExecID_;
            return this;
        }

        public Builder sentryID_(String sentryID_) {
            this.sentryID_ = sentryID_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder sourceCaseExecID_(String sourceCaseExecID_) {
            this.sourceCaseExecID_ = sourceCaseExecID_;
            return this;
        }

        public Builder standardEvent_(String standardEvent_) {
            this.standardEvent_ = standardEvent_;
            return this;
        }

        public Builder source_(String source_) {
            this.source_ = source_;
            return this;
        }

        public Builder variableEvent_(String variableEvent_) {
            this.variableEvent_ = variableEvent_;
            return this;
        }

        public Builder variableName_(String variableName_) {
            this.variableName_ = variableName_;
            return this;
        }

        public Builder satisfied_(Long satisfied_) {
            this.satisfied_ = satisfied_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActRuCaseSentryPart build() {
            return new FgActRuCaseSentryPart(ID_, rev_, caseInstID_, caseExecID_, sentryID_, type_, sourceCaseExecID_, standardEvent_, source_, variableEvent_, variableName_, satisfied_, tenantID_);
        }
    }
}
