package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Language;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Film;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageTest {

    private static final Integer languageid = 10;

    private static final String name = "Test Name 2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<Film> filmlist = new ArrayList<>(Arrays.asList(new Film()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Language obj = new Language();
        assertNotNull(obj);
        assertNull(obj.getLanguageID());
        assertNull(obj.getName());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getFilmList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Language obj = new Language();
        obj.setLanguageID(languageid);
        assertEquals(languageid, obj.getLanguageID());
        obj.setName(name);
        assertEquals(name, obj.getName());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setFilmList(filmlist);
        assertEquals(filmlist, obj.getFilmList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Language obj = new Language(languageid, name, lastupdate);
        assertNotNull(obj);
        assertEquals(languageid, obj.getLanguageID());
        assertEquals(name, obj.getName());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertNull(obj.getFilmList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Language obj = new Language.Builder().languageID(languageid).name(name).lastUpdate(lastupdate).filmList(filmlist).build();
        assertNotNull(obj);
        assertEquals(languageid, obj.getLanguageID());
        assertEquals(name, obj.getName());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(filmlist, obj.getFilmList());
    }

    @Test()
    @DisplayName("Should manage filmList relationship correctly")
    public void testFilmListRelationship() {
        Language obj = new Language();
        List<Film> relatedList = filmlist;
        obj.setFilmList(relatedList);
        assertNotNull(obj.getFilmList());
        assertEquals(relatedList, obj.getFilmList());
    }
}
