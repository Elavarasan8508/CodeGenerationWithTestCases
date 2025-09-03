package com.bsit.codegeneration.pojo;

public class JobLog {

    private String logTime;

    private String message;

    public JobLog() {
    }

    public JobLog(String logTime, String message) {
        this.logTime = logTime;
        this.message = message;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder {

        private JobLog instance = new JobLog();

        public Builder logTime(String logTime) {
            instance.setLogTime(logTime);
            return this;
        }

        public Builder message(String message) {
            instance.setMessage(message);
            return this;
        }

        public JobLog build() {
            return instance;
        }
    }
}
