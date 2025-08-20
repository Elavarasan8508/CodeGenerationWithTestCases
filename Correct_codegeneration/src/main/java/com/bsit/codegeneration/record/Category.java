package com.bsit.codegeneration.record;

import java.util.List;

public record Category(Integer categoryID, String name, java.time.LocalDateTime lastUpdate, List<FilmCategory> filmCategorys, List<Film> films) {

    public static class Builder {

        private Integer categoryID;

        private String name;

        private java.time.LocalDateTime lastUpdate;

        private List<FilmCategory> filmCategorys;

        private List<Film> films;

        public Builder categoryID(Integer categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder filmCategorys(List<FilmCategory> filmCategorys) {
            this.filmCategorys = filmCategorys;
            return this;
        }

        public Builder films(List<Film> films) {
            this.films = films;
            return this;
        }

        public Category build() {
            return new Category(categoryID, name, lastUpdate, filmCategorys, films);
        }
    }
}
