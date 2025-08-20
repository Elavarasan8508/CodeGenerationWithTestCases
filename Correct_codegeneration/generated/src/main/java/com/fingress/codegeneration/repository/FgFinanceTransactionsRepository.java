package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFinanceTransactionsDao;
import com.bsit.codegeneration.record.FgFinanceTransactions;

public class FgFinanceTransactionsRepository {

    private final Jdbi jdbi;

    public FgFinanceTransactionsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFinanceTransactions> getAllFgFinanceTransactionss() {
        return jdbi.withExtension(FgFinanceTransactionsDao.class, fgfinancetransactionsdao -> fgfinancetransactionsdao.findAll());
    }

    public Optional<FgFinanceTransactions> getFgFinanceTransactionsById(String id) {
        return jdbi.withExtension(FgFinanceTransactionsDao.class, dao -> dao.findById(id));
    }

    public String createFgFinanceTransactions(FgFinanceTransactions entity) {
        return jdbi.withExtension(FgFinanceTransactionsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFinanceTransactions(FgFinanceTransactions entity) {
        return jdbi.withExtension(FgFinanceTransactionsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFinanceTransactions(String id) {
        jdbi.useExtension(FgFinanceTransactionsDao.class, dao -> dao.delete(id));
    }
}
