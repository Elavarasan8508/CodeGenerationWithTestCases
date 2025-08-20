package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzCronTriggersDao;
import com.bsit.codegeneration.record.QrtzCronTriggers;

public class QrtzCronTriggersRepository {

    private final Jdbi jdbi;

    public QrtzCronTriggersRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzCronTriggers> getAllQrtzCronTriggerss() {
        return jdbi.withExtension(QrtzCronTriggersDao.class, qrtzcrontriggersdao -> qrtzcrontriggersdao.findAll());
    }

    public Optional<QrtzCronTriggers> getQrtzCronTriggersById(String id) {
        return jdbi.withExtension(QrtzCronTriggersDao.class, dao -> dao.findById(id));
    }

    public String createQrtzCronTriggers(QrtzCronTriggers entity) {
        return jdbi.withExtension(QrtzCronTriggersDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzCronTriggers(QrtzCronTriggers entity) {
        return jdbi.withExtension(QrtzCronTriggersDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzCronTriggers(String id) {
        jdbi.useExtension(QrtzCronTriggersDao.class, dao -> dao.delete(id));
    }
}
