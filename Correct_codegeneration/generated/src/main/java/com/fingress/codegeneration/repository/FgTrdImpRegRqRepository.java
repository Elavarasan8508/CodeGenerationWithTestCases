package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdImpRegRqDao;
import com.bsit.codegeneration.record.FgTrdImpRegRq;

public class FgTrdImpRegRqRepository {

    private final Jdbi jdbi;

    public FgTrdImpRegRqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdImpRegRq> getAllFgTrdImpRegRqs() {
        return jdbi.withExtension(FgTrdImpRegRqDao.class, fgtrdimpregrqdao -> fgtrdimpregrqdao.findAll());
    }

    public Optional<FgTrdImpRegRq> getFgTrdImpRegRqById(String id) {
        return jdbi.withExtension(FgTrdImpRegRqDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdImpRegRq(FgTrdImpRegRq entity) {
        return jdbi.withExtension(FgTrdImpRegRqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdImpRegRq(FgTrdImpRegRq entity) {
        return jdbi.withExtension(FgTrdImpRegRqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdImpRegRq(String id) {
        jdbi.useExtension(FgTrdImpRegRqDao.class, dao -> dao.delete(id));
    }
}
