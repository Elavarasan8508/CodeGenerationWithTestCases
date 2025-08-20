package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FinReqBatchDao;
import com.bsit.codegeneration.record.FinReqBatch;

public class FinReqBatchRepository {

    private final Jdbi jdbi;

    public FinReqBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FinReqBatch> getAllFinReqBatchs() {
        return jdbi.withExtension(FinReqBatchDao.class, finreqbatchdao -> finreqbatchdao.findAll());
    }

    public Optional<FinReqBatch> getFinReqBatchById(String id) {
        return jdbi.withExtension(FinReqBatchDao.class, dao -> dao.findById(id));
    }

    public String createFinReqBatch(FinReqBatch entity) {
        return jdbi.withExtension(FinReqBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateFinReqBatch(FinReqBatch entity) {
        return jdbi.withExtension(FinReqBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteFinReqBatch(String id) {
        jdbi.useExtension(FinReqBatchDao.class, dao -> dao.delete(id));
    }
}
