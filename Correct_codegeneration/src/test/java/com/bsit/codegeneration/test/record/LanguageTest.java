package com.bsit.codegeneration.test.record;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.bsit.codegeneration.record.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LanguageTest {

    private static final Integer languageid = 10;

    private static final String name = "Test Name 2";

    private static final java.time.LocalDateTime lastupdate = LocalDateTime.of(2023, 3, 3, 10, 30, 0);

    private static final List<Film> films = new ArrayList<>();

    @Test()
    @DisplayName("Should create record with all parameters")
    public void testConstructor() {
        Language record = new Language(languageid, name, lastupdate, films);
        assertNotNull(record);
        assertEquals(languageid, record.languageID());
        assertEquals(name, record.name());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(films, record.films());
    }

    @Test()
    @DisplayName("Should build record using builder pattern")
    public void testBuilder() {
        Language record = new Language.Builder().languageID(languageid).name(name).lastUpdate(lastupdate).films(films).build();
        assertNotNull(record);
        assertEquals(languageid, record.languageID());
        assertEquals(name, record.name());
        assertEquals(lastupdate, record.lastUpdate());
        assertEquals(films, record.films());
    }

    @Test()
    @DisplayName("Should implement equals and hashCode correctly")
    public void testEqualsAndHashCode() {
        Language record1 = new Language(languageid, name, lastupdate, films);
        Language record2 = new Language(languageid, name, lastupdate, films);
        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test()
    @DisplayName("Should have meaningful toString implementation")
    public void testToString() {
        Language record = new Language(languageid, name, lastupdate, films);
        String result = record.toString();
        assertNotNull(result);
        assertTrue(result.contains("Language"));
    }
}
