package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BatchJobExecutionParamsDao;
import com.bsit.codegeneration.record.BatchJobExecutionParams;

public class BatchJobExecutionParamsRepository {

    private final Jdbi jdbi;

    public BatchJobExecutionParamsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BatchJobExecutionParams> getAllBatchJobExecutionParamss() {
        return jdbi.withExtension(BatchJobExecutionParamsDao.class, batchjobexecutionparamsdao -> batchjobexecutionparamsdao.findAll());
    }

    public Optional<BatchJobExecutionParams> getBatchJobExecutionParamsById(String id) {
        return jdbi.withExtension(BatchJobExecutionParamsDao.class, dao -> dao.findById(id));
    }

    public String createBatchJobExecutionParams(BatchJobExecutionParams entity) {
        return jdbi.withExtension(BatchJobExecutionParamsDao.class, dao -> dao.insert(entity));
    }

    public int updateBatchJobExecutionParams(BatchJobExecutionParams entity) {
        return jdbi.withExtension(BatchJobExecutionParamsDao.class, dao -> dao.update(entity));
    }

    public void deleteBatchJobExecutionParams(String id) {
        jdbi.useExtension(BatchJobExecutionParamsDao.class, dao -> dao.delete(id));
    }
}
