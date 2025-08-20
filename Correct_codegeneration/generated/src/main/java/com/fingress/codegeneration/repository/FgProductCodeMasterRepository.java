package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProductCodeMasterDao;
import com.bsit.codegeneration.record.FgProductCodeMaster;

public class FgProductCodeMasterRepository {

    private final Jdbi jdbi;

    public FgProductCodeMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProductCodeMaster> getAllFgProductCodeMasters() {
        return jdbi.withExtension(FgProductCodeMasterDao.class, fgproductcodemasterdao -> fgproductcodemasterdao.findAll());
    }

    public Optional<FgProductCodeMaster> getFgProductCodeMasterById(String id) {
        return jdbi.withExtension(FgProductCodeMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgProductCodeMaster(FgProductCodeMaster entity) {
        return jdbi.withExtension(FgProductCodeMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProductCodeMaster(FgProductCodeMaster entity) {
        return jdbi.withExtension(FgProductCodeMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProductCodeMaster(String id) {
        jdbi.useExtension(FgProductCodeMasterDao.class, dao -> dao.delete(id));
    }
}
