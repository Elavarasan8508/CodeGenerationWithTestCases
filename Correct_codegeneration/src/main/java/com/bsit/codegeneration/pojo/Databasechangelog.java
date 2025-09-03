package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class Databasechangelog {

    private Integer ID;

    private String author;

    private String filename;

    private String dateexecuted;

    private java.math.BigDecimal orderexecuted;

    private String exectype;

    private String md5sum;

    private String description;

    private String comments;

    private String tag;

    private String liquibase;

    private String contexts;

    private String labels;

    private Integer deploymentID;

    public Databasechangelog() {
    }

    public Databasechangelog(Integer ID, String author, String filename, String dateexecuted, java.math.BigDecimal orderexecuted, String exectype, String md5sum, String description, String comments, String tag, String liquibase, String contexts, String labels, Integer deploymentID) {
        this.ID = ID;
        this.author = author;
        this.filename = filename;
        this.dateexecuted = dateexecuted;
        this.orderexecuted = orderexecuted;
        this.exectype = exectype;
        this.md5sum = md5sum;
        this.description = description;
        this.comments = comments;
        this.tag = tag;
        this.liquibase = liquibase;
        this.contexts = contexts;
        this.labels = labels;
        this.deploymentID = deploymentID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDateexecuted() {
        return dateexecuted;
    }

    public void setDateexecuted(String dateexecuted) {
        this.dateexecuted = dateexecuted;
    }

    public java.math.BigDecimal getOrderexecuted() {
        return orderexecuted;
    }

    public void setOrderexecuted(java.math.BigDecimal orderexecuted) {
        this.orderexecuted = orderexecuted;
    }

    public String getExectype() {
        return exectype;
    }

    public void setExectype(String exectype) {
        this.exectype = exectype;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLiquibase() {
        return liquibase;
    }

    public void setLiquibase(String liquibase) {
        this.liquibase = liquibase;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Integer getDeploymentID() {
        return deploymentID;
    }

    public void setDeploymentID(Integer deploymentID) {
        this.deploymentID = deploymentID;
    }

    public static class Builder {

        private Databasechangelog instance = new Databasechangelog();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder author(String author) {
            instance.setAuthor(author);
            return this;
        }

        public Builder filename(String filename) {
            instance.setFilename(filename);
            return this;
        }

        public Builder dateexecuted(String dateexecuted) {
            instance.setDateexecuted(dateexecuted);
            return this;
        }

        public Builder orderexecuted(java.math.BigDecimal orderexecuted) {
            instance.setOrderexecuted(orderexecuted);
            return this;
        }

        public Builder exectype(String exectype) {
            instance.setExectype(exectype);
            return this;
        }

        public Builder md5sum(String md5sum) {
            instance.setMd5sum(md5sum);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder comments(String comments) {
            instance.setComments(comments);
            return this;
        }

        public Builder tag(String tag) {
            instance.setTag(tag);
            return this;
        }

        public Builder liquibase(String liquibase) {
            instance.setLiquibase(liquibase);
            return this;
        }

        public Builder contexts(String contexts) {
            instance.setContexts(contexts);
            return this;
        }

        public Builder labels(String labels) {
            instance.setLabels(labels);
            return this;
        }

        public Builder deploymentID(Integer deploymentID) {
            instance.setDeploymentID(deploymentID);
            return this;
        }

        public Databasechangelog build() {
            return instance;
        }
    }
}
