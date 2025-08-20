package com.bsit.codegeneration.record;

public record FgActRuVariable(String ID_, Long rev_, String type_, String name_, String executionID_, String procInstID_, String caseExecutionID_, String caseInstID_, String taskID_, String bytearrayID_, Long double_, Long long_, String text_, String text2_, String varScope_, Long sequenceCounter_, Long isConcurrentLocal_, String tenantID_, String procDefID_, String batchID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String type_;

        private String name_;

        private String executionID_;

        private String procInstID_;

        private String caseExecutionID_;

        private String caseInstID_;

        private String taskID_;

        private String bytearrayID_;

        private Long double_;

        private Long long_;

        private String text_;

        private String text2_;

        private String varScope_;

        private Long sequenceCounter_;

        private Long isConcurrentLocal_;

        private String tenantID_;

        private String procDefID_;

        private String batchID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
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

        public Builder caseExecutionID_(String caseExecutionID_) {
            this.caseExecutionID_ = caseExecutionID_;
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            this.caseInstID_ = caseInstID_;
            return this;
        }

        public Builder taskID_(String taskID_) {
            this.taskID_ = taskID_;
            return this;
        }

        public Builder bytearrayID_(String bytearrayID_) {
            this.bytearrayID_ = bytearrayID_;
            return this;
        }

        public Builder double_(Long double_) {
            this.double_ = double_;
            return this;
        }

        public Builder long_(Long long_) {
            this.long_ = long_;
            return this;
        }

        public Builder text_(String text_) {
            this.text_ = text_;
            return this;
        }

        public Builder text2_(String text2_) {
            this.text2_ = text2_;
            return this;
        }

        public Builder varScope_(String varScope_) {
            this.varScope_ = varScope_;
            return this;
        }

        public Builder sequenceCounter_(Long sequenceCounter_) {
            this.sequenceCounter_ = sequenceCounter_;
            return this;
        }

        public Builder isConcurrentLocal_(Long isConcurrentLocal_) {
            this.isConcurrentLocal_ = isConcurrentLocal_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder batchID_(String batchID_) {
            this.batchID_ = batchID_;
            return this;
        }

        public FgActRuVariable build() {
            return new FgActRuVariable(ID_, rev_, type_, name_, executionID_, procInstID_, caseExecutionID_, caseInstID_, taskID_, bytearrayID_, double_, long_, text_, text2_, varScope_, sequenceCounter_, isConcurrentLocal_, tenantID_, procDefID_, batchID_);
        }
    }
}
