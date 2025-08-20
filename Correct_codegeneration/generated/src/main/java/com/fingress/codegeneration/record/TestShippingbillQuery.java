package com.bsit.codegeneration.record;

public record TestShippingbillQuery(String billID, String invoiceID, String shippingBillStatus, String shippingbillNo, String formNo, java.time.LocalDateTime shippingbillDate, java.time.LocalDateTime leoDate, String adCode, String portOfLoading, String exportAgency, String exportType, String ieCode, String adBillNumber, String invoiceStatus, String invoiceNo, java.time.LocalDateTime invoiceDate, String invoiceSerialNo, String fobCurrency, String frieghtCurrency, String insuranceCurrency, Long fobAmount, Long utilizedFobAmount, Long freightAmount, Long utilizedFreightAmount, Long insuranceAmount, Long utilizedInsuranceAmount) {

    public static class Builder {

        private String billID;

        private String invoiceID;

        private String shippingBillStatus;

        private String shippingbillNo;

        private String formNo;

        private java.time.LocalDateTime shippingbillDate;

        private java.time.LocalDateTime leoDate;

        private String adCode;

        private String portOfLoading;

        private String exportAgency;

        private String exportType;

        private String ieCode;

        private String adBillNumber;

        private String invoiceStatus;

        private String invoiceNo;

        private java.time.LocalDateTime invoiceDate;

        private String invoiceSerialNo;

        private String fobCurrency;

        private String frieghtCurrency;

        private String insuranceCurrency;

        private Long fobAmount;

        private Long utilizedFobAmount;

        private Long freightAmount;

        private Long utilizedFreightAmount;

        private Long insuranceAmount;

        private Long utilizedInsuranceAmount;

        public Builder billID(String billID) {
            this.billID = billID;
            return this;
        }

        public Builder invoiceID(String invoiceID) {
            this.invoiceID = invoiceID;
            return this;
        }

        public Builder shippingBillStatus(String shippingBillStatus) {
            this.shippingBillStatus = shippingBillStatus;
            return this;
        }

        public Builder shippingbillNo(String shippingbillNo) {
            this.shippingbillNo = shippingbillNo;
            return this;
        }

        public Builder formNo(String formNo) {
            this.formNo = formNo;
            return this;
        }

        public Builder shippingbillDate(java.time.LocalDateTime shippingbillDate) {
            this.shippingbillDate = shippingbillDate;
            return this;
        }

        public Builder leoDate(java.time.LocalDateTime leoDate) {
            this.leoDate = leoDate;
            return this;
        }

        public Builder adCode(String adCode) {
            this.adCode = adCode;
            return this;
        }

        public Builder portOfLoading(String portOfLoading) {
            this.portOfLoading = portOfLoading;
            return this;
        }

        public Builder exportAgency(String exportAgency) {
            this.exportAgency = exportAgency;
            return this;
        }

        public Builder exportType(String exportType) {
            this.exportType = exportType;
            return this;
        }

        public Builder ieCode(String ieCode) {
            this.ieCode = ieCode;
            return this;
        }

        public Builder adBillNumber(String adBillNumber) {
            this.adBillNumber = adBillNumber;
            return this;
        }

        public Builder invoiceStatus(String invoiceStatus) {
            this.invoiceStatus = invoiceStatus;
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invoiceSerialNo(String invoiceSerialNo) {
            this.invoiceSerialNo = invoiceSerialNo;
            return this;
        }

        public Builder fobCurrency(String fobCurrency) {
            this.fobCurrency = fobCurrency;
            return this;
        }

        public Builder frieghtCurrency(String frieghtCurrency) {
            this.frieghtCurrency = frieghtCurrency;
            return this;
        }

        public Builder insuranceCurrency(String insuranceCurrency) {
            this.insuranceCurrency = insuranceCurrency;
            return this;
        }

        public Builder fobAmount(Long fobAmount) {
            this.fobAmount = fobAmount;
            return this;
        }

        public Builder utilizedFobAmount(Long utilizedFobAmount) {
            this.utilizedFobAmount = utilizedFobAmount;
            return this;
        }

        public Builder freightAmount(Long freightAmount) {
            this.freightAmount = freightAmount;
            return this;
        }

        public Builder utilizedFreightAmount(Long utilizedFreightAmount) {
            this.utilizedFreightAmount = utilizedFreightAmount;
            return this;
        }

        public Builder insuranceAmount(Long insuranceAmount) {
            this.insuranceAmount = insuranceAmount;
            return this;
        }

        public Builder utilizedInsuranceAmount(Long utilizedInsuranceAmount) {
            this.utilizedInsuranceAmount = utilizedInsuranceAmount;
            return this;
        }

        public TestShippingbillQuery build() {
            return new TestShippingbillQuery(billID, invoiceID, shippingBillStatus, shippingbillNo, formNo, shippingbillDate, leoDate, adCode, portOfLoading, exportAgency, exportType, ieCode, adBillNumber, invoiceStatus, invoiceNo, invoiceDate, invoiceSerialNo, fobCurrency, frieghtCurrency, insuranceCurrency, fobAmount, utilizedFobAmount, freightAmount, utilizedFreightAmount, insuranceAmount, utilizedInsuranceAmount);
        }
    }
}
