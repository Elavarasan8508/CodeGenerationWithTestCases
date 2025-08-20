package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdPreLoansViewDao;
import com.bsit.codegeneration.record.FgTrdPreLoansView;

public class FgTrdPreLoansViewRepository {

    private final Jdbi jdbi;

    public FgTrdPreLoansViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdPreLoansView> getAllFgTrdPreLoansViews() {
        return jdbi.withExtension(FgTrdPreLoansViewDao.class, fgtrdpreloansviewdao -> fgtrdpreloansviewdao.findAll());
    }

    public Optional<FgTrdPreLoansView> getFgTrdPreLoansViewById(java.time.LocalDateTime id) {
        return jdbi.withExtension(FgTrdPreLoansViewDao.class, dao -> dao.findById(id));
    }

    public java.time.LocalDateTime createFgTrdPreLoansView(FgTrdPreLoansView entity) {
        return jdbi.withExtension(FgTrdPreLoansViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdPreLoansView(FgTrdPreLoansView entity) {
        return jdbi.withExtension(FgTrdPreLoansViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdPreLoansView(java.time.LocalDateTime id) {
        jdbi.useExtension(FgTrdPreLoansViewDao.class, dao -> dao.delete(id));
    }
}
