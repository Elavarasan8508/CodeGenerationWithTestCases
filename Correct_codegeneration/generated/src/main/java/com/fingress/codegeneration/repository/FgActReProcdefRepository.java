package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActReProcdefDao;
import com.bsit.codegeneration.record.FgActReProcdef;

public class FgActReProcdefRepository {

    private final Jdbi jdbi;

    public FgActReProcdefRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActReProcdef> getAllFgActReProcdefs() {
        return jdbi.withExtension(FgActReProcdefDao.class, fgactreprocdefdao -> fgactreprocdefdao.findAll());
    }

    public Optional<FgActReProcdef> getFgActReProcdefById(Long id) {
        return jdbi.withExtension(FgActReProcdefDao.class, dao -> dao.findById(id));
    }

    public Long createFgActReProcdef(FgActReProcdef entity) {
        return jdbi.withExtension(FgActReProcdefDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActReProcdef(FgActReProcdef entity) {
        return jdbi.withExtension(FgActReProcdefDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActReProcdef(Long id) {
        jdbi.useExtension(FgActReProcdefDao.class, dao -> dao.delete(id));
    }
}
