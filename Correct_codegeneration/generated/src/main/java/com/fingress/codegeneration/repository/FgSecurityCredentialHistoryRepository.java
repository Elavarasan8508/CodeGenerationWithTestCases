package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSecurityCredentialHistoryDao;
import com.bsit.codegeneration.record.FgSecurityCredentialHistory;

public class FgSecurityCredentialHistoryRepository {

    private final Jdbi jdbi;

    public FgSecurityCredentialHistoryRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSecurityCredentialHistory> getAllFgSecurityCredentialHistorys() {
        return jdbi.withExtension(FgSecurityCredentialHistoryDao.class, fgsecuritycredentialhistorydao -> fgsecuritycredentialhistorydao.findAll());
    }

    public Optional<FgSecurityCredentialHistory> getFgSecurityCredentialHistoryById(String id) {
        return jdbi.withExtension(FgSecurityCredentialHistoryDao.class, dao -> dao.findById(id));
    }

    public String createFgSecurityCredentialHistory(FgSecurityCredentialHistory entity) {
        return jdbi.withExtension(FgSecurityCredentialHistoryDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSecurityCredentialHistory(FgSecurityCredentialHistory entity) {
        return jdbi.withExtension(FgSecurityCredentialHistoryDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSecurityCredentialHistory(String id) {
        jdbi.useExtension(FgSecurityCredentialHistoryDao.class, dao -> dao.delete(id));
    }
}
