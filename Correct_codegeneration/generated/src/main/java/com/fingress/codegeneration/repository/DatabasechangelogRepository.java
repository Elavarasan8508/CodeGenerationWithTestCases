package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.DatabasechangelogDao;
import com.bsit.codegeneration.record.Databasechangelog;

public class DatabasechangelogRepository {

    private final Jdbi jdbi;

    public DatabasechangelogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Databasechangelog> getAllDatabasechangelogs() {
        return jdbi.withExtension(DatabasechangelogDao.class, databasechangelogdao -> databasechangelogdao.findAll());
    }

    public Optional<Databasechangelog> getDatabasechangelogById(String id) {
        return jdbi.withExtension(DatabasechangelogDao.class, dao -> dao.findById(id));
    }

    public String createDatabasechangelog(Databasechangelog entity) {
        return jdbi.withExtension(DatabasechangelogDao.class, dao -> dao.insert(entity));
    }

    public int updateDatabasechangelog(Databasechangelog entity) {
        return jdbi.withExtension(DatabasechangelogDao.class, dao -> dao.update(entity));
    }

    public void deleteDatabasechangelog(String id) {
        jdbi.useExtension(DatabasechangelogDao.class, dao -> dao.delete(id));
    }
}
