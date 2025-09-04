package com.bsit.codegeneration.record;

import java.util.List;

public record Film(Integer filmID, String title, String description, String releaseYear, Integer languageID, Integer originalLanguageID, String rentalDuration, Long rentalRate, String length, Long replacementCost, String rating, String specialFeatures, java.time.LocalDateTime lastUpdate, Language language, List<FilmActor> filmActors, List<FilmCategory> filmCategorys, List<Inventory> inventorys, List<Category> categorys, List<Actor> actors) {

    public static class Builder {

        private Integer filmID;

        private String title;

        private String description;

        private String releaseYear;

        private Integer languageID;

        private Integer originalLanguageID;

        private String rentalDuration;

        private Long rentalRate;

        private String length;

        private Long replacementCost;

        private String rating;

        private String specialFeatures;

        private java.time.LocalDateTime lastUpdate;

        private Language language;

        private List<FilmActor> filmActors;

        private List<FilmCategory> filmCategorys;

        private List<Inventory> inventorys;

        private List<Category> categorys;

        private List<Actor> actors;

        public Builder filmID(Integer filmID) {
            this.filmID = filmID;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder releaseYear(String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder languageID(Integer languageID) {
            this.languageID = languageID;
            return this;
        }

        public Builder originalLanguageID(Integer originalLanguageID) {
            this.originalLanguageID = originalLanguageID;
            return this;
        }

        public Builder rentalDuration(String rentalDuration) {
            this.rentalDuration = rentalDuration;
            return this;
        }

        public Builder rentalRate(Long rentalRate) {
            this.rentalRate = rentalRate;
            return this;
        }

        public Builder length(String length) {
            this.length = length;
            return this;
        }

        public Builder replacementCost(Long replacementCost) {
            this.replacementCost = replacementCost;
            return this;
        }

        public Builder rating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder specialFeatures(String specialFeatures) {
            this.specialFeatures = specialFeatures;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder filmActors(List<FilmActor> filmActors) {
            this.filmActors = filmActors;
            return this;
        }

        public Builder filmCategorys(List<FilmCategory> filmCategorys) {
            this.filmCategorys = filmCategorys;
            return this;
        }

        public Builder inventorys(List<Inventory> inventorys) {
            this.inventorys = inventorys;
            return this;
        }

        public Builder categorys(List<Category> categorys) {
            this.categorys = categorys;
            return this;
        }

        public Builder actors(List<Actor> actors) {
            this.actors = actors;
            return this;
        }

        public Film build() {
            return new Film(filmID, title, description, releaseYear, languageID, originalLanguageID, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate, language, filmActors, filmCategorys, inventorys, categorys, actors);
        }
    }
}
