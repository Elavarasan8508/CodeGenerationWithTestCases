package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.FilmActorDTO;
import com.bsit.codegeneration.dto.ActorDTO;
import com.bsit.codegeneration.dto.FilmDTO;
import java.time.LocalDateTime;

public class FilmActorDTOTest {

    private static final ActorDTO actor = new ActorDTO();

    private static final FilmDTO film = new FilmDTO();

    private static final Integer actorid = 30;

    private static final Integer filmid = 40;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        FilmActorDTO dto = new FilmActorDTO();
        assertNotNull(dto);
        assertNull(dto.getActor());
        assertNull(dto.getFilm());
        assertNull(dto.getActorID());
        assertNull(dto.getFilmID());
        assertNull(dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        FilmActorDTO dto = new FilmActorDTO();
        dto.setActor(actor);
        assertEquals(actor, dto.getActor());
        dto.setFilm(film);
        assertEquals(film, dto.getFilm());
        dto.setActorID(actorid);
        assertEquals(actorid, dto.getActorID());
        dto.setFilmID(filmid);
        assertEquals(filmid, dto.getFilmID());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        FilmActorDTO dto = new FilmActorDTO(actor, film, actorid, filmid, lastupdate);
        assertNotNull(dto);
        assertEquals(actor, dto.getActor());
        assertEquals(film, dto.getFilm());
        assertEquals(actorid, dto.getActorID());
        assertEquals(filmid, dto.getFilmID());
        assertEquals(lastupdate, dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should set and get actor relationship correctly")
    public void testActorRelationship() {
        FilmActorDTO dto = new FilmActorDTO();
        ActorDTO relatedDto = actor;
        dto.setActor(relatedDto);
        assertSame(relatedDto, dto.getActor());
    }

    @Test()
    @DisplayName("Should set and get film relationship correctly")
    public void testFilmRelationship() {
        FilmActorDTO dto = new FilmActorDTO();
        FilmDTO relatedDto = film;
        dto.setFilm(relatedDto);
        assertSame(relatedDto, dto.getFilm());
    }
}
