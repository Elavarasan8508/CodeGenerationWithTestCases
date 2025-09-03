package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgEventNotification {

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

    private Integer entityRefID;

    private Integer entityVersionID;

    private String entityTypeCode;

    private String entitySubTypeCode;

    private String eventType;

    private String eventStatus;

    private String channel;

    private String notificationPurpose;

    private String stages;

    private Integer eventTemplateID;

    private String recipientMobileNumber;

    private String recipientEmailAddress;

    private String sendersEmailAddress;

    private String subject;

    private String content;

    private Long attachments;

    public FgEventNotification() {
    }

    public FgEventNotification(Integer ID, Integer referenceID, String typeCode, String subTypeCode, String activeCode, String stageCode, String statusCode, String createdOn, java.math.BigDecimal createdBy, String lastUpdatedOn, java.math.BigDecimal lastUpdatedBy, String lastAuthorisedOn, java.math.BigDecimal lastAuthorisedBy, String template, Integer isTemplate, Integer entityRefID, Integer entityVersionID, String entityTypeCode, String entitySubTypeCode, String eventType, String eventStatus, String channel, String notificationPurpose, String stages, Integer eventTemplateID, String recipientMobileNumber, String recipientEmailAddress, String sendersEmailAddress, String subject, String content, Long attachments) {
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
        this.entityRefID = entityRefID;
        this.entityVersionID = entityVersionID;
        this.entityTypeCode = entityTypeCode;
        this.entitySubTypeCode = entitySubTypeCode;
        this.eventType = eventType;
        this.eventStatus = eventStatus;
        this.channel = channel;
        this.notificationPurpose = notificationPurpose;
        this.stages = stages;
        this.eventTemplateID = eventTemplateID;
        this.recipientMobileNumber = recipientMobileNumber;
        this.recipientEmailAddress = recipientEmailAddress;
        this.sendersEmailAddress = sendersEmailAddress;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
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

    public Integer getEntityRefID() {
        return entityRefID;
    }

    public void setEntityRefID(Integer entityRefID) {
        this.entityRefID = entityRefID;
    }

    public Integer getEntityVersionID() {
        return entityVersionID;
    }

    public void setEntityVersionID(Integer entityVersionID) {
        this.entityVersionID = entityVersionID;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntitySubTypeCode() {
        return entitySubTypeCode;
    }

    public void setEntitySubTypeCode(String entitySubTypeCode) {
        this.entitySubTypeCode = entitySubTypeCode;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNotificationPurpose() {
        return notificationPurpose;
    }

    public void setNotificationPurpose(String notificationPurpose) {
        this.notificationPurpose = notificationPurpose;
    }

    public String getStages() {
        return stages;
    }

    public void setStages(String stages) {
        this.stages = stages;
    }

    public Integer getEventTemplateID() {
        return eventTemplateID;
    }

    public void setEventTemplateID(Integer eventTemplateID) {
        this.eventTemplateID = eventTemplateID;
    }

    public String getRecipientMobileNumber() {
        return recipientMobileNumber;
    }

    public void setRecipientMobileNumber(String recipientMobileNumber) {
        this.recipientMobileNumber = recipientMobileNumber;
    }

    public String getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public void setRecipientEmailAddress(String recipientEmailAddress) {
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public String getSendersEmailAddress() {
        return sendersEmailAddress;
    }

    public void setSendersEmailAddress(String sendersEmailAddress) {
        this.sendersEmailAddress = sendersEmailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAttachments() {
        return attachments;
    }

    public void setAttachments(Long attachments) {
        this.attachments = attachments;
    }

    public static class Builder {

        private FgEventNotification instance = new FgEventNotification();

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

        public Builder entityRefID(Integer entityRefID) {
            instance.setEntityRefID(entityRefID);
            return this;
        }

        public Builder entityVersionID(Integer entityVersionID) {
            instance.setEntityVersionID(entityVersionID);
            return this;
        }

        public Builder entityTypeCode(String entityTypeCode) {
            instance.setEntityTypeCode(entityTypeCode);
            return this;
        }

        public Builder entitySubTypeCode(String entitySubTypeCode) {
            instance.setEntitySubTypeCode(entitySubTypeCode);
            return this;
        }

        public Builder eventType(String eventType) {
            instance.setEventType(eventType);
            return this;
        }

        public Builder eventStatus(String eventStatus) {
            instance.setEventStatus(eventStatus);
            return this;
        }

        public Builder channel(String channel) {
            instance.setChannel(channel);
            return this;
        }

        public Builder notificationPurpose(String notificationPurpose) {
            instance.setNotificationPurpose(notificationPurpose);
            return this;
        }

        public Builder stages(String stages) {
            instance.setStages(stages);
            return this;
        }

        public Builder eventTemplateID(Integer eventTemplateID) {
            instance.setEventTemplateID(eventTemplateID);
            return this;
        }

        public Builder recipientMobileNumber(String recipientMobileNumber) {
            instance.setRecipientMobileNumber(recipientMobileNumber);
            return this;
        }

        public Builder recipientEmailAddress(String recipientEmailAddress) {
            instance.setRecipientEmailAddress(recipientEmailAddress);
            return this;
        }

        public Builder sendersEmailAddress(String sendersEmailAddress) {
            instance.setSendersEmailAddress(sendersEmailAddress);
            return this;
        }

        public Builder subject(String subject) {
            instance.setSubject(subject);
            return this;
        }

        public Builder content(String content) {
            instance.setContent(content);
            return this;
        }

        public Builder attachments(Long attachments) {
            instance.setAttachments(attachments);
            return this;
        }

        public FgEventNotification build() {
            return instance;
        }
    }
}
