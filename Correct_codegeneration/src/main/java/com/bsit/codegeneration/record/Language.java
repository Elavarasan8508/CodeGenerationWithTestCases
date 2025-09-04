package com.bsit.codegeneration.record;

import java.util.List;

public record Language(Integer languageID, String name, java.time.LocalDateTime lastUpdate, List<Film> films) {

    public static class Builder {

        private Integer languageID;

        private String name;

        private java.time.LocalDateTime lastUpdate;

        private List<Film> films;

        public Builder languageID(Integer languageID) {
            this.languageID = languageID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder films(List<Film> films) {
            this.films = films;
            return this;
        }

        public Language build() {
            return new Language(languageID, name, lastUpdate, films);
        }
    }
}
