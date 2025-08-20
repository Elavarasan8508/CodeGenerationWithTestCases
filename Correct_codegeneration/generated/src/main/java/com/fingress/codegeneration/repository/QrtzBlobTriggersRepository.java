package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzBlobTriggersDao;
import com.bsit.codegeneration.record.QrtzBlobTriggers;

public class QrtzBlobTriggersRepository {

    private final Jdbi jdbi;

    public QrtzBlobTriggersRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzBlobTriggers> getAllQrtzBlobTriggerss() {
        return jdbi.withExtension(QrtzBlobTriggersDao.class, qrtzblobtriggersdao -> qrtzblobtriggersdao.findAll());
    }

    public Optional<QrtzBlobTriggers> getQrtzBlobTriggersById(String id) {
        return jdbi.withExtension(QrtzBlobTriggersDao.class, dao -> dao.findById(id));
    }

    public String createQrtzBlobTriggers(QrtzBlobTriggers entity) {
        return jdbi.withExtension(QrtzBlobTriggersDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzBlobTriggers(QrtzBlobTriggers entity) {
        return jdbi.withExtension(QrtzBlobTriggersDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzBlobTriggers(String id) {
        jdbi.useExtension(QrtzBlobTriggersDao.class, dao -> dao.delete(id));
    }
}
