package com.bsit.codegeneration.pojo;

public class FgActHiComment {

    private String ID_;

    private String type_;

    private String time_;

    private String userID_;

    private String taskID_;

    private String procInstID_;

    private String action_;

    private String message_;

    private byte[] fullMsg_;

    private String tenantID_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiComment() {
    }

    public FgActHiComment(String ID_, String type_, String time_, String userID_, String taskID_, String procInstID_, String action_, String message_, byte[] fullMsg_, String tenantID_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.type_ = type_;
        this.time_ = time_;
        this.userID_ = userID_;
        this.taskID_ = taskID_;
        this.procInstID_ = procInstID_;
        this.action_ = action_;
        this.message_ = message_;
        this.fullMsg_ = fullMsg_;
        this.tenantID_ = tenantID_;
        this.rootProcInstID_ = rootProcInstID_;
        this.removalTime_ = removalTime_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getTime_() {
        return time_;
    }

    public void setTime_(String time_) {
        this.time_ = time_;
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

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getAction_() {
        return action_;
    }

    public void setAction_(String action_) {
        this.action_ = action_;
    }

    public String getMessage_() {
        return message_;
    }

    public void setMessage_(String message_) {
        this.message_ = message_;
    }

    public byte[] getFullMsg_() {
        return fullMsg_;
    }

    public void setFullMsg_(byte[] fullMsg_) {
        this.fullMsg_ = fullMsg_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
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

        private FgActHiComment instance = new FgActHiComment();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder type_(String type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder time_(String time_) {
            instance.setTime_(time_);
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

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder action_(String action_) {
            instance.setAction_(action_);
            return this;
        }

        public Builder message_(String message_) {
            instance.setMessage_(message_);
            return this;
        }

        public Builder fullMsg_(byte[] fullMsg_) {
            instance.setFullMsg_(fullMsg_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
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

        public FgActHiComment build() {
            return instance;
        }
    }
}
