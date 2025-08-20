package com.bsit.codegeneration.record;

public record FccOrmStagging(Long seqID, String referenceid, String uploadRefID, String uploadTnxID, String request, String response, String errorMsg, String insertedOn, String tnxStatCode, String prodStatCode) {

    public static class Builder {

        private Long seqID;

        private String referenceid;

        private String uploadRefID;

        private String uploadTnxID;

        private String request;

        private String response;

        private String errorMsg;

        private String insertedOn;

        private String tnxStatCode;

        private String prodStatCode;

        public Builder seqID(Long seqID) {
            this.seqID = seqID;
            return this;
        }

        public Builder referenceid(String referenceid) {
            this.referenceid = referenceid;
            return this;
        }

        public Builder uploadRefID(String uploadRefID) {
            this.uploadRefID = uploadRefID;
            return this;
        }

        public Builder uploadTnxID(String uploadTnxID) {
            this.uploadTnxID = uploadTnxID;
            return this;
        }

        public Builder request(String request) {
            this.request = request;
            return this;
        }

        public Builder response(String response) {
            this.response = response;
            return this;
        }

        public Builder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder insertedOn(String insertedOn) {
            this.insertedOn = insertedOn;
            return this;
        }

        public Builder tnxStatCode(String tnxStatCode) {
            this.tnxStatCode = tnxStatCode;
            return this;
        }

        public Builder prodStatCode(String prodStatCode) {
            this.prodStatCode = prodStatCode;
            return this;
        }

        public FccOrmStagging build() {
            return new FccOrmStagging(seqID, referenceid, uploadRefID, uploadTnxID, request, response, errorMsg, insertedOn, tnxStatCode, prodStatCode);
        }
    }
}
