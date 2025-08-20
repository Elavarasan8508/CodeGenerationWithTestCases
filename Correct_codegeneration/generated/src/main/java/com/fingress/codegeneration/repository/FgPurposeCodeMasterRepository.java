package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgPurposeCodeMasterDao;
import com.bsit.codegeneration.record.FgPurposeCodeMaster;

public class FgPurposeCodeMasterRepository {

    private final Jdbi jdbi;

    public FgPurposeCodeMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgPurposeCodeMaster> getAllFgPurposeCodeMasters() {
        return jdbi.withExtension(FgPurposeCodeMasterDao.class, fgpurposecodemasterdao -> fgpurposecodemasterdao.findAll());
    }

    public Optional<FgPurposeCodeMaster> getFgPurposeCodeMasterById(String id) {
        return jdbi.withExtension(FgPurposeCodeMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgPurposeCodeMaster(FgPurposeCodeMaster entity) {
        return jdbi.withExtension(FgPurposeCodeMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgPurposeCodeMaster(FgPurposeCodeMaster entity) {
        return jdbi.withExtension(FgPurposeCodeMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgPurposeCodeMaster(String id) {
        jdbi.useExtension(FgPurposeCodeMasterDao.class, dao -> dao.delete(id));
    }
}
