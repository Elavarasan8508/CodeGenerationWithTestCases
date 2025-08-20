package com.bsit.codegeneration.record;

public record FgActIDMembership(String userID_, String groupID_) {

    public static class Builder {

        private String userID_;

        private String groupID_;

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder groupID_(String groupID_) {
            this.groupID_ = groupID_;
            return this;
        }

        public FgActIDMembership build() {
            return new FgActIDMembership(userID_, groupID_);
        }
    }
}
