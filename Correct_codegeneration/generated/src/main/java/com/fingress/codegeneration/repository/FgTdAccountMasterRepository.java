package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdAccountMasterDao;
import com.bsit.codegeneration.record.FgTdAccountMaster;

public class FgTdAccountMasterRepository {

    private final Jdbi jdbi;

    public FgTdAccountMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdAccountMaster> getAllFgTdAccountMasters() {
        return jdbi.withExtension(FgTdAccountMasterDao.class, fgtdaccountmasterdao -> fgtdaccountmasterdao.findAll());
    }

    public Optional<FgTdAccountMaster> getFgTdAccountMasterById(String id) {
        return jdbi.withExtension(FgTdAccountMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgTdAccountMaster(FgTdAccountMaster entity) {
        return jdbi.withExtension(FgTdAccountMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdAccountMaster(FgTdAccountMaster entity) {
        return jdbi.withExtension(FgTdAccountMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdAccountMaster(String id) {
        jdbi.useExtension(FgTdAccountMasterDao.class, dao -> dao.delete(id));
    }
}
