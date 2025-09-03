package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActIDTenant {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String name_;

    private List<FgActIDTenantMember> fgActIDTenantMemberList;

    public FgActIDTenant() {
    }

    public FgActIDTenant(String ID_, java.math.BigDecimal rev_, String name_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.name_ = name_;
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

    public List<FgActIDTenantMember> getFgActIDTenantMemberList() {
        return fgActIDTenantMemberList;
    }

    public void setFgActIDTenantMemberList(List<FgActIDTenantMember> fgActIDTenantMemberList) {
        this.fgActIDTenantMemberList = fgActIDTenantMemberList;
    }

    public static class Builder {

        private FgActIDTenant instance = new FgActIDTenant();

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

        public Builder fgActIDTenantMemberList(List<FgActIDTenantMember> fgActIDTenantMemberList) {
            instance.setFgActIDTenantMemberList(fgActIDTenantMemberList);
            return this;
        }

        public FgActIDTenant build() {
            return instance;
        }
    }
}
