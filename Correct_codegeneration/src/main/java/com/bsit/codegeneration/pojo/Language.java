package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Language {

    private Integer languageID;

    private String name;

    private java.time.LocalDateTime lastUpdate;

    private List<Film> filmList;

    public Language() {
    }

    public Language(Integer languageID, String name, java.time.LocalDateTime lastUpdate) {
        this.languageID = languageID;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public static class Builder {

        private Language instance = new Language();

        public Builder languageID(Integer languageID) {
            instance.setLanguageID(languageID);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder filmList(List<Film> filmList) {
            instance.setFilmList(filmList);
            return this;
        }

        public Language build() {
            return instance;
        }
    }
}
