package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.DatabasechangeloglockDao;
import com.bsit.codegeneration.record.Databasechangeloglock;

public class DatabasechangeloglockRepository {

    private final Jdbi jdbi;

    public DatabasechangeloglockRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Databasechangeloglock> getAllDatabasechangeloglocks() {
        return jdbi.withExtension(DatabasechangeloglockDao.class, databasechangeloglockdao -> databasechangeloglockdao.findAll());
    }

    public Optional<Databasechangeloglock> getDatabasechangeloglockById(String id) {
        return jdbi.withExtension(DatabasechangeloglockDao.class, dao -> dao.findById(id));
    }

    public String createDatabasechangeloglock(Databasechangeloglock entity) {
        return jdbi.withExtension(DatabasechangeloglockDao.class, dao -> dao.insert(entity));
    }

    public int updateDatabasechangeloglock(Databasechangeloglock entity) {
        return jdbi.withExtension(DatabasechangeloglockDao.class, dao -> dao.update(entity));
    }

    public void deleteDatabasechangeloglock(String id) {
        jdbi.useExtension(DatabasechangeloglockDao.class, dao -> dao.delete(id));
    }
}
