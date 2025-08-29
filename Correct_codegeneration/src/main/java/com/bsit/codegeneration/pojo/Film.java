package com.bsit.codegeneration.pojo;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Film {

    private Language language;

    private Language originalLanguage;

    private FilmActor film;

    private Category category;

    private Actor actor;

    private Integer filmID;

    private String title;

    private String description;

    private Integer releaseYear;

    private Integer languageID;

    private Integer originalLanguageID;

    private Integer rentalDuration;

    private java.math.BigDecimal rentalRate;

    private Integer length;

    private java.math.BigDecimal replacementCost;

    private String rating;

    private String specialFeatures;

    private java.time.LocalDateTime lastUpdate;

    private List<FilmActor> filmActorList;

    private List<FilmCategory> filmCategoryList;

    private List<Inventory> inventoryList;

    public Film() {
    }

    public Film(Language language, Language originalLanguage, FilmActor film, Category category, Actor actor, Integer filmID, String title, String description, Integer releaseYear, Integer languageID, Integer originalLanguageID, Integer rentalDuration, java.math.BigDecimal rentalRate, Integer length, java.math.BigDecimal replacementCost, String rating, String specialFeatures, java.time.LocalDateTime lastUpdate) {
        this.language = language;
        this.originalLanguage = originalLanguage;
        this.film = film;
        this.category = category;
        this.actor = actor;
        this.filmID = filmID;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageID = languageID;
        this.originalLanguageID = originalLanguageID;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public FilmActor getFilm() {
        return film;
    }

    public void setFilm(FilmActor film) {
        this.film = film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public Integer getOriginalLanguageID() {
        return originalLanguageID;
    }

    public void setOriginalLanguageID(Integer originalLanguageID) {
        this.originalLanguageID = originalLanguageID;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public java.math.BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(java.math.BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public java.math.BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(java.math.BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<FilmActor> getFilmActorList() {
        return filmActorList;
    }

    public void setFilmActorList(List<FilmActor> filmActorList) {
        this.filmActorList = filmActorList;
    }

    public List<FilmCategory> getFilmCategoryList() {
        return filmCategoryList;
    }

    public void setFilmCategoryList(List<FilmCategory> filmCategoryList) {
        this.filmCategoryList = filmCategoryList;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public static class Builder {

        private Film instance = new Film();

        public Builder language(Language language) {
            instance.setLanguage(language);
            return this;
        }

        public Builder originalLanguage(Language originalLanguage) {
            instance.setOriginalLanguage(originalLanguage);
            return this;
        }

        public Builder film(FilmActor film) {
            instance.setFilm(film);
            return this;
        }

        public Builder category(Category category) {
            instance.setCategory(category);
            return this;
        }

        public Builder actor(Actor actor) {
            instance.setActor(actor);
            return this;
        }

        public Builder filmID(Integer filmID) {
            instance.setFilmID(filmID);
            return this;
        }

        public Builder title(String title) {
            instance.setTitle(title);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder releaseYear(Integer releaseYear) {
            instance.setReleaseYear(releaseYear);
            return this;
        }

        public Builder languageID(Integer languageID) {
            instance.setLanguageID(languageID);
            return this;
        }

        public Builder originalLanguageID(Integer originalLanguageID) {
            instance.setOriginalLanguageID(originalLanguageID);
            return this;
        }

        public Builder rentalDuration(Integer rentalDuration) {
            instance.setRentalDuration(rentalDuration);
            return this;
        }

        public Builder rentalRate(java.math.BigDecimal rentalRate) {
            instance.setRentalRate(rentalRate);
            return this;
        }

        public Builder length(Integer length) {
            instance.setLength(length);
            return this;
        }

        public Builder replacementCost(java.math.BigDecimal replacementCost) {
            instance.setReplacementCost(replacementCost);
            return this;
        }

        public Builder rating(String rating) {
            instance.setRating(rating);
            return this;
        }

        public Builder specialFeatures(String specialFeatures) {
            instance.setSpecialFeatures(specialFeatures);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public Builder filmActorList(List<FilmActor> filmActorList) {
            instance.setFilmActorList(filmActorList);
            return this;
        }

        public Builder filmCategoryList(List<FilmCategory> filmCategoryList) {
            instance.setFilmCategoryList(filmCategoryList);
            return this;
        }

        public Builder inventoryList(List<Inventory> inventoryList) {
            instance.setInventoryList(inventoryList);
            return this;
        }

        public Film build() {
            return instance;
        }
    }
}
