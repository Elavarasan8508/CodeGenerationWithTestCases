package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class LanguageDTO {

    private Integer languageID;

    private String name;

    private java.time.LocalDateTime lastUpdate;

    private List<FilmDTO> filmList;

    public LanguageDTO() {
    }

    public LanguageDTO(Integer languageID, String name, java.time.LocalDateTime lastUpdate) {
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

    public List<FilmDTO> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<FilmDTO> filmList) {
        this.filmList = filmList;
    }

    public static class Builder {

        private LanguageDTO instance = new LanguageDTO();

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

        public Builder filmList(List<FilmDTO> filmList) {
            instance.setFilmList(filmList);
            return this;
        }

        public LanguageDTO build() {
            return instance;
        }
    }
}
