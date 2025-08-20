package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRuleSetsDao;
import com.bsit.codegeneration.record.FgRuleSets;

public class FgRuleSetsRepository {

    private final Jdbi jdbi;

    public FgRuleSetsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRuleSets> getAllFgRuleSetss() {
        return jdbi.withExtension(FgRuleSetsDao.class, fgrulesetsdao -> fgrulesetsdao.findAll());
    }

    public Optional<FgRuleSets> getFgRuleSetsById(String id) {
        return jdbi.withExtension(FgRuleSetsDao.class, dao -> dao.findById(id));
    }

    public String createFgRuleSets(FgRuleSets entity) {
        return jdbi.withExtension(FgRuleSetsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRuleSets(FgRuleSets entity) {
        return jdbi.withExtension(FgRuleSetsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRuleSets(String id) {
        jdbi.useExtension(FgRuleSetsDao.class, dao -> dao.delete(id));
    }
}
