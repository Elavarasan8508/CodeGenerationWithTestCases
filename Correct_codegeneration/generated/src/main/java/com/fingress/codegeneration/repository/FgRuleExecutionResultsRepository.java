package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgRuleExecutionResultsDao;
import com.bsit.codegeneration.record.FgRuleExecutionResults;

public class FgRuleExecutionResultsRepository {

    private final Jdbi jdbi;

    public FgRuleExecutionResultsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgRuleExecutionResults> getAllFgRuleExecutionResultss() {
        return jdbi.withExtension(FgRuleExecutionResultsDao.class, fgruleexecutionresultsdao -> fgruleexecutionresultsdao.findAll());
    }

    public Optional<FgRuleExecutionResults> getFgRuleExecutionResultsById(String id) {
        return jdbi.withExtension(FgRuleExecutionResultsDao.class, dao -> dao.findById(id));
    }

    public String createFgRuleExecutionResults(FgRuleExecutionResults entity) {
        return jdbi.withExtension(FgRuleExecutionResultsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgRuleExecutionResults(FgRuleExecutionResults entity) {
        return jdbi.withExtension(FgRuleExecutionResultsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgRuleExecutionResults(String id) {
        jdbi.useExtension(FgRuleExecutionResultsDao.class, dao -> dao.delete(id));
    }
}
