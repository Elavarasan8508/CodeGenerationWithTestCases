package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdLiqViewDao;
import com.bsit.codegeneration.record.FgTdLiqView;

public class FgTdLiqViewRepository {

    private final Jdbi jdbi;

    public FgTdLiqViewRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdLiqView> getAllFgTdLiqViews() {
        return jdbi.withExtension(FgTdLiqViewDao.class, fgtdliqviewdao -> fgtdliqviewdao.findAll());
    }

    public Optional<FgTdLiqView> getFgTdLiqViewById(String id) {
        return jdbi.withExtension(FgTdLiqViewDao.class, dao -> dao.findById(id));
    }

    public String createFgTdLiqView(FgTdLiqView entity) {
        return jdbi.withExtension(FgTdLiqViewDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdLiqView(FgTdLiqView entity) {
        return jdbi.withExtension(FgTdLiqViewDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdLiqView(String id) {
        jdbi.useExtension(FgTdLiqViewDao.class, dao -> dao.delete(id));
    }
}
