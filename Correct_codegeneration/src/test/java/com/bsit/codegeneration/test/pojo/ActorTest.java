package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Actor;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.FilmActor;
import com.bsit.codegeneration.pojo.Film;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActorTest {

    private static final Integer actorid = 10;

    private static final String firstname = "Test Name 2";

    private static final String lastname = "Test Name 3";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final FilmActor actor = new FilmActor();

    private static final Film film = new Film();

    private static final List<FilmActor> filmactorlist = new ArrayList<>(Arrays.asList(new FilmActor()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Actor obj = new Actor();
        assertNotNull(obj);
        assertNull(obj.getActorID());
        assertNull(obj.getFirstName());
        assertNull(obj.getLastName());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getActor());
        assertNull(obj.getFilm());
        assertNull(obj.getFilmActorList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Actor obj = new Actor();
        obj.setActorID(actorid);
        assertEquals(actorid, obj.getActorID());
        obj.setFirstName(firstname);
        assertEquals(firstname, obj.getFirstName());
        obj.setLastName(lastname);
        assertEquals(lastname, obj.getLastName());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setActor(actor);
        assertEquals(actor, obj.getActor());
        obj.setFilm(film);
        assertEquals(film, obj.getFilm());
        obj.setFilmActorList(filmactorlist);
        assertEquals(filmactorlist, obj.getFilmActorList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Actor obj = new Actor(actorid, firstname, lastname, lastupdate, actor, film);
        assertNotNull(obj);
        assertEquals(actorid, obj.getActorID());
        assertEquals(firstname, obj.getFirstName());
        assertEquals(lastname, obj.getLastName());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(actor, obj.getActor());
        assertEquals(film, obj.getFilm());
        assertNull(obj.getFilmActorList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Actor obj = new Actor.Builder().actorID(actorid).firstName(firstname).lastName(lastname).lastUpdate(lastupdate).actor(actor).film(film).filmActorList(filmactorlist).build();
        assertNotNull(obj);
        assertEquals(actorid, obj.getActorID());
        assertEquals(firstname, obj.getFirstName());
        assertEquals(lastname, obj.getLastName());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(actor, obj.getActor());
        assertEquals(film, obj.getFilm());
        assertEquals(filmactorlist, obj.getFilmActorList());
    }

    @Test()
    @DisplayName("Should manage filmActorList relationship correctly")
    public void testFilmActorListRelationship() {
        Actor obj = new Actor();
        List<FilmActor> relatedList = filmactorlist;
        obj.setFilmActorList(relatedList);
        assertNotNull(obj.getFilmActorList());
        assertEquals(relatedList, obj.getFilmActorList());
    }
}
