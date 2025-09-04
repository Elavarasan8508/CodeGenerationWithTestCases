package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.FilmActor;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Actor;
import com.bsit.codegeneration.pojo.Film;

public class FilmActorTest {

    private static final Integer actorid = 10;

    private static final Integer filmid = 20;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final Actor actor = new Actor();

    private static final Film film = new Film();

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        FilmActor obj = new FilmActor();
        assertNotNull(obj);
        assertNull(obj.getActorID());
        assertNull(obj.getFilmID());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getActor());
        assertNull(obj.getFilm());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        FilmActor obj = new FilmActor();
        obj.setActorID(actorid);
        assertEquals(actorid, obj.getActorID());
        obj.setFilmID(filmid);
        assertEquals(filmid, obj.getFilmID());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setActor(actor);
        assertEquals(actor, obj.getActor());
        obj.setFilm(film);
        assertEquals(film, obj.getFilm());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        FilmActor obj = new FilmActor(actorid, filmid, lastupdate, actor, film);
        assertNotNull(obj);
        assertEquals(actorid, obj.getActorID());
        assertEquals(filmid, obj.getFilmID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(actor, obj.getActor());
        assertEquals(film, obj.getFilm());
    }

    @Test()
    @DisplayName("Should set and get actor relationship correctly")
    public void testActorRelationship() {
        FilmActor obj = new FilmActor();
        Actor relatedObj = actor;
        obj.setActor(relatedObj);
        assertSame(relatedObj, obj.getActor());
    }

    @Test()
    @DisplayName("Should set and get film relationship correctly")
    public void testFilmRelationship() {
        FilmActor obj = new FilmActor();
        Film relatedObj = film;
        obj.setFilm(relatedObj);
        assertSame(relatedObj, obj.getFilm());
    }
}
