package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSitesDao;
import com.bsit.codegeneration.record.FgSites;

public class FgSitesRepository {

    private final Jdbi jdbi;

    public FgSitesRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSites> getAllFgSitess() {
        return jdbi.withExtension(FgSitesDao.class, fgsitesdao -> fgsitesdao.findAll());
    }

    public Optional<FgSites> getFgSitesById(String id) {
        return jdbi.withExtension(FgSitesDao.class, dao -> dao.findById(id));
    }

    public String createFgSites(FgSites entity) {
        return jdbi.withExtension(FgSitesDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSites(FgSites entity) {
        return jdbi.withExtension(FgSitesDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSites(String id) {
        jdbi.useExtension(FgSitesDao.class, dao -> dao.delete(id));
    }
}
