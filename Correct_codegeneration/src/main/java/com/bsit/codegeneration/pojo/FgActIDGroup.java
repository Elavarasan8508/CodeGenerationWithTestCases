package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActIDGroup {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String name_;

    private String type_;

    private List<FgActIDMembership> fgActIDMembershipList;

    private List<FgActIDTenantMember> fgActIDTenantMemberList;

    public FgActIDGroup() {
    }

    public FgActIDGroup(String ID_, java.math.BigDecimal rev_, String name_, String type_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.name_ = name_;
        this.type_ = type_;
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

    public String getType_() {
        return type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
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

        private FgActIDGroup instance = new FgActIDGroup();

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

        public Builder type_(String type_) {
            instance.setType_(type_);
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

        public FgActIDGroup build() {
            return instance;
        }
    }
}
