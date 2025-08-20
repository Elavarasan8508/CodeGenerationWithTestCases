package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgSchemaReposDao;
import com.bsit.codegeneration.record.FgSchemaRepos;

public class FgSchemaReposRepository {

    private final Jdbi jdbi;

    public FgSchemaReposRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgSchemaRepos> getAllFgSchemaReposs() {
        return jdbi.withExtension(FgSchemaReposDao.class, fgschemareposdao -> fgschemareposdao.findAll());
    }

    public Optional<FgSchemaRepos> getFgSchemaReposById(String id) {
        return jdbi.withExtension(FgSchemaReposDao.class, dao -> dao.findById(id));
    }

    public String createFgSchemaRepos(FgSchemaRepos entity) {
        return jdbi.withExtension(FgSchemaReposDao.class, dao -> dao.insert(entity));
    }

    public int updateFgSchemaRepos(FgSchemaRepos entity) {
        return jdbi.withExtension(FgSchemaReposDao.class, dao -> dao.update(entity));
    }

    public void deleteFgSchemaRepos(String id) {
        jdbi.useExtension(FgSchemaReposDao.class, dao -> dao.delete(id));
    }
}
