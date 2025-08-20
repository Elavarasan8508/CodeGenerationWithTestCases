package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgAppVersionDao;
import com.bsit.codegeneration.record.FgAppVersion;

public class FgAppVersionRepository {

    private final Jdbi jdbi;

    public FgAppVersionRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgAppVersion> getAllFgAppVersions() {
        return jdbi.withExtension(FgAppVersionDao.class, fgappversiondao -> fgappversiondao.findAll());
    }

    public Optional<FgAppVersion> getFgAppVersionById(String id) {
        return jdbi.withExtension(FgAppVersionDao.class, dao -> dao.findById(id));
    }

    public String createFgAppVersion(FgAppVersion entity) {
        return jdbi.withExtension(FgAppVersionDao.class, dao -> dao.insert(entity));
    }

    public int updateFgAppVersion(FgAppVersion entity) {
        return jdbi.withExtension(FgAppVersionDao.class, dao -> dao.update(entity));
    }

    public void deleteFgAppVersion(String id) {
        jdbi.useExtension(FgAppVersionDao.class, dao -> dao.delete(id));
    }
}
