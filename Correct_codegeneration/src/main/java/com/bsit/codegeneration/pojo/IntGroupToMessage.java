package com.bsit.codegeneration.pojo;

public class IntGroupToMessage {

    private String groupKey;

    private Integer messageID;

    private String region;

    public IntGroupToMessage() {
    }

    public IntGroupToMessage(String groupKey, Integer messageID, String region) {
        this.groupKey = groupKey;
        this.messageID = messageID;
        this.region = region;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public static class Builder {

        private IntGroupToMessage instance = new IntGroupToMessage();

        public Builder groupKey(String groupKey) {
            instance.setGroupKey(groupKey);
            return this;
        }

        public Builder messageID(Integer messageID) {
            instance.setMessageID(messageID);
            return this;
        }

        public Builder region(String region) {
            instance.setRegion(region);
            return this;
        }

        public IntGroupToMessage build() {
            return instance;
        }
    }
}
