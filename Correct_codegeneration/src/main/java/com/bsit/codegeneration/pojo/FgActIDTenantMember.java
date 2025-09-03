package com.bsit.codegeneration.pojo;

public class FgActIDTenantMember {

    private String ID_;

    private String tenantID_;

    private String userID_;

    private String groupID_;

    public FgActIDTenantMember() {
    }

    public FgActIDTenantMember(String ID_, String tenantID_, String userID_, String groupID_) {
        this.ID_ = ID_;
        this.tenantID_ = tenantID_;
        this.userID_ = userID_;
        this.groupID_ = groupID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
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

        private FgActIDTenantMember instance = new FgActIDTenantMember();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder groupID_(String groupID_) {
            instance.setGroupID_(groupID_);
            return this;
        }

        public FgActIDTenantMember build() {
            return instance;
        }
    }
}
