package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPreferencesMasterDao;
import com.bsit.codegeneration.record.FgPreferencesMaster;

public class FgPreferencesMasterRepository {

    private final Jdbi jdbi;

    public FgPreferencesMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPreferencesMaster> getAllFgPreferencesMasters() {
        return jdbi.withExtension(FgPreferencesMasterDao.class, fgpreferencesmasterdao -> fgpreferencesmasterdao.findAll());
    }

    public Optional<FgPreferencesMaster> getFgPreferencesMasterById(String id) {
        return jdbi.withExtension(FgPreferencesMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgPreferencesMaster(FgPreferencesMaster entity) {
        return jdbi.withExtension(FgPreferencesMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPreferencesMaster(FgPreferencesMaster entity) {
        return jdbi.withExtension(FgPreferencesMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPreferencesMaster(String id) {
        jdbi.useExtension(FgPreferencesMasterDao.class, dao -> dao.delete(id));
    }
}
