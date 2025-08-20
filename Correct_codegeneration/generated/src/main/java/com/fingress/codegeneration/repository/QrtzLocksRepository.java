package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzLocksDao;
import com.bsit.codegeneration.record.QrtzLocks;

public class QrtzLocksRepository {

    private final Jdbi jdbi;

    public QrtzLocksRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzLocks> getAllQrtzLockss() {
        return jdbi.withExtension(QrtzLocksDao.class, qrtzlocksdao -> qrtzlocksdao.findAll());
    }

    public Optional<QrtzLocks> getQrtzLocksById(String id) {
        return jdbi.withExtension(QrtzLocksDao.class, dao -> dao.findById(id));
    }

    public String createQrtzLocks(QrtzLocks entity) {
        return jdbi.withExtension(QrtzLocksDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzLocks(QrtzLocks entity) {
        return jdbi.withExtension(QrtzLocksDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzLocks(String id) {
        jdbi.useExtension(QrtzLocksDao.class, dao -> dao.delete(id));
    }
}
