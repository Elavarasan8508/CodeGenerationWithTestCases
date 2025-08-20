package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSiteProfileDao;
import com.bsit.codegeneration.record.FgSiteProfile;

public class FgSiteProfileRepository {

    private final Jdbi jdbi;

    public FgSiteProfileRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSiteProfile> getAllFgSiteProfiles() {
        return jdbi.withExtension(FgSiteProfileDao.class, fgsiteprofiledao -> fgsiteprofiledao.findAll());
    }

    public Optional<FgSiteProfile> getFgSiteProfileById(String id) {
        return jdbi.withExtension(FgSiteProfileDao.class, dao -> dao.findById(id));
    }

    public String createFgSiteProfile(FgSiteProfile entity) {
        return jdbi.withExtension(FgSiteProfileDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSiteProfile(FgSiteProfile entity) {
        return jdbi.withExtension(FgSiteProfileDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSiteProfile(String id) {
        jdbi.useExtension(FgSiteProfileDao.class, dao -> dao.delete(id));
    }
}
