package com.bsit.codegeneration.record;

import java.util.List;

public record FgActIDTenantMember(String ID_, String tenantID_, String userID_, String groupID_, FgActIDGroup fgActIDGroup, FgActIDTenant fgActIDTenant, FgActIDUser fgActIDUser) {

    public static class Builder {

        private String ID_;

        private String tenantID_;

        private String userID_;

        private String groupID_;

        private FgActIDGroup fgActIDGroup;

        private FgActIDTenant fgActIDTenant;

        private FgActIDUser fgActIDUser;

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

        public Builder fgActIDGroup(FgActIDGroup fgActIDGroup) {
            this.fgActIDGroup = fgActIDGroup;
            return this;
        }

        public Builder fgActIDTenant(FgActIDTenant fgActIDTenant) {
            this.fgActIDTenant = fgActIDTenant;
            return this;
        }

        public Builder fgActIDUser(FgActIDUser fgActIDUser) {
            this.fgActIDUser = fgActIDUser;
            return this;
        }

        public FgActIDTenantMember build() {
            return new FgActIDTenantMember(ID_, tenantID_, userID_, groupID_, fgActIDGroup, fgActIDTenant, fgActIDUser);
        }
    }
}
