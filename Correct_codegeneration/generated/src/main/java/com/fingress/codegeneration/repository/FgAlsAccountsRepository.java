package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAlsAccountsDao;
import com.bsit.codegeneration.record.FgAlsAccounts;

public class FgAlsAccountsRepository {

    private final Jdbi jdbi;

    public FgAlsAccountsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAlsAccounts> getAllFgAlsAccountss() {
        return jdbi.withExtension(FgAlsAccountsDao.class, fgalsaccountsdao -> fgalsaccountsdao.findAll());
    }

    public Optional<FgAlsAccounts> getFgAlsAccountsById(Long id) {
        return jdbi.withExtension(FgAlsAccountsDao.class, dao -> dao.findById(id));
    }

    public Long createFgAlsAccounts(FgAlsAccounts entity) {
        return jdbi.withExtension(FgAlsAccountsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAlsAccounts(FgAlsAccounts entity) {
        return jdbi.withExtension(FgAlsAccountsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAlsAccounts(Long id) {
        jdbi.useExtension(FgAlsAccountsDao.class, dao -> dao.delete(id));
    }
}
