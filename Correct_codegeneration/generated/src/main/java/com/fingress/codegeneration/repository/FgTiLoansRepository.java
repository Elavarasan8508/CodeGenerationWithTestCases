package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTiLoansDao;
import com.bsit.codegeneration.record.FgTiLoans;

public class FgTiLoansRepository {

    private final Jdbi jdbi;

    public FgTiLoansRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTiLoans> getAllFgTiLoanss() {
        return jdbi.withExtension(FgTiLoansDao.class, fgtiloansdao -> fgtiloansdao.findAll());
    }

    public Optional<FgTiLoans> getFgTiLoansById(Long id) {
        return jdbi.withExtension(FgTiLoansDao.class, dao -> dao.findById(id));
    }

    public Long createFgTiLoans(FgTiLoans entity) {
        return jdbi.withExtension(FgTiLoansDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTiLoans(FgTiLoans entity) {
        return jdbi.withExtension(FgTiLoansDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTiLoans(Long id) {
        jdbi.useExtension(FgTiLoansDao.class, dao -> dao.delete(id));
    }
}
