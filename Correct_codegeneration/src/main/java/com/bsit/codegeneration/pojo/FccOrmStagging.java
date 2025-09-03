package com.bsit.codegeneration.pojo;

public class FccOrmStagging {

    private Integer seqID;

    private String referenceid;

    private Integer uploadRefID;

    private Integer uploadTnxID;

    private String request;

    private String response;

    private String errorMsg;

    private String insertedOn;

    private String tnxStatCode;

    private String prodStatCode;

    public FccOrmStagging() {
    }

    public FccOrmStagging(Integer seqID, String referenceid, Integer uploadRefID, Integer uploadTnxID, String request, String response, String errorMsg, String insertedOn, String tnxStatCode, String prodStatCode) {
        this.seqID = seqID;
        this.referenceid = referenceid;
        this.uploadRefID = uploadRefID;
        this.uploadTnxID = uploadTnxID;
        this.request = request;
        this.response = response;
        this.errorMsg = errorMsg;
        this.insertedOn = insertedOn;
        this.tnxStatCode = tnxStatCode;
        this.prodStatCode = prodStatCode;
    }

    public Integer getSeqID() {
        return seqID;
    }

    public void setSeqID(Integer seqID) {
        this.seqID = seqID;
    }

    public String getReferenceid() {
        return referenceid;
    }

    public void setReferenceid(String referenceid) {
        this.referenceid = referenceid;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Integer getUploadTnxID() {
        return uploadTnxID;
    }

    public void setUploadTnxID(Integer uploadTnxID) {
        this.uploadTnxID = uploadTnxID;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getInsertedOn() {
        return insertedOn;
    }

    public void setInsertedOn(String insertedOn) {
        this.insertedOn = insertedOn;
    }

    public String getTnxStatCode() {
        return tnxStatCode;
    }

    public void setTnxStatCode(String tnxStatCode) {
        this.tnxStatCode = tnxStatCode;
    }

    public String getProdStatCode() {
        return prodStatCode;
    }

    public void setProdStatCode(String prodStatCode) {
        this.prodStatCode = prodStatCode;
    }

    public static class Builder {

        private FccOrmStagging instance = new FccOrmStagging();

        public Builder seqID(Integer seqID) {
            instance.setSeqID(seqID);
            return this;
        }

        public Builder referenceid(String referenceid) {
            instance.setReferenceid(referenceid);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder uploadTnxID(Integer uploadTnxID) {
            instance.setUploadTnxID(uploadTnxID);
            return this;
        }

        public Builder request(String request) {
            instance.setRequest(request);
            return this;
        }

        public Builder response(String response) {
            instance.setResponse(response);
            return this;
        }

        public Builder errorMsg(String errorMsg) {
            instance.setErrorMsg(errorMsg);
            return this;
        }

        public Builder insertedOn(String insertedOn) {
            instance.setInsertedOn(insertedOn);
            return this;
        }

        public Builder tnxStatCode(String tnxStatCode) {
            instance.setTnxStatCode(tnxStatCode);
            return this;
        }

        public Builder prodStatCode(String prodStatCode) {
            instance.setProdStatCode(prodStatCode);
            return this;
        }

        public FccOrmStagging build() {
            return instance;
        }
    }
}
