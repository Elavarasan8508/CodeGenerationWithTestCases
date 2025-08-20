package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdSchemeLimitDao;
import com.bsit.codegeneration.record.FgTdSchemeLimit;

public class FgTdSchemeLimitRepository {

    private final Jdbi jdbi;

    public FgTdSchemeLimitRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdSchemeLimit> getAllFgTdSchemeLimits() {
        return jdbi.withExtension(FgTdSchemeLimitDao.class, fgtdschemelimitdao -> fgtdschemelimitdao.findAll());
    }

    public Optional<FgTdSchemeLimit> getFgTdSchemeLimitById(String id) {
        return jdbi.withExtension(FgTdSchemeLimitDao.class, dao -> dao.findById(id));
    }

    public String createFgTdSchemeLimit(FgTdSchemeLimit entity) {
        return jdbi.withExtension(FgTdSchemeLimitDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdSchemeLimit(FgTdSchemeLimit entity) {
        return jdbi.withExtension(FgTdSchemeLimitDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdSchemeLimit(String id) {
        jdbi.useExtension(FgTdSchemeLimitDao.class, dao -> dao.delete(id));
    }
}
