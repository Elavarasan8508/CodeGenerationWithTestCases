package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.QrtzJobDetailsDao;
import com.bsit.codegeneration.record.QrtzJobDetails;

public class QrtzJobDetailsRepository {

    private final Jdbi jdbi;

    public QrtzJobDetailsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<QrtzJobDetails> getAllQrtzJobDetailss() {
        return jdbi.withExtension(QrtzJobDetailsDao.class, qrtzjobdetailsdao -> qrtzjobdetailsdao.findAll());
    }

    public Optional<QrtzJobDetails> getQrtzJobDetailsById(String id) {
        return jdbi.withExtension(QrtzJobDetailsDao.class, dao -> dao.findById(id));
    }

    public String createQrtzJobDetails(QrtzJobDetails entity) {
        return jdbi.withExtension(QrtzJobDetailsDao.class, dao -> dao.insert(entity));
    }

    public int updateQrtzJobDetails(QrtzJobDetails entity) {
        return jdbi.withExtension(QrtzJobDetailsDao.class, dao -> dao.update(entity));
    }

    public void deleteQrtzJobDetails(String id) {
        jdbi.useExtension(QrtzJobDetailsDao.class, dao -> dao.delete(id));
    }
}
