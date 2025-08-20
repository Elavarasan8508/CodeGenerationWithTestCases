package com.bsit.codegeneration.record;

public record FgActHiDecIn(String ID_, String decInstID_, String clauseID_, String clauseName_, String varType_, String bytearrayID_, Long double_, Long long_, String text_, String text2_, String tenantID_, String createTime_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String decInstID_;

        private String clauseID_;

        private String clauseName_;

        private String varType_;

        private String bytearrayID_;

        private Long double_;

        private Long long_;

        private String text_;

        private String text2_;

        private String tenantID_;

        private String createTime_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder decInstID_(String decInstID_) {
            this.decInstID_ = decInstID_;
            return this;
        }

        public Builder clauseID_(String clauseID_) {
            this.clauseID_ = clauseID_;
            return this;
        }

        public Builder clauseName_(String clauseName_) {
            this.clauseName_ = clauseName_;
            return this;
        }

        public Builder varType_(String varType_) {
            this.varType_ = varType_;
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

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
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

        public FgActHiDecIn build() {
            return new FgActHiDecIn(ID_, decInstID_, clauseID_, clauseName_, varType_, bytearrayID_, double_, long_, text_, text2_, tenantID_, createTime_, rootProcInstID_, removalTime_);
        }
    }
}
