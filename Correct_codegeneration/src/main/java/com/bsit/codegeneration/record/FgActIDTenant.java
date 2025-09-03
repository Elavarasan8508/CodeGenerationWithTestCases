package com.bsit.codegeneration.record;

import java.util.List;

public record FgActIDTenant(String ID_, Long rev_, String name_, List<FgActIDTenantMember> fgActIDTenantMembers) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String name_;

        private List<FgActIDTenantMember> fgActIDTenantMembers;

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

        public Builder fgActIDTenantMembers(List<FgActIDTenantMember> fgActIDTenantMembers) {
            this.fgActIDTenantMembers = fgActIDTenantMembers;
            return this;
        }

        public FgActIDTenant build() {
            return new FgActIDTenant(ID_, rev_, name_, fgActIDTenantMembers);
        }
    }
}
