package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdRestrictcodeMasterDao;
import com.bsit.codegeneration.record.FgTdRestrictcodeMaster;

public class FgTdRestrictcodeMasterRepository {

    private final Jdbi jdbi;

    public FgTdRestrictcodeMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdRestrictcodeMaster> getAllFgTdRestrictcodeMasters() {
        return jdbi.withExtension(FgTdRestrictcodeMasterDao.class, fgtdrestrictcodemasterdao -> fgtdrestrictcodemasterdao.findAll());
    }

    public Optional<FgTdRestrictcodeMaster> getFgTdRestrictcodeMasterById(String id) {
        return jdbi.withExtension(FgTdRestrictcodeMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgTdRestrictcodeMaster(FgTdRestrictcodeMaster entity) {
        return jdbi.withExtension(FgTdRestrictcodeMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdRestrictcodeMaster(FgTdRestrictcodeMaster entity) {
        return jdbi.withExtension(FgTdRestrictcodeMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdRestrictcodeMaster(String id) {
        jdbi.useExtension(FgTdRestrictcodeMasterDao.class, dao -> dao.delete(id));
    }
}
