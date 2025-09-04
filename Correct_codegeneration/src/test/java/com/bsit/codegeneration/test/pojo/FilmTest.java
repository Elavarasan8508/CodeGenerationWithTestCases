package com.bsit.codegeneration.test.pojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.pojo.Film;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.Language;
import com.bsit.codegeneration.pojo.FilmActor;
import com.bsit.codegeneration.pojo.Category;
import com.bsit.codegeneration.pojo.Actor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.pojo.FilmCategory;
import com.bsit.codegeneration.pojo.Inventory;

public class FilmTest {

    private static final Integer filmid = 10;

    private static final String title = "TestValue2";

    private static final String description = "Test description for description";

    private static final Integer releaseyear = 40;

    private static final Integer languageid = 50;

    private static final Integer originallanguageid = 60;

    private static final Integer rentalduration = 70;

    private static final java.math.BigDecimal rentalrate = new BigDecimal("87.92");

    private static final Integer length = 90;

    private static final java.math.BigDecimal replacementcost = new BigDecimal("109.9");

    private static final String rating = "TestValue11";

    private static final String specialfeatures = "TestValue12";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 1, 13, 10, 30, 0);

    private static final Language language = new Language();

    private static final Language originallanguage = new Language();

    private static final FilmActor film = new FilmActor();

    private static final Category category = new Category();

    private static final Actor actor = new Actor();

    private static final List<FilmActor> filmactorlist = new ArrayList<>(Arrays.asList(new FilmActor()));

    private static final List<FilmCategory> filmcategorylist = new ArrayList<>(Arrays.asList(new FilmCategory()));

    private static final List<Inventory> inventorylist = new ArrayList<>(Arrays.asList(new Inventory()));

    @Test()
    @DisplayName("Should create object with default constructor and null/default values")
    public void testDefaultConstructor() {
        Film obj = new Film();
        assertNotNull(obj);
        assertNull(obj.getFilmID());
        assertNull(obj.getTitle());
        assertNull(obj.getDescription());
        assertNull(obj.getReleaseYear());
        assertNull(obj.getLanguageID());
        assertNull(obj.getOriginalLanguageID());
        assertNull(obj.getRentalDuration());
        assertNull(obj.getRentalRate());
        assertNull(obj.getLength());
        assertNull(obj.getReplacementCost());
        assertNull(obj.getRating());
        assertNull(obj.getSpecialFeatures());
        assertNull(obj.getLastUpdate());
        assertNull(obj.getLanguage());
        assertNull(obj.getOriginalLanguage());
        assertNull(obj.getFilm());
        assertNull(obj.getCategory());
        assertNull(obj.getActor());
        assertNull(obj.getFilmActorList());
        assertNull(obj.getFilmCategoryList());
        assertNull(obj.getInventoryList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        Film obj = new Film();
        obj.setFilmID(filmid);
        assertEquals(filmid, obj.getFilmID());
        obj.setTitle(title);
        assertEquals(title, obj.getTitle());
        obj.setDescription(description);
        assertEquals(description, obj.getDescription());
        obj.setReleaseYear(releaseyear);
        assertEquals(releaseyear, obj.getReleaseYear());
        obj.setLanguageID(languageid);
        assertEquals(languageid, obj.getLanguageID());
        obj.setOriginalLanguageID(originallanguageid);
        assertEquals(originallanguageid, obj.getOriginalLanguageID());
        obj.setRentalDuration(rentalduration);
        assertEquals(rentalduration, obj.getRentalDuration());
        obj.setRentalRate(rentalrate);
        assertEquals(rentalrate, obj.getRentalRate());
        obj.setLength(length);
        assertEquals(length, obj.getLength());
        obj.setReplacementCost(replacementcost);
        assertEquals(replacementcost, obj.getReplacementCost());
        obj.setRating(rating);
        assertEquals(rating, obj.getRating());
        obj.setSpecialFeatures(specialfeatures);
        assertEquals(specialfeatures, obj.getSpecialFeatures());
        obj.setLastUpdate(lastupdate);
        assertEquals(lastupdate, obj.getLastUpdate());
        obj.setLanguage(language);
        assertEquals(language, obj.getLanguage());
        obj.setOriginalLanguage(originallanguage);
        assertEquals(originallanguage, obj.getOriginalLanguage());
        obj.setFilm(film);
        assertEquals(film, obj.getFilm());
        obj.setCategory(category);
        assertEquals(category, obj.getCategory());
        obj.setActor(actor);
        assertEquals(actor, obj.getActor());
        obj.setFilmActorList(filmactorlist);
        assertEquals(filmactorlist, obj.getFilmActorList());
        obj.setFilmCategoryList(filmcategorylist);
        assertEquals(filmcategorylist, obj.getFilmCategoryList());
        obj.setInventoryList(inventorylist);
        assertEquals(inventorylist, obj.getInventoryList());
    }

    @Test()
    @DisplayName("Should create object using constructor #1")
    public void testParameterizedConstructor1() {
        Film obj = new Film(filmid, title, description, releaseyear, languageid, originallanguageid, rentalduration, rentalrate, length, replacementcost, rating, specialfeatures, lastupdate, language, originallanguage, film, category, actor);
        assertNotNull(obj);
        assertEquals(filmid, obj.getFilmID());
        assertEquals(title, obj.getTitle());
        assertEquals(description, obj.getDescription());
        assertEquals(releaseyear, obj.getReleaseYear());
        assertEquals(languageid, obj.getLanguageID());
        assertEquals(originallanguageid, obj.getOriginalLanguageID());
        assertEquals(rentalduration, obj.getRentalDuration());
        assertEquals(rentalrate, obj.getRentalRate());
        assertEquals(length, obj.getLength());
        assertEquals(replacementcost, obj.getReplacementCost());
        assertEquals(rating, obj.getRating());
        assertEquals(specialfeatures, obj.getSpecialFeatures());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(language, obj.getLanguage());
        assertEquals(originallanguage, obj.getOriginalLanguage());
        assertEquals(film, obj.getFilm());
        assertEquals(category, obj.getCategory());
        assertEquals(actor, obj.getActor());
        assertNull(obj.getFilmActorList());
        assertNull(obj.getFilmCategoryList());
        assertNull(obj.getInventoryList());
    }

    @Test()
    @DisplayName("Should build object using builder pattern")
    public void testBuilder() {
        Film obj = new Film.Builder().filmID(filmid).title(title).description(description).releaseYear(releaseyear).languageID(languageid).originalLanguageID(originallanguageid).rentalDuration(rentalduration).rentalRate(rentalrate).length(length).replacementCost(replacementcost).rating(rating).specialFeatures(specialfeatures).lastUpdate(lastupdate).language(language).originalLanguage(originallanguage).film(film).category(category).actor(actor).filmActorList(filmactorlist).filmCategoryList(filmcategorylist).inventoryList(inventorylist).build();
        assertNotNull(obj);
        assertEquals(filmid, obj.getFilmID());
        assertEquals(title, obj.getTitle());
        assertEquals(description, obj.getDescription());
        assertEquals(releaseyear, obj.getReleaseYear());
        assertEquals(languageid, obj.getLanguageID());
        assertEquals(originallanguageid, obj.getOriginalLanguageID());
        assertEquals(rentalduration, obj.getRentalDuration());
        assertEquals(rentalrate, obj.getRentalRate());
        assertEquals(length, obj.getLength());
        assertEquals(replacementcost, obj.getReplacementCost());
        assertEquals(rating, obj.getRating());
        assertEquals(specialfeatures, obj.getSpecialFeatures());
        assertEquals(lastupdate, obj.getLastUpdate());
        assertEquals(language, obj.getLanguage());
        assertEquals(originallanguage, obj.getOriginalLanguage());
        assertEquals(film, obj.getFilm());
        assertEquals(category, obj.getCategory());
        assertEquals(actor, obj.getActor());
        assertEquals(filmactorlist, obj.getFilmActorList());
        assertEquals(filmcategorylist, obj.getFilmCategoryList());
        assertEquals(inventorylist, obj.getInventoryList());
    }

    @Test()
    @DisplayName("Should set and get language relationship correctly")
    public void testLanguageRelationship() {
        Film obj = new Film();
        Language relatedObj = language;
        obj.setLanguage(relatedObj);
        assertSame(relatedObj, obj.getLanguage());
    }

    @Test()
    @DisplayName("Should set and get originalLanguage relationship correctly")
    public void testOriginalLanguageRelationship() {
        Film obj = new Film();
        Language relatedObj = originallanguage;
        obj.setOriginalLanguage(relatedObj);
        assertSame(relatedObj, obj.getOriginalLanguage());
    }

    @Test()
    @DisplayName("Should manage filmActorList relationship correctly")
    public void testFilmActorListRelationship() {
        Film obj = new Film();
        List<FilmActor> relatedList = filmactorlist;
        obj.setFilmActorList(relatedList);
        assertNotNull(obj.getFilmActorList());
        assertEquals(relatedList, obj.getFilmActorList());
    }

    @Test()
    @DisplayName("Should manage filmCategoryList relationship correctly")
    public void testFilmCategoryListRelationship() {
        Film obj = new Film();
        List<FilmCategory> relatedList = filmcategorylist;
        obj.setFilmCategoryList(relatedList);
        assertNotNull(obj.getFilmCategoryList());
        assertEquals(relatedList, obj.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should manage inventoryList relationship correctly")
    public void testInventoryListRelationship() {
        Film obj = new Film();
        List<Inventory> relatedList = inventorylist;
        obj.setInventoryList(relatedList);
        assertNotNull(obj.getInventoryList());
        assertEquals(relatedList, obj.getInventoryList());
    }
}
