package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFinanceMasterDao;
import com.bsit.codegeneration.record.FgFinanceMaster;

public class FgFinanceMasterRepository {

    private final Jdbi jdbi;

    public FgFinanceMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFinanceMaster> getAllFgFinanceMasters() {
        return jdbi.withExtension(FgFinanceMasterDao.class, fgfinancemasterdao -> fgfinancemasterdao.findAll());
    }

    public Optional<FgFinanceMaster> getFgFinanceMasterById(String id) {
        return jdbi.withExtension(FgFinanceMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgFinanceMaster(FgFinanceMaster entity) {
        return jdbi.withExtension(FgFinanceMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFinanceMaster(FgFinanceMaster entity) {
        return jdbi.withExtension(FgFinanceMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFinanceMaster(String id) {
        jdbi.useExtension(FgFinanceMasterDao.class, dao -> dao.delete(id));
    }
}
