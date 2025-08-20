package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMockFynAccountDao;
import com.bsit.codegeneration.record.FgMockFynAccount;

public class FgMockFynAccountRepository {

    private final Jdbi jdbi;

    public FgMockFynAccountRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMockFynAccount> getAllFgMockFynAccounts() {
        return jdbi.withExtension(FgMockFynAccountDao.class, fgmockfynaccountdao -> fgmockfynaccountdao.findAll());
    }

    public Optional<FgMockFynAccount> getFgMockFynAccountById(String id) {
        return jdbi.withExtension(FgMockFynAccountDao.class, dao -> dao.findById(id));
    }

    public String createFgMockFynAccount(FgMockFynAccount entity) {
        return jdbi.withExtension(FgMockFynAccountDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMockFynAccount(FgMockFynAccount entity) {
        return jdbi.withExtension(FgMockFynAccountDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMockFynAccount(String id) {
        jdbi.useExtension(FgMockFynAccountDao.class, dao -> dao.delete(id));
    }
}
