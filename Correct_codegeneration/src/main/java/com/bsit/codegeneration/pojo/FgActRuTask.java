package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActRuTask {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String executionID_;

    private String procInstID_;

    private String procDefID_;

    private String caseExecutionID_;

    private String caseInstID_;

    private String caseDefID_;

    private String name_;

    private String parentTaskID_;

    private String description_;

    private String taskDefKey_;

    private String owner_;

    private String assignee_;

    private String delegation_;

    private java.math.BigDecimal priority_;

    private String createTime_;

    private String dueDate_;

    private String followUpDate_;

    private java.math.BigDecimal suspensionState_;

    private String tenantID_;

    private List<FgActRuIdentitylink> fgActRuIdentitylinkList;

    public FgActRuTask() {
    }

    public FgActRuTask(String ID_, java.math.BigDecimal rev_, String executionID_, String procInstID_, String procDefID_, String caseExecutionID_, String caseInstID_, String caseDefID_, String name_, String parentTaskID_, String description_, String taskDefKey_, String owner_, String assignee_, String delegation_, java.math.BigDecimal priority_, String createTime_, String dueDate_, String followUpDate_, java.math.BigDecimal suspensionState_, String tenantID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.executionID_ = executionID_;
        this.procInstID_ = procInstID_;
        this.procDefID_ = procDefID_;
        this.caseExecutionID_ = caseExecutionID_;
        this.caseInstID_ = caseInstID_;
        this.caseDefID_ = caseDefID_;
        this.name_ = name_;
        this.parentTaskID_ = parentTaskID_;
        this.description_ = description_;
        this.taskDefKey_ = taskDefKey_;
        this.owner_ = owner_;
        this.assignee_ = assignee_;
        this.delegation_ = delegation_;
        this.priority_ = priority_;
        this.createTime_ = createTime_;
        this.dueDate_ = dueDate_;
        this.followUpDate_ = followUpDate_;
        this.suspensionState_ = suspensionState_;
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

    public String getExecutionID_() {
        return executionID_;
    }

    public void setExecutionID_(String executionID_) {
        this.executionID_ = executionID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getCaseExecutionID_() {
        return caseExecutionID_;
    }

    public void setCaseExecutionID_(String caseExecutionID_) {
        this.caseExecutionID_ = caseExecutionID_;
    }

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getCaseDefID_() {
        return caseDefID_;
    }

    public void setCaseDefID_(String caseDefID_) {
        this.caseDefID_ = caseDefID_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getParentTaskID_() {
        return parentTaskID_;
    }

    public void setParentTaskID_(String parentTaskID_) {
        this.parentTaskID_ = parentTaskID_;
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    public String getTaskDefKey_() {
        return taskDefKey_;
    }

    public void setTaskDefKey_(String taskDefKey_) {
        this.taskDefKey_ = taskDefKey_;
    }

    public String getOwner_() {
        return owner_;
    }

    public void setOwner_(String owner_) {
        this.owner_ = owner_;
    }

    public String getAssignee_() {
        return assignee_;
    }

    public void setAssignee_(String assignee_) {
        this.assignee_ = assignee_;
    }

    public String getDelegation_() {
        return delegation_;
    }

    public void setDelegation_(String delegation_) {
        this.delegation_ = delegation_;
    }

    public java.math.BigDecimal getPriority_() {
        return priority_;
    }

    public void setPriority_(java.math.BigDecimal priority_) {
        this.priority_ = priority_;
    }

    public String getCreateTime_() {
        return createTime_;
    }

    public void setCreateTime_(String createTime_) {
        this.createTime_ = createTime_;
    }

    public String getDueDate_() {
        return dueDate_;
    }

    public void setDueDate_(String dueDate_) {
        this.dueDate_ = dueDate_;
    }

    public String getFollowUpDate_() {
        return followUpDate_;
    }

    public void setFollowUpDate_(String followUpDate_) {
        this.followUpDate_ = followUpDate_;
    }

    public java.math.BigDecimal getSuspensionState_() {
        return suspensionState_;
    }

    public void setSuspensionState_(java.math.BigDecimal suspensionState_) {
        this.suspensionState_ = suspensionState_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public List<FgActRuIdentitylink> getFgActRuIdentitylinkList() {
        return fgActRuIdentitylinkList;
    }

    public void setFgActRuIdentitylinkList(List<FgActRuIdentitylink> fgActRuIdentitylinkList) {
        this.fgActRuIdentitylinkList = fgActRuIdentitylinkList;
    }

    public static class Builder {

        private FgActRuTask instance = new FgActRuTask();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder executionID_(String executionID_) {
            instance.setExecutionID_(executionID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder caseExecutionID_(String caseExecutionID_) {
            instance.setCaseExecutionID_(caseExecutionID_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            instance.setCaseDefID_(caseDefID_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder parentTaskID_(String parentTaskID_) {
            instance.setParentTaskID_(parentTaskID_);
            return this;
        }

        public Builder description_(String description_) {
            instance.setDescription_(description_);
            return this;
        }

        public Builder taskDefKey_(String taskDefKey_) {
            instance.setTaskDefKey_(taskDefKey_);
            return this;
        }

        public Builder owner_(String owner_) {
            instance.setOwner_(owner_);
            return this;
        }

        public Builder assignee_(String assignee_) {
            instance.setAssignee_(assignee_);
            return this;
        }

        public Builder delegation_(String delegation_) {
            instance.setDelegation_(delegation_);
            return this;
        }

        public Builder priority_(java.math.BigDecimal priority_) {
            instance.setPriority_(priority_);
            return this;
        }

        public Builder createTime_(String createTime_) {
            instance.setCreateTime_(createTime_);
            return this;
        }

        public Builder dueDate_(String dueDate_) {
            instance.setDueDate_(dueDate_);
            return this;
        }

        public Builder followUpDate_(String followUpDate_) {
            instance.setFollowUpDate_(followUpDate_);
            return this;
        }

        public Builder suspensionState_(java.math.BigDecimal suspensionState_) {
            instance.setSuspensionState_(suspensionState_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder fgActRuIdentitylinkList(List<FgActRuIdentitylink> fgActRuIdentitylinkList) {
            instance.setFgActRuIdentitylinkList(fgActRuIdentitylinkList);
            return this;
        }

        public FgActRuTask build() {
            return instance;
        }
    }
}
