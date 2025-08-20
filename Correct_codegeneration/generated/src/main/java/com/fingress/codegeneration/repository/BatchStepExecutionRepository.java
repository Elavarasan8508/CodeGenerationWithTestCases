package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BatchStepExecutionDao;
import com.bsit.codegeneration.record.BatchStepExecution;

public class BatchStepExecutionRepository {

    private final Jdbi jdbi;

    public BatchStepExecutionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BatchStepExecution> getAllBatchStepExecutions() {
        return jdbi.withExtension(BatchStepExecutionDao.class, batchstepexecutiondao -> batchstepexecutiondao.findAll());
    }

    public Optional<BatchStepExecution> getBatchStepExecutionById(String id) {
        return jdbi.withExtension(BatchStepExecutionDao.class, dao -> dao.findById(id));
    }

    public String createBatchStepExecution(BatchStepExecution entity) {
        return jdbi.withExtension(BatchStepExecutionDao.class, dao -> dao.insert(entity));
    }

    public int updateBatchStepExecution(BatchStepExecution entity) {
        return jdbi.withExtension(BatchStepExecutionDao.class, dao -> dao.update(entity));
    }

    public void deleteBatchStepExecution(String id) {
        jdbi.useExtension(BatchStepExecutionDao.class, dao -> dao.delete(id));
    }
}
