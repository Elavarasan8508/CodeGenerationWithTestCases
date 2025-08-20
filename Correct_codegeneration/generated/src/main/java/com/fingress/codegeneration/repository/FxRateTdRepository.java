package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FxRateTdDao;
import com.bsit.codegeneration.record.FxRateTd;

public class FxRateTdRepository {

    private final Jdbi jdbi;

    public FxRateTdRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FxRateTd> getAllFxRateTds() {
        return jdbi.withExtension(FxRateTdDao.class, fxratetddao -> fxratetddao.findAll());
    }

    public Optional<FxRateTd> getFxRateTdById(Long id) {
        return jdbi.withExtension(FxRateTdDao.class, dao -> dao.findById(id));
    }

    public Long createFxRateTd(FxRateTd entity) {
        return jdbi.withExtension(FxRateTdDao.class, dao -> dao.insert(entity));
    }

    public int updateFxRateTd(FxRateTd entity) {
        return jdbi.withExtension(FxRateTdDao.class, dao -> dao.update(entity));
    }

    public void deleteFxRateTd(Long id) {
        jdbi.useExtension(FxRateTdDao.class, dao -> dao.delete(id));
    }
}
