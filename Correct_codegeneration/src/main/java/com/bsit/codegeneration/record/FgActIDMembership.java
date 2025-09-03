package com.bsit.codegeneration.record;

import java.util.List;

public record FgActIDMembership(String userID_, String groupID_, FgActIDGroup fgActIDGroup, FgActIDUser fgActIDUser) {

    public static class Builder {

        private String userID_;

        private String groupID_;

        private FgActIDGroup fgActIDGroup;

        private FgActIDUser fgActIDUser;

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

        public Builder fgActIDUser(FgActIDUser fgActIDUser) {
            this.fgActIDUser = fgActIDUser;
            return this;
        }

        public FgActIDMembership build() {
            return new FgActIDMembership(userID_, groupID_, fgActIDGroup, fgActIDUser);
        }
    }
}
