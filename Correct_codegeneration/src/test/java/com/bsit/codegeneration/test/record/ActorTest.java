package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActorTest {

    private static final Integer actorid = 10;

    private static final String firstname = "Test Name 2";

    private static final String lastname = "Test Name 3";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 4, 4, 10, 30, 0);

    private static final List<FilmActor> filmactors = new ArrayList<>();

    private static final List<Film> films = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Actor record = new Actor(actorid, firstname, lastname, lastupdate, filmactors, films);
        assertNotNull(record);
        assertEquals(actorid, record.actorID());
        assertEquals(firstname, record.firstName());
        assertEquals(lastname, record.lastName());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(filmactors, record.filmActors());
        assertEquals(films, record.films());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Actor record = new Actor.Builder().actorID(actorid).firstName(firstname).lastName(lastname).lastUpdate(lastupdate).filmActors(filmactors).films(films).build();
        assertNotNull(record);
        assertEquals(actorid, record.actorID());
        assertEquals(firstname, record.firstName());
        assertEquals(lastname, record.lastName());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(filmactors, record.filmActors());
        assertEquals(films, record.films());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Actor record1 = new Actor(actorid, firstname, lastname, lastupdate, filmactors, films);
        Actor record2 = new Actor(actorid, firstname, lastname, lastupdate, filmactors, films);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Actor record = new Actor(actorid, firstname, lastname, lastupdate, filmactors, films);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Actor"));
    }
}
