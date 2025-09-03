package com.bsit.codegeneration.pojo;

public class FgActIDMembership {

    private String userID_;

    private String groupID_;

    public FgActIDMembership() {
    }

    public FgActIDMembership(String userID_, String groupID_) {
        this.userID_ = userID_;
        this.groupID_ = groupID_;
    }

    public String getUserID_() {
        return userID_;
    }

    public void setUserID_(String userID_) {
        this.userID_ = userID_;
    }

    public String getGroupID_() {
        return groupID_;
    }

    public void setGroupID_(String groupID_) {
        this.groupID_ = groupID_;
    }

    public static class Builder {

        private FgActIDMembership instance = new FgActIDMembership();

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder groupID_(String groupID_) {
            instance.setGroupID_(groupID_);
            return this;
        }

        public FgActIDMembership build() {
            return instance;
        }
    }
}
