package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgMandmlDao;
import com.bsit.codegeneration.record.FgMandml;

public class FgMandmlRepository {

    private final Jdbi jdbi;

    public FgMandmlRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgMandml> getAllFgMandmls() {
        return jdbi.withExtension(FgMandmlDao.class, fgmandmldao -> fgmandmldao.findAll());
    }

    public Optional<FgMandml> getFgMandmlById(String id) {
        return jdbi.withExtension(FgMandmlDao.class, dao -> dao.findById(id));
    }

    public String createFgMandml(FgMandml entity) {
        return jdbi.withExtension(FgMandmlDao.class, dao -> dao.insert(entity));
    }

    public int updateFgMandml(FgMandml entity) {
        return jdbi.withExtension(FgMandmlDao.class, dao -> dao.update(entity));
    }

    public void deleteFgMandml(String id) {
        jdbi.useExtension(FgMandmlDao.class, dao -> dao.delete(id));
    }
}
