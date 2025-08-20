package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdPostLoansViewDao;
import com.bsit.codegeneration.record.FgTrdPostLoansView;

public class FgTrdPostLoansViewRepository {

    private final Jdbi jdbi;

    public FgTrdPostLoansViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdPostLoansView> getAllFgTrdPostLoansViews() {
        return jdbi.withExtension(FgTrdPostLoansViewDao.class, fgtrdpostloansviewdao -> fgtrdpostloansviewdao.findAll());
    }

    public Optional<FgTrdPostLoansView> getFgTrdPostLoansViewById(String id) {
        return jdbi.withExtension(FgTrdPostLoansViewDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdPostLoansView(FgTrdPostLoansView entity) {
        return jdbi.withExtension(FgTrdPostLoansViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdPostLoansView(FgTrdPostLoansView entity) {
        return jdbi.withExtension(FgTrdPostLoansViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdPostLoansView(String id) {
        jdbi.useExtension(FgTrdPostLoansViewDao.class, dao -> dao.delete(id));
    }
}
