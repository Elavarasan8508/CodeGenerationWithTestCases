package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRuleAlsDao;
import com.bsit.codegeneration.record.FgRuleAls;

public class FgRuleAlsRepository {

    private final Jdbi jdbi;

    public FgRuleAlsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRuleAls> getAllFgRuleAlss() {
        return jdbi.withExtension(FgRuleAlsDao.class, fgrulealsdao -> fgrulealsdao.findAll());
    }

    public Optional<FgRuleAls> getFgRuleAlsById(String id) {
        return jdbi.withExtension(FgRuleAlsDao.class, dao -> dao.findById(id));
    }

    public String createFgRuleAls(FgRuleAls entity) {
        return jdbi.withExtension(FgRuleAlsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRuleAls(FgRuleAls entity) {
        return jdbi.withExtension(FgRuleAlsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRuleAls(String id) {
        jdbi.useExtension(FgRuleAlsDao.class, dao -> dao.delete(id));
    }
}
