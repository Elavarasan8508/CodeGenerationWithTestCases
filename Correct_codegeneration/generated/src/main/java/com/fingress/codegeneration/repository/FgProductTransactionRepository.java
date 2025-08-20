package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductTransactionDao;
import com.bsit.codegeneration.record.FgProductTransaction;

public class FgProductTransactionRepository {

    private final Jdbi jdbi;

    public FgProductTransactionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductTransaction> getAllFgProductTransactions() {
        return jdbi.withExtension(FgProductTransactionDao.class, fgproducttransactiondao -> fgproducttransactiondao.findAll());
    }

    public Optional<FgProductTransaction> getFgProductTransactionById(Long id) {
        return jdbi.withExtension(FgProductTransactionDao.class, dao -> dao.findById(id));
    }

    public Long createFgProductTransaction(FgProductTransaction entity) {
        return jdbi.withExtension(FgProductTransactionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductTransaction(FgProductTransaction entity) {
        return jdbi.withExtension(FgProductTransactionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductTransaction(Long id) {
        jdbi.useExtension(FgProductTransactionDao.class, dao -> dao.delete(id));
    }
}
