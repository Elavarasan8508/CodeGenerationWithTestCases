package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductStageHistoryDao;
import com.bsit.codegeneration.record.FgProductStageHistory;

public class FgProductStageHistoryRepository {

    private final Jdbi jdbi;

    public FgProductStageHistoryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductStageHistory> getAllFgProductStageHistorys() {
        return jdbi.withExtension(FgProductStageHistoryDao.class, fgproductstagehistorydao -> fgproductstagehistorydao.findAll());
    }

    public Optional<FgProductStageHistory> getFgProductStageHistoryById(String id) {
        return jdbi.withExtension(FgProductStageHistoryDao.class, dao -> dao.findById(id));
    }

    public String createFgProductStageHistory(FgProductStageHistory entity) {
        return jdbi.withExtension(FgProductStageHistoryDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductStageHistory(FgProductStageHistory entity) {
        return jdbi.withExtension(FgProductStageHistoryDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductStageHistory(String id) {
        jdbi.useExtension(FgProductStageHistoryDao.class, dao -> dao.delete(id));
    }
}
