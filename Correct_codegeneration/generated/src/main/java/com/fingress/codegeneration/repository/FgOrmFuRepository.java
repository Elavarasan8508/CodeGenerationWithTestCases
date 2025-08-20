package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgOrmFuDao;
import com.bsit.codegeneration.record.FgOrmFu;

public class FgOrmFuRepository {

    private final Jdbi jdbi;

    public FgOrmFuRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgOrmFu> getAllFgOrmFus() {
        return jdbi.withExtension(FgOrmFuDao.class, fgormfudao -> fgormfudao.findAll());
    }

    public Optional<FgOrmFu> getFgOrmFuById(String id) {
        return jdbi.withExtension(FgOrmFuDao.class, dao -> dao.findById(id));
    }

    public String createFgOrmFu(FgOrmFu entity) {
        return jdbi.withExtension(FgOrmFuDao.class, dao -> dao.insert(entity));
    }

    public int updateFgOrmFu(FgOrmFu entity) {
        return jdbi.withExtension(FgOrmFuDao.class, dao -> dao.update(entity));
    }

    public void deleteFgOrmFu(String id) {
        jdbi.useExtension(FgOrmFuDao.class, dao -> dao.delete(id));
    }
}
