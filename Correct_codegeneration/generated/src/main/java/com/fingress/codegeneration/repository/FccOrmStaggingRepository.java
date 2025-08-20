package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FccOrmStaggingDao;
import com.bsit.codegeneration.record.FccOrmStagging;

public class FccOrmStaggingRepository {

    private final Jdbi jdbi;

    public FccOrmStaggingRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FccOrmStagging> getAllFccOrmStaggings() {
        return jdbi.withExtension(FccOrmStaggingDao.class, fccormstaggingdao -> fccormstaggingdao.findAll());
    }

    public Optional<FccOrmStagging> getFccOrmStaggingById(String id) {
        return jdbi.withExtension(FccOrmStaggingDao.class, dao -> dao.findById(id));
    }

    public String createFccOrmStagging(FccOrmStagging entity) {
        return jdbi.withExtension(FccOrmStaggingDao.class, dao -> dao.insert(entity));
    }

    public int updateFccOrmStagging(FccOrmStagging entity) {
        return jdbi.withExtension(FccOrmStaggingDao.class, dao -> dao.update(entity));
    }

    public void deleteFccOrmStagging(String id) {
        jdbi.useExtension(FccOrmStaggingDao.class, dao -> dao.delete(id));
    }
}
