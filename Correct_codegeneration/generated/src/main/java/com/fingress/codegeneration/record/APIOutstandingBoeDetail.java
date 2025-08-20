package com.bsit.codegeneration.record;

public record APIOutstandingBoeDetail(String boeNumber, java.time.LocalDateTime boeDate, String dischargePort, String importAgency, String ieCode, Long invoiceSerialNumber, String invoiceNumber, String invoiceTerm, String supplierName, String supplierAddress, String supplierCountry, String sellerName, String sellerAddress, String sellerCountry, String fobCurrency, Long fobValue, Long utilizedFobValue, String referenceID) {

    public static class Builder {

        private String boeNumber;

        private java.time.LocalDateTime boeDate;

        private String dischargePort;

        private String importAgency;

        private String ieCode;

        private Long invoiceSerialNumber;

        private String invoiceNumber;

        private String invoiceTerm;

        private String supplierName;

        private String supplierAddress;

        private String supplierCountry;

        private String sellerName;

        private String sellerAddress;

        private String sellerCountry;

        private String fobCurrency;

        private Long fobValue;

        private Long utilizedFobValue;

        private String referenceID;

        public Builder boeNumber(String boeNumber) {
            this.boeNumber = boeNumber;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder dischargePort(String dischargePort) {
            this.dischargePort = dischargePort;
            return this;
        }

        public Builder importAgency(String importAgency) {
            this.importAgency = importAgency;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder invoiceSerialNumber(Long invoiceSerialNumber) {
            this.invoiceSerialNumber = invoiceSerialNumber;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder invoiceTerm(String invoiceTerm) {
            this.invoiceTerm = invoiceTerm;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder supplierAddress(String supplierAddress) {
            this.supplierAddress = supplierAddress;
            return this;
        }

        public Builder supplierCountry(String supplierCountry) {
            this.supplierCountry = supplierCountry;
            return this;
        }

        public Builder sellerName(String sellerName) {
            this.sellerName = sellerName;
            return this;
        }

        public Builder sellerAddress(String sellerAddress) {
            this.sellerAddress = sellerAddress;
            return this;
        }

        public Builder sellerCountry(String sellerCountry) {
            this.sellerCountry = sellerCountry;
            return this;
        }

        public Builder fobCurrency(String fobCurrency) {
            this.fobCurrency = fobCurrency;
            return this;
        }

        public Builder fobValue(Long fobValue) {
            this.fobValue = fobValue;
            return this;
        }

        public Builder utilizedFobValue(Long utilizedFobValue) {
            this.utilizedFobValue = utilizedFobValue;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
            return this;
        }

        public APIOutstandingBoeDetail build() {
            return new APIOutstandingBoeDetail(boeNumber, boeDate, dischargePort, importAgency, ieCode, invoiceSerialNumber, invoiceNumber, invoiceTerm, supplierName, supplierAddress, supplierCountry, sellerName, sellerAddress, sellerCountry, fobCurrency, fobValue, utilizedFobValue, referenceID);
        }
    }
}
