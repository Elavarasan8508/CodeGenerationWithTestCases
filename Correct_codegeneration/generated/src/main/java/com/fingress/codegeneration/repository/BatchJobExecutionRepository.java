package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BatchJobExecutionDao;
import com.bsit.codegeneration.record.BatchJobExecution;

public class BatchJobExecutionRepository {

    private final Jdbi jdbi;

    public BatchJobExecutionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BatchJobExecution> getAllBatchJobExecutions() {
        return jdbi.withExtension(BatchJobExecutionDao.class, batchjobexecutiondao -> batchjobexecutiondao.findAll());
    }

    public Optional<BatchJobExecution> getBatchJobExecutionById(String id) {
        return jdbi.withExtension(BatchJobExecutionDao.class, dao -> dao.findById(id));
    }

    public String createBatchJobExecution(BatchJobExecution entity) {
        return jdbi.withExtension(BatchJobExecutionDao.class, dao -> dao.insert(entity));
    }

    public int updateBatchJobExecution(BatchJobExecution entity) {
        return jdbi.withExtension(BatchJobExecutionDao.class, dao -> dao.update(entity));
    }

    public void deleteBatchJobExecution(String id) {
        jdbi.useExtension(BatchJobExecutionDao.class, dao -> dao.delete(id));
    }
}
