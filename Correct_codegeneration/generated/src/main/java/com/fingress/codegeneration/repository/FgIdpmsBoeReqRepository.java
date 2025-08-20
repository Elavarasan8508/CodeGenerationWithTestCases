package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgIdpmsBoeReqDao;
import com.bsit.codegeneration.record.FgIdpmsBoeReq;

public class FgIdpmsBoeReqRepository {

    private final Jdbi jdbi;

    public FgIdpmsBoeReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgIdpmsBoeReq> getAllFgIdpmsBoeReqs() {
        return jdbi.withExtension(FgIdpmsBoeReqDao.class, fgidpmsboereqdao -> fgidpmsboereqdao.findAll());
    }

    public Optional<FgIdpmsBoeReq> getFgIdpmsBoeReqById(String id) {
        return jdbi.withExtension(FgIdpmsBoeReqDao.class, dao -> dao.findById(id));
    }

    public String createFgIdpmsBoeReq(FgIdpmsBoeReq entity) {
        return jdbi.withExtension(FgIdpmsBoeReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgIdpmsBoeReq(FgIdpmsBoeReq entity) {
        return jdbi.withExtension(FgIdpmsBoeReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgIdpmsBoeReq(String id) {
        jdbi.useExtension(FgIdpmsBoeReqDao.class, dao -> dao.delete(id));
    }
}
