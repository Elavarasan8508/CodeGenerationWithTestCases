package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductWfActHistoryDao;
import com.bsit.codegeneration.record.FgProductWfActHistory;

public class FgProductWfActHistoryRepository {

    private final Jdbi jdbi;

    public FgProductWfActHistoryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductWfActHistory> getAllFgProductWfActHistorys() {
        return jdbi.withExtension(FgProductWfActHistoryDao.class, fgproductwfacthistorydao -> fgproductwfacthistorydao.findAll());
    }

    public Optional<FgProductWfActHistory> getFgProductWfActHistoryById(Long id) {
        return jdbi.withExtension(FgProductWfActHistoryDao.class, dao -> dao.findById(id));
    }

    public Long createFgProductWfActHistory(FgProductWfActHistory entity) {
        return jdbi.withExtension(FgProductWfActHistoryDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductWfActHistory(FgProductWfActHistory entity) {
        return jdbi.withExtension(FgProductWfActHistoryDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductWfActHistory(Long id) {
        jdbi.useExtension(FgProductWfActHistoryDao.class, dao -> dao.delete(id));
    }
}
