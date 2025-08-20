package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.BoeMasterDao;
import com.bsit.codegeneration.record.BoeMaster;

public class BoeMasterRepository {

    private final Jdbi jdbi;

    public BoeMasterRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<BoeMaster> getAllBoeMasters() {
        return jdbi.withExtension(BoeMasterDao.class, boemasterdao -> boemasterdao.findAll());
    }

    public Optional<BoeMaster> getBoeMasterById(String id) {
        return jdbi.withExtension(BoeMasterDao.class, dao -> dao.findById(id));
    }

    public String createBoeMaster(BoeMaster entity) {
        return jdbi.withExtension(BoeMasterDao.class, dao -> dao.insert(entity));
    }

    public int updateBoeMaster(BoeMaster entity) {
        return jdbi.withExtension(BoeMasterDao.class, dao -> dao.update(entity));
    }

    public void deleteBoeMaster(String id) {
        jdbi.useExtension(BoeMasterDao.class, dao -> dao.delete(id));
    }
}
