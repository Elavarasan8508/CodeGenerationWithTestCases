package com.bsit.codegeneration.pojo;

import java.util.List;
import java.time.LocalDateTime;

public class Category {

    private FilmCategory category;

    private Film film;

    private Integer categoryID;

    private String name;

    private java.time.LocalDateTime lastUpdate;

    private List<FilmCategory> filmCategoryList;

    public Category() {
    }

    public Category(FilmCategory category, Film film, Integer categoryID, String name, java.time.LocalDateTime lastUpdate) {
        this.category = category;
        this.film = film;
        this.categoryID = categoryID;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategory getCategory() {
        return category;
    }

    public void setCategory(FilmCategory category) {
        this.category = category;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
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

    public List<FilmCategory> getFilmCategoryList() {
        return filmCategoryList;
    }

    public void setFilmCategoryList(List<FilmCategory> filmCategoryList) {
        this.filmCategoryList = filmCategoryList;
    }

    public static class Builder {

        private Category instance = new Category();

        public Builder category(FilmCategory category) {
            instance.setCategory(category);
            return this;
        }

        public Builder film(Film film) {
            instance.setFilm(film);
            return this;
        }

        public Builder categoryID(Integer categoryID) {
            instance.setCategoryID(categoryID);
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

        public Builder filmCategoryList(List<FilmCategory> filmCategoryList) {
            instance.setFilmCategoryList(filmCategoryList);
            return this;
        }

        public Category build() {
            return instance;
        }
    }
}
