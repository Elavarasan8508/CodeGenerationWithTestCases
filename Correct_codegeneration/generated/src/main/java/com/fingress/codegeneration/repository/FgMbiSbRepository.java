package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMbiSbDao;
import com.bsit.codegeneration.record.FgMbiSb;

public class FgMbiSbRepository {

    private final Jdbi jdbi;

    public FgMbiSbRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMbiSb> getAllFgMbiSbs() {
        return jdbi.withExtension(FgMbiSbDao.class, fgmbisbdao -> fgmbisbdao.findAll());
    }

    public Optional<FgMbiSb> getFgMbiSbById(java.time.LocalDateTime id) {
        return jdbi.withExtension(FgMbiSbDao.class, dao -> dao.findById(id));
    }

    public java.time.LocalDateTime createFgMbiSb(FgMbiSb entity) {
        return jdbi.withExtension(FgMbiSbDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMbiSb(FgMbiSb entity) {
        return jdbi.withExtension(FgMbiSbDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMbiSb(java.time.LocalDateTime id) {
        jdbi.useExtension(FgMbiSbDao.class, dao -> dao.delete(id));
    }
}
