package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgBatchDao;
import com.bsit.codegeneration.record.FgBatch;

public class FgBatchRepository {

    private final Jdbi jdbi;

    public FgBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgBatch> getAllFgBatchs() {
        return jdbi.withExtension(FgBatchDao.class, fgbatchdao -> fgbatchdao.findAll());
    }

    public Optional<FgBatch> getFgBatchById(Long id) {
        return jdbi.withExtension(FgBatchDao.class, dao -> dao.findById(id));
    }

    public Long createFgBatch(FgBatch entity) {
        return jdbi.withExtension(FgBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateFgBatch(FgBatch entity) {
        return jdbi.withExtension(FgBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteFgBatch(Long id) {
        jdbi.useExtension(FgBatchDao.class, dao -> dao.delete(id));
    }
}
