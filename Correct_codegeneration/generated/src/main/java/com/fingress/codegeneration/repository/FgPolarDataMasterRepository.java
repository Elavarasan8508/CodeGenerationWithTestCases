package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPolarDataMasterDao;
import com.bsit.codegeneration.record.FgPolarDataMaster;

public class FgPolarDataMasterRepository {

    private final Jdbi jdbi;

    public FgPolarDataMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPolarDataMaster> getAllFgPolarDataMasters() {
        return jdbi.withExtension(FgPolarDataMasterDao.class, fgpolardatamasterdao -> fgpolardatamasterdao.findAll());
    }

    public Optional<FgPolarDataMaster> getFgPolarDataMasterById(String id) {
        return jdbi.withExtension(FgPolarDataMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgPolarDataMaster(FgPolarDataMaster entity) {
        return jdbi.withExtension(FgPolarDataMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPolarDataMaster(FgPolarDataMaster entity) {
        return jdbi.withExtension(FgPolarDataMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPolarDataMaster(String id) {
        jdbi.useExtension(FgPolarDataMasterDao.class, dao -> dao.delete(id));
    }
}
