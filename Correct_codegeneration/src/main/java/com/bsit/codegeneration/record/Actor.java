package com.bsit.codegeneration.record;

import java.util.List;

public record Actor(Integer actorID, String firstName, String lastName, java.time.LocalDateTime lastUpdate, List<FilmActor> filmActors, List<Film> films) {

    public static class Builder {

        private Integer actorID;

        private String firstName;

        private String lastName;

        private java.time.LocalDateTime lastUpdate;

        private List<FilmActor> filmActors;

        private List<Film> films;

        public Builder actorID(Integer actorID) {
            this.actorID = actorID;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder filmActors(List<FilmActor> filmActors) {
            this.filmActors = filmActors;
            return this;
        }

        public Builder films(List<Film> films) {
            this.films = films;
            return this;
        }

        public Actor build() {
            return new Actor(actorID, firstName, lastName, lastUpdate, filmActors, films);
        }
    }
}
