package com.bsit.codegeneration.record;

public record FgModProductLink(Long ID, String refID, String typeCode, String subTypeCode, String childRefID, String childTypeCode, String childSubTypeCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, Long amount, Long faceValue, String discountPercentage, String requestPercentage, Long requestedAmount, String programCode, String offerCode) {

    public static class Builder {

        private Long ID;

        private String refID;

        private String typeCode;

        private String subTypeCode;

        private String childRefID;

        private String childTypeCode;

        private String childSubTypeCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private Long amount;

        private Long faceValue;

        private String discountPercentage;

        private String requestPercentage;

        private Long requestedAmount;

        private String programCode;

        private String offerCode;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder refID(String refID) {
            this.refID = refID;
            return this;
        }

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            this.subTypeCode = subTypeCode;
            return this;
        }

        public Builder childRefID(String childRefID) {
            this.childRefID = childRefID;
            return this;
        }

        public Builder childTypeCode(String childTypeCode) {
            this.childTypeCode = childTypeCode;
            return this;
        }

        public Builder childSubTypeCode(String childSubTypeCode) {
            this.childSubTypeCode = childSubTypeCode;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdBy(Long createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder lastUpdatedBy(Long lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            this.lastAuthorisedOn = lastAuthorisedOn;
            return this;
        }

        public Builder lastAuthorisedBy(Long lastAuthorisedBy) {
            this.lastAuthorisedBy = lastAuthorisedBy;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder faceValue(Long faceValue) {
            this.faceValue = faceValue;
            return this;
        }

        public Builder discountPercentage(String discountPercentage) {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Builder requestPercentage(String requestPercentage) {
            this.requestPercentage = requestPercentage;
            return this;
        }

        public Builder requestedAmount(Long requestedAmount) {
            this.requestedAmount = requestedAmount;
            return this;
        }

        public Builder programCode(String programCode) {
            this.programCode = programCode;
            return this;
        }

        public Builder offerCode(String offerCode) {
            this.offerCode = offerCode;
            return this;
        }

        public FgModProductLink build() {
            return new FgModProductLink(ID, refID, typeCode, subTypeCode, childRefID, childTypeCode, childSubTypeCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, amount, faceValue, discountPercentage, requestPercentage, requestedAmount, programCode, offerCode);
        }
    }
}
