package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTermDepositReqDao;
import com.bsit.codegeneration.record.FgTermDepositReq;

public class FgTermDepositReqRepository {

    private final Jdbi jdbi;

    public FgTermDepositReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTermDepositReq> getAllFgTermDepositReqs() {
        return jdbi.withExtension(FgTermDepositReqDao.class, fgtermdepositreqdao -> fgtermdepositreqdao.findAll());
    }

    public Optional<FgTermDepositReq> getFgTermDepositReqById(String id) {
        return jdbi.withExtension(FgTermDepositReqDao.class, dao -> dao.findById(id));
    }

    public String createFgTermDepositReq(FgTermDepositReq entity) {
        return jdbi.withExtension(FgTermDepositReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTermDepositReq(FgTermDepositReq entity) {
        return jdbi.withExtension(FgTermDepositReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTermDepositReq(String id) {
        jdbi.useExtension(FgTermDepositReqDao.class, dao -> dao.delete(id));
    }
}
