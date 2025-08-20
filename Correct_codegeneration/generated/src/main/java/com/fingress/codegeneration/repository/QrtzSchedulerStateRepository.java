package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzSchedulerStateDao;
import com.bsit.codegeneration.record.QrtzSchedulerState;

public class QrtzSchedulerStateRepository {

    private final Jdbi jdbi;

    public QrtzSchedulerStateRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzSchedulerState> getAllQrtzSchedulerStates() {
        return jdbi.withExtension(QrtzSchedulerStateDao.class, qrtzschedulerstatedao -> qrtzschedulerstatedao.findAll());
    }

    public Optional<QrtzSchedulerState> getQrtzSchedulerStateById(Long id) {
        return jdbi.withExtension(QrtzSchedulerStateDao.class, dao -> dao.findById(id));
    }

    public Long createQrtzSchedulerState(QrtzSchedulerState entity) {
        return jdbi.withExtension(QrtzSchedulerStateDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzSchedulerState(QrtzSchedulerState entity) {
        return jdbi.withExtension(QrtzSchedulerStateDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzSchedulerState(Long id) {
        jdbi.useExtension(QrtzSchedulerStateDao.class, dao -> dao.delete(id));
    }
}
