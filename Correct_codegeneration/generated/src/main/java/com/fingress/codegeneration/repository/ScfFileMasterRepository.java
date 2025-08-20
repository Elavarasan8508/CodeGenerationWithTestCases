package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ScfFileMasterDao;
import com.bsit.codegeneration.record.ScfFileMaster;

public class ScfFileMasterRepository {

    private final Jdbi jdbi;

    public ScfFileMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ScfFileMaster> getAllScfFileMasters() {
        return jdbi.withExtension(ScfFileMasterDao.class, scffilemasterdao -> scffilemasterdao.findAll());
    }

    public Optional<ScfFileMaster> getScfFileMasterById(String id) {
        return jdbi.withExtension(ScfFileMasterDao.class, dao -> dao.findById(id));
    }

    public String createScfFileMaster(ScfFileMaster entity) {
        return jdbi.withExtension(ScfFileMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateScfFileMaster(ScfFileMaster entity) {
        return jdbi.withExtension(ScfFileMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteScfFileMaster(String id) {
        jdbi.useExtension(ScfFileMasterDao.class, dao -> dao.delete(id));
    }
}
