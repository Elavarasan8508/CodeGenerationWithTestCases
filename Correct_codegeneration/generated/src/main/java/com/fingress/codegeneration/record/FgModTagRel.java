package com.bsit.codegeneration.record;

public record FgModTagRel(Long ID, String tagReferenceNo, String targetEntityTypeCode, String targetEntitySubTypeCode, String targetEntityRefNo, Long targetEntityVersionid, Long createdBy, String createdOn, Long lastUpdatedBy, String lastUpdatedOn, Long lastAuthorisedBy, String lastAuthorisedOn) {

    public static class Builder {

        private Long ID;

        private String tagReferenceNo;

        private String targetEntityTypeCode;

        private String targetEntitySubTypeCode;

        private String targetEntityRefNo;

        private Long targetEntityVersionid;

        private Long createdBy;

        private String createdOn;

        private Long lastUpdatedBy;

        private String lastUpdatedOn;

        private Long lastAuthorisedBy;

        private String lastAuthorisedOn;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder tagReferenceNo(String tagReferenceNo) {
            this.tagReferenceNo = tagReferenceNo;
            return this;
        }

        public Builder targetEntityTypeCode(String targetEntityTypeCode) {
            this.targetEntityTypeCode = targetEntityTypeCode;
            return this;
        }

        public Builder targetEntitySubTypeCode(String targetEntitySubTypeCode) {
            this.targetEntitySubTypeCode = targetEntitySubTypeCode;
            return this;
        }

        public Builder targetEntityRefNo(String targetEntityRefNo) {
            this.targetEntityRefNo = targetEntityRefNo;
            return this;
        }

        public Builder targetEntityVersionid(Long targetEntityVersionid) {
            this.targetEntityVersionid = targetEntityVersionid;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public FgModTagRel build() {
            return new FgModTagRel(ID, tagReferenceNo, targetEntityTypeCode, targetEntitySubTypeCode, targetEntityRefNo, targetEntityVersionid, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn, lastAuthorisedBy, lastAuthorisedOn);
        }
    }
}
