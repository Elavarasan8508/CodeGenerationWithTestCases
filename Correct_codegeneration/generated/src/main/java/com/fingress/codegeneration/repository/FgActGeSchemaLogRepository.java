package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActGeSchemaLogDao;
import com.bsit.codegeneration.record.FgActGeSchemaLog;

public class FgActGeSchemaLogRepository {

    private final Jdbi jdbi;

    public FgActGeSchemaLogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActGeSchemaLog> getAllFgActGeSchemaLogs() {
        return jdbi.withExtension(FgActGeSchemaLogDao.class, fgactgeschemalogdao -> fgactgeschemalogdao.findAll());
    }

    public Optional<FgActGeSchemaLog> getFgActGeSchemaLogById(String id) {
        return jdbi.withExtension(FgActGeSchemaLogDao.class, dao -> dao.findById(id));
    }

    public String createFgActGeSchemaLog(FgActGeSchemaLog entity) {
        return jdbi.withExtension(FgActGeSchemaLogDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActGeSchemaLog(FgActGeSchemaLog entity) {
        return jdbi.withExtension(FgActGeSchemaLogDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActGeSchemaLog(String id) {
        jdbi.useExtension(FgActGeSchemaLogDao.class, dao -> dao.delete(id));
    }
}
