package com.bsit.codegeneration.record;

import java.util.List;

public record FilmActor(Integer actorID, Integer filmID, java.time.LocalDateTime lastUpdate, Actor actor, Film film) {

    public static class Builder {

        private Integer actorID;

        private Integer filmID;

        private java.time.LocalDateTime lastUpdate;

        private Actor actor;

        private Film film;

        public Builder actorID(Integer actorID) {
            this.actorID = actorID;
            return this;
        }

        public Builder filmID(Integer filmID) {
            this.filmID = filmID;
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Builder actor(Actor actor) {
            this.actor = actor;
            return this;
        }

        public Builder film(Film film) {
            this.film = film;
            return this;
        }

        public FilmActor build() {
            return new FilmActor(actorID, filmID, lastUpdate, actor, film);
        }
    }
}
