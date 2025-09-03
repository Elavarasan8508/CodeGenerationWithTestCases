package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActRuCaseExecution {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String caseInstID_;

    private String superCaseExec_;

    private String superExec_;

    private String businessKey_;

    private String parentID_;

    private String caseDefID_;

    private String actID_;

    private java.math.BigDecimal prevState_;

    private java.math.BigDecimal currentState_;

    private Integer required_;

    private String tenantID_;

    private List<FgActRuCaseExecution> fgActRuCaseExecutionList;

    private List<FgActRuCaseSentryPart> fgActRuCaseSentryPartList;

    private List<FgActRuTask> fgActRuTaskList;

    private List<FgActRuVariable> fgActRuVariableList;

    public FgActRuCaseExecution() {
    }

    public FgActRuCaseExecution(String ID_, java.math.BigDecimal rev_, String caseInstID_, String superCaseExec_, String superExec_, String businessKey_, String parentID_, String caseDefID_, String actID_, java.math.BigDecimal prevState_, java.math.BigDecimal currentState_, Integer required_, String tenantID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.caseInstID_ = caseInstID_;
        this.superCaseExec_ = superCaseExec_;
        this.superExec_ = superExec_;
        this.businessKey_ = businessKey_;
        this.parentID_ = parentID_;
        this.caseDefID_ = caseDefID_;
        this.actID_ = actID_;
        this.prevState_ = prevState_;
        this.currentState_ = currentState_;
        this.required_ = required_;
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

    public String getCaseInstID_() {
        return caseInstID_;
    }

    public void setCaseInstID_(String caseInstID_) {
        this.caseInstID_ = caseInstID_;
    }

    public String getSuperCaseExec_() {
        return superCaseExec_;
    }

    public void setSuperCaseExec_(String superCaseExec_) {
        this.superCaseExec_ = superCaseExec_;
    }

    public String getSuperExec_() {
        return superExec_;
    }

    public void setSuperExec_(String superExec_) {
        this.superExec_ = superExec_;
    }

    public String getBusinessKey_() {
        return businessKey_;
    }

    public void setBusinessKey_(String businessKey_) {
        this.businessKey_ = businessKey_;
    }

    public String getParentID_() {
        return parentID_;
    }

    public void setParentID_(String parentID_) {
        this.parentID_ = parentID_;
    }

    public String getCaseDefID_() {
        return caseDefID_;
    }

    public void setCaseDefID_(String caseDefID_) {
        this.caseDefID_ = caseDefID_;
    }

    public String getActID_() {
        return actID_;
    }

    public void setActID_(String actID_) {
        this.actID_ = actID_;
    }

    public java.math.BigDecimal getPrevState_() {
        return prevState_;
    }

    public void setPrevState_(java.math.BigDecimal prevState_) {
        this.prevState_ = prevState_;
    }

    public java.math.BigDecimal getCurrentState_() {
        return currentState_;
    }

    public void setCurrentState_(java.math.BigDecimal currentState_) {
        this.currentState_ = currentState_;
    }

    public Integer getRequired_() {
        return required_;
    }

    public void setRequired_(Integer required_) {
        this.required_ = required_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public List<FgActRuCaseExecution> getFgActRuCaseExecutionList() {
        return fgActRuCaseExecutionList;
    }

    public void setFgActRuCaseExecutionList(List<FgActRuCaseExecution> fgActRuCaseExecutionList) {
        this.fgActRuCaseExecutionList = fgActRuCaseExecutionList;
    }

    public List<FgActRuCaseSentryPart> getFgActRuCaseSentryPartList() {
        return fgActRuCaseSentryPartList;
    }

    public void setFgActRuCaseSentryPartList(List<FgActRuCaseSentryPart> fgActRuCaseSentryPartList) {
        this.fgActRuCaseSentryPartList = fgActRuCaseSentryPartList;
    }

    public List<FgActRuTask> getFgActRuTaskList() {
        return fgActRuTaskList;
    }

    public void setFgActRuTaskList(List<FgActRuTask> fgActRuTaskList) {
        this.fgActRuTaskList = fgActRuTaskList;
    }

    public List<FgActRuVariable> getFgActRuVariableList() {
        return fgActRuVariableList;
    }

    public void setFgActRuVariableList(List<FgActRuVariable> fgActRuVariableList) {
        this.fgActRuVariableList = fgActRuVariableList;
    }

    public static class Builder {

        private FgActRuCaseExecution instance = new FgActRuCaseExecution();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder caseInstID_(String caseInstID_) {
            instance.setCaseInstID_(caseInstID_);
            return this;
        }

        public Builder superCaseExec_(String superCaseExec_) {
            instance.setSuperCaseExec_(superCaseExec_);
            return this;
        }

        public Builder superExec_(String superExec_) {
            instance.setSuperExec_(superExec_);
            return this;
        }

        public Builder businessKey_(String businessKey_) {
            instance.setBusinessKey_(businessKey_);
            return this;
        }

        public Builder parentID_(String parentID_) {
            instance.setParentID_(parentID_);
            return this;
        }

        public Builder caseDefID_(String caseDefID_) {
            instance.setCaseDefID_(caseDefID_);
            return this;
        }

        public Builder actID_(String actID_) {
            instance.setActID_(actID_);
            return this;
        }

        public Builder prevState_(java.math.BigDecimal prevState_) {
            instance.setPrevState_(prevState_);
            return this;
        }

        public Builder currentState_(java.math.BigDecimal currentState_) {
            instance.setCurrentState_(currentState_);
            return this;
        }

        public Builder required_(Integer required_) {
            instance.setRequired_(required_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder fgActRuCaseExecutionList(List<FgActRuCaseExecution> fgActRuCaseExecutionList) {
            instance.setFgActRuCaseExecutionList(fgActRuCaseExecutionList);
            return this;
        }

        public Builder fgActRuCaseSentryPartList(List<FgActRuCaseSentryPart> fgActRuCaseSentryPartList) {
            instance.setFgActRuCaseSentryPartList(fgActRuCaseSentryPartList);
            return this;
        }

        public Builder fgActRuTaskList(List<FgActRuTask> fgActRuTaskList) {
            instance.setFgActRuTaskList(fgActRuTaskList);
            return this;
        }

        public Builder fgActRuVariableList(List<FgActRuVariable> fgActRuVariableList) {
            instance.setFgActRuVariableList(fgActRuVariableList);
            return this;
        }

        public FgActRuCaseExecution build() {
            return instance;
        }
    }
}
