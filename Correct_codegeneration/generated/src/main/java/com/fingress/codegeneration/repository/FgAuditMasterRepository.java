package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAuditMasterDao;
import com.bsit.codegeneration.record.FgAuditMaster;

public class FgAuditMasterRepository {

    private final Jdbi jdbi;

    public FgAuditMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAuditMaster> getAllFgAuditMasters() {
        return jdbi.withExtension(FgAuditMasterDao.class, fgauditmasterdao -> fgauditmasterdao.findAll());
    }

    public Optional<FgAuditMaster> getFgAuditMasterById(String id) {
        return jdbi.withExtension(FgAuditMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgAuditMaster(FgAuditMaster entity) {
        return jdbi.withExtension(FgAuditMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAuditMaster(FgAuditMaster entity) {
        return jdbi.withExtension(FgAuditMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAuditMaster(String id) {
        jdbi.useExtension(FgAuditMasterDao.class, dao -> dao.delete(id));
    }
}
