package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class FilmDTO {

    private LanguageDTO language;

    private LanguageDTO originalLanguage;

    private FilmActorDTO film;

    private CategoryDTO category;

    private ActorDTO actor;

    private Integer filmID;

    private String title;

    private String description;

    private String releaseYear;

    private Integer languageID;

    private Integer originalLanguageID;

    private String rentalDuration;

    private Float rentalRate;

    private String length;

    private Float replacementCost;

    private String rating;

    private String specialFeatures;

    private java.time.LocalDateTime lastUpdate;

    private List<FilmActorDTO> filmActorList;

    private List<FilmCategoryDTO> filmCategoryList;

    private List<InventoryDTO> inventoryList;

    public FilmDTO() {
    }

    public FilmDTO(LanguageDTO language, LanguageDTO originalLanguage, FilmActorDTO film, CategoryDTO category, ActorDTO actor, Integer filmID, String title, String description, String releaseYear, Integer languageID, Integer originalLanguageID, String rentalDuration, Float rentalRate, String length, Float replacementCost, String rating, String specialFeatures, java.time.LocalDateTime lastUpdate) {
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

    public LanguageDTO getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }

    public LanguageDTO getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(LanguageDTO originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public FilmActorDTO getFilm() {
        return film;
    }

    public void setFilm(FilmActorDTO film) {
        this.film = film;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public ActorDTO getActor() {
        return actor;
    }

    public void setActor(ActorDTO actor) {
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
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

    public String getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(String rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Float replacementCost) {
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

    public List<FilmActorDTO> getFilmActorList() {
        return filmActorList;
    }

    public void setFilmActorList(List<FilmActorDTO> filmActorList) {
        this.filmActorList = filmActorList;
    }

    public List<FilmCategoryDTO> getFilmCategoryList() {
        return filmCategoryList;
    }

    public void setFilmCategoryList(List<FilmCategoryDTO> filmCategoryList) {
        this.filmCategoryList = filmCategoryList;
    }

    public List<InventoryDTO> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<InventoryDTO> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public static class Builder {

        private FilmDTO instance = new FilmDTO();

        public Builder language(LanguageDTO language) {
            instance.setLanguage(language);
            return this;
        }

        public Builder originalLanguage(LanguageDTO originalLanguage) {
            instance.setOriginalLanguage(originalLanguage);
            return this;
        }

        public Builder film(FilmActorDTO film) {
            instance.setFilm(film);
            return this;
        }

        public Builder category(CategoryDTO category) {
            instance.setCategory(category);
            return this;
        }

        public Builder actor(ActorDTO actor) {
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

        public Builder releaseYear(String releaseYear) {
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

        public Builder rentalDuration(String rentalDuration) {
            instance.setRentalDuration(rentalDuration);
            return this;
        }

        public Builder rentalRate(Float rentalRate) {
            instance.setRentalRate(rentalRate);
            return this;
        }

        public Builder length(String length) {
            instance.setLength(length);
            return this;
        }

        public Builder replacementCost(Float replacementCost) {
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

        public Builder filmActorList(List<FilmActorDTO> filmActorList) {
            instance.setFilmActorList(filmActorList);
            return this;
        }

        public Builder filmCategoryList(List<FilmCategoryDTO> filmCategoryList) {
            instance.setFilmCategoryList(filmCategoryList);
            return this;
        }

        public Builder inventoryList(List<InventoryDTO> inventoryList) {
            instance.setInventoryList(inventoryList);
            return this;
        }

        public FilmDTO build() {
            return instance;
        }
    }
}
