package com.bsit.codegeneration.record;

public record FgActIDInfo(String ID_, Long rev_, String userID_, String type_, String key_, String value_, String password_, String parentID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String userID_;

        private String type_;

        private String key_;

        private String value_;

        private String password_;

        private String parentID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder key_(String key_) {
            this.key_ = key_;
            return this;
        }

        public Builder value_(String value_) {
            this.value_ = value_;
            return this;
        }

        public Builder password_(String password_) {
            this.password_ = password_;
            return this;
        }

        public Builder parentID_(String parentID_) {
            this.parentID_ = parentID_;
            return this;
        }

        public FgActIDInfo build() {
            return new FgActIDInfo(ID_, rev_, userID_, type_, key_, value_, password_, parentID_);
        }
    }
}
