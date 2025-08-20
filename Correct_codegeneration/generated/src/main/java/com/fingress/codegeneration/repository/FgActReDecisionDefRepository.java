package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActReDecisionDefDao;
import com.bsit.codegeneration.record.FgActReDecisionDef;

public class FgActReDecisionDefRepository {

    private final Jdbi jdbi;

    public FgActReDecisionDefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActReDecisionDef> getAllFgActReDecisionDefs() {
        return jdbi.withExtension(FgActReDecisionDefDao.class, fgactredecisiondefdao -> fgactredecisiondefdao.findAll());
    }

    public Optional<FgActReDecisionDef> getFgActReDecisionDefById(String id) {
        return jdbi.withExtension(FgActReDecisionDefDao.class, dao -> dao.findById(id));
    }

    public String createFgActReDecisionDef(FgActReDecisionDef entity) {
        return jdbi.withExtension(FgActReDecisionDefDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActReDecisionDef(FgActReDecisionDef entity) {
        return jdbi.withExtension(FgActReDecisionDefDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActReDecisionDef(String id) {
        jdbi.useExtension(FgActReDecisionDefDao.class, dao -> dao.delete(id));
    }
}
