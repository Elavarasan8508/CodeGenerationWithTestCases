package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.LmsMdmConfigDao;
import com.bsit.codegeneration.record.LmsMdmConfig;

public class LmsMdmConfigRepository {

    private final Jdbi jdbi;

    public LmsMdmConfigRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<LmsMdmConfig> getAllLmsMdmConfigs() {
        return jdbi.withExtension(LmsMdmConfigDao.class, lmsmdmconfigdao -> lmsmdmconfigdao.findAll());
    }

    public Optional<LmsMdmConfig> getLmsMdmConfigById(Long id) {
        return jdbi.withExtension(LmsMdmConfigDao.class, dao -> dao.findById(id));
    }

    public Long createLmsMdmConfig(LmsMdmConfig entity) {
        return jdbi.withExtension(LmsMdmConfigDao.class, dao -> dao.insert(entity));
    }

    public int updateLmsMdmConfig(LmsMdmConfig entity) {
        return jdbi.withExtension(LmsMdmConfigDao.class, dao -> dao.update(entity));
    }

    public void deleteLmsMdmConfig(Long id) {
        jdbi.useExtension(LmsMdmConfigDao.class, dao -> dao.delete(id));
    }
}
