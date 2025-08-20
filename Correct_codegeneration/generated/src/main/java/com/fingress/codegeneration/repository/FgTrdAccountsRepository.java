package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdAccountsDao;
import com.bsit.codegeneration.record.FgTrdAccounts;

public class FgTrdAccountsRepository {

    private final Jdbi jdbi;

    public FgTrdAccountsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdAccounts> getAllFgTrdAccountss() {
        return jdbi.withExtension(FgTrdAccountsDao.class, fgtrdaccountsdao -> fgtrdaccountsdao.findAll());
    }

    public Optional<FgTrdAccounts> getFgTrdAccountsById(String id) {
        return jdbi.withExtension(FgTrdAccountsDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdAccounts(FgTrdAccounts entity) {
        return jdbi.withExtension(FgTrdAccountsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdAccounts(FgTrdAccounts entity) {
        return jdbi.withExtension(FgTrdAccountsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdAccounts(String id) {
        jdbi.useExtension(FgTrdAccountsDao.class, dao -> dao.delete(id));
    }
}
