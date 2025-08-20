package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LoanEodStatusDao;
import com.bsit.codegeneration.record.LoanEodStatus;

public class LoanEodStatusRepository {

    private final Jdbi jdbi;

    public LoanEodStatusRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LoanEodStatus> getAllLoanEodStatuss() {
        return jdbi.withExtension(LoanEodStatusDao.class, loaneodstatusdao -> loaneodstatusdao.findAll());
    }

    public Optional<LoanEodStatus> getLoanEodStatusById(String id) {
        return jdbi.withExtension(LoanEodStatusDao.class, dao -> dao.findById(id));
    }

    public String createLoanEodStatus(LoanEodStatus entity) {
        return jdbi.withExtension(LoanEodStatusDao.class, dao -> dao.insert(entity));
    }

    public int updateLoanEodStatus(LoanEodStatus entity) {
        return jdbi.withExtension(LoanEodStatusDao.class, dao -> dao.update(entity));
    }

    public void deleteLoanEodStatus(String id) {
        jdbi.useExtension(LoanEodStatusDao.class, dao -> dao.delete(id));
    }
}
