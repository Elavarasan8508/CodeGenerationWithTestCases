package com.bsit.codegeneration.record;

import java.util.List;

public record FgActIDGroup(String ID_, Long rev_, String name_, String type_, List<FgActIDMembership> fgActIDMemberships, List<FgActIDTenantMember> fgActIDTenantMembers, List<FgActIDUser> fgActIDUsers) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String name_;

        private String type_;

        private List<FgActIDMembership> fgActIDMemberships;

        private List<FgActIDTenantMember> fgActIDTenantMembers;

        private List<FgActIDUser> fgActIDUsers;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder fgActIDMemberships(List<FgActIDMembership> fgActIDMemberships) {
            this.fgActIDMemberships = fgActIDMemberships;
            return this;
        }

        public Builder fgActIDTenantMembers(List<FgActIDTenantMember> fgActIDTenantMembers) {
            this.fgActIDTenantMembers = fgActIDTenantMembers;
            return this;
        }

        public Builder fgActIDUsers(List<FgActIDUser> fgActIDUsers) {
            this.fgActIDUsers = fgActIDUsers;
            return this;
        }

        public FgActIDGroup build() {
            return new FgActIDGroup(ID_, rev_, name_, type_, fgActIDMemberships, fgActIDTenantMembers, fgActIDUsers);
        }
    }
}
