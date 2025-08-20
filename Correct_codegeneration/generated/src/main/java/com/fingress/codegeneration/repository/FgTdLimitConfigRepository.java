package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdLimitConfigDao;
import com.bsit.codegeneration.record.FgTdLimitConfig;

public class FgTdLimitConfigRepository {

    private final Jdbi jdbi;

    public FgTdLimitConfigRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdLimitConfig> getAllFgTdLimitConfigs() {
        return jdbi.withExtension(FgTdLimitConfigDao.class, fgtdlimitconfigdao -> fgtdlimitconfigdao.findAll());
    }

    public Optional<FgTdLimitConfig> getFgTdLimitConfigById(String id) {
        return jdbi.withExtension(FgTdLimitConfigDao.class, dao -> dao.findById(id));
    }

    public String createFgTdLimitConfig(FgTdLimitConfig entity) {
        return jdbi.withExtension(FgTdLimitConfigDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdLimitConfig(FgTdLimitConfig entity) {
        return jdbi.withExtension(FgTdLimitConfigDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdLimitConfig(String id) {
        jdbi.useExtension(FgTdLimitConfigDao.class, dao -> dao.delete(id));
    }
}
