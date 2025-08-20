package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;

public class FilmCategoryTest {

    private static final Integer filmid = 10;

    private static final Integer categoryid = 20;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final Category category = null;

    private static final Film film = null;

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        FilmCategory record = new FilmCategory(filmid, categoryid, lastupdate, category, film);
        assertNotNull(record);
        assertEquals(filmid, record.filmID());
        assertEquals(categoryid, record.categoryID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(category, record.category());
        assertEquals(film, record.film());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        FilmCategory record = new FilmCategory.Builder().filmID(filmid).categoryID(categoryid).lastUpdate(lastupdate).category(category).film(film).build();
        assertNotNull(record);
        assertEquals(filmid, record.filmID());
        assertEquals(categoryid, record.categoryID());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(category, record.category());
        assertEquals(film, record.film());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        FilmCategory record1 = new FilmCategory(filmid, categoryid, lastupdate, category, film);
        FilmCategory record2 = new FilmCategory(filmid, categoryid, lastupdate, category, film);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        FilmCategory record = new FilmCategory(filmid, categoryid, lastupdate, category, film);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("FilmCategory"));
    }
}
