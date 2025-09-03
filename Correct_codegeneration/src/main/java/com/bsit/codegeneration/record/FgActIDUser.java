package com.bsit.codegeneration.record;

import java.util.List;

public record FgActIDUser(String ID_, Long rev_, String first_, String last_, String email_, String pwd_, String salt_, String pictureID_, String lockExpTime_, Long attempts_, List<FgActIDGroup> fgActIDGroups, List<FgActIDMembership> fgActIDMemberships, List<FgActIDTenantMember> fgActIDTenantMembers) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String first_;

        private String last_;

        private String email_;

        private String pwd_;

        private String salt_;

        private String pictureID_;

        private String lockExpTime_;

        private Long attempts_;

        private List<FgActIDGroup> fgActIDGroups;

        private List<FgActIDMembership> fgActIDMemberships;

        private List<FgActIDTenantMember> fgActIDTenantMembers;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder first_(String first_) {
            this.first_ = first_;
            return this;
        }

        public Builder last_(String last_) {
            this.last_ = last_;
            return this;
        }

        public Builder email_(String email_) {
            this.email_ = email_;
            return this;
        }

        public Builder pwd_(String pwd_) {
            this.pwd_ = pwd_;
            return this;
        }

        public Builder salt_(String salt_) {
            this.salt_ = salt_;
            return this;
        }

        public Builder pictureID_(String pictureID_) {
            this.pictureID_ = pictureID_;
            return this;
        }

        public Builder lockExpTime_(String lockExpTime_) {
            this.lockExpTime_ = lockExpTime_;
            return this;
        }

        public Builder attempts_(Long attempts_) {
            this.attempts_ = attempts_;
            return this;
        }

        public Builder fgActIDGroups(List<FgActIDGroup> fgActIDGroups) {
            this.fgActIDGroups = fgActIDGroups;
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

        public FgActIDUser build() {
            return new FgActIDUser(ID_, rev_, first_, last_, email_, pwd_, salt_, pictureID_, lockExpTime_, attempts_, fgActIDGroups, fgActIDMemberships, fgActIDTenantMembers);
        }
    }
}
