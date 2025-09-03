package com.bsit.codegeneration.record;

import java.util.List;

public record QrtzBlobTriggers(String schedName, String triggerName, String triggerGroup, String blobData, QrtzTriggers qrtzTriggers) {

    public static class Builder {

        private String schedName;

        private String triggerName;

        private String triggerGroup;

        private String blobData;

        private QrtzTriggers qrtzTriggers;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder triggerName(String triggerName) {
            this.triggerName = triggerName;
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            this.triggerGroup = triggerGroup;
            return this;
        }

        public Builder blobData(String blobData) {
            this.blobData = blobData;
            return this;
        }

        public Builder qrtzTriggers(QrtzTriggers qrtzTriggers) {
            this.qrtzTriggers = qrtzTriggers;
            return this;
        }

        public QrtzBlobTriggers build() {
            return new QrtzBlobTriggers(schedName, triggerName, triggerGroup, blobData, qrtzTriggers);
        }
    }
}
