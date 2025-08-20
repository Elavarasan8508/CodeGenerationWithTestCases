package com.bsit.codegeneration.record;

public record FgLocalization(String locType, String locKey, String locale, String locValue, Long ID) {

    public static class Builder {

        private String locType;

        private String locKey;

        private String locale;

        private String locValue;

        private Long ID;

        public Builder locType(String locType) {
            this.locType = locType;
            return this;
        }

        public Builder locKey(String locKey) {
            this.locKey = locKey;
            return this;
        }

        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder locValue(String locValue) {
            this.locValue = locValue;
            return this;
        }

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public FgLocalization build() {
            return new FgLocalization(locType, locKey, locale, locValue, ID);
        }
    }
}
