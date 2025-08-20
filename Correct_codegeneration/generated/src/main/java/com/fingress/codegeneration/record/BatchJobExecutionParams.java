package com.bsit.codegeneration.record;

public record BatchJobExecutionParams(Long jobExecutionID, String parameterName, String parameterType, String parameterValue, String identifying, Long doubleVal, Long longVal, String dateVal, String keyName, String stringVal, String typeCd) {

    public static class Builder {

        private Long jobExecutionID;

        private String parameterName;

        private String parameterType;

        private String parameterValue;

        private String identifying;

        private Long doubleVal;

        private Long longVal;

        private String dateVal;

        private String keyName;

        private String stringVal;

        private String typeCd;

        public Builder jobExecutionID(Long jobExecutionID) {
            this.jobExecutionID = jobExecutionID;
            return this;
        }

        public Builder parameterName(String parameterName) {
            this.parameterName = parameterName;
            return this;
        }

        public Builder parameterType(String parameterType) {
            this.parameterType = parameterType;
            return this;
        }

        public Builder parameterValue(String parameterValue) {
            this.parameterValue = parameterValue;
            return this;
        }

        public Builder identifying(String identifying) {
            this.identifying = identifying;
            return this;
        }

        public Builder doubleVal(Long doubleVal) {
            this.doubleVal = doubleVal;
            return this;
        }

        public Builder longVal(Long longVal) {
            this.longVal = longVal;
            return this;
        }

        public Builder dateVal(String dateVal) {
            this.dateVal = dateVal;
            return this;
        }

        public Builder keyName(String keyName) {
            this.keyName = keyName;
            return this;
        }

        public Builder stringVal(String stringVal) {
            this.stringVal = stringVal;
            return this;
        }

        public Builder typeCd(String typeCd) {
            this.typeCd = typeCd;
            return this;
        }

        public BatchJobExecutionParams build() {
            return new BatchJobExecutionParams(jobExecutionID, parameterName, parameterType, parameterValue, identifying, doubleVal, longVal, dateVal, keyName, stringVal, typeCd);
        }
    }
}
