package com.bsit.codegeneration.test.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.dto.LanguageDTO;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.FilmDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageDTOTest {

    private static final Integer languageid = 10;

    private static final String name = "Test Name 2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<FilmDTO> filmlist = new ArrayList<>(Arrays.asList(new FilmDTO()));

    @Test()
    @DisplayName("Should create DTO with default constructor and null/default values")
    public void testDefaultConstructor() {
        LanguageDTO dto = new LanguageDTO();
        assertNotNull(dto);
        assertNull(dto.getLanguageID());
        assertNull(dto.getName());
        assertNull(dto.getLastUpdate());
        assertNull(dto.getFilmList());
    }

    @Test()
    @DisplayName("Should get and set all properties correctly")
    public void testGettersAndSetters() {
        LanguageDTO dto = new LanguageDTO();
        dto.setLanguageID(languageid);
        assertEquals(languageid, dto.getLanguageID());
        dto.setName(name);
        assertEquals(name, dto.getName());
        dto.setLastUpdate(lastupdate);
        assertEquals(lastupdate, dto.getLastUpdate());
        dto.setFilmList(filmlist);
        assertEquals(filmlist, dto.getFilmList());
    }

    @Test()
    @DisplayName("Should create DTO using constructor #1")
    public void testParameterizedConstructor() {
        LanguageDTO dto = new LanguageDTO(languageid, name, lastupdate);
        assertNotNull(dto);
        assertEquals(languageid, dto.getLanguageID());
        assertEquals(name, dto.getName());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertNull(dto.getFilmList());
    }

    @Test()
    @DisplayName("Should build DTO using builder pattern")
    public void testBuilder() {
        LanguageDTO dto = new LanguageDTO.Builder().languageID(languageid).name(name).lastUpdate(lastupdate).filmList(filmlist).build();
        assertNotNull(dto);
        assertEquals(languageid, dto.getLanguageID());
        assertEquals(name, dto.getName());
        assertEquals(lastupdate, dto.getLastUpdate());
        assertEquals(filmlist, dto.getFilmList());
    }

    @Test()
    @DisplayName("Should manage filmList relationship correctly")
    public void testFilmListRelationship() {
        LanguageDTO dto = new LanguageDTO();
        List<FilmDTO> relatedList = filmlist;
        dto.setFilmList(relatedList);
        assertNotNull(dto.getFilmList());
        assertEquals(relatedList, dto.getFilmList());
    }
}
