package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBatchDetailDao;
import com.bsit.codegeneration.record.FgBatchDetail;

public class FgBatchDetailRepository {

    private final Jdbi jdbi;

    public FgBatchDetailRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBatchDetail> getAllFgBatchDetails() {
        return jdbi.withExtension(FgBatchDetailDao.class, fgbatchdetaildao -> fgbatchdetaildao.findAll());
    }

    public Optional<FgBatchDetail> getFgBatchDetailById(String id) {
        return jdbi.withExtension(FgBatchDetailDao.class, dao -> dao.findById(id));
    }

    public String createFgBatchDetail(FgBatchDetail entity) {
        return jdbi.withExtension(FgBatchDetailDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBatchDetail(FgBatchDetail entity) {
        return jdbi.withExtension(FgBatchDetailDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBatchDetail(String id) {
        jdbi.useExtension(FgBatchDetailDao.class, dao -> dao.delete(id));
    }
}
