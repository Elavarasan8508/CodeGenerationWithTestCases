package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FingressProjectDao;
import com.bsit.codegeneration.record.FingressProject;

public class FingressProjectRepository {

    private final Jdbi jdbi;

    public FingressProjectRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FingressProject> getAllFingressProjects() {
        return jdbi.withExtension(FingressProjectDao.class, fingressprojectdao -> fingressprojectdao.findAll());
    }

    public Optional<FingressProject> getFingressProjectById(Long id) {
        return jdbi.withExtension(FingressProjectDao.class, dao -> dao.findById(id));
    }

    public Long createFingressProject(FingressProject entity) {
        return jdbi.withExtension(FingressProjectDao.class, dao -> dao.insert(entity));
    }

    public int updateFingressProject(FingressProject entity) {
        return jdbi.withExtension(FingressProjectDao.class, dao -> dao.update(entity));
    }

    public void deleteFingressProject(Long id) {
        jdbi.useExtension(FingressProjectDao.class, dao -> dao.delete(id));
    }
}
