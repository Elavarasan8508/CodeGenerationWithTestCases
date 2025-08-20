package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.ActorDTO;
import com.bsit.codegeneration.dto.FilmActorDTO;
import com.bsit.codegeneration.dto.FilmDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActorDTOTest {

    private static final FilmActorDTO actor = new FilmActorDTO();

    private static final FilmDTO film = new FilmDTO();

    private static final Integer actorid = 30;

    private static final String firstname = "Test Name 4";

    private static final String lastname = "Test Name 5";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 6, 6, 10, 30, 0);

    private static final List<FilmActorDTO> filmactorlist = new ArrayList<>(Arrays.asList(new FilmActorDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        ActorDTO dto = new ActorDTO();
        assertNotNull(dto);
        assertNull(dto.getActor());
        assertNull(dto.getFilm());
        assertNull(dto.getActorID());
        assertNull(dto.getFirstName());
        assertNull(dto.getLastName());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getFilmActorList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        ActorDTO dto = new ActorDTO();
        dto.setActor(actor);
        assertEquals(actor, dto.getActor());
        dto.setFilm(film);
        assertEquals(film, dto.getFilm());
        dto.setActorID(actorid);
        assertEquals(actorid, dto.getActorID());
        dto.setFirstName(firstname);
        assertEquals(firstname, dto.getFirstName());
        dto.setLastName(lastname);
        assertEquals(lastname, dto.getLastName());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setFilmActorList(filmactorlist);
        assertEquals(filmactorlist, dto.getFilmActorList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        ActorDTO dto = new ActorDTO(actor, film, actorid, firstname, lastname, lastupdate);
        assertNotNull(dto);
        assertEquals(actor, dto.getActor());
        assertEquals(film, dto.getFilm());
        assertEquals(actorid, dto.getActorID());
        assertEquals(firstname, dto.getFirstName());
        assertEquals(lastname, dto.getLastName());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getFilmActorList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        ActorDTO dto = new ActorDTO.Builder().actor(actor).film(film).actorID(actorid).firstName(firstname).lastName(lastname).lastUpdate(lastupdate).filmActorList(filmactorlist).build();
        assertNotNull(dto);
        assertEquals(actor, dto.getActor());
        assertEquals(film, dto.getFilm());
        assertEquals(actorid, dto.getActorID());
        assertEquals(firstname, dto.getFirstName());
        assertEquals(lastname, dto.getLastName());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(filmactorlist, dto.getFilmActorList());
    }

    @Test()
    @DisplayName("Should manage filmActorList relationship correctly")
    public void testFilmActorListRelationship() {
        ActorDTO dto = new ActorDTO();
        List<FilmActorDTO> relatedList = filmactorlist;
        dto.setFilmActorList(relatedList);
        assertNotNull(dto.getFilmActorList());
        assertEquals(relatedList, dto.getFilmActorList());
    }
}
