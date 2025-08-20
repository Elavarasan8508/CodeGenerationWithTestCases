package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BatchJobInstanceDao;
import com.bsit.codegeneration.record.BatchJobInstance;

public class BatchJobInstanceRepository {

    private final Jdbi jdbi;

    public BatchJobInstanceRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BatchJobInstance> getAllBatchJobInstances() {
        return jdbi.withExtension(BatchJobInstanceDao.class, batchjobinstancedao -> batchjobinstancedao.findAll());
    }

    public Optional<BatchJobInstance> getBatchJobInstanceById(String id) {
        return jdbi.withExtension(BatchJobInstanceDao.class, dao -> dao.findById(id));
    }

    public String createBatchJobInstance(BatchJobInstance entity) {
        return jdbi.withExtension(BatchJobInstanceDao.class, dao -> dao.insert(entity));
    }

    public int updateBatchJobInstance(BatchJobInstance entity) {
        return jdbi.withExtension(BatchJobInstanceDao.class, dao -> dao.update(entity));
    }

    public void deleteBatchJobInstance(String id) {
        jdbi.useExtension(BatchJobInstanceDao.class, dao -> dao.delete(id));
    }
}
