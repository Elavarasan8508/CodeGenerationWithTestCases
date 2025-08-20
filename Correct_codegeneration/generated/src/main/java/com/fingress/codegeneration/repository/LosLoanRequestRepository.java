package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LosLoanRequestDao;
import com.bsit.codegeneration.record.LosLoanRequest;

public class LosLoanRequestRepository {

    private final Jdbi jdbi;

    public LosLoanRequestRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LosLoanRequest> getAllLosLoanRequests() {
        return jdbi.withExtension(LosLoanRequestDao.class, losloanrequestdao -> losloanrequestdao.findAll());
    }

    public Optional<LosLoanRequest> getLosLoanRequestById(String id) {
        return jdbi.withExtension(LosLoanRequestDao.class, dao -> dao.findById(id));
    }

    public String createLosLoanRequest(LosLoanRequest entity) {
        return jdbi.withExtension(LosLoanRequestDao.class, dao -> dao.insert(entity));
    }

    public int updateLosLoanRequest(LosLoanRequest entity) {
        return jdbi.withExtension(LosLoanRequestDao.class, dao -> dao.update(entity));
    }

    public void deleteLosLoanRequest(String id) {
        jdbi.useExtension(LosLoanRequestDao.class, dao -> dao.delete(id));
    }
}
