package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.FilmCategoryDTO;
import com.bsit.codegeneration.dto.CategoryDTO;
import com.bsit.codegeneration.dto.FilmDTO;
import java.time.LocalDateTime;

public class FilmCategoryDTOTest {

    private static final CategoryDTO category = new CategoryDTO();

    private static final FilmDTO film = new FilmDTO();

    private static final Integer filmid = 30;

    private static final Integer categoryid = 40;

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        FilmCategoryDTO dto = new FilmCategoryDTO();
        assertNotNull(dto);
        assertNull(dto.getCategory());
        assertNull(dto.getFilm());
        assertNull(dto.getFilmID());
        assertNull(dto.getCategoryID());
        assertNull(dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        FilmCategoryDTO dto = new FilmCategoryDTO();
        dto.setCategory(category);
        assertEquals(category, dto.getCategory());
        dto.setFilm(film);
        assertEquals(film, dto.getFilm());
        dto.setFilmID(filmid);
        assertEquals(filmid, dto.getFilmID());
        dto.setCategoryID(categoryid);
        assertEquals(categoryid, dto.getCategoryID());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        FilmCategoryDTO dto = new FilmCategoryDTO(category, film, filmid, categoryid, lastupdate);
        assertNotNull(dto);
        assertEquals(category, dto.getCategory());
        assertEquals(film, dto.getFilm());
        assertEquals(filmid, dto.getFilmID());
        assertEquals(categoryid, dto.getCategoryID());
        assertEquals(lastupdate, dto.getLastUpdate());
    }

    @Test()
    @DisplayName("Should set and get category relationship correctly")
    public void testCategoryRelationship() {
        FilmCategoryDTO dto = new FilmCategoryDTO();
        CategoryDTO relatedDto = category;
        dto.setCategory(relatedDto);
        assertSame(relatedDto, dto.getCategory());
    }

    @Test()
    @DisplayName("Should set and get film relationship correctly")
    public void testFilmRelationship() {
        FilmCategoryDTO dto = new FilmCategoryDTO();
        FilmDTO relatedDto = film;
        dto.setFilm(relatedDto);
        assertSame(relatedDto, dto.getFilm());
    }
}
