package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRulesDao;
import com.bsit.codegeneration.record.FgRules;

public class FgRulesRepository {

    private final Jdbi jdbi;

    public FgRulesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRules> getAllFgRuless() {
        return jdbi.withExtension(FgRulesDao.class, fgrulesdao -> fgrulesdao.findAll());
    }

    public Optional<FgRules> getFgRulesById(String id) {
        return jdbi.withExtension(FgRulesDao.class, dao -> dao.findById(id));
    }

    public String createFgRules(FgRules entity) {
        return jdbi.withExtension(FgRulesDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRules(FgRules entity) {
        return jdbi.withExtension(FgRulesDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRules(String id) {
        jdbi.useExtension(FgRulesDao.class, dao -> dao.delete(id));
    }
}
