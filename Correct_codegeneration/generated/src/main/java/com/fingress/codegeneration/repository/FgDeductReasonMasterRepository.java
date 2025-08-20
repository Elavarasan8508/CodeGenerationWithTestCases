package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDeductReasonMasterDao;
import com.bsit.codegeneration.record.FgDeductReasonMaster;

public class FgDeductReasonMasterRepository {

    private final Jdbi jdbi;

    public FgDeductReasonMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDeductReasonMaster> getAllFgDeductReasonMasters() {
        return jdbi.withExtension(FgDeductReasonMasterDao.class, fgdeductreasonmasterdao -> fgdeductreasonmasterdao.findAll());
    }

    public Optional<FgDeductReasonMaster> getFgDeductReasonMasterById(String id) {
        return jdbi.withExtension(FgDeductReasonMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgDeductReasonMaster(FgDeductReasonMaster entity) {
        return jdbi.withExtension(FgDeductReasonMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDeductReasonMaster(FgDeductReasonMaster entity) {
        return jdbi.withExtension(FgDeductReasonMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDeductReasonMaster(String id) {
        jdbi.useExtension(FgDeductReasonMasterDao.class, dao -> dao.delete(id));
    }
}
