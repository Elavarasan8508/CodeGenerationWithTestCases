package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BatchJobExecutionContextDao;
import com.bsit.codegeneration.record.BatchJobExecutionContext;

public class BatchJobExecutionContextRepository {

    private final Jdbi jdbi;

    public BatchJobExecutionContextRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BatchJobExecutionContext> getAllBatchJobExecutionContexts() {
        return jdbi.withExtension(BatchJobExecutionContextDao.class, batchjobexecutioncontextdao -> batchjobexecutioncontextdao.findAll());
    }

    public Optional<BatchJobExecutionContext> getBatchJobExecutionContextById(String id) {
        return jdbi.withExtension(BatchJobExecutionContextDao.class, dao -> dao.findById(id));
    }

    public String createBatchJobExecutionContext(BatchJobExecutionContext entity) {
        return jdbi.withExtension(BatchJobExecutionContextDao.class, dao -> dao.insert(entity));
    }

    public int updateBatchJobExecutionContext(BatchJobExecutionContext entity) {
        return jdbi.withExtension(BatchJobExecutionContextDao.class, dao -> dao.update(entity));
    }

    public void deleteBatchJobExecutionContext(String id) {
        jdbi.useExtension(BatchJobExecutionContextDao.class, dao -> dao.delete(id));
    }
}
