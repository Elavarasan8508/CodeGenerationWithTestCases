package com.bsit.codegeneration.pojo;

public class FgMyQueueView {

    private String ID_;

    private String procInstID_;

    private String name_;

    private String groupID_;

    private String tenantID_;

    private String procDefID_;

    public FgMyQueueView() {
    }

    public FgMyQueueView(String ID_, String procInstID_, String name_, String groupID_, String tenantID_, String procDefID_) {
        this.ID_ = ID_;
        this.procInstID_ = procInstID_;
        this.name_ = name_;
        this.groupID_ = groupID_;
        this.tenantID_ = tenantID_;
        this.procDefID_ = procDefID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getGroupID_() {
        return groupID_;
    }

    public void setGroupID_(String groupID_) {
        this.groupID_ = groupID_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public static class Builder {

        private FgMyQueueView instance = new FgMyQueueView();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder groupID_(String groupID_) {
            instance.setGroupID_(groupID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public FgMyQueueView build() {
            return instance;
        }
    }
}
