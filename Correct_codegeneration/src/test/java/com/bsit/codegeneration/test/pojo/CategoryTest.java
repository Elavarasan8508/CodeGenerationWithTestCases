package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Category;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.FilmCategory;
import com.bsit.codegeneration.pojo.Film;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryTest {

    private static final Integer categoryid = 10;

    private static final String name = "Test Name 2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final FilmCategory category = new FilmCategory();

    private static final Film film = new Film();

    private static final List<FilmCategory> filmcategorylist = new ArrayList<>(Arrays.asList(new FilmCategory()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Category obj = new Category();
        assertNotNull(obj);
        assertNull(obj.getCategoryID());
        assertNull(obj.getName());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getCategory());
        assertNull(obj.getFilm());
        assertNull(obj.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Category obj = new Category();
        obj.setCategoryID(categoryid);
        assertEquals(categoryid, obj.getCategoryID());
        obj.setName(name);
        assertEquals(name, obj.getName());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setCategory(category);
        assertEquals(category, obj.getCategory());
        obj.setFilm(film);
        assertEquals(film, obj.getFilm());
        obj.setFilmCategoryList(filmcategorylist);
        assertEquals(filmcategorylist, obj.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Category obj = new Category(categoryid, name, lastupdate, category, film);
        assertNotNull(obj);
        assertEquals(categoryid, obj.getCategoryID());
        assertEquals(name, obj.getName());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(category, obj.getCategory());
        assertEquals(film, obj.getFilm());
        assertNull(obj.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Category obj = new Category.Builder().categoryID(categoryid).name(name).lastUpdate(lastupdate).category(category).film(film).filmCategoryList(filmcategorylist).build();
        assertNotNull(obj);
        assertEquals(categoryid, obj.getCategoryID());
        assertEquals(name, obj.getName());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(category, obj.getCategory());
        assertEquals(film, obj.getFilm());
        assertEquals(filmcategorylist, obj.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should manage filmCategoryList relationship correctly")
    public void testFilmCategoryListRelationship() {
        Category obj = new Category();
        List<FilmCategory> relatedList = filmcategorylist;
        obj.setFilmCategoryList(relatedList);
        assertNotNull(obj.getFilmCategoryList());
        assertEquals(relatedList, obj.getFilmCategoryList());
    }
}
