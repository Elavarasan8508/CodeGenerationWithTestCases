package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdPostLoansDao;
import com.bsit.codegeneration.record.FgTrdPostLoans;

public class FgTrdPostLoansRepository {

    private final Jdbi jdbi;

    public FgTrdPostLoansRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdPostLoans> getAllFgTrdPostLoanss() {
        return jdbi.withExtension(FgTrdPostLoansDao.class, fgtrdpostloansdao -> fgtrdpostloansdao.findAll());
    }

    public Optional<FgTrdPostLoans> getFgTrdPostLoansById(String id) {
        return jdbi.withExtension(FgTrdPostLoansDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdPostLoans(FgTrdPostLoans entity) {
        return jdbi.withExtension(FgTrdPostLoansDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdPostLoans(FgTrdPostLoans entity) {
        return jdbi.withExtension(FgTrdPostLoansDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdPostLoans(String id) {
        jdbi.useExtension(FgTrdPostLoansDao.class, dao -> dao.delete(id));
    }
}
