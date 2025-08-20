package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdFtDao;
import com.bsit.codegeneration.record.FgTrdFt;

public class FgTrdFtRepository {

    private final Jdbi jdbi;

    public FgTrdFtRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdFt> getAllFgTrdFts() {
        return jdbi.withExtension(FgTrdFtDao.class, fgtrdftdao -> fgtrdftdao.findAll());
    }

    public Optional<FgTrdFt> getFgTrdFtById(String id) {
        return jdbi.withExtension(FgTrdFtDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdFt(FgTrdFt entity) {
        return jdbi.withExtension(FgTrdFtDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdFt(FgTrdFt entity) {
        return jdbi.withExtension(FgTrdFtDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdFt(String id) {
        jdbi.useExtension(FgTrdFtDao.class, dao -> dao.delete(id));
    }
}
