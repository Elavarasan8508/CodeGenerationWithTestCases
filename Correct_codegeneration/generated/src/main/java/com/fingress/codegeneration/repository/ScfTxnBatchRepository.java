package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfTxnBatchDao;
import com.bsit.codegeneration.record.ScfTxnBatch;

public class ScfTxnBatchRepository {

    private final Jdbi jdbi;

    public ScfTxnBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfTxnBatch> getAllScfTxnBatchs() {
        return jdbi.withExtension(ScfTxnBatchDao.class, scftxnbatchdao -> scftxnbatchdao.findAll());
    }

    public Optional<ScfTxnBatch> getScfTxnBatchById(Long id) {
        return jdbi.withExtension(ScfTxnBatchDao.class, dao -> dao.findById(id));
    }

    public Long createScfTxnBatch(ScfTxnBatch entity) {
        return jdbi.withExtension(ScfTxnBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateScfTxnBatch(ScfTxnBatch entity) {
        return jdbi.withExtension(ScfTxnBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteScfTxnBatch(Long id) {
        jdbi.useExtension(ScfTxnBatchDao.class, dao -> dao.delete(id));
    }
}
