package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgModBiDashboardReposDao;
import com.bsit.codegeneration.record.FgModBiDashboardRepos;

public class FgModBiDashboardReposRepository {

    private final Jdbi jdbi;

    public FgModBiDashboardReposRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgModBiDashboardRepos> getAllFgModBiDashboardReposs() {
        return jdbi.withExtension(FgModBiDashboardReposDao.class, fgmodbidashboardreposdao -> fgmodbidashboardreposdao.findAll());
    }

    public Optional<FgModBiDashboardRepos> getFgModBiDashboardReposById(Long id) {
        return jdbi.withExtension(FgModBiDashboardReposDao.class, dao -> dao.findById(id));
    }

    public Long createFgModBiDashboardRepos(FgModBiDashboardRepos entity) {
        return jdbi.withExtension(FgModBiDashboardReposDao.class, dao -> dao.insert(entity));
    }

    public int updateFgModBiDashboardRepos(FgModBiDashboardRepos entity) {
        return jdbi.withExtension(FgModBiDashboardReposDao.class, dao -> dao.update(entity));
    }

    public void deleteFgModBiDashboardRepos(Long id) {
        jdbi.useExtension(FgModBiDashboardReposDao.class, dao -> dao.delete(id));
    }
}
