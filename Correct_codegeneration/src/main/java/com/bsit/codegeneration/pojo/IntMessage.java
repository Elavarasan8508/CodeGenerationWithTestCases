package com.bsit.codegeneration.pojo;

public class IntMessage {

    private Integer messageID;

    private String region;

    private String createdDate;

    private byte[] messageBytes;

    public IntMessage() {
    }

    public IntMessage(Integer messageID, String region, String createdDate, byte[] messageBytes) {
        this.messageID = messageID;
        this.region = region;
        this.createdDate = createdDate;
        this.messageBytes = messageBytes;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public byte[] getMessageBytes() {
        return messageBytes;
    }

    public void setMessageBytes(byte[] messageBytes) {
        this.messageBytes = messageBytes;
    }

    public static class Builder {

        private IntMessage instance = new IntMessage();

        public Builder messageID(Integer messageID) {
            instance.setMessageID(messageID);
            return this;
        }

        public Builder region(String region) {
            instance.setRegion(region);
            return this;
        }

        public Builder createdDate(String createdDate) {
            instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder messageBytes(byte[] messageBytes) {
            instance.setMessageBytes(messageBytes);
            return this;
        }

        public IntMessage build() {
            return instance;
        }
    }
}
