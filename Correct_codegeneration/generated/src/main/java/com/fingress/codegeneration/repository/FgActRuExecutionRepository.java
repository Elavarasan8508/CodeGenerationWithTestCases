package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuExecutionDao;
import com.bsit.codegeneration.record.FgActRuExecution;

public class FgActRuExecutionRepository {

    private final Jdbi jdbi;

    public FgActRuExecutionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuExecution> getAllFgActRuExecutions() {
        return jdbi.withExtension(FgActRuExecutionDao.class, fgactruexecutiondao -> fgactruexecutiondao.findAll());
    }

    public Optional<FgActRuExecution> getFgActRuExecutionById(String id) {
        return jdbi.withExtension(FgActRuExecutionDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuExecution(FgActRuExecution entity) {
        return jdbi.withExtension(FgActRuExecutionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuExecution(FgActRuExecution entity) {
        return jdbi.withExtension(FgActRuExecutionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuExecution(String id) {
        jdbi.useExtension(FgActRuExecutionDao.class, dao -> dao.delete(id));
    }
}
