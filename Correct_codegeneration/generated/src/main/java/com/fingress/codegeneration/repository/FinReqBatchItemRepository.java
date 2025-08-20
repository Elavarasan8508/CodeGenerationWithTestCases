package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FinReqBatchItemDao;
import com.bsit.codegeneration.record.FinReqBatchItem;

public class FinReqBatchItemRepository {

    private final Jdbi jdbi;

    public FinReqBatchItemRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FinReqBatchItem> getAllFinReqBatchItems() {
        return jdbi.withExtension(FinReqBatchItemDao.class, finreqbatchitemdao -> finreqbatchitemdao.findAll());
    }

    public Optional<FinReqBatchItem> getFinReqBatchItemById(String id) {
        return jdbi.withExtension(FinReqBatchItemDao.class, dao -> dao.findById(id));
    }

    public String createFinReqBatchItem(FinReqBatchItem entity) {
        return jdbi.withExtension(FinReqBatchItemDao.class, dao -> dao.insert(entity));
    }

    public int updateFinReqBatchItem(FinReqBatchItem entity) {
        return jdbi.withExtension(FinReqBatchItemDao.class, dao -> dao.update(entity));
    }

    public void deleteFinReqBatchItem(String id) {
        jdbi.useExtension(FinReqBatchItemDao.class, dao -> dao.delete(id));
    }
}
