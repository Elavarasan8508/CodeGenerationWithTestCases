package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPreferencesRelationDao;
import com.bsit.codegeneration.record.FgPreferencesRelation;

public class FgPreferencesRelationRepository {

    private final Jdbi jdbi;

    public FgPreferencesRelationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPreferencesRelation> getAllFgPreferencesRelations() {
        return jdbi.withExtension(FgPreferencesRelationDao.class, fgpreferencesrelationdao -> fgpreferencesrelationdao.findAll());
    }

    public Optional<FgPreferencesRelation> getFgPreferencesRelationById(String id) {
        return jdbi.withExtension(FgPreferencesRelationDao.class, dao -> dao.findById(id));
    }

    public String createFgPreferencesRelation(FgPreferencesRelation entity) {
        return jdbi.withExtension(FgPreferencesRelationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPreferencesRelation(FgPreferencesRelation entity) {
        return jdbi.withExtension(FgPreferencesRelationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPreferencesRelation(String id) {
        jdbi.useExtension(FgPreferencesRelationDao.class, dao -> dao.delete(id));
    }
}
