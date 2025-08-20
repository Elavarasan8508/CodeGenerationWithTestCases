package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdApplFxRateDao;
import com.bsit.codegeneration.record.FgTrdApplFxRate;

public class FgTrdApplFxRateRepository {

    private final Jdbi jdbi;

    public FgTrdApplFxRateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdApplFxRate> getAllFgTrdApplFxRates() {
        return jdbi.withExtension(FgTrdApplFxRateDao.class, fgtrdapplfxratedao -> fgtrdapplfxratedao.findAll());
    }

    public Optional<FgTrdApplFxRate> getFgTrdApplFxRateById(String id) {
        return jdbi.withExtension(FgTrdApplFxRateDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdApplFxRate(FgTrdApplFxRate entity) {
        return jdbi.withExtension(FgTrdApplFxRateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdApplFxRate(FgTrdApplFxRate entity) {
        return jdbi.withExtension(FgTrdApplFxRateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdApplFxRate(String id) {
        jdbi.useExtension(FgTrdApplFxRateDao.class, dao -> dao.delete(id));
    }
}
