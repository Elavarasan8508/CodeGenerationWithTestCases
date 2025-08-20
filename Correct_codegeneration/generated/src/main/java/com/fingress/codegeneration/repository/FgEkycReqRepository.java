package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEkycReqDao;
import com.bsit.codegeneration.record.FgEkycReq;

public class FgEkycReqRepository {

    private final Jdbi jdbi;

    public FgEkycReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEkycReq> getAllFgEkycReqs() {
        return jdbi.withExtension(FgEkycReqDao.class, fgekycreqdao -> fgekycreqdao.findAll());
    }

    public Optional<FgEkycReq> getFgEkycReqById(String id) {
        return jdbi.withExtension(FgEkycReqDao.class, dao -> dao.findById(id));
    }

    public String createFgEkycReq(FgEkycReq entity) {
        return jdbi.withExtension(FgEkycReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEkycReq(FgEkycReq entity) {
        return jdbi.withExtension(FgEkycReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEkycReq(String id) {
        jdbi.useExtension(FgEkycReqDao.class, dao -> dao.delete(id));
    }
}
