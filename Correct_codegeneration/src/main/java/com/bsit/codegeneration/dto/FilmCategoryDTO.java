package com.bsit.codegeneration.dto;

import java.time.LocalDateTime;

public class FilmCategoryDTO {

    private CategoryDTO category;

    private FilmDTO film;

    private Integer filmID;

    private Integer categoryID;

    private java.time.LocalDateTime lastUpdate;

    public FilmCategoryDTO() {
    }

    public FilmCategoryDTO(CategoryDTO category, FilmDTO film, Integer filmID, Integer categoryID, java.time.LocalDateTime lastUpdate) {
        this.category = category;
        this.film = film;
        this.filmID = filmID;
        this.categoryID = categoryID;
        this.lastUpdate = lastUpdate;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
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

        private FilmCategoryDTO instance = new FilmCategoryDTO();

        public Builder category(CategoryDTO category) {
            instance.setCategory(category);
            return this;
        }

        public Builder film(FilmDTO film) {
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

        public FilmCategoryDTO build() {
            return instance;
        }
    }
}
