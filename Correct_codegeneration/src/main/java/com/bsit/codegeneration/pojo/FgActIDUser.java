package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActIDUser {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String first_;

    private String last_;

    private String email_;

    private String pwd_;

    private String salt_;

    private String pictureID_;

    private String lockExpTime_;

    private java.math.BigDecimal attempts_;

    private List<FgActIDMembership> fgActIDMembershipList;

    private List<FgActIDTenantMember> fgActIDTenantMemberList;

    public FgActIDUser() {
    }

    public FgActIDUser(String ID_, java.math.BigDecimal rev_, String first_, String last_, String email_, String pwd_, String salt_, String pictureID_, String lockExpTime_, java.math.BigDecimal attempts_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.first_ = first_;
        this.last_ = last_;
        this.email_ = email_;
        this.pwd_ = pwd_;
        this.salt_ = salt_;
        this.pictureID_ = pictureID_;
        this.lockExpTime_ = lockExpTime_;
        this.attempts_ = attempts_;
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

    public String getFirst_() {
        return first_;
    }

    public void setFirst_(String first_) {
        this.first_ = first_;
    }

    public String getLast_() {
        return last_;
    }

    public void setLast_(String last_) {
        this.last_ = last_;
    }

    public String getEmail_() {
        return email_;
    }

    public void setEmail_(String email_) {
        this.email_ = email_;
    }

    public String getPwd_() {
        return pwd_;
    }

    public void setPwd_(String pwd_) {
        this.pwd_ = pwd_;
    }

    public String getSalt_() {
        return salt_;
    }

    public void setSalt_(String salt_) {
        this.salt_ = salt_;
    }

    public String getPictureID_() {
        return pictureID_;
    }

    public void setPictureID_(String pictureID_) {
        this.pictureID_ = pictureID_;
    }

    public String getLockExpTime_() {
        return lockExpTime_;
    }

    public void setLockExpTime_(String lockExpTime_) {
        this.lockExpTime_ = lockExpTime_;
    }

    public java.math.BigDecimal getAttempts_() {
        return attempts_;
    }

    public void setAttempts_(java.math.BigDecimal attempts_) {
        this.attempts_ = attempts_;
    }

    public List<FgActIDMembership> getFgActIDMembershipList() {
        return fgActIDMembershipList;
    }

    public void setFgActIDMembershipList(List<FgActIDMembership> fgActIDMembershipList) {
        this.fgActIDMembershipList = fgActIDMembershipList;
    }

    public List<FgActIDTenantMember> getFgActIDTenantMemberList() {
        return fgActIDTenantMemberList;
    }

    public void setFgActIDTenantMemberList(List<FgActIDTenantMember> fgActIDTenantMemberList) {
        this.fgActIDTenantMemberList = fgActIDTenantMemberList;
    }

    public static class Builder {

        private FgActIDUser instance = new FgActIDUser();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder first_(String first_) {
            instance.setFirst_(first_);
            return this;
        }

        public Builder last_(String last_) {
            instance.setLast_(last_);
            return this;
        }

        public Builder email_(String email_) {
            instance.setEmail_(email_);
            return this;
        }

        public Builder pwd_(String pwd_) {
            instance.setPwd_(pwd_);
            return this;
        }

        public Builder salt_(String salt_) {
            instance.setSalt_(salt_);
            return this;
        }

        public Builder pictureID_(String pictureID_) {
            instance.setPictureID_(pictureID_);
            return this;
        }

        public Builder lockExpTime_(String lockExpTime_) {
            instance.setLockExpTime_(lockExpTime_);
            return this;
        }

        public Builder attempts_(java.math.BigDecimal attempts_) {
            instance.setAttempts_(attempts_);
            return this;
        }

        public Builder fgActIDMembershipList(List<FgActIDMembership> fgActIDMembershipList) {
            instance.setFgActIDMembershipList(fgActIDMembershipList);
            return this;
        }

        public Builder fgActIDTenantMemberList(List<FgActIDTenantMember> fgActIDTenantMemberList) {
            instance.setFgActIDTenantMemberList(fgActIDTenantMemberList);
            return this;
        }

        public FgActIDUser build() {
            return instance;
        }
    }
}
