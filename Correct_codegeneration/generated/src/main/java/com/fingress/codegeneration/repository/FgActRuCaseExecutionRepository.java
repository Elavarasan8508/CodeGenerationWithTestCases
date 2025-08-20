package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuCaseExecutionDao;
import com.bsit.codegeneration.record.FgActRuCaseExecution;

public class FgActRuCaseExecutionRepository {

    private final Jdbi jdbi;

    public FgActRuCaseExecutionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuCaseExecution> getAllFgActRuCaseExecutions() {
        return jdbi.withExtension(FgActRuCaseExecutionDao.class, fgactrucaseexecutiondao -> fgactrucaseexecutiondao.findAll());
    }

    public Optional<FgActRuCaseExecution> getFgActRuCaseExecutionById(String id) {
        return jdbi.withExtension(FgActRuCaseExecutionDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuCaseExecution(FgActRuCaseExecution entity) {
        return jdbi.withExtension(FgActRuCaseExecutionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuCaseExecution(FgActRuCaseExecution entity) {
        return jdbi.withExtension(FgActRuCaseExecutionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuCaseExecution(String id) {
        jdbi.useExtension(FgActRuCaseExecutionDao.class, dao -> dao.delete(id));
    }
}
