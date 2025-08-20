package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzSimpropTriggersDao;
import com.bsit.codegeneration.record.QrtzSimpropTriggers;

public class QrtzSimpropTriggersRepository {

    private final Jdbi jdbi;

    public QrtzSimpropTriggersRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzSimpropTriggers> getAllQrtzSimpropTriggerss() {
        return jdbi.withExtension(QrtzSimpropTriggersDao.class, qrtzsimproptriggersdao -> qrtzsimproptriggersdao.findAll());
    }

    public Optional<QrtzSimpropTriggers> getQrtzSimpropTriggersById(String id) {
        return jdbi.withExtension(QrtzSimpropTriggersDao.class, dao -> dao.findById(id));
    }

    public String createQrtzSimpropTriggers(QrtzSimpropTriggers entity) {
        return jdbi.withExtension(QrtzSimpropTriggersDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzSimpropTriggers(QrtzSimpropTriggers entity) {
        return jdbi.withExtension(QrtzSimpropTriggersDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzSimpropTriggers(String id) {
        jdbi.useExtension(QrtzSimpropTriggersDao.class, dao -> dao.delete(id));
    }
}
