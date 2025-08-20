package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiJobLogDao;
import com.bsit.codegeneration.record.FgActHiJobLog;

public class FgActHiJobLogRepository {

    private final Jdbi jdbi;

    public FgActHiJobLogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiJobLog> getAllFgActHiJobLogs() {
        return jdbi.withExtension(FgActHiJobLogDao.class, fgacthijoblogdao -> fgacthijoblogdao.findAll());
    }

    public Optional<FgActHiJobLog> getFgActHiJobLogById(String id) {
        return jdbi.withExtension(FgActHiJobLogDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiJobLog(FgActHiJobLog entity) {
        return jdbi.withExtension(FgActHiJobLogDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiJobLog(FgActHiJobLog entity) {
        return jdbi.withExtension(FgActHiJobLogDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiJobLog(String id) {
        jdbi.useExtension(FgActHiJobLogDao.class, dao -> dao.delete(id));
    }
}
