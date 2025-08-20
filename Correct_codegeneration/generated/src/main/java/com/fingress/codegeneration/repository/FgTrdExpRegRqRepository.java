package com.bsit.codegeneration.repository;

import org.jdbi.v3.core.Jdbi;
import java.util.*;
import com.bsit.codegeneration.dao.FgTrdExpRegRqDao;
import com.bsit.codegeneration.record.FgTrdExpRegRq;

public class FgTrdExpRegRqRepository {

    private final Jdbi jdbi;

    public FgTrdExpRegRqRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<FgTrdExpRegRq> getAllFgTrdExpRegRqs() {
        return jdbi.withExtension(FgTrdExpRegRqDao.class, fgtrdexpregrqdao -> fgtrdexpregrqdao.findAll());
    }

    public Optional<FgTrdExpRegRq> getFgTrdExpRegRqById(String id) {
        return jdbi.withExtension(FgTrdExpRegRqDao.class, dao -> dao.findById(id));
    }

    public String createFgTrdExpRegRq(FgTrdExpRegRq entity) {
        return jdbi.withExtension(FgTrdExpRegRqDao.class, dao -> dao.insert(entity));
    }

    public int updateFgTrdExpRegRq(FgTrdExpRegRq entity) {
        return jdbi.withExtension(FgTrdExpRegRqDao.class, dao -> dao.update(entity));
    }

    public void deleteFgTrdExpRegRq(String id) {
        jdbi.useExtension(FgTrdExpRegRqDao.class, dao -> dao.delete(id));
    }
}
