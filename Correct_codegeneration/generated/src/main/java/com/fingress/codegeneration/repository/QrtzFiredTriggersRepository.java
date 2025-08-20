package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzFiredTriggersDao;
import com.bsit.codegeneration.record.QrtzFiredTriggers;

public class QrtzFiredTriggersRepository {

    private final Jdbi jdbi;

    public QrtzFiredTriggersRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzFiredTriggers> getAllQrtzFiredTriggerss() {
        return jdbi.withExtension(QrtzFiredTriggersDao.class, qrtzfiredtriggersdao -> qrtzfiredtriggersdao.findAll());
    }

    public Optional<QrtzFiredTriggers> getQrtzFiredTriggersById(String id) {
        return jdbi.withExtension(QrtzFiredTriggersDao.class, dao -> dao.findById(id));
    }

    public String createQrtzFiredTriggers(QrtzFiredTriggers entity) {
        return jdbi.withExtension(QrtzFiredTriggersDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzFiredTriggers(QrtzFiredTriggers entity) {
        return jdbi.withExtension(QrtzFiredTriggersDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzFiredTriggers(String id) {
        jdbi.useExtension(QrtzFiredTriggersDao.class, dao -> dao.delete(id));
    }
}
