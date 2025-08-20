package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductReqDao;
import com.bsit.codegeneration.record.FgProductReq;

public class FgProductReqRepository {

    private final Jdbi jdbi;

    public FgProductReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductReq> getAllFgProductReqs() {
        return jdbi.withExtension(FgProductReqDao.class, fgproductreqdao -> fgproductreqdao.findAll());
    }

    public Optional<FgProductReq> getFgProductReqById(String id) {
        return jdbi.withExtension(FgProductReqDao.class, dao -> dao.findById(id));
    }

    public String createFgProductReq(FgProductReq entity) {
        return jdbi.withExtension(FgProductReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductReq(FgProductReq entity) {
        return jdbi.withExtension(FgProductReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductReq(String id) {
        jdbi.useExtension(FgProductReqDao.class, dao -> dao.delete(id));
    }
}
