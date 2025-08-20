package com.bsit.codegeneration.record;

public record FgActGeProperty(String name_, String value_, Long rev_) {

    public static class Builder {

        private String name_;

        private String value_;

        private Long rev_;

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder value_(String value_) {
            this.value_ = value_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public FgActGeProperty build() {
            return new FgActGeProperty(name_, value_, rev_);
        }
    }
}
