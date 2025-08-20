package com.bsit.codegeneration.record;

public record FgActRuFilter(String ID_, Long rev_, String resourceType_, String name_, String owner_, String query_, String properties_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String resourceType_;

        private String name_;

        private String owner_;

        private String query_;

        private String properties_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder resourceType_(String resourceType_) {
            this.resourceType_ = resourceType_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder owner_(String owner_) {
            this.owner_ = owner_;
            return this;
        }

        public Builder query_(String query_) {
            this.query_ = query_;
            return this;
        }

        public Builder properties_(String properties_) {
            this.properties_ = properties_;
            return this;
        }

        public FgActRuFilter build() {
            return new FgActRuFilter(ID_, rev_, resourceType_, name_, owner_, query_, properties_);
        }
    }
}
