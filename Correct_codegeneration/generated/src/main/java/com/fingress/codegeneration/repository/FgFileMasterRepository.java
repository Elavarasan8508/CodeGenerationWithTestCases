package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgFileMasterDao;
import com.bsit.codegeneration.record.FgFileMaster;

public class FgFileMasterRepository {

    private final Jdbi jdbi;

    public FgFileMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgFileMaster> getAllFgFileMasters() {
        return jdbi.withExtension(FgFileMasterDao.class, fgfilemasterdao -> fgfilemasterdao.findAll());
    }

    public Optional<FgFileMaster> getFgFileMasterById(String id) {
        return jdbi.withExtension(FgFileMasterDao.class, dao -> dao.findById(id));
    }

    public String createFgFileMaster(FgFileMaster entity) {
        return jdbi.withExtension(FgFileMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateFgFileMaster(FgFileMaster entity) {
        return jdbi.withExtension(FgFileMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteFgFileMaster(String id) {
        jdbi.useExtension(FgFileMasterDao.class, dao -> dao.delete(id));
    }
}
