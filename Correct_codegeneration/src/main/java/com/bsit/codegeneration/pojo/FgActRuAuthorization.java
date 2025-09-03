package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuAuthorization {

    private String ID_;

    private java.math.BigDecimal rev_;

    private java.math.BigDecimal type_;

    private String groupID_;

    private String userID_;

    private java.math.BigDecimal resourceType_;

    private String resourceID_;

    private java.math.BigDecimal perms_;

    private String removalTime_;

    private String rootProcInstID_;

    public FgActRuAuthorization() {
    }

    public FgActRuAuthorization(String ID_, java.math.BigDecimal rev_, java.math.BigDecimal type_, String groupID_, String userID_, java.math.BigDecimal resourceType_, String resourceID_, java.math.BigDecimal perms_, String removalTime_, String rootProcInstID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.type_ = type_;
        this.groupID_ = groupID_;
        this.userID_ = userID_;
        this.resourceType_ = resourceType_;
        this.resourceID_ = resourceID_;
        this.perms_ = perms_;
        this.removalTime_ = removalTime_;
        this.rootProcInstID_ = rootProcInstID_;
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

    public java.math.BigDecimal getType_() {
        return type_;
    }

    public void setType_(java.math.BigDecimal type_) {
        this.type_ = type_;
    }

    public String getGroupID_() {
        return groupID_;
    }

    public void setGroupID_(String groupID_) {
        this.groupID_ = groupID_;
    }

    public String getUserID_() {
        return userID_;
    }

    public void setUserID_(String userID_) {
        this.userID_ = userID_;
    }

    public java.math.BigDecimal getResourceType_() {
        return resourceType_;
    }

    public void setResourceType_(java.math.BigDecimal resourceType_) {
        this.resourceType_ = resourceType_;
    }

    public String getResourceID_() {
        return resourceID_;
    }

    public void setResourceID_(String resourceID_) {
        this.resourceID_ = resourceID_;
    }

    public java.math.BigDecimal getPerms_() {
        return perms_;
    }

    public void setPerms_(java.math.BigDecimal perms_) {
        this.perms_ = perms_;
    }

    public String getRemovalTime_() {
        return removalTime_;
    }

    public void setRemovalTime_(String removalTime_) {
        this.removalTime_ = removalTime_;
    }

    public String getRootProcInstID_() {
        return rootProcInstID_;
    }

    public void setRootProcInstID_(String rootProcInstID_) {
        this.rootProcInstID_ = rootProcInstID_;
    }

    public static class Builder {

        private FgActRuAuthorization instance = new FgActRuAuthorization();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder type_(java.math.BigDecimal type_) {
            instance.setType_(type_);
            return this;
        }

        public Builder groupID_(String groupID_) {
            instance.setGroupID_(groupID_);
            return this;
        }

        public Builder userID_(String userID_) {
            instance.setUserID_(userID_);
            return this;
        }

        public Builder resourceType_(java.math.BigDecimal resourceType_) {
            instance.setResourceType_(resourceType_);
            return this;
        }

        public Builder resourceID_(String resourceID_) {
            instance.setResourceID_(resourceID_);
            return this;
        }

        public Builder perms_(java.math.BigDecimal perms_) {
            instance.setPerms_(perms_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            instance.setRootProcInstID_(rootProcInstID_);
            return this;
        }

        public FgActRuAuthorization build() {
            return instance;
        }
    }
}
