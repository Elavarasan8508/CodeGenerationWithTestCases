package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPreferencesDao;
import com.bsit.codegeneration.record.FgPreferences;

public class FgPreferencesRepository {

    private final Jdbi jdbi;

    public FgPreferencesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPreferences> getAllFgPreferencess() {
        return jdbi.withExtension(FgPreferencesDao.class, fgpreferencesdao -> fgpreferencesdao.findAll());
    }

    public Optional<FgPreferences> getFgPreferencesById(String id) {
        return jdbi.withExtension(FgPreferencesDao.class, dao -> dao.findById(id));
    }

    public String createFgPreferences(FgPreferences entity) {
        return jdbi.withExtension(FgPreferencesDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPreferences(FgPreferences entity) {
        return jdbi.withExtension(FgPreferencesDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPreferences(String id) {
        jdbi.useExtension(FgPreferencesDao.class, dao -> dao.delete(id));
    }
}
