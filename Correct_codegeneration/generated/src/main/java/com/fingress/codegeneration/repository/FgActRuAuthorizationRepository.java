package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuAuthorizationDao;
import com.bsit.codegeneration.record.FgActRuAuthorization;

public class FgActRuAuthorizationRepository {

    private final Jdbi jdbi;

    public FgActRuAuthorizationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuAuthorization> getAllFgActRuAuthorizations() {
        return jdbi.withExtension(FgActRuAuthorizationDao.class, fgactruauthorizationdao -> fgactruauthorizationdao.findAll());
    }

    public Optional<FgActRuAuthorization> getFgActRuAuthorizationById(String id) {
        return jdbi.withExtension(FgActRuAuthorizationDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuAuthorization(FgActRuAuthorization entity) {
        return jdbi.withExtension(FgActRuAuthorizationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuAuthorization(FgActRuAuthorization entity) {
        return jdbi.withExtension(FgActRuAuthorizationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuAuthorization(String id) {
        jdbi.useExtension(FgActRuAuthorizationDao.class, dao -> dao.delete(id));
    }
}
