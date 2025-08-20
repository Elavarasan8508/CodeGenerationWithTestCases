package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgProjectsDao;
import com.bsit.codegeneration.record.FgProjects;

public class FgProjectsRepository {

    private final Jdbi jdbi;

    public FgProjectsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgProjects> getAllFgProjectss() {
        return jdbi.withExtension(FgProjectsDao.class, fgprojectsdao -> fgprojectsdao.findAll());
    }

    public Optional<FgProjects> getFgProjectsById(String id) {
        return jdbi.withExtension(FgProjectsDao.class, dao -> dao.findById(id));
    }

    public String createFgProjects(FgProjects entity) {
        return jdbi.withExtension(FgProjectsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgProjects(FgProjects entity) {
        return jdbi.withExtension(FgProjectsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgProjects(String id) {
        jdbi.useExtension(FgProjectsDao.class, dao -> dao.delete(id));
    }
}
