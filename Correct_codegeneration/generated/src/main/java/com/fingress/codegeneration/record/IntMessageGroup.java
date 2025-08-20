package com.bsit.codegeneration.record;

public record IntMessageGroup(String groupKey, String region, Long marked, Long complete, Long lastReleasedSequence, String createdDate, String updatedDate) {

    public static class Builder {

        private String groupKey;

        private String region;

        private Long marked;

        private Long complete;

        private Long lastReleasedSequence;

        private String createdDate;

        private String updatedDate;

        public Builder groupKey(String groupKey) {
            this.groupKey = groupKey;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder marked(Long marked) {
            this.marked = marked;
            return this;
        }

        public Builder complete(Long complete) {
            this.complete = complete;
            return this;
        }

        public Builder lastReleasedSequence(Long lastReleasedSequence) {
            this.lastReleasedSequence = lastReleasedSequence;
            return this;
        }

        public Builder createdDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder updatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public IntMessageGroup build() {
            return new IntMessageGroup(groupKey, region, marked, complete, lastReleasedSequence, createdDate, updatedDate);
        }
    }
}
