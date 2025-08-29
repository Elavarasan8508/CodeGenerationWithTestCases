package com.bsit.codegeneration.pojo;

import java.time.LocalDateTime;

public class FilmActor {

    private Actor actor;

    private Film film;

    private Integer actorID;

    private Integer filmID;

    private java.time.LocalDateTime lastUpdate;

    public FilmActor() {
    }

    public FilmActor(Actor actor, Film film, Integer actorID, Integer filmID, java.time.LocalDateTime lastUpdate) {
        this.actor = actor;
        this.film = film;
        this.actorID = actorID;
        this.filmID = filmID;
        this.lastUpdate = lastUpdate;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getActorID() {
        return actorID;
    }

    public void setActorID(Integer actorID) {
        this.actorID = actorID;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public java.time.LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.time.LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public static class Builder {

        private FilmActor instance = new FilmActor();

        public Builder actor(Actor actor) {
            instance.setActor(actor);
            return this;
        }

        public Builder film(Film film) {
            instance.setFilm(film);
            return this;
        }

        public Builder actorID(Integer actorID) {
            instance.setActorID(actorID);
            return this;
        }

        public Builder filmID(Integer filmID) {
            instance.setFilmID(filmID);
            return this;
        }

        public Builder lastUpdate(java.time.LocalDateTime lastUpdate) {
            instance.setLastUpdate(lastUpdate);
            return this;
        }

        public FilmActor build() {
            return instance;
        }
    }
}
