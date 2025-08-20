package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoryTest {

    private static final Integer categoryid = 10;

    private static final String name = "Test Name 2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<FilmCategory> filmcategorys = new ArrayList<>();

    private static final List<Film> films = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Category record = new Category(categoryid, name, lastupdate, filmcategorys, films);
        assertNotNull(record);
        assertEquals(categoryid, record.categoryID());
        assertEquals(name, record.name());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(filmcategorys, record.filmCategorys());
        assertEquals(films, record.films());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Category record = new Category.Builder().categoryID(categoryid).name(name).lastUpdate(lastupdate).filmCategorys(filmcategorys).films(films).build();
        assertNotNull(record);
        assertEquals(categoryid, record.categoryID());
        assertEquals(name, record.name());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(filmcategorys, record.filmCategorys());
        assertEquals(films, record.films());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Category record1 = new Category(categoryid, name, lastupdate, filmcategorys, films);
        Category record2 = new Category(categoryid, name, lastupdate, filmcategorys, films);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Category record = new Category(categoryid, name, lastupdate, filmcategorys, films);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Category"));
    }
}
