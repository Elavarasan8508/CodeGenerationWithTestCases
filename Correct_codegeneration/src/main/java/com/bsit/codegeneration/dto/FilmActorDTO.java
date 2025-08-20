package com.bsit.codegeneration.dto;

import java.time.LocalDateTime;

public class FilmActorDTO {

    private ActorDTO actor;

    private FilmDTO film;

    private Integer actorID;

    private Integer filmID;

    private java.time.LocalDateTime lastUpdate;

    public FilmActorDTO() {
    }

    public FilmActorDTO(ActorDTO actor, FilmDTO film, Integer actorID, Integer filmID, java.time.LocalDateTime lastUpdate) {
        this.actor = actor;
        this.film = film;
        this.actorID = actorID;
        this.filmID = filmID;
        this.lastUpdate = lastUpdate;
    }

    public ActorDTO getActor() {
        return actor;
    }

    public void setActor(ActorDTO actor) {
        this.actor = actor;
    }

    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
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

        private FilmActorDTO instance = new FilmActorDTO();

        public Builder actor(ActorDTO actor) {
            instance.setActor(actor);
            return this;
        }

        public Builder film(FilmDTO film) {
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

        public FilmActorDTO build() {
            return instance;
        }
    }
}
