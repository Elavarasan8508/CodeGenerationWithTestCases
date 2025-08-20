package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgDmsContentBackupDao;
import com.bsit.codegeneration.record.FgDmsContentBackup;

public class FgDmsContentBackupRepository {

    private final Jdbi jdbi;

    public FgDmsContentBackupRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgDmsContentBackup> getAllFgDmsContentBackups() {
        return jdbi.withExtension(FgDmsContentBackupDao.class, fgdmscontentbackupdao -> fgdmscontentbackupdao.findAll());
    }

    public Optional<FgDmsContentBackup> getFgDmsContentBackupById(Long id) {
        return jdbi.withExtension(FgDmsContentBackupDao.class, dao -> dao.findById(id));
    }

    public Long createFgDmsContentBackup(FgDmsContentBackup entity) {
        return jdbi.withExtension(FgDmsContentBackupDao.class, dao -> dao.insert(entity));
    }

    public int updateFgDmsContentBackup(FgDmsContentBackup entity) {
        return jdbi.withExtension(FgDmsContentBackupDao.class, dao -> dao.update(entity));
    }

    public void deleteFgDmsContentBackup(Long id) {
        jdbi.useExtension(FgDmsContentBackupDao.class, dao -> dao.delete(id));
    }
}
