package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiActinst {

    private String ID_;

    private String parentActInstID_;

    private String procDefKey_;

    private String procDefID_;

    private String procInstID_;

    private String executionID_;

    private String actID_;

    private String taskID_;

    private String callProcInstID_;

    private String callCaseInstID_;

    private String actName_;

    private String actType_;

    private String assignee_;

    private String startTime_;

    private String endTime_;

    private Integer duration_;

    private java.math.BigDecimal actInstState_;

    private java.math.BigDecimal sequenceCounter_;

    private String tenantID_;

    private String rootProcInstID_;

    private String removalTime_;

    public FgActHiActinst() {
    }

    public FgActHiActinst(String ID_, String parentActInstID_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String actID_, String taskID_, String callProcInstID_, String callCaseInstID_, String actName_, String actType_, String assignee_, String startTime_, String endTime_, Integer duration_, java.math.BigDecimal actInstState_, java.math.BigDecimal sequenceCounter_, String tenantID_, String rootProcInstID_, String removalTime_) {
        this.ID_ = ID_;
        this.parentActInstID_ = parentActInstID_;
        this.procDefKey_ = procDefKey_;
        this.procDefID_ = procDefID_;
        this.procInstID_ = procInstID_;
        this.executionID_ = executionID_;
        this.actID_ = actID_;
        this.taskID_ = taskID_;
        this.callProcInstID_ = callProcInstID_;
        this.callCaseInstID_ = callCaseInstID_;
        this.actName_ = actName_;
        this.actType_ = actType_;
        this.assignee_ = assignee_;
        this.startTime_ = startTime_;
        this.endTime_ = endTime_;
        this.duration_ = duration_;
        this.actInstState_ = actInstState_;
        this.sequenceCounter_ = sequenceCounter_;
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

    public String getParentActInstID_() {
        return parentActInstID_;
    }

    public void setParentActInstID_(String parentActInstID_) {
        this.parentActInstID_ = parentActInstID_;
    }

    public String getProcDefKey_() {
        return procDefKey_;
    }

    public void setProcDefKey_(String procDefKey_) {
        this.procDefKey_ = procDefKey_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getExecutionID_() {
        return executionID_;
    }

    public void setExecutionID_(String executionID_) {
        this.executionID_ = executionID_;
    }

    public String getActID_() {
        return actID_;
    }

    public void setActID_(String actID_) {
        this.actID_ = actID_;
    }

    public String getTaskID_() {
        return taskID_;
    }

    public void setTaskID_(String taskID_) {
        this.taskID_ = taskID_;
    }

    public String getCallProcInstID_() {
        return callProcInstID_;
    }

    public void setCallProcInstID_(String callProcInstID_) {
        this.callProcInstID_ = callProcInstID_;
    }

    public String getCallCaseInstID_() {
        return callCaseInstID_;
    }

    public void setCallCaseInstID_(String callCaseInstID_) {
        this.callCaseInstID_ = callCaseInstID_;
    }

    public String getActName_() {
        return actName_;
    }

    public void setActName_(String actName_) {
        this.actName_ = actName_;
    }

    public String getActType_() {
        return actType_;
    }

    public void setActType_(String actType_) {
        this.actType_ = actType_;
    }

    public String getAssignee_() {
        return assignee_;
    }

    public void setAssignee_(String assignee_) {
        this.assignee_ = assignee_;
    }

    public String getStartTime_() {
        return startTime_;
    }

    public void setStartTime_(String startTime_) {
        this.startTime_ = startTime_;
    }

    public String getEndTime_() {
        return endTime_;
    }

    public void setEndTime_(String endTime_) {
        this.endTime_ = endTime_;
    }

    public Integer getDuration_() {
        return duration_;
    }

    public void setDuration_(Integer duration_) {
        this.duration_ = duration_;
    }

    public java.math.BigDecimal getActInstState_() {
        return actInstState_;
    }

    public void setActInstState_(java.math.BigDecimal actInstState_) {
        this.actInstState_ = actInstState_;
    }

    public java.math.BigDecimal getSequenceCounter_() {
        return sequenceCounter_;
    }

    public void setSequenceCounter_(java.math.BigDecimal sequenceCounter_) {
        this.sequenceCounter_ = sequenceCounter_;
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

        private FgActHiActinst instance = new FgActHiActinst();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder parentActInstID_(String parentActInstID_) {
            instance.setParentActInstID_(parentActInstID_);
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            instance.setProcDefKey_(procDefKey_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder executionID_(String executionID_) {
            instance.setExecutionID_(executionID_);
            return this;
        }

        public Builder actID_(String actID_) {
            instance.setActID_(actID_);
            return this;
        }

        public Builder taskID_(String taskID_) {
            instance.setTaskID_(taskID_);
            return this;
        }

        public Builder callProcInstID_(String callProcInstID_) {
            instance.setCallProcInstID_(callProcInstID_);
            return this;
        }

        public Builder callCaseInstID_(String callCaseInstID_) {
            instance.setCallCaseInstID_(callCaseInstID_);
            return this;
        }

        public Builder actName_(String actName_) {
            instance.setActName_(actName_);
            return this;
        }

        public Builder actType_(String actType_) {
            instance.setActType_(actType_);
            return this;
        }

        public Builder assignee_(String assignee_) {
            instance.setAssignee_(assignee_);
            return this;
        }

        public Builder startTime_(String startTime_) {
            instance.setStartTime_(startTime_);
            return this;
        }

        public Builder endTime_(String endTime_) {
            instance.setEndTime_(endTime_);
            return this;
        }

        public Builder duration_(Integer duration_) {
            instance.setDuration_(duration_);
            return this;
        }

        public Builder actInstState_(java.math.BigDecimal actInstState_) {
            instance.setActInstState_(actInstState_);
            return this;
        }

        public Builder sequenceCounter_(java.math.BigDecimal sequenceCounter_) {
            instance.setSequenceCounter_(sequenceCounter_);
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

        public FgActHiActinst build() {
            return instance;
        }
    }
}
