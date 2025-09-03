package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActGeBytearray {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String name_;

    private String deploymentID_;

    private byte[] bytes_;

    private java.math.BigDecimal generated_;

    private String tenantID_;

    private java.math.BigDecimal type_;

    private String createTime_;

    private String rootProcInstID_;

    private String removalTime_;

    private List<FgActRuExtTask> fgActRuExtTaskList;

    private List<FgActRuJob> fgActRuJobList;

    private List<FgActRuVariable> fgActRuVariableList;

    public FgActGeBytearray() {
    }

    public FgActGeBytearray(String ID_, java.math.BigDecimal rev_, String name_, String deploymentID_, byte[] bytes_, java.math.BigDecimal generated_, String tenantID_, java.math.BigDecimal type_, String createTime_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.name_ = name_;
        this.deploymentID_ = deploymentID_;
        this.bytes_ = bytes_;
        this.generated_ = generated_;
        this.tenantID_ = tenantID_;
        this.type_ = type_;
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

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getDeploymentID_() {
        return deploymentID_;
    }

    public void setDeploymentID_(String deploymentID_) {
        this.deploymentID_ = deploymentID_;
    }

    public byte[] getBytes_() {
        return bytes_;
    }

    public void setBytes_(byte[] bytes_) {
        this.bytes_ = bytes_;
    }

    public java.math.BigDecimal getGenerated_() {
        return generated_;
    }

    public void setGenerated_(java.math.BigDecimal generated_) {
        this.generated_ = generated_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public java.math.BigDecimal getType_() {
        return type_;
    }

    public void setType_(java.math.BigDecimal type_) {
        this.type_ = type_;
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

    public List<FgActRuExtTask> getFgActRuExtTaskList() {
        return fgActRuExtTaskList;
    }

    public void setFgActRuExtTaskList(List<FgActRuExtTask> fgActRuExtTaskList) {
        this.fgActRuExtTaskList = fgActRuExtTaskList;
    }

    public List<FgActRuJob> getFgActRuJobList() {
        return fgActRuJobList;
    }

    public void setFgActRuJobList(List<FgActRuJob> fgActRuJobList) {
        this.fgActRuJobList = fgActRuJobList;
    }

    public List<FgActRuVariable> getFgActRuVariableList() {
        return fgActRuVariableList;
    }

    public void setFgActRuVariableList(List<FgActRuVariable> fgActRuVariableList) {
        this.fgActRuVariableList = fgActRuVariableList;
    }

    public static class Builder {

        private FgActGeBytearray instance = new FgActGeBytearray();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            instance.setDeploymentID_(deploymentID_);
            return this;
        }

        public Builder bytes_(byte[] bytes_) {
            instance.setBytes_(bytes_);
            return this;
        }

        public Builder generated_(java.math.BigDecimal generated_) {
            instance.setGenerated_(generated_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder type_(java.math.BigDecimal type_) {
            instance.setType_(type_);
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

        public Builder fgActRuExtTaskList(List<FgActRuExtTask> fgActRuExtTaskList) {
            instance.setFgActRuExtTaskList(fgActRuExtTaskList);
            return this;
        }

        public Builder fgActRuJobList(List<FgActRuJob> fgActRuJobList) {
            instance.setFgActRuJobList(fgActRuJobList);
            return this;
        }

        public Builder fgActRuVariableList(List<FgActRuVariable> fgActRuVariableList) {
            instance.setFgActRuVariableList(fgActRuVariableList);
            return this;
        }

        public FgActGeBytearray build() {
            return instance;
        }
    }
}
