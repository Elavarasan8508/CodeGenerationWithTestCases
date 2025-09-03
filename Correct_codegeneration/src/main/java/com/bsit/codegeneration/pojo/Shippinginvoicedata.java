package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Shippinginvoicedata {

    private String billNo;

    private String shipbillno;

    private java.time.LocalDateTime shipbilldate;

    private String formno;

    private java.math.BigDecimal invSlNo;

    private String invNo;

    private java.time.LocalDateTime invDate;

    private String ieCode;

    public Shippinginvoicedata() {
    }

    public Shippinginvoicedata(String billNo, String shipbillno, java.time.LocalDateTime shipbilldate, String formno, java.math.BigDecimal invSlNo, String invNo, java.time.LocalDateTime invDate, String ieCode) {
        this.billNo = billNo;
        this.shipbillno = shipbillno;
        this.shipbilldate = shipbilldate;
        this.formno = formno;
        this.invSlNo = invSlNo;
        this.invNo = invNo;
        this.invDate = invDate;
        this.ieCode = ieCode;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getShipbillno() {
        return shipbillno;
    }

    public void setShipbillno(String shipbillno) {
        this.shipbillno = shipbillno;
    }

    public java.time.LocalDateTime getShipbilldate() {
        return shipbilldate;
    }

    public void setShipbilldate(java.time.LocalDateTime shipbilldate) {
        this.shipbilldate = shipbilldate;
    }

    public String getFormno() {
        return formno;
    }

    public void setFormno(String formno) {
        this.formno = formno;
    }

    public java.math.BigDecimal getInvSlNo() {
        return invSlNo;
    }

    public void setInvSlNo(java.math.BigDecimal invSlNo) {
        this.invSlNo = invSlNo;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public java.time.LocalDateTime getInvDate() {
        return invDate;
    }

    public void setInvDate(java.time.LocalDateTime invDate) {
        this.invDate = invDate;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public static class Builder {

        private Shippinginvoicedata instance = new Shippinginvoicedata();

        public Builder billNo(String billNo) {
            instance.setBillNo(billNo);
            return this;
        }

        public Builder shipbillno(String shipbillno) {
            instance.setShipbillno(shipbillno);
            return this;
        }

        public Builder shipbilldate(java.time.LocalDateTime shipbilldate) {
            instance.setShipbilldate(shipbilldate);
            return this;
        }

        public Builder formno(String formno) {
            instance.setFormno(formno);
            return this;
        }

        public Builder invSlNo(java.math.BigDecimal invSlNo) {
            instance.setInvSlNo(invSlNo);
            return this;
        }

        public Builder invNo(String invNo) {
            instance.setInvNo(invNo);
            return this;
        }

        public Builder invDate(java.time.LocalDateTime invDate) {
            instance.setInvDate(invDate);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Shippinginvoicedata build() {
            return instance;
        }
    }
}
