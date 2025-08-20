package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSiteAppsDao;
import com.bsit.codegeneration.record.FgSiteApps;

public class FgSiteAppsRepository {

    private final Jdbi jdbi;

    public FgSiteAppsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSiteApps> getAllFgSiteAppss() {
        return jdbi.withExtension(FgSiteAppsDao.class, fgsiteappsdao -> fgsiteappsdao.findAll());
    }

    public Optional<FgSiteApps> getFgSiteAppsById(String id) {
        return jdbi.withExtension(FgSiteAppsDao.class, dao -> dao.findById(id));
    }

    public String createFgSiteApps(FgSiteApps entity) {
        return jdbi.withExtension(FgSiteAppsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSiteApps(FgSiteApps entity) {
        return jdbi.withExtension(FgSiteAppsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSiteApps(String id) {
        jdbi.useExtension(FgSiteAppsDao.class, dao -> dao.delete(id));
    }
}
