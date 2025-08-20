package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActHiOpLogDao;
import com.bsit.codegeneration.record.FgActHiOpLog;

public class FgActHiOpLogRepository {

    private final Jdbi jdbi;

    public FgActHiOpLogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActHiOpLog> getAllFgActHiOpLogs() {
        return jdbi.withExtension(FgActHiOpLogDao.class, fgacthioplogdao -> fgacthioplogdao.findAll());
    }

    public Optional<FgActHiOpLog> getFgActHiOpLogById(String id) {
        return jdbi.withExtension(FgActHiOpLogDao.class, dao -> dao.findById(id));
    }

    public String createFgActHiOpLog(FgActHiOpLog entity) {
        return jdbi.withExtension(FgActHiOpLogDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActHiOpLog(FgActHiOpLog entity) {
        return jdbi.withExtension(FgActHiOpLogDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActHiOpLog(String id) {
        jdbi.useExtension(FgActHiOpLogDao.class, dao -> dao.delete(id));
    }
}
