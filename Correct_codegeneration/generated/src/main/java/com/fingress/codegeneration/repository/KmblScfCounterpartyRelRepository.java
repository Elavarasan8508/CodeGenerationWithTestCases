package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.KmblScfCounterpartyRelDao;
import com.bsit.codegeneration.record.KmblScfCounterpartyRel;

public class KmblScfCounterpartyRelRepository {

    private final Jdbi jdbi;

    public KmblScfCounterpartyRelRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<KmblScfCounterpartyRel> getAllKmblScfCounterpartyRels() {
        return jdbi.withExtension(KmblScfCounterpartyRelDao.class, kmblscfcounterpartyreldao -> kmblscfcounterpartyreldao.findAll());
    }

    public Optional<KmblScfCounterpartyRel> getKmblScfCounterpartyRelById(String id) {
        return jdbi.withExtension(KmblScfCounterpartyRelDao.class, dao -> dao.findById(id));
    }

    public String createKmblScfCounterpartyRel(KmblScfCounterpartyRel entity) {
        return jdbi.withExtension(KmblScfCounterpartyRelDao.class, dao -> dao.insert(entity));
    }

    public int updateKmblScfCounterpartyRel(KmblScfCounterpartyRel entity) {
        return jdbi.withExtension(KmblScfCounterpartyRelDao.class, dao -> dao.update(entity));
    }

    public void deleteKmblScfCounterpartyRel(String id) {
        jdbi.useExtension(KmblScfCounterpartyRelDao.class, dao -> dao.delete(id));
    }
}
