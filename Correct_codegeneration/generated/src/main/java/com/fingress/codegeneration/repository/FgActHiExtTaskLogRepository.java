package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiExtTaskLogDao;
import com.bsit.codegeneration.record.FgActHiExtTaskLog;

public class FgActHiExtTaskLogRepository {

    private final Jdbi jdbi;

    public FgActHiExtTaskLogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiExtTaskLog> getAllFgActHiExtTaskLogs() {
        return jdbi.withExtension(FgActHiExtTaskLogDao.class, fgacthiexttasklogdao -> fgacthiexttasklogdao.findAll());
    }

    public Optional<FgActHiExtTaskLog> getFgActHiExtTaskLogById(String id) {
        return jdbi.withExtension(FgActHiExtTaskLogDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiExtTaskLog(FgActHiExtTaskLog entity) {
        return jdbi.withExtension(FgActHiExtTaskLogDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiExtTaskLog(FgActHiExtTaskLog entity) {
        return jdbi.withExtension(FgActHiExtTaskLogDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiExtTaskLog(String id) {
        jdbi.useExtension(FgActHiExtTaskLogDao.class, dao -> dao.delete(id));
    }
}
