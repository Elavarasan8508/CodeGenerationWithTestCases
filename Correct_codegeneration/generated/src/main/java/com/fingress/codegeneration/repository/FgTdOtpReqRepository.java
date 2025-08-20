package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdOtpReqDao;
import com.bsit.codegeneration.record.FgTdOtpReq;

public class FgTdOtpReqRepository {

    private final Jdbi jdbi;

    public FgTdOtpReqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdOtpReq> getAllFgTdOtpReqs() {
        return jdbi.withExtension(FgTdOtpReqDao.class, fgtdotpreqdao -> fgtdotpreqdao.findAll());
    }

    public Optional<FgTdOtpReq> getFgTdOtpReqById(String id) {
        return jdbi.withExtension(FgTdOtpReqDao.class, dao -> dao.findById(id));
    }

    public String createFgTdOtpReq(FgTdOtpReq entity) {
        return jdbi.withExtension(FgTdOtpReqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdOtpReq(FgTdOtpReq entity) {
        return jdbi.withExtension(FgTdOtpReqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdOtpReq(String id) {
        jdbi.useExtension(FgTdOtpReqDao.class, dao -> dao.delete(id));
    }
}
