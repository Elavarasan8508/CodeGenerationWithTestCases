package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdMaturityMasterDao;
import com.bsit.codegeneration.record.FgTdMaturityMaster;

public class FgTdMaturityMasterRepository {

    private final Jdbi jdbi;

    public FgTdMaturityMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdMaturityMaster> getAllFgTdMaturityMasters() {
        return jdbi.withExtension(FgTdMaturityMasterDao.class, fgtdmaturitymasterdao -> fgtdmaturitymasterdao.findAll());
    }

    public Optional<FgTdMaturityMaster> getFgTdMaturityMasterById(String id) {
        return jdbi.withExtension(FgTdMaturityMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgTdMaturityMaster(FgTdMaturityMaster entity) {
        return jdbi.withExtension(FgTdMaturityMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdMaturityMaster(FgTdMaturityMaster entity) {
        return jdbi.withExtension(FgTdMaturityMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdMaturityMaster(String id) {
        jdbi.useExtension(FgTdMaturityMasterDao.class, dao -> dao.delete(id));
    }
}
