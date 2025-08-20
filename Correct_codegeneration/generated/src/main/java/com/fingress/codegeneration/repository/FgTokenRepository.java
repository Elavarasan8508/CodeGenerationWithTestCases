package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTokenDao;
import com.bsit.codegeneration.record.FgToken;

public class FgTokenRepository {

    private final Jdbi jdbi;

    public FgTokenRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgToken> getAllFgTokens() {
        return jdbi.withExtension(FgTokenDao.class, fgtokendao -> fgtokendao.findAll());
    }

    public Optional<FgToken> getFgTokenById(String id) {
        return jdbi.withExtension(FgTokenDao.class, dao -> dao.findById(id));
    }

    public String createFgToken(FgToken entity) {
        return jdbi.withExtension(FgTokenDao.class, dao -> dao.insert(entity));
    }

    public int updateFgToken(FgToken entity) {
        return jdbi.withExtension(FgTokenDao.class, dao -> dao.update(entity));
    }

    public void deleteFgToken(String id) {
        jdbi.useExtension(FgTokenDao.class, dao -> dao.delete(id));
    }
}
