package com.bsit.codegeneration.pojo;

import java.time.LocalDateTime;

public class FilmCategory {

    private Category category;

    private Film film;

    private Integer filmID;

    private Integer categoryID;

    private java.time.LocalDateTime lastUpdate;

    public FilmCategory() {
    }

    public FilmCategory(Category category, Film film, Integer filmID, Integer categoryID, java.time.LocalDateTime lastUpdate) {
        this.category = category;
        this.film = film;
        this.filmID = filmID;
        this.categoryID = categoryID;
        this.lastUpdate = lastUpdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public static class Builder {

        private FilmCategory instance = new FilmCategory();

        public Builder category(Category category) {
            instance.setCategory(category);
            return this;
        }

        public Builder film(Film film) {
            instance.setFilm(film);
            return this;
        }

        public Builder filmID(Integer filmID) {
            instance.setFilmID(filmID);
            return this;
        }

        public Builder categoryID(Integer categoryID) {
            instance.setCategoryID(categoryID);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public FilmCategory build() {
            return instance;
        }
    }
}
