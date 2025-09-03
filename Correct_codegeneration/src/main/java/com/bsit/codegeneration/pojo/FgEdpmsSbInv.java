package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgEdpmsSbInv {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private Integer processID;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private String applicantParty;

    private String fulfillmentParty;

    private Integer isTemplate;

    private String billNo;

    private String shipbillno;

    private String formno;

    private String invSlNo;

    private String invNo;

    private java.time.LocalDateTime invDate;

    private String fobcurrcode;

    private java.math.BigDecimal fobAmt;

    private String frieghtcurrcode;

    private java.math.BigDecimal frieghtAmt;

    private String inscurrcode;

    private java.math.BigDecimal insAmt;

    private String ieCode;

    private Integer parentRefID;

    private Integer parentVersionID;

    public FgEdpmsSbInv() {
    }

    public FgEdpmsSbInv(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, String billNo, String shipbillno, String formno, String invSlNo, String invNo, java.time.LocalDateTime invDate, String fobcurrcode, java.math.BigDecimal fobAmt, String frieghtcurrcode, java.math.BigDecimal frieghtAmt, String inscurrcode, java.math.BigDecimal insAmt, String ieCode, Integer parentRefID, Integer parentVersionID) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.processID = processID;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.applicantParty = applicantParty;
        this.fulfillmentParty = fulfillmentParty;
        this.isTemplate = isTemplate;
        this.billNo = billNo;
        this.shipbillno = shipbillno;
        this.formno = formno;
        this.invSlNo = invSlNo;
        this.invNo = invNo;
        this.invDate = invDate;
        this.fobcurrcode = fobcurrcode;
        this.fobAmt = fobAmt;
        this.frieghtcurrcode = frieghtcurrcode;
        this.frieghtAmt = frieghtAmt;
        this.inscurrcode = inscurrcode;
        this.insAmt = insAmt;
        this.ieCode = ieCode;
        this.parentRefID = parentRefID;
        this.parentVersionID = parentVersionID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Integer referenceID) {
        this.referenceID = referenceID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public java.math.BigDecimal getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(java.math.BigDecimal createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public java.math.BigDecimal getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastAuthorisedOn() {
        return lastAuthorisedOn;
    }

    public void setLastAuthorisedOn(String lastAuthorisedOn) {
        this.lastAuthorisedOn = lastAuthorisedOn;
    }

    public java.math.BigDecimal getLastAuthorisedBy() {
        return lastAuthorisedBy;
    }

    public void setLastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
        this.lastAuthorisedBy = lastAuthorisedBy;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getApplicantParty() {
        return applicantParty;
    }

    public void setApplicantParty(String applicantParty) {
        this.applicantParty = applicantParty;
    }

    public String getFulfillmentParty() {
        return fulfillmentParty;
    }

    public void setFulfillmentParty(String fulfillmentParty) {
        this.fulfillmentParty = fulfillmentParty;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
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

    public String getFormno() {
        return formno;
    }

    public void setFormno(String formno) {
        this.formno = formno;
    }

    public String getInvSlNo() {
        return invSlNo;
    }

    public void setInvSlNo(String invSlNo) {
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

    public String getFobcurrcode() {
        return fobcurrcode;
    }

    public void setFobcurrcode(String fobcurrcode) {
        this.fobcurrcode = fobcurrcode;
    }

    public java.math.BigDecimal getFobAmt() {
        return fobAmt;
    }

    public void setFobAmt(java.math.BigDecimal fobAmt) {
        this.fobAmt = fobAmt;
    }

    public String getFrieghtcurrcode() {
        return frieghtcurrcode;
    }

    public void setFrieghtcurrcode(String frieghtcurrcode) {
        this.frieghtcurrcode = frieghtcurrcode;
    }

    public java.math.BigDecimal getFrieghtAmt() {
        return frieghtAmt;
    }

    public void setFrieghtAmt(java.math.BigDecimal frieghtAmt) {
        this.frieghtAmt = frieghtAmt;
    }

    public String getInscurrcode() {
        return inscurrcode;
    }

    public void setInscurrcode(String inscurrcode) {
        this.inscurrcode = inscurrcode;
    }

    public java.math.BigDecimal getInsAmt() {
        return insAmt;
    }

    public void setInsAmt(java.math.BigDecimal insAmt) {
        this.insAmt = insAmt;
    }

    public String getIeCode() {
        return ieCode;
    }

    public void setIeCode(String ieCode) {
        this.ieCode = ieCode;
    }

    public Integer getParentRefID() {
        return parentRefID;
    }

    public void setParentRefID(Integer parentRefID) {
        this.parentRefID = parentRefID;
    }

    public Integer getParentVersionID() {
        return parentVersionID;
    }

    public void setParentVersionID(Integer parentVersionID) {
        this.parentVersionID = parentVersionID;
    }

    public static class Builder {

        private FgEdpmsSbInv instance = new FgEdpmsSbInv();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder typeCode(String typeCode) {
            instance.setTypeCode(typeCode);
            return this;
        }

        public Builder subTypeCode(String subTypeCode) {
            instance.setSubTypeCode(subTypeCode);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
            return this;
        }

        public Builder stageCode(String stageCode) {
            instance.setStageCode(stageCode);
            return this;
        }

        public Builder statusCode(String statusCode) {
            instance.setStatusCode(statusCode);
            return this;
        }

        public Builder processID(Integer processID) {
            instance.setProcessID(processID);
            return this;
        }

        public Builder createdOn(String createdOn) {
            instance.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(java.math.BigDecimal createdBy) {
            instance.setCreatedBy(createdBy);
            return this;
        }

        public Builder lastUpdatedOn(String lastUpdatedOn) {
            instance.setLastUpdatedOn(lastUpdatedOn);
            return this;
        }

        public Builder lastUpdatedBy(java.math.BigDecimal lastUpdatedBy) {
            instance.setLastUpdatedBy(lastUpdatedBy);
            return this;
        }

        public Builder lastAuthorisedOn(String lastAuthorisedOn) {
            instance.setLastAuthorisedOn(lastAuthorisedOn);
            return this;
        }

        public Builder lastAuthorisedBy(java.math.BigDecimal lastAuthorisedBy) {
            instance.setLastAuthorisedBy(lastAuthorisedBy);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder applicantParty(String applicantParty) {
            instance.setApplicantParty(applicantParty);
            return this;
        }

        public Builder fulfillmentParty(String fulfillmentParty) {
            instance.setFulfillmentParty(fulfillmentParty);
            return this;
        }

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder billNo(String billNo) {
            instance.setBillNo(billNo);
            return this;
        }

        public Builder shipbillno(String shipbillno) {
            instance.setShipbillno(shipbillno);
            return this;
        }

        public Builder formno(String formno) {
            instance.setFormno(formno);
            return this;
        }

        public Builder invSlNo(String invSlNo) {
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

        public Builder fobcurrcode(String fobcurrcode) {
            instance.setFobcurrcode(fobcurrcode);
            return this;
        }

        public Builder fobAmt(java.math.BigDecimal fobAmt) {
            instance.setFobAmt(fobAmt);
            return this;
        }

        public Builder frieghtcurrcode(String frieghtcurrcode) {
            instance.setFrieghtcurrcode(frieghtcurrcode);
            return this;
        }

        public Builder frieghtAmt(java.math.BigDecimal frieghtAmt) {
            instance.setFrieghtAmt(frieghtAmt);
            return this;
        }

        public Builder inscurrcode(String inscurrcode) {
            instance.setInscurrcode(inscurrcode);
            return this;
        }

        public Builder insAmt(java.math.BigDecimal insAmt) {
            instance.setInsAmt(insAmt);
            return this;
        }

        public Builder ieCode(String ieCode) {
            instance.setIeCode(ieCode);
            return this;
        }

        public Builder parentRefID(Integer parentRefID) {
            instance.setParentRefID(parentRefID);
            return this;
        }

        public Builder parentVersionID(Integer parentVersionID) {
            instance.setParentVersionID(parentVersionID);
            return this;
        }

        public FgEdpmsSbInv build() {
            return instance;
        }
    }
}
