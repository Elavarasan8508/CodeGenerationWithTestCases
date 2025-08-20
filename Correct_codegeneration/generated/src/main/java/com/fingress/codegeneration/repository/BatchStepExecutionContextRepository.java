package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BatchStepExecutionContextDao;
import com.bsit.codegeneration.record.BatchStepExecutionContext;

public class BatchStepExecutionContextRepository {

    private final Jdbi jdbi;

    public BatchStepExecutionContextRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BatchStepExecutionContext> getAllBatchStepExecutionContexts() {
        return jdbi.withExtension(BatchStepExecutionContextDao.class, batchstepexecutioncontextdao -> batchstepexecutioncontextdao.findAll());
    }

    public Optional<BatchStepExecutionContext> getBatchStepExecutionContextById(String id) {
        return jdbi.withExtension(BatchStepExecutionContextDao.class, dao -> dao.findById(id));
    }

    public String createBatchStepExecutionContext(BatchStepExecutionContext entity) {
        return jdbi.withExtension(BatchStepExecutionContextDao.class, dao -> dao.insert(entity));
    }

    public int updateBatchStepExecutionContext(BatchStepExecutionContext entity) {
        return jdbi.withExtension(BatchStepExecutionContextDao.class, dao -> dao.update(entity));
    }

    public void deleteBatchStepExecutionContext(String id) {
        jdbi.useExtension(BatchStepExecutionContextDao.class, dao -> dao.delete(id));
    }
}
