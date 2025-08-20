package com.bsit.codegeneration.record;

public record JobLog(String logTime, String message) {

    public static class Builder {

        private String logTime;

        private String message;

        public Builder logTime(String logTime) {
            this.logTime = logTime;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public JobLog build() {
            return new JobLog(logTime, message);
        }
    }
}
