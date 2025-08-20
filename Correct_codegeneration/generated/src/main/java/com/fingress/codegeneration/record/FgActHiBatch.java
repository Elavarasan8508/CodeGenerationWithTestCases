package com.bsit.codegeneration.record;

public record FgActHiBatch(String ID_, String type_, Long totalJobs_, Long jobsPerSeed_, Long invocationsPerJob_, String seedJobDefID_, String monitorJobDefID_, String batchJobDefID_, String tenantID_, String startTime_, String endTime_, String createUserID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String type_;

        private Long totalJobs_;

        private Long jobsPerSeed_;

        private Long invocationsPerJob_;

        private String seedJobDefID_;

        private String monitorJobDefID_;

        private String batchJobDefID_;

        private String tenantID_;

        private String startTime_;

        private String endTime_;

        private String createUserID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder totalJobs_(Long totalJobs_) {
            this.totalJobs_ = totalJobs_;
            return this;
        }

        public Builder jobsPerSeed_(Long jobsPerSeed_) {
            this.jobsPerSeed_ = jobsPerSeed_;
            return this;
        }

        public Builder invocationsPerJob_(Long invocationsPerJob_) {
            this.invocationsPerJob_ = invocationsPerJob_;
            return this;
        }

        public Builder seedJobDefID_(String seedJobDefID_) {
            this.seedJobDefID_ = seedJobDefID_;
            return this;
        }

        public Builder monitorJobDefID_(String monitorJobDefID_) {
            this.monitorJobDefID_ = monitorJobDefID_;
            return this;
        }

        public Builder batchJobDefID_(String batchJobDefID_) {
            this.batchJobDefID_ = batchJobDefID_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder startTime_(String startTime_) {
            this.startTime_ = startTime_;
            return this;
        }

        public Builder endTime_(String endTime_) {
            this.endTime_ = endTime_;
            return this;
        }

        public Builder createUserID_(String createUserID_) {
            this.createUserID_ = createUserID_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public FgActHiBatch build() {
            return new FgActHiBatch(ID_, type_, totalJobs_, jobsPerSeed_, invocationsPerJob_, seedJobDefID_, monitorJobDefID_, batchJobDefID_, tenantID_, startTime_, endTime_, createUserID_, removalTime_);
        }
    }
}
