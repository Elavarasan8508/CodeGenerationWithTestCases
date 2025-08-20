package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgCurrencyCodeMasterDao;
import com.bsit.codegeneration.record.FgCurrencyCodeMaster;

public class FgCurrencyCodeMasterRepository {

    private final Jdbi jdbi;

    public FgCurrencyCodeMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgCurrencyCodeMaster> getAllFgCurrencyCodeMasters() {
        return jdbi.withExtension(FgCurrencyCodeMasterDao.class, fgcurrencycodemasterdao -> fgcurrencycodemasterdao.findAll());
    }

    public Optional<FgCurrencyCodeMaster> getFgCurrencyCodeMasterById(String id) {
        return jdbi.withExtension(FgCurrencyCodeMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgCurrencyCodeMaster(FgCurrencyCodeMaster entity) {
        return jdbi.withExtension(FgCurrencyCodeMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgCurrencyCodeMaster(FgCurrencyCodeMaster entity) {
        return jdbi.withExtension(FgCurrencyCodeMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgCurrencyCodeMaster(String id) {
        jdbi.useExtension(FgCurrencyCodeMasterDao.class, dao -> dao.delete(id));
    }
}
