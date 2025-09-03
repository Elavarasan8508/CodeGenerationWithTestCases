package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiAttachment {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String userID_;

    private String name_;

    private String description_;

    private String type_;

    private String taskID_;

    private String procInstID_;

    private String URL_;

    private String contentID_;

    private String tenantID_;

    private String createTime_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiAttachment() {
    }

    public FgActHiAttachment(String ID_, java.math.BigDecimal rev_, String userID_, String name_, String description_, String type_, String taskID_, String procInstID_, String URL_, String contentID_, String tenantID_, String createTime_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.userID_ = userID_;
        this.name_ = name_;
        this.description_ = description_;
        this.type_ = type_;
        this.taskID_ = taskID_;
        this.procInstID_ = procInstID_;
        this.URL_ = URL_;
        this.contentID_ = contentID_;
        this.tenantID_ = tenantID_;
        this.createTime_ = createTime_;
        this.rootProcInstID_ = rootProcInstID_;
        this.removalTime_ = removalTime_;
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

    public String getUserID_() {
        return userID_;
    }

    public void setUserID_(String userID_) {
        this.userID_ = userID_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getTaskID_() {
        return taskID_;
    }

    public void setTaskID_(String taskID_) {
        this.taskID_ = taskID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getURL_() {
        return URL_;
    }

    public void setURL_(String URL_) {
        this.URL_ = URL_;
    }

    public String getContentID_() {
        return contentID_;
    }

    public void setContentID_(String contentID_) {
        this.contentID_ = contentID_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getCreateTime_() {
        return createTime_;
    }

    public void setCreateTime_(String createTime_) {
        this.createTime_ = createTime_;
    }

    public String getRootProcInstID_() {
        return rootProcInstID_;
    }

    public void setRootProcInstID_(String rootProcInstID_) {
        this.rootProcInstID_ = rootProcInstID_;
    }

    public String getRemovalTime_() {
        return removalTime_;
    }

    public void setRemovalTime_(String removalTime_) {
        this.removalTime_ = removalTime_;
    }

    public static class Builder {

        private FgActHiAttachment instance = new FgActHiAttachment();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder description_(String description_) {
            instance.setDescription_(description_);
            return this;
        }

        public Builder type_(String type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder taskID_(String taskID_) {
            instance.setTaskID_(taskID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder URL_(String URL_) {
            instance.setURL_(URL_);
            return this;
        }

        public Builder contentID_(String contentID_) {
            instance.setContentID_(contentID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder createTime_(String createTime_) {
            instance.setCreateTime_(createTime_);
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            instance.setRootProcInstID_(rootProcInstID_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public FgActHiAttachment build() {
            return instance;
        }
    }
}
