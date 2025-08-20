package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgApplicationDao;
import com.bsit.codegeneration.record.FgApplication;

public class FgApplicationRepository {

    private final Jdbi jdbi;

    public FgApplicationRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgApplication> getAllFgApplications() {
        return jdbi.withExtension(FgApplicationDao.class, fgapplicationdao -> fgapplicationdao.findAll());
    }

    public Optional<FgApplication> getFgApplicationById(String id) {
        return jdbi.withExtension(FgApplicationDao.class, dao -> dao.findById(id));
    }

    public String createFgApplication(FgApplication entity) {
        return jdbi.withExtension(FgApplicationDao.class, dao -> dao.insert(entity));
    }

    public int updateFgApplication(FgApplication entity) {
        return jdbi.withExtension(FgApplicationDao.class, dao -> dao.update(entity));
    }

    public void deleteFgApplication(String id) {
        jdbi.useExtension(FgApplicationDao.class, dao -> dao.delete(id));
    }
}
