package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmAlcoMinRateDao;
import com.bsit.codegeneration.record.LmsMdmAlcoMinRate;

public class LmsMdmAlcoMinRateRepository {

    private final Jdbi jdbi;

    public LmsMdmAlcoMinRateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmAlcoMinRate> getAllLmsMdmAlcoMinRates() {
        return jdbi.withExtension(LmsMdmAlcoMinRateDao.class, lmsmdmalcominratedao -> lmsmdmalcominratedao.findAll());
    }

    public Optional<LmsMdmAlcoMinRate> getLmsMdmAlcoMinRateById(String id) {
        return jdbi.withExtension(LmsMdmAlcoMinRateDao.class, dao -> dao.findById(id));
    }

    public String createLmsMdmAlcoMinRate(LmsMdmAlcoMinRate entity) {
        return jdbi.withExtension(LmsMdmAlcoMinRateDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmAlcoMinRate(LmsMdmAlcoMinRate entity) {
        return jdbi.withExtension(LmsMdmAlcoMinRateDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmAlcoMinRate(String id) {
        jdbi.useExtension(LmsMdmAlcoMinRateDao.class, dao -> dao.delete(id));
    }
}
