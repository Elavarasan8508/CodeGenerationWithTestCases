package com.bsit.codegeneration.record;

public record FgActGeSchemaLog(String ID_, String timestamp_, String version_) {

    public static class Builder {

        private String ID_;

        private String timestamp_;

        private String version_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            this.timestamp_ = timestamp_;
            return this;
        }

        public Builder version_(String version_) {
            this.version_ = version_;
            return this;
        }

        public FgActGeSchemaLog build() {
            return new FgActGeSchemaLog(ID_, timestamp_, version_);
        }
    }
}
