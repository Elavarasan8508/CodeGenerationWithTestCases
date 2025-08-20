package com.bsit.codegeneration.record;

public record FgActRuMeterLog(String ID_, String name_, String reporter_, Long value_, String timestamp_, Long milliseconds_) {

    public static class Builder {

        private String ID_;

        private String name_;

        private String reporter_;

        private Long value_;

        private String timestamp_;

        private Long milliseconds_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder reporter_(String reporter_) {
            this.reporter_ = reporter_;
            return this;
        }

        public Builder value_(Long value_) {
            this.value_ = value_;
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            this.timestamp_ = timestamp_;
            return this;
        }

        public Builder milliseconds_(Long milliseconds_) {
            this.milliseconds_ = milliseconds_;
            return this;
        }

        public FgActRuMeterLog build() {
            return new FgActRuMeterLog(ID_, name_, reporter_, value_, timestamp_, milliseconds_);
        }
    }
}
