package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzTriggersDao;
import com.bsit.codegeneration.record.QrtzTriggers;

public class QrtzTriggersRepository {

    private final Jdbi jdbi;

    public QrtzTriggersRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzTriggers> getAllQrtzTriggerss() {
        return jdbi.withExtension(QrtzTriggersDao.class, qrtztriggersdao -> qrtztriggersdao.findAll());
    }

    public Optional<QrtzTriggers> getQrtzTriggersById(String id) {
        return jdbi.withExtension(QrtzTriggersDao.class, dao -> dao.findById(id));
    }

    public String createQrtzTriggers(QrtzTriggers entity) {
        return jdbi.withExtension(QrtzTriggersDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzTriggers(QrtzTriggers entity) {
        return jdbi.withExtension(QrtzTriggersDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzTriggers(String id) {
        jdbi.useExtension(QrtzTriggersDao.class, dao -> dao.delete(id));
    }
}
