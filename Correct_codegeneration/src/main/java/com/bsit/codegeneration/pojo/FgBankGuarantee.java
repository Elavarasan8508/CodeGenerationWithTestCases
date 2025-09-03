package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FgBankGuarantee {

    private Integer ID;

    private Integer referenceID;

    private String typeCode;

    private String subTypeCode;

    private String activeCode;

    private String stageCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private String template;

    private Integer isTemplate;

    private String bankGuaranteeNumber;

    private String issuingBankName;

    private String issuingBankIfscOrBic;

    private String issuingBankAddress;

    private String applicantCode;

    private String applicantName;

    private String applicantAddress;

    private String applicantPan;

    private String applicantGstin;

    private String applicantAadhaar;

    private java.time.LocalDateTime dateOfIssuance;

    private java.time.LocalDateTime effectiveDate;

    private java.math.BigDecimal faceValue;

    private java.time.LocalDateTime expiryDate;

    private java.time.LocalDateTime claimExpiryDate;

    private String ifin760coverReference;

    private Integer uploadRefID;

    private Integer dmsEventID;

    public FgBankGuarantee() {
    }

    public FgBankGuarantee(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, String bankGuaranteeNumber, String issuingBankName, String issuingBankIfscOrBic, String issuingBankAddress, String applicantCode, String applicantName, String applicantAddress, String applicantPan, String applicantGstin, String applicantAadhaar, java.time.LocalDateTime dateOfIssuance, java.time.LocalDateTime effectiveDate, java.math.BigDecimal faceValue, java.time.LocalDateTime expiryDate, java.time.LocalDateTime claimExpiryDate, String ifin760coverReference, Integer uploadRefID, Integer dmsEventID) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.activeCode = activeCode;
        this.stageCode = stageCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.template = template;
        this.isTemplate = isTemplate;
        this.bankGuaranteeNumber = bankGuaranteeNumber;
        this.issuingBankName = issuingBankName;
        this.issuingBankIfscOrBic = issuingBankIfscOrBic;
        this.issuingBankAddress = issuingBankAddress;
        this.applicantCode = applicantCode;
        this.applicantName = applicantName;
        this.applicantAddress = applicantAddress;
        this.applicantPan = applicantPan;
        this.applicantGstin = applicantGstin;
        this.applicantAadhaar = applicantAadhaar;
        this.dateOfIssuance = dateOfIssuance;
        this.effectiveDate = effectiveDate;
        this.faceValue = faceValue;
        this.expiryDate = expiryDate;
        this.claimExpiryDate = claimExpiryDate;
        this.ifin760coverReference = ifin760coverReference;
        this.uploadRefID = uploadRefID;
        this.dmsEventID = dmsEventID;
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

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getBankGuaranteeNumber() {
        return bankGuaranteeNumber;
    }

    public void setBankGuaranteeNumber(String bankGuaranteeNumber) {
        this.bankGuaranteeNumber = bankGuaranteeNumber;
    }

    public String getIssuingBankName() {
        return issuingBankName;
    }

    public void setIssuingBankName(String issuingBankName) {
        this.issuingBankName = issuingBankName;
    }

    public String getIssuingBankIfscOrBic() {
        return issuingBankIfscOrBic;
    }

    public void setIssuingBankIfscOrBic(String issuingBankIfscOrBic) {
        this.issuingBankIfscOrBic = issuingBankIfscOrBic;
    }

    public String getIssuingBankAddress() {
        return issuingBankAddress;
    }

    public void setIssuingBankAddress(String issuingBankAddress) {
        this.issuingBankAddress = issuingBankAddress;
    }

    public String getApplicantCode() {
        return applicantCode;
    }

    public void setApplicantCode(String applicantCode) {
        this.applicantCode = applicantCode;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantPan() {
        return applicantPan;
    }

    public void setApplicantPan(String applicantPan) {
        this.applicantPan = applicantPan;
    }

    public String getApplicantGstin() {
        return applicantGstin;
    }

    public void setApplicantGstin(String applicantGstin) {
        this.applicantGstin = applicantGstin;
    }

    public String getApplicantAadhaar() {
        return applicantAadhaar;
    }

    public void setApplicantAadhaar(String applicantAadhaar) {
        this.applicantAadhaar = applicantAadhaar;
    }

    public java.time.LocalDateTime getDateOfIssuance() {
        return dateOfIssuance;
    }

    public void setDateOfIssuance(java.time.LocalDateTime dateOfIssuance) {
        this.dateOfIssuance = dateOfIssuance;
    }

    public java.time.LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(java.time.LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public java.math.BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(java.math.BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public java.time.LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(java.time.LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public java.time.LocalDateTime getClaimExpiryDate() {
        return claimExpiryDate;
    }

    public void setClaimExpiryDate(java.time.LocalDateTime claimExpiryDate) {
        this.claimExpiryDate = claimExpiryDate;
    }

    public String getIfin760coverReference() {
        return ifin760coverReference;
    }

    public void setIfin760coverReference(String ifin760coverReference) {
        this.ifin760coverReference = ifin760coverReference;
    }

    public Integer getUploadRefID() {
        return uploadRefID;
    }

    public void setUploadRefID(Integer uploadRefID) {
        this.uploadRefID = uploadRefID;
    }

    public Integer getDmsEventID() {
        return dmsEventID;
    }

    public void setDmsEventID(Integer dmsEventID) {
        this.dmsEventID = dmsEventID;
    }

    public static class Builder {

        private FgBankGuarantee instance = new FgBankGuarantee();

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

        public Builder isTemplate(Integer isTemplate) {
            instance.setIsTemplate(isTemplate);
            return this;
        }

        public Builder bankGuaranteeNumber(String bankGuaranteeNumber) {
            instance.setBankGuaranteeNumber(bankGuaranteeNumber);
            return this;
        }

        public Builder issuingBankName(String issuingBankName) {
            instance.setIssuingBankName(issuingBankName);
            return this;
        }

        public Builder issuingBankIfscOrBic(String issuingBankIfscOrBic) {
            instance.setIssuingBankIfscOrBic(issuingBankIfscOrBic);
            return this;
        }

        public Builder issuingBankAddress(String issuingBankAddress) {
            instance.setIssuingBankAddress(issuingBankAddress);
            return this;
        }

        public Builder applicantCode(String applicantCode) {
            instance.setApplicantCode(applicantCode);
            return this;
        }

        public Builder applicantName(String applicantName) {
            instance.setApplicantName(applicantName);
            return this;
        }

        public Builder applicantAddress(String applicantAddress) {
            instance.setApplicantAddress(applicantAddress);
            return this;
        }

        public Builder applicantPan(String applicantPan) {
            instance.setApplicantPan(applicantPan);
            return this;
        }

        public Builder applicantGstin(String applicantGstin) {
            instance.setApplicantGstin(applicantGstin);
            return this;
        }

        public Builder applicantAadhaar(String applicantAadhaar) {
            instance.setApplicantAadhaar(applicantAadhaar);
            return this;
        }

        public Builder dateOfIssuance(java.time.LocalDateTime dateOfIssuance) {
            instance.setDateOfIssuance(dateOfIssuance);
            return this;
        }

        public Builder effectiveDate(java.time.LocalDateTime effectiveDate) {
            instance.setEffectiveDate(effectiveDate);
            return this;
        }

        public Builder faceValue(java.math.BigDecimal faceValue) {
            instance.setFaceValue(faceValue);
            return this;
        }

        public Builder expiryDate(java.time.LocalDateTime expiryDate) {
            instance.setExpiryDate(expiryDate);
            return this;
        }

        public Builder claimExpiryDate(java.time.LocalDateTime claimExpiryDate) {
            instance.setClaimExpiryDate(claimExpiryDate);
            return this;
        }

        public Builder ifin760coverReference(String ifin760coverReference) {
            instance.setIfin760coverReference(ifin760coverReference);
            return this;
        }

        public Builder uploadRefID(Integer uploadRefID) {
            instance.setUploadRefID(uploadRefID);
            return this;
        }

        public Builder dmsEventID(Integer dmsEventID) {
            instance.setDmsEventID(dmsEventID);
            return this;
        }

        public FgBankGuarantee build() {
            return instance;
        }
    }
}
