package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdSchemeCodesMasterDao;
import com.bsit.codegeneration.record.FgTdSchemeCodesMaster;

public class FgTdSchemeCodesMasterRepository {

    private final Jdbi jdbi;

    public FgTdSchemeCodesMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdSchemeCodesMaster> getAllFgTdSchemeCodesMasters() {
        return jdbi.withExtension(FgTdSchemeCodesMasterDao.class, fgtdschemecodesmasterdao -> fgtdschemecodesmasterdao.findAll());
    }

    public Optional<FgTdSchemeCodesMaster> getFgTdSchemeCodesMasterById(String id) {
        return jdbi.withExtension(FgTdSchemeCodesMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgTdSchemeCodesMaster(FgTdSchemeCodesMaster entity) {
        return jdbi.withExtension(FgTdSchemeCodesMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdSchemeCodesMaster(FgTdSchemeCodesMaster entity) {
        return jdbi.withExtension(FgTdSchemeCodesMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdSchemeCodesMaster(String id) {
        jdbi.useExtension(FgTdSchemeCodesMasterDao.class, dao -> dao.delete(id));
    }
}
