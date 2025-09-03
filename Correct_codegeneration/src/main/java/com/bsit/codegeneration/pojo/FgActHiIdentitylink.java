package com.bsit.codegeneration.pojo;

public class FgActHiIdentitylink {

    private String ID_;

    private String timestamp_;

    private String type_;

    private String userID_;

    private String groupID_;

    private String taskID_;

    private String procDefID_;

    private String operationType_;

    private String assignerID_;

    private String procDefKey_;

    private String tenantID_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiIdentitylink() {
    }

    public FgActHiIdentitylink(String ID_, String timestamp_, String type_, String userID_, String groupID_, String taskID_, String procDefID_, String operationType_, String assignerID_, String procDefKey_, String tenantID_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.timestamp_ = timestamp_;
        this.type_ = type_;
        this.userID_ = userID_;
        this.groupID_ = groupID_;
        this.taskID_ = taskID_;
        this.procDefID_ = procDefID_;
        this.operationType_ = operationType_;
        this.assignerID_ = assignerID_;
        this.procDefKey_ = procDefKey_;
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

    public String getTimestamp_() {
        return timestamp_;
    }

    public void setTimestamp_(String timestamp_) {
        this.timestamp_ = timestamp_;
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

    public String getGroupID_() {
        return groupID_;
    }

    public void setGroupID_(String groupID_) {
        this.groupID_ = groupID_;
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

    public String getOperationType_() {
        return operationType_;
    }

    public void setOperationType_(String operationType_) {
        this.operationType_ = operationType_;
    }

    public String getAssignerID_() {
        return assignerID_;
    }

    public void setAssignerID_(String assignerID_) {
        this.assignerID_ = assignerID_;
    }

    public String getProcDefKey_() {
        return procDefKey_;
    }

    public void setProcDefKey_(String procDefKey_) {
        this.procDefKey_ = procDefKey_;
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

        private FgActHiIdentitylink instance = new FgActHiIdentitylink();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            instance.setTimestamp_(timestamp_);
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

        public Builder groupID_(String groupID_) {
            instance.setGroupID_(groupID_);
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

        public Builder operationType_(String operationType_) {
            instance.setOperationType_(operationType_);
            return this;
        }

        public Builder assignerID_(String assignerID_) {
            instance.setAssignerID_(assignerID_);
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            instance.setProcDefKey_(procDefKey_);
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

        public FgActHiIdentitylink build() {
            return instance;
        }
    }
}
