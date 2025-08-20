package com.bsit.codegeneration.test.record;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bsit.codegeneration.record.Actor;
import com.bsit.codegeneration.record.Category;
import com.bsit.codegeneration.record.Film;
import com.bsit.codegeneration.record.FilmActor;
import com.bsit.codegeneration.record.FilmCategory;
import com.bsit.codegeneration.record.Inventory;
import com.bsit.codegeneration.record.Language;

public class FilmTest {

    private static final Integer filmid = 10;

    private static final String title = "TestValue2";

    private static final String description = "TestValue3";

    private static final String releaseyear = "TestValue4";

    private static final Integer languageid = 50;

    private static final Integer originallanguageid = 60;

    private static final String rentalduration = "TestValue7";

    private static final Long rentalrate = 800L;

    private static final String length = "TestValue9";

    private static final Long replacementcost = 1000L;

    private static final String rating = "TestValue11";

    private static final String specialfeatures = "TestValue12";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 1, 13, 10, 30, 0);

    private static final Language language = null;

    private static final List<FilmActor> filmactors = new ArrayList<>();

    private static final List<FilmCategory> filmcategorys = new ArrayList<>();

    private static final List<Inventory> inventorys = new ArrayList<>();

    private static final List<Actor> actors = new ArrayList<>();

    private static final List<Category> categorys = new ArrayList<>();


    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Film record = new Film(filmid, title, description, releaseyear, languageid, originallanguageid, rentalduration, rentalrate, length, replacementcost, rating, specialfeatures, lastupdate, language, filmactors, filmcategorys, inventorys, categorys, actors);
        assertNotNull(record);
        assertEquals(filmid, record.filmID());
        assertEquals(title, record.title());
        assertEquals(description, record.description());
        assertEquals(releaseyear, record.releaseYear());
        assertEquals(languageid, record.languageID());
        assertEquals(originallanguageid, record.originalLanguageID());
        assertEquals(rentalduration, record.rentalDuration());
        assertEquals(rentalrate, record.rentalRate());
        assertEquals(length, record.length());
        assertEquals(replacementcost, record.replacementCost());
        assertEquals(rating, record.rating());
        assertEquals(specialfeatures, record.specialFeatures());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(language, record.language());
        assertEquals(filmactors, record.filmActors());
        assertEquals(filmcategorys, record.filmCategorys());
        assertEquals(inventorys, record.inventorys());
        assertEquals(actors, record.actors());
        assertEquals(categorys, record.categorys());
        
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Film record = new Film.Builder().filmID(filmid).title(title).description(description).releaseYear(releaseyear).languageID(languageid).originalLanguageID(originallanguageid).rentalDuration(rentalduration).rentalRate(rentalrate).length(length).replacementCost(replacementcost).rating(rating).specialFeatures(specialfeatures).lastUpdate(lastupdate).language(language).filmActors(filmactors).filmCategorys(filmcategorys).inventorys(inventorys).actors(actors).categorys(categorys).build();
        assertNotNull(record);
        assertEquals(filmid, record.filmID());
        assertEquals(title, record.title());
        assertEquals(description, record.description());
        assertEquals(releaseyear, record.releaseYear());
        assertEquals(languageid, record.languageID());
        assertEquals(originallanguageid, record.originalLanguageID());
        assertEquals(rentalduration, record.rentalDuration());
        assertEquals(rentalrate, record.rentalRate());
        assertEquals(length, record.length());
        assertEquals(replacementcost, record.replacementCost());
        assertEquals(rating, record.rating());
        assertEquals(specialfeatures, record.specialFeatures());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(language, record.language());
        assertEquals(filmactors, record.filmActors());
        assertEquals(filmcategorys, record.filmCategorys());
        assertEquals(inventorys, record.inventorys());
        assertEquals(actors, record.actors());
        assertEquals(categorys, record.categorys());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Film record1 = new Film(filmid, title, description, releaseyear, languageid, originallanguageid, rentalduration, rentalrate, length, replacementcost, rating, specialfeatures, lastupdate, language, filmactors, filmcategorys, inventorys,categorys, actors);
        Film record2 = new Film(filmid, title, description, releaseyear, languageid, originallanguageid, rentalduration, rentalrate, length, replacementcost, rating, specialfeatures, lastupdate, language, filmactors, filmcategorys, inventorys, categorys, actors);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Film record = new Film(filmid, title, description, releaseyear, languageid, originallanguageid, rentalduration, rentalrate, length, replacementcost, rating, specialfeatures, lastupdate, language, filmactors, filmcategorys, inventorys, categorys, actors);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Film"));
    }
}
