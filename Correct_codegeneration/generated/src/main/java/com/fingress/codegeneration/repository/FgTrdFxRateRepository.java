package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdFxRateDao;
import com.bsit.codegeneration.record.FgTrdFxRate;

public class FgTrdFxRateRepository {

    private final Jdbi jdbi;

    public FgTrdFxRateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdFxRate> getAllFgTrdFxRates() {
        return jdbi.withExtension(FgTrdFxRateDao.class, fgtrdfxratedao -> fgtrdfxratedao.findAll());
    }

    public Optional<FgTrdFxRate> getFgTrdFxRateById(String id) {
        return jdbi.withExtension(FgTrdFxRateDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdFxRate(FgTrdFxRate entity) {
        return jdbi.withExtension(FgTrdFxRateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdFxRate(FgTrdFxRate entity) {
        return jdbi.withExtension(FgTrdFxRateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdFxRate(String id) {
        jdbi.useExtension(FgTrdFxRateDao.class, dao -> dao.delete(id));
    }
}
