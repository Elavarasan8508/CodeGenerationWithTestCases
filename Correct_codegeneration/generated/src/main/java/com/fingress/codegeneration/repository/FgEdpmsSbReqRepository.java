package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEdpmsSbReqDao;
import com.bsit.codegeneration.record.FgEdpmsSbReq;

public class FgEdpmsSbReqRepository {

    private final Jdbi jdbi;

    public FgEdpmsSbReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEdpmsSbReq> getAllFgEdpmsSbReqs() {
        return jdbi.withExtension(FgEdpmsSbReqDao.class, fgedpmssbreqdao -> fgedpmssbreqdao.findAll());
    }

    public Optional<FgEdpmsSbReq> getFgEdpmsSbReqById(String id) {
        return jdbi.withExtension(FgEdpmsSbReqDao.class, dao -> dao.findById(id));
    }

    public String createFgEdpmsSbReq(FgEdpmsSbReq entity) {
        return jdbi.withExtension(FgEdpmsSbReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEdpmsSbReq(FgEdpmsSbReq entity) {
        return jdbi.withExtension(FgEdpmsSbReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEdpmsSbReq(String id) {
        jdbi.useExtension(FgEdpmsSbReqDao.class, dao -> dao.delete(id));
    }
}
