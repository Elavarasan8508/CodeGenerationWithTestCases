package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.DoSmartCollectDao;
import com.bsit.codegeneration.record.DoSmartCollect;

public class DoSmartCollectRepository {

    private final Jdbi jdbi;

    public DoSmartCollectRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<DoSmartCollect> getAllDoSmartCollects() {
        return jdbi.withExtension(DoSmartCollectDao.class, dosmartcollectdao -> dosmartcollectdao.findAll());
    }

    public Optional<DoSmartCollect> getDoSmartCollectById(String id) {
        return jdbi.withExtension(DoSmartCollectDao.class, dao -> dao.findById(id));
    }

    public String createDoSmartCollect(DoSmartCollect entity) {
        return jdbi.withExtension(DoSmartCollectDao.class, dao -> dao.insert(entity));
    }

    public int updateDoSmartCollect(DoSmartCollect entity) {
        return jdbi.withExtension(DoSmartCollectDao.class, dao -> dao.update(entity));
    }

    public void deleteDoSmartCollect(String id) {
        jdbi.useExtension(DoSmartCollectDao.class, dao -> dao.delete(id));
    }
}
