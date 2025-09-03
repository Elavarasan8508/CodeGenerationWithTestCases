package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuIdentitylink {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String groupID_;

    private String type_;

    private String userID_;

    private String taskID_;

    private String procDefID_;

    private String tenantID_;

    public FgActRuIdentitylink() {
    }

    public FgActRuIdentitylink(String ID_, java.math.BigDecimal rev_, String groupID_, String type_, String userID_, String taskID_, String procDefID_, String tenantID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.groupID_ = groupID_;
        this.type_ = type_;
        this.userID_ = userID_;
        this.taskID_ = taskID_;
        this.procDefID_ = procDefID_;
        this.tenantID_ = tenantID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public java.math.BigDecimal getRev_() {
        return rev_;
    }

    public void setRev_(java.math.BigDecimal rev_) {
        this.rev_ = rev_;
    }

    public String getGroupID_() {
        return groupID_;
    }

    public void setGroupID_(String groupID_) {
        this.groupID_ = groupID_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getUserID_() {
        return userID_;
    }

    public void setUserID_(String userID_) {
        this.userID_ = userID_;
    }

    public String getTaskID_() {
        return taskID_;
    }

    public void setTaskID_(String taskID_) {
        this.taskID_ = taskID_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public static class Builder {

        private FgActRuIdentitylink instance = new FgActRuIdentitylink();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder groupID_(String groupID_) {
            instance.setGroupID_(groupID_);
            return this;
        }

        public Builder type_(String type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder taskID_(String taskID_) {
            instance.setTaskID_(taskID_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public FgActRuIdentitylink build() {
            return instance;
        }
    }
}
