package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.CategoryDTO;
import com.bsit.codegeneration.dto.FilmCategoryDTO;
import com.bsit.codegeneration.dto.FilmDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryDTOTest {

    private static final FilmCategoryDTO category = new FilmCategoryDTO();

    private static final FilmDTO film = new FilmDTO();

    private static final Integer categoryid = 30;

    private static final String name = "Test Name 4";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 5, 5, 10, 30, 0);

    private static final List<FilmCategoryDTO> filmcategorylist = new ArrayList<>(Arrays.asList(new FilmCategoryDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        CategoryDTO dto = new CategoryDTO();
        assertNotNull(dto);
        assertNull(dto.getCategory());
        assertNull(dto.getFilm());
        assertNull(dto.getCategoryID());
        assertNull(dto.getName());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategory(category);
        assertEquals(category, dto.getCategory());
        dto.setFilm(film);
        assertEquals(film, dto.getFilm());
        dto.setCategoryID(categoryid);
        assertEquals(categoryid, dto.getCategoryID());
        dto.setName(name);
        assertEquals(name, dto.getName());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setFilmCategoryList(filmcategorylist);
        assertEquals(filmcategorylist, dto.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        CategoryDTO dto = new CategoryDTO(category, film, categoryid, name, lastupdate);
        assertNotNull(dto);
        assertEquals(category, dto.getCategory());
        assertEquals(film, dto.getFilm());
        assertEquals(categoryid, dto.getCategoryID());
        assertEquals(name, dto.getName());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        CategoryDTO dto = new CategoryDTO.Builder().category(category).film(film).categoryID(categoryid).name(name).lastUpdate(lastupdate).filmCategoryList(filmcategorylist).build();
        assertNotNull(dto);
        assertEquals(category, dto.getCategory());
        assertEquals(film, dto.getFilm());
        assertEquals(categoryid, dto.getCategoryID());
        assertEquals(name, dto.getName());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(filmcategorylist, dto.getFilmCategoryList());
    }

    @Test()
    @DisplayName("Should manage filmCategoryList relationship correctly")
    public void testFilmCategoryListRelationship() {
        CategoryDTO dto = new CategoryDTO();
        List<FilmCategoryDTO> relatedList = filmcategorylist;
        dto.setFilmCategoryList(relatedList);
        assertNotNull(dto.getFilmCategoryList());
        assertEquals(relatedList, dto.getFilmCategoryList());
    }
}
