package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Shippingbilldata {

    private String status;

    private String shipbillno;

    private java.time.LocalDateTime shipbilldate;

    private String portcode;

    private String formno;

    private java.math.BigDecimal shippingbillamount;

    private String shippingbillcurr;

    private java.math.BigDecimal utilizedAmt;

    private java.math.BigDecimal unutilizedAmt;

    private String billrefno;

    private String counterParty;

    public Shippingbilldata() {
    }

    public Shippingbilldata(String status, String shipbillno, java.time.LocalDateTime shipbilldate, String portcode, String formno, java.math.BigDecimal shippingbillamount, String shippingbillcurr, java.math.BigDecimal utilizedAmt, java.math.BigDecimal unutilizedAmt, String billrefno, String counterParty) {
        this.status = status;
        this.shipbillno = shipbillno;
        this.shipbilldate = shipbilldate;
        this.portcode = portcode;
        this.formno = formno;
        this.shippingbillamount = shippingbillamount;
        this.shippingbillcurr = shippingbillcurr;
        this.utilizedAmt = utilizedAmt;
        this.unutilizedAmt = unutilizedAmt;
        this.billrefno = billrefno;
        this.counterParty = counterParty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getPortcode() {
        return portcode;
    }

    public void setPortcode(String portcode) {
        this.portcode = portcode;
    }

    public String getFormno() {
        return formno;
    }

    public void setFormno(String formno) {
        this.formno = formno;
    }

    public java.math.BigDecimal getShippingbillamount() {
        return shippingbillamount;
    }

    public void setShippingbillamount(java.math.BigDecimal shippingbillamount) {
        this.shippingbillamount = shippingbillamount;
    }

    public String getShippingbillcurr() {
        return shippingbillcurr;
    }

    public void setShippingbillcurr(String shippingbillcurr) {
        this.shippingbillcurr = shippingbillcurr;
    }

    public java.math.BigDecimal getUtilizedAmt() {
        return utilizedAmt;
    }

    public void setUtilizedAmt(java.math.BigDecimal utilizedAmt) {
        this.utilizedAmt = utilizedAmt;
    }

    public java.math.BigDecimal getUnutilizedAmt() {
        return unutilizedAmt;
    }

    public void setUnutilizedAmt(java.math.BigDecimal unutilizedAmt) {
        this.unutilizedAmt = unutilizedAmt;
    }

    public String getBillrefno() {
        return billrefno;
    }

    public void setBillrefno(String billrefno) {
        this.billrefno = billrefno;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public static class Builder {

        private Shippingbilldata instance = new Shippingbilldata();

        public Builder status(String status) {
            instance.setStatus(status);
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

        public Builder portcode(String portcode) {
            instance.setPortcode(portcode);
            return this;
        }

        public Builder formno(String formno) {
            instance.setFormno(formno);
            return this;
        }

        public Builder shippingbillamount(java.math.BigDecimal shippingbillamount) {
            instance.setShippingbillamount(shippingbillamount);
            return this;
        }

        public Builder shippingbillcurr(String shippingbillcurr) {
            instance.setShippingbillcurr(shippingbillcurr);
            return this;
        }

        public Builder utilizedAmt(java.math.BigDecimal utilizedAmt) {
            instance.setUtilizedAmt(utilizedAmt);
            return this;
        }

        public Builder unutilizedAmt(java.math.BigDecimal unutilizedAmt) {
            instance.setUnutilizedAmt(unutilizedAmt);
            return this;
        }

        public Builder billrefno(String billrefno) {
            instance.setBillrefno(billrefno);
            return this;
        }

        public Builder counterParty(String counterParty) {
            instance.setCounterParty(counterParty);
            return this;
        }

        public Shippingbilldata build() {
            return instance;
        }
    }
}
