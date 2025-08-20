package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdFtViewDao;
import com.bsit.codegeneration.record.FgTrdFtView;

public class FgTrdFtViewRepository {

    private final Jdbi jdbi;

    public FgTrdFtViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdFtView> getAllFgTrdFtViews() {
        return jdbi.withExtension(FgTrdFtViewDao.class, fgtrdftviewdao -> fgtrdftviewdao.findAll());
    }

    public Optional<FgTrdFtView> getFgTrdFtViewById(String id) {
        return jdbi.withExtension(FgTrdFtViewDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdFtView(FgTrdFtView entity) {
        return jdbi.withExtension(FgTrdFtViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdFtView(FgTrdFtView entity) {
        return jdbi.withExtension(FgTrdFtViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdFtView(String id) {
        jdbi.useExtension(FgTrdFtViewDao.class, dao -> dao.delete(id));
    }
}
