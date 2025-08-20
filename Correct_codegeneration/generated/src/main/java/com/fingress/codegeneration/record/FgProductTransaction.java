package com.bsit.codegeneration.record;

public record FgProductTransaction(Long ID, Long paymentID, String entityReferenceID, java.time.LocalDateTime transactionDate, String currencyCode, Long transactionAmount, String description, String activeCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy) {

    public static class Builder {

        private Long ID;

        private Long paymentID;

        private String entityReferenceID;

        private java.time.LocalDateTime transactionDate;

        private String currencyCode;

        private Long transactionAmount;

        private String description;

        private String activeCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder paymentID(Long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder entityReferenceID(String entityReferenceID) {
            this.entityReferenceID = entityReferenceID;
            return this;
        }

        public Builder transactionDate(java.time.LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder transactionAmount(Long transactionAmount) {
            this.transactionAmount = transactionAmount;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
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

        public FgProductTransaction build() {
            return new FgProductTransaction(ID, paymentID, entityReferenceID, transactionDate, currencyCode, transactionAmount, description, activeCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy);
        }
    }
}
