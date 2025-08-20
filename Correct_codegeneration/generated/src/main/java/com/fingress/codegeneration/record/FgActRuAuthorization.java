package com.bsit.codegeneration.record;

public record FgActRuAuthorization(String ID_, Long rev_, Long type_, String groupID_, String userID_, Long resourceType_, String resourceID_, Long perms_, String removalTime_, String rootProcInstID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private Long type_;

        private String groupID_;

        private String userID_;

        private Long resourceType_;

        private String resourceID_;

        private Long perms_;

        private String removalTime_;

        private String rootProcInstID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder type_(Long type_) {
            this.type_ = type_;
            return this;
        }

        public Builder groupID_(String groupID_) {
            this.groupID_ = groupID_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder resourceType_(Long resourceType_) {
            this.resourceType_ = resourceType_;
            return this;
        }

        public Builder resourceID_(String resourceID_) {
            this.resourceID_ = resourceID_;
            return this;
        }

        public Builder perms_(Long perms_) {
            this.perms_ = perms_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            this.rootProcInstID_ = rootProcInstID_;
            return this;
        }

        public FgActRuAuthorization build() {
            return new FgActRuAuthorization(ID_, rev_, type_, groupID_, userID_, resourceType_, resourceID_, perms_, removalTime_, rootProcInstID_);
        }
    }
}
