package com.bsit.codegeneration.record;

public record FgActIDTenant(String ID_, Long rev_, String name_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String name_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public FgActIDTenant build() {
            return new FgActIDTenant(ID_, rev_, name_);
        }
    }
}
