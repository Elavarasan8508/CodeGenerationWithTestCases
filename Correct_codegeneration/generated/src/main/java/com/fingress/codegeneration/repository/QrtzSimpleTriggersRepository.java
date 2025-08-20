package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzSimpleTriggersDao;
import com.bsit.codegeneration.record.QrtzSimpleTriggers;

public class QrtzSimpleTriggersRepository {

    private final Jdbi jdbi;

    public QrtzSimpleTriggersRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzSimpleTriggers> getAllQrtzSimpleTriggerss() {
        return jdbi.withExtension(QrtzSimpleTriggersDao.class, qrtzsimpletriggersdao -> qrtzsimpletriggersdao.findAll());
    }

    public Optional<QrtzSimpleTriggers> getQrtzSimpleTriggersById(Long id) {
        return jdbi.withExtension(QrtzSimpleTriggersDao.class, dao -> dao.findById(id));
    }

    public Long createQrtzSimpleTriggers(QrtzSimpleTriggers entity) {
        return jdbi.withExtension(QrtzSimpleTriggersDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzSimpleTriggers(QrtzSimpleTriggers entity) {
        return jdbi.withExtension(QrtzSimpleTriggersDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzSimpleTriggers(Long id) {
        jdbi.useExtension(QrtzSimpleTriggersDao.class, dao -> dao.delete(id));
    }
}
