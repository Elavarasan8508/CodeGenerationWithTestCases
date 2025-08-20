package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdOptionalLimitDao;
import com.bsit.codegeneration.record.FgTdOptionalLimit;

public class FgTdOptionalLimitRepository {

    private final Jdbi jdbi;

    public FgTdOptionalLimitRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdOptionalLimit> getAllFgTdOptionalLimits() {
        return jdbi.withExtension(FgTdOptionalLimitDao.class, fgtdoptionallimitdao -> fgtdoptionallimitdao.findAll());
    }

    public Optional<FgTdOptionalLimit> getFgTdOptionalLimitById(String id) {
        return jdbi.withExtension(FgTdOptionalLimitDao.class, dao -> dao.findById(id));
    }

    public String createFgTdOptionalLimit(FgTdOptionalLimit entity) {
        return jdbi.withExtension(FgTdOptionalLimitDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdOptionalLimit(FgTdOptionalLimit entity) {
        return jdbi.withExtension(FgTdOptionalLimitDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdOptionalLimit(String id) {
        jdbi.useExtension(FgTdOptionalLimitDao.class, dao -> dao.delete(id));
    }
}
