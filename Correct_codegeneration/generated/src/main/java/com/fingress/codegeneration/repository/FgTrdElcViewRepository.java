package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdElcViewDao;
import com.bsit.codegeneration.record.FgTrdElcView;

public class FgTrdElcViewRepository {

    private final Jdbi jdbi;

    public FgTrdElcViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdElcView> getAllFgTrdElcViews() {
        return jdbi.withExtension(FgTrdElcViewDao.class, fgtrdelcviewdao -> fgtrdelcviewdao.findAll());
    }

    public Optional<FgTrdElcView> getFgTrdElcViewById(String id) {
        return jdbi.withExtension(FgTrdElcViewDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdElcView(FgTrdElcView entity) {
        return jdbi.withExtension(FgTrdElcViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdElcView(FgTrdElcView entity) {
        return jdbi.withExtension(FgTrdElcViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdElcView(String id) {
        jdbi.useExtension(FgTrdElcViewDao.class, dao -> dao.delete(id));
    }
}
