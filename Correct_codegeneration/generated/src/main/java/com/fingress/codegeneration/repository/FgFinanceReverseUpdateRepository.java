package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFinanceReverseUpdateDao;
import com.bsit.codegeneration.record.FgFinanceReverseUpdate;

public class FgFinanceReverseUpdateRepository {

    private final Jdbi jdbi;

    public FgFinanceReverseUpdateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFinanceReverseUpdate> getAllFgFinanceReverseUpdates() {
        return jdbi.withExtension(FgFinanceReverseUpdateDao.class, fgfinancereverseupdatedao -> fgfinancereverseupdatedao.findAll());
    }

    public Optional<FgFinanceReverseUpdate> getFgFinanceReverseUpdateById(String id) {
        return jdbi.withExtension(FgFinanceReverseUpdateDao.class, dao -> dao.findById(id));
    }

    public String createFgFinanceReverseUpdate(FgFinanceReverseUpdate entity) {
        return jdbi.withExtension(FgFinanceReverseUpdateDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFinanceReverseUpdate(FgFinanceReverseUpdate entity) {
        return jdbi.withExtension(FgFinanceReverseUpdateDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFinanceReverseUpdate(String id) {
        jdbi.useExtension(FgFinanceReverseUpdateDao.class, dao -> dao.delete(id));
    }
}
