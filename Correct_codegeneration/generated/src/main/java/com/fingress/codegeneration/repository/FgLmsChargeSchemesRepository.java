package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgLmsChargeSchemesDao;
import com.bsit.codegeneration.record.FgLmsChargeSchemes;

public class FgLmsChargeSchemesRepository {

    private final Jdbi jdbi;

    public FgLmsChargeSchemesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgLmsChargeSchemes> getAllFgLmsChargeSchemess() {
        return jdbi.withExtension(FgLmsChargeSchemesDao.class, fglmschargeschemesdao -> fglmschargeschemesdao.findAll());
    }

    public Optional<FgLmsChargeSchemes> getFgLmsChargeSchemesById(String id) {
        return jdbi.withExtension(FgLmsChargeSchemesDao.class, dao -> dao.findById(id));
    }

    public String createFgLmsChargeSchemes(FgLmsChargeSchemes entity) {
        return jdbi.withExtension(FgLmsChargeSchemesDao.class, dao -> dao.insert(entity));
    }

    public int updateFgLmsChargeSchemes(FgLmsChargeSchemes entity) {
        return jdbi.withExtension(FgLmsChargeSchemesDao.class, dao -> dao.update(entity));
    }

    public void deleteFgLmsChargeSchemes(String id) {
        jdbi.useExtension(FgLmsChargeSchemesDao.class, dao -> dao.delete(id));
    }
}
