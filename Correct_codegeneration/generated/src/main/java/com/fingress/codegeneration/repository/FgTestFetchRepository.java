package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTestFetchDao;
import com.bsit.codegeneration.record.FgTestFetch;

public class FgTestFetchRepository {

    private final Jdbi jdbi;

    public FgTestFetchRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTestFetch> getAllFgTestFetchs() {
        return jdbi.withExtension(FgTestFetchDao.class, fgtestfetchdao -> fgtestfetchdao.findAll());
    }

    public Optional<FgTestFetch> getFgTestFetchById(String id) {
        return jdbi.withExtension(FgTestFetchDao.class, dao -> dao.findById(id));
    }

    public String createFgTestFetch(FgTestFetch entity) {
        return jdbi.withExtension(FgTestFetchDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTestFetch(FgTestFetch entity) {
        return jdbi.withExtension(FgTestFetchDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTestFetch(String id) {
        jdbi.useExtension(FgTestFetchDao.class, dao -> dao.delete(id));
    }
}
