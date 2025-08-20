package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;

public class FilmActorTest {

    private static final Integer actorid = 10;

    private static final Integer filmid = 20;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final Actor actor = null;

    private static final Film film = null;

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        FilmActor record = new FilmActor(actorid, filmid, lastupdate, actor, film);
        assertNotNull(record);
        assertEquals(actorid, record.actorID());
        assertEquals(filmid, record.filmID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(actor, record.actor());
        assertEquals(film, record.film());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        FilmActor record = new FilmActor.Builder().actorID(actorid).filmID(filmid).lastUpdate(lastupdate).actor(actor).film(film).build();
        assertNotNull(record);
        assertEquals(actorid, record.actorID());
        assertEquals(filmid, record.filmID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(actor, record.actor());
        assertEquals(film, record.film());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        FilmActor record1 = new FilmActor(actorid, filmid, lastupdate, actor, film);
        FilmActor record2 = new FilmActor(actorid, filmid, lastupdate, actor, film);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        FilmActor record = new FilmActor(actorid, filmid, lastupdate, actor, film);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("FilmActor"));
    }
}
