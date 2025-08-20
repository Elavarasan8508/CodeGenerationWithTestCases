package com.bsit.codegeneration.record;

public record FgActIDTenantMember(String ID_, String tenantID_, String userID_, String groupID_) {

    public static class Builder {

        private String ID_;

        private String tenantID_;

        private String userID_;

        private String groupID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder groupID_(String groupID_) {
            this.groupID_ = groupID_;
            return this;
        }

        public FgActIDTenantMember build() {
            return new FgActIDTenantMember(ID_, tenantID_, userID_, groupID_);
        }
    }
}
