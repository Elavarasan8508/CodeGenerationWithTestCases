package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEdpmsFircReqDao;
import com.bsit.codegeneration.record.FgEdpmsFircReq;

public class FgEdpmsFircReqRepository {

    private final Jdbi jdbi;

    public FgEdpmsFircReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEdpmsFircReq> getAllFgEdpmsFircReqs() {
        return jdbi.withExtension(FgEdpmsFircReqDao.class, fgedpmsfircreqdao -> fgedpmsfircreqdao.findAll());
    }

    public Optional<FgEdpmsFircReq> getFgEdpmsFircReqById(String id) {
        return jdbi.withExtension(FgEdpmsFircReqDao.class, dao -> dao.findById(id));
    }

    public String createFgEdpmsFircReq(FgEdpmsFircReq entity) {
        return jdbi.withExtension(FgEdpmsFircReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEdpmsFircReq(FgEdpmsFircReq entity) {
        return jdbi.withExtension(FgEdpmsFircReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEdpmsFircReq(String id) {
        jdbi.useExtension(FgEdpmsFircReqDao.class, dao -> dao.delete(id));
    }
}
