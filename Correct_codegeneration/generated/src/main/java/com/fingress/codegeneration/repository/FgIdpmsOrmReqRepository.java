package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgIdpmsOrmReqDao;
import com.bsit.codegeneration.record.FgIdpmsOrmReq;

public class FgIdpmsOrmReqRepository {

    private final Jdbi jdbi;

    public FgIdpmsOrmReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgIdpmsOrmReq> getAllFgIdpmsOrmReqs() {
        return jdbi.withExtension(FgIdpmsOrmReqDao.class, fgidpmsormreqdao -> fgidpmsormreqdao.findAll());
    }

    public Optional<FgIdpmsOrmReq> getFgIdpmsOrmReqById(String id) {
        return jdbi.withExtension(FgIdpmsOrmReqDao.class, dao -> dao.findById(id));
    }

    public String createFgIdpmsOrmReq(FgIdpmsOrmReq entity) {
        return jdbi.withExtension(FgIdpmsOrmReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgIdpmsOrmReq(FgIdpmsOrmReq entity) {
        return jdbi.withExtension(FgIdpmsOrmReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgIdpmsOrmReq(String id) {
        jdbi.useExtension(FgIdpmsOrmReqDao.class, dao -> dao.delete(id));
    }
}
