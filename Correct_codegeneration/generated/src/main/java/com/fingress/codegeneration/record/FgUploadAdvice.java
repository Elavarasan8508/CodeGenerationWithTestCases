package com.bsit.codegeneration.record;

public record FgUploadAdvice(String ID, String referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, Long createdBy, String lastUpdatedOn, Long lastUpdatedBy, String lastAuthorisedOn, Long lastAuthorisedBy, String template, Long isTemplate, String vendorCode, String invoiceNumber, java.time.LocalDateTime invoiceDate, java.time.LocalDateTime billDueDate, String currency, Long invoiceAmount, String invoiceRef, String serialNo, String documentNo, Long otherDeductions, Long totalDeductedAmount, Long netAmountPayable, java.time.LocalDateTime boeDate, String paymentDetails6, String paymentDetails7, String paymentDetails8, String paymentDetails9, String paymentDetails10, String clientRefNo, java.time.LocalDateTime invoiceDrNoteDate, String invoiceDrNoteNo, String tenure, Long interestRate, Long amountA, Long amountB, Long amountC, Long invoiceDebitNoteAmount, String narration, String billNo, String netAmount, java.time.LocalDateTime billDate, String hundiNumber, String lineNoOfAdvice, String annexureTextContent, String invoiceDateSomany, String parentRefID, Long parentVersionID, String discountRate, String grossAmount, String tdsAmount, String bankCharges, Long equivalentAmount, String equivalentCurrency, Long displayAmount, String displayCurrency, Long authEquivalentAmount, String authEquivalentCurrency, Long displayEquivalentAmount, String displayEquivalentCurrency, Long authFxBaseRate, Long displayFxBaseRate) {

    public static class Builder {

        private String ID;

        private String referenceID;

        private String typeCode;

        private String subTypeCode;

        private String activeCode;

        private String stageCode;

        private String statusCode;

        private String createdOn;

        private Long createdBy;

        private String lastUpdatedOn;

        private Long lastUpdatedBy;

        private String lastAuthorisedOn;

        private Long lastAuthorisedBy;

        private String template;

        private Long isTemplate;

        private String vendorCode;

        private String invoiceNumber;

        private java.time.LocalDateTime invoiceDate;

        private java.time.LocalDateTime billDueDate;

        private String currency;

        private Long invoiceAmount;

        private String invoiceRef;

        private String serialNo;

        private String documentNo;

        private Long otherDeductions;

        private Long totalDeductedAmount;

        private Long netAmountPayable;

        private java.time.LocalDateTime boeDate;

        private String paymentDetails6;

        private String paymentDetails7;

        private String paymentDetails8;

        private String paymentDetails9;

        private String paymentDetails10;

        private String clientRefNo;

        private java.time.LocalDateTime invoiceDrNoteDate;

        private String invoiceDrNoteNo;

        private String tenure;

        private Long interestRate;

        private Long amountA;

        private Long amountB;

        private Long amountC;

        private Long invoiceDebitNoteAmount;

        private String narration;

        private String billNo;

        private String netAmount;

        private java.time.LocalDateTime billDate;

        private String hundiNumber;

        private String lineNoOfAdvice;

        private String annexureTextContent;

        private String invoiceDateSomany;

        private String parentRefID;

        private Long parentVersionID;

        private String discountRate;

        private String grossAmount;

        private String tdsAmount;

        private String bankCharges;

        private Long equivalentAmount;

        private String equivalentCurrency;

        private Long displayAmount;

        private String displayCurrency;

        private Long authEquivalentAmount;

        private String authEquivalentCurrency;

        private Long displayEquivalentAmount;

        private String displayEquivalentCurrency;

        private Long authFxBaseRate;

        private Long displayFxBaseRate;

