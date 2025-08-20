package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdAccountsViewDao;
import com.bsit.codegeneration.record.FgTrdAccountsView;

public class FgTrdAccountsViewRepository {

    private final Jdbi jdbi;

    public FgTrdAccountsViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdAccountsView> getAllFgTrdAccountsViews() {
        return jdbi.withExtension(FgTrdAccountsViewDao.class, fgtrdaccountsviewdao -> fgtrdaccountsviewdao.findAll());
    }

    public Optional<FgTrdAccountsView> getFgTrdAccountsViewById(String id) {
        return jdbi.withExtension(FgTrdAccountsViewDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdAccountsView(FgTrdAccountsView entity) {
        return jdbi.withExtension(FgTrdAccountsViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdAccountsView(FgTrdAccountsView entity) {
        return jdbi.withExtension(FgTrdAccountsViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdAccountsView(String id) {
        jdbi.useExtension(FgTrdAccountsViewDao.class, dao -> dao.delete(id));
    }
}
