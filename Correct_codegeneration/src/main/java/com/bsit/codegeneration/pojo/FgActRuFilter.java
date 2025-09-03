package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActRuFilter {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String resourceType_;

    private String name_;

    private String owner_;

    private String query_;

    private String properties_;

    public FgActRuFilter() {
    }

    public FgActRuFilter(String ID_, java.math.BigDecimal rev_, String resourceType_, String name_, String owner_, String query_, String properties_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.resourceType_ = resourceType_;
        this.name_ = name_;
        this.owner_ = owner_;
        this.query_ = query_;
        this.properties_ = properties_;
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

    public String getResourceType_() {
        return resourceType_;
    }

    public void setResourceType_(String resourceType_) {
        this.resourceType_ = resourceType_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getOwner_() {
        return owner_;
    }

    public void setOwner_(String owner_) {
        this.owner_ = owner_;
    }

    public String getQuery_() {
        return query_;
    }

    public void setQuery_(String query_) {
        this.query_ = query_;
    }

    public String getProperties_() {
        return properties_;
    }

    public void setProperties_(String properties_) {
        this.properties_ = properties_;
    }

    public static class Builder {

        private FgActRuFilter instance = new FgActRuFilter();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder resourceType_(String resourceType_) {
            instance.setResourceType_(resourceType_);
            return this;
        }

        public Builder name_(String name_) {
            instance.setName_(name_);
            return this;
        }

        public Builder owner_(String owner_) {
            instance.setOwner_(owner_);
            return this;
        }

        public Builder query_(String query_) {
            instance.setQuery_(query_);
            return this;
        }

        public Builder properties_(String properties_) {
            instance.setProperties_(properties_);
            return this;
        }

        public FgActRuFilter build() {
            return instance;
        }
    }
}
