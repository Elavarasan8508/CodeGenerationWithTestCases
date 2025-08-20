package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdPreLoansDao;
import com.bsit.codegeneration.record.FgTrdPreLoans;

public class FgTrdPreLoansRepository {

    private final Jdbi jdbi;

    public FgTrdPreLoansRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdPreLoans> getAllFgTrdPreLoanss() {
        return jdbi.withExtension(FgTrdPreLoansDao.class, fgtrdpreloansdao -> fgtrdpreloansdao.findAll());
    }

    public Optional<FgTrdPreLoans> getFgTrdPreLoansById(String id) {
        return jdbi.withExtension(FgTrdPreLoansDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdPreLoans(FgTrdPreLoans entity) {
        return jdbi.withExtension(FgTrdPreLoansDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdPreLoans(FgTrdPreLoans entity) {
        return jdbi.withExtension(FgTrdPreLoansDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdPreLoans(String id) {
        jdbi.useExtension(FgTrdPreLoansDao.class, dao -> dao.delete(id));
    }
}
