package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMfaTokenDao;
import com.bsit.codegeneration.record.FgMfaToken;

public class FgMfaTokenRepository {

    private final Jdbi jdbi;

    public FgMfaTokenRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMfaToken> getAllFgMfaTokens() {
        return jdbi.withExtension(FgMfaTokenDao.class, fgmfatokendao -> fgmfatokendao.findAll());
    }

    public Optional<FgMfaToken> getFgMfaTokenById(String id) {
        return jdbi.withExtension(FgMfaTokenDao.class, dao -> dao.findById(id));
    }

    public String createFgMfaToken(FgMfaToken entity) {
        return jdbi.withExtension(FgMfaTokenDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMfaToken(FgMfaToken entity) {
        return jdbi.withExtension(FgMfaTokenDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMfaToken(String id) {
        jdbi.useExtension(FgMfaTokenDao.class, dao -> dao.delete(id));
    }
}
