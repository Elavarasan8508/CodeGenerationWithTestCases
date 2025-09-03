package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class IntMessageGroup {

    private String groupKey;

    private String region;

    private java.math.BigDecimal marked;

    private java.math.BigDecimal complete;

    private java.math.BigDecimal lastReleasedSequence;

    private String createdDate;

    private String updatedDate;

    public IntMessageGroup() {
    }

    public IntMessageGroup(String groupKey, String region, java.math.BigDecimal marked, java.math.BigDecimal complete, java.math.BigDecimal lastReleasedSequence, String createdDate, String updatedDate) {
        this.groupKey = groupKey;
        this.region = region;
        this.marked = marked;
        this.complete = complete;
        this.lastReleasedSequence = lastReleasedSequence;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public java.math.BigDecimal getMarked() {
        return marked;
    }

    public void setMarked(java.math.BigDecimal marked) {
        this.marked = marked;
    }

    public java.math.BigDecimal getComplete() {
        return complete;
    }

    public void setComplete(java.math.BigDecimal complete) {
        this.complete = complete;
    }

    public java.math.BigDecimal getLastReleasedSequence() {
        return lastReleasedSequence;
    }

    public void setLastReleasedSequence(java.math.BigDecimal lastReleasedSequence) {
        this.lastReleasedSequence = lastReleasedSequence;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public static class Builder {

        private IntMessageGroup instance = new IntMessageGroup();

        public Builder groupKey(String groupKey) {
            instance.setGroupKey(groupKey);
            return this;
        }

        public Builder region(String region) {
            instance.setRegion(region);
            return this;
        }

        public Builder marked(java.math.BigDecimal marked) {
            instance.setMarked(marked);
            return this;
        }

        public Builder complete(java.math.BigDecimal complete) {
            instance.setComplete(complete);
            return this;
        }

        public Builder lastReleasedSequence(java.math.BigDecimal lastReleasedSequence) {
            instance.setLastReleasedSequence(lastReleasedSequence);
            return this;
        }

        public Builder createdDate(String createdDate) {
            instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder updatedDate(String updatedDate) {
            instance.setUpdatedDate(updatedDate);
            return this;
        }

        public IntMessageGroup build() {
            return instance;
        }
    }
}
