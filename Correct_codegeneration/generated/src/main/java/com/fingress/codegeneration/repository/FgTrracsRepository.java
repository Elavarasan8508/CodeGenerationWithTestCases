package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrracsDao;
import com.bsit.codegeneration.record.FgTrracs;

public class FgTrracsRepository {

    private final Jdbi jdbi;

    public FgTrracsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrracs> getAllFgTrracss() {
        return jdbi.withExtension(FgTrracsDao.class, fgtrracsdao -> fgtrracsdao.findAll());
    }

    public Optional<FgTrracs> getFgTrracsById(String id) {
        return jdbi.withExtension(FgTrracsDao.class, dao -> dao.findById(id));
    }

    public String createFgTrracs(FgTrracs entity) {
        return jdbi.withExtension(FgTrracsDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrracs(FgTrracs entity) {
        return jdbi.withExtension(FgTrracsDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrracs(String id) {
        jdbi.useExtension(FgTrracsDao.class, dao -> dao.delete(id));
    }
}
