package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class IntChannelMessage {

    private Integer messageID;

    private String groupKey;

    private java.math.BigDecimal createdDate;

    private java.math.BigDecimal messagePriority;

    private java.math.BigDecimal messageSequence;

    private byte[] messageBytes;

    private String region;

    public IntChannelMessage() {
    }

    public IntChannelMessage(Integer messageID, String groupKey, java.math.BigDecimal createdDate, java.math.BigDecimal messagePriority, java.math.BigDecimal messageSequence, byte[] messageBytes, String region) {
        this.messageID = messageID;
        this.groupKey = groupKey;
        this.createdDate = createdDate;
        this.messagePriority = messagePriority;
        this.messageSequence = messageSequence;
        this.messageBytes = messageBytes;
        this.region = region;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public java.math.BigDecimal getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.math.BigDecimal createdDate) {
        this.createdDate = createdDate;
    }

    public java.math.BigDecimal getMessagePriority() {
        return messagePriority;
    }

    public void setMessagePriority(java.math.BigDecimal messagePriority) {
        this.messagePriority = messagePriority;
    }

    public java.math.BigDecimal getMessageSequence() {
        return messageSequence;
    }

    public void setMessageSequence(java.math.BigDecimal messageSequence) {
        this.messageSequence = messageSequence;
    }

    public byte[] getMessageBytes() {
        return messageBytes;
    }

    public void setMessageBytes(byte[] messageBytes) {
        this.messageBytes = messageBytes;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public static class Builder {

        private IntChannelMessage instance = new IntChannelMessage();

        public Builder messageID(Integer messageID) {
            instance.setMessageID(messageID);
            return this;
        }

        public Builder groupKey(String groupKey) {
            instance.setGroupKey(groupKey);
            return this;
        }

        public Builder createdDate(java.math.BigDecimal createdDate) {
            instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder messagePriority(java.math.BigDecimal messagePriority) {
            instance.setMessagePriority(messagePriority);
            return this;
        }

        public Builder messageSequence(java.math.BigDecimal messageSequence) {
            instance.setMessageSequence(messageSequence);
            return this;
        }

        public Builder messageBytes(byte[] messageBytes) {
            instance.setMessageBytes(messageBytes);
            return this;
        }

        public Builder region(String region) {
            instance.setRegion(region);
            return this;
        }

        public IntChannelMessage build() {
            return instance;
        }
    }
}
