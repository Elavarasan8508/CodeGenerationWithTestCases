package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LosLoanReqEventDao;
import com.bsit.codegeneration.record.LosLoanReqEvent;

public class LosLoanReqEventRepository {

    private final Jdbi jdbi;

    public LosLoanReqEventRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LosLoanReqEvent> getAllLosLoanReqEvents() {
        return jdbi.withExtension(LosLoanReqEventDao.class, losloanreqeventdao -> losloanreqeventdao.findAll());
    }

    public Optional<LosLoanReqEvent> getLosLoanReqEventById(String id) {
        return jdbi.withExtension(LosLoanReqEventDao.class, dao -> dao.findById(id));
    }

    public String createLosLoanReqEvent(LosLoanReqEvent entity) {
        return jdbi.withExtension(LosLoanReqEventDao.class, dao -> dao.insert(entity));
    }

    public int updateLosLoanReqEvent(LosLoanReqEvent entity) {
        return jdbi.withExtension(LosLoanReqEventDao.class, dao -> dao.update(entity));
    }

    public void deleteLosLoanReqEvent(String id) {
        jdbi.useExtension(LosLoanReqEventDao.class, dao -> dao.delete(id));
    }
}
