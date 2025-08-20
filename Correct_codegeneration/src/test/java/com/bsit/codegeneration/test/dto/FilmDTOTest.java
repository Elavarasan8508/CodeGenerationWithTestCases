package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.FilmDTO;
import com.bsit.codegeneration.dto.LanguageDTO;
import com.bsit.codegeneration.dto.FilmActorDTO;
import com.bsit.codegeneration.dto.CategoryDTO;
import com.bsit.codegeneration.dto.ActorDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bsit.codegeneration.dto.FilmCategoryDTO;
import com.bsit.codegeneration.dto.InventoryDTO;

public class FilmDTOTest {

    private static final LanguageDTO language = new LanguageDTO();

    private static final LanguageDTO originallanguage = new LanguageDTO();

    private static final FilmActorDTO film = new FilmActorDTO();

    private static final CategoryDTO category = new CategoryDTO();

    private static final ActorDTO actor = new ActorDTO();

    private static final Integer filmid = 60;

    private static final String title = "TestValue7";

    private static final String description = "Test description for description";

    private static final String releaseyear = "TestValue9";

    private static final Integer languageid = 100;

    private static final Integer originallanguageid = 110;

    private static final String rentalduration = "TestValue12";

    private static final Float rentalrate = 19.5f;

    private static final String length = "TestValue14";

    private static final Float replacementcost = 22.5f;

    private static final String rating = "TestValue16";

