package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.ArchivalStagingDao;
import com.bsit.codegeneration.record.ArchivalStaging;

public class ArchivalStagingRepository {

    private final Jdbi jdbi;

    public ArchivalStagingRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<ArchivalStaging> getAllArchivalStagings() {
        return jdbi.withExtension(ArchivalStagingDao.class, archivalstagingdao -> archivalstagingdao.findAll());
    }

    public Optional<ArchivalStaging> getArchivalStagingById(String id) {
        return jdbi.withExtension(ArchivalStagingDao.class, dao -> dao.findById(id));
    }

    public String createArchivalStaging(ArchivalStaging entity) {
        return jdbi.withExtension(ArchivalStagingDao.class, dao -> dao.insert(entity));
    }

    public int updateArchivalStaging(ArchivalStaging entity) {
        return jdbi.withExtension(ArchivalStagingDao.class, dao -> dao.update(entity));
    }

    public void deleteArchivalStaging(String id) {
        jdbi.useExtension(ArchivalStagingDao.class, dao -> dao.delete(id));
    }
}
