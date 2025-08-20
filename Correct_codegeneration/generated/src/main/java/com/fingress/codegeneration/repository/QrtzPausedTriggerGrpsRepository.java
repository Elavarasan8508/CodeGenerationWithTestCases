package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzPausedTriggerGrpsDao;
import com.bsit.codegeneration.record.QrtzPausedTriggerGrps;

public class QrtzPausedTriggerGrpsRepository {

    private final Jdbi jdbi;

    public QrtzPausedTriggerGrpsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzPausedTriggerGrps> getAllQrtzPausedTriggerGrpss() {
        return jdbi.withExtension(QrtzPausedTriggerGrpsDao.class, qrtzpausedtriggergrpsdao -> qrtzpausedtriggergrpsdao.findAll());
    }

    public Optional<QrtzPausedTriggerGrps> getQrtzPausedTriggerGrpsById(String id) {
        return jdbi.withExtension(QrtzPausedTriggerGrpsDao.class, dao -> dao.findById(id));
    }

    public String createQrtzPausedTriggerGrps(QrtzPausedTriggerGrps entity) {
        return jdbi.withExtension(QrtzPausedTriggerGrpsDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzPausedTriggerGrps(QrtzPausedTriggerGrps entity) {
        return jdbi.withExtension(QrtzPausedTriggerGrpsDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzPausedTriggerGrps(String id) {
        jdbi.useExtension(QrtzPausedTriggerGrpsDao.class, dao -> dao.delete(id));
    }
}
