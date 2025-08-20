package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfTxnBatchItemDao;
import com.bsit.codegeneration.record.ScfTxnBatchItem;

public class ScfTxnBatchItemRepository {

    private final Jdbi jdbi;

    public ScfTxnBatchItemRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfTxnBatchItem> getAllScfTxnBatchItems() {
        return jdbi.withExtension(ScfTxnBatchItemDao.class, scftxnbatchitemdao -> scftxnbatchitemdao.findAll());
    }

    public Optional<ScfTxnBatchItem> getScfTxnBatchItemById(String id) {
        return jdbi.withExtension(ScfTxnBatchItemDao.class, dao -> dao.findById(id));
    }

    public String createScfTxnBatchItem(ScfTxnBatchItem entity) {
        return jdbi.withExtension(ScfTxnBatchItemDao.class, dao -> dao.insert(entity));
    }

    public int updateScfTxnBatchItem(ScfTxnBatchItem entity) {
        return jdbi.withExtension(ScfTxnBatchItemDao.class, dao -> dao.update(entity));
    }

    public void deleteScfTxnBatchItem(String id) {
        jdbi.useExtension(ScfTxnBatchItemDao.class, dao -> dao.delete(id));
    }
}
