package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.KmblScfFinReqBatchDao;
import com.bsit.codegeneration.record.KmblScfFinReqBatch;

public class KmblScfFinReqBatchRepository {

    private final Jdbi jdbi;

    public KmblScfFinReqBatchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<KmblScfFinReqBatch> getAllKmblScfFinReqBatchs() {
        return jdbi.withExtension(KmblScfFinReqBatchDao.class, kmblscffinreqbatchdao -> kmblscffinreqbatchdao.findAll());
    }

    public Optional<KmblScfFinReqBatch> getKmblScfFinReqBatchById(String id) {
        return jdbi.withExtension(KmblScfFinReqBatchDao.class, dao -> dao.findById(id));
    }

    public String createKmblScfFinReqBatch(KmblScfFinReqBatch entity) {
        return jdbi.withExtension(KmblScfFinReqBatchDao.class, dao -> dao.insert(entity));
    }

    public int updateKmblScfFinReqBatch(KmblScfFinReqBatch entity) {
        return jdbi.withExtension(KmblScfFinReqBatchDao.class, dao -> dao.update(entity));
    }

    public void deleteKmblScfFinReqBatch(String id) {
        jdbi.useExtension(KmblScfFinReqBatchDao.class, dao -> dao.delete(id));
    }
}
