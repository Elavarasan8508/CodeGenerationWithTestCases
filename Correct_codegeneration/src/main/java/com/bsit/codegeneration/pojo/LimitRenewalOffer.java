package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LimitRenewalOffer {

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

    private Long lob;

    private Long crnBor;

    private Integer prospectID;

    private java.time.LocalDateTime validTo;

    private java.math.BigDecimal procFee;

    private java.math.BigDecimal procFeeGst;

    private java.math.BigDecimal alreadyCollected;

    private java.math.BigDecimal alreadyCollectedGst;

    private java.math.BigDecimal balCollected;

    private java.math.BigDecimal balCollectedGst;

    private java.math.BigDecimal adminChrgs;

    private java.math.BigDecimal adminChrgsGst;

    private java.math.BigDecimal technicalFees;

    private java.math.BigDecimal technicalFeesGst;

    private java.time.LocalDateTime nextReviewDate;

    private java.time.LocalDateTime lastReviewDate;

    private String varLimitApplicable;

    private String gmlLimitApplicable;

    private String cgtmse;

    private String remarks;

    private String termLoan;

    private String sidbi;

    private String ccod;

    private String seasonalAdHoc;

    private String crnName;

    private Integer versionID;

    private Integer isMasterVersion;

    private java.math.BigDecimal adminCharges;

    private java.math.BigDecimal adminChargesGst;

    public LimitRenewalOffer() {
    }

    public LimitRenewalOffer(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, Integer processID, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, String applicantParty, String fulfillmentParty, Integer isTemplate, Long lob, Long crnBor, Integer prospectID, java.time.LocalDateTime validTo, java.math.BigDecimal procFee, java.math.BigDecimal procFeeGst, java.math.BigDecimal alreadyCollected, java.math.BigDecimal alreadyCollectedGst, java.math.BigDecimal balCollected, java.math.BigDecimal balCollectedGst, java.math.BigDecimal adminChrgs, java.math.BigDecimal adminChrgsGst, java.math.BigDecimal technicalFees, java.math.BigDecimal technicalFeesGst, java.time.LocalDateTime nextReviewDate, java.time.LocalDateTime lastReviewDate, String varLimitApplicable, String gmlLimitApplicable, String cgtmse, String remarks, String termLoan, String sidbi, String ccod, String seasonalAdHoc, String crnName, Integer versionID, Integer isMasterVersion, java.math.BigDecimal adminCharges, java.math.BigDecimal adminChargesGst) {
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
        this.lob = lob;
        this.crnBor = crnBor;
        this.prospectID = prospectID;
        this.validTo = validTo;
        this.procFee = procFee;
        this.procFeeGst = procFeeGst;
        this.alreadyCollected = alreadyCollected;
        this.alreadyCollectedGst = alreadyCollectedGst;
        this.balCollected = balCollected;
        this.balCollectedGst = balCollectedGst;
        this.adminChrgs = adminChrgs;
        this.adminChrgsGst = adminChrgsGst;
        this.technicalFees = technicalFees;
        this.technicalFeesGst = technicalFeesGst;
        this.nextReviewDate = nextReviewDate;
        this.lastReviewDate = lastReviewDate;
        this.varLimitApplicable = varLimitApplicable;
        this.gmlLimitApplicable = gmlLimitApplicable;
        this.cgtmse = cgtmse;
        this.remarks = remarks;
        this.termLoan = termLoan;
        this.sidbi = sidbi;
        this.ccod = ccod;
        this.seasonalAdHoc = seasonalAdHoc;
        this.crnName = crnName;
        this.versionID = versionID;
        this.isMasterVersion = isMasterVersion;
        this.adminCharges = adminCharges;
        this.adminChargesGst = adminChargesGst;
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

    public Long getLob() {
        return lob;
    }

    public void setLob(Long lob) {
        this.lob = lob;
    }

    public Long getCrnBor() {
        return crnBor;
    }

    public void setCrnBor(Long crnBor) {
        this.crnBor = crnBor;
    }

    public Integer getProspectID() {
        return prospectID;
    }

    public void setProspectID(Integer prospectID) {
        this.prospectID = prospectID;
    }

    public java.time.LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(java.time.LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public java.math.BigDecimal getProcFee() {
        return procFee;
    }

    public void setProcFee(java.math.BigDecimal procFee) {
        this.procFee = procFee;
    }

    public java.math.BigDecimal getProcFeeGst() {
        return procFeeGst;
    }

    public void setProcFeeGst(java.math.BigDecimal procFeeGst) {
        this.procFeeGst = procFeeGst;
    }

    public java.math.BigDecimal getAlreadyCollected() {
        return alreadyCollected;
    }

    public void setAlreadyCollected(java.math.BigDecimal alreadyCollected) {
        this.alreadyCollected = alreadyCollected;
    }

    public java.math.BigDecimal getAlreadyCollectedGst() {
        return alreadyCollectedGst;
    }

    public void setAlreadyCollectedGst(java.math.BigDecimal alreadyCollectedGst) {
        this.alreadyCollectedGst = alreadyCollectedGst;
    }

    public java.math.BigDecimal getBalCollected() {
        return balCollected;
    }

    public void setBalCollected(java.math.BigDecimal balCollected) {
        this.balCollected = balCollected;
    }

    public java.math.BigDecimal getBalCollectedGst() {
        return balCollectedGst;
    }

    public void setBalCollectedGst(java.math.BigDecimal balCollectedGst) {
        this.balCollectedGst = balCollectedGst;
    }

    public java.math.BigDecimal getAdminChrgs() {
        return adminChrgs;
    }

    public void setAdminChrgs(java.math.BigDecimal adminChrgs) {
        this.adminChrgs = adminChrgs;
    }

    public java.math.BigDecimal getAdminChrgsGst() {
        return adminChrgsGst;
    }

    public void setAdminChrgsGst(java.math.BigDecimal adminChrgsGst) {
        this.adminChrgsGst = adminChrgsGst;
    }

    public java.math.BigDecimal getTechnicalFees() {
        return technicalFees;
    }

    public void setTechnicalFees(java.math.BigDecimal technicalFees) {
        this.technicalFees = technicalFees;
    }

    public java.math.BigDecimal getTechnicalFeesGst() {
        return technicalFeesGst;
    }

    public void setTechnicalFeesGst(java.math.BigDecimal technicalFeesGst) {
        this.technicalFeesGst = technicalFeesGst;
    }

    public java.time.LocalDateTime getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(java.time.LocalDateTime nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public java.time.LocalDateTime getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(java.time.LocalDateTime lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    public String getVarLimitApplicable() {
        return varLimitApplicable;
    }

    public void setVarLimitApplicable(String varLimitApplicable) {
        this.varLimitApplicable = varLimitApplicable;
    }

    public String getGmlLimitApplicable() {
        return gmlLimitApplicable;
    }

    public void setGmlLimitApplicable(String gmlLimitApplicable) {
        this.gmlLimitApplicable = gmlLimitApplicable;
    }

    public String getCgtmse() {
        return cgtmse;
    }

    public void setCgtmse(String cgtmse) {
        this.cgtmse = cgtmse;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTermLoan() {
        return termLoan;
    }

    public void setTermLoan(String termLoan) {
        this.termLoan = termLoan;
    }

    public String getSidbi() {
        return sidbi;
    }

    public void setSidbi(String sidbi) {
        this.sidbi = sidbi;
    }

    public String getCcod() {
        return ccod;
    }

    public void setCcod(String ccod) {
        this.ccod = ccod;
    }

    public String getSeasonalAdHoc() {
        return seasonalAdHoc;
    }

    public void setSeasonalAdHoc(String seasonalAdHoc) {
        this.seasonalAdHoc = seasonalAdHoc;
    }

    public String getCrnName() {
        return crnName;
    }

    public void setCrnName(String crnName) {
        this.crnName = crnName;
    }

    public Integer getVersionID() {
        return versionID;
    }

    public void setVersionID(Integer versionID) {
        this.versionID = versionID;
    }

    public Integer getIsMasterVersion() {
        return isMasterVersion;
    }

    public void setIsMasterVersion(Integer isMasterVersion) {
        this.isMasterVersion = isMasterVersion;
    }

    public java.math.BigDecimal getAdminCharges() {
        return adminCharges;
    }

    public void setAdminCharges(java.math.BigDecimal adminCharges) {
        this.adminCharges = adminCharges;
    }

    public java.math.BigDecimal getAdminChargesGst() {
        return adminChargesGst;
    }

    public void setAdminChargesGst(java.math.BigDecimal adminChargesGst) {
        this.adminChargesGst = adminChargesGst;
    }

    public static class Builder {

        private LimitRenewalOffer instance = new LimitRenewalOffer();

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

        public Builder lob(Long lob) {
            instance.setLob(lob);
            return this;
        }

        public Builder crnBor(Long crnBor) {
            instance.setCrnBor(crnBor);
            return this;
        }

        public Builder prospectID(Integer prospectID) {
            instance.setProspectID(prospectID);
            return this;
        }

        public Builder validTo(java.time.LocalDateTime validTo) {
            instance.setValidTo(validTo);
            return this;
        }

        public Builder procFee(java.math.BigDecimal procFee) {
            instance.setProcFee(procFee);
            return this;
        }

        public Builder procFeeGst(java.math.BigDecimal procFeeGst) {
            instance.setProcFeeGst(procFeeGst);
            return this;
        }

        public Builder alreadyCollected(java.math.BigDecimal alreadyCollected) {
            instance.setAlreadyCollected(alreadyCollected);
            return this;
        }

        public Builder alreadyCollectedGst(java.math.BigDecimal alreadyCollectedGst) {
            instance.setAlreadyCollectedGst(alreadyCollectedGst);
            return this;
        }

        public Builder balCollected(java.math.BigDecimal balCollected) {
            instance.setBalCollected(balCollected);
            return this;
        }

        public Builder balCollectedGst(java.math.BigDecimal balCollectedGst) {
            instance.setBalCollectedGst(balCollectedGst);
            return this;
        }

        public Builder adminChrgs(java.math.BigDecimal adminChrgs) {
            instance.setAdminChrgs(adminChrgs);
            return this;
        }

        public Builder adminChrgsGst(java.math.BigDecimal adminChrgsGst) {
            instance.setAdminChrgsGst(adminChrgsGst);
            return this;
        }

        public Builder technicalFees(java.math.BigDecimal technicalFees) {
            instance.setTechnicalFees(technicalFees);
            return this;
        }

        public Builder technicalFeesGst(java.math.BigDecimal technicalFeesGst) {
            instance.setTechnicalFeesGst(technicalFeesGst);
            return this;
        }

        public Builder nextReviewDate(java.time.LocalDateTime nextReviewDate) {
            instance.setNextReviewDate(nextReviewDate);
            return this;
        }

        public Builder lastReviewDate(java.time.LocalDateTime lastReviewDate) {
            instance.setLastReviewDate(lastReviewDate);
            return this;
        }

        public Builder varLimitApplicable(String varLimitApplicable) {
            instance.setVarLimitApplicable(varLimitApplicable);
            return this;
        }

        public Builder gmlLimitApplicable(String gmlLimitApplicable) {
            instance.setGmlLimitApplicable(gmlLimitApplicable);
            return this;
        }

        public Builder cgtmse(String cgtmse) {
            instance.setCgtmse(cgtmse);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder termLoan(String termLoan) {
            instance.setTermLoan(termLoan);
            return this;
        }

        public Builder sidbi(String sidbi) {
            instance.setSidbi(sidbi);
            return this;
        }

        public Builder ccod(String ccod) {
            instance.setCcod(ccod);
            return this;
        }

        public Builder seasonalAdHoc(String seasonalAdHoc) {
            instance.setSeasonalAdHoc(seasonalAdHoc);
            return this;
        }

        public Builder crnName(String crnName) {
            instance.setCrnName(crnName);
            return this;
        }

        public Builder versionID(Integer versionID) {
            instance.setVersionID(versionID);
            return this;
        }

        public Builder isMasterVersion(Integer isMasterVersion) {
            instance.setIsMasterVersion(isMasterVersion);
            return this;
        }

        public Builder adminCharges(java.math.BigDecimal adminCharges) {
            instance.setAdminCharges(adminCharges);
            return this;
        }

        public Builder adminChargesGst(java.math.BigDecimal adminChargesGst) {
            instance.setAdminChargesGst(adminChargesGst);
            return this;
        }

        public LimitRenewalOffer build() {
            return instance;
        }
    }
}