        public Builder ID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder referenceID(String referenceID) {
            this.referenceID = referenceID;
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

        public Builder activeCode(String activeCode) {
            this.activeCode = activeCode;
            return this;
        }

        public Builder stageCode(String stageCode) {
            this.stageCode = stageCode;
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

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder isTemplate(Long isTemplate) {
            this.isTemplate = isTemplate;
            return this;
        }

        public Builder vendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder invoiceDate(java.time.LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder billDueDate(java.time.LocalDateTime billDueDate) {
            this.billDueDate = billDueDate;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder invoiceAmount(Long invoiceAmount) {
            this.invoiceAmount = invoiceAmount;
            return this;
        }

        public Builder invoiceRef(String invoiceRef) {
            this.invoiceRef = invoiceRef;
            return this;
        }

        public Builder serialNo(String serialNo) {
            this.serialNo = serialNo;
            return this;
        }

        public Builder documentNo(String documentNo) {
            this.documentNo = documentNo;
            return this;
        }

        public Builder otherDeductions(Long otherDeductions) {
            this.otherDeductions = otherDeductions;
            return this;
        }

        public Builder totalDeductedAmount(Long totalDeductedAmount) {
            this.totalDeductedAmount = totalDeductedAmount;
            return this;
        }

        public Builder netAmountPayable(Long netAmountPayable) {
            this.netAmountPayable = netAmountPayable;
            return this;
        }

        public Builder boeDate(java.time.LocalDateTime boeDate) {
            this.boeDate = boeDate;
            return this;
        }

        public Builder paymentDetails6(String paymentDetails6) {
            this.paymentDetails6 = paymentDetails6;
            return this;
        }

        public Builder paymentDetails7(String paymentDetails7) {
            this.paymentDetails7 = paymentDetails7;
            return this;
        }

        public Builder paymentDetails8(String paymentDetails8) {
            this.paymentDetails8 = paymentDetails8;
            return this;
        }

        public Builder paymentDetails9(String paymentDetails9) {
            this.paymentDetails9 = paymentDetails9;
            return this;
        }

        public Builder paymentDetails10(String paymentDetails10) {
            this.paymentDetails10 = paymentDetails10;
            return this;
        }

        public Builder clientRefNo(String clientRefNo) {
            this.clientRefNo = clientRefNo;
            return this;
        }

        public Builder invoiceDrNoteDate(java.time.LocalDateTime invoiceDrNoteDate) {
            this.invoiceDrNoteDate = invoiceDrNoteDate;
            return this;
        }

        public Builder invoiceDrNoteNo(String invoiceDrNoteNo) {
            this.invoiceDrNoteNo = invoiceDrNoteNo;
            return this;
        }

        public Builder tenure(String tenure) {
            this.tenure = tenure;
            return this;
        }

        public Builder interestRate(Long interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder amountA(Long amountA) {
            this.amountA = amountA;
            return this;
        }

        public Builder amountB(Long amountB) {
            this.amountB = amountB;
            return this;
        }

        public Builder amountC(Long amountC) {
            this.amountC = amountC;
            return this;
        }

        public Builder invoiceDebitNoteAmount(Long invoiceDebitNoteAmount) {
            this.invoiceDebitNoteAmount = invoiceDebitNoteAmount;
            return this;
        }

        public Builder narration(String narration) {
            this.narration = narration;
            return this;
        }

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public Builder netAmount(String netAmount) {
            this.netAmount = netAmount;
            return this;
        }

        public Builder billDate(java.time.LocalDateTime billDate) {
            this.billDate = billDate;
            return this;
        }

        public Builder hundiNumber(String hundiNumber) {
            this.hundiNumber = hundiNumber;
            return this;
        }

        public Builder lineNoOfAdvice(String lineNoOfAdvice) {
            this.lineNoOfAdvice = lineNoOfAdvice;
            return this;
        }

        public Builder annexureTextContent(String annexureTextContent) {
            this.annexureTextContent = annexureTextContent;
            return this;
        }

        public Builder invoiceDateSomany(String invoiceDateSomany) {
            this.invoiceDateSomany = invoiceDateSomany;
            return this;
        }

        public Builder parentRefID(String parentRefID) {
            this.parentRefID = parentRefID;
            return this;
        }

        public Builder parentVersionID(Long parentVersionID) {
            this.parentVersionID = parentVersionID;
            return this;
        }

        public Builder discountRate(String discountRate) {
            this.discountRate = discountRate;
            return this;
        }

        public Builder grossAmount(String grossAmount) {
            this.grossAmount = grossAmount;
            return this;
        }

        public Builder tdsAmount(String tdsAmount) {
            this.tdsAmount = tdsAmount;
            return this;
        }

        public Builder bankCharges(String bankCharges) {
            this.bankCharges = bankCharges;
            return this;
        }

        public Builder equivalentAmount(Long equivalentAmount) {
            this.equivalentAmount = equivalentAmount;
            return this;
        }

        public Builder equivalentCurrency(String equivalentCurrency) {
            this.equivalentCurrency = equivalentCurrency;
            return this;
        }

        public Builder displayAmount(Long displayAmount) {
            this.displayAmount = displayAmount;
            return this;
        }

        public Builder displayCurrency(String displayCurrency) {
            this.displayCurrency = displayCurrency;
            return this;
        }

        public Builder authEquivalentAmount(Long authEquivalentAmount) {
            this.authEquivalentAmount = authEquivalentAmount;
            return this;
        }

        public Builder authEquivalentCurrency(String authEquivalentCurrency) {
            this.authEquivalentCurrency = authEquivalentCurrency;
            return this;
        }

        public Builder displayEquivalentAmount(Long displayEquivalentAmount) {
            this.displayEquivalentAmount = displayEquivalentAmount;
            return this;
        }

        public Builder displayEquivalentCurrency(String displayEquivalentCurrency) {
            this.displayEquivalentCurrency = displayEquivalentCurrency;
            return this;
        }

        public Builder authFxBaseRate(Long authFxBaseRate) {
            this.authFxBaseRate = authFxBaseRate;
            return this;
        }

        public Builder displayFxBaseRate(Long displayFxBaseRate) {
            this.displayFxBaseRate = displayFxBaseRate;
            return this;
        }

        public FgUploadAdvice build() {
            return new FgUploadAdvice(ID, referenceID, typeCode, subTypeCode, activeCode, stageCode, statusCode, createdOn, createdBy, lastUpdatedOn, lastUpdatedBy, lastAuthorisedOn, lastAuthorisedBy, template, isTemplate, vendorCode, invoiceNumber, invoiceDate, billDueDate, currency, invoiceAmount, invoiceRef, serialNo, documentNo, otherDeductions, totalDeductedAmount, netAmountPayable, boeDate, paymentDetails6, paymentDetails7, paymentDetails8, paymentDetails9, paymentDetails10, clientRefNo, invoiceDrNoteDate, invoiceDrNoteNo, tenure, interestRate, amountA, amountB, amountC, invoiceDebitNoteAmount, narration, billNo, netAmount, billDate, hundiNumber, lineNoOfAdvice, annexureTextContent, invoiceDateSomany, parentRefID, parentVersionID, discountRate, grossAmount, tdsAmount, bankCharges, equivalentAmount, equivalentCurrency, displayAmount, displayCurrency, authEquivalentAmount, authEquivalentCurrency, displayEquivalentAmount, displayEquivalentCurrency, authFxBaseRate, displayFxBaseRate);
        }
    }
}
