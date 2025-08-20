package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTdTenureDao;
import com.bsit.codegeneration.record.FgTdTenure;

public class FgTdTenureRepository {

    private final Jdbi jdbi;

    public FgTdTenureRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTdTenure> getAllFgTdTenures() {
        return jdbi.withExtension(FgTdTenureDao.class, fgtdtenuredao -> fgtdtenuredao.findAll());
    }

    public Optional<FgTdTenure> getFgTdTenureById(String id) {
        return jdbi.withExtension(FgTdTenureDao.class, dao -> dao.findById(id));
    }

    public String createFgTdTenure(FgTdTenure entity) {
        return jdbi.withExtension(FgTdTenureDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTdTenure(FgTdTenure entity) {
        return jdbi.withExtension(FgTdTenureDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTdTenure(String id) {
        jdbi.useExtension(FgTdTenureDao.class, dao -> dao.delete(id));
    }
}
