package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.KmblScfCounterpartyDao;
import com.bsit.codegeneration.record.KmblScfCounterparty;

public class KmblScfCounterpartyRepository {

    private final Jdbi jdbi;

    public KmblScfCounterpartyRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<KmblScfCounterparty> getAllKmblScfCounterpartys() {
        return jdbi.withExtension(KmblScfCounterpartyDao.class, kmblscfcounterpartydao -> kmblscfcounterpartydao.findAll());
    }

    public Optional<KmblScfCounterparty> getKmblScfCounterpartyById(Long id) {
        return jdbi.withExtension(KmblScfCounterpartyDao.class, dao -> dao.findById(id));
    }

    public Long createKmblScfCounterparty(KmblScfCounterparty entity) {
        return jdbi.withExtension(KmblScfCounterpartyDao.class, dao -> dao.insert(entity));
    }

    public int updateKmblScfCounterparty(KmblScfCounterparty entity) {
        return jdbi.withExtension(KmblScfCounterpartyDao.class, dao -> dao.update(entity));
    }

    public void deleteKmblScfCounterparty(Long id) {
        jdbi.useExtension(KmblScfCounterpartyDao.class, dao -> dao.delete(id));
    }
}
