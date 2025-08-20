package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlsExecutionDao;
import com.bsit.codegeneration.record.FgAlsExecution;

public class FgAlsExecutionRepository {

    private final Jdbi jdbi;

    public FgAlsExecutionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlsExecution> getAllFgAlsExecutions() {
        return jdbi.withExtension(FgAlsExecutionDao.class, fgalsexecutiondao -> fgalsexecutiondao.findAll());
    }

    public Optional<FgAlsExecution> getFgAlsExecutionById(String id) {
        return jdbi.withExtension(FgAlsExecutionDao.class, dao -> dao.findById(id));
    }

    public String createFgAlsExecution(FgAlsExecution entity) {
        return jdbi.withExtension(FgAlsExecutionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlsExecution(FgAlsExecution entity) {
        return jdbi.withExtension(FgAlsExecutionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlsExecution(String id) {
        jdbi.useExtension(FgAlsExecutionDao.class, dao -> dao.delete(id));
    }
}
