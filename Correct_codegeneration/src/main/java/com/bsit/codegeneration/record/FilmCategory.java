package com.bsit.codegeneration.record;

import java.util.List;

public record FilmCategory(Integer filmID, Integer categoryID, java.time.LocalDateTime lastUpdate, Category category, Film film) {

    public static class Builder {

        private Integer filmID;

        private Integer categoryID;

        private java.time.LocalDateTime lastUpdate;

        private Category category;

        private Film film;

        public Builder filmID(Integer filmID) {
            this.filmID = filmID;
            return this;
        }

        public Builder categoryID(Integer categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder film(Film film) {
            this.film = film;
            return this;
        }

        public FilmCategory build() {
            return new FilmCategory(filmID, categoryID, lastUpdate, category, film);
        }
    }
}
