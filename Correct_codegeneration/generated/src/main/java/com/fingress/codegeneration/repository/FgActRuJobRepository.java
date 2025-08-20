package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgActRuJobDao;
import com.bsit.codegeneration.record.FgActRuJob;

public class FgActRuJobRepository {

    private final Jdbi jdbi;

    public FgActRuJobRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgActRuJob> getAllFgActRuJobs() {
        return jdbi.withExtension(FgActRuJobDao.class, fgactrujobdao -> fgactrujobdao.findAll());
    }

    public Optional<FgActRuJob> getFgActRuJobById(String id) {
        return jdbi.withExtension(FgActRuJobDao.class, dao -> dao.findById(id));
    }

    public String createFgActRuJob(FgActRuJob entity) {
        return jdbi.withExtension(FgActRuJobDao.class, dao -> dao.insert(entity));
    }

    public int updateFgActRuJob(FgActRuJob entity) {
        return jdbi.withExtension(FgActRuJobDao.class, dao -> dao.update(entity));
    }

    public void deleteFgActRuJob(String id) {
        jdbi.useExtension(FgActRuJobDao.class, dao -> dao.delete(id));
    }
}
