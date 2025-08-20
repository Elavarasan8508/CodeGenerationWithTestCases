package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgEdpmsIrmReqDao;
import com.bsit.codegeneration.record.FgEdpmsIrmReq;

public class FgEdpmsIrmReqRepository {

    private final Jdbi jdbi;

    public FgEdpmsIrmReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgEdpmsIrmReq> getAllFgEdpmsIrmReqs() {
        return jdbi.withExtension(FgEdpmsIrmReqDao.class, fgedpmsirmreqdao -> fgedpmsirmreqdao.findAll());
    }

    public Optional<FgEdpmsIrmReq> getFgEdpmsIrmReqById(String id) {
        return jdbi.withExtension(FgEdpmsIrmReqDao.class, dao -> dao.findById(id));
    }

    public String createFgEdpmsIrmReq(FgEdpmsIrmReq entity) {
        return jdbi.withExtension(FgEdpmsIrmReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgEdpmsIrmReq(FgEdpmsIrmReq entity) {
        return jdbi.withExtension(FgEdpmsIrmReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgEdpmsIrmReq(String id) {
        jdbi.useExtension(FgEdpmsIrmReqDao.class, dao -> dao.delete(id));
    }
}
