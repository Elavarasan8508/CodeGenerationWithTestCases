package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.FilmCategory;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Category;
import com.bsit.codegeneration.pojo.Film;

public class FilmCategoryTest {

    private static final Integer filmid = 10;

    private static final Integer categoryid = 20;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final Category category = new Category();

    private static final Film film = new Film();

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        FilmCategory obj = new FilmCategory();
        assertNotNull(obj);
        assertNull(obj.getFilmID());
        assertNull(obj.getCategoryID());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCategory());
        assertNull(obj.getFilm());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        FilmCategory obj = new FilmCategory();
        obj.setFilmID(filmid);
        assertEquals(filmid, obj.getFilmID());
        obj.setCategoryID(categoryid);
        assertEquals(categoryid, obj.getCategoryID());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCategory(category);
        assertEquals(category, obj.getCategory());
        obj.setFilm(film);
        assertEquals(film, obj.getFilm());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        FilmCategory obj = new FilmCategory(filmid, categoryid, lastupdate, category, film);
        assertNotNull(obj);
        assertEquals(filmid, obj.getFilmID());
        assertEquals(categoryid, obj.getCategoryID());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(category, obj.getCategory());
        assertEquals(film, obj.getFilm());
    }

    @Test()
    @DisplayName("Should set and get category relationship correctly")
    public void testCategoryRelationship() {
        FilmCategory obj = new FilmCategory();
        Category relatedObj = category;
        obj.setCategory(relatedObj);
        assertSame(relatedObj, obj.getCategory());
    }

    @Test()
    @DisplayName("Should set and get film relationship correctly")
    public void testFilmRelationship() {
        FilmCategory obj = new FilmCategory();
        Film relatedObj = film;
        obj.setFilm(relatedObj);
        assertSame(relatedObj, obj.getFilm());
    }
}
