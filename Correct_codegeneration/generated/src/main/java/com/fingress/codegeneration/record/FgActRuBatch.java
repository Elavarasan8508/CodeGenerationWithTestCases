package com.bsit.codegeneration.record;

public record FgActRuBatch(String ID_, Long rev_, String type_, Long totalJobs_, Long jobsCreated_, Long jobsPerSeed_, Long invocationsPerJob_, String seedJobDefID_, String batchJobDefID_, String monitorJobDefID_, Long suspensionState_, String configuration_, String tenantID_, String createUserID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String type_;

        private Long totalJobs_;

        private Long jobsCreated_;

        private Long jobsPerSeed_;

        private Long invocationsPerJob_;

        private String seedJobDefID_;

        private String batchJobDefID_;

        private String monitorJobDefID_;

        private Long suspensionState_;

        private String configuration_;

        private String tenantID_;

        private String createUserID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
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

        public Builder jobsCreated_(Long jobsCreated_) {
            this.jobsCreated_ = jobsCreated_;
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

        public Builder batchJobDefID_(String batchJobDefID_) {
            this.batchJobDefID_ = batchJobDefID_;
            return this;
        }

        public Builder monitorJobDefID_(String monitorJobDefID_) {
            this.monitorJobDefID_ = monitorJobDefID_;
            return this;
        }

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder configuration_(String configuration_) {
            this.configuration_ = configuration_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder createUserID_(String createUserID_) {
            this.createUserID_ = createUserID_;
            return this;
        }

        public FgActRuBatch build() {
            return new FgActRuBatch(ID_, rev_, type_, totalJobs_, jobsCreated_, jobsPerSeed_, invocationsPerJob_, seedJobDefID_, batchJobDefID_, monitorJobDefID_, suspensionState_, configuration_, tenantID_, createUserID_);
        }
    }
}
