package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLiquidationReqDao;
import com.bsit.codegeneration.record.FgLiquidationReq;

public class FgLiquidationReqRepository {

    private final Jdbi jdbi;

    public FgLiquidationReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLiquidationReq> getAllFgLiquidationReqs() {
        return jdbi.withExtension(FgLiquidationReqDao.class, fgliquidationreqdao -> fgliquidationreqdao.findAll());
    }

    public Optional<FgLiquidationReq> getFgLiquidationReqById(String id) {
        return jdbi.withExtension(FgLiquidationReqDao.class, dao -> dao.findById(id));
    }

    public String createFgLiquidationReq(FgLiquidationReq entity) {
        return jdbi.withExtension(FgLiquidationReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLiquidationReq(FgLiquidationReq entity) {
        return jdbi.withExtension(FgLiquidationReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLiquidationReq(String id) {
        jdbi.useExtension(FgLiquidationReqDao.class, dao -> dao.delete(id));
    }
}
