package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuMeterLogDao;
import com.bsit.codegeneration.record.FgActRuMeterLog;

public class FgActRuMeterLogRepository {

    private final Jdbi jdbi;

    public FgActRuMeterLogRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuMeterLog> getAllFgActRuMeterLogs() {
        return jdbi.withExtension(FgActRuMeterLogDao.class, fgactrumeterlogdao -> fgactrumeterlogdao.findAll());
    }

    public Optional<FgActRuMeterLog> getFgActRuMeterLogById(Long id) {
        return jdbi.withExtension(FgActRuMeterLogDao.class, dao -> dao.findById(id));
    }

    public Long createFgActRuMeterLog(FgActRuMeterLog entity) {
        return jdbi.withExtension(FgActRuMeterLogDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuMeterLog(FgActRuMeterLog entity) {
        return jdbi.withExtension(FgActRuMeterLogDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuMeterLog(Long id) {
        jdbi.useExtension(FgActRuMeterLogDao.class, dao -> dao.delete(id));
    }
}
