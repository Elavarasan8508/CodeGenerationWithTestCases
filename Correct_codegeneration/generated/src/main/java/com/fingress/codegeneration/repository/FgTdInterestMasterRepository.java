package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdInterestMasterDao;
import com.bsit.codegeneration.record.FgTdInterestMaster;

public class FgTdInterestMasterRepository {

    private final Jdbi jdbi;

    public FgTdInterestMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdInterestMaster> getAllFgTdInterestMasters() {
        return jdbi.withExtension(FgTdInterestMasterDao.class, fgtdinterestmasterdao -> fgtdinterestmasterdao.findAll());
    }

    public Optional<FgTdInterestMaster> getFgTdInterestMasterById(String id) {
        return jdbi.withExtension(FgTdInterestMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgTdInterestMaster(FgTdInterestMaster entity) {
        return jdbi.withExtension(FgTdInterestMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdInterestMaster(FgTdInterestMaster entity) {
        return jdbi.withExtension(FgTdInterestMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdInterestMaster(String id) {
        jdbi.useExtension(FgTdInterestMasterDao.class, dao -> dao.delete(id));
    }
}
