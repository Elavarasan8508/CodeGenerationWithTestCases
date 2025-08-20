package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlsRepaymentHistoryDao;
import com.bsit.codegeneration.record.FgAlsRepaymentHistory;

public class FgAlsRepaymentHistoryRepository {

    private final Jdbi jdbi;

    public FgAlsRepaymentHistoryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlsRepaymentHistory> getAllFgAlsRepaymentHistorys() {
        return jdbi.withExtension(FgAlsRepaymentHistoryDao.class, fgalsrepaymenthistorydao -> fgalsrepaymenthistorydao.findAll());
    }

    public Optional<FgAlsRepaymentHistory> getFgAlsRepaymentHistoryById(String id) {
        return jdbi.withExtension(FgAlsRepaymentHistoryDao.class, dao -> dao.findById(id));
    }

    public String createFgAlsRepaymentHistory(FgAlsRepaymentHistory entity) {
        return jdbi.withExtension(FgAlsRepaymentHistoryDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlsRepaymentHistory(FgAlsRepaymentHistory entity) {
        return jdbi.withExtension(FgAlsRepaymentHistoryDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlsRepaymentHistory(String id) {
        jdbi.useExtension(FgAlsRepaymentHistoryDao.class, dao -> dao.delete(id));
    }
}
