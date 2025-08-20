package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActReDeploymentDao;
import com.bsit.codegeneration.record.FgActReDeployment;

public class FgActReDeploymentRepository {

    private final Jdbi jdbi;

    public FgActReDeploymentRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActReDeployment> getAllFgActReDeployments() {
        return jdbi.withExtension(FgActReDeploymentDao.class, fgactredeploymentdao -> fgactredeploymentdao.findAll());
    }

    public Optional<FgActReDeployment> getFgActReDeploymentById(String id) {
        return jdbi.withExtension(FgActReDeploymentDao.class, dao -> dao.findById(id));
    }

    public String createFgActReDeployment(FgActReDeployment entity) {
        return jdbi.withExtension(FgActReDeploymentDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActReDeployment(FgActReDeployment entity) {
        return jdbi.withExtension(FgActReDeploymentDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActReDeployment(String id) {
        jdbi.useExtension(FgActReDeploymentDao.class, dao -> dao.delete(id));
    }
}
