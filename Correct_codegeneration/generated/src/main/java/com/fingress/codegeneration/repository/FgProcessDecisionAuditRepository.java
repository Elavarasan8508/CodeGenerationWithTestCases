package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProcessDecisionAuditDao;
import com.bsit.codegeneration.record.FgProcessDecisionAudit;

public class FgProcessDecisionAuditRepository {

    private final Jdbi jdbi;

    public FgProcessDecisionAuditRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProcessDecisionAudit> getAllFgProcessDecisionAudits() {
        return jdbi.withExtension(FgProcessDecisionAuditDao.class, fgprocessdecisionauditdao -> fgprocessdecisionauditdao.findAll());
    }

    public Optional<FgProcessDecisionAudit> getFgProcessDecisionAuditById(String id) {
        return jdbi.withExtension(FgProcessDecisionAuditDao.class, dao -> dao.findById(id));
    }

    public String createFgProcessDecisionAudit(FgProcessDecisionAudit entity) {
        return jdbi.withExtension(FgProcessDecisionAuditDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProcessDecisionAudit(FgProcessDecisionAudit entity) {
        return jdbi.withExtension(FgProcessDecisionAuditDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProcessDecisionAudit(String id) {
        jdbi.useExtension(FgProcessDecisionAuditDao.class, dao -> dao.delete(id));
    }
}