    private static final String specialfeatures = "TestValue17";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 6, 18, 10, 30, 0);

    private static final List<FilmActorDTO> filmactorlist = new ArrayList<>(Arrays.asList(new FilmActorDTO()));

    private static final List<FilmCategoryDTO> filmcategorylist = new ArrayList<>(Arrays.asList(new FilmCategoryDTO()));

    private static final List<InventoryDTO> inventorylist = new ArrayList<>(Arrays.asList(new InventoryDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        FilmDTO dto = new FilmDTO();
        assertNotNull(dto);
        assertNull(dto.getLanguage());
        assertNull(dto.getOriginalLanguage());
        assertNull(dto.getFilm());
        assertNull(dto.getCategory());
        assertNull(dto.getActor());
        assertNull(dto.getFilmID());
        assertNull(dto.getTitle());
        assertNull(dto.getDescription());
        assertNull(dto.getReleaseYear());
        assertNull(dto.getLanguageID());
        assertNull(dto.getOriginalLanguageID());
        assertNull(dto.getRentalDuration());
        assertNull(dto.getRentalRate());
        assertNull(dto.getLength());
        assertNull(dto.getReplacementCost());
        assertNull(dto.getRating());
        assertNull(dto.getSpecialFeatures());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getFilmActorList());
        assertNull(dto.getFilmCategoryList());
        assertNull(dto.getInventoryList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        FilmDTO dto = new FilmDTO();
        dto.setLanguage(language);
        assertEquals(language, dto.getLanguage());
        dto.setOriginalLanguage(originallanguage);
        assertEquals(originallanguage, dto.getOriginalLanguage());
        dto.setFilm(film);
        assertEquals(film, dto.getFilm());
        dto.setCategory(category);
        assertEquals(category, dto.getCategory());
        dto.setActor(actor);
        assertEquals(actor, dto.getActor());
        dto.setFilmID(filmid);
        assertEquals(filmid, dto.getFilmID());
        dto.setTitle(title);
        assertEquals(title, dto.getTitle());
        dto.setDescription(description);
        assertEquals(description, dto.getDescription());
        dto.setReleaseYear(releaseyear);
        assertEquals(releaseyear, dto.getReleaseYear());
        dto.setLanguageID(languageid);
        assertEquals(languageid, dto.getLanguageID());
        dto.setOriginalLanguageID(originallanguageid);
        assertEquals(originallanguageid, dto.getOriginalLanguageID());
        dto.setRentalDuration(rentalduration);
        assertEquals(rentalduration, dto.getRentalDuration());
        dto.setRentalRate(rentalrate);
        assertEquals(rentalrate, dto.getRentalRate());
        dto.setLength(length);
        assertEquals(length, dto.getLength());
        dto.setReplacementCost(replacementcost);
        assertEquals(replacementcost, dto.getReplacementCost());
        dto.setRating(rating);
        assertEquals(rating, dto.getRating());
        dto.setSpecialFeatures(specialfeatures);
        assertEquals(specialfeatures, dto.getSpecialFeatures());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setFilmActorList(filmactorlist);
        assertEquals(filmactorlist, dto.getFilmActorList());
        dto.setFilmCategoryList(filmcategorylist);
        assertEquals(filmcategorylist, dto.getFilmCategoryList());
        dto.setInventoryList(inventorylist);
        assertEquals(inventorylist, dto.getInventoryList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        FilmDTO dto = new FilmDTO(language, originallanguage, film, category, actor, filmid, title, description, releaseyear, languageid, originallanguageid, rentalduration, rentalrate, length, replacementcost, rating, specialfeatures, lastupdate);
        assertNotNull(dto);
        assertEquals(language, dto.getLanguage());
        assertEquals(originallanguage, dto.getOriginalLanguage());
        assertEquals(film, dto.getFilm());
        assertEquals(category, dto.getCategory());
        assertEquals(actor, dto.getActor());
        assertEquals(filmid, dto.getFilmID());
        assertEquals(title, dto.getTitle());
        assertEquals(description, dto.getDescription());
        assertEquals(releaseyear, dto.getReleaseYear());
        assertEquals(languageid, dto.getLanguageID());
        assertEquals(originallanguageid, dto.getOriginalLanguageID());
        assertEquals(rentalduration, dto.getRentalDuration());
        assertEquals(rentalrate, dto.getRentalRate());
        assertEquals(length, dto.getLength());
        assertEquals(replacementcost, dto.getReplacementCost());
        assertEquals(rating, dto.getRating());
        assertEquals(specialfeatures, dto.getSpecialFeatures());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getFilmActorList());
        assertNull(dto.getFilmCategoryList());
        assertNull(dto.getInventoryList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        FilmDTO dto = new FilmDTO.Builder().language(language).originalLanguage(originallanguage).film(film).category(category).actor(actor).filmID(filmid).title(title).description(description).releaseYear(releaseyear).languageID(languageid).originalLanguageID(originallanguageid).rentalDuration(rentalduration).rentalRate(rentalrate).length(length).replacementCost(replacementcost).rating(rating).specialFeatures(specialfeatures).lastUpdate(lastupdate).filmActorList(filmactorlist).filmCategoryList(filmcategorylist).inventoryList(inventorylist).build();
        assertNotNull(dto);
        assertEquals(language, dto.getLanguage());
        assertEquals(originallanguage, dto.getOriginalLanguage());
        assertEquals(film, dto.getFilm());
        assertEquals(category, dto.getCategory());
        assertEquals(actor, dto.getActor());
        assertEquals(filmid, dto.getFilmID());
        assertEquals(title, dto.getTitle());
        assertEquals(description, dto.getDescription());
        assertEquals(releaseyear, dto.getReleaseYear());
        assertEquals(languageid, dto.getLanguageID());
        assertEquals(originallanguageid, dto.getOriginalLanguageID());
        assertEquals(rentalduration, dto.getRentalDuration());
        assertEquals(rentalrate, dto.getRentalRate());
        assertEquals(length, dto.getLength());
        assertEquals(replacementcost, dto.getReplacementCost());
        assertEquals(rating, dto.getRating());
        assertEquals(specialfeatures, dto.getSpecialFeatures());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(filmactorlist, dto.getFilmActorList());
        assertEquals(filmcategorylist, dto.getFilmCategoryList());
        assertEquals(inventorylist, dto.getInventoryList());
    }

    @Test()
    @DisplayName("Should set and get language relationship correctly")
    public void testLanguageRelationship() {
        FilmDTO dto = new FilmDTO();
        LanguageDTO relatedDto = language;
        dto.setLanguage(relatedDto);
        assertSame(relatedDto, dto.getLanguage());
    }

    @Test()
    @DisplayName("Should set and get originalLanguage relationship correctly")
    public void testOriginalLanguageRelationship() {
        FilmDTO dto = new FilmDTO();
        LanguageDTO relatedDto = originallanguage;
        dto.setOriginalLanguage(relatedDto);
        assertSame(relatedDto, dto.getOriginalLanguage());
    }

    @Test()
    @DisplayName("Should manage filmActorList relationship correctly")
    public void testFilmActorListRelationship() {
        FilmDTO dto = new FilmDTO();
        List<FilmActorDTO> relatedList = filmactorlist;
        dto.setFilmActorList(relatedList);
        assertNotNull(dto.getFilmActorList());
        assertEquals(relatedList, dto.getFilmActorList());
    }

    @Test()
    @DisplayName("Should manage filmCategoryList relationship correctly")
    public void testFilmCategoryListRelationship() {
        FilmDTO dto = new FilmDTO();
        List<FilmCategoryDTO> relatedList = filmcategorylist;
        dto.setFilmCategoryList(relatedList);
        assertNotNull(dto.getFilmCategoryList());
        assertEquals(relatedList, dto.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should manage inventoryList relationship correctly")
    public void testInventoryListRelationship() {
        FilmDTO dto = new FilmDTO();
        List<InventoryDTO> relatedList = inventorylist;
        dto.setInventoryList(relatedList);
        assertNotNull(dto.getInventoryList());
        assertEquals(relatedList, dto.getInventoryList());
    }
}
