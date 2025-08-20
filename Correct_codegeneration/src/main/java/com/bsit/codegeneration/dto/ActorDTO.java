package com.bsit.codegeneration.dto;

import java.util.List;
import java.time.LocalDateTime;

public class ActorDTO {

    private FilmActorDTO actor;

    private FilmDTO film;

    private Integer actorID;

    private String firstName;

    private String lastName;

    private java.time.LocalDateTime lastUpdate;

    private List<FilmActorDTO> filmActorList;

    public ActorDTO() {
    }

    public ActorDTO(FilmActorDTO actor, FilmDTO film, Integer actorID, String firstName, String lastName, java.time.LocalDateTime lastUpdate) {
        this.actor = actor;
        this.film = film;
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public FilmActorDTO getActor() {
        return actor;
    }

    public void setActor(FilmActorDTO actor) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public static class Builder {

        private ActorDTO instance = new ActorDTO();

        public Builder actor(FilmActorDTO actor) {
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

        public Builder firstName(String firstName) {
            instance.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            instance.setLastName(lastName);
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

        public ActorDTO build() {
            return instance;
        }
    }
}
