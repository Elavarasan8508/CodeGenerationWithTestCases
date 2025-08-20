package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class CategoryDTO {

    private FilmCategoryDTO category;

    private FilmDTO film;

    private Integer categoryID;

    private String name;

    private java.time.LocalDateTime lastUpdate;

    private List<FilmCategoryDTO> filmCategoryList;

    public CategoryDTO() {
    }

    public CategoryDTO(FilmCategoryDTO category, FilmDTO film, Integer categoryID, String name, java.time.LocalDateTime lastUpdate) {
        this.category = category;
        this.film = film;
        this.categoryID = categoryID;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(FilmCategoryDTO category) {
        this.category = category;
    }

    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
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

    public List<FilmCategoryDTO> getFilmCategoryList() {
        return filmCategoryList;
    }

    public void setFilmCategoryList(List<FilmCategoryDTO> filmCategoryList) {
        this.filmCategoryList = filmCategoryList;
    }

    public static class Builder {

        private CategoryDTO instance = new CategoryDTO();

        public Builder category(FilmCategoryDTO category) {
            instance.setCategory(category);
            return this;
        }

        public Builder film(FilmDTO film) {
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

        public Builder filmCategoryList(List<FilmCategoryDTO> filmCategoryList) {
            instance.setFilmCategoryList(filmCategoryList);
            return this;
        }

        public CategoryDTO build() {
            return instance;
        }
    }
}
