package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.TdAccountListDao;
import com.bsit.codegeneration.record.TdAccountList;

public class TdAccountListRepository {

    private final Jdbi jdbi;

    public TdAccountListRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<TdAccountList> getAllTdAccountLists() {
        return jdbi.withExtension(TdAccountListDao.class, tdaccountlistdao -> tdaccountlistdao.findAll());
    }

    public Optional<TdAccountList> getTdAccountListById(Long id) {
        return jdbi.withExtension(TdAccountListDao.class, dao -> dao.findById(id));
    }

    public Long createTdAccountList(TdAccountList entity) {
        return jdbi.withExtension(TdAccountListDao.class, dao -> dao.insert(entity));
    }

    public int updateTdAccountList(TdAccountList entity) {
        return jdbi.withExtension(TdAccountListDao.class, dao -> dao.update(entity));
    }

    public void deleteTdAccountList(Long id) {
        jdbi.useExtension(TdAccountListDao.class, dao -> dao.delete(id));
    }
}
