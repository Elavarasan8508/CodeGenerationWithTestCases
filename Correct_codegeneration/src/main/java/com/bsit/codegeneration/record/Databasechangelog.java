package com.bsit.codegeneration.record;

import java.util.List;

public record Databasechangelog(Integer ID, String author, String filename, String dateexecuted, Long orderexecuted, String exectype, String md5sum, String description, String comments, String tag, String liquibase, String contexts, String labels, Integer deploymentID) {

    public static class Builder {

        private Integer ID;

        private String author;

        private String filename;

        private String dateexecuted;

        private Long orderexecuted;

        private String exectype;

        private String md5sum;

        private String description;

        private String comments;

        private String tag;

        private String liquibase;

        private String contexts;

        private String labels;

        private Integer deploymentID;

        public Builder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        public Builder dateexecuted(String dateexecuted) {
            this.dateexecuted = dateexecuted;
            return this;
        }

        public Builder orderexecuted(Long orderexecuted) {
            this.orderexecuted = orderexecuted;
            return this;
        }

        public Builder exectype(String exectype) {
            this.exectype = exectype;
            return this;
        }

        public Builder md5sum(String md5sum) {
            this.md5sum = md5sum;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder liquibase(String liquibase) {
            this.liquibase = liquibase;
            return this;
        }

        public Builder contexts(String contexts) {
            this.contexts = contexts;
            return this;
        }

        public Builder labels(String labels) {
            this.labels = labels;
            return this;
        }

        public Builder deploymentID(Integer deploymentID) {
            this.deploymentID = deploymentID;
            return this;
        }

        public Databasechangelog build() {
            return new Databasechangelog(ID, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deploymentID);
        }
    }
}
