package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgDocumentTemplate {

    private Integer ID;

    private Integer referenceID;

    private String name;

    private String typeCode;

    private String subTypeCode;

    private Integer isDefault;

    private String purposeCode;

    private String renderTypeCode;

    private String description;

    private String template;

    private String activeCode;

    private String statusCode;

    private String createdOn;

    private java.math.BigDecimal createdBy;

    private String lastUpdatedOn;

    private java.math.BigDecimal lastUpdatedBy;

    private String lastAuthorisedOn;

    private java.math.BigDecimal lastAuthorisedBy;

    private FgDocumentTemplateParty document;

    private List<FgDocumentTemplateParty> fgDocumentTemplatePartyList;

    public FgDocumentTemplate() {
    }

    public FgDocumentTemplate(Integer ID, Integer referenceID, String name, String typeCode, String subTypeCode, Integer isDefault, String purposeCode, String renderTypeCode, String description, String template, String activeCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, FgDocumentTemplateParty document) {
        this.ID = ID;
        this.referenceID = referenceID;
        this.name = name;
        this.typeCode = typeCode;
        this.subTypeCode = subTypeCode;
        this.isDefault = isDefault;
        this.purposeCode = purposeCode;
        this.renderTypeCode = renderTypeCode;
        this.description = description;
        this.template = template;
        this.activeCode = activeCode;
        this.statusCode = statusCode;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastAuthorisedOn = lastAuthorisedOn;
        this.lastAuthorisedBy = lastAuthorisedBy;
        this.document = document;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getRenderTypeCode() {
        return renderTypeCode;
    }

    public void setRenderTypeCode(String renderTypeCode) {
        this.renderTypeCode = renderTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
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

    public FgDocumentTemplateParty getDocument() {
        return document;
    }

    public void setDocument(FgDocumentTemplateParty document) {
        this.document = document;
    }

    public List<FgDocumentTemplateParty> getFgDocumentTemplatePartyList() {
        return fgDocumentTemplatePartyList;
    }

    public void setFgDocumentTemplatePartyList(List<FgDocumentTemplateParty> fgDocumentTemplatePartyList) {
        this.fgDocumentTemplatePartyList = fgDocumentTemplatePartyList;
    }

    public static class Builder {

        private FgDocumentTemplate instance = new FgDocumentTemplate();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder referenceID(Integer referenceID) {
            instance.setReferenceID(referenceID);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
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

        public Builder isDefault(Integer isDefault) {
            instance.setIsDefault(isDefault);
            return this;
        }

        public Builder purposeCode(String purposeCode) {
            instance.setPurposeCode(purposeCode);
            return this;
        }

        public Builder renderTypeCode(String renderTypeCode) {
            instance.setRenderTypeCode(renderTypeCode);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder template(String template) {
            instance.setTemplate(template);
            return this;
        }

        public Builder activeCode(String activeCode) {
            instance.setActiveCode(activeCode);
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

        public Builder document(FgDocumentTemplateParty document) {
            instance.setDocument(document);
            return this;
        }

        public Builder fgDocumentTemplatePartyList(List<FgDocumentTemplateParty> fgDocumentTemplatePartyList) {
            instance.setFgDocumentTemplatePartyList(fgDocumentTemplatePartyList);
            return this;
        }

        public FgDocumentTemplate build() {
            return instance;
        }
    }
}
