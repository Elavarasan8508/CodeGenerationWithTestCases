package com.bsit.codegeneration.record;

public record QrtzSimpropTriggers(String schedName, String triggerName, String triggerGroup, String strProp1, String strProp2, String strProp3, Long intProp1, Long intProp2, Long longProp1, Long longProp2, Long decProp1, Long decProp2, String boolProp1, String boolProp2, String timeZoneID) {

    public static class Builder {

        private String schedName;

        private String triggerName;

        private String triggerGroup;

        private String strProp1;

        private String strProp2;

        private String strProp3;

        private Long intProp1;

        private Long intProp2;

        private Long longProp1;

        private Long longProp2;

        private Long decProp1;

        private Long decProp2;

        private String boolProp1;

        private String boolProp2;

        private String timeZoneID;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder triggerName(String triggerName) {
            this.triggerName = triggerName;
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            this.triggerGroup = triggerGroup;
            return this;
        }

        public Builder strProp1(String strProp1) {
            this.strProp1 = strProp1;
            return this;
        }

        public Builder strProp2(String strProp2) {
            this.strProp2 = strProp2;
            return this;
        }

        public Builder strProp3(String strProp3) {
            this.strProp3 = strProp3;
            return this;
        }

        public Builder intProp1(Long intProp1) {
            this.intProp1 = intProp1;
            return this;
        }

        public Builder intProp2(Long intProp2) {
            this.intProp2 = intProp2;
            return this;
        }

        public Builder longProp1(Long longProp1) {
            this.longProp1 = longProp1;
            return this;
        }

        public Builder longProp2(Long longProp2) {
            this.longProp2 = longProp2;
            return this;
        }

        public Builder decProp1(Long decProp1) {
            this.decProp1 = decProp1;
            return this;
        }

        public Builder decProp2(Long decProp2) {
            this.decProp2 = decProp2;
            return this;
        }

        public Builder boolProp1(String boolProp1) {
            this.boolProp1 = boolProp1;
            return this;
        }

        public Builder boolProp2(String boolProp2) {
            this.boolProp2 = boolProp2;
            return this;
        }

        public Builder timeZoneID(String timeZoneID) {
            this.timeZoneID = timeZoneID;
            return this;
        }

        public QrtzSimpropTriggers build() {
            return new QrtzSimpropTriggers(schedName, triggerName, triggerGroup, strProp1, strProp2, strProp3, intProp1, intProp2, longProp1, longProp2, decProp1, decProp2, boolProp1, boolProp2, timeZoneID);
        }
    }
}
