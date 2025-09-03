package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class QrtzSimpropTriggers {

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private String strProp1;

    private String strProp2;

    private String strProp3;

    private Long intProp1;

    private Long intProp2;

    private java.math.BigDecimal longProp1;

    private java.math.BigDecimal longProp2;

    private java.math.BigDecimal decProp1;

    private java.math.BigDecimal decProp2;

    private String boolProp1;

    private String boolProp2;

    private Integer timeZoneID;

    public QrtzSimpropTriggers() {
    }

    public QrtzSimpropTriggers(String schedName, String triggerName, String triggerGroup, String strProp1, String strProp2, String strProp3, Long intProp1, Long intProp2, java.math.BigDecimal longProp1, java.math.BigDecimal longProp2, java.math.BigDecimal decProp1, java.math.BigDecimal decProp2, String boolProp1, String boolProp2, Integer timeZoneID) {
        this.schedName = schedName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.strProp1 = strProp1;
        this.strProp2 = strProp2;
        this.strProp3 = strProp3;
        this.intProp1 = intProp1;
        this.intProp2 = intProp2;
        this.longProp1 = longProp1;
        this.longProp2 = longProp2;
        this.decProp1 = decProp1;
        this.decProp2 = decProp2;
        this.boolProp1 = boolProp1;
        this.boolProp2 = boolProp2;
        this.timeZoneID = timeZoneID;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getStrProp1() {
        return strProp1;
    }

    public void setStrProp1(String strProp1) {
        this.strProp1 = strProp1;
    }

    public String getStrProp2() {
        return strProp2;
    }

    public void setStrProp2(String strProp2) {
        this.strProp2 = strProp2;
    }

    public String getStrProp3() {
        return strProp3;
    }

    public void setStrProp3(String strProp3) {
        this.strProp3 = strProp3;
    }

    public Long getIntProp1() {
        return intProp1;
    }

    public void setIntProp1(Long intProp1) {
        this.intProp1 = intProp1;
    }

    public Long getIntProp2() {
        return intProp2;
    }

    public void setIntProp2(Long intProp2) {
        this.intProp2 = intProp2;
    }

    public java.math.BigDecimal getLongProp1() {
        return longProp1;
    }

    public void setLongProp1(java.math.BigDecimal longProp1) {
        this.longProp1 = longProp1;
    }

    public java.math.BigDecimal getLongProp2() {
        return longProp2;
    }

    public void setLongProp2(java.math.BigDecimal longProp2) {
        this.longProp2 = longProp2;
    }

    public java.math.BigDecimal getDecProp1() {
        return decProp1;
    }

    public void setDecProp1(java.math.BigDecimal decProp1) {
        this.decProp1 = decProp1;
    }

    public java.math.BigDecimal getDecProp2() {
        return decProp2;
    }

    public void setDecProp2(java.math.BigDecimal decProp2) {
        this.decProp2 = decProp2;
    }

    public String getBoolProp1() {
        return boolProp1;
    }

    public void setBoolProp1(String boolProp1) {
        this.boolProp1 = boolProp1;
    }

    public String getBoolProp2() {
        return boolProp2;
    }

    public void setBoolProp2(String boolProp2) {
        this.boolProp2 = boolProp2;
    }

    public Integer getTimeZoneID() {
        return timeZoneID;
    }

    public void setTimeZoneID(Integer timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    public static class Builder {

        private QrtzSimpropTriggers instance = new QrtzSimpropTriggers();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder triggerName(String triggerName) {
            instance.setTriggerName(triggerName);
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            instance.setTriggerGroup(triggerGroup);
            return this;
        }

        public Builder strProp1(String strProp1) {
            instance.setStrProp1(strProp1);
            return this;
        }

        public Builder strProp2(String strProp2) {
            instance.setStrProp2(strProp2);
            return this;
        }

        public Builder strProp3(String strProp3) {
            instance.setStrProp3(strProp3);
            return this;
        }

        public Builder intProp1(Long intProp1) {
            instance.setIntProp1(intProp1);
            return this;
        }

        public Builder intProp2(Long intProp2) {
            instance.setIntProp2(intProp2);
            return this;
        }

        public Builder longProp1(java.math.BigDecimal longProp1) {
            instance.setLongProp1(longProp1);
            return this;
        }

        public Builder longProp2(java.math.BigDecimal longProp2) {
            instance.setLongProp2(longProp2);
            return this;
        }

        public Builder decProp1(java.math.BigDecimal decProp1) {
            instance.setDecProp1(decProp1);
            return this;
        }

        public Builder decProp2(java.math.BigDecimal decProp2) {
            instance.setDecProp2(decProp2);
            return this;
        }

        public Builder boolProp1(String boolProp1) {
            instance.setBoolProp1(boolProp1);
            return this;
        }

        public Builder boolProp2(String boolProp2) {
            instance.setBoolProp2(boolProp2);
            return this;
        }

        public Builder timeZoneID(Integer timeZoneID) {
            instance.setTimeZoneID(timeZoneID);
            return this;
        }

        public QrtzSimpropTriggers build() {
            return instance;
        }
    }
}
