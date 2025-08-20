package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModRuleDao;
import com.bsit.codegeneration.record.FgModRule;

public class FgModRuleRepository {

    private final Jdbi jdbi;

    public FgModRuleRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModRule> getAllFgModRules() {
        return jdbi.withExtension(FgModRuleDao.class, fgmodruledao -> fgmodruledao.findAll());
    }

    public Optional<FgModRule> getFgModRuleById(String id) {
        return jdbi.withExtension(FgModRuleDao.class, dao -> dao.findById(id));
    }

    public String createFgModRule(FgModRule entity) {
        return jdbi.withExtension(FgModRuleDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModRule(FgModRule entity) {
        return jdbi.withExtension(FgModRuleDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModRule(String id) {
        jdbi.useExtension(FgModRuleDao.class, dao -> dao.delete(id));
    }
}
